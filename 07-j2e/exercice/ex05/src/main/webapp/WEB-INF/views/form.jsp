<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 12/06/2025
  Time: 09:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="org.example.ex05.model.entity.Dog" %>

<jsp:useBean id="edit" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="dog" type="org.example.ex05.model.entity.Dog" scope="request" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include.jsp" %>
<html>
<head>
    <title>From for a good boi</title>
</head>
<body>
<main>
    <section>
        <a class="back_to_list" href="list">&#10094;</a>
        <% if(!edit){ %> <h1>Add a good boi !</h1> <% } else { %> <h1>Edit <%=dog.getName() %> !</h1> <% } %>
        <article class="form">
            <form action="dogs" method="post">
                <input type="hidden" name="edit" value="<% if(edit){ %><%=dog.getId() %><% } else { %>0<% }%>">
                <fieldset>
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" id="name" name="name" <% if(edit){ %> value="<%=dog.getName() %>" <% } %>>
                    </div>
                    <div class="form-group">
                        <label for="breed">Breed</label>
                        <input type="text" class="form-control" id="breed" name="breed" <% if(edit){ %> value="<%=dog.getBreed() %>" <% } %> >
                    </div>
                    <div class="form-group">
                        <label for="DateOfBirth">Date Of Birth</label>
                        <input type="date" class="form-control" id="DateOfBirth" name="birthday" <% if(edit){ %> value="<%=dog.getBirthday() %>" <% } %>>
                    </div>
                </fieldset>

                <button class="btn"> <% if(edit){ %> update ! <%=dog.getName() %> <% } else { %> add new dog !  <% } %> </button>
            </form>
        </article>
    </section>

</main>
</body>
</html>
