package com.neuedu.room.utils;

import java.io.UnsupportedEncodingException;

/**
 * �ַ�������
 * @author k063
 * ***/

public class StringUtil {
	
	/**
	 * ����get����
	 * @param param
	 * @return
	 * **/
	public static String parseEncoding(String param)
	{   
		if(isEmpty(param))
		{
			return "";
		}
		try {
			return new String(param.getBytes("ISO8859-1"));
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}


	
	/**
	 * �ж��ַ����Ƿ�Ϊ��
	 * @param param
	 * @return
	 * ***/
     public static boolean isEmpty(String param)
     {
    	return param==null || "".equals(param.trim()); 
     }
}
