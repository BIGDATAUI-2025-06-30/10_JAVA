package Ch07.사조;

public class Div implements Calculation {

	@Override
	public void Run(int n1, int n2) {
		int n3;
		if(n1 > n2) {
			n3 = n1;
			n1 = n2;
			n2 = n3;
			int div = n1/n2;
			System.out.println("4조 김홍섭 나눗셈 결과 : "+ div );
		}
		
	}
	

}
