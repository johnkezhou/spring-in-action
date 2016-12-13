<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>Spitter</title>
    <link rel="stylesheet" 
          type="text/css" 
          href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <h1>Welcome to Spitter</h1>
    <form name="itemsForm" action="/city/list_city_info" method="post">
    <table>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>CountryCode</th>
        <th>District</th>
        <th>Population</th>
      </tr>
      <c:forEach items="${cities}" var="city">
        <tr>
          <td>${city.id}</td>
          <td>${city.name}</td>
          <td>${city.countryCode}</td>
          <td>${city.district}</td>
          <td>${city.population}</td>
        </tr>
      </c:forEach>
    </table>
      </form>
  </body>
</html>
