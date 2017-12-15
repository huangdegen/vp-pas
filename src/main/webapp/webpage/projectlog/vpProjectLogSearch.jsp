<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="col-md-12">
	<div class="panel-search">
	  <form class="form-inline" action="/vpProjectLog/list">
      <div class="form-group">
          <label for="projectManger" class="control-label">项目经理：</label>
          <input type="text" name="projectManger" class="form-control" />
      </div>
      <div class="form-group">
          <label for="updateManger" class="control-label">更改后的经理人：</label>
          <input type="text" name="updateManger" class="form-control" />
      </div>
	  </form>
	  <div class="btn-div">
			<div class="div-right">
				<button type="button" class="btn btn-primary" onclick="search()">
					<i class="fa fa-search"></i> <spring:message code="btn.search"></spring:message>
				</button>
		    <button type="button" class="btn btn-default" onclick="reset()">
		    	<i class="fa fa-repeat"></i> <spring:message code="btn.reset"></spring:message>	
		    </button>
			</div>
		</div>
	</div>
	<div class="panel-content"></div>
</div>
<script type="text/javascript" src="<c:url value="/static/custom/datepicker-util.js"></c:url>"></script>
<script type="text/javascript">
	$(function(){
		search();
	});
</script>