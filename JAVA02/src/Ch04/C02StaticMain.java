package Ch04;



class C02Simple
{
	static int n1;
	int n2;
	
	void func1() {
		n1=100;
		n2=200;
	}
	static void func2() {
		n1=300;
//		n2=400;		// 문제 발생 왜? 
					// static 함수에서 사용되는 변수는 , static변수 or 지역변수만 가능(일반멤버변수 사용x)		
	}
}

public class C02StaticMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
