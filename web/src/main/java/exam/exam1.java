package exam;

import java.util.Random;
import java.util.Scanner;

//Random : 자동으로 pc가 생성하는 원리? => 기본 소수점
//Math.random() 
public class exam1 {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		int no = sc.nextInt();
		System.out.println("숫자를 입력하세요");
		for(int f=0; f<no; f++) {
			int free = rand.nextInt(99);
			System.out.println(free);
		}
		sc.close();
	}
	
}


