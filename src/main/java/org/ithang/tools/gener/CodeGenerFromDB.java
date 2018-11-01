package org.ithang.tools.gener;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ithang.system.data.bean.FieldInfo;
import org.ithang.system.data.bean.TableInfo;
import org.ithang.tools.lang.JsonUtils;
import org.ithang.tools.lang.StrUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.mysql.jdbc.Driver;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 代码生成器
 * @author ithang
 *
 */
public class CodeGenerFromDB {

	
	private final static Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
	//private final static StringTemplateLoader loader=new StringTemplateLoader();
	
	static{
		try{
		    cfg.setDefaultEncoding("UTF-8");
            cfg.setDirectoryForTemplateLoading(new File(CodeGenerFromDB.class.getResource("./").getPath()+"ftl"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 根据表结构生成 对应的Bean,Mapper,Service
	 * @param jdbcTemplate
	 * @param tableNames 如果为null或长度为0,则全库表都生成一遍
	 */
	public static void gener(JdbcTemplate jdbcTemplate,String... tableNames){
		
		for(String tableName:tableNames){
			
			Map<String,Object> values=new HashMap<String,Object>();
			
			List<Map<String,Object>> fields=jdbcTemplate.query("describe "+tableName, new RowMapper<Map<String,Object>>(){
				@Override
				public Map<String,Object> mapRow(ResultSet rs, int index) throws SQLException {
					Map<String,Object> mp=new HashMap<>(5);
					
					mp.put("field",StrUtils.dropUnderline(rs.getString("Field")));
					mp.put("type",rs.getString("Type"));
					if("PRI".equalsIgnoreCase(rs.getString("key"))){
						String type=String.valueOf(mp.get("type"));
						if(null!=type&&type.trim().length()>0){
							if(type.indexOf("int")>-1){
								values.put("pri", "int");	//全局设置主键类型		
							}else{
								values.put("pri", "String");	//全局设置主键类型
							}
							values.put("idFieldWhere", mp.get("field")+"=#{"+mp.get("field")+"}");
						}
						
					}
					
					return mp;
				}
				
			});
			
			values.put("PkgName", "org.ithang.tools.gener");
			values.put("BeanName", StrUtils.headUpper(StrUtils.dropUnderline(tableName)));
			values.put("TableName", StrUtils.dropUnderline(tableName));
			values.put("BeanFields", fields);
			generBean(values);
			generMapper(values);
			generMapperXML(values);
		}
	}
	
	
	/**
	 * 生成业务实体Bean
	 * @param table
	 */
	protected static void generBean(Map<String,Object> values) {
		try{
		    Template temp=cfg.getTemplate("Bean.ftl");
		    
		    Writer out=new FileWriter(new File(CodeGenerFromDB.class.getResource("./").getPath().replaceAll("target/classes", "src/main/java")+values.get("BeanName")+".java"));
		    temp.process(values, out);
		    out.flush();
		    out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成业务实体Bean
	 * @param table
	 */
	protected static void generMapper(Map<String,Object> values) {
		try{
		    Template temp=cfg.getTemplate("Mapper.ftl");
		    
		    Writer out=new FileWriter(new File(CodeGenerFromDB.class.getResource("./").getPath().replaceAll("target/classes", "src/main/java")+values.get("BeanName")+"Mapper.java"));
		    temp.process(values, out);
		    out.flush();
		    out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成业务实体Bean
	 * @param table
	 */
	protected static void generMapperXML(Map<String,Object> values) {
		try{
		    Template temp=cfg.getTemplate("MapperXML.ftl");
		    
		    Writer out=new FileWriter(new File(CodeGenerFromDB.class.getResource("./").getPath().replaceAll("target/classes", "src/main/java")+values.get("BeanName")+"Mapper.xml"));
		    temp.process(values, out);
		    out.flush();
		    out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) throws SQLException {
		//System.out.println(CodeGenerFromDB.class.getResource("./").getPath().replaceAll("target/classes", "src/main/java"));
		
		SimpleDriverDataSource ds=new SimpleDriverDataSource(new Driver(), "jdbc:mysql://localhost:3306/ithang?useSSL=false", "root", "su");
		
		JdbcTemplate jdbc=new JdbcTemplate(ds);
		
		gener(jdbc, "sys_info");
		
	}
	
}
