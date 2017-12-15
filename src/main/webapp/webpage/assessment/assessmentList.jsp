<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<div class="table-scrollable">
    <table class="table table-striped table-hover table-success">
        <thead>
        <tr>
            <th>序号</th>
            <th>名称</th>
            <th>部门名称</th>
            <th>岗位名称</th>
            <th>考核月份</th>
            <th>地址</th>
            <th>是否转正</th>
            <th>项目名称</th>
            <th>团队评分</th>
            <th>自评分</th>
            <th>领导评分</th>
            <th>综合评分</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.result}" var="assessment" varStatus="vs">
            <tr>
                <td>${vs.count + page.offset}</td>
                <td>${assessment.userName}</td>
                <td>${assessment.orgName}</td>
                <td>${assessment.roleName}</td>
                <td>${assessment.pasMonth}</td>

                <td>
                <c:forEach items="${address}" var="address">
                    <c:if test="${assessment.address == address.code}">
                        ${address.name}
                    </c:if>
                </c:forEach>
                </td>
               <%-- ${assessment.address}--%>
                <td>
                <c:forEach items="${isPositive}" var="isRotation">
                    <c:if test="${assessment.rotation == isRotation.code}">
                        ${isRotation.name}
                    </c:if>
                </c:forEach>
                </td>
                <td>
                <c:set value="${ fn:split(assessment.projects, ',') }" var="projectIds" />
                <c:forEach items="${ projectIds }" var="project"  varStatus="projectArray">
                    <c:forEach items="${dictProject}" var="dictProject">
                        <c:if test="${project == dictProject.code}">
                            ${dictProject.name}
                            <c:if test="${!projectArray.last}">,</c:if>
                        </c:if>
                    </c:forEach>
                </c:forEach>
                </td>
                <td>${assessment.teamScoring}</td>
                <td>${assessment.selfScoring}</td>
                <td>${assessment.leadeScore}</td>
                <td>${assessment.comprehensiveScore}</td>
                <td>
                <c:if test="${assessment.isCommit == 0}">
                        <a href="javascript:;" class="btn btn-sm blue"
                           onclick="update('/assessment/assessment?id=${assessment.id}')">
                            <i class="fa fa-edit"></i>编辑
                        </a>
                        <a href="javascript:;" class="btn btn-sm red"
                           onclick="del('/assessment/delete?id=${assessment.id}')">
                            <i class="fa fa-trash"></i>删除
                        </a>
                </c:if>
                 <c:if test="${assessment.isCommit == 1 && fn:substring(assessment.userParentCode,0,fn:length(user.userCode)) == user.userCode}">
                     <a href="javascript:;" class="btn btn-sm blue"
                        onclick="update('/assessment/assessmentScore?id=${assessment.id}')">
                         <i class="fa fa-pencil"></i>评分
                     </a>
                 </c:if>
                 </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="pageination-panel">${page}</div>