package listpkg;

import java.util.ArrayList;
import java.util.List;

public class ListMain {

	public static class Bean {
		public String name;
		public int age;

		public Bean(String name, int age) {
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			return "[" + name + " , " + age + "]";
		}
	}

	public static Bean buildBean(String name, int age) {
		return new Bean(name, age);
	}

	public static void main(String[] args) {
		List<Bean> list = new ArrayList<>(4);
		
		System.out.println("size :"+list.size());

		showList(list, 1);
		list.add(buildBean("aaa", 111));
		showList(list, 2);

		list.add(0, buildBean("bbb", 222));
		showList(list, 3);
		
		
	}

	public static void showList(List<Bean> list, int logIndex) {
		System.out.println("\n\n" + logIndex + " --- size :" + list.size());
		int len = list.size();
		for(int i=0;i<len;i++){
			System.out.println(i + " --- " + list.get(i).toString());
		}

	}

}
