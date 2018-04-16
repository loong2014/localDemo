package listpkg;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetMain {

	private static void logList(TreeSet<Object> setList) {
		System.out.println("size :" + setList.size());
		Iterator<Object> it = setList.iterator();
		while (it.hasNext()) {
			Object obj = (Object) it.next();
			System.out.println("info :" + obj);
		}
	}

	private static void caseWithComparator() {
		TreeSet<Object> setList = new TreeSet<Object>();
		// 元素如果是对象，则需要实现Comparable接口

		boolean state = false;
		System.out.println("\n=== treeSetCase =>");

		// 1 可以存入null
		System.out.println("\ncase-1 :");
		try {
			state = setList.add(null);
			logList(setList);
		} catch (Exception e) {
			System.out.println("不能添加null元素 e :" + e);
		}

		TreeSetInfo info1 = new TreeSetInfoWithComparator("aaa");
		TreeSetInfo info2 = new TreeSetInfoWithComparator("bbb");
		TreeSetInfo info3 = new TreeSetInfoWithComparator("ccc");

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

	static class MyComparator implements Comparator<Object> {

		@Override
		public int compare(Object obj1, Object obj2) {
			TreeSetInfo info1 = (TreeSetInfo) obj1;
			TreeSetInfo info2 = (TreeSetInfo) obj2;
			return info2.name.compareToIgnoreCase(info1.name);
 		}

	}

	private static void caseWithFactory() {
		TreeSet<Object> setList = new TreeSet<Object>(new MyComparator());
		// 元素如果是对象，则需要实现Comparable接口

		boolean state = false;
		System.out.println("\n=== treeSetCase =>");

		// 1 可以存入null
		System.out.println("\ncase-1 :");
		try {
			state = setList.add(null);
			logList(setList);
		} catch (Exception e) {
			System.out.println("不能添加null元素 e :" + e);
		}

		TreeSetInfo info1 = new TreeSetInfo("aaa");
		TreeSetInfo info2 = new TreeSetInfo("bbb");
		TreeSetInfo info3 = new TreeSetInfo("ccc");

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

	public static void main(String[] args) {
		// caseWithComparator();
		caseWithFactory();
	}

}
