package Ch09;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class C01Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket client = new Socket("SERVERIP",7000);
		
		InputStream in =  client.getInputStream();
		DataInputStream din = new DataInputStream(in);
		String recv = din.readUTF();
		System.out.println("메시지 : " + recv);
		
		din.close();
		in.close();
		client.close();
		
	}
	
}
