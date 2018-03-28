package listpkg;

import java.util.HashSet;
import java.util.Set;

public class SetMain {

	public static void main(String[] args) {
		Set<ListInfo> setList = new HashSet<>();

		// 1 可以存入null
		setList.add(null);
		for (ListInfo info : setList) {
			System.out.println("info 1 :" + info);
		}

		setList.clear();
		ListInfo info1 = new ListInfo("aaa");
		ListInfo info2 = new ListInfo("bbb");
		ListInfo info3 = new ListInfo("ccc");

		// 2 存储相同元素时，只保留第一个元素，后续元素无法存入
		setList.add(info1);
		setList.add(info1);
		setList.add(info1);
		for (ListInfo info : setList) {
			System.out.println("info 2 :" + info);
		}

		// 3 存入顺序与取出顺序不保证一致性
		setList.clear();
		setList.add(info1);
		setList.add(info2);
		setList.add(info3);
		for (ListInfo info : setList) {
			System.out.println("info 3 :" + info);
		}
	}

}
