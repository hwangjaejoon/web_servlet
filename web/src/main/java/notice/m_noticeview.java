package notice;
//Database 의 Table 중 where 및 조회수 카운트
// Query 문 : select, update
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import shop.m_dbinfo;

public class m_noticeview {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String sql = "";	//Query 문법
	m_dbinfo db = new m_dbinfo();
	
	public void viewcount(int nidx) {
		try {
			this.con = this.db.getConnection();
			//해당 컬럼의 값을 +1씩 증가시키는 Qurey 문
			this.sql = "update notice set nview=nview+1 where nidx=?";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setInt(1, nidx);	//nidx 자료형이 int 이므로 setInt ==> String이면 setString
			this.ps.executeUpdate();	//Query문 실행
		}catch(Exception e) {
			
		}finally {
			try {
				this.ps.close();
				this.con.close();
			}catch(Exception e) {
				
			}
		}
	}
}
