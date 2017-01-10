package org.mc.outOfMemoryError;


/**
 * Created in 2017/01/10
 * @author machao
 * VM参数: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
 *        -XX:SurvivorRatio=8
 * 解释:-XX:+UseSerialGC, 打开此开关后,使用Serial+Serial Old的收集器组合
 * 进行内存回收.由于本机默认的垃圾收集器是Parallel Scavenge+Parallel Old的
 * 收集器组合进行内存回收,所以加与不加(-XX:+UseSerialGC)看到的GC收集日志的结果
 * 不一样.       
 *        
 */
public class Allocation {
	
	private static final int _1MB=1024*1024;
	
	public static void testAllocation(){
		byte[] allocation1,allocation2,allocation3,allocation4;
		/*allocation1=new byte[2*_1MB];
		allocation2=new byte[2*_1MB];
		allocation3=new byte[2*_1MB];*/
		allocation4=new byte[5*_1MB];
	}
    	
	public static void main(String[] args) {
		testAllocation();
	}
	


}
