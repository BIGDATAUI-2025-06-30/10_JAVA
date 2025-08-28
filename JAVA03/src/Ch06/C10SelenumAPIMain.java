package Ch06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//크롬서버.jar 다운로드 경로(셀레니움 공식 홈페이지)
//https://www.selenium.dev/downloads/

//크롬드라이브 다운로드 경로
//https://googlechromelabs.github.io/chrome-for-testing/#stable


public class C10SelenumAPIMain {

	private static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	private static final String WEB_DRIVER_PATH = "src/Drivers/chromedriver.exe";
	
	public static void main(String[] args) throws InterruptedException, IOException {
		//Selenum 3.x 기준 브라우저 활성화 방법(4.x 부터는 chromedriver.exe 를 윈도우 PATH에 등록시 경로설정필요없음)
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		//크롬브라우저 옵션 설정
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");			//백그라운드 실행
//		options.addArguments("--no-sandbox");		//리눅스환경 sendbox 사용 여부
		
		//크롬브라우저 활성화
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.naver.com");
		
		//특정 요소 위치 선택(키워드 입력하기)
		WebElement searchEl = driver.findElement(By.id("query"));
		
		//키워드 입력
		searchEl.sendKeys("모니터");
		
		//엔터키 전달
		searchEl.sendKeys(Keys.RETURN);
	
		//쇼핑버튼 클릭 (.api_flicking_wrap .tab:nth-child(1) )
		WebElement shoppingBtnEl = driver.findElement(By.cssSelector(".api_flicking_wrap .tab:nth-child(1)"));
		//새창열기(target="_blank") 제거
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].removeAttribute('target')",shoppingBtnEl);		
		
		shoppingBtnEl.click();
		
		Thread.sleep(500);
		
//		//네이버포털 -> '노트북'검색 -> 쇼핑 클릭-> 삼성 노트북(엔터) -> 리뷰 많은순 클릭
		List<WebElement> Els =  driver.findElements(By.cssSelector(".subFilter_sort__lhuHl"));
		Els.forEach(el->{
			if(el.getText().contains("리뷰 많은순"))
				el.click();
		});
//		
//		//영역내 모든 정보 긁어오기 basicList_list_basis__uNBZx
		List<WebElement> El2s =  driver.findElements(By.cssSelector(".basicList_list_basis__uNBZx"));
		
		
		//파일로 저장
		Writer out = new FileWriter("C:\\IOTEST\\"+UUID.randomUUID()+".html");
	
		
        // HTML 기본 구조 작성
        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append("<!DOCTYPE html>\n");
        htmlContent.append("<html lang=\"ko\">\n");
        htmlContent.append("<head>\n");
        htmlContent.append("<meta charset=\"UTF-8\">\n");
        htmlContent.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        htmlContent.append("<title>네이버 쇼핑 검색 결과</title>\n");
        
        
		//css link 빼내오기
		List<WebElement> cssLinks = driver.findElements(By.tagName("link"));
		for(WebElement link : cssLinks) {
			String rel = link.getAttribute("rel");
			if(rel.equals("stylesheet")){
				String href = link.getAttribute("href");
				System.out.println("CSS 링크 : " + href);
                htmlContent.append("<link rel=\"stylesheet\" href=\"").append(href).append("\">\n");

			}
		}
        htmlContent.append("</head>\n");
        htmlContent.append("<body>\n");
        
		//본문내용
		for(WebElement el :El2s) {
			String elHTML = el.getAttribute("outerHTML");
			htmlContent.append(elHTML).append("\n");
			
		}
        htmlContent.append("</body>\n");
        htmlContent.append("</html>");
        
        // 파일에 저장
        out.write(htmlContent.toString());
        
		out.flush();
		out.close();

	}

}
