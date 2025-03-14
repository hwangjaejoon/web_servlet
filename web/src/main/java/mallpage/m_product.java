package mallpage;
//상품 리스트 Database연결 Model

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shop.m_dbinfo;

public class m_product {
	//DTO (setter,getter)
	dto_product pd = new dto_product();		//void 메소드 일 경우 Controller 가져가는 객체?
	
	ArrayList<ArrayList<String>> all = null;
	ArrayList<String> al = null;
	
	//DB정보 및 연결
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql = null;	//DB 쿼리문
	
	//DB접속 정보
	m_dbinfo db = new m_dbinfo();
	//상품 하나의 정보만 가져오는 모델
	public void oneproduct(dto_product p) {//controller에서 가져온 dto값을 받음
//		System.out.println(p.getMidx());
		try {
			this.con = this.db.getConnection();
			this.sql = "select * from mall_product where midx=?";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setInt(1, p.getMidx());
			this.rs = this.ps.executeQuery();
			if(this.rs.next() == false) {
//				System.out.println("data없음");
				this.pd.setMidx(0);// midx autoincrement값은 1부터 시작이니까
			}else {//필드에 있는 dto 모델의 setter로 db값 전달
//				System.out.println("데이터있음");
//				System.out.println(this.rs.getString("pnm"));
				this.pd.setMidx(this.rs.getInt("midx"));
				this.pd.setPcode(this.rs.getString("pcode"));
				this.pd.setPdate(this.rs.getString("pdate"));
				this.pd.setPimg(this.rs.getString("pimg"));
				this.pd.setPmoney(this.rs.getString("pmoney"));
				this.pd.setPnm(this.rs.getString("pnm"));
				this.pd.setPsales(this.rs.getString("psales"));
				this.pd.setPsmoney(this.rs.getString("psmoney"));
			}
			
			
		} catch (Exception e) {
			this.pd.setMidx(0);
		}finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();
			}catch (Exception e) {
				this.pd.setMidx(0);
			}
	
		}
	}
	
	
	public ArrayList<ArrayList<String>> product_all(){//전체리스트 가져오는모델
		
		try {
			this.con = this.db.getConnection();
			this.sql = "select * from mall_product order by midx desc";
			this.ps = this.con.prepareStatement(this.sql);
			this.rs = this.ps.executeQuery();
			this.all = new ArrayList<ArrayList<String>>();
			while(this.rs.next()) {
				this.al = new ArrayList<String>();
				this.al.add(String.valueOf(this.rs.getInt("midx")));
				this.al.add(this.rs.getString("pcode"));
				this.al.add(this.rs.getString("pnm"));
				this.al.add(this.rs.getString("pmoney"));
				this.al.add(this.rs.getString("psales"));
				this.al.add(this.rs.getString("psmoney"));
				this.al.add(this.rs.getString("pimg"));
				this.al.add(this.rs.getString("pdate"));
				this.all.add(this.al);
			}
			
		}catch(Exception e) {
			this.all = null;
		}finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();
			}catch(Exception e) {
				this.all = null;
			}
		}
	
		return this.all;
	}
	
}
