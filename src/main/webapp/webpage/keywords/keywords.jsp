<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="portlet box green">
	<div class="portlet-title">
		<div class="caption">
			<i class="fa fa-gift"></i>关键词过滤
		</div>
  </div>
  <div class="portlet-body form">
  	<form id="keywordsForm" class="form-horizontal form-bordered" action="/keywords/save" method="post">
  		<!-- <div class="form-group" style="display: none;">
        <label class="col-md-3 control-label">ID:</label>
        <div class="col-md-4">
	          <input type="text" name="keywordsId" class="form-control" value="${keywords.keywordsId}"  maxlength="10"/>
        </div>
      </div>
       -->
  		<div class="form-group">
        <label class="col-md-3 control-label">关键词:</label>
        <div class="col-md-4">
	          <input type="text" name="keywordsName" class="form-control" value="${keywords.keywordsName}"  maxlength="20"/>
        </div>
      </div>
      <!--  
  		<div class="form-group" style="display: none;">
        <label class="col-md-3 control-label">时间:</label>
        
        <div class="col-md-4">
	        <div class="input-icon right">
	        	<i class="fa"></i>
	          <div class="input-group date date-picker" data-date-format="yyyy-mm-dd">
							<input type="text" class="form-control" name="keywordsTime" readonly 
								value="<fmt:formatDate value="${keywords.keywordsTime}" pattern="yyyy-MM-dd"/>"  maxlength="11"/>
							<span class="input-group-btn">
							<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
							</span>
						</div>
					</div>
        </div>
        
      </div>
      -->
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
      <input type="hidden" name="keywordsId" value="${keywords.keywordsId}">
  	</form>
  </div>
</div>
<script type="text/javascript" src="<c:url value="/static/custom/datepicker-util.js"></c:url>"></script>
<script type="text/javascript">
	$(function(){
		$('#keywordsForm').validate();
	});
</script>