<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 10/06/2025
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="prenom" type="java.lang.String" scope="request" />
<jsp:useBean id="nom" type="java.lang.String" scope="request" />
<jsp:useBean id="paroles" type="java.util.ArrayList<java.lang.String>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="../WEB-INF/head.jsp" %>
<body>

<main>

    <%-- 3/ Scriplet JSP: --%>
    <% for (String p : paroles){%>
        <p><%= p %></p>
    <% } %>

    <br>
    <%-- Affichage des variables --%>

    <%-- 1/ En utilisant le langage EL (expression language) : --%>
    <%--<em>- ${prenom} ${nom}</em>--%>

    <%-- 2/ (plus propre) En utilisant le langage EL avec usebean (déclarer les variables en haut): --%>
    <em>- ${prenom.toUpperCase()} ${nom.toUpperCase()}</em>

</main>

</body>
</html>
