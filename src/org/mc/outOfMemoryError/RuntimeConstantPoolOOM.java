package org.mc.outOfMemoryError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created in 2017/01/05
 * @author machao
 * VM Args:-XX:PermSize=10M -XX:MaxPermSize=10M
 * JDK1.6之前有用
 */
public class RuntimeConstantPoolOOM {
	
	
	/*public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		int i=0;
		while(true){
			list.add(String.valueOf(i++).intern());
		}
	}*/
	
	public static void main(String[] args) {
		/*String str1=new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern()==str1);
		String str2=new StringBuilder().append("java").toString();
		System.out.println(str2.intern()==str2);*/
		/*
		new StringBuffer("计算机").append("1").toString();
		//System.out.println(str3.intern()==str3);
		String str4=new StringBuffer("flo").append("at").toString();
		System.out.println(str4.intern()==str4);*/
		
		 /*String str7=new StringBuffer().append("计算").append("机网络").toString();
	        String str8=new StringBuffer().append("计算机").append("网络").toString();
	        String str9=new StringBuffer("计").append("算机网络").toString();

	        System.out.println("str7.intern()==str7"+(str7.intern()==str7));
	        System.out.println("str8.intern()==str7"+(str8.intern()==str7));
	        System.out.println("str9.intern()==str7"+(str9.intern()==str7));*/
		
		/* String str1=new StringBuffer("计算机").append("软件").toString();
	        String str2=new StringBuffer("计算机软件").toString();
//	        String str3=new StringBuffer("计算机软件").append("").toString();
	        String str4=new StringBuffer().append("计算").append("机软件").toString();
	        String str5=new StringBuffer().append("计算机").append("软件").toString();
	        
	        System.out.println("str1.intern()==str2\t"+(str1.intern()==str2));
	        System.out.println("str2.intern()==str2\t"+(str2.intern()==str2));
//	        System.out.println("str3.intern()==str3\t"+(str3.intern()==str3));
	        System.out.println("str4.intern()==str2\t"+(str4.intern()==str2));
	        System.out.println("str5.intern()==str2\t"+(str5.intern()==str2));*/
		
		/*String a1="abc";
		String a2="ab"+"c";
		final String a3="a";
		String a5="bc";
		String a4=a3+a5;*/
		/*String a7=new String("abc");
		String a1="abc";
		System.out.println(a1==a7.intern());
		System.out.println(a1==a7);*/
		Integer i=77;
		Integer a=new Integer(77);
		System.out.println(i==a);
	    Integer b=Integer.valueOf(77);
	    System.out.println(i==b);
	    Integer y=300;
	    Integer x=Integer.valueOf(300);
	    System.out.println(y==x);
		 
	}
	
}
