package listpkg;

public class TreeSetInfoWithComparator extends TreeSetInfo implements Comparable<Object> {

	public TreeSetInfoWithComparator(String name) {
		super(name);
	}

	/**
	 * 自定义排序，按name的首字母排序(不区分大小写)
	 */
	@Override
	public int compareTo(Object obj) {
		TreeSetInfoWithComparator info = (TreeSetInfoWithComparator) obj;
		return this.name.compareToIgnoreCase(info.name);
	}
}
