package basic.sort;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySortTest {

	public static void main(String[] args) {
		// 정수 정렬
//		int[] intArray = {3, 5, 2, 7, 9, 4};
//		Arrays.sort(intArray);
//		System.out.println(Arrays.toString(intArray));
		
		// 문자열
//		String[] strArray = {"Hello", "ABC", "World", "UPLUS"};
//		Arrays.sort(strArray);
//		System.out.println(Arrays.toString(strArray));
		
		Item[] itemArray = {
				new Item(3, "666"), new Item(2, "777"), new Item(5, "444"), new Item(3, "111")
		};
		// implements Comparable
//		Arrays.sort(itemArray);
//		Arrays.sort(itemArray, Collections.reverseOrder()); // 뒤집어줌
//		System.out.println(Arrays.toString(itemArray));
		
		
		
		// Comparator interface 객체 전달
		// 정렬하기 위한 방법 2 : Comparator 객체 전달 (익명 anonymous)
		// 대상 객체에 Comparable 구현이 없어도 된다.
//		Arrays.sort( itemArray, new Comparator<Item>() {
//			@Override
//			public int compare (Item o1, Item o2) {
//				// return o1.itemId - o2.itemId;
//				return o1.itemNm.compareTo(o2.itemNm);
//			}
//		});
//		System.out.println(Arrays.toString(itemArray));
		
		
		// 정렬하기 위한 방법 3 : Comparator 객체 전달(Lambda)	// 대상 객체에 Comparble 구현 없어도 된다.
		Arrays.sort( itemArray, (o1, o2) -> o1.itemId - o2.itemId);
		System.out.println(Arrays.toString(itemArray));
	}
	
	// 정렬이 되기 위한 방법 1 : Comparaable interface를 구현
	
	static class Item implements Comparable<Item>{
		int itemId;
		String itemNm;
		
		Item(int itemId, String itemNm){
			this.itemId = itemId;
			this.itemNm = itemNm;
		}

		@Override
		public String toString() {
			return "Item [itemId=" + itemId + ", itemNm=" + itemNm + "]";
		}

		@Override
		public int compareTo(Item o) {
//			return -(this.itemId - o.itemId);	// itemId 기준 asc
//			return this.itemNm.compareTo(o.itemNm);	// itemNm 기준
			// itemId 우선 비교, 같으면 itemNm 비교
			return this.itemId == o.itemId ? this.itemNm.compareTo(o.itemNm) : this.itemId - o.itemId;
		}
		
		
	}

}
