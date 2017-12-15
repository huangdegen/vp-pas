<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<div class="col-md-12">
    <div class="panel-search">
        <form class="form-inline" id="searchForm" action="/vpReportings/list">
            <div class="form-group">
                <label for="reportingName" class="control-label">用户名称：</label>
                <input type="text" name="reportingName" class="form-control"/>
            </div>
            <%-- <div class="form-group">
                 <label for="reportingDate" class="control-label">填报日期：</label>
                 <div class="input-group date date-picker" data-date-format="yyyy-mm-dd">
                     <input type="text" name="reportingDateStart" class="form-control" readonly style="width:100px;"/>
                     <span class="input-group-btn">
                             <button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                         </span>
                 </div>
                 -
                 <div class="input-group date date-picker" data-date-format="yyyy-mm-dd">
                     <input type="text" name="reportingDateEnd" class="form-control" readonly style="width:100px;"/>
                     <span class="input-group-btn">
                             <button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                         </span>
                 </div>
             </div>--%>

            <div class="form-group">
                <label for="reportingDate" class="control-label">填报日期：</label>
                <div class="input-group date date-picker" data-date-format="yyyy-mm-dd">
                    <input type="text" name="reportingDate" class="form-control" readonly style="width:100px;"/>
                    <span class="input-group-btn">
							<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
						</span>
                </div>
            </div>

            <div class="form-group">
                <label for="projects" class="control-label">项目名称：</label>
                <select class="form-control select2" style="padding: 0;width: 180px;" id="projects"
                        name="reportingProject"
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
                <button type="button" class="btn btn-warning" onclick="add('/vpReportings/vpReporting')">
                    <i class="fa fa-plus"></i> <spring:message code="btn.add"></spring:message>
                </button>
            </div>
            <div class="div-right">
                <c:if test="${!isLastUser}">
                    <button type="button" class="btn btn-primary" onclick="doSubmitReporting()">
                        <i class="fa fa-level-up"></i> 工时信息导出
                    </button>
                    <button type="button" class="btn btn-primary" onclick="workingReporting()">
                        <i class="fa fa-level-up"></i> 工时统计导出
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
<script type="text/javascript" src="<c:url value="/static/custom/datepicker-util.js"></c:url>"></script>
<script type="text/javascript">
    $(function () {
        search();
    });
    /**
     * 导出
     */
    function doSubmitReporting() {
        $("#searchForm").attr("action", webRoot + '/vpReportings/export');
        $("#searchForm").submit();
        $("#searchForm").attr("action", '/vpReportings/list');
    }
    /**
     * 导出
     */
    function workingReporting() {
        $("#searchForm").attr("action", webRoot + '/vpReportings/StatisticalExport');
        $("#searchForm").submit();
        $("#searchForm").attr("action", '/vpReportings/list');
    }
    /**
     * 查询
     */
    function searchOverride() {
        $.ajax({
            type: 'post',
            url: webRoot + '/vpReportings/list',
            data: $('.panel-search form').serialize(),
            dataType: 'html',
            success: function (data) {
                $(".panel-content").html(data);
            }
        });
    }
    function resetForm() {
        $("#searchForm")[0].reset();
        $("input[type='hidden']").val("");
    }

</script>