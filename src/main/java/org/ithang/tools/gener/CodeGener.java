package org.ithang.tools.gener;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.ithang.system.data.bean.FieldInfo;
import org.ithang.system.data.bean.TableInfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * 代码生成器
 * @author ithang
 *
 */
public class CodeGener {

	/**
	 * 根据表结构生成 对应的Bean,Mapper,Service
	 * @param jdbcTemplate
	 * @param tableNames 如果为null或长度为0,则全库表都生成一遍
	 */
	public void gener(JdbcTemplate jdbcTemplate,String[] tableNames){
		for(String tableName:tableNames){
			List<FieldInfo> fields=jdbcTemplate.query("describe "+tableName, new RowMapper<FieldInfo>(){
				@Override
				public FieldInfo mapRow(ResultSet rs, int index) throws SQLException {
					FieldInfo ti=new FieldInfo();
					
					ti.setField(rs.getString("Field"));
					ti.setType(rs.getString("Type"));
					ti.setAllowNull(rs.getString("Null"));
					ti.setIskey(rs.getString("Key"));
					ti.setDefaultValue(rs.getString("default"));
					ti.setExtra(rs.getString("extra"));
					
					return ti;
				}
				
			});
			
			TableInfo tab=new TableInfo(tableName,fields);
			generBean(tab);
		}
	}
	
	/**
	 * 生成业务实体Bean
	 * @param table
	 */
	protected void generBean(TableInfo table) {
		
	}
	
}
