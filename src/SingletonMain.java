
public class SingletonMain {

	public static void main( String[] args ) {
		System.out.println("Start.");
		Singleton sgt1 = Singleton.getInstance();
		Singleton sgt2 = Singleton.getInstance();
		if( sgt1 == sgt2 )
			System.out.println("sgt1 과 sgt2 는 같은 객체입니다.");
		else
			System.out.println("sgt1 과 sgt2 는 다른 객체입니다.");
		
		 System.out.println("End.");
		 
		 System.out.println("");
	}
}
