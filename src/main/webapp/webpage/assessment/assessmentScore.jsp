<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<div class="portlet box green">
    <div class="portlet-title">
        <div class="caption">
            <i class="fa fa-gift"></i>评分
        </div>
    </div>
    <div class="portlet-body form">
        <form id="assessmentForm" class="form-horizontal form-bordered" action="/assessment/saveScore" method="post">
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
                        <select disabled="disabled" disabled="disabled" class="form-control">
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
                            <input disabled="disabled" type="text" readonly="readonly" class="form-control"
                                   name="pasMonth" required
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
                    <input readonly="readonly" type="text" name="address" class="form-control"
                           value="${assessment.address}"
                           maxlength="255" data-validate="required:请输入地址"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">项目名称:</label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <select disabled="disabled" class="form-control select2" style="padding: 0;" id="projectIds"
                                name="projects"
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
                    <span>(按照项目将本月工作列出权重)</span>
                </label>
                <div class="col-md-4">
                    <textarea readonly="readonly" type="text" name="monthContent" class="form-control" required
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
            <div class="form-group">
                <label class="col-md-3 control-label">团队评分(满分100分、权重:20%):</label>
                <div class="col-md-4">
                    <input type="text" name="teamScoring" id="teamScoring" class="form-control"
                           onkeyup="fillB()"
                           value="${assessment.teamScoring}" required digits="true" range="[0,100]"
                           maxlength="3"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">自评分(满分100分、权重:20%):</label>
                <div class="col-md-4">
                    <input readonly="readonly" type="text" id="selfScoring" name="selfScoring" class="form-control"
                           onkeyup="fillB()"
                           value="${assessment.selfScoring}" required digits="true" range="[0,100]"
                           maxlength="3"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">领导评分(满分100分、权重:60%):</label>
                <div class="col-md-4">
                    <input type="text" name="leadeScore" id="leadeScore" class="form-control" onkeyup="fillB()"
                           value="${assessment.leadeScore}" digits="true" range="[0,100]"
                           maxlength="3"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">综合评分:</label>
                <div class="col-md-4">
                    <input readonly="readonly" type="text" id="comprehensiveScore" name="comprehensiveScore"
                           class="form-control" number="true"
                           value="${assessment.comprehensiveScore}"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">评语:</label>
                <div class="col-md-4">
                    <textarea type="text" name="comment" class="form-control"
                              maxlength="3000">${assessment.comment}</textarea>
                </div>
            </div>
            <div class="form-actions">
                <div class="col-md-9 col-md-offset-3">
                    <button type="button" class="btn btn-primary" onclick="save(this)">
                        评分
                    </button>
                    <button type="reset" class="btn btn-default"  onclick="cancel()">
                        <spring:message code="btn.return"></spring:message>
                    </button>
                </div>
            </div>
            <input type="hidden" name="id" value="${assessment.id}">

        </form>
    </div>
</div>
<script type="text/javascript" src="<c:url value="/static/custom/datepicker-util.js"></c:url>"></script>
<script type="text/javascript">

    function fillB() {
        var teamScoring = document.getElementById("teamScoring").value    //团队评分
        var selfScoring = document.getElementById("selfScoring").value    //自评分
        var leadeScore = document.getElementById("leadeScore").value      //领导评分
        var comprehensiveScore = document.getElementById("comprehensiveScore").value
        if (leadeScore == '') {
            $("#comprehensiveScore").val("");
        }
        if (leadeScore != '') {
            var comprehensiveScore = parseInt(teamScoring) * 0.2 + parseInt(selfScoring) * 0.2 + parseInt(leadeScore) * 0.6;
            $("#comprehensiveScore").val(comprehensiveScore.toFixed(2));

        }
    }
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
            maxViewMode: 'years',
            minViewMode: 'months'
        });
    });

    /**
     * 保存
     * @param obj 保存按钮（按钮需要在form表单中）
     */
    function save(obj) {
        if ($(obj).closest('form').valid()) {
            $.ajax({
                type: 'post',
                url: webRoot + $(obj).closest('form').attr('action'),
                data: $(obj).closest('form').serialize(),
                dataType: 'json',
                success: function (data) {
                    alert(messages[data.result]);
                    search();
                    $(".panel-search").show();
                }
            });
        }
    }
</script>