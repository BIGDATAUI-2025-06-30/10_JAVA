package Ch07.오조;



public class Mul implements Ch07.오조.Calculation{

	@Override
	public void Run(int n1, int n2) {
		int Val =1;
		
		Val = n1 * n2;
		System.out.println("5조 지원이의 두 수 곱셈값은!?" + Val);
	}

	@Override
	public void Run(int... nums) {
		int Val = 1;
		for (int i = 0; i < nums.length; i++) {
		    Val *= nums[i];   // i번째 값 꺼내서 곱하기
		}
		System.out.println("5조 지원이의 배열 곱셈값은!?" + Val);
	}

	@Override
	public void Run(double... nums1) {
		double Val = 1;
		for (int i = 0; i < nums1.length; i++) {
		    Val *= nums1[i];   // i번째 값 꺼내서 곱하기
		}
		System.out.println("5조 지원이의 배열 곱셈값은!?" + Val);
	
	}

	@Override
	public void Run(String... strings) {
		StringBuilder sv = new StringBuilder();
		    for (String s : strings) {
		        sv.append(s);   // 그냥 이어붙이기
		    }
		System.out.println("5조 지원이의 문자배열 곱셈값은!?" + sv.toString());
	
	}
	
}


	

	
	
