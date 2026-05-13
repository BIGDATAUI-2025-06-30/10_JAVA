package Ch18_;

/* ----------------------------------------------------------
   8-Ex. [학생용 문제] 종합 - 직원 데이터로 스트림 활용
   ----------------------------------------------------------
   주어진 직원 리스트에서 :
     Q1. IT 부서 직원만 골라 이름순으로 정렬해 이름 리스트로 출력
     Q2. 부서별 평균 연봉 (Map<부서, 평균>) 출력
     Q3. 연봉 상위 3 명의 이름 출력
     Q4. 전체 연봉 합계 출력
     Q5. 모든 직원의 나이가 20 이상인지 검사 결과 출력
     Q6. 부서 종류 (중복 제거된 부서 이름 리스트) 출력
     Q7. 부서별 직원 수 (Map<부서, count>) 출력

   정답 참고 : C08ExAns.java
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.List;

public class C08Ex {

	static class Emp {
		String name;
		String dept;
		int    age;
		int    salary;

		Emp(String name, String dept, int age, int salary) {
			this.name   = name;
			this.dept   = dept;
			this.age    = age;
			this.salary = salary;
		}
		@Override
		public String toString() {
			return name + "(" + dept + "," + age + "세," + salary + ")";
		}
	}

	public static void main(String[] args) {

		List<Emp> emps = Arrays.asList(
				new Emp("김철수", "IT",   28, 4500),
				new Emp("이영희", "HR",   35, 3800),
				new Emp("박민수", "IT",   42, 6200),
				new Emp("정수진", "Sales",31, 4100),
				new Emp("최동훈", "IT",   25, 3500),
				new Emp("강서연", "HR",   29, 3900),
				new Emp("윤지호", "Sales",38, 4800),
				new Emp("한미래", "IT",   33, 5500)
		);

		// Q1. IT 부서 이름순 정렬 → 이름 리스트 출력
		// TODO 답안 작성

		// Q2. 부서별 평균 연봉 출력
		// TODO 답안 작성

		// Q3. 연봉 상위 3명의 이름 출력
		// TODO 답안 작성

		// Q4. 전체 연봉 합계 출력
		// TODO 답안 작성

		// Q5. 모두 20세 이상? 출력
		// TODO 답안 작성

		// Q6. 부서 종류 (중복 제거) 출력
		// TODO 답안 작성

		// Q7. 부서별 직원 수 출력
		// TODO 답안 작성
	}
}
