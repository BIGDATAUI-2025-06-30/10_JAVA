package Ch06;

import org.openqa.selenium.By;
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
	
	public static void main(String[] args) {
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
		shoppingBtnEl.click();
		
		
		//창닫기
		//driver.close();

	}

}
