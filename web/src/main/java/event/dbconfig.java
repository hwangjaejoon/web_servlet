package event;
// Database 환경설정 및 세팅값

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconfig {
	public static Connection info() throws Exception{
		//String database = "com.mysql.jdbc.Driver";		//mysql 5.1 , 5.5 버전일 때
		
		//mysql 버전의 연결 성정 파트
		String database = "com.mysql.cj.jdbc.Driver";		//mysql 5.7 ~ 버전일 때
		String dburl = "jdbc:mysql://localhost:3306/mrp";	//mysql 연결 경로
		String user = "project";	//mysql 아이디
		String passwd = "p402402";	//mysql 비번
		
		Class.forName(database);	//어떤 라이브러리를 이용하여 db에 접속할 것인지를 정하는 것을 말함
		//mysql -u 아이디 -p
		Connection con = DriverManager.getConnection(dburl,user,passwd);
		return con;
		
		
	}
}
