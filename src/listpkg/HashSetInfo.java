package listpkg;

public class HashSetInfo {

	private String name;

	public HashSetInfo(String name) {
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

		if (!(obj instanceof HashSetInfo)) {
			return false;
		}

		HashSetInfo info = (HashSetInfo) obj;
		return this.name.equals(info.name);
	}
}
