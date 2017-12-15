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
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.result}" var="vpProjectDetail" varStatus="vs">
            <td>${vs.count + page.offset}</td>
            <td>
                <c:set value="${ fn:split(vpProjectDetail.projectName, ',') }" var="projectIds"/>
                <c:forEach items="${ projectIds }" var="project" varStatus="projectArray">
                    <c:forEach items="${dictProject}" var="dictProject">
                        <c:if test="${project == dictProject.code}">
                            ${dictProject.name}
                            <c:if test="${!projectArray.last}">,</c:if>
                        </c:if>
                    </c:forEach>
                </c:forEach>
            </td>
            <td>${vpProjectDetail.projectManger}</td>
            <td> <c:set value="${ fn:split(vpProjectDetail.projectMember, ',') }" var="projectMember" />
            <c:forEach items="${ projectMember }" var="project"  varStatus="projectArray">
                <c:forEach items="${userList}" var="user">
                    <c:if test="${project == user.id}">
                        ${user.name}
                        <c:if test="${!projectArray.last}">,</c:if>
                    </c:if>
                </c:forEach>
            </c:forEach>
            </td>
            <td>${vpProjectDetail.projectProgress}</td>
            <td>
                <c:forEach items="${address}" var="address">
                    <c:if test="${vpProjectDetail.projectAddress == address.code}">
                        ${address.name}
                    </c:if>
                </c:forEach>
            </td>
            <td>${vpProjectDetail.projectDescribe}</td>
            <td><fmt:formatDate value="${vpProjectDetail.projectStartTime}" pattern="yyyy-MM-dd"/></td>
            <td><fmt:formatDate value="${vpProjectDetail.projectEndTime}" pattern="yyyy-MM-dd"/></td>
            <td>
                <a href="javascript:;" class="btn btn-sm blue"
                   onclick="update('/vpProjectDetail/vpProjectDetail?id=${vpProjectDetail.id}')">
                    <i class="fa fa-edit"></i>编辑
                </a>
                <a href="javascript:;" class="btn btn-sm red"
                   onclick="del('/vpProjectDetail/delete?id=${vpProjectDetail.id}')">
                    <i class="fa fa-trash"></i>删除
                </a>
            </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="pageination-panel">${page}</div>