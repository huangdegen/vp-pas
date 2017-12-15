<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="portlet box green">
	<div class="portlet-title">
		<div class="caption">
			<i class="fa fa-gift"></i>访问日志
		</div>
  </div>
  <div class="portlet-body form">
  	<form id="accessLogForm" class="form-horizontal form-bordered" action="/accessLog/save" method="post">
  		<div class="form-group">
        <label class="col-md-3 control-label">accessLogId:</label>
        <div class="col-md-4">
	          <input type="text" name="accessLogId" class="form-control" value="${accessLog.accessLogId}"  maxlength="10"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">访问时间:</label>
        <div class="col-md-4">
	          <input type="text" name="accessLogTime" class="form-control" value="${accessLog.accessLogTime}"  maxlength=""/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">用户名:</label>
        <div class="col-md-4">
	          <input type="text" name="userId" class="form-control" value="${accessLog.userId}"  maxlength="32"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">IP地址:</label>
        <div class="col-md-4">
	          <input type="text" name="accessIp" class="form-control" value="${accessLog.accessIp}"  maxlength="15"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">地址:</label>
        <div class="col-md-4">
	          <input type="text" name="accessUrl" class="form-control" value="${accessLog.accessUrl}"  maxlength="255"/>
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
      <input type="hidden" name="accessLogId" value="${accessLog.accessLogId}">
  	</form>
  </div>
</div>
<script type="text/javascript" src="<c:url value="/static/custom/datepicker-util.js"></c:url>"></script>
<script type="text/javascript">
	$(function(){
		$('#accessLogForm').validate();
	});
</script>