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

    private static final String TRANSACTION_ERROR =
            "Transaction error!";
    private static final String CREDIT_CARD_REPOSITORY_ERROR =
            "Credit Card repository error!";

    @Override
    @SneakyThrows
    @Transient
    @SuppressWarnings({"unchecked"})
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
                throw new RepositoryException(e, TRANSACTION_ERROR);
            } catch (Exception e) {
                throw new RepositoryException(e, CREDIT_CARD_REPOSITORY_ERROR);
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
            throw new RepositoryException(e, TRANSACTION_ERROR);
        } catch (Exception e) {
            throw new RepositoryException(e, CREDIT_CARD_REPOSITORY_ERROR);
        }
    }

    @SneakyThrows
    @Override
    public void updateItem(CreditCard creditCard) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(creditCard);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new RepositoryException(e, TRANSACTION_ERROR);
        } catch (Exception e) {
            throw new RepositoryException(e, CREDIT_CARD_REPOSITORY_ERROR);
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
                throw new RepositoryException(e, TRANSACTION_ERROR);
            } catch (Exception e) {
                throw new RepositoryException(e, CREDIT_CARD_REPOSITORY_ERROR);
            }
        }
        return creditCard;
    }

    @SneakyThrows
    @Transient
    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
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
                throw new RepositoryException(e, TRANSACTION_ERROR);
            } catch (Exception e) {
                throw new RepositoryException(e, CREDIT_CARD_REPOSITORY_ERROR);
            }
        }
        return creditCards;
    }
}

