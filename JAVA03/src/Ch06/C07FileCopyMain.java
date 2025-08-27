package Ch06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class C07FileCopyMain {
	
	private static final String PATH="c:\\IOTEST\\";
	
	public static void main(String[] args) throws Exception{
		//args[0] : 원본파일경로(원본파일명)
		//args[1] : 복사대상경로(복사파일명)
		InputStream fin = new FileInputStream(PATH+args[0]);
		OutputStream fout = new FileOutputStream(PATH+args[1]);
		
		long startTime = System.currentTimeMillis();
		byte [] buff = new byte[4096];
		while(true)
		{
			int data = fin.read(buff);
			if(data==-1)
				break;
			fout.write(buff,0,data);
			fout.flush();
		}
		fout.close();
		fin.close();
		
		long endTime = System.currentTimeMillis();
		System.out.println("소요시간 : " + (endTime - startTime) + "ms");
		
	}
	
}
