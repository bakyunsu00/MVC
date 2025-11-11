<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
성공
<ul>
    <li>id=${member.id}</li>
    <li>username=${member.userName}</li>
    <li>age=${member.age}</li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>


<%--request에 있는 어트리뷰트(Attribute)를 가져오는 부분
여기서 사용된 ${...} 문법은 EL입니다. EL은 기본적으로 다음과 같은 네 가지 영역(Scope)을 순서대로 탐색하며 해당하는 이름을 찾습니다:

pageScope (페이지 영역)

requestScope (리퀘스트 영역)

sessionScope (세션 영역)

applicationScope (애플리케이션 영역)--%>