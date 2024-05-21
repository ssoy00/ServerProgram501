<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP-Model2(MVC)-todoUpdate</title>
</head>
<body>
<h1><%= "임시 todoRead 화면." %>
</h1>
<form method="post" action="/todo/update ">
  <div>
    <input type="text" name="title" placeholder="제목을 입력해주세요." value="${sample.title}" >
  </div>
  <div>
    <input type="date" name="dueDate" value="${sample.dueDate}" >
  </div>
  <div>
    <button type="submit">수정하기</button>
  </div>
</form>
<form method="get" action="/todo/list">
  <button type="submit">전체메뉴</button>
</form>
</body>
</html>
