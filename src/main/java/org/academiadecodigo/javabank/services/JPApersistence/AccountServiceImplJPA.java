package org.academiadecodigo.javabank.services.JPApersistence;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.AbstractAccount;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.services.AccountService;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class AccountServiceImplJPA implements AccountService {

    private EntityManagerFactory emf;

    public static void main(String[] args) {


        AccountServiceImplJPA jpa = new AccountServiceImplJPA()
    }


    public AccountServiceImplJPA (EntityManagerFactory emf){
        this.emf = emf;
    }

    @Override
    public void add(Account account) {
        EntityManager em = emf.createEntityManager();
        AbstractAccount abstractAccount = (AbstractAccount) account;

        try{
            em.getTransaction().begin();
            em.persist(abstractAccount);
            em.getTransaction().commit();

        }catch (RollbackException e){
            em.getTransaction().rollback();
            return;
        }
        finally {
            if(em != null){
                em.close();
            }
        }
    }

    @Override
    public void deposit(int id, double amount) {
        EntityManager em = emf.createEntityManager();

        try{


            // 1 - get a CriteriaBuilder object from the EntityManager
            CriteriaBuilder builder = em.getCriteriaBuilder();

            // 2 - create a new CriteriaQuery instance for the Customer entity
            CriteriaQuery<AbstractAccount> criteriaQuery = builder.createQuery(AbstractAccount.class);

            // 3 - get the root of the query, from where all navigation starts
            Root<AbstractAccount> root = criteriaQuery.from(AbstractAccount.class);

            // 4 - specify the item that is to be returned in the query result
            criteriaQuery.select(root);

            // 5 - add query restrictions
            criteriaQuery.where(builder.equal(root.get("id"), id));

            AbstractAccount abstractAccount = em.createQuery(criteriaQuery).getSingleResult();
            abstractAccount.credit(amount);

            em.getTransaction().begin();
            em.persist(abstractAccount);
            em.getTransaction().commit();



        }catch (RollbackException e){
            em.getTransaction().rollback();
            return;
        }
        finally {
            if(em != null){
                em.close();
            }
        }

    }

    @Override
    public void withdraw(int id, double amount) {

    }

    @Override
    public void transfer(int srcId, int dstId, double amount) {

    }

}
