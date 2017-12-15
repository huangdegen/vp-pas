<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<div class="table-scrollable">
    <table class="table table-striped table-hover table-success">
        <thead>
        <tr>
            <th>序号</th>
            <th>用户名称</th>
            <th>部门名称</th>
            <th>填报日期</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>项目名称</th>
            <th>工作时长(小时)</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.result}" var="vpReporting" varStatus="vs">
            <tr>
                <td>${vs.count + page.offset}</td>
                <td>${vpReporting.reportingName}</td>
                <td>${vpReporting.orgName}</td>
                <td><fmt:formatDate value="${vpReporting.reportingDate}" pattern="yyyy-MM-dd"/></td>
                <td>${vpReporting.startTime}</td>
                <td>${vpReporting.endTime}</td>
                <td>
                    <c:set value="${ fn:split(vpReporting.reportingProject, ',') }" var="projectIds"/>
                    <c:forEach items="${ projectIds }" var="project" varStatus="projectArray">
                        <c:forEach items="${dictProject}" var="dictProject">
                            <c:if test="${project == dictProject.code}">
                                ${dictProject.name}
                                <c:if test="${!projectArray.last}">,</c:if>
                            </c:if>
                        </c:forEach>
                    </c:forEach>
                </td>
                <td>${vpReporting.reportingTime}h</td>
                <td>
                    <a href="javascript:;" class="btn btn-sm blue"
                       onclick="update('/vpReportings/vpReportingDetails?id=${vpReporting.id}')">
                        <i class="fa fa-edit"></i>详情
                    </a>
                    <c:if test="${vpReporting.isCommit == 0}">
                    <a href="javascript:;" class="btn btn-sm blue"
                       onclick="update('/vpReportings/vpReporting?id=${vpReporting.id}')">
                        <i class="fa fa-edit"></i>编辑
                    </a>

                    <a href="javascript:;" class="btn btn-sm red"
                       onclick="del('/vpReportings/delete?id=${vpReporting.id}')">
                        <i class="fa fa-trash"></i>删除
                    </a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="pageination-panel">${page}</div>