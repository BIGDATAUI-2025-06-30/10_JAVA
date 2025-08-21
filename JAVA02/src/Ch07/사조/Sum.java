package Ch07.사조;

public class Sum implements Ch07.사조.Calculation{

	@Override
	public void Run(int n1, int n2) {
		System.out.println("일조 누구 덧셈결과 : " + n1 + n2);
	}
}
