package Ch03;


class 캬라멜{
	
}
class 버터옥수수{
	
}
class PopCorn<T>{
	
}
public class C02Ex {

	public static void main(String[] args) {
		
		PopCorn<캬라멜> ob1 = new PopCorn<캬라멜>(new 캬라멜());
		System.out.println(ob1);
		
		PopCorn<버터옥수수> ob2 = new PopCorn<버터옥수수>(new 버터옥수수());
		System.out.println(ob2);

	}

}
