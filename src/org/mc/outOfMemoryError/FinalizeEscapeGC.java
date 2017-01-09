package org.mc.outOfMemoryError;
/**
 * 
 * @author machao
 *�˴�����ʾ�����㣺
 *1.��������ڱ�GCʱ�������ȡ�
 *2.�����ԾȵĻ���ֻ��һ�Σ���Ϊһ�������finalize�����������ֻ�ᱻϵͳ�Զ�����һ��
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
		/*�������Ҫ��finalize�����гɹ������Լ�����ֻҪ������������
		�ϵ��κ�һ���������������ɣ�Ʃ����Լ���this�ؼ��֣���ֵ��ĳ����������߶����
		��Ա���������ڵڶ��α��ʱ�������Ƴ������������ա��ļ��ϣ�*/
		FinalizeEscapeGC.SAVE_HOOK=this;
	}
	
	public static void main(String[] args) throws Throwable {
		SAVE_HOOK=new FinalizeEscapeGC();
		//�����һ�γɹ������Լ�
		SAVE_HOOK=null;
		System.gc();
		//��Ϊfinalize�������ȼ��ܵ�,������ͣ0.5���Եȴ���
		Thread.sleep(500);
		if(SAVE_HOOK!=null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("no,i am dead:1(");
		}
		//������δ������������ȫ��ͬ,��������Ծ�ȴʧ����
		SAVE_HOOK=null;
		System.gc();
		//��Ϊfinalize�������ȼ��ܵ�,������ͣ0.5���Եȴ���
		Thread.sleep(500);
		if(SAVE_HOOK!=null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("no,i am dead:2(");
		}
		
	}

}
