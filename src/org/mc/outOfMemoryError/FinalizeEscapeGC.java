package org.mc.outOfMemoryError;
/**
 * 
 * @author machao
 *此代码演示了两点：
 *1.对象可以在被GC时自我拯救。
 *2.这种自救的机会只有一次，因为一个对象的finalize（）方法最多只会被系统自动调用一次
 */
public class FinalizeEscapeGC {
	public static FinalizeEscapeGC SAVE_HOOK=null;
	public void isAlive(){
		System.out.println("yes,i am still alive:)");
	}
	
	
	@Override
	protected void finalize() throws Throwable{
		super.finalize();
		System.out.println("finalize method executed!");
		/*如果对象要在finalize（）中成功拯救自己——只要重新与引用链
		上的任何一个对象建立关联即可，譬如把自己（this关键字）赋值给某个类变量或者对象的
		成员变量，那在第二次标记时它将被移除出“即将回收”的集合；*/
		FinalizeEscapeGC.SAVE_HOOK=this;
	}
	
	public static void main(String[] args) throws Throwable {
		SAVE_HOOK=new FinalizeEscapeGC();
		//对象第一次成功拯救自己
		SAVE_HOOK=null;
		System.gc();
		//因为finalize方法优先级很低,所以暂停0.5秒以等待它
		Thread.sleep(500);
		if(SAVE_HOOK!=null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("no,i am dead:1(");
		}
		//下面这段代码与上面的完全相同,但是这次自救却失败了
		SAVE_HOOK=null;
		System.gc();
		//因为finalize方法优先级很低,所以暂停0.5秒以等待它
		Thread.sleep(500);
		if(SAVE_HOOK!=null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("no,i am dead:2(");
		}
		
	}

}
