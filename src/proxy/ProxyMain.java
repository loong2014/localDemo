package proxy;

public class ProxyMain {

	private static void logI(String msg){
		System.out.println("ProxyMain :"+msg);
	}
	
	public static void main(String[] args) {
		logI("main");
		
		ProxyA proxyA = new ProxyA();
		logI("binder");
		IAFunc iaFunc =(IAFunc) new TimeConsumeProxy().binder(proxyA);
		logI("doA");
		iaFunc.doA();
		
//		ProxyB proxyB = new ProxyB();
//		IBFunc ibFunc =(IBFunc)new TimeConsumeProxy().binder(proxyB);
//		ibFunc.doB();
		
		
	}
}
