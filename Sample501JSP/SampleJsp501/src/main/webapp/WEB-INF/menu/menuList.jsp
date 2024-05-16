<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--jstl 도구 사용하기 위해서, 메타 설정 코드 불러오기, 복붙해서 사용함. --%>
<!DOCTYPE html>
<html>
<head>
  <title>JSP-Model2(MVC)-MenuList</title>
</head>
<body>

<h1><%= "임시 MenuList 화면. 임시 메인" %>
</h1>

<h1>JSTL 이용해서 반복문 출력해보기1.단순 반복문</h1>
<ul>
  <c:forEach var="dto" items="${list}">
    <li>
        ${dto}
    </li>
  </c:forEach>
</ul>
</body>
</html>
