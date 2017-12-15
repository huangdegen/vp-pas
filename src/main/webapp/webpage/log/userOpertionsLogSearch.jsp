<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>


<div class="col-md-12">
	<div class="panel-search">
		<form class="form-inline" action="/userOpertionsLog/list">
			<div class="form-group">
				<label for="datetime" class="control-label">时间：</label>
				<!-- 开始时间 -->
				<div class="input-group date date-picker"
					data-date-format="yyyy-mm-dd">
					<input type="text" name="datetimeStart" class="form-control"
						readonly style="width: 100px;" /> <span class="input-group-btn">
						<button class="btn default" type="button">
							<i class="fa fa-calendar"></i>
						</button>
					</span>
				</div>
				<!-- 结束时间 -->
				<div class="input-group date date-picker"
					data-date-format="yyyy-mm-dd">
					<input type="text" name="datetimeEnd" class="form-control" readonly
						style="width: 100px;" /> <span class="input-group-btn">
						<button class="btn default" type="button">
							<i class="fa fa-calendar"></i>
						</button>
					</span>
				</div>
			</div>
			<div class="form-group">
				<label for="ipAddress" class="control-label">IP地址：</label> <input
					type="text" name="ipAddress" class="form-control" />
			</div>
			<div class="form-group">
				<label for="models" class="control-label">模块名：</label> <input
					type="text" name="models" class="form-control" />
			</div>
			<div class="form-group">
				<label for="action" class="control-label">动作：</label> <input
					type="text" name="action" class="form-control" />
			</div>
			<div class="form-group">
				<label for="message" class="control-label">消息：</label> <input
					type="text" name="message" class="form-control" />
			</div>
		</form>
		<div class="btn-div">
			<!-- 
			<div class="div-left">
				<button type="button" class="btn btn-warning" onclick="add('/userOpertionsLog/userOpertionsLog')">
					<i class="fa fa-plus"></i> <spring:message code="btn.add"></spring:message>
				</button>
			</div>
			 -->
			<div class="div-right">
				<button type="button" class="btn btn-primary" onclick="search()">
					<i class="fa fa-search"></i>
					<spring:message code="btn.search"></spring:message>
				</button>
				<button type="button" class="btn btn-default" onclick="reset()">
					<i class="fa fa-repeat"></i>
					<spring:message code="btn.reset"></spring:message>
				</button>
			</div>
		</div>
	</div>
	<div class="panel-content"></div>
</div>
<script type="text/javascript"
	src="<c:url value="/static/custom/datepicker-util.js"></c:url>"></script>
<script type="text/javascript">
	$(function() {
		search();
	});
</script>