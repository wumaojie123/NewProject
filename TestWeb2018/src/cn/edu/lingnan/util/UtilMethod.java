package cn.edu.lingnan.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilMethod {
public static String getDate()
   {
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	String nowTime=sdf.format(new Date(System.currentTimeMillis()));
	return nowTime;
	}
/*public static void main(String []args)
    {
	UtilMethod util=new UtilMethod();
	System.out.println(util.getDate());
	}*/
}
