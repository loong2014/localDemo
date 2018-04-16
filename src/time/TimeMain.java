package time;

import java.text.SimpleDateFormat;

public class TimeMain {

	public static void main(String[] args) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		long curTime = System.currentTimeMillis();
//		curTime = 1521240000000L;
		System.out.println("curTime :"+curTime);
		String curDataStr =  format.format(curTime);
		System.out.println("curDataStr :"+curDataStr);
		
		
	}
}
