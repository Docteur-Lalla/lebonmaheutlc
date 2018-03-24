<%--
  Created by IntelliJ IDEA.
  User: lalla
  Date: 14/03/18
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Goodenough's list</title>
  </head>
  <body>
    <h1>Welcome to Hell!</h1>
    <h3>Last ads:</h3>

    <h3>Pending ads:</h3>

    <h3>Post a new ad:</h3>
    <form method="POST" action="/">
      <label>Ad title: </label><input id="ad-title" name="ad-title" type="text" /><br/>
      <label>Ad price: </label><input id="ad-price" name="ad-price" type="number" /><br/>
      <label>Ad contents: </label><textarea id="ad-contents" name="ad-contents" width="80" height="25"></textarea><br/>
      <input value="Send Ad please" type="submit" />
    </form>

    <form method="POST" action="persist">
      <input value="Commit Ad list please" type="submit" />
    </form>
  </body>
</html>
