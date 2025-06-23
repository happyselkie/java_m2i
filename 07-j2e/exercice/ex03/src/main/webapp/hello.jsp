<%@ page import="org.example.ex03.model.entity.Person" %>
<jsp:useBean id="personnes" type="java.util.ArrayList<org.example.ex03.model.entity.Person>" scope="request" />
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="format-detection" content="telephone=no">
    <%@include file="WEB-INF/styles.jsp" %>
</head>

<body>

<main>
    <h1>Liste des personnes inscrites : </h1>
    <article class="tab">
        <div>Nom</div>
        <div>Prénom</div>
        <div>Age</div>
        <% for (Person p : personnes){%>
        <div> <%= p.getName() %> </div>
        <div> <%= p.getLastname() %> </div>
        <div> <%= p.getAge() %> </div>
        <% } %>
    </article>
</main>

</body>
</html>