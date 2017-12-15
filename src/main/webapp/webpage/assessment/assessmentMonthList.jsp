<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<div class="col-md-12 hide">
    <div class="panel-search">
        <form class="form-inline" id="searchForm" action="/user/statisticsMonth">
        </form>
    </div>
</div>
<div class="panel-content">
    <div class="table-scrollable">
        <input id="msg" type="hidden" value="${msg}">
        <table class="table table-striped table-hover table-success">
            <thead>
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>状态</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.result}" var="user" varStatus="vs">
                <tr>
                    <td>${vs.count + page.offset}</td>
                    <td>${user.name}</td>
                    <td>未提交</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="pageination-panel">${page}</div>
</div>