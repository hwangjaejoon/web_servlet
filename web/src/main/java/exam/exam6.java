package exam;

import java.util.Scanner;

public class exam6 {

	public static void main(String[] args) {
		String user[][] = {
				{"마동석","010-5351-4423"},
				{"김무열","010-1004-2223"},
				{"박지환","010-698-2901"},
		};
		Scanner sc = new Scanner(System.in);
		System.out.println("고객명을 입력하세요 : ");
		String name = sc.nextLine().replaceAll(" ","");		// 띄어쓰기 해도 입력 되는듯..? " " 를 "" 로 변경
		System.out.println(name);
		
		int w = 0;
		while(w < user.length) {
			if(name.equals(user[w][0])) {
				System.out.println(user[w][0] + " 님 연락처 " + user[w][1] + " 입니다");
			}
			w++;
		}
		
		
		sc.close();
	}

}
