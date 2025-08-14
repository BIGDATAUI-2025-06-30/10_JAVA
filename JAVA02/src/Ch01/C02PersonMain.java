package Ch01;


class C02Person {
	//속성
	public String name;
	public int age;
	public float height;
	public double weight;
	
	//기능
}
public class C02PersonMain {

	public static void main(String[] args) {
		
		C02Person hong = new C02Person();
		hong.name="홍길동";
		hong.age=15;
		hong.height=177.5f;
		hong.weight=70.5;
		
		System.out.printf("%s %d %f %f\n", hong.name,hong.age,hong.height,hong.weight);


	}

}
