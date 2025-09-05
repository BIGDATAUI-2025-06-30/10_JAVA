package Ch01;

class Buyer{
	private int myMoney;
	private int appleCnt;
	//모든 인자 생성자
	//toString
	public Buyer(int myMoney, int appleCnt) {
		super();
		this.myMoney = myMoney;
		this.appleCnt = appleCnt;
	}
	public void payment(Seller 사과장수,int money) {
		myMoney-=money;
		int cnt=사과장수.receive(money);
		this.appleCnt+=cnt;
	}
	@Override
	public String toString() {
		return "Buyer [myMoney=" + myMoney + ", appleCnt=" + appleCnt + "]";
	}
	
}
class Seller{
	private int myMoney;
	private int appleCnt;
	private int price;
	//모든 인자 생성자
	//toString
	public Seller(int myMoney, int appleCnt,int price) {
		super();
		this.myMoney = myMoney;
		this.appleCnt = appleCnt;
		this.price = price;
	}
	public int receive(int money) {
		this.myMoney+=money;
		int cnt = money / this.price;
		appleCnt-=cnt;
		return cnt;
	}
	
	@Override
	public String toString() {
		return "Seller [myMoney=" + myMoney + ", appleCnt=" + appleCnt + ", price=" + price + "]";
	}

	
}

public class C11Ex {
	public static void main(String[] args) {
		// 
		Buyer 홍길동 = new Buyer(10000,0);
		Buyer 티모 = new Buyer(20000,0);
		//
		Seller 사과장수1 = new Seller(50000,100,1000);
		
		//
		홍길동.payment(사과장수1, 3000);
		티모.payment(사과장수1, 8000);
		
		//
		System.out.println(홍길동);
		System.out.println(티모);
		System.out.println(사과장수1);
		//
		//편의점 고객이 콜라를 주문한다
		//고객이 사과장수에게 사과를 주문한다
		
		
		
		
	}
}
