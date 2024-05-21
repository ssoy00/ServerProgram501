<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--jstl 도구 사용하기 위해서, 메타 설정 코드 불러오기, 복붙해서 사용함. --%>
<!DOCTYPE html>
<html>
<head>
  <title>JSP-Model2(MVC)-MenuList</title>
</head>
<body>

<ul>
  <c:forEach var="dto" items="${list}">
    <li>
        ${dto}
    </li>
  </c:forEach>
</ul>
</body>
</html>
