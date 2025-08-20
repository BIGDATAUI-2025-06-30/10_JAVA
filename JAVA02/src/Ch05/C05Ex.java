package Ch05;

class Employee {
	public String name;
	protected int age;
	protected String addr;
	
	//기본생성자
	//모든인자생성자
	public Employee() {}
	public Employee(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
class Parttimer extends Employee  {
	private int hour_pay;
	
	//기본
	public Parttimer() {}
	//모든인자
	public Parttimer(String name, int age , String addr, int hour_pay) {
		super(name,age,addr);
		this.hour_pay=hour_pay;
	}
	
	public void setHour_pay(int hour_pay) {
		this.hour_pay = hour_pay;
	}
	
	//
	@Override
	public String toString() {
		return "Parttimer [hour_pay=" + hour_pay + ", name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}

	
	

}
class Regular extends Employee {
	private int salary;

	//기본
	public Regular() {}
	//모든인자
	public Regular(String name,int age,String addr,int salary) 
	{
		super(name,age,addr);
		this.salary=salary;
	}
	@Override
	public String toString() {
		return "Regular [salary=" + salary + ", name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
	
}

public class C05Ex {

	public static void main(String[] args) {
		Parttimer emp1 = new Parttimer("홍길동", 25, "대구", 20000);
		emp1.setAge(100);
		
		Regular emp2 = new Regular("서길동", 45, "울산", 50000000);
		System.out.println(emp1);
		System.out.println(emp2);
	}

}
