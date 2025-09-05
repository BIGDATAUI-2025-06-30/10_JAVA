package Ch03;

import java.util.Arrays;

class Box <A,B>
{
	A ob1;
	B ob2;
	Box(A ob1, B ob2){
		this.ob1 = ob1;
		this.ob2 = ob2;
	}
	
	@Override
	public String toString() {
		return "Box [ob1=" + ob1 + ", ob2=" + ob2 + "]";
	}

}
class Student{
	String name;
	String major;
	Integer level;
	public Student(String name, String major, Integer level) {
		super();
		this.name = name;
		this.major = major;
		this.level = level;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", major=" + major + ", level=" + level + "]";
	}
	
	
	
}

class Item{
	int sum;
	void setSum(int sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "Item [sum=" + sum + "]";
	}
	
}
public class C06Ex {
	
	
	public static <T> void print1(T ob) {
		System.out.println(ob);
	}
	public static <T extends Item> T print2(T box,int ...args) {
		int sum = Arrays.stream(args).reduce(0, (s,val)->s+val);
		box.setSum(sum);
		return box;
	}
	public static <T,X,Z> void print3(T ob,X ob2 , Z ob3) {
	
	}
	public static void main(String[] args) {
//		print1(10);
//		print1("홍길동");
//		print1(new Student("홍길동","컴공",2));
		
		Item item = new Item();
		System.out.println("PRINT전 : " + item);
		
		print2(item,10,20,30,40,50,60,70,80);
		
		System.out.println("PRINT후 : " + item);
		
	}

}
