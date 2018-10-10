<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <meta charset="UTF-8">
        <title>测试</title>
        <#include "common/header.ftl">
    </head>
    <body>
        
    </body>
    
    <script type="text/javascript">
       

    Ext.define('com.Root', {
             constructor:function(){
                console.log(Ext.getBody());
             },
             name: 'something',

		     getName: function(s) {
		         console.log('hello '+s);
		     }

    });
    
    Ext.define('com.Person',{
          extend: 'com.Root',
           constructor:function(){
                var el=Ext.getBody().insertHtml('afterBegin','<a href="http://www.baidu.com/" class="layui-btn">baidu</a>',true);
             },
          name:'goodjob'
      })
      
      Ext.require('mina.root.Root');
      
       Ext.onReady(function(){
           
           
           var root=Ext.create('mina.root.Root');
            console.log(root.getBody());
           
       });

       
    </script>
</html>