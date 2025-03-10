package notice;
//Database 의 Table 중 where 및 조회수 카운트
// Query 문 : select, update
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shop.m_dbinfo;

public class m_noticeview {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String sql = "";	//Query 문법
	m_dbinfo db = new m_dbinfo();
	ArrayList<String> db_data = null; 	//한 개의 데이터 그룹만 저장시킴
	
	public void viewcount(int nidx) {
		try {
			this.con = this.db.getConnection();
			//해당 컬럼의 값을 +1씩 증가시키는 Qurey 문
			this.sql = "update notice set nview=nview+1 where nidx=?";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setInt(1, nidx);	//setInt : nidx 자료형이 int라서
			this.ps.executeUpdate();	//Query문 실행
			
			
			//해당 테이블에 맞는 컬럼값을 select 함
			this.sql = "select * from notice where nidx=? order by nidx desc";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setInt(1,nidx);
			this.rs = this.ps.executeQuery();
			if(this.rs.next() == true) {		//해당 조건에 맞는 내이터가 있을 경우
				this.db_data = new ArrayList<String>();
				this.db_data.add(this.rs.getString("nidx"));
				this.db_data.add(this.rs.getString("subject"));
				this.db_data.add(this.rs.getString("writer"));
				this.db_data.add(this.rs.getString("pw"));
				this.db_data.add(this.rs.getString("texts"));
				this.db_data.add(this.rs.getString("filenm"));
				this.db_data.add(this.rs.getString("nfile"));
				this.db_data.add(this.rs.getString("nview"));
				this.db_data.add(this.rs.getString("ndate"));
			}
			
		}catch(Exception e) {
			
		}finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();
			}catch(Exception e) {
				
			}
		}
	}
}
