package shop;
//Database, 사용자 아이디, 사용자 패스워드

import java.sql.Connection;
import java.sql.DriverManager;
//Database 의 기본 디폴트 메소드명 : getConnection (바꿔도 됨)
public class m_dbinfo {

	public Connection getConnection() throws Exception{
		//해당 라이브러리를 가져오는 역할
		String db_driver = "com.mysql.cj.jdbc.Driver";
		//Database 경로 연결 : 외부서버일 경우 localhost 대신 도메인명이나 ip주소를 입력
		String db_url = "jdbc:mysql://localhost:3306/mrp";
		//mysql에 접속하는 사용자
		String db_user = "project";
		//mysql 사용자 패스워드
		String db_passwd = "p402402";
		
		//실제 Database에 연결하는 명령어
		Class.forName(db_driver);
		Connection con = DriverManager.getConnection(db_url,db_user,db_passwd);
		//System.out.println(con);
		
		return con;	//Database가 정상적으로 연결 됐는 지 확인
	}
	
}
