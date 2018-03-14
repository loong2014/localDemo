package staticpkg;

public class StaticB extends StaticA {

	public static final String MSG = "StaticB MSG";
	public static final String MSGB = "StaticB MSGB";
	static {
		System.out.println("StaticB static block");
	}

	public StaticB() {
		super();
		System.out.println("StaticB struct init :" + this);
	}
}
