<!DOCTYPE html>
<html lang="en">
<#assign vipRoot="/vip/"/>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>${title!}</title>
<#include "head_css_tpl.ftl"/>

</head>
<body class="body">
<#include "body_js_tpl.ftl"/>
${content!}
<script type="text/javascript" src="/jkBuilderInit.js"></script>
<script type="text/html" id="image">
        <#--<a href="{{d.imageUrl}}" rel="lightbox">--><img height="30px"  src="{{d.imageUrl}}"/><#--</a>-->
</script>
<script type="text/javascript">
    setTimeout(function () {
        layui.use([], function () {
            // 操作对象
            var $ = layui.jquery;
           /* $("a[rel^='lightbox']").picbox();*/
        });
    },500)
</script>
</body>
</html>