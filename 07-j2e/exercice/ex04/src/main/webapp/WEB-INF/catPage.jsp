<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 11/06/2025
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="org.example.ex04.model.entity.Cat" %>
<jsp:useBean id="cats" type="java.util.ArrayList<org.example.ex04.model.entity.Cat>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CATS</title>
  <%@include file="../WEB-INF/include.jsp" %>
</head>
<body>

<main>

  <article class="tab">
    <h1>CATS CATS CATS ! </h1>

  <% if(!cats.isEmpty()){ %>

    <table class="table table-striped">
      <thead class="thead-dark">
      <tr>
        <td>Name</td>
        <td>Race</td>
        <td>Favorite Meal</td>
        <td>Date Of Birth</td>
      </tr>
      </thead>
      <tbody>

      <% for (Cat c : cats){%>
      <tr>
        <td><%= c.getName() %></td>
        <td><%= c.getRace() %></td>
        <td><%= c.getFavoriteMeal() %></td>
        <%--<td><%= c.getDateOfBirth() %></td>--%>
        <td><%= c.getDateOfBirth().getDayOfMonth()+"/"+c.getDateOfBirth().getMonthValue()+"/"+c.getDateOfBirth().getYear() %></td>
      </tr>
      <% } %>
      </tbody>
    </table>

    <% } else { %>

    <p>There is no cat :'(</p>

    <% } %>
  </article>

  <article class="tab">
    <h2>Add a new cat ! =D</h2>
    <form action="cats" method="post">
      <fieldset>
        <div class="form-group">
          <label for="name">Name</label>
          <input type="text" class="form-control" id="name" name="name" placeholder="Enter name">
        </div>
        <div class="form-group">
          <label for="race">Race</label>
          <input type="text" class="form-control" id="race" name="race" placeholder="Enter Race">
        </div>
        <div class="form-group">
          <label for="favMeal">Favorite Meal</label>
          <input type="text" class="form-control" id="favMeal" name="favMeal" placeholder="Enter Favorite Meal">
        </div>
        <div class="form-group">
          <label for="favMeal">Date Of Birth</label>
          <input type="date" class="form-control" id="DateOfBirth" name="DateOfBirth" placeholder="Enter Date Of Birth">
        </div>
      </fieldset>

      <button>Cat ! </button>
    </form>
  </article>


</main>

</body>
</html>
