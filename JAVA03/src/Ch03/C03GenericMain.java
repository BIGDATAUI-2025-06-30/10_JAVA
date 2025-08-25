package Ch03;

class Person{
	String name;
	String age;
	String addr;
	//생성자
	public Person(String name, String age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
}

class Man extends Person{
	//생성자
	public Man(String name, String age, String addr) {
		super(name, age, addr);
		
	}
	//toString
	@Override
	public String toString() {
		return "Man [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
	
}

class Woman extends Person{
	//생성자
	public Woman(String name, String age, String addr) {
		super(name, age, addr);
	}
	//toString
	@Override
	public String toString() {
		return "Woman [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
	
}

class Couple<X extends Person , Y  extends Person>{
	private X member1;
	private Y member2;
	//생성자
	public Couple(X member1, Y member2) {
		super();
		this.member1 = member1;
		this.member2 = member2;
	}
	//toString
	@Override
	public String toString() {
		return "Couple [member1=" + member1 + ", member2=" + member2 + "]";
	}
	

	
}

public class C03GenericMain {

	public static void main(String[] args) {
		
		Couple<Man,Woman> couple1 = new Couple<Man,Woman>(new Man("철수","50","대구"),new Woman("영희","40","울산"));
		System.out.println("couple1 : " + couple1);
		
		Couple<Man,Man> couple2 = new Couple<Man,Man>(new Man("홍길동1","30","대구"),new Man("홍길동2","25","인천"));
		System.out.println("couple2 : " + couple2);
		
//		Couple<Double,Integer> couple3 = new Couple<Double,Integer>(100.5,200);
//		System.out.println("couple3 : " + couple3);
		
	}

}
