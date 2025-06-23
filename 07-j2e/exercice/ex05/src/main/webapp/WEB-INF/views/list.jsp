<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 12/06/2025
  Time: 09:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="org.example.ex05.model.entity.Dog" %>
<jsp:useBean id="dogs" type="java.util.List<org.example.ex05.model.entity.Dog>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of good bois !</title>
    <%@include file="../include.jsp" %>
</head>
<body>

<main>
    <section>
        <% if(!dogs.isEmpty()){ %>

        <h1>List of good bois !</h1>
        <nav>
            <a href="add" class="add btn">Add a new boi !</a>
        </nav>

        <article class="container">
            <div class="line header">
                <div>Name</div>
                <div>Breed</div>
                <div>Birthday</div>
                <div>&nbsp;</div>
            </div>

            <% for (Dog d : dogs){%>
            <div  class="line">
                <a href="edit?id=<%= d.getId() %>" class="edit"><%= d.getName() %></a>
                <div><%= d.getBreed() %></div>
                <div><%= d.getBirthday().getDayOfMonth()+"/"+d.getBirthday().getMonthValue()+"/"+d.getBirthday().getYear() %></div>
                <a href="delete?id=<%= d.getId() %>">&#10060;</a>
            </div>
            <% } %>
        </article>


        <% } else {%>
        <h1 lass="empty">There is no dog :'(</h1>>
        <nav>
            <a href="add" class="add">Add a new boi !</a>
        </nav>
        <% } %>
    </section>

</main>

</body>
</html>
