package Ch01;

//생성자메서드
//ex) Scanner sc = new Scanner(System.in)
//생성자메서드 Scanner();

//객체 생성시 한번만 호출되는 메서드
//생성된 객체 내에서는 사용이 불가능
//객체 생성시에 필요한 메모리공간 형성과 "초기값 부여" 에 사용
//생성자 메서드의 이름은 클래스이름과 동일하게 부여
//생성자 메서드는 반환자료형을 가지지 않습니다

//생성자 함수를 클래스 내에 명시하지 않으면(코드삽입x) 
//컴파일러에 의해 기본 생성자 함수가 주입된다(디폴트 생성자)


class C08Simple{
	//속성
	int n1;
	double n2;
	boolean n3;
	String n4;
	//기능
	
	//디폴트 생성자 메서드
	C08Simple(){
		System.out.println("C08Simple() 생성자 호출");
		this.n1=10;
		this.n2=10.10;
		this.n3=true;
		this.n4="TEST";
	}
	C08Simple(int n1){
		System.out.println("C08Simple(int n1) 생성자 호출");
		this.n1 = n1;
	}
	C08Simple(int n1,double n2){
		System.out.println("C08Simple(int n1,double n2) 생성자 호출");
		this.n1 = n1;
		this.n2 = n2;
	}
	C08Simple(int n1,double n2,boolean n3){
		System.out.println("C08Simple(int n1,double n2,boolean n3) 생성자 호출");
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
	}
//	C08Simple(int n1,double n2,boolean n3,String n4){
//		System.out.println("C08Simple(int n1,double n2,boolean n3,String n4) 생성자 호출");
//		this.n1 = n1;
//		this.n2 = n2;
//		this.n3 = n3;
//		this.n4 = n4;
//	}
	
	public C08Simple(int n1, double n2, boolean n3, String n4) {
		super();
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
		this.n4 = n4;
	}	
	
	@Override
	public String toString() {
		return "C08Simple [n1=" + n1 + ", n2=" + n2 + ", n3=" + n3 + ", n4=" + n4 + "]";
	}

	
}

public class C08ConstructorMain {

	public static void main(String[] args) {
		C08Simple ob0 = new C08Simple();
		C08Simple ob1 = new C08Simple(10);
		C08Simple ob2 = new C08Simple(10,10.10);
		C08Simple ob3 = new C08Simple(10,20.20,true);
		C08Simple ob4 = new C08Simple(10,20.20,true,"홍길동");
		
		System.out.println(ob0);
		System.out.println(ob1);
		System.out.println(ob2);
		System.out.println(ob3);
		System.out.println(ob4);
	}
}
