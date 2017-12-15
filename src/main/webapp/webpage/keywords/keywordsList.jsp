<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="table-scrollable">
	<table class="table table-striped table-hover table-success">
		<thead>
			<tr>
				<th>序号</th>
				<!-- <th>ID</th> -->
				<th>关键词</th>
				<th>时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.result}" var="keywords" varStatus="vs">
			<tr>
				<td>${vs.count + page.offset}</td>
					<!-- <td>${keywords.keywordsId}</td> -->
					<td>${keywords.keywordsName}</td>
					<td><fmt:formatDate value="${keywords.keywordsTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>
					<a href="javascript:;" class="btn btn-sm blue" onclick="update('/keywords/keywords?keywordsId=${keywords.keywordsId}')">
						<i class="fa fa-edit"></i>编辑
					</a>
					<a href="javascript:;" class="btn btn-sm red" onclick="del('/keywords/delete?keywordsId=${keywords.keywordsId}')">
						<i class="fa fa-trash"></i>删除
					</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="pageination-panel">${page}</div>