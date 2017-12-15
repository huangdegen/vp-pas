<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="portlet box green">
	<div class="portlet-title">
		<div class="caption">
			<i class="fa fa-gift"></i>数据库备份日志
		</div>
  </div>
  <div class="portlet-body form">
  	<form id="digitalBackupLogForm" class="form-horizontal form-bordered" action="/digitalBackupLog/save" method="post">
  		<div class="form-group">
        <label class="col-md-3 control-label">time:</label>
        <div class="col-md-4">
	          <input type="text" name="time" class="form-control" value="${digitalBackupLog.time}"  maxlength=""/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">storeUrl:</label>
        <div class="col-md-4">
	          <input type="text" name="storeUrl" class="form-control" value="${digitalBackupLog.storeUrl}"  maxlength="255"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">fileName:</label>
        <div class="col-md-4">
	          <input type="text" name="fileName" class="form-control" value="${digitalBackupLog.fileName}"  maxlength="255"/>
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
      <input type="hidden" name="id" value="${digitalBackupLog.id}">
  	</form>
  </div>
</div>
<script type="text/javascript" src="<c:url value="/static/custom/datepicker-util.js"></c:url>"></script>
<script type="text/javascript">
	$(function(){
		$('#digitalBackupLogForm').validate();
	});
</script>