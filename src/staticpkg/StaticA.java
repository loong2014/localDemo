package staticpkg;

public class StaticA {

	public static final String MSG = "StaticA MSG";
	public static final String MSGA = "StaticA MSGA";
//	public static final String MSGA;

	static {
//		MSGA = "StaticA MSGA";
		System.out.println("StaticA static block");
	}

	public StaticA() {
 		System.out.println("StaticA struct init :"+this);
	}
}
