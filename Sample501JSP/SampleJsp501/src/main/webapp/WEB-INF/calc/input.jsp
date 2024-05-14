<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP2 - input.jsp</title>
</head>
<body>
<%--action 속성의 값으로 서버에서 처리할 서블릿 주소를 입력 하면 됨.--%>
<%--예제로, input.jsp -> result1.jsp 로 쿼리스트링을 이용해서 , 파라미터 전달 테스트--%>
<%--원래 의도 대로 , 현재 입력폼이 -> 컨트롤러를 먼저가서 확인후 -> 화면--%>
<%--result1.jsp , 단순 페이지 입니다. 절대 바로 안감.!!--%>
<form action="result1.jsp" method="post">
  <input type="number" name="num1">
  <input type="number" name="num2">
  <button type="submit">전송</button>
</form>
</body>
</html>
