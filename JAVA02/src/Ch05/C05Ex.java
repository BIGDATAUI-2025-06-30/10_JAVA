package Ch05;

class Employee {
	public String name;
	private int age;
	private String addr;
}
class Parttimer  {
	private int hour_pay;
}
class Regular  {
	private int salary;
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
