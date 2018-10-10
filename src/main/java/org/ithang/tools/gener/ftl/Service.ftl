[#ftl]
package com.thang.service.${pkgName};

import com.thang.tools.dao.Service;

@Service
public class ${entityName?cap_first}Service{

    @Autowired
    private ${entityName?cap_first}Mapper ${entityName?cap_first}Mapper;
}