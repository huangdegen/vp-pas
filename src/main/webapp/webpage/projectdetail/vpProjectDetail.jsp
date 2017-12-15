<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<div class="portlet box green">
    <div class="portlet-title">
        <div class="caption">
            <i class="fa fa-gift"></i>项目详情
        </div>
    </div>
    <div class="portlet-body form">
        <form id="vpProjectDetailForm" class="form-horizontal form-bordered" action="/vpProjectDetail/save"
              method="post">
            <div class="form-group">
                <label class="col-md-3 control-label">项目名称:</label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <select class="form-control select2" style="padding: 0;" id="projectIds" name="projectName"
                                required>
                            <option value="">请选择</option>
                            <c:forEach items="${dictProject}" var="dictProject">
                                <option
                                        <c:if test="${fn:contains(vpProjectDetail.projectName,dictProject.code)}">selected</c:if>
                                        value="${dictProject.code}">${dictProject.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <input type="hidden" name="oldProjectManger" value="${vpProjectDetail.oldProjectManger}">
                <label class="col-md-3 control-label">项目经理:</label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <input type="hidden" id="parentId" name="parentId" value="${vpProjectDetail.parentId}"/>
                        <input type="text" class="form-control" id="projectManger" name="projectManger"
                               onclick="showOrgs()"
                               readonly
                               value="${vpProjectDetail.projectManger}" maxlength="200"/>
                    </div>
                </div>
                <div class="col-md-2">
                    <button type="button" class="btn btn-default" onclick="clearParent()">清空</button>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-3 control-label">项目成员:</label>
                <div class="col-md-4">
                    <select class="form-control select2" style="padding: 0;" id="userName" name="projectMember"
                            multiple>
                        <c:forEach items="${userList}" var="user">
                            <option
                                    <c:if test="${fn:contains(vpProjectDetail.projectMember,user.id)}">selected</c:if>
                                    value="${user.id}">${user.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-3 control-label">项目进度:</label>
                <div class="col-md-4">
                     <input type="text" name="projectProgress" class="form-control" required
                               value="${vpProjectDetail.projectProgress}"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">项目所属地址:</label>
                <div class="col-md-4">
                    <select name="projectAddress" class="form-control" required>
                        <option value="">请选择</option>
                        <c:forEach items="${address}" var="address">
                            <option
                                    <c:if test="${address.code == vpProjectDetail.projectAddress}">selected</c:if>
                                    value="${address.code}">${address.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">项目描述:</label>
                <div class="col-md-4">
                     <textarea type="text" name="projectDescribe" class="form-control" required
                               value="${vpProjectDetail.projectDescribe}"
                               maxlength="3000">${vpProjectDetail.projectDescribe}</textarea>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-3 control-label">项目起始时间:</label>
                <div class="col-md-4">
                    <div class="input-group date date-picker" data-date-format="yyyy-mm-dd">
                        <input type="text" class="form-control" name="projectStartTime" id="form_datetime" readonly
                               value="<fmt:formatDate value="${vpProjectDetail.projectStartTime}" pattern="yyyy-MM-dd"/>"
                               maxlength="11" style="width: 518px;"/>
                        <span class="input-group-btn">
							<button class="btn default" type="button"
                                    style="height: 34px; background-color: ivory"></button>
							</span>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">项目结束时间:</label>
                <div class="col-md-4">
                    <div class="input-group date date-picker" data-date-format="yyyy-mm-dd">
                        <input type="text" class="form-control" name="projectEndTime" id="form_datetimes" readonly
                               value="<fmt:formatDate value="${vpProjectDetail.projectEndTime}" pattern="yyyy-MM-dd"/>"
                               maxlength="11" style="width: 518px;"/>
                        <span class="input-group-btn">
							<button class="btn default" type="button"
                                    style="height: 34px; background-color: ivory"></button>
							</span>
                    </div>
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
            <input type="hidden" name="id" value="${vpProjectDetail.id}">
            <div class="modal fade" id="orgModals" tabindex="-1" role="basic" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                            <h4 class="modal-title">请选择经理</h4>
                        </div>
                        <div class="modal-body">
                            <ul id="orgTrees" class="ztree" style="margin-top:0; width:160px;"></ul>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn blue" onclick="saveParentOrgs()">确定</button>
                            <button type="button" class="btn default" data-dismiss="modal">关闭</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>

<script type="text/javascript" src="<c:url value="/static/custom/datepicker-util.js"></c:url>"></script>
<script type="text/javascript">

    var setting = {
        view: {
            selectedMulti: false
        },
        data: {
            simpleData: {
                enable: true
            }
        }
    };
    $(function () {
        $('#vpProjectDetailForm').validate();
        $('#projectIds').select2({
            allowClear: true
        });
    });

    $('#userName').select2({
        allowClear: true
    });
    // 保存
    function saveParentOrgs() {
        var nodes = $.fn.zTree.getZTreeObj("orgTrees").getSelectedNodes();
        if (nodes[0].id != $('#id').val()) {
            $('#parentId').val(nodes[0].id);
            $('#projectManger').val(nodes[0].name);
            // 隐藏弹窗
            $('#orgModals').modal('hide');
        }
        else {
            alert('不能选择当前组织');
        }
    }


    // 清空
    function clearParent() {
        $('#parentId').val('');
        $('#projectManger').val('');
    }

    // 显示弹窗
    function showOrgs() {
        // 加载用户的树状结构
        $.ajax({
            type: 'post',
            url: '<c:url value="/vpProjectDetail/getOrgForTrees"></c:url>',
            data: {parentId: $('#id').val()},
            dataType: 'json',
            success: function (data) {
                $.fn.zTree.init($("#orgTrees"), setting, data);
            }
        });
        $('#orgModals').modal('show');
    }
</script>