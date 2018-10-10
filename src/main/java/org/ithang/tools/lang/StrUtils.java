package org.ithang.tools.lang;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.LineNumberReader;
import java.io.StringReader;

public final class StrUtils {

	/**
     * 是非空有效字段吗?是true,否false
     * @param value
     * @return 
     */
    public static boolean isNotBlank(String value){
        if(null!=value&&value.trim().length()>0){
            return true;
        }
        return false;
    }
	
    public static String trim(String str,String mark){
		if(str.startsWith(mark)){
			str=str.replaceFirst(mark, "");
		}
		if(str.endsWith(mark)){
			str=str.substring(0, str.lastIndexOf(mark));
		}
		
		return str;
	}
    
    public static boolean isEmptyArray(Object[] array){
    	if(null!=array&&array.length>0){
    		return true;
    	}
    	return false;
    }
    
    /**
	 * 增加下划线,把驼峰式转到下划线式
	 * @param tname
	 * @return
	 */
	public static String addUnderline(String tname){
		String columnName="";
		
		char[] tnames=tname.toCharArray();
		boolean _show=false;
		for(int i=0;i<tnames.length;i++){
			if(Character.isUpperCase(tnames[i])&&i>0){
				_show=true;
			}
			if(_show){
				columnName+="_"+tnames[i];
				_show=false;
			}else{
				columnName+=tnames[i];
			}
		}
		return columnName.toLowerCase();
    }
	
	/**
	 * 去掉下划线,并转为小写
	 * @param tname
	 * @return
	 */
	public static String dropUnderline(String tname){
		StringBuffer columnName=new StringBuffer();
		tname=tname.toLowerCase();
		
		char[] tnames=tname.toCharArray();
		boolean _show=false;
		for(int i=0;i<tnames.length;i++){
			if("_".equals(String.valueOf(tnames[i]))){
				_show=true;
				continue;
			}
			if(_show){
				columnName.append(String.valueOf(Character.toUpperCase(tnames[i])));
				_show=false;
			}else{
				columnName.append(String.valueOf(tnames[i]));
			}
		}
		return columnName.toString();
	}
	
	
	/**
	 * 去前缀
	 * @param value
	 * @param prefix
	 * @param suffix
	 * @return
	 */
	public static String trimPrefix(String value,String ... prefixs){
		if(isNotBlank(value)){
            for(String prefix:prefixs){
            	if(value.startsWith(prefix)){
            		return value.replaceFirst(prefix, "");//只去前缀一次
            	}
            }
		}
		return value.trim();
	}
	
	/**
	 * 去后缀
	 * @param value
	 * @param prefix
	 * @param suffix
	 * @return
	 */
	public static String trimSuffix(String value,String ... suffixs){
		if(null!=suffixs&&suffixs.length>0){
            for(String suffix:suffixs){
            	if(value.endsWith(suffix)){
            		return value.substring(0, value.length()-suffix.length());//只去后缀一次
            	}
            }
		}
		return value.trim();
	}
	
	/**
	 * 首字母大写
	 * @param value
	 * @return
	 */
	public static String headUpper(String value){
		char[] chars=value.toCharArray();
		if(null!=chars&&chars.length>1&&Character.isUpperCase(chars[1])){
			
		}else{
		    chars[0]=Character.toUpperCase(chars[0]);
		}
		return String.valueOf(chars);
    }
	
	
	/**
	 * 为每个字符串加前后缀
	 * @param values
	 * @param prefix
	 * @param suffix
	 * @return
	 */
	public static String pkg(String[] values,String prefix,String suffix,String liner){
		StringBuilder sber=new StringBuilder();
		int i=0;
		for(String value:values){
			if(isNotBlank(value)){
				if(i>0){
					sber.append(liner);
				}
				sber.append(prefix).append(value).append(suffix);
				i++;
			}
		}
		return sber.toString();
	}
	
	public static String join(String[] values,String liner){
		StringBuilder sber=new StringBuilder();
		int i=0;
		for(String value:values){
			if(isNotBlank(value)){
				if(i>0){
					sber.append(liner);
				}
				sber.append(value);	
				i++;
			}
		}
		return sber.toString();
	}
	
	/**
	 * 把文件内容转成java字符串内容
	 * @param file
	 * @return
	 * @throws FileNotFoundException 
	 */
	public static String fromFileToStr(File file) {
	    FileInputStream fis=null;
	    try{
	    	fis=new FileInputStream(file);
	    	StringBuilder sber=new StringBuilder();
	    	byte[] bs=new byte[1024*5];
	    	int k=fis.read(bs);
	    	while(-1!=k){
	    		sber.append(new String(bs,0,k));
	    		k=fis.read(bs);
	    	}
	    	
	    	StringReader sr=new StringReader(sber.toString());
	    	LineNumberReader LNReader=new LineNumberReader(sr);
	    	StringBuilder r=new StringBuilder();
	    	String s=LNReader.readLine();
	    	
	    	while(null!=s&&s.trim().length()>0){
	    		r.append("\"").append(s.replaceAll("\\\"","\\\\\"")).append("\"+\n");	
	    		s=LNReader.readLine();
	    	}
	    	
	    	sr.close();
	    	LNReader.close();
	    	return r.toString();
	    }catch(Exception e){
	    	e.printStackTrace();
	    }finally{
	    	if(null!=fis){
	    		try{
	    			fis.close();
	    		}catch(Exception e){
	    			e.printStackTrace();
	    		}
	    	}
	    }
	    return null;
	}
    
}
