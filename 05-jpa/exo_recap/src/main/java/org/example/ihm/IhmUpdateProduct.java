package org.example.ihm;

import org.example.entity.Product;
import org.example.entity.ProductClothe;
import org.example.entity.ProductElectronic;
import org.example.entity.ProductFood;
import org.example.enums.ClotheCategory;
import org.example.enums.ClotheSize;
import org.example.util.EnumChecker;

import java.sql.Date;
import java.util.InputMismatchException;

public class IhmUpdateProduct extends Ihm{
    private static Product product;

    public IhmUpdateProduct(Product p){
        product = p;
    }

    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("*********************** Modifier un produit : "+product.getName()+" ***********************");
            System.out.println("*   Que voulez-vous faire ?                              *");
            System.out.println("*   [1] Modifier le nom                                  *");
            System.out.println("*   [2] Modifier la description                          *");
            System.out.println("*   [3] Modifier le prix                                 *");
            if(product instanceof ProductFood){
                System.out.println("*   [4] Modifier la date d'expiration                    *");
            } else if(product instanceof ProductElectronic){
                System.out.println("*   [4] Modifier l'autonomie                             *");
            } else{
                System.out.println("*   [4] Modifier la catégorie                            *");
                System.out.println("*   [5] Modifier la taille                               *");
            }
            System.out.println("*   [0] Retour au menu de gestion de l'inventaire        *");
            System.out.print("============================ Choix : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    updateName();
                    break;
                case 2:
                    updateDescription();
                    break;
                case 3:
                    updatePrice();
                    break;
                case 4:
                    if(product instanceof ProductFood){
                        updateExpiration();
                    } else if (product instanceof ProductElectronic) {
                        updateAutonomy();
                    } else{
                        updateCategory();
                    }
                case 5:
                    if(product instanceof ProductFood){
                        updateSize();
                    } else{
                        System.out.println("Choix invalide !");
                    }
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        }
        System.out.println("Retour au menu de gestion de l'inventaire...");
    }

    public static void updateName() {
        String name = product.getName();
        System.out.println("Saisir le nouveau nom :");
        product.setName(scanner.nextLine());

        productService.update(product);
        System.out.println("Le nom "+name+"du produit "+product.getName()+" a bien été modifié en "+product.getName()+" !");
    }

    public static void updateDescription() {
        String description = product.getDescription();
        System.out.println("Saisir la nouvelle description :");
        product.setDescription(scanner.nextLine());

        productService.update(product);
        System.out.println("La description \""+description+"\"du produit "+product.getName()+" a bien été modifiée en "+product.getDescription()+" !");
    }
     public static void updatePrice() {
        double price = product.getPrice();
        System.out.println("Saisir le prix :");
        product.setPrice(scanner.nextDouble());

        productService.update(product);
        System.out.println("Le prix \""+price+"\"du produit "+product.getName()+" a bien été modifiée en "+product.getPrice()+" !");
     }

     public static void updateExpiration() {
        ProductFood productFood = (ProductFood) product;
        Date expirationDate = productFood.getExpirationDate();
        System.out.println("Saisir la date d'expiration :");
        Date newExpirationDate = dateChecker.dateToSqlDate(scanner.nextLine());
        productFood.setExpirationDate(newExpirationDate);

        productService.update(productFood);
        System.out.println("La date d'expiration "+expirationDate.toString()+" du produit "+product.getName()+" a bien été modifiée en "+newExpirationDate.toString()+" !");
     }

     public static void updateAutonomy() {
         ProductElectronic productElectronic = (ProductElectronic) product;
         int autonomy = productElectronic.getAutonomy();
         System.out.println("Saisir l'autonomie :");
         productElectronic.setAutonomy(scanner.nextInt());
         scanner.nextLine();


         productService.update(productElectronic);
         System.out.println("L'autonomie "+autonomy+" du produit "+product.getName()+" a bien été modifiée en "+productElectronic.getAutonomy()+" !");

     }

     public static void updateCategory() {
        ProductClothe productClothe = (ProductClothe) product;
        ClotheCategory clotheCategory = productClothe.getClotheCategory();
        System.out.println("Catégorie (\"men\", \"women\" ou \"children\") : ");

         boolean validCat = false;
         ClotheCategory newClotheCategory = null;

         while(!validCat) {
             try{
                 newClotheCategory = EnumChecker.getCategory(scanner.nextLine().toLowerCase());
                 validCat = true;
             } catch (InputMismatchException e){
                 System.out.println(e.getMessage()+ ", veuillez insérer une catégorie valide (\"men\", \"women\" ou \"children\") :");
             }
         }

         productClothe.setClotheCategory(newClotheCategory);
         System.out.println("La catégorie "+clotheCategory+ " du produit "+productClothe.getName()+" a bien été modifiée en "+productClothe.getClotheCategory()+" !");
     }

     public static void updateSize() {
         ProductClothe productClothe = (ProductClothe) product;
         ClotheSize clotheSize = productClothe.getClotheSize();

         System.out.println("Taille (\"xs\", \"s\", \"m\", \"l\", \"xl\") : ");
         boolean validSize = false;
         ClotheSize newclotheSize = null;

         while(!validSize) {
             try{
                 newclotheSize = EnumChecker.getSize(scanner.nextLine().toLowerCase());
                 validSize = true;
             } catch (InputMismatchException e){
                 System.out.println(e.getMessage()+ ", veuillez insérer une taille valide (\"xs\", \"s\", \"m\", \"l\", \"xl\") :");
             }
         }

         productClothe.setClotheSize(newclotheSize);
         System.out.println("La taille "+clotheSize+ " du produit "+productClothe.getName()+" a bien été modifiée en "+productClothe.getClotheSize()+" !");
     }

}
