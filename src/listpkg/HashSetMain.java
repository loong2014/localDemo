package listpkg;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class HashSetMain {

	private static void logList(Set<HashSetInfo> setList) {
		System.out.println("size :" + setList.size());
		Iterator<HashSetInfo> it = setList.iterator();
		while (it.hasNext()) {
			Object obj = (Object) it.next();
			System.out.println("info :" + obj);
		}
	}

	public static void main(String[] args) {
		Set<HashSetInfo> setList = new HashSet<>();
		boolean state = false;
		System.out.println("\n=== hashSetCase =>");

		// 1 可以存入null
		System.out.println("\ncase-1 :");
		state = setList.add(null); // true
		logList(setList);

		HashSetInfo info1 = new HashSetInfo("aaa");
		HashSetInfo info2 = new HashSetInfo("bbb");
		HashSetInfo info3 = new HashSetInfo("ccc");

		// 2 存储相同元素时，只保留第一个元素，后续元素无法存入
		System.out.println("\ncase-2 :");
		setList.clear();
		state = setList.add(info1); // true
		state = setList.add(info1); // false
		logList(setList);

		// 3 存入顺序与取出顺序不保证一致性
		System.out.println("\ncase-3 :");
		setList.clear();
		state = setList.add(info1); // true
		state = setList.add(info2); // true
		state = setList.add(info3); // true
		logList(setList);
	}

}
