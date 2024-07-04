package 자료구조알고리즘.ch04;

//데이터 입력, 출력 pointer
//데이터 변화에 배열의 데이터를 이동 X
public class IntQueue {
 private int[] que;
 private int capacity; // 용량
 private int front; // 맨 앞 요소를 가리킨다.
 private int rear; // 맨 뒤 요소를 가리킨다.
 private int num; // 실제 데이터의 갯수
 
 // 생성자
 public IntQueue(int maxlen) {
     capacity = maxlen;
     num = front = rear = 0;
     
     // 지나치게 큰 용량에 대해서 OutOfMemoryError 처리
     try {
         que = new int[capacity];
     }catch(OutOfMemoryError e) {
         capacity = 0;
     }
 }
 
 // enque
 public int enque(int x) {
     if( num >= capacity ) throw new OverflowIntQueueException();
     que[rear++] = x;
     num++;
     if( rear == capacity ) rear = 0;
     return x;
 }
 
 // deque
 public int deque() {
     if( num <= 0 ) throw new EmptyIntQueueException();
     int x = que[front++];
     num--;
     if( front == capacity ) front = 0;
     return x;
 }
 
 // peek
 // 용량이 비워져 있을 때 예외 발생 
 public int peek() {
     if( num <= 0 ) {
         throw new EmptyIntQueueException();
     }
     return que[front];
 }
 
 // 초기화 
 public void clear() {
     num = front = rear = 0;
 }
 
 // 검색 + index
 public int indexOf(int x) {
     // 위(탑)부터 찾기
     for (int i = 0; i < num; i++) {
         int idx = ( i + front ) % capacity;
         if( que[idx] == x ) return idx;
     }
     return -1;
 }
 
 // 용량
 public int getCapacity() {
     return capacity;
 }
 
 public int size() {
     return num;
 }
 
 public boolean isEmpty() {
     return num <= 0;
 }
 
 public boolean isFull() {
     return num >= capacity;
 }
 
 public void dump() {
     if( num <= 0 ) {
         System.out.println("큐가 비어 있습니다.");
         return;
     }
     
     for (int i = 0; i < num; i++) {
         int idx = ( i + front ) % capacity;
         System.out.print(que[idx] + " ");
     }
     System.out.println();
 }   
 
 public class OverflowIntQueueException extends RuntimeException{
     private static final long serialVersionUID = 1L;
     public OverflowIntQueueException() {}
 }
 
 public class EmptyIntQueueException extends RuntimeException{
     private static final long serialVersionUID = 1L;
     public EmptyIntQueueException() {}
 }
}

