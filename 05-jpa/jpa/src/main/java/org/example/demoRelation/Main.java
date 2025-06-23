package org.example.demoRelation;

import org.example.demoRelation.ManyToMany.Ingredient;
import org.example.demoRelation.ManyToMany.Recette;
import org.example.demoRelation.OneToMany.Departement;
import org.example.demoRelation.OneToMany.Professeur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");
        EntityManager em = emf.createEntityManager();

      /*  Coordonnees coordonnees = Coordonnees.builder().adresse("12 rue des lilas").codePostal(59000).build();
        Etudiant etudiant = Etudiant.builder().name("toto").age(20).coordonnees(coordonnees).build();*/

/*        em.getTransaction().begin();
        em.persist(coordonnees);
        em.persist(etudiant);
        em.getTransaction().commit();*/


        // Demo ONE TO ONE
      /*  System.out.println(em.find(Etudiant.class, 1));
        System.out.println(em.find(Coordonnees.class, 1).getEtudiant());*/

        //DEMO ONE TO MANY / MANY TO ONE
        /*Departement departement = Departement.builder().name("dep").build();
        Professeur professeur = Professeur.builder().name("toto").departement(departement).build();*/

        // ONE TO MANY
       /* em.getTransaction().begin();
        em.persist(professeur);
        em.getTransaction().commit();*/

        // MANY TO ONE
        //System.out.println(em.createQuery("select d from Departement d").getResultList());

        //MANY TO MANY
/*        Ingredient tomate = Ingredient.builder().name("Tomate").price(12.5f).build();
        Ingredient fromage = Ingredient.builder().name("Fromage").price(22.5f).build();
        Ingredient pain = Ingredient.builder().name("Pain").price(2.5f).build();

        Recette recette1 = Recette.builder().name("Pain à la tomate").build();
        Recette recette2 = Recette.builder().name("Pain au fromage").build();*/

        /*em.getTransaction().begin();
        em.persist(tomate);
        em.persist(fromage);
        em.persist(pain);
        em.persist(recette1);
        em.persist(recette2);
        em.getTransaction().commit();*/



/*        em.getTransaction().begin();
        Recette recette1 = em.find(Recette.class, 4);
        Ingredient ingredient1 = em.find(Ingredient.class, 1);
        Ingredient ingredient2 = em.find(Ingredient.class, 2);
        recette1.addIngredient(ingredient1);
        recette1.addIngredient(ingredient2);
        em.getTransaction().commit();*/

        Recette recette1 = em.find(Recette.class, 4);
        System.out.println(recette1);


    }
}


