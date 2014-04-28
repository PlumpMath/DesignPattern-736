package TemplateMethod;

abstract public class CommonBatchTemplate {
	
	/**
	 *  공통적인 비지니스 로직이 포함되는 Template Method.
	 */
	public void executeBathcJob() {
		this.setConfig();
		
		this.connectDb();
		
		this.printInfo();
		this.runTask();
		this.printResult();
		
		this.closeDb();
	}
	
	
	/**
	 *  서브클래스에서 구현해야할 추상메소드
	 */
	abstract protected void printInfo();
	abstract protected void runTask();
	abstract protected void printResult();
		
	
	/**
	 * 환경설정 파일 로드. DB정보, logfile정보 등
	 */
	private void setConfig() {
		System.out.println(" called setConfig() ");
	}
	
	/**
	 * Jdbc Connect 작업
	 */
	private void connectDb() {
		System.out.println(" called connectDb() ");
	}
	
	/**
	 * Jdbc close
	 */
	private void closeDb() {
		System.out.println(" called closeDb() ");
	}

}
