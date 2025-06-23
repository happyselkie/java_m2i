<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 11/06/2025
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="sent" type="java.lang.Boolean" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Formulaire</title>
</head>
<body>
<h1>Formulaire</h1>

<form action="form" method="POST">
  <fieldset>
    <label>Prénom :
      <input type="text" name="prenom">
    </label>

    <label>Nom :
      <input type="text" name="nom">
    </label>

    <label>Age :
      <input type="text" name="age">
    </label>
  </fieldset>

  <button type="submit">Ajouter</button>

</form>

<% if sent %>

</body>
</html>
