package Ch07.사조;

import java.util.Arrays;
import java.util.Collections;

public class Div implements Calculation {

	@Override
	public void Run(int n1, int n2) {
		int max = Math.max(n1, n2);
		int min = Math.min(n1, n2);

		int div = max / min;
		System.out.println("4조 김홍섭 나눗셈1 결과 : " + div);
	}

	@Override
	public void Run(int... values) {
		Integer[] arr = new Integer[values.length];
		for (int i = 0; i < values.length; i++) {
			arr[i] = values[i]; // Integer 변환
		} // Chat gpt is smart

		Arrays.sort(arr, Collections.reverseOrder()); // 내림차순

		double result = arr[0];
		for (int i = 1; i < arr.length; i++) {
			result /= arr[i];
		}

		System.out.printf("4조 김홍섭 나눗셈2 결과 : %.5f\n", result);
	}

	@Override
	public void Run(double... values) { // n개 인자 받아 나눗셈 화면 출력
		Double[] arr = new Double[values.length];
		for (int i = 0; i < values.length; i++) {
			arr[i] = values[i]; // double 변환
		}

		Arrays.sort(arr, Collections.reverseOrder()); // 내림차순

		double result = arr[0];
		for (int i = 1; i < arr.length; i++) {
			result /= arr[i];
		}

		System.out.printf("4조 김홍섭 나눗셈3 결과 : %.2f\n", result);

	}

	@Override
	public void Run(String... values) {// 문자열 붙이기 함수 구현
		String result = String.join("/", values);
		//String.join함수 (여러문자열을 지정한 구분자로 연결해 하나의 문자열로 반환)
		System.out.println(result);
	}
}
