package Ch05;


class A{
	int a;
	//toSting 재정의

	@Override
	public String toString() {
		return "A [a=" + a + "]";
	}
	
}
class B extends A{
	int b;
	//toSting 재정의

	@Override
	public String toString() {
		return "B [b=" + b + ", a=" + a + "]";
	}
	
}
class C extends A{
	int c;
	//toSting 재정의

	@Override
	public String toString() {
		return "C [c=" + c + ", a=" + a + "]";
	}
	
}
class D extends B{
	int d;
	//toSting 재정의

	@Override
	public String toString() {
		return "D [d=" + d + ", b=" + b + ", a=" + a + "]";
	}
	
}
class E extends B{
	int e;
	//toSting 재정의

	@Override
	public String toString() {
		return "E [e=" + e + ", b=" + b + ", a=" + a + "]";
	}
	
}
class F extends C{
	int f;
	//toSting 재정의

	@Override
	public String toString() {
		return "F [f=" + f + ", c=" + c + ", a=" + a + "]";
	}
	
}
class G extends C{
	int g;
	//toSting 재정의

	@Override
	public String toString() {
		return "G [g=" + g + ", c=" + c + ", a=" + a + "]";
	}
	
}



public class C07UpDownCastingMain {
	
	public static void UpDownCastTestFunc(A obj) //Upcasting
	{									// A obj = new A();	//NoCasting
										// A obj = new B();	//Upcasting
										// A obj = new C(); //Upcasting
		obj.a=100;
		
		if(obj instanceof B) {
			B down = (B)obj;
			down.b=200;	
		}
		if(obj instanceof C) {
			C down = (C)obj;
			down.c=300;
		}
		// 나머지 if문으로 만들어줍니다
		if(obj instanceof D) {
			D down = (D)obj;
			down.d=400;
		}	
		if(obj instanceof E) {
			E down = (E)obj;
			down.e=500;
		}
		System.out.println(obj);
	}
	
	public static void main(String[] args) {

		UpDownCastTestFunc(new A());
		UpDownCastTestFunc(new B());
		UpDownCastTestFunc(new C());
		UpDownCastTestFunc(new D());
		UpDownCastTestFunc(new E());

	}

}
