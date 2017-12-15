<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<div class="portlet box green">
    <div class="portlet-title">
        <div class="caption">
            <i class="fa fa-gift"></i>修改用户密码
        </div>
    </div>
    <div class="portlet-body form">
        <form id="updateUserPasswordForm" class="form-horizontal form-bordered" action="/user/updateUserPassword"
              method="post">
            <div class="form-group">
                <label class="col-md-3 control-label">新密码:</label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <input type="password" name="password" password="true" required class="form-control" value=""
                               maxlength="32"/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-3 control-label">确认新密码:</label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <input type="password" name="newPassword" password="true" required class="form-control" value=""
                               maxlength="32"/>
                    </div>
                </div>
            </div>
            <div class="form-actions">
                <div class="col-md-9 col-md-offset-3">
                    <button type="button" class="btn btn-primary" onclick="updateUserPassword(this)">
                        <spring:message code="btn.save"></spring:message>
                    </button>
                    <button type="reset" class="btn btn-default" onclick="cancelUserPassword()">
                        <spring:message code="btn.return"></spring:message>
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript" src="<c:url value="/static/custom/datepicker-util.js"></c:url>"></script>
<script type="text/javascript">
    $(function () {
        $('#updateUserPasswordForm').validate();
    });

    function cancel() {
        self.location = document.referrer;
        alert(document.referrer);
    }

    /**
     * 修改
     * @param obj 修改成功跳转登录页面
     */
    function updateUserPassword(obj) {
        if ($(obj).closest('form').valid()) {
            $.ajax({
                type: 'post',
                url: webRoot + $(obj).closest('form').attr('action'),
                data: $(obj).closest('form').serialize(),
                dataType: 'json',
                success: function (data) {
                    alert(messages[data.result]);
                    if ("save_success" == data.result) {
                        self.location = webRoot + "/login/logout";
                    }
                }
            });
        }
    }

    /**
     *返回首页
     */
    function cancelUserPassword() {
        self.location = webRoot + "/index";
    }

</script>