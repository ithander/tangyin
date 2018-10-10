layui.define(['layer'], function(exports){
  var layer=layui.layer;
  /*使用主式
  {
      url:'',
      method:'get/post',
      items:[{
          label:'',
          name:'uname',
          type:'text'
      }]
   }
  */
  var layerForm={
      id_prefix:"#layerForm__",
      url:'',
      form:function(config){
         this.url=config.url;
         var html='<html><body>';
             html+='<br/><br/><div class="layui-row"><div class="layui-col-md9">';
             html+='<form id="'+this.id_prefix+'fm" class="layui-form" action="'+config.url+'" method="'+config.method+'">';
             
             //解析config中的items
             if(config&&config.items){
                 for(index in config.items){
                     var conf=config.items[index];
                     if('text'==conf.type){
                         html+='<div class="layui-form-item">';
                         html+='    <label class="layui-form-label">'+conf.label+'</label>';
                         html+='    <div class="layui-input-block">';
                         html+='        <input id="'+this.id_prefix+conf.name+'" type="text" name="'+conf.name+'" placeholder="请输入标题" class="layui-input">';
                         html+='    </div>';
                         html+='</div>';
                     }else if('password'==conf.type){
                         html+='<div class="layui-form-item">';
                         html+='    <label class="layui-form-label">'+conf.label+'</label>';
                         html+='    <div class="layui-input-block">';
                         html+='        <input id="'+this.id_prefix+conf.name+'" type="password" name="'+conf.name+'"  placeholder="请输入标题" class="layui-input">';
                         html+='    </div>';
                         html+='</div>';
                     }else if('select'==conf.type){
                     
                     }else if('checkbox'==conf.type){
                     
                     }else if('radio'==conf.type){
                     
                     }
                 }
             }
             
             html+='</form></div></div>';
             html+='</body></html>'
             //弹出框设置
             config.type=1;
             config.content=html;
             layer.open(config);
      },//form end
      submit:function(){//form 表单提交
          var fm=Ext.getDom(this.id_prefix+'fm');
          fm.submit();
      },
      post:function(){//ajax post提交
          var fm=Ext.getDom(this.id_prefix+'fm');
          var seriFm=Ext.dom.Element.serializeForm(fm);
          //console.log(seriFm);
          $.post({url:this.url,data:seriFm})
      },
      get:function(){//ajax get提交
          var fm=Ext.getDom(this.id_prefix+'fm');
          var seriFm=Ext.dom.Element.serializeForm(fm);
          //console.log(seriFm);
          $.get({url:this.url,data:seriFm,function(r){
              console.log('success');
          }})
      }
      
  }
  
  exports('LayerForm', layerForm);
});  