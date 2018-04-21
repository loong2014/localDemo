
package repase;

public class RepaseMain {

	public static void main(String[] args) {

		String str = "aa&splatid=501&splatid=121&splatid=503";
		System.out.println("old str :" + str);

		String newStr = str.replace("splatid=[0-9][0-9][0-9]", "splatid=521");
		System.out.println("new str :" + newStr);
		
		
		Integer num=null;
		
		// 直接进行判断会报异常
		if (num ==1) {
			System.out.println("dsfasfddasfa");
		}
	}
}
