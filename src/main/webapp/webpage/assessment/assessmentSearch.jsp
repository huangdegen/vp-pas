<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<div class="col-md-12">
    <div class="panel-search">
        <form class="form-inline" id="searchForm" action="/assessment/list">
            <div class="form-group">
                <label for="userName" class="control-label">名称：</label>
                <input type="hidden" name="userId" value="${assessment.userId}">
                <input type="text" name="userName" class="form-control"
                       value="${assessment.userName}"
                       maxlength="32"/>
            </div>
            <div class="form-group">
                <label for="orgName" class="control-label">部门名称：</label>
                <input type="hidden" id="orgId" name="orgId" value="${assessment.orgId}"/>
                <input type="text" class="form-control" id="orgName" name="orgName" required onclick="showOrg()"
                       required readonly value="${assessment.orgName}">
            </div>
            <%-- <div class="form-group">
                 <label for="roleName" class="control-label">岗位名称：</label>

                 <input type="hidden" name="roleId" value="${assessment.orgId}">
                 <input type="text" name="roleName"  class="form-control"
                        value="${assessment.roleName}"
                        maxlength="32"/>

                 &lt;%&ndash;<select name="roleName" class="form-control">
                     <option value="">全部</option>
                     <option value="1">Option 1</option>
                     <option value="2">Option 2</option>
                 </select>&ndash;%&gt;
             </div>--%>

            <%
                Calendar c = Calendar.getInstance();
                c.add(Calendar.MONTH, -1);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
                String preMonth = dateFormat.format(c.getTime());
            %>
            <div class="form-group date date-picker-override" data-date-format="yyyy-mm">
                <label for="pasMonth" class="control-label">考核月份：</label>

                <input type="text" name="pasMonth" id="pasMonth" class="form-control" required maxlength="10"/>
                <input type="hidden" id="dfpasMonth" value="<%=preMonth%>" />
                <button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
            </div>

            <%-- <div class="form-group">
                 <label for="address" class="control-label">地址：</label>
                 <input type="text" name="address" class="form-control"/>
             </div>--%>
            <div class="form-group">
                <label for="projects" class="control-label">项目名称：</label>
                <select class="form-control select2" style="padding: 0;width: 180px;" id="projects" name="projects"
                        required>
                    <option value="">--请选择--</option>
                    <c:forEach items="${dictProject}" var="dictProjects">
                        <option value="${dictProjects.code}">${dictProjects.name}</option>
                    </c:forEach>
                </select>
            </div>

        </form>
        <div class="btn-div">
            <div class="div-left">
                <button type="button" class="btn btn-warning" onclick="add('/assessment/assessment')">
                    <i class="fa fa-plus"></i> <spring:message code="btn.add"></spring:message>
                </button>
            </div>
            <div class="div-right">
                <c:if test="${!isLastUser}">
                    <button type="button" class="btn btn-primary" onclick="doSubmit()">
                        <i class="fa fa-level-up"></i> 导出
                    </button>
                </c:if>
                <button type="button" class="btn btn-primary" onclick="searchOverride()">
                    <i class="fa fa-search"></i> <spring:message code="btn.search"></spring:message>
                </button>
                <button type="button" class="btn btn-default" onclick="resetForm()">
                    <i class="fa fa-repeat"></i> <spring:message code="btn.reset"></spring:message>
                </button>
            </div>
        </div>
    </div>
    <div class="panel-content"></div>
</div>
<div class="modal fade" id="orgModal" tabindex="-1" role="basic" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h4 class="modal-title">所属组织</h4>
            </div>
            <div class="modal-body">
                <ul id="orgTree" class="ztree" style="margin-top:0; width:160px;"></ul>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn blue" onclick="saveParentOrg()">确定</button>
                <button type="button" class="btn default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="<c:url value="/static/custom/datepicker-util.js"></c:url>"></script>
<script type="text/javascript">


    /**
     * 导出
     */
    function doSubmit() {
        $("#searchForm").attr("action", webRoot + '/assessment/export');
        $("#searchForm").submit();
        $("#searchForm").attr("action", '/assessment/list');
    }
    /**
     * 查询
     */
    function searchOverride() {
        $.ajax({
            type: 'post',
            url: webRoot + '/assessment/list',
            data: $('.panel-search form').serialize(),
            dataType: 'html',
            success: function (data) {
                $(".panel-content").html(data);
            }
        });
    }



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


    $(function () {
        $('#projects').select2({
            allowClear: true
        });

        search();
        $("#pasMonth").val($("#dfpasMonth").val());

    });
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
    // 显示弹窗
    function showOrg() {
        // 加载组织的树状结构
        $.ajax({
            type: 'post',
            url: '<c:url value="/org/getOrgForTree"></c:url>',
            dataType: 'json',
            success: function (data) {
                $.fn.zTree.init($("#orgTree"), setting, data);
            }
        });
        $('#orgModal').modal('show');
    }

    // 保存组织
    function saveParentOrg() {
        var nodes = $.fn.zTree.getZTreeObj("orgTree").getSelectedNodes();
        $('#orgId').val(nodes[0].code);
        $('#orgName').val(nodes[0].name);
        // 隐藏弹窗
        $('#orgModal').modal('hide');
    }
    function resetForm() {
        $("#searchForm")[0].reset();
        $("input[type='hidden']").val("");
        $("#projects").val(null).trigger("change");
    }
</script>
