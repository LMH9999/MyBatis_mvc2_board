<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" width="90%">
    <c:choose>
        <c:when test="${empty boardLists}">
            <tr>
                <td colspan="6" align="center">등록된 게시물이 없습니다^^*</td>
            </tr>
        </c:when>
        <c:otherwise>
            <h5>등록된 게시물 개수 : ${totalCount}</h5>
            <c:forEach items="${boardLists}" var="row" varStatus="loop">
                <tr align="center">
                    <td align="left">
                        <a href="../mvcboard/view.do?idx=${row.idx}">${row.title}</a>
                    </td>
                    <td>${row.name}</td>
                    <td>${row.visitcount}</td>
                    <td>${row.postdate}</td>
                </tr>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</table>

</body>
</html>
