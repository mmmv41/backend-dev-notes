<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Filter</h1>
<h3>필터의 라이프 사이클</h3>
<%--    ul>li>a  --%>
<ul>
    <li><a href="first/filter">Filter 사용하기</a></li>
</ul>

<hr>

<h3>필터의 활용</h3>
<form action="member/regist" method="post">
    <%--    lable{아이디: }--%>
    <lable>아이디:</lable>
    <input type="text" name="userId">
    <br>
    <%--    (label+input[name=password]+br)*2--%>
    <label>비밀번호: </label>
    <input type="password" name="password">
    <br>
    <label>이름: </label>
    <input type="text" name="name">
    <br>
    <%--    버튼의 기본 타입은 submit 이다. --%>
    <button type="submit">가입하기</button>
</form>
</body>
</html>