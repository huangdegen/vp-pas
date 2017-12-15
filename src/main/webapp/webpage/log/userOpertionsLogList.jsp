<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="table-scrollable">
	<table class="table table-striped table-hover table-success">
		<thead>
			<tr>
				<th>序号</th>
				<th>时间</th>
				<th>用户</th>
				<th>IP地址</th>
				<th>模块名</th>
				<th>动作</th>
				<th>结果</th>
				<th>消息</th>
				<!-- <th>操作</th> -->
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.result}" var="userOpertionsLog" varStatus="vs">
			<tr>
				<td>${vs.count + page.offset}</td>
					<td><fmt:formatDate value="${userOpertionsLog.datetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>${userOpertionsLog.sysUserName}</td>
					<td>${userOpertionsLog.ipAddress}</td>
					<td>${userOpertionsLog.models}</td>
					<td>${userOpertionsLog.action}</td>
					<td><c:if test="${userOpertionsLog.result==1}">成功</c:if><c:if test="${userOpertionsLog.result==2}">失败</c:if></td>
					<td>${userOpertionsLog.message}</td>
				<!-- 
				<td>
					<a href="javascript:;" class="btn btn-sm blue" onclick="update('/userOpertionsLog/userOpertionsLog?id=${userOpertionsLog.id}')">
						<i class="fa fa-edit"></i>编辑
					</a>
					<a href="javascript:;" class="btn btn-sm red" onclick="del('/userOpertionsLog/delete?id=${userOpertionsLog.id}')">
						<i class="fa fa-trash"></i>删除
					</a>
				</td>
				 -->
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="pageination-panel">${page}</div>