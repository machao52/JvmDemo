package org.mc.outOfMemoryError;


import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * @author machao
 * ʹ��unsafe���䱾���ڴ�
 * VM Args:-Xmx20m -XX:MaxDirectMemorySize=10m
 * DirectMemory������ͨ��-XX��MaxDirectMemorySizeָ���������ָ������Ĭ����Java
 * �����ֵ��-Xmxָ����һ���������嵥2-9Խ����DirectByteBuffer�ֱ࣬��ͨ�������ȡ
 *	Unsafeʵ�������ڴ���䣨Unsafe���getUnsafe��������������ֻ��������������Ż᷵��
 *ʵ����Ҳ���������ϣ��ֻ��rt.jar�е������ʹ��Unsafe�Ĺ��ܣ�����Ϊ����Ȼʹ��
 *DirectByteBuffer�����ڴ�Ҳ���׳��ڴ�����쳣�������׳��쳣ʱ��û�����������ϵͳ��
 *������ڴ棬����ͨ�������֪�ڴ��޷����䣬�����ֶ��׳��쳣��������������ڴ�ķ�
 *����unsafe.allocateMemory������
 */
public class DirectMemoryOOM {
	
	private static final int _1MB=1024*1024;
	
	public static void main(String[] args) throws Exception {
		Field unsafeField=Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		Unsafe unsafe=(Unsafe) unsafeField.get(null);
		while(true){
			unsafe.allocateMemory(_1MB);
		}
	}
}
