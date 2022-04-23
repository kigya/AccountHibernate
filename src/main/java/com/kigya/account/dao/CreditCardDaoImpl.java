package com.kigya.account.dao;

import com.kigya.account.entity.CreditCard;
import com.kigya.account.exception.RepositoryException;
import com.kigya.account.utils.HibernateUtil;
import lombok.SneakyThrows;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Transient;
import java.util.List;

public class CreditCardDaoImpl implements CreditCardDao {

    @Override
    @SneakyThrows
    @Transient
    public List<CreditCard> findAll() {
        Transaction tx = null;
        List<CreditCard> creditCards;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            try {
                tx = session.beginTransaction();
                creditCards = session.createQuery("FROM CreditCard").list();
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) {
                    tx.rollback();
                }
                throw new RepositoryException(e, "Transaction error!");
            } catch (Exception e) {
                throw new RepositoryException(e, "Credit card repository error!");
            }
        }
        return creditCards;
    }

    @Override
    @SneakyThrows
    public void addItem(CreditCard creditCard) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(creditCard);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new RepositoryException(e, "Transaction error!");
        } catch (Exception e) {
            throw new RepositoryException(e, "Credit card repository error!");
        }
    }


    @SneakyThrows
    @Transient
    @Override
    public CreditCard getById(int id) {
        Transaction tx = null;
        CreditCard creditCard;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            try {
                tx = session.beginTransaction();
                creditCard = session.get(CreditCard.class, id);
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) {
                    tx.rollback();
                }
                throw new RepositoryException(e, "Transaction error!");
            } catch (Exception e) {
                throw new RepositoryException(e, "Credit card repository error!");
            }
        }
        return creditCard;
    }

    @SneakyThrows
    @Transient
    @Override
    public List<CreditCard> getByAccountId(int idRequired) {
        Transaction tx = null;
        List creditCards;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            try {
                tx = session.beginTransaction();
                creditCards = session
                        .createQuery("FROM CreditCard WHERE accountId = :idRequired")
                        .setParameter("idRequired", idRequired).list();
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) {
                    tx.rollback();
                }
                throw new RepositoryException(e, "Transaction error!");
            } catch (Exception e) {
                throw new RepositoryException(e, "Credit card repository error!");
            }
        }
        return creditCards;
    }
}

