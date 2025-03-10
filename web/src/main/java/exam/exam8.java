package exam;

import java.util.ArrayList;
import java.util.Arrays;

public class exam8 extends exam8_box {
	@Override
	public void even() {	//짝수 
		ArrayList<Integer> number = new ArrayList<Integer>(Arrays.asList(this.data));
		int w = 0;
		while(w < number.size()) {
			if(number.get(w) % 2 == 1) {		//홀수 값 조건은 배열에서 삭제
				number.remove(w);		//remove 시 배열의 index 즉 node번호가 변경됨
				w=0;					// 0사용은 배열의 값이 삭제되면 노드 변화로 처음부터 다시 검토
			}
			else {
			w++;
			}
		}
		System.out.println(number);
	}@Override
	public void odd() {		//홀수
		ArrayList<Integer> number = new ArrayList<Integer>(Arrays.asList(this.data));
		int w = 0;
		while(w < number.size()) {
			if(number.get(w) % 2 != 1) {		//짝수 값 조건은 배열에서 삭제
				number.remove(w);
				w=0;
			}
			else {
			w++;
			}
		}
		System.out.println(number);
	}
	public static void main(String[] args) {
		new exam8().even();
		new exam8().odd();
	}
}
//추상 클래스
abstract class exam8_box{
	Integer data[] = {3,5,2,1,6,7,8,9,10,4};
	abstract public void even();
	abstract public void odd();
}