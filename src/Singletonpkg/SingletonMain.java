package Singletonpkg;

 
public class SingletonMain {

	public static void main(String[] args) {

		SingletonA singletonA = new SingletonA();
		SingletonA.InnerClass innerClass =   singletonA.new InnerClass();
		
		SingletonA.StaticInnerClass staticInnerClass = new SingletonA.StaticInnerClass();
		
	}
}
