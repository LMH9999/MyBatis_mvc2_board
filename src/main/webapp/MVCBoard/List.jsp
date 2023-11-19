<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<table border="1" width="90%">--%>
<%--    <c:choose>--%>
<%--        <c:when test="${empty boardLists}">--%>
<%--            <tr>--%>
<%--                <td colspan="6" align="center">등록된 게시물이 없습니다^^*</td>--%>
<%--            </tr>--%>
<%--        </c:when>--%>
<%--        <c:otherwise>--%>
<%--            <h5>등록된 게시물 개수 : ${totalCount}</h5>--%>
<%--            <c:forEach items="${boardLists}" var="row" varStatus="loop">--%>
<%--                <tr align="center">--%>
<%--                    <td align="left">--%>
<%--                        <a href="../mvcboard/view.do?idx=${row.idx}">${row.title}</a>--%>
<%--                    </td>--%>
<%--                    <td>${row.name}</td>--%>
<%--                    <td>${row.visitcount}</td>--%>
<%--                    <td>${row.postdate}</td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
<%--        </c:otherwise>--%>
<%--    </c:choose>--%>
<%--</table>--%>

<table border="1" width="90%">
    <tr>
        <th width="10%">번호</th>
        <th width="*">제목</th>
        <th width="15%">작성자</th>
        <th width="10%">조회수</th>
        <th width="15%">작성일</th>
        <th width="8%">첨부</th>
    </tr>
    <c:choose>
        <c:when test="${empty boardLists}">
            <tr>
                <td colspan="6" align="center">등록된 게시물이 없습니다^^*</td>
            </tr>
        </c:when>
        <c:otherwise>
            <h5>등록된 게시물 개수 : ${requestScope.pageMaker.totalCount}</h5>
            <c:set var="no" value="${pageMaker.totalCount - ((pageMaker.cri.pageNum - 1) * 10)}" />
            <c:forEach items="${boardLists}" var="row" varStatus="loop">
                <tr align="center">
                    <td>
                            ${no}
                    </td>
                    <td align="left">
                        <a href="../mvcboard/view.do?idx=${row.idx}">${row.title}</a>
                    </td>
                    <td>${row.name}</td>
                    <td>${row.visitcount}</td>
                    <td>${row.postdate}</td>
                    <td>
                            <%--                            첨부 파일--%>
                        <c:if test="${not empty row.ofile}">
                            <a href="../mvcboard/download.do?ofile=${row.ofile}&sfile=${row.sfile}&idx=${row.idx}">
                                [Down]</a>
                        </c:if>
                    </td>
                </tr>
                <c:set var="no" value="${no - 1}" />
            </c:forEach>
        </c:otherwise>
    </c:choose>
</table>

<c:if test="${requestScope.pageMaker.totalCount > 0 and not empty boardLists}">
    <br><br>
    <div class="container">
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <c:if test="${pageMaker.prev}">
                    <li class="page-item"><a class="page-link" href="${pageMaker.startPage - 1}">이전</a></li>
                </c:if>
                <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                    <c:choose>
                        <c:when test="${pageMaker.cri.pageNum == num}">
                            <a href="../mvcboard/list.do?pageNum=${num}"> ${num}</a>
                        </c:when>
                        <c:otherwise>
                            <a href="../mvcboard/list.do?pageNum=${num}"> ${num}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:if test="${pageMaker.next}">
                    <li class="page-item"><a class="page-link" href="${pageMaker.endPage + 1}">다음</a></li>
                </c:if>
            </ul>
        </nav>
    </div>
</c:if>

</body>
</html>
