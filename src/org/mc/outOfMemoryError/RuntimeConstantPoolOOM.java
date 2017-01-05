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
		String str1=new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern()==str1);
		String str2=new StringBuilder().append("java").toString();
		System.out.println(str2.intern()==str2);
		 
		/*String str3=new String("计算机软件");
		System.out.println(str3.intern()==str3);
		String str4=new String("java");
		System.out.println(str4.intern()==str4);*/
	}
	
}
