package Ch06;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class C03FileCopyMain {
	
	private static final String PATH="c:\\IOTEST\\"; 
	
	public static void main(String[] args) throws Exception
	{
		//args[0] : 원본파일경로(원본파일명)
		//args[1] : 복사대상경로(복사파일명)
		Reader fin = new FileReader(PATH+args[0]);
		Writer fout = new FileWriter(PATH+args[1]);
		
		while(true)
		{
			int data = fin.read();
			if(data==-1)
				break;
			fout.write((char)data);
			fout.flush();
		}
		fout.close();
		fin.close();
	}
}
