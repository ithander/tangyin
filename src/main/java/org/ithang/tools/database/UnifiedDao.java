package org.ithang.tools.database;

import java.util.List;
import java.util.Map;


public class UnifiedDao extends BaseDao {

	/**
	 * 查询一条数字列
	 * @param sql
	 * @param params 对象数组
	 * @return
	 */
    public Integer getsInt(DBOperator oper,String sql,Object ...params){
		return getsInt(oper.getJdbcTemplate(),sql, params);
	}
    
    /**
	 * 查询一条数字列
	 * @param sql
	 * @param params map类型
	 * @return
	 */
	public Integer getInt(DBOperator oper,String sql,Map<String,Object> params){
		return getInt(oper.getNamedJdbcTemplate(),sql, params);
	}
    
    /**
	 * 查询多条数字列
	 * @param sql
	 * @param params 对象数组
	 * @return
	 */
    public List<Integer> listsInt(DBOperator oper,String sql,Object ...params){
    	return listsInt(oper.getJdbcTemplate(),sql,params);
	}
    
    /**
	 * 查询多条数字列
	 * @param sql
	 * @param params 对象数组
	 * @return
	 */
    public List<Integer> listInt(DBOperator oper,String sql,Map<String,Object> params){
    	return listInt(oper.getNamedJdbcTemplate(),sql, params);
	}
    
    /**
	 * 查询一条字符串列
	 * @param sql
	 * @param params 对象数组
	 * @return
	 */
    public String getsStr(DBOperator oper,String sql,Object ...params){
		return getsStr(oper.getJdbcTemplate(),sql, params);
	}
	
    /**
	 * 查询一条字符串列
	 * @param sql
	 * @param params map类型
	 * @return
	 */
	public String getStr(DBOperator oper,String sql,Map<String,Object> params){
		return getStr(oper.getNamedJdbcTemplate(),sql, params);
	}
	
   /**
	* 查询多条字符串列
	* @param sql
	* @param params 对象数组
	* @return
    */
	public List<String> listsStr(DBOperator oper,String sql,Object ...params){
	    return listsStr(oper.getJdbcTemplate(),sql,params);
	}
		
	/**
	 * 查询多条字符串列
	 * @param sql
	 * @param params map类型
	 * @return
	 */
	public List<String> listStr(DBOperator oper,String sql,Map<String,Object> params){
		return listStr(oper.getNamedJdbcTemplate(),sql, params);
	}
	
	/**
     * 查询一条任意类型列
     * @param sql
     * @param params map类型
     * @param cls
     * @return
     */
    public <T>T getObj(DBOperator oper,String sql,Map<String,Object> params,Class<T> cls){
		return getObj(oper.getNamedJdbcTemplate(),sql,params,cls);
	}
    
    /**
     * 查询一条任意类型列
     * @param sql
     * @param params map类型
     * @param cls
     * @return
     */
    public <T>List<T> listObj(DBOperator oper,String sql,Map<String,Object> params,Class<T> cls){
		return listObj(oper.getNamedJdbcTemplate(),sql,params,cls);
	}
    
    /**
	 * 用传入的Map值 修改数据库
	 * @param sql
	 * @param params map类型
	 * @return
	 */
	public int updateSQL(DBOperator oper,String sql,Map<String,Object> params){
		return updateSQL(oper.getNamedJdbcTemplate(),sql,params);	
	}
	
	/**
	 * 简单修改，多参数值
	 * @param sql
	 * @param params 对象数组
	 * @return
	 */
	public int updatesSQL(DBOperator oper,String sql,Object ... params){
		return updatesSQL(oper.getJdbcTemplate(),sql,params);
	}
	
	/**
	 * 查询一条记录
	 * @param sql
	 * @param params map类型
	 * @return
	 */
	public Map<String,Object> getSQL(DBOperator oper,String sql,Map<String,Object> params){
		return getSQL(oper.getNamedJdbcTemplate(),sql,params);
	}
	
	/**
	 * 查询一条记录
	 * @param sql
	 * @param params 对象类型
	 * @return
	 */
	public Map<String,Object> getsSQL(DBOperator oper,String sql,Object ... params){
		return getsSQL(oper.getJdbcTemplate(),sql,params);
	}
	
	/**
	 * 查询，传map
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<Map<String,Object>> listSQL(DBOperator oper,String sql,Map<String,Object> params){
		return listSQL(oper.getNamedJdbcTemplate(),sql,params);
	}
	
	/**
	 * 查询,多参数值,无法判断是否分页,只能把分页limit写在sql中
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<Map<String,Object>> listsSQL(DBOperator oper,String sql,Object ... params){
		return listsSQL(oper.getJdbcTemplate(),sql,params);
	}
	
	
}
