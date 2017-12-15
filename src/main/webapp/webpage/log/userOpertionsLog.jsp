<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="portlet box green">
	<div class="portlet-title">
		<div class="caption">
			<i class="fa fa-gift"></i>审计日志
		</div>
  </div>
  <div class="portlet-body form">
  	<form id="userOpertionsLogForm" class="form-horizontal form-bordered" action="/userOpertionsLog/save" method="post">
  		<div class="form-group">
        <label class="col-md-3 control-label">datetime:</label>
        <div class="col-md-4">
	        <div class="input-icon right">
	        	<i class="fa"></i>
	          <div class="input-group date date-picker" data-date-format="yyyy-mm-dd HH:mm:ss">
							<input type="text" class="form-control" name="datetime" readonly 
								value="<fmt:formatDate value="${userOpertionsLog.datetime}" pattern="yyyy-MM-dd HH:mm:ss"/>"  maxlength="11"/>
							<span class="input-group-btn">
							<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
							</span>
						</div>
					</div>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">用户:</label>
        <div class="col-md-4">
	          <input type="text" name="userId" class="form-control" value="${userOpertionsLog.sysUser.name}"  maxlength="10"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">IP地址:</label>
        <div class="col-md-4">
	          <input type="text" name="ipAddress" class="form-control" value="${userOpertionsLog.ipAddress}"  maxlength="15"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">模块名:</label>
        <div class="col-md-4">
	          <input type="text" name="models" class="form-control" value="${userOpertionsLog.models}"  maxlength="255"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">动作:</label>
        <div class="col-md-4">
	          <input type="text" name="action" class="form-control" value="${userOpertionsLog.action}"  maxlength="255"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">结果:</label>
        <div class="col-md-4">
	          <input type="text" name="result" class="form-control" value="${userOpertionsLog.result}"  maxlength="10"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">消息:</label>
        <div class="col-md-4">
	          <input type="text" name="message" class="form-control" value="${userOpertionsLog.message}"  maxlength="255"/>
        </div>
      </div>
      <div class="form-actions">
        <div class="col-md-9 col-md-offset-3">
          <button type="button" class="btn btn-primary" onclick="save(this)">
          	<spring:message code="btn.save"></spring:message>
          </button>
          <button type="reset" class="btn btn-default" onclick="cancel()">
          	<spring:message code="btn.return"></spring:message>
          </button>
        </div>
      </div>
      <input type="hidden" name="id" value="${userOpertionsLog.id}">
  	</form>
  </div>
</div>
<script type="text/javascript" src="<c:url value="/static/custom/datepicker-util.js"></c:url>"></script>
<script type="text/javascript">
	$(function(){
		$('#userOpertionsLogForm').validate();
	});
</script>