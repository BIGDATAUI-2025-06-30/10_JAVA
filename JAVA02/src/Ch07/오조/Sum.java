package Ch07.오조;

public class Sum implements Ch07.오조.Calculation {
	// 함수 오버로딩으로
	// public void run(int n1, int n2){}, public void run(int... nums){}, public void run(double... nums){}, public void run(String... strings){} 이렇게 4개를 만들어주세요.
	@Override
	public void Run(int n1, int n2) {
		// TODO Auto-generated method stub
		System.out.println("오조 심예진 덧셈결과 : " + (n1 + n2));
	}

	@Override
	public void Run(int... nums) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int num : nums) {
			sum +=num;
		}
		System.out.println("오조 심예진 n개 인자 덧셈결과 : " + sum);
	}

	@Override
	public void Run(double... nums1) {
		// TODO Auto-generated method stub
		double sum1 = 0;
		for(double num : nums1) {
			sum1 += num;
		}
		System.out.println("오조 심예진 n개 인자 덧셈결과 : " + sum1);
	}

	@Override
	public void Run(String... strings) {
		// TODO Auto-generated method stub
		String sum2 = "";
		for(String str : strings) {
			sum2 += str;
		}
		System.out.println("오조 심예진 n개 문자열 덧셈결과 : " + sum2);
	}
	
}


