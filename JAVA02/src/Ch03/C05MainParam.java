package Ch03;

public class C05MainParam {
	
	public static void main(String[] args) {
		System.out.println("length : " + args.length);
		for(String param : args) {
			System.out.println(param);
		}
	}
}
