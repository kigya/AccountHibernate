package com.kigya.account.dao;

import com.kigya.account.entity.Account;
import com.kigya.account.exception.RepositoryException;
import com.kigya.account.utils.HibernateUtil;
import lombok.SneakyThrows;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Transient;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

    @Override
    @SneakyThrows
    @Transient
    public List<Account> findAll() {
        Transaction tx = null;
        List<Account> accounts;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            try {
                tx = session.beginTransaction();
                accounts = session.createQuery("FROM Account").list();
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) {
                    tx.rollback();
                }
                throw new RepositoryException(e, "Initialization transaction error!");
            } catch (Exception e) {
                throw new RepositoryException(e, "Account repository error!");
            }
        }
        return accounts;
    }

    @Override
    @SneakyThrows
    public void addItem(Account account) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(account);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new RepositoryException(e, "Transaction error!");
        } catch (Exception e) {
            throw new RepositoryException(e, "Account repository error!");
        }
    }
}
