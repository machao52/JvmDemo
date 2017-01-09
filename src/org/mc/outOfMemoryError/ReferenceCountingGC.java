package org.mc.outOfMemoryError;


/**
 * 
 * @author machao
 *
 */
public class ReferenceCountingGC {
	
	public Object instance=null;
	
	private static final int _1MB=1024*1024;
	
	/**
	 * 这个成员属性的唯一意义就是占点内存，以便能在GC日志中看清楚是否被回收过
	 */
	private byte [] bigSize=new byte[2*_1MB];
	public static void testGC(){
		ReferenceCountingGC obj1=new ReferenceCountingGC();
		ReferenceCountingGC obj2=new ReferenceCountingGC();
		obj1.instance=obj2;
		obj2.instance=obj1;
		obj1=null;
		obj2=null;
		//假设在这行发生GC,objA和objB是否能被回收？
		System.gc();
	}
    
	public static void main(String[] args) {
		testGC();
	}
}
