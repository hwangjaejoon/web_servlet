package model;
//model (난수를 생성하는 모델)

import java.util.ArrayList;
import java.util.Random;

public class rnd {
	ArrayList<String> num = null;
	int ea = 0;
	public rnd(int n) {
		this.ea = n;		//자동등록방지 n자리
		this.num = new ArrayList<String>();
		
	}
	public ArrayList<String> make_num(){	//난수를 생성하는 메소드
		Random rd = new Random();
		int w = 1;
		while(w <= this.ea) {
			this.num.add(String.valueOf(rd.nextInt(10)));	//0~9까지 생성?
		w++;
		}
		
		return this.num;
	}
	
	
	
}
