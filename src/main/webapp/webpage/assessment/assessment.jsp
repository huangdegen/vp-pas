<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<div class="portlet box green">
    <div class="portlet-title">
        <div class="caption">
            <i class="fa fa-gift"></i>考核评分
        </div>
    </div>
    <div class="portlet-body form">
        <form id="assessmentForm" class="form-horizontal form-bordered" action="/assessment/save" method="post">
            <input type="hidden" id="isCommit" name="isCommit">
            <div class="form-group">
                <label class="col-md-3 control-label">名称:</label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <input type="hidden" name="userId" value="${assessment.userId}">
                        <input type="text" name="userName" readonly="readonly" class="form-control"
                               value="${assessment.userName}"
                               maxlength="32"/>

                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">部门名称:</label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <input type="hidden" name="orgId" value="${assessment.orgId}">
                        <input type="text" name="orgName" readonly="readonly" class="form-control"
                               value="${assessment.orgName}"
                               maxlength="32"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">岗位名称:</label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <input type="hidden" name="roleId" value="${assessment.orgId}">
                        <input type="text" name="roleName" readonly="readonly" class="form-control"
                               value="${assessment.roleName}"
                               maxlength="32"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">是否转正:</label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <input type="hidden" name="rotation" value="${assessment.rotation}">
                        <select  readonly="readonly" disabled="disabled" class="form-control">
                            <option value="">请选择</option>
                            <c:forEach items="${isPositive}" var="isPositive">
                                <option
                                        <c:if test="${isPositive.code == assessment.rotation}">selected</c:if>
                                        value="${isPositive.code}">${isPositive.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">考核月份:</label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <div class="input-group date date-picker-override" data-date-format="yyyy-mm">
                            <input type="text" class="form-control" name="pasMonth" required
                                   value="${assessment.pasMonth}" maxlength="10"/>
                            <span class="input-group-btn">
							<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
							</span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-3 control-label">地址:</label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <select name="address" class="form-control" required>
                            <option value="">请选择</option>
                            <c:forEach items="${address}" var="address">
                                <option
                                        <c:if test="${address.code == assessment.address}">selected</c:if>
                                        value="${address.code}">${address.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>

          <%--  <div class="form-group">
                <label class="col-md-3 control-label">地址:</label>
                <div class="col-md-4">
                    <input type="text" name="address" class="form-control" value="${assessment.address}"
                           maxlength="255" data-validate="required:请输入地址"/>
                </div>
            </div>--%>



            <div class="form-group">
                <label class="col-md-3 control-label">项目名称:</label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <select class="form-control select2" style="padding: 0;" id="projectIds" name="projects"
                                required multiple>
                            <c:forEach items="${dictProject}" var="dictProject">
                                <option
                                        <c:if test="${fn:contains(assessment.projects,dictProject.code)}">selected</c:if>
                                        value="${dictProject.code}">${dictProject.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">本月工作自评:<br/>
                    <span>(按照项目将本月工作列出)</span>
                </label>
                <div class="col-md-4">
                    <textarea type="text" name="monthContent" class="form-control" required
                              maxlength="3000">${assessment.monthContent}</textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">团队协作:<br/>
                    <span>(导师工作/文档/分享/团队组织工作/其他团队反馈意见)</span>
                </label>
                <div class="col-md-4">
                    <textarea type="text" name="teamworkContent" class="form-control" required
                              maxlength="3000">${assessment.teamworkContent}</textarea>
                </div>

            </div>
           <%-- <div class="form-group">
                <label class="col-md-3 control-label">团队评分(满分100分、权重:20%):</label>
                <div class="col-md-4">
                    <input type="text" name="teamScoring" class="form-control" value="${assessment.teamScoring}" required digits="true" range="[0,100]"
                           maxlength="3"/>
                </div>
            </div>--%>
            <div class="form-group">
                <label class="col-md-3 control-label">自评分(满分100分、权重:20%):</label>
                <div class="col-md-4">
                    <input type="text" name="selfScoring" class="form-control" value="${assessment.selfScoring}" required digits="true" range="[0,100]"
                           maxlength="3"/>
                </div>
            </div>
           <%-- <div class="form-group">
                <label class="col-md-3 control-label">领导评分(权重:20%):</label>
                <div class="col-md-4">
                    <input disabled="disabled" type="text" name="leadeScore" class="form-control" value="${assessment.leadeScore}" digits="true" range="[0,100]"
                           maxlength="3"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">综合评分:</label>
                <div class="col-md-4">
                    <input disabled="disabled" type="text" name="comprehensiveScore" class="form-control" digits="true" range="[0,100]"
                           value="${assessment.comprehensiveScore}" maxlength="3"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">评语:</label>
                <div class="col-md-4">
                    <textarea disabled="disabled" type="text" name="comment" class="form-control"
                              maxlength="3000">${assessment.comment}</textarea>
                </div>
            </div>--%>
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
            <input type="hidden" name="id" value="${assessment.id}">
        </form>
    </div>
</div>
<script type="text/javascript" src="<c:url value="/static/custom/datepicker-util.js"></c:url>"></script>
<script src="${webRoot}/static/global/scripts/metronic.js" type="text/javascript"></script>
<script type="text/javascript" src="${webRoot}/static/layer/layer.js"></script>
<script type="text/javascript">
    $(function () {
        $('#assessmentForm').validate();
        // init select2
        $('#projectIds').select2({
            allowClear: true
        });

        //init datepicker
        $('.date-picker-override').datepicker({
            language: 'zh-CN',
            autoclose: true,
            todayHighlight: true,
            format: 'yyyy-mm',
            startView: 'months',
            maxViewMode:'years',
            minViewMode:'months'
        });
    });

    /**
     * 保存
     * @param obj 保存按钮（按钮需要在form表单中）
     */
    function save(obj,isCommit){
        $("#isCommit").val(isCommit);
        if($(obj).closest('form').valid()){
            $.ajax({
                type: 'post',
                url: webRoot+$(obj).closest('form').attr('action'),
                data: $(obj).closest('form').serialize(),
                dataType: 'json',
                success: function(data){
                    if (data.result == 'returnNotNull') {
                        layer.msg('当月只能填写一条考核信息', {icon: 5});
                        return false;
                    }
                    alert(messages[data.result]);
                    search();
                    $(".panel-search").show();
                }
            });
        }
    }
</script>