package exam;

import java.util.Scanner;

public class exam6_self {

	public static void main(String[] args) {
		java6_box rb = new java6_box();
		rb.event();

	}

}

class java6_box {
	String user[] = { "마동석", "김무열", "이동휘", "박지환", "이주빈" };
	String number[] = { "01053514423", "01023103637", "01055317889", "01069882901", "01095849004" };

	public void event() {
		Scanner sc = new Scanner(System.in);
		System.out.println("고객명을 입력해 주세요.");
		String username = sc.next();

		int w = 0;
		int count = 0;
		while (w < this.user.length) {
			if (username.equals(user[w])){
				System.out.println(this.user[w] + " 님 연락처 " + this.number[w] + " 입니다.");
				count = count + 1;
			}
			w++;
		}
		if (count == 0) {
			System.out.println("확인 되지 않은 고객 입니다.");
			event();
		}
		sc.close();
	}

}