
public class SingletonMain {

	public static void main( String[] args ) {
		System.out.println("Start.");
		Singleton sgt1 = Singleton.getInstance();
		Singleton sgt2 = Singleton.getInstance();
		if( sgt1 == sgt2 )
			System.out.println("sgt1 �� sgt2 �� ���� ��ü�Դϴ�.");
		else
			System.out.println("sgt1 �� sgt2 �� �ٸ� ��ü�Դϴ�.");
		
		 System.out.println("End.");
		 
		 System.out.println("");
	}
}
