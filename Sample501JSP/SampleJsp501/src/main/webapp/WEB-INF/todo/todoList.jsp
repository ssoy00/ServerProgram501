<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP-Model2(MVC)-todoList</title>
</head>
<body>
<h1><%= "todoList.jsp" %>
</h1>
<br/>
<h1><%= "임시 todoList 화면. 임시 메인" %>
</h1>
<p>서버에서 넘겨 받은 임시 더미 리스트 사용해보기.
  EL 표기법 으로 \${사용할 변수의 키 }, ex(key 이름 : list)</p>
<h2>서버에서 넘겨 받은 데이터를 그냥 출력했고, </h2>
${list}
</body>
</html>
