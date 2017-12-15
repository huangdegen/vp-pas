<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="col-md-12">
	<div class="panel-search">
	  <form class="form-inline" action="/keywords/list">
      <!-- <div class="form-group">
          <label for="keywordsId" class="control-label">:</label>
          <input type="text" name="keywordsId" class="form-control" />
      </div> -->
      <div class="form-group">
          <label for="keywordsName" class="control-label">关键词:</label>
          <input type="text" name="keywordsName" class="form-control" />
      </div>
     <!--  <div class="form-group">
          <label for="keywordsTime" class="control-label">时间：</label>
          <input type="text" name="keywordsTimeStart" class="form-control" style="width:100px;"/> -
          <input type="text" name="keywordsTimeEnd" class="form-control" style="width:100px;"/>
      </div> -->
	  </form>
	  <div class="btn-div">
			<div class="div-left">
				<button type="button" class="btn btn-warning" onclick="add('/keywords/keywords')">
					<i class="fa fa-plus"></i> <spring:message code="btn.add"></spring:message>
				</button>
			</div>
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