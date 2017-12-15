<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="table-scrollable">
	<table class="table table-striped table-hover table-success">
		<thead>
			<tr>
				<th>序号</th>
				<!-- <th style="">accessLogId</th> -->
				<th>访问时间</th>
				<th>用户名</th>
				<th>IP地址</th>
				<th>地址</th>
				<!-- <th>操作</th> -->
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.result}" var="accessLog" varStatus="vs">
			<tr>
				<td>${vs.count + page.offset}</td>
					<%-- <td>${accessLog.accessLogId}</td> --%>
					<td><fmt:formatDate value="${accessLog.accessLogTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>${accessLog.sysUserName}</td>
					<td>${accessLog.accessIp}</td>
					<td>${accessLog.accessUrl}</td>
				<%-- <td>
					<a href="javascript:;" class="btn btn-sm blue" onclick="update('/accessLog/accessLog?accessLogId=${accessLog.accessLogId}')">
						<i class="fa fa-edit"></i>编辑
					</a>
					<a href="javascript:;" class="btn btn-sm red" onclick="del('/accessLog/delete?accessLogId=${accessLog.accessLogId}')">
						<i class="fa fa-trash"></i>删除
					</a>
				</td> --%>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="pageination-panel">${page}</div>