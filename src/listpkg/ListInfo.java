package listpkg;

public class ListInfo {

	private String name;

	public ListInfo(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return super.toString() + " : " + this.name;
	}
}
