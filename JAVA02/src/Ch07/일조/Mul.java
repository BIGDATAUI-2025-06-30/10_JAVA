package Ch07.일조;

public class Mul implements Ch07.일조.Calculation{

	@Override
	public void Run(int n1, int n2) {
		System.out.println("1조 이수현 곱셈 결과 : " + n1*n2);
	}
	public void Run(int n1, int n2, int n3, int n4, int n5) {
		System.out.println("1조 이수현 곱셈 결과 : " + n1*n2*n3*n4*n5);
	}
	public void Run(double n1, double n2, double n3, double n4) {
		System.out.println("1조 이수현 곱셈 결과 : " + n1 * n2* n3 * n4);
	}
	public void Run(String str1, String str2, String str3, String str4) {
		System.out.println("1조 이수현 곱셈 결과 : " + str1 * str2 * str3 * str4);
		 
	}
	

}
