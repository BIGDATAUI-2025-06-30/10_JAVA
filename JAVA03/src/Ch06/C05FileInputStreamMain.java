package Ch06;

import java.io.FileInputStream;
import java.io.InputStream;

public class C05FileInputStreamMain {

	public static void main(String[] args) throws Exception{
		
		InputStream fin = new FileInputStream("c:\\IOTEST\\test.pdf");
		
		
		long startTime = System.currentTimeMillis();
		StringBuffer stringBuffer = new StringBuffer();
		byte[] buff = new byte[4096];
		while(true) {
			int data = fin.read(buff);
			if(data==-1)
				break;
//			System.out.print((char)data);
			stringBuffer.append((char)data);
	
		}
		System.out.println("총길이 :  " + stringBuffer.length());
		fin.close();

		long endTime = System.currentTimeMillis();
		System.out.println("소요시간 : " + (endTime - startTime) + "ms");

	}

}
