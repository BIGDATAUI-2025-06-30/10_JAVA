package Ch20;

@C02CustomAnnotation(value="홍길동",number=10000,isOpen=true)
class Simple2 extends C02AnnotationInjected
{
	@C02BindFrom("value")
	String value;
	
	@C02BindFrom("number")
	int number;
	
	@C02BindFrom("isOpen")
	boolean isOpen;
	
	Simple2(){
		System.out.println("Simple2 디폴트 생성자 호출!..");
	}

	@Override
	public String toString() {
		return "Simple2 [value=" + value + ", number=" + number + ", isOpen=" + isOpen + "]";
	}
	
	
}

public class C02Main {

	public static void main(String[] args) {
		Simple2 ob = new Simple2();
		System.out.println(ob);

	}

}
