package Ch07.삼조;

public class Div implements Ch07.삼조.Calculation{
	
	@Override
	public void Run(int n1, int n2) {
		System.out.println("삼조 혜연 나눗셈 결과1 : " + (double)n1 / n2);
	}
	
	public void Run(int ... arg) {
		for(int i : arg) { //배열 큰 것 부터 재배열
			
		}
		
		System.out.println("삼조 혜연 나눗셈 결과2 : ");
	}

}
