package org.ithang.tools.gener;

public class SysInfo{
     

         private int id;
         private String author;
         private String version;
         private String mobile;
         private String createTime;

         public int getId(){
             return id;
         }
         
         public void setId(int id){
             this.id=id;
         }
         public String getAuthor(){
             return author;
         }
         
         public void setAuthor(String author){
             this.author=author;
         }
         public String getVersion(){
             return version;
         }
         
         public void setVersion(String version){
             this.version=version;
         }
         public String getMobile(){
             return mobile;
         }
         
         public void setMobile(String mobile){
             this.mobile=mobile;
         }
         public String getCreateTime(){
             return createTime;
         }
         
         public void setCreateTime(String createTime){
             this.createTime=createTime;
         }
}