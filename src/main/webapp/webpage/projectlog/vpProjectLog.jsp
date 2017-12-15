<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="portlet box green">
	<div class="portlet-title">
		<div class="caption">
			<i class="fa fa-gift"></i>项目管理日志
		</div>
  </div>
  <div class="portlet-body form">
  	<form id="vpProjectLogForm" class="form-horizontal form-bordered" action="/vpProjectLog/save" method="post">
  		<div class="form-group">
        <label class="col-md-3 control-label">项目名称:</label>
        <div class="col-md-4">
	          <input type="text" name="projectName" class="form-control" value="${vpProjectLog.projectName}"  maxlength="255"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">项目经理:</label>
        <div class="col-md-4">
	          <input type="text" name="projectManger" class="form-control" value="${vpProjectLog.projectManger}"  maxlength="255"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">项目成员:</label>
        <div class="col-md-4">
	          <input type="text" name="projectMember" class="form-control" value="${vpProjectLog.projectMember}"  maxlength="255"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">项目所属地址:</label>
        <div class="col-md-4">
	          <input type="text" name="projectAddress" class="form-control" value="${vpProjectLog.projectAddress}"  maxlength="255"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">项目描述:</label>
        <div class="col-md-4">
	          <input type="text" name="projectDescribe" class="form-control" value="${vpProjectLog.projectDescribe}"  maxlength="3,000"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">项目起始时间:</label>
        <div class="col-md-4">
	          <input type="text" name="projectStartTime" class="form-control" value="${vpProjectLog.projectStartTime}"  maxlength=""/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">项目结束时间:</label>
        <div class="col-md-4">
	          <input type="text" name="projectEndTime" class="form-control" value="${vpProjectLog.projectEndTime}"  maxlength=""/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">项目进度:</label>
        <div class="col-md-4">
	          <input type="text" name="projectProgress" class="form-control" value="${vpProjectLog.projectProgress}"  maxlength="10"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">更改后的经理人:</label>
        <div class="col-md-4">
	          <input type="text" name="updateManger" class="form-control" value="${vpProjectLog.updateManger}"  maxlength="255"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">修改时间:</label>
        <div class="col-md-4">
	          <input type="text" name="updateDate" class="form-control" value="${vpProjectLog.updateDate}"  maxlength=""/>
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
      <input type="hidden" name="id" value="${vpProjectLog.id}">
  	</form>
  </div>
</div>
<script type="text/javascript" src="<c:url value="/static/custom/datepicker-util.js"></c:url>"></script>
<script type="text/javascript">
	$(function(){
		$('#vpProjectLogForm').validate();
	});
</script>