package TemplateMethod;

public class SimpleBatch extends CommonBatchTemplate {

	@Override
	protected void printInfo() {
		// TODO Auto-generated method stub
		System.out.println("=== Simple Batch Start! ===");

	}

	@Override
	protected void runTask() {
		// TODO Auto-generated method stub
		/**
		 * 실제 작업에 해당하는 내용을 구현
		 */
		for( int i=0; i<10; ++i )
			System.out.println( i );

	}

	@Override
	protected void printResult() {
		// TODO Auto-generated method stub
		System.out.println("=== Simple Batch End! ===");

	}
	
	
	public static void main(String[] args) {
		// 추상클래스의 Template Method 를 호출해준다.
		new SimpleBatch().executeBathcJob();
	}

}
