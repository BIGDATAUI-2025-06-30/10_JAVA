package Ch06;

interface Printer {
	void print();
}

class Inkjet implements Printer {
	public void print() {
		System.out.println("Inkjet");
	}
}

class Laser implements Printer {
	public void print() {
		System.out.println("Laser");
	}
}



public class C06Ex {

	public static void main(String[] args) {
	       Printer p = new Inkjet();
	        p.print();
	        p = new Laser();
	        p.print();
	}
}
