package staticpkg;

import java.awt.font.TextHitInfo;

import Singletonpkg.SingletonA;

public class StaticMain {

	public static void main(String[] args) {
		// StaticB staticB = new StaticB();
		
//		 System.out.println(" 1 :"+StaticB.MSGA);
		// System.out.println(" 2 :"+StaticA.MSG);
		try {
//			StaticB staticA = (StaticB) Class
//					.forName("staticpkg.StaticB").newInstance();
			
		 Class c = Class.forName("staticpkg.StaticB");
		 StaticA sA = (StaticA)c.newInstance();
		 
//		 StaticA sA2 = new StaticA();
		 sA.getClass().getClassLoader().loadClass("staticpkg.StaticC");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
