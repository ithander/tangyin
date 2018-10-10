package org.ithang.tools.database;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * 数据源操作者
 * @author ithang
 *
 */
public class DBOperator {

	private String title;
	
	private String dbType;//mysql,oracle
	
	private DataSource dataSource;
	
    private JdbcTemplate jdbcTemplate;
	
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public DBOperator(String title,DataSource dataSource){
		setTitle(title);
		setDataSource(dataSource);
	}
	
	public DBOperator(String title,String dbType,DataSource dataSource){
		setTitle(title);
		setDbType(dbType);
		setDataSource(dataSource);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		if(null!=dataSource){
			this.dataSource = dataSource;
			this.jdbcTemplate=new JdbcTemplate(dataSource);
			this.namedJdbcTemplate=new NamedParameterJdbcTemplate(jdbcTemplate);
		}
		
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public NamedParameterJdbcTemplate getNamedJdbcTemplate() {
		return namedJdbcTemplate;
	}

	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
	}
	
	@Override
	public String toString() {
		return getTitle();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof DataSource){
			return this.dataSource==obj;
		}
		if(obj instanceof DBOperator){
			return ((DBOperator)obj).equals(this.dataSource);
		}
		return false;
	}
}
