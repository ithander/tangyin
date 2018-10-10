package org.ithang.tools.database;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.ithang.tools.model.DBConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
public abstract class Dao {

	@Autowired
	private static DataSource dataSource;//根(root)数据源,根(root)数据源拥有项目配置数据
	
	private static DBOperator dbOperator;//根(root)数据源操作者
	
	private final static Map<String, DBOperator> ds=new HashMap<String, DBOperator>(5);
	
	private static Logger logger=LoggerFactory.getLogger(Dao.class);
	
	public Dao(){logger.debug("初始化默认数据源成功");}
	
	
	/**
	 * 得到Root数据源
	 * @return
	 */
	public static DataSource getDataSource() {
		return Dao.dataSource;
	}
	
	/**
	 * 得到Root数据源操作者
	 * @return
	 */
	public static DBOperator getDBOperator() {
		if(null!=dataSource&&(null==dbOperator||!dbOperator.equals(dataSource))){
			dbOperator=new DBOperator("default",dataSource);
		}
		return dbOperator;
	}
	
	/**
	 * 根据属性文件加载数据源
	 * @param key
	 * @param db_config
	 */
	public void loadDsByProperties(String key,Properties db_config) {
		try{
		    DataSource keyDs=BasicDataSourceFactory.createDataSource(db_config);
		    ds.put(key, new DBOperator(key, keyDs));
		}catch(Exception e){
			logger.error("加载数据源"+key+"出错"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据JNDI加载数据源
	 * @param key
	 * @param lookup
	 */
	public void loadDsByJNDI(String key,String lookup){
		try{
		     InitialContext ic = new InitialContext();
		     DataSource keyDs = (DataSource) ic.lookup(lookup);
		     ds.put(key, new DBOperator(key, keyDs));
		}catch(Exception e){
			logger.error("加载数据源"+key+"出错"+e.getMessage());
			e.printStackTrace();
		}

	}
	
	/**
	 * 加载数据源
	 * @param key
	 * @param dbConfig
	 */
	public void load(String key,DBConfig dbConfig){
		
	}
	
	/**
	 * 加载数据源
	 * @param key
	 * @param uname
	 * @param upass
	 * @param url
	 */
	public void load(String key,String uname,String upass,String url){
		
	}

	public static Map<String, DBOperator> getDs() {
		return ds;
	}

	
}
