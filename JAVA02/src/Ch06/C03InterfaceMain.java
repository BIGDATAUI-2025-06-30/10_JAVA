package Ch06;

interface Remocon {

	void powerOn(); // 추상메서드

	void powerOff(); // 추상메서드
}

class Tv implements Remocon {

	@Override
	public void powerOn() {
		System.out.println("TV를 켭니다.");
	}

	@Override
	public void powerOff() {
		System.out.println("TV를 끕니다.");
	}
}

class Radio implements Remocon {
	@Override
	public void powerOn() {
		System.out.println("라디오를 켭니다.");		
	}
	@Override
	public void powerOff() {
		System.out.println("라디오를 끕니다.");
	}
	
}

public class C03InterfaceMain {

	public static void TurnOn(Remocon controller) // TV/Radio객체 
								// Remocon controller = new Tv();
	{
		controller.powerOn();
	}

	public static void TurnOff(Remocon controller) 
	{
		
	}

	public static void main(String[] args) {
		
		Tv tv = new Tv();
		Radio radio = new Radio();
		
		TurnOn(tv);
		TurnOn(radio);
		
	}

}
