package Ch07.오조;

public class Sum implements Ch07.오조.Calculation {
	// 함수 오버로딩으로
	// public void run(int n1, int n2){}, public void run(int... nums){}, public void run(double... nums){}, public void run(String... strings){} 이렇게 4개를 만들어주세요.
	// 그리고 {}안에서 Scanner를 사용하여 인자들을 조건에 맞게 받아서 연산하고 그 연산식을 System.out.println("");으로 출력하는 함수까지 만들어주세요

	@Override
	public void Run(int n1, int n2) {
		// TODO Auto-generated method stub
		System.out.println("오조 심예진 덧셈결과 : " + n1 + n2);
	}

	@Override
	public void Run(int... nums) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Run(double... nums1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Run(String... strings) {
		// TODO Auto-generated method stub
		
	}
	
	}

}
