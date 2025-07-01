Exercice 6 

1 - Création de compte et Connexion

    - L'utilisateur doit pouvoir créer un compte.
    - L'utilisateur doit pouvoir se connecter à son compte.

2 - Recherche et Navigation des Produits

    - L'utilisateur doit pouvoir rechercher des produits.
    - L'utilisateur doit pouvoir naviguer par catégorie de produits.

3 - Passation de Commande

    - L'utilisateur doit pouvoir passer une commande.



>- User Story 1 : En tant qu'utilisateur, je veux créer un compte pour pouvoir passer des commandes.
>> - Critères d'acceptation :
        >>> - L'utilisateur peut accéder à un formulaire d'inscription.
        >>> - L'utilisateur doit fournir un email, un nom d'utilisateur, et un mot de passe.
        >>> - L'utilisateur reçoit une confirmation après l'inscription.
        >>> - Une erreure est renvoyé lors que la creation d'un compte avec un identifiant deja existant

>- User Story 2 : En tant qu'utilisateur, je veux me connecter à mon compte pour accéder et passer des commandes.
>> -    Critères d'acceptation :
        >>> - L'utilisateur peut accéder à un formulaire de connexion.
        >>> - L'utilisateur doit entrer son nom d'utilisateur et son mot de passe.
        >>> - L'utilisateur voit un message d'erreur en cas de connexion échouée.
        >>> - L'utilisateur est redirigé vers la page d'accueil après une connexion réussie.

>- User Story 3 : En tant qu'utilisateur, je veux rechercher des produits pour trouver ce dont j'ai besoin rapidement.
>> -    Critères d'acceptation :
        >>> - L'utilisateur peut accéder à une barre de recherche.
        >>> - L'utilisateur voit une liste de résultats de recherche pertinente après avoir entré un mot-clé.

>- User Story 4 : En tant qu'utilisateur, je veux naviguer par catégorie de produits pour découvrir ce qui est disponible.
>> -    Critères d'acceptation :
        >>> - L'utilisateur peut accéder à une page de catégories.
        >>> - L'utilisateur peut cliquer sur une catégorie pour voir les produits correspondants.

> - User Story 5 : En tant qu'utilisateur, je veux ajouter des produits a la commande.
>> -    Critères d'acceptation :
        >>> - L'utilisateur peut cliquer sur un bouton "Ajouter a la commande" depuis la page produit.
        >>> - L'utilisateur voit une confirmation que le produit a été ajouté a la commande.
        >>> - si le produit se trouve deja dans la commande la sa quantité est augmentée de 1

>- User Story 6 : En tant qu'utilisateur, je veux supprimer des produits de la commande.
>> -    Critères d'acceptation :
        >>>- L'utilisateur peut cliquer sur un bouton "Supprimer" à côté de chaque produit dans la commande.
        >>>- Ca quantitée est diminué de 1 ou le produit est retiré de la commande.
        >>>- une erreure est renvoyé si le produit ne se trouve pas dans la commande

>- User Story 7 : En tant qu'utilisateur, je veux passer une commande.
>>-   Critères d'acceptation :
        >>>- L'utilisateur peut accéder à un formulaire de commande.
        >>>- L'utilisateur reçoit une confirmation de commande après l'avoir passée.
        >>> - une erreure est renvoyé si la commande n'existe pas