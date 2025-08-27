package Ch06;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class C09JsoupMain {

	public static void main(String[] args) throws IOException {
		
		//URL 연결
		Connection conn = 
		Jsoup.connect("https://op.gg/lol/champions")	//크롤링할 URL 지정
			 .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/139.0.0.0 Safari/537.36") //브라우저 정보
			 .timeout(5000)	//timeout 값
			 .ignoreHttpErrors(true)
			 .followRedirects(true);
		
		//DOM 객체 받기
		Document document =  conn.get();
		System.out.println(document);
		
	}

}
