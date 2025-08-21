package Ch07;

import Ch07.사조.Div;

public class C06임시확인 {

	public static void main(String[] args) {
		Div cal3 = new Ch07.사조.Div();
		cal3.Run(10, 20); // 2개 인자 받아 나눈셈 화면 출력


		cal3.Run(10, 20, 30, 40, 50);// n개 인자 받아 나눈셈 화면 출력(큰수에서 작은수로 반복 나눈셈)

		cal3.Run(10.5, 20.2, 30.4, 50.6);// n개 인자 받아 나눗셈 화면 출력

		cal3.Run("문자열1", "문자열2", "문자열3", "문자열4");// n개 문자열받아 '/'를 기준으로 문자열덧붙여 출력


	}

}
