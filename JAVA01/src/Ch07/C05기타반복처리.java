package Ch07;

import java.util.ArrayList;
import java.util.List;

public class C05기타반복처리 {

	public static void main(String[] args) {
		
		// Collection(자료구조-List,Map) 객체를 이용 - 저장
		List<String> lists = new ArrayList();
		lists.add("JAVA");			//0
		lists.add("JSP");			//1
		lists.add("SERVLET");		//2
		lists.add("SPRINGBOOT");	//3
		lists.add("NODEJS");		//4
		lists.add("REACT");			//5
		lists.add("DOCKER_COMPOSE");//6
		
		// 반복 : 기본 for
//		for(int i=0;i<lists.size() ;i++) {
//			System.out.println(lists.get(i));
//		}
		
		// 반복 : 개량 for
//		for(String subject : lists) {
//			System.out.println(subject);
//		}
		
		// 반복 : 스트림함수 forEach
		
		// ()=>{}
		lists.stream().forEach((item)->{System.out.println(item); });
		
		
		
	}

}


