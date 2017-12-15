<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<div class="portlet box green">
    <div class="portlet-title">
        <div class="caption">
            <i class="fa fa-gift"></i>工时填报
        </div>
    </div>
    <div class="portlet-body form">
        <form id="vpReportingForm" class="form-horizontal form-bordered" action="/vpReportings/save" method="post">
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
                            <input type="text" class="form-control" name="reportingDate" id="form_datetime" readonly
                                   value="<fmt:formatDate value="${vpReporting.reportingDate}" pattern="yyyy-MM-dd"/>"
                                   maxlength="11" style="width: 518px;"/>
                            <span class="input-group-btn">
							<button class="btn default" type="button" style="height: 34px; background-color: ivory" ></button>
							</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">开始时间:</label>
                <div class="col-md-4">
                    <select required name="startTime" class="form-control" id="startTime">
                        <option value="">请选择</option>
                        <c:forEach items="${dictTime}" var="dictTime">
                            <option
                                    <c:if test="${dictTime.code == vpReporting.startTime}">selected</c:if>
                                    value="${dictTime.code}">${dictTime.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">结束时间:</label>
                <div class="col-md-4">
                    <select required name="endTime" class="form-control" id="endTime">
                        <option value="">请选择</option>
                        <c:forEach items="${dictTime}" var="dictTime">
                            <option
                                    <c:if test="${dictTime.code == vpReporting.endTime}">selected</c:if>
                                    value="${dictTime.code}">${dictTime.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">部门名称:</label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <input type="hidden" name="orgId" value="${vpReporting.orgId}">
                        <input type="text" name="orgName" readonly="readonly" class="form-control"
                               value="${vpReporting.orgName}"
                               maxlength="32"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">项目名称:</label>
                <div class="col-md-4">

                    <select class="form-control select2" style="padding: 0;" id="projectIds" name="reportingProject"
                            required>
                        <c:forEach items="${dictProject}" var="dictProject">
                            <option
                                    <c:if test="${fn:contains(vpReporting.reportingProject,dictProject.code)}">selected</c:if>
                                    value="${dictProject.code}">${dictProject.name}</option>
                        </c:forEach>
                    </select>
                    <%--<input type="text" name="reportingProject" class="form-control"
                           value="${vpReporting.reportingProject}" maxlength="255"/>--%>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">工作内容:</label>
                <div class="col-md-4">
                    <textarea type="text" name="reportingContent" class="form-control" required
                              value="${vpReporting.reportingContent}"
                              maxlength="3000">${vpReporting.reportingContent}</textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">工作时长(小时):</label>
                <div class="col-md-4">
                    <input type="text" name="reportingTime" class="form-control" id="reportingTime" required
                           value="${vpReporting.reportingTime}"
                           maxlength="10"/>
                </div>
            </div>
            <div class="form-actions">
                <div class="col-md-9 col-md-offset-3">
                    <button type="button" class="btn btn-primary" onclick="save(this,'0')">
                        <spring:message code="btn.isCommit"></spring:message>
                    </button>
                    <button type="button" class="btn btn-primary" onclick="save(this,'1')">
                        <spring:message code="btn.save"></spring:message>
                    </button>
                    <button type="reset" class="btn btn-default" onclick="cancel()">
                        <spring:message code="btn.return"></spring:message>
                    </button>
                </div>
                <p><font color="red"><span style="margin-left: 440px;">提交后,不能进行修改、删除</span></font></p>
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
            allowClear: true,
            maximumSelectionLength: 1 //最多能够选择的个数
        });
    });

    /**
     * 保存
     * @param obj 保存按钮（按钮需要在form表单中）
     */
    function save(obj, isCommit) {
        $("#isCommit").val(isCommit);
        if ($(obj).closest('form').valid()) {
            $.ajax({
                type: 'post',
                url: webRoot + $(obj).closest('form').attr('action'),
                data: $(obj).closest('form').serialize(),
                dataType: 'json',
                success: function (data) {
                    if (data.result == 'notReportingTime') {
                        layer.msg('工时不能超过8小时', {icon: 5});
                        return false;
                    }
                    if (data.result == 'countReportingTime') {
                        layer.msg('一天总工时不能超过8小时', {icon: 5});
                        return false;
                    }
                    search();
                    $(".panel-search").show();
                },
                error: function (e) {
                    return false;
                }


            });
        }
    }

    $('#form_datetime').datepicker({
        format: 'yyyy-mm-dd',
        weekStart: 1,
        endDate: new Date(),//结束时间，在这时间之后都不可选
        autoclose: true,
        todayBtn: 'linked',
        language: 'zh-CN'
    });
</script>