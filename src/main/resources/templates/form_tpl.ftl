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

<#if footerTpl??>
    <#list footerTpl as tpl>
        <#include tpl/>
    </#list>
</#if>

<script type="text/javascript" src="/jkBuilderInit.js"></script>
<script type="text/javascript" src="/vue.js"></script>
<script type="text/html" id="billList">
    <div id="billListVm">
        {{!
        <table class="layui-table" >
            <tbody>
            <tr v-for="item in billList">
                <td>  <#--<a :href="item" rel="lightbox">-->
                    <img :src="item" style="width: 300px;height: 100px"/>
                    <#--</a>-->
                </td>
            </tr>
            </tbody>
        </table>
        !}}
        {{#initBillData(d.value)}}
    </div>
</script>
<script type="text/javascript">

    function initBillData(value) {
        setTimeout(function () {
            var vm=new Vue({
                el:"#billListVm",
                data:{billList:[]},
                methods:{
                    setList:function (value) {
                       this.billList=value;
                    }
                }
            });
            vm.setList(JSON.parse(value))
        },1)
    };
    layui.use(['layer', 'tree'], function () {
        // 操作对象
        var layer = layui.layer, tree = layui.tree, $ = layui.jquery;

      /*  $("a[rel^='lightbox']").picbox();*/
    });
</script>

<script type="text/html" id="voucherList">
    <div id="voucherListVm">
        {{!
        <table class="layui-table" >
            <tbody>
            <tr v-for="item in voucherList">
                <td>
                    <#--<a :href="item" rel="lightbox">--><img :src="item" style="width: 300px;height: 100px"/><#--</a>-->
                </td>
            </tr>
            </tbody>
        </table>
        !}}
        {{#initVoucherData(d.value)}}
    </div>
</script>
<script type="text/javascript">
    function initVoucherData(value) {
        setTimeout(function () {
            var vm=new Vue({
                el:"#voucherListVm",
                data:{voucherList:[]},
                methods:{
                    setList:function (value) {
                        this.voucherList=value;
                    }
                }
            });
            vm.setList(JSON.parse(value))
        },1)
    }
    layui.use(['layer', 'tree'], function () {
        // 操作对象
        var layer = layui.layer, tree = layui.tree, $ = layui.jquery;

       /* $("a[rel^='lightbox']").picbox();*/
    });

</script>

<script type="text/html" id="recommendationRelationshipTree">
    <div>
    <ul id="demo"></ul>
    </div>
    {{#initRecommendData(d.value)}}
</script>
<script type="text/javascript">
    function initRecommendData(value) {
        var json=JSON.parse(value);
        layui.use(['layer', 'tree'], function () {
            // 操作对象
            var layer = layui.layer, tree = layui.tree, $ = layui.jquery;
            layui.tree({
                elem: '#demo' //传入元素选择器
                , nodes: json
            });
        });
    }
</script>

</body>
</html>