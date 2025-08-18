package Ch08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class C01DbConn {
	
	public static void main(String[] args) {
		//DB CONN DATA
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/testdb";
		
		//JDBC참조변수
		Connection conn = null;			// DBMS 의 특정 DB와 연결되는 객체
		PreparedStatement pstmt = null;	// SQL Query 전송용 객체
		ResultSet rs = null;			// Select 결과물 담을 객체
		
	}
}
