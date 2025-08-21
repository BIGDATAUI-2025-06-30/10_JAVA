package Ch07.일조;

public class Sum implements Ch07.일조.Calculation{

	@Override
	public void Run(int n1, int n2) {	// n1, n2 의 두 수를 받아 두 수의 합을 console창에 출력
		int sum = n1 + n2;
		System.out.printf("일조 이인호 덧셈 결과: %d\n", sum);
	}

	@Override
	public void Run(int n1, int n2, int n3, int n4, int n5) {
		int sum = n1 + n2 + n3 + n4 + n5;
		System.out.printf("일조 이인호 덧셈 결과: %d\n", sum);
		
	}

	@Override
	public void Run(double n1, double n2, double n3, double n4, double n5) {
		double sum = n1 + n2 + n3 + n4 + n5;
		System.out.printf("일조 이인호 덧셈 결과: %f\n", sum);	
	}

	@Override
	public void Run(String s1, String s2, String s3, String s4, String s5) {
		System.out.println(s1 + s2 + s3 + s4 + s5);
	}

	

	

}
