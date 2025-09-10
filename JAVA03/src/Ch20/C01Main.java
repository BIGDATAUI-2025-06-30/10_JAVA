package Ch20;


@C01CustomAnnotation(value="홍길동",number=10000,isOpen=true)
class Simple
{
	String value;
	int number;
	boolean isOpen;
	
	Simple(){
		C01CustomAnnotation ref = this.getClass().getAnnotation(C01CustomAnnotation.class);
		System.out.println("VALUE : " + ref.value());
		System.out.println("NUMBER : " + ref.number());
		System.out.println("ISOPEN : " + ref.isOpen());
		this.value = ref.value();
		this.number = ref.number();
		this.isOpen = ref.isOpen();
	}
}

public class C01Main {

	public static void main(String[] args) {
		Simple ob = new Simple();
		System.out.println(ob);

	}

}
