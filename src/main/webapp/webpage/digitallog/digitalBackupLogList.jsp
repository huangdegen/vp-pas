<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="table-scrollable">
	<table class="table table-striped table-hover table-success">
		<thead>
			<tr>
				<th>序号</th>
								<th>备份时间</th>
				<th>备份地址</th>
				<th>备份名称</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.result}" var="digitalBackupLog" varStatus="vs">
			<tr>
				<td>${vs.count + page.offset}</td>
					<td><fmt:formatDate value="${digitalBackupLog.time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>${digitalBackupLog.storeUrl}</td>
					<td>${digitalBackupLog.fileName}</td>
				<td>
					<a href="javascript:;" class="btn btn-sm red" onclick="del('/digitalBackupLog/delete?id=${digitalBackupLog.id}')">
						<i class="fa fa-trash"></i>删除
					</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="pageination-panel">${page}</div>