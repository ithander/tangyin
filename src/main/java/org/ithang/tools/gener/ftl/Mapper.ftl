package ${PkgName};

import java.util.List;

import org.ithang.tools.model.Page;

public interface ${BeanName}Mapper {

	
	public ${BeanName} get(int id);
	
	public List<${BeanName}> list(Page<${BeanName}> page);
	
	public int update(${BeanName} ${BeanName?uncap_first});
	
	public int delete(${pri} id);
	
}