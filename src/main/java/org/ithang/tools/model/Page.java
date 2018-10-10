package org.ithang.tools.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.ithang.tools.lang.StrUtils;

public class Page<T> {

	private long pageNow;//当前页号,分页必传，不传的话默认为0，如果传0表示不分页
	private long pageSize=20;//每页记录数
	private long pageNum;//总页数
	private long total;//总记录数
	private long from;//从指定记录查
	private String order;//排序字段
	private String sort;//排序算法asc|desc
	private List<T> data;
	
	private Map<String,Object> params;//请求参数
	
	public Page(HttpServletRequest request){
		setPageNow(Integer.parseInt(request.getParameter("pageNow")==null?"0":request.getParameter("pageNow")));
		setPageSize(Integer.parseInt(request.getParameter("pageSize")==null?""+pageSize:request.getParameter("pageSize")));
		Map<String,String[]> mps=request.getParameterMap();
		if(!mps.isEmpty()){
			params=new HashMap<String,Object>(mps.size());
			mps.forEach((k,v)->{
				if(1==v.length){
					params.put(k, v[0]);
				}else{
					params.put(k, null!=v?StrUtils.pkg(v, "'", "'",","):"");
				}
			});
		}
	}
	
	public Page(long pageNow,long pageSize){
		setPageNow(pageNow);
		setPageSize(pageSize);
	}
	
	public long getPageNow() {
		return pageNow;
	}
	public void setPageNow(long pageNow) {
		this.pageNow = pageNow;
	}
	public long getPageSize() {
		return pageSize;
	}
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}
	public long getPageNum() {
		return pageNum;
	}
	public void setPageNum(long pageNum) {
		this.pageNum = pageNum;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
		if(total>0){
			setPageNum(total%pageSize==0?(total/pageSize):(total/pageSize+1));	
		}
	}
	public long getFrom() {
		return from;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getSort() {
		return sort==null?"desc":sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public long getFrom(long from) {
		return (pageNow>0?pageNow-1:0)*pageSize;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

}
