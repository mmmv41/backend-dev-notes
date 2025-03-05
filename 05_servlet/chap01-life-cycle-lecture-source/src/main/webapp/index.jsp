<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<h1>라이프 사이클 테스트</h1>
<a href="xml-lifecycle">xml 방식 라이프 사이클 테스트</a><br> <!-- 링크를 눌렀을 때 path -->
<a href="annotation-lifecycle">annotation 방식 라이프 사이클 테스트</a>
<%--슬래시(/) 없이 작성하면 현재 페이지를 기준으로 해당 경로를 찾음.--%>
<%--따라서 annotation-lifecycle 라고 적으면 -> chap01/annotation-lifecycle 로 이동하면서 인식하게 됨.--%>
</body>
</html>