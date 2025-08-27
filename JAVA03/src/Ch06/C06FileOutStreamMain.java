package Ch06;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class C06FileOutStreamMain {
	
	public static void main(String[] args) throws Exception {
		OutputStream fout = new FileOutputStream("c:\\IOTEST\\test6.txt");
		fout.write("가나다".getBytes(StandardCharsets.UTF_8));
		fout.write('a');
		fout.write('b');
		fout.write('c');
		fout.flush();
		fout.close();
	}
}
