package org.mc.outOfMemoryError;


/**
 * @author machao
 * Created in 2017/01/04
 * VM Args:-Xss128k
 */
public class JavaVMStackSOF {
	
	private int stackLength=1;
	
	public void stackLeak(){
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) {
		JavaVMStackSOF oom=new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("stack length: "+oom.stackLength);
			throw e;
		}
	}

}
