package org.example.demoJPA;

import org.example.demoJPA.entity.Account;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");
        EntityManager em = emf.createEntityManager();

        // Enregistrer de données :
        /*Account account = new Account(2000, "Fran", "0000 0000 0000 0000");
        Account account2 = new Account(800, "Fran2", "9876 5432 1987 6543");

        em.getTransaction().begin();
        em.persist(account);
        em.persist(account2);
        em.getTransaction().commit();*/

        // Rechercher des occurences :

        // Par Id :
        Account accountFind = em.find(Account.class, 2); //avec find
        if(accountFind != null) System.out.println(accountFind);
        else System.out.println("No account fount");

        try {
            Account accountByReference = em.getReference(Account.class, 3); // avec getReference
            System.out.println(accountByReference);
        } catch (EntityNotFoundException e){
            System.out.printf(e.getMessage());
        }

        // avec les queries :
        TypedQuery<Account> query = em.createQuery("Select a from Account a where a.balance > 500", Account.class);

        List<Account> accounts = query.getResultList();

        accounts.forEach(System.out::println);

        // Modifier une occurence :
        try{
            Account accountToUpdate = em.getReference(Account.class, 2);
            em.getTransaction().begin();
            accountToUpdate.setBalance(450);
            em.getTransaction().commit();
        } catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
        }

        System.out.println(em.find(Account.class, 2));


        // Supprimer une occurence :
        Account accountToDelete = em.find(Account.class, 3);

        if (accountToDelete != null){
            em.getTransaction().begin();
            em.remove(accountToDelete);
            em.getTransaction().commit();
        }


    }
}
