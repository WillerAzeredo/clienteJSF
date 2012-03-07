/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.iff.info.javaweb20112.prettyfaces.utility;

/**** @author Willer */

import br.iff.info.javaweb20112.prettyfaces.models.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

    private static final SessionFactory factory;
    private static final ThreadLocal sessionThread = new ThreadLocal();
    private static final ThreadLocal transactionThread = new ThreadLocal();

    public static Session getSession() {
        Session session = (Session) sessionThread.get();
        if ((session == null) || (!(session.isOpen()))) {
            session = factory.openSession();
            sessionThread.set(session);
        }
        return ((Session) sessionThread.get());
    }

    public static void closeSession() {
        Session session = (Session) sessionThread.get();
        if ((session != null) && (session.isOpen())) {
            sessionThread.set(null);
            session.close();
        }
    }

    public static void beginTransaction() {
        Transaction transaction = getSession().beginTransaction();
        transactionThread.set(transaction);
    }

    public static void commitTransaction() {
        Transaction transaction = (Transaction) transactionThread.get();
        if ((transaction != null) && (!(transaction.wasCommitted())) && (!(transaction.wasRolledBack()))) {
            transaction.commit();
            transactionThread.set(null);
        }
    }

    public static void rollbackTransaction() {
        Transaction transaction = (Transaction) transactionThread.get();
        if ((transaction != null) && (!(transaction.wasCommitted())) && (!(transaction.wasRolledBack()))) {
            transaction.rollback();
            transactionThread.set(null);
        }
    }

    static {
        try {
            factory = new Configuration()
//                    /***MYSQL***/
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect") // tipo de dialeto do banco
                    .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver") // driver do banco
                    .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/cliente") // endereço do banco de dados
                    .setProperty("hibernate.connection.username", "willer")
                    .setProperty("hibernate.connection.password", "140491")
                    .setProperty("hibernate.hbm2ddl.auto", "update")
                    .setProperty("hibernate.c3p0.max_size", "10")
                    .setProperty("hibernate.c3p0.min_size", "2")
                    .setProperty("hibernate.c3p0.timeout", "5000")
                    .setProperty("hibernate.c3p0.max_statements", "10")
                    .setProperty("hibernate.c3p0.idle_test_period", "3000")
                    .setProperty("hibernate.c3p0.acquire_increment", "2")
                    .setProperty("show_sql", "true")
                    .setProperty("use_outer_join", "true")
                    .setProperty("hibernate.generate_statistics", "true")
                    .setProperty("hibernate.use_sql_comments", "true")
                    .setProperty("hibernate.format_sql", "true")
                    //CADASTROS abaixo coloque todas classes que deseja ser modelo para criação do banco de dados
                    .addAnnotatedClass(Cliente.class)
                    //MOVIMENTOS
                    .buildSessionFactory();
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String [] args) {

    }

}