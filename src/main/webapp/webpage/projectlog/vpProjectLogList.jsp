<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<div class="table-scrollable">
    <table class="table table-striped table-hover table-success">
        <thead>
        <tr>
            <th>序号</th>
            <th>项目名称</th>
            <th>项目经理</th>
            <th>项目成员</th>
            <th>项目进度</th>
            <th>项目所属地址</th>
            <th>项目描述</th>
            <th>项目起始时间</th>
            <th>项目结束时间</th>
            <th>更改后的经理人</th>
            <th>修改时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.result}" var="vpProjectLog" varStatus="vs">
            <tr>
                <td>${vs.count + page.offset}</td>


                <td>
                    <c:set value="${ fn:split(vpProjectLog.projectName, ',') }" var="projectIds"/>
                    <c:forEach items="${ projectIds }" var="project" varStatus="projectArray">
                        <c:forEach items="${dictProject}" var="dictProject">
                            <c:if test="${project == dictProject.code}">
                                ${dictProject.name}
                                <c:if test="${!projectArray.last}">,</c:if>
                            </c:if>
                        </c:forEach>
                    </c:forEach>
                </td>
                <td>${vpProjectLog.projectManger}</td>


                <td> <c:set value="${ fn:split(vpProjectLog.projectMember, ',') }" var="projectMember" />
                    <c:forEach items="${ projectMember }" var="project"  varStatus="projectArray">
                        <c:forEach items="${userList}" var="user">
                            <c:if test="${project == user.id}">
                                ${user.name}
                                <c:if test="${!projectArray.last}">,</c:if>
                            </c:if>
                        </c:forEach>
                    </c:forEach>
                </td>
                <td>${vpProjectLog.projectProgress}%</td>
                <td>
                    <c:forEach items="${address}" var="address">
                        <c:if test="${vpProjectLog.projectAddress == address.code}">
                            ${address.name}
                        </c:if>
                    </c:forEach>
                </td>
                <td>${vpProjectLog.projectDescribe}</td>
                <td><fmt:formatDate value="${vpProjectLog.projectStartTime}" pattern="yyyy-MM-dd"/></td>
                <td><fmt:formatDate value="${vpProjectLog.projectEndTime}" pattern="yyyy-MM-dd"/></td>
                <td>${vpProjectLog.updateManger}</td>
                <td><fmt:formatDate value="${vpProjectLog.updateDate}" pattern="yyyy-MM-dd"/></td>
                <td>
                    <a href="javascript:;" class="btn btn-sm red"
                       onclick="del('/vpProjectLog/delete?id=${vpProjectLog.id}')">
                        <i class="fa fa-trash"></i>删除
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="pageination-panel">${page}</div>