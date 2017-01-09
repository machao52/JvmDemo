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
	 * �����Ա���Ե�Ψһ�������ռ���ڴ棬�Ա�����GC��־�п�����Ƿ񱻻��չ�
	 */
	private byte [] bigSize=new byte[2*_1MB];
	public static void testGC(){
		ReferenceCountingGC obj1=new ReferenceCountingGC();
		ReferenceCountingGC obj2=new ReferenceCountingGC();
		obj1.instance=obj2;
		obj2.instance=obj1;
		obj1=null;
		obj2=null;
		//���������з���GC,objA��objB�Ƿ��ܱ����գ�
		System.gc();
	}
    
	public static void main(String[] args) {
		testGC();
	}
}
