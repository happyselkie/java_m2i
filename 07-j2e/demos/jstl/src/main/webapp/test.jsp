<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 12/06/2025
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
</head>
<body>

<h3> la balise c:if</h3>
<c:if test="${isTrue}">
  <p>La valeur est vraie !</p>
</c:if>

<c:if test="${isFalse}">
  <p>La valeur est fausse !</p>
</c:if>

<h3> la balise c:out</h3>
<p><c:out value="${nameDemo}"/></p>

<p><c:out value="${nameInconnu}" default="Au cas une valeur par défaut (si variable non ajoutée)"/></p>

<h3> la balise c:forEach</h3>
<c:forEach var="prenom" items="${prenoms}" >
    <p>${prenom}</p>
</c:forEach>

<h3> la balise c:import</h3>
<c:import url="${pageContext.request.contextPath}/WEB-INF/maDiv.jsp" />


<h3> les balises c:choose, c:when, c:otherwhise</h3>
<c:choose>
    <c:when test="${isFalse}">
        <p>J'affiche le premier paragraphe</p>
    </c:when>
    <c:when test="${isTrue}">
        <p>J'affiche le deuxième paragraphe</p>
    </c:when>
    <c:otherwise>
        <p>Aucune des valeurs précédentes n'est vraies</p>
    </c:otherwise>
</c:choose>



</body>
</html>
