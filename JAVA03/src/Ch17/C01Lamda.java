package Ch17;

import java.util.ArrayList;
import java.util.List;

class Person
{
	private String name;
	private int age;
	private String addr;
	//기본생성자
	public Person() {}
	//모든인자 생성자
	public Person(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
	
	//Getter and Setter
	
	//toString
}

public class C01Lamda {
	
	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		list.add(new Person("홍길동",55,"대구"));
		list.add(new Person("티모",100,"안드로메다"));
		list.add(new Person("김범수",45,"서울"));
		
		list.stream().forEach((item)->{System.out.println(item);});
		System.out.println("------");
		list.sort((a,b)->{return b.getAge()-a.getAge();});
		
		list.stream().forEach((item)->{System.out.println(item);});
		
	}
	
}
