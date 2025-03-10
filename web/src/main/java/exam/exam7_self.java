package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class exam7_self {

	public static void main(String[] args) {
		java7_box rb = new java7_box();
		rb.boxbox();
	}

}

class java7_box {
	String box[] = { "스마트워치", "카메라", "킥보드", "노트북", "프린터", "세탁기", "무선청소기", "냉장고", "안마기", "공기청정기" };
	ArrayList<String> list = new ArrayList<>(Arrays.asList(box));
	Scanner sc = null;

	public void boxbox() {
		this.sc = new Scanner(System.in);
		System.out.println(Arrays.toString(box));
		System.out.println("삭제하실 상품을 입력해 주세요");
		String userdel = this.sc.next();
		this.list.remove(String.valueOf(userdel));
		System.out.println(list);


	}
}
