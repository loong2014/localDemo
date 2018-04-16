package method;

import java.lang.annotation.Native;

import proxy.IBFunc;

public class SuperClassB extends SuperClassA  implements IBFunc{

	private String strPriB;

	public String strPubB;

	protected String strProB;

	String strPkgB;

	private void getPrivateB() {

	}
	@MyAnnotation(subName = "publicB")
	public void getPublicB(String name) {

	}

	protected void getProtectedB() {

	}

	void getPackageB() {

	}

	@Override
	public void doB() {		
	}

}
