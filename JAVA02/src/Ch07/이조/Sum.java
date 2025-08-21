package Ch07.이조;

public class Sum implements Ch07.이조.Calculation{
	private int result;
	@Override
	public void Run(int n1, int n2) {
		result = n1 + n2;
		System.out.println("이조 전익환 덧셈결과 : "+result);
		
	}
	@Override
	public void Run(int... args) {
		result = 0;
		for(int num: args) {
			result+=num;
			System.out.println("이조 전익환 덧셈결과(n개) : "+result);
		}
		
	}
	@Override
	public void Run(double... args) {
		double result =0.0;
		for(double num : args) {
			double result1 = num;
			System.out.println("이조 전익환 덧셈결과(n개 소수점) : "+ result1);
		}
		
	}
	@Override
	public void Run(String... args) {
		
		
	}


}
