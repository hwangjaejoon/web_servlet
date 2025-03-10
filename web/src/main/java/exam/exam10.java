package exam;

import java.util.Scanner;

public class exam10 extends exam10_box{

	public static void main(String[] args) {
		System.out.println("[1. 휴대폰 인증   2. 이메일 인증] 선택 : ");
		new exam10().sec();
	}
	public void sec() {
		String part = this.sc.next();
		String result = null;
		Integer hpno = null;
		String useremail = null;
		if(part.equals("1")) {
			System.out.println("휴대폰 번호를 입력하세요(숫자만) : ");
			try {
				hpno = this.sc.nextInt();
				
			}catch(Exception e) {
				System.out.println("숫자만 입력 ㄱㄱ");
				new exam10().main(null);
			}
			result = this.hp(hpno);
		}
		else if(part.equals("2")) {
			System.out.println("이메일을 입력하세요 : ");
			useremail = this.sc.next();
			result = this.email(useremail);
			

		}
		else {
			new exam10().main(null);
		}
		System.out.println(result);
	}
}
abstract class exam10_box{
	Scanner sc = new Scanner(System.in);
	public String hp(Integer hpno) {		//폰 번호 인증
		String msg = "인증번호 1350 발송";
		return msg;
	}
	public String email(String useremail) {	//이메일 인증
		String msg = "인증번호 1350 발송";
		return msg;	
	}
}