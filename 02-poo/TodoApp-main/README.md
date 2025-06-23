# 📝 Projet Java POO : Compléter une application de gestion de tâches pour l’entreprise TaskFlow

## 📚 Objectif pédagogique

- Travailler sur une base de code existante (cas réel en entreprise)
- Appliquer les principes de **programmation orientée objet** :
  - Encapsulation
  - Abstraction (via interfaces)
  - Responsabilité unique
  - Réutilisabilité

---

## 🎯 Contexte

L’entreprise **TaskFlow**, spécialisée dans les outils de productivité, développe une application console permettant aux utilisateurs internes de **gérer leurs tâches au quotidien**.

L’équipe technique a déjà mis en place :

✅ Une **interface console complète (IHM)** qui gère les menus, les entrées utilisateurs et l’affichage.  
✅ Les **interfaces Java** définissant les fonctionnalités à implémenter pour la couche métier (service).

Votre mission en tant que développeur junior dans l’équipe sera de **compléter l’application** en :

- Complétant le modèle `Todo`
- Implémentant la classe métier `TodoServiceImpl`

---

### ✅ 📌 Ce que doit contenir une tâche (Todo)

Chaque tâche (ou "todo") est représentée par un objet `Todo` et doit obligatoirement contenir les champs suivants :

* `id` (entier) : identifiant unique généré automatiquement.
* `name` (chaîne de caractères) : le **titre** de la tâche.
* `description` (chaîne de caractères) : une **description détaillée** de la tâche.
* `done` (booléen) : un indicateur qui vaut `false` par défaut, puis `true` si la tâche est marquée comme faite.

🛠️ Ces champs doivent être **encapsulés** dans la classe `Todo`, avec des **getters et setters** publics.


---

### 🚀 📂 Livraison attendue sur GitHub

Votre projet Java doit être livré sur une plateforme de versioning (comme GitHub) avec les éléments suivants :

1. ✅ Le code source complet, organisé dans les bons packages (`model`, `service`, `ihm`, etc.).
2. ✅ Un fichier `README.md` expliquant :

  * Le contexte du projet
  * Les instructions de compilation et d’exécution
  * Ce que vous avez implémenté
3. ✅ Des **commits clairs** et réguliers
4. ✅ Un `.gitignore` adapté (vous pouvez générer un modèle Java sur [gitignore.io](https://www.toptal.com/developers/gitignore))

🎯 Lien du dépôt GitHub à fournir en fin de projet.

---

### 🔎 💡 Bonus 1 : Diagramme de classe UML

Pour améliorer la lisibilité et la compréhension de votre architecture, réalisez un **diagramme de classe UML** représentant votre application.

Il doit inclure au minimum les classes suivantes :

* `Todo`
* `TodoServiceImpl`
* `Ihm`

Le diagramme peut être dessiné avec un outil comme :

* [PlantUML](https://plantuml.com/fr/)
* [Lucidchart](https://www.lucidchart.com/)
* [draw.io](https://app.diagrams.net/)

💡 Livrez-le sous forme d’image (`.png` ou `.svg`) ou en fichier `.puml` dans le dossier `/docs`.

---

### 🧠 💡 Bonus 2 : Filtrer les tâches à faire uniquement

Ajoutez une nouvelle fonctionnalité au menu de l’application pour **afficher uniquement les tâches non terminées** (donc celles dont `done == false`).

**Exemple d'entrée dans le menu :**

```
7. Afficher uniquement les tâches à faire
```

💡 Cette fonctionnalité devra être implémentée en ajoutant une méthode dans `TodoServiceImpl` et une nouvelle action dans la classe `Ihm`.

Excellent choix ! Voici un **bonus pédagogique** axé sur l’**héritage**, parfaitement adapté pour un exercice Java POO.

---

### 🧠 💡 Bonus 3 : Implémenter une catégorie de tâche prioritaire

Ajoutez une **classe `PriorityTodo`** qui hérite de la classe `Todo` et permet de spécifier un **niveau de priorité** (par exemple : *haute*, *moyenne*, *basse*).

#### Objectif :

* Mettre en pratique l’**héritage** en Java
* Manipuler des objets polymorphes dans la liste des tâches
* Gérer des affichages différenciés selon le type de tâche

---

#### Consignes :

1. Créez une classe `PriorityTodo` dans le package `model` qui **hérite de `Todo`**.
2. Ajoutez un attribut `String priority` avec les valeurs possibles : `"basse"`, `"moyenne"`, `"haute"`.
3. Redéfinissez la méthode `toString()` pour **inclure la priorité dans l'affichage**.
4. Ajoutez une nouvelle option dans l’IHM pour créer une tâche prioritaire.
5. Vous pouvez stocker les `PriorityTodo` dans la même collection grâce au **polymorphisme**.

---

#### Exemple de rendu console :

```
[3] 🔴 [Prioritaire - HAUTE] Réviser l’oral - relire les fiches (À FAIRE)
[4] ✅ Acheter du café (FAIT)
```

---





