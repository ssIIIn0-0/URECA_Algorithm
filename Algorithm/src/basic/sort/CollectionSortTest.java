package basic.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionSortTest {

	public static void main(String[] args) {
		List<Item> list = new ArrayList<>();
		list.add(new Item(3, "666"));
		list.add(new Item(2, "777"));
		list.add(new Item(5, "444"));
		list.add(new Item(3, "111"));
		
		System.out.println(list);
		
//		Collections.sort(list);
//		System.out.println(list);
		
		Collections.sort(list, (el1, el2) -> el1.itemId - el2.itemId);
		System.out.println(list);
		
		Collections.sort(list, (el1, el2) -> el1.itemNm.compareTo(el2.itemNm));
		System.out.println(list);
		
		Collections.sort(list, (el1, el2) -> el1.itemId == el2.itemId ? el1.itemNm.compareTo(el2.itemNm) : el1.itemId - el2.itemId);
		System.out.println(list);		
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
