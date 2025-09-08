package Ch06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class C01WriterMain {
	
	public static void main(String[] args) throws IOException {
//		Writer fout = new FileWriter("c:\\IOTEST\\test1.txt",false); //덮어쓰기
		Writer fout = new FileWriter("c:\\IOTEST\\test1.txt",true);	//추가하기
		fout.write("TEST1_2\n");
		fout.write("TEST2_2\n");
		fout.write("TEST3_2\n");
		
		fout.flush();
		fout.close();
	}
}
