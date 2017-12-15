<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<div class="col-md-12">
    <div class="panel-search">
        <form class="form-inline" action="/user/list">
            <div class="form-group">
                <label class="control-label">用户名：</label>
                <input type="text" class="form-control" name="username">
            </div>
            <div class="form-group">
                <label class="control-label">姓名：</label>
                <input type="text" class="form-control" name="name">
            </div>
            <div class="form-group">
                <label class="control-label">电话：</label>
                <input type="text" class="form-control" name="phone">
            </div>
        </form>
        <div class="btn-div">
            <div class="div-left">
                <button type="button" class="btn btn-warning" onclick="add('/user/user')">
                    <i class="fa fa-plus"></i> <spring:message code="btn.add"></spring:message>
                </button>
            </div>
            <div class="div-left">
                <div id="importBox" class="">
                    <form id="importForm" action="${webRoot}/user/import" method="post" enctype="multipart/form-data"
                          target="hiddenFrame"
                          class="form-search" style="padding-left:20px;text-align:center;"
                          onsubmit="loading('正在导入，请稍等...');">
                        <a href="${webRoot}/webpage/assessment/model.xlsx" target="hiddenFrame"
                           style="margin-left: 550px; position: absolute">下载Excel模板</a>
                        <a href="${webRoot}/webpage/assessment/correspondingEncodingDetails.xlsx" target="hiddenFrame"
                           style="margin-left: 650px; position: absolute">下载对应编码模板</a>
                        <input id="uploadFile" name="file" type="file"
                               style="margin-left: 0px; width:330px;margin-top: 8px;"/>

                    </form>
                </div>
            </div>
            <div class="div-right">
                <input style="margin-right: 1px;" id="btnImportSubmit" class="btn btn-primary" type="button"
                       onclick="importFile()" value="导入"/>
                <%-- <button type="button" class="btn btn-primary" onclick="">
                     <i class="fa  fa-level-down"></i> 导入
                 </button>--%>
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
    <iframe src="about:bland;" id="hiddenFrame" name="hiddenFrame" style="display:none;" frameborder="0"></iframe>
</div>
<script type="text/javascript">
    $(function () {
        search();
    });

    function importFile() {
        var formData = new FormData();
        formData.append("file", $("#uploadFile")[0].files[0]);
        $.ajax({
            url: webRoot + '/user/import',
            type: 'post',
            data: formData,
            // 告诉jQuery不要去处理发送的数据
            processData: false,
            // 告诉jQuery不要去设置Content-Type请求头
            contentType: false,
            dataType: 'html',
            success: function (data) {
                var msg = $(data).find("#msg").val();
                console.log("msg:" + msg)
                if (''!= msg){
                    alert(msg);
                }
                $('.panel-content').html(data);
            }
        });
    }
</script>