package exam;

import java.util.ArrayList;

abstract class number {
	abstract void aaa(int[] numbers);
}

class numberselect extends number {
	@Override
	void aaa(int[] numbers) {
		ArrayList<Integer> odd = new ArrayList<>();
		ArrayList<Integer> even = new ArrayList<>();

		int a = 0;
		while (a < numbers.length) {
			if (numbers[a] % 2 == 0) {
				even.add(numbers[a]);
			} else {
				odd.add(numbers[a]);
			}

			a++;
		}
		System.out.println(even);
		System.out.println(odd);

		
	}
}

public class exam8_self {

	public static void main(String[] args) {
		int num[] = { 3, 5, 2, 1, 6, 7, 8, 9, 10, 4 };
		numberselect bbb = new numberselect();
		bbb.aaa(num);
	}

}
