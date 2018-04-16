package listpkg;

public class TreeSetInfo {

	public String name;

	public TreeSetInfo(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return super.toString() + " : " + this.name;
	}

	/**
	 * 自定义比较
	 */
	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof TreeSetInfo)) {
			return false;
		}

		TreeSetInfo info = (TreeSetInfo) obj;
		return this.name.equals(info.name);
	}
}
