package org.mc.outOfMemoryError;


/**
 * @author machao
 * Created in 2017/01/05
 * VM Args:-Xss2m
 */
public class JavaVMStackOOM {
	static long i=1;
	private void dontStop(){
		while(true){
			
		}
	}
	public void stackLeakByThread(){
		while(true){
			Thread thread=new Thread(new Runnable(){
				@Override
				public void run() {
					dontStop();
				}
			});
			thread.start();
		}
	}
	
	public static void main(String[] args) throws Throwable {
		JavaVMStackOOM js=new JavaVMStackOOM();
		js.stackLeakByThread();
	}

}
