<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--jstl 도구 사용하기 위해서, 메타 설정 코드 불러오기, 복붙해서 사용함. --%>
<!DOCTYPE html>
<html>
<head>
  <title>JSP-Model2(MVC)-todoList</title>
</head>
<body>
<ul>
<%--  서버 컨트롤러에서 전달 받은 박스, 라벨 이름: list, --%>
<%--  내용물: 디비에서 가져온 10개의 값--%>
  <c:forEach items="${list}" var="dto">
    <li>${dto}</li>
  </c:forEach>
</ul>

</body>
</html>
