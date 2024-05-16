<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--jstl 도구 사용하기 위해서, 메타 설정 코드 불러오기, 복붙해서 사용함. --%>
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
<h2>
  tno 번호 :
</h2>
<h3>${list[0].tno}</h3>
<h2>
  tno 제목 :
</h2>
<h3>${list[0].title}</h3>

<h2>
  tno 날짜 :
</h2>
<h3>${list[0].dueDate}</h3>
<ul>
  <c:forEach var="dto" items="${list}">
    <li>
        ${dto}
    </li>
  </c:forEach>
</ul>

</body>
</html>
