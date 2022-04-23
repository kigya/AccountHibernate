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
import java.util.*;

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

    @Override
    @SneakyThrows
    @Transient
    @SuppressWarnings({"unchecked"})
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
                throw new RepositoryException(e, "Initialization transaction error!");
            } catch (Exception e) {
                throw new RepositoryException(e, "Account repository error!");
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
                throw new RepositoryException(e, "Initialization transaction error!");
            } catch (Exception e) {
                throw new RepositoryException(e, "Account repository error!");
            }
        }
        return account;
    }
}
