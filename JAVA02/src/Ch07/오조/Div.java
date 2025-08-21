package Ch07.오조;

import java.util.Arrays;

public class Div implements Ch07.오조.Calculation {

	// 함수 오버로딩으로
	// public void run(int n1, int n2){}, public void run(int... nums){}, public
	// void run(double... nums){}, public void run(String... strings){} 이렇게 4개를
	// 만들어주세요.
	// 그리고 {}안에서 Scanner를 사용하여 인자들을 조건에 맞게 받아서 연산하고 그 연산식을 System.out.println("");으로
	// 출력하는 함수까지 만들어주세요

//	Ch07.오조.Calculation cal3 = new Ch07.오조.Div();
//	cal3.Run(10,20);	//2개 인자 받아 나눈셈 화면 출력
//	cal3.Run(10,20,30,40,50);//5개 인자 받아 나눈셈 화면 출력(큰수에서 작은수로 반복 나눈셈)
//	cal3.Run(10.5,20.2,30.4,50.6);//4개 인자 받아 나눗셈 화면 출력
//	cal3.Run("문자열1","문자열2","문자열3","문자열4");//4개 문자열받아 '/'를 기준으로 문자열덧붙여 출력

	@Override
	public void Run(int n1, int n2) {
		int a = 0;
		if (n2 > n1)
			a = n2 / n1;
		else
			a = n1 / n2;
		System.out.println("오조 박준형 n1/n2 나눗셈결과 : " + a);
	}

	@Override
	public void Run(int... nums) {

        // 정수 배열을 double 배열로 변환 후 정렬
        double[] doubleNums = Arrays.stream(nums).asDoubleStream().sorted().toArray();

        // 가장 큰 수로 초기 결과값 설정
        double result = doubleNums[doubleNums.length - 1];

        // 두 번째로 큰 수부터 역순으로 반복하며 나누기
        for (int i = doubleNums.length - 2; i >= 0; i--) {
            double divisor = doubleNums[i];
            if (divisor == 0) {
                System.out.println("\n오류: 0으로 나눌 수 없습니다.");
                return;
            }
            result /= divisor;
        }
        System.out.printf("50.0 / 40.0 / 30.0 / 20.0 / 10.0으로 나눈값: %f\n", result);
	}

	@Override
	public void Run(double... nums1) {
        Arrays.sort(nums1);
        double result = nums1[nums1.length - 1];
        for (int i = nums1.length - 2; i >= 0; i--) {
            double divisor = nums1[i];
            if (divisor == 0) {
                System.out.println("\n오류: 0으로 나눌 수 없습니다.");
                return;
            }
            result /= divisor;
        }
        System.out.printf("50.6 / 30.4 / 20.2 / 10.5으로 나눈값: %f\n", result);
	}

	@Override
	public void Run(String... strings) {
		String result = String.join(" / ", strings);
		System.out.println("문자열을 /기준으로 나누기 :" + result);
	}
}
