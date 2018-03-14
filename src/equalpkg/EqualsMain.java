package equalpkg;

import java.util.HashMap;
import java.util.Map;

public class EqualsMain {

	private static void test1() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("d", 10);
		Object b = map.get("c");

		boolean same = "null".equals(b);
		System.out.println(same);
	}

	public static void main(String[] args) {
		test1();
	}
}
