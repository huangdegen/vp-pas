<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta name="force-rendering" content="webkit">
</head>
<body>
<img id="image" src="${webRoot}/servlet/ValidationServlet" style="cursor: pointer;">
</body>
</body>
<script src="${webRoot}/static/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${webRoot}/static/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function(){
        $("#image").click(function(event){
            var obj=this;
            var x=event.offsetX;//获取点击时鼠标相对图片坐标
            var y=event.offsetY;
            $.ajax({
                url:"${webRoot}/ValidationZh/validation", //ajax提交
                type:"post",
                data:{'x':x,"y":y},
                success:function(data){
                    alert(data)
                    obj.src=obj.src+"?date="+new Date();
                }
            })
        });
    })

</script>
</html>