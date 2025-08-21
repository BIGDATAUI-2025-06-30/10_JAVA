package Ch07.사조;

public class Sum implements Ch07.사조.Calculation{

	@Override
	public void Run(int n1, int n2) {
		System.out.println("사조 정재민 덧셈결과 : " + (n1+n2));
	}
	@Override
	public void Run(int... n) {
		int sum=0;
		for(int num:n) {
			sum+=num;
		}
		System.out.println("사조 정재민 덧셈결과 : " + sum);
	}
	@Override
	public void Run(double... d) {
		double sum=0;
		for(double num:d) {
			sum+=num;
		}
		System.out.printf("사조 정재민 덧셈결과 : %.2f\n",sum);
	}
	@Override
	public void Run(String... n) {
		String all="";
		for(int i=0;i<n.length*2-1;i++) {
			if(i%2==0) {
				all+=(n[i/2]);}
			else if(i%2==1){
				all+=("+");
			}
		}
		System.out.println("사조 정재민 덧셈결과 : " + all);
	}
}
