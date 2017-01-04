package org.mc.outOfMemoryError;

import java.util.ArrayList;
import java.util.List;

/**
 * @author machao
 * Created in 2017/01/04
 * VM Args:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 */
public class HeapOOM {
	
	static class OOMObject{
		
	}
	
	public static void main(String[] args) {
		List<OOMObject> list=new ArrayList<OOMObject>();
		int i=0;
		while(true){
			list.add(new OOMObject());
			i++;
			System.out.println(i);
		}
		
	}

}
