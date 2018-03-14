package comprablepkg;

public class ComprableA implements Comparable<ComprableA> {

	private int age;
	private String name;
	private String birthDay;

	@Override
	public int compareTo(ComprableA o) {
		// TODO Auto-generated method stub
		if (this.age == o.age) {
			return 0;
		} else if (this.age < o.age) {
			return -1;
		} else {
			return 1;
		}
		
		
		
		
	}
	
}
