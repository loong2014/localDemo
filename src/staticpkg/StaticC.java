package staticpkg;

public class StaticC {
	public static   String MSG = "StaticC MSG";
	public static   String MSGB = "StaticC MSGB";
	static {
		System.out.println("StaticC static block");
	}
	public StaticC() {
 		System.out.println("StaticC struct init :"+this);
	}
}
