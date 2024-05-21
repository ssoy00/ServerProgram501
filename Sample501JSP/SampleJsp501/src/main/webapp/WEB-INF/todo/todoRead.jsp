<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP-Model2(MVC)-todoRead</title>
</head>
<body>
<h1><%= "임시 todoRead 화면." %>
</h1>

  <div>
    <input type="text" name="title" placeholder="제목을 입력해주세요." value="${sample.title}" readonly>
  </div>
  <div>
    <input type="date" name="dueDate" value="${sample.dueDate}" readonly>
  </div>
<div>
  <input type="checkbox" name="finished" ${sample.finished ? "checked":""} readonly>
</div>
<%--방법1--%>
<%--<form method="get" action="/todo/update ">--%>
<%--  <input type="text" name="tno" value="${sample.tno}">--%>
<%--  <div>--%>
<%--    <button type="submit">수정하기</button>--%>
<%--  </div>--%>
<%--</form>--%>
<%--방법2 링크로 해당 수정폼 이동하기.--%>
<div>
  <a href="/todo/update?tno=${sample.tno}">수정폼이동</a>
</div>
<%--방법3--%>
<%--&lt;%&ndash;자바스크립트의 코드 이용해서. 처리하기. &ndash;%&gt;--%>
<%--<div>--%>
<%--  <input type="button" value="수정폼이동" id="updateBtn">--%>
<%--</div>--%>

<form method="get" action="/todo/list">
  <button type="submit">전체메뉴</button>
</form>
<script>
  const target = document.querySelector("#updateBtn");

  target.addEventListener("click", function () {

  });
</script>
</body>
</html>
