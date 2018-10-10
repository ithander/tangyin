<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>安装系统</title>
        <#include "common/header.ftl">
    </head>
    <body>
        <table id="a">
            <tbody>
                <tr>
                    <td>aaaaaaaaaa<td>
                </tr>
            </tbody>
        <table>
    </body>
    <script type="text/javascript">
        layui.use(['layer'], function(){
            var layer = layui.layer;
            layer.open({
                type: 1,
                title:'安装信息',
                closeBtn:0,
                skin: 'layui-layer-rim', //加上边框
                area: ['420px', '240px'], //宽高
                content: $('#a').html(),
                success:function(){
                   $('body').hide();
                }
            });
                      
        });
    </script>
</html>