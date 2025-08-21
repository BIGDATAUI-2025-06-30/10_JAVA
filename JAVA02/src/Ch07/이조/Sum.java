package Ch07.이조;

public class Sum implements Ch07.이조.Calculation{
	private int result;
	@Override
	public void Run(int n1, int n2) {
		result = n1 + n2;
		System.out.println("이조 전익환 덧셈결과 : "+result);
		
	}


}
