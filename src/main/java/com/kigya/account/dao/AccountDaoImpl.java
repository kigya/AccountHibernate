package com.kigya.account.dao;

import com.kigya.account.entity.Account;
import com.kigya.account.exception.RepositoryException;
import com.kigya.account.utils.HibernateUtil;
import lombok.SneakyThrows;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;

import javax.persistence.Transient;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AccountDaoImpl implements AccountDao {

    private static final String TRANSACTION_ERROR =
            "Transaction error!";
    private static final String ACCOUNT_REPOSITORY_ERROR =
            "Account repository error!";

    @Override
    @SneakyThrows
    @Transient
    @SuppressWarnings({"unchecked"})
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
                throw new RepositoryException(e, TRANSACTION_ERROR);
            } catch (Exception e) {
                throw new RepositoryException(e, ACCOUNT_REPOSITORY_ERROR);
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
            throw new RepositoryException(e, TRANSACTION_ERROR);
        } catch (Exception e) {
            throw new RepositoryException(e, ACCOUNT_REPOSITORY_ERROR);
        }
    }

    @Override
    @SneakyThrows
    @Transient
    @SuppressWarnings({"unchecked", "rawtypes"})
    public Set<Integer> findAllId() {
        Transaction tx = null;
        List idList;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            try {
                tx = session.beginTransaction();
                idList = Collections.unmodifiableList(session
                        .createNativeQuery("SELECT id FROM Account")
                        .addScalar("id", StandardBasicTypes.INTEGER)
                        .list());
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) {
                    tx.rollback();
                }
                throw new RepositoryException(e, TRANSACTION_ERROR);
            } catch (Exception e) {
                throw new RepositoryException(e, ACCOUNT_REPOSITORY_ERROR);
            }
        }
        return new TreeSet<Integer>(idList);
    }

    @SneakyThrows
    @Transient
    @Override
    public Account getById(int idRequired) {
        Transaction tx = null;
        Account account;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            try {
                tx = session.beginTransaction();
                account = session.get(Account.class, idRequired);
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) {
                    tx.rollback();
                }
                throw new RepositoryException(e, TRANSACTION_ERROR);
            } catch (Exception e) {
                throw new RepositoryException(e, ACCOUNT_REPOSITORY_ERROR);
            }
        }
        return account;
    }

}
