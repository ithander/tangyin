<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${PkgName}.${BeanName}Mapper">

    <select id="get" resultType="${BeanName}">
        select <#list BeanFields as field><#if field_index != 0 >,</#if>${(field.field)!""}</#list> from ${TableName} where ${idFieldWhere}
    </select>
    
    <select id="list" resultType="${BeanName}">
        select <#list BeanFields as field><#if field_index != 0 >,</#if>${(field.field)!""}</#list> from ${TableName} 
        where ${idFieldWhere}
    </select>

</mapper>