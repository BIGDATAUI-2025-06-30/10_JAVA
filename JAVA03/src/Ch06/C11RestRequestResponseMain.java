package Ch06;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class C11RestRequestResponseMain {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//01 요청URL 파라미터 지정
		String url = "https://www.daegufood.go.kr/kor/api/tasty.html";
		String mode = "json";
		String addr = "중구";
		url = url + "?mode=" + mode + "&addr=" + addr;
		
		//02 Http Request 구성
		HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
		
		//03 Request 요청 -> Response 받기
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//		System.out.println(response.body());
		
		//04 받은 Data Class화 
		
		ObjectMapper objectMapper = new ObjectMapper();

		//04-01) JSON Type 유지
//		JsonNode jsonNode = objectMapper.readTree(response.body());
//		System.out.println("status : " + jsonNode.get("status"));
//		System.out.println("total : " + jsonNode.get("total"));
//		JsonNode data = jsonNode.get("data");
//		for(int i=0;i<data.size();i++) {
//			JsonNode item = data.get(i);
//			System.out.println(item.get("BZ_NM"));
//		}
		
		//04-02) JAVA Class 로 변환
		
		
		
	}

}
