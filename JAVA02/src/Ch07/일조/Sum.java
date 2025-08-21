package Ch07.일조;

public class Sum implements Ch07.일조.Calculation{

	@Override
	public void Run(int n1, int n2) {
		int sum = n1 + n2;
		System.out.printf("일조 이인호 덧셈 결과: %d", sum);
	}

	

	

}
