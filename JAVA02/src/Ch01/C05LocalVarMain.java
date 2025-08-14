package Ch01;

// 변수 종류

// 멤버 변수		: 클래스 내부 - 메서드 영역 외부 사이 , 객체 개별데이터 저장용도
// 지역 변수		: 메서드 영역 내부에서 생성되는 변수
//				  (or 매서드 영역 내부에서 {}가 명시되어 있을때 해당{} 내에서 생성되는 변수도 포함)
//				  파라미터변수,일반변수..	
// static 변수 	: 동일 클래스로부터 생성된 여러 객체간 공유하는 멤버변수


class C05Simple
{
	//속성	
	int num = 10;	//멤버변수
	
	//기능
	void Func1() {
		System.out.println("num : " + num);
		int num=20;	//Func1 의 지역변수
		num++;
		this.num++;
		System.out.println("num : " + num);
	}
	void Func2() {
		System.out.println("num : " + num);
		if(num>0) // 멤버변수 num
		{
			int num=100;	// if문 내의 지역변수 num
			System.out.println("num : " + num);
		}
		System.out.println("num : " + num); //멤버변수 num
		while(num<15) {
			int num=100;
			System.out.println("num : " + num);
			num++;
		}
	}
	//
	void Func3(int num) {
		this.num = num;
	}
	
	
}
public class C05LocalVarMain {
	public static void main(String[] args) {

		C05Simple obj = new C05Simple();
		obj.Func1();
		System.out.println("---------------");
		obj.Func2();
	}

}
