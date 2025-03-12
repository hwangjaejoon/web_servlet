package mallpage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import event.dbconfig;
import shop.m_dbinfo;

//copyrighter Model	+ login model
public class copyright {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql = null;
	ArrayList<String> cp = null;
	m_dbinfo db = new m_dbinfo();
	String result = null;
	m_member mb = new m_member();	//얜 뭐지 그럼
	
		//login 전용
	public String user_login(m_member dto) {
		try {
			this.con = this.db.getConnection();
			this.sql = "select mid,mname,memail from joins where mid=? and mpass=?";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1, dto.getMid());
			this.ps.setString(2, dto.getMpass());
			this.rs = this.ps.executeQuery();
			if(this.rs.next() == true) {	//아디비번이 맞을 때
				this.result = "ok";
				
				//기존에 사용 된 dto를 초기화 및 새로운 dto 값을 구성
				this.mb.setMid(this.rs.getString("mid"));		//id
				this.mb.setMname(this.rs.getString("mname"));	//name
				this.mb.setMemail(this.rs.getString("memail"));	//email
				
			}
		}catch(Exception e) {
			this.result = null;	
		}finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();
			}catch(Exception e) {
				this.result = null;
			}
		}
		return this.result;
	}
	
	
	
	
	
	

		// copyright 전용
	public ArrayList<String> copyright_info() {
	try {
		this.con = this.db.getConnection();
		this.sql = "select * from corp_info";
		this.ps = this.con.prepareStatement(this.sql);
		
		this.rs = this.ps.executeQuery();
		this.rs.next();	//next 때려아 함..?
		this.cp = new ArrayList<String>();
		this.cp.add(this.rs.getString("corp_nm"));
		this.cp.add(this.rs.getString("ceo_nm"));
		this.cp.add(this.rs.getString("corp_addr"));
		this.cp.add(this.rs.getString("corp_tel"));
		this.cp.add(this.rs.getString("corp_time"));
		this.cp.add(this.rs.getString("corp_email"));
		this.cp.add(this.rs.getString("corp_no"));
		this.cp.add(this.rs.getString("corp_no2"));
		this.cp.add(this.rs.getString("corp_master"));
		this.cp.add(this.rs.getString("corp_domain"));
		

		
		//System.out.println(this.cp);
		
		
		}catch(Exception e) {
			System.out.println("Database Error");
		}
		finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();
			}catch(Exception e) {
				System.out.println("Database Closing Error");
			}
		}
	return this.cp;
	}

}
