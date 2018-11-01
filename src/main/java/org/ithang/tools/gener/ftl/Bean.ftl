package ${PkgName};

public class ${BeanName?cap_first}{
     

    <#if BeanFields?? && BeanFields?size gt 0>
    <#list BeanFields as field>
         private <#if field.type?index_of("varchar")!=-1>String</#if><#if field.type?index_of("int")!=-1>int</#if> ${(field.field)!""};
    </#list>
    </#if>

    <#if BeanFields?? && BeanFields?size gt 0>
    <#list BeanFields as field>
         public <#if field.type?index_of("varchar")!=-1>String</#if><#if field.type?index_of("int")!=-1>int</#if> get${((field.field)!"")?cap_first}(){
             return ${(field.field)!""};
         }
         
         public void set${((field.field)!"")?cap_first}(<#if field.type?index_of("varchar")!=-1>String</#if><#if field.type?index_of("int")!=-1>int</#if> ${(field.field)!""}){
             this.${(field.field)!""}=${(field.field)!""};
         }
    </#list>
    </#if>
}