<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Spring Boot</title>
</head>
<body>
  <h1>Spring Boot Properites file</h1>
  <table>
    <tr>
      <td>Name:</td>
      <td><p th:text="${name}">Default Name</p></td>
    </tr>
    <tr>
      <td>Website:</td>
      <td><p th:text="${website}">Default Website</p></td>
    </tr>
    <tr>
      <td>Message:</td>
      <td><p th:text="${message}">Default Message</p></td>
    </tr>
    <tr>
      <td>Service:</td>
      <td><p th:text="${service}">Default Message</p></td>
    </tr>
    Menu:
    <ul th:if="${menus != null && !menus.empty}">
      <li th:each="menu: ${menus}" th:text="${menu}"></li>
    </ul>
  </table>
</body>
</html>