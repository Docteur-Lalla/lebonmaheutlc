<%--
  Created by IntelliJ IDEA.
  User: lalla
  Date: 14/03/18
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Goodenough's list</title>
</head>
<body>
<h1>Welcome to Hell!</h1>
<h3>Last ads:</h3>

<table>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Date</th>
        <th>Delete ?</th>
    </tr>

    <c:forEach items="${ requestScope.ads }" var="ad">
        <tr>
            <form method="POST" action="persist">
                <td><c:out value="${ad.title}"/></td>
                <td><c:out value="${ad.price}"/></td>
                <td><c:out value="${ad.contents}"/></td>
                <td><c:out value="${ad.date}"/></td>
                <td><input value="Delete" type="submit" /></td>
                <input name="ad-delete-id" value="${ad.id}" style="display: none" />
            </form>
        </tr>
    </c:forEach>
</table>

<h3>Pending ads:</h3>
<table>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Date</th>
    </tr>

    <c:forEach items="${ applicationScope.pendingAds }" var="ad">
        <tr>
            <td><c:out value="${ad.title}"/></td>
            <td><c:out value="${ad.price}"/></td>
            <td><c:out value="${ad.contents}"/></td>
            <td><c:out value="${ad.date}"/></td>
        </tr>
    </c:forEach>
</table>

<h3>Post a new ad:</h3>
<form method="POST" action="/">
    <label>Ad title: </label><input id="ad-title" name="ad-title" type="text"/><br/>
    <label>Ad price: </label><input id="ad-price" name="ad-price" type="number"/><br/>
    <label>Ad contents: </label><textarea id="ad-contents" name="ad-contents" width="80" height="25"></textarea><br/>
    <input value="Send Ad please" type="submit"/>
</form>

<form method="POST" action="persist">
    <input value="Commit Ad list please" type="submit"/>
</form>
</body>
</html>
