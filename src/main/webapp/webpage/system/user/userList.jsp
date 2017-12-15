<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="table-scrollable">
	<input id="msg" type="hidden" value="${msg}">
	<table class="table table-striped table-hover table-success">
		<thead>
			<tr>
				<th>编号</th>
				<th>用户名</th>
				<th>姓名</th>
				<th>组织</th>
				<th>电话</th>
				<th>是否转正</th>
				<th>是否在职</th>
				<th>直属上级</th>
				<th>邮箱</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.result }" var="user" varStatus="vs">
			<tr>
				<td>${vs.count + page.offset}</td>
				<td>${user.username}</td>
				<td>${user.name}</td>
				<td>${user.orgName}</td>
				<td>${user.phone}</td>
				<td>
					<c:forEach items="${isPositive}" var="isRotation">
						<c:if test="${user.rotationId == isRotation.code}">
							${isRotation.name}
						</c:if>
					</c:forEach>
				</td>

				<td>
					<c:forEach items="${isWork}" var="isWork">
						<c:if test="${user.isWork == isWork.code}">
							${isWork.name}
						</c:if>
					</c:forEach>
				</td>


				<td>${user.parentName}</td>
				<td>${user.email}</td>
				<td>
					<a href="javascript:;" class="btn btn-sm blue" onclick="update('/user/user?id=${user.id}')">
						<i class="fa fa-edit"></i>编辑
					</a>
					<a href="javascript:;" class="btn btn-sm red" onclick="del('/user/delete?id=${user.id}')">
						<i class="fa fa-trash"></i>删除
					</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="pageination-panel">${page}</div>