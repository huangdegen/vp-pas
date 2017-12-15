<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<div class="portlet box green">
    <div class="portlet-title">
        <div class="caption">
            <i class="fa fa-gift"></i>工时填报
        </div>
    </div>
    <div class="portlet-body form">
        <form id="vpReportingForm" class="form-horizontal form-bordered" action="" method="post">
            <input type="hidden" id="isCommit" name="isCommit">
            <div class="form-group">
                <label class="col-md-3 control-label">用户名称:</label>
                <div class="col-md-4">
                    <input type="hidden" name="userId" value="${vpReporting.userId}">
                    <input type="text" name="reportingName" class="form-control" readonly="readonly"
                           value="${vpReporting.reportingName}"
                           maxlength="255"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">填报日期:</label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <div class="input-group date date-picker" data-date-format="yyyy-mm-dd">
                            <input disabled type="text" class="form-control" name="reportingDate" readonly
                                   value="<fmt:formatDate value="${vpReporting.reportingDate}" pattern="yyyy-MM-dd"/>"
                                   maxlength="11"/>
                            <span class="input-group-btn">
							<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
							</span>
                        </div>
                    </div>
                </div>
            </div>


            <div class="form-group">
                <label class="col-md-3 control-label">开始时间:</label>
                <div class="col-md-4">
                    <%--<select readonly="readonly" disabled name="startTime" class="form-control">
                        <option value="">请选择</option>
                        <c:forEach items="${dictTime}" var="dictTime">
                            <option value="${dictTime.code}">${dictTime.name}</option>
                        </c:forEach>
                    </select>--%>
                     <input type="text" name="startTime" class="form-control" readonly="readonly"
                            value="${vpReporting.startTime}"
                            maxlength="255"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">结束时间:</label>
                <div class="col-md-4">
                   <%-- <select readonly="readonly" disabled name="endTime" class="form-control">
                        <option value="">请选择</option>
                        <c:forEach items="${dictTime}" var="dictTime">
                            <option
                                    <c:if test="${dictTime.code == dictTime.time}">selected</c:if>
                                    value="${dictTime.code}">${dictTime.name}</option>
                        </c:forEach>
                    </select>--%>
                    <input type="text" name="endTime" class="form-control" readonly="readonly"
                           value="${vpReporting.endTime}"
                           maxlength="255"/>
                </div>
            </div>


            <div class="form-group">
                <label class="col-md-3 control-label">项目名称:</label>
                <div class="col-md-4">

                    <select disabled class="form-control select2" style="padding: 0;" id="projectIds"
                            name="reportingProject"
                            required multiple>
                        <c:forEach items="${dictProject}" var="dictProject">
                            <option readonly="readonly"
                                    <c:if test="${fn:contains(vpReporting.reportingProject,dictProject.code)}">selected</c:if>
                                    value="${dictProject.code}">${dictProject.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">工作内容:</label>
                <div class="col-md-4">
                    <textarea type="text" name="reportingContent" class="form-control" readonly="readonly"
                              value="${vpReporting.reportingContent}"
                              maxlength="3000">${vpReporting.reportingContent}</textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">工作时长(小时):</label>
                <div class="col-md-4">
                    <input type="text" name="reportingTime" class="form-control" value="${vpReporting.reportingTime}"
                           readonly="readonly"
                           maxlength="10"/>
                </div>
            </div>
            <div class="form-actions">
                <div class="col-md-9 col-md-offset-3">
                    <button type="reset" class="btn btn-default" onclick="cancel()">
                        <spring:message code="btn.return"></spring:message>
                    </button>
                </div>
            </div>
            <input type="hidden" name="id" value="${vpReporting.id}">
        </form>
    </div>
</div>
<script type="text/javascript" src="<c:url value="/static/custom/datepicker-util.js"></c:url>"></script>
<script type="text/javascript" src="${webRoot}/static/layer/layer.js"></script>
<script type="text/javascript">
    $(function () {
        $('#vpReportingForm').validate();

        $('#projectIds').select2({
            allowClear: true
        });
    });
</script>