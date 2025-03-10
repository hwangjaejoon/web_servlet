package exam;

import java.util.ArrayList;
import java.util.Scanner;

public class exam2 {
	public static void main(String[] args) {
		exam2_box rb = new exam2_box();
		rb.aaa();
	}
}

class exam2_box {
	ArrayList<Integer> user = null;
	ArrayList<Integer> pc = null;
	Scanner sc = new Scanner(System.in);

	public exam2_box() {
		this.user = new ArrayList<Integer>();
		this.pc = new ArrayList<Integer>();
	}
	public Integer pc_return() {
		Integer npc = (int)Math.ceil(Math.random()*46);
		if(this.pc.contains(npc)==true) {
			pc_return();
		}
		return 0;
	}

	public void aaa() {
		try {
			while (true) {
				if(this.user.size() == 6) {
					break;
				}
				if(this.pc.size()<7) {
				Integer npc = (int)Math.ceil(Math.random()*46);
				if(this.pc.contains(npc) == false && npc > 0 && npc < 47) {
					this.pc.add(npc);
				}else {
					//외부 return 메소드로 재핸들링
					Integer result = pc_return();
					this.pc.add(result);
				}
				}
				
				
				System.out.println("숫자를 입력하세요 : 1 ~ 46");
				Integer no = this.sc.nextInt();
				if (no > 0 && no < 47) {
					//같은 숫자 확인
					if(this.user.contains(no) == false) {
					this.user.add(no);
					}
				}
				else{
					System.out.println("숫자는 1 ~ 46 까지만 입력가능 합니다");
				}
			}
		} catch (Exception e) {
			System.out.println("숫자만 입력하쇼 초기화 합미다");
		} finally {
			System.out.println(this.user);
			System.out.println(this.pc);
			sc.close();
		}
	}
}