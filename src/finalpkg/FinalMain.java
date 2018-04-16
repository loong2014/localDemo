package finalpkg;

public class FinalMain {
	
	
	private static class InnerClass {
		private static  final int i = 100;
	}

	public static void main(String[] args) {
		// FinalA finalA;
		// finalA = new FinalA();
//		 FinalA.getInt();

	int i = 	InnerClass.i;
		
		
//		for (int i = 0; i < 20; i++) {
//			int num = i;
//			new Thread(new Runnable() {
//
//				@Override
//				public void run() {
//					// TODO Auto-generated method stub
//					System.out.println(this + "  " + num + "  : " + FinalA.getInt());
//
//				}
//			}).start();
//		}
	
	String string = "/adfadfa";
	String[] strPart = string.split("/");
	
	System.out.println(" :"+strPart[0]);
	for(String string2 :strPart){
		System.out.println("str :"+string2);
	}
	}

}
