package Ch07.일조;

public interface Calculation {
	//사칙연산의 결과를 담기위한 멤버변수를 만드세요(덧셈,뺄셈,곱셈,나눗셈별)	
	//사칙연산을 위한 추상 메서드를 만들고
	//해당 폴더에 있는 Div,Mul,Sub,Sum을 각각 역할 나눠서 함수를 완성하세요(C99Ex참고)
	//나머지는 자유롭게 - !
	
	void Run(int n1, int n2);	
	void Run(int n1, int n2, int n3, int n4, int n5);
	void Run(double n1, double n2, double n3, double n4);
	void Run(String s1, String s2, String s3, String s4);
	
	// 예시
//	int MAX_VALUE = 100000;
//	void Run(int n1, int n2); // n1, n2 받아 두 수의 합을 console창에 출력해주세요. 입력값은 MAX_VALUE보다 작아야합니다.
//	int Run_by_keyboard(); // 키보드로 두 수의 입력값을 받아 

}
