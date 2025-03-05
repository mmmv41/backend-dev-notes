<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Request Parameter</h1>
<h3>GET 방식의 요청</h3>
<h4>form 태그를 활용한 get 방식 요청</h4>
<form action="querystring" method="get">
    <label>이름: </label><input type="text" name="name">
    <br>
    <label>나이: </label><input type="text" name="age">
    <br>
    <%--  label+input --%>
    <label>생일: </label><input type="date" name="birthday">
    <br>
    <label>성별: </label>
    <input type="radio" name="gender" id="male" value="M">
    <label for="male">남자</label>
    <input type="radio" name="gender" id="female" value="F">
    <label for="female">여자</label>
    <br>
    <label>국적: </label>
    <select name="national">
        <%-- option*4--%>
        <option value="ko">한국</option>
        <option value="ch">중국</option>
        <option value="jp">일본</option>
        <option value="etc">기타</option>
    </select>
    <br>
    <label>취미: </label>
    <input type="checkbox" name="hobbies" id="movie" value="movie"><label>영화보기</label>
    <input type="checkbox" name="hobbies" id="music" value="music"><label>음악감상</label>
    <input type="checkbox" name="hobbies" id="sleep" value="sleep">
    <lable>잠자기</lable>
    <br>
    <button type="submit">GET 요청</button>
</form>

<a href="querystring?name=밍&age=25&birthday=2025-02-03&gender=F&national=ko&hobbies=movie&hobbies=music&hobbies=sleep">
    a 태그를 활용한 쿼리스트링 방식
</a>


<h3>POST 방식의 요청</h3>
<h4>form 태그를 이용한 post 방식 요청</h4>
<form action="formdata" method="post">
    <label>이름: </label><input type="text" name="name">
    <br>
    <label>나이: </label><input type="text" name="age">
    <br>
    <%--  label+input --%>
    <label>생일: </label><input type="date" name="birthday">
    <br>
    <label>성별: </label>
    <input type="radio" name="gender" id="male" value="M">
    <label for="male">남자</label>
    <input type="radio" name="gender" id="female" value="F">
    <label for="female">여자</label>
    <br>
    <label>국적: </label>
    <select name="national">
        <%-- option*4--%>
        <option value="ko">한국</option>
        <option value="ch">중국</option>
        <option value="jp">일본</option>
        <option value="etc">기타</option>
    </select>
    <br>
    <label>취미: </label>
    <input type="checkbox" name="hobbies" id="movie" value="movie"><label>영화보기</label>
    <input type="checkbox" name="hobbies" id="music" value="music"><label>음악감상</label>
    <input type="checkbox" name="hobbies" id="sleep" value="sleep">
    <lable>잠자기</lable>
    <br>
    <button type="submit">POST 요청</button>
</form>


<br/>
</body>
</html>