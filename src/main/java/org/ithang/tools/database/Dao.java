package org.ithang.tools.database;


import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * 该设计是为了适应多数据源的情况
 *       datasource(root)
 *    ds(app_1)  ds(app_2)  ds(app_3)
 *  在根数据源中拥有其它数据源的配置信息,
 *  1. 先通过spring默认配置初始化根数据源
 *  2.再根据根数据源中的配置信息初始化其它数据源
 * @author ithang
 *
 */
@Component
public class Dao {

	@Autowired
	private DataSource dataSource;//根(root)数据源,根(root)数据源拥有项目配置数据
	
	private  JdbcTemplate jdbcTemplate;
	private  NamedParameterJdbcTemplate namedJdbcTemplate;
	private  QueryRunner qr; 
	
	private  Logger logger=LoggerFactory.getLogger(Dao.class);
	
	public Dao(){}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public QueryRunner getQuery(){
		if(null==qr){
			qr=new QueryRunner(getDataSource());
		}
		return qr;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		if(null==jdbcTemplate){
			jdbcTemplate=new JdbcTemplate(getDataSource());
		}
		return jdbcTemplate;
	}


	public  NamedParameterJdbcTemplate getNamedJdbcTemplate() {
		if(null==this.namedJdbcTemplate){
			this.namedJdbcTemplate=new NamedParameterJdbcTemplate(getJdbcTemplate());	
		}
		return namedJdbcTemplate;
	}


	/**
	 * 得到Root数据源
	 * @return
	 */
	public DataSource getDataSource() {
		return dataSource;
	}
	
	
}
