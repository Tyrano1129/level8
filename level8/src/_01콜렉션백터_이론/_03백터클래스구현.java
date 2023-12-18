package _01콜렉션백터_이론;

class MyVector{
	int[] arr;
	int size;
	int capacity;
	MyVector(){
		arr = new int[10];
		capacity = 10;
	}
	
	void add (int value) {
		if (size >= capacity){
			capacity += 10;
			int[] temp = arr;
			arr = new int[capacity];
			for(int i =0; i < temp.length; i+=1) {
				arr[i] = temp[i];
			}
		}
		arr[size] = value;
		size+=1;
	}
	int capacity() {
		return capacity;
	}
	void remove(int idx) {
		if (idx < 0 || idx >= size) {
			throw new ArrayIndexOutOfBoundsException(idx);
		}else {
			for(int i = idx; i < size-1; i+=1) {
				arr[i] = arr[i+1];
			}
			arr[size-1] = 0;
			size-=1;
		}
	}
	
	void add(int idx, int value) {
		if (idx < 0 || idx >= size) {
			throw new ArrayIndexOutOfBoundsException(idx);
		}
		size += 1;
		if (size >= capacity) {
			capacity += 10;
			int[] temp = arr;
			arr = new int[capacity];
			for (int i = 0; i < temp.length; i += 1) {
				arr[i] = temp[i];
			}
		}
		for (int i = size; i > idx; i -= 1) {
			arr[i] = arr[i-1];
		}
		arr[idx] = value;
		
	}
	void set(int idx, int value) {
		if (idx < 0 || idx >= size) {
			throw new ArrayIndexOutOfBoundsException(idx);
		}
		arr[idx] = value;
	}
	int get(int idx) {
		if (idx < 0 || idx >= size) {
			throw new ArrayIndexOutOfBoundsException(idx);
		}
		return arr[idx];
	}
	int size() {
		return size;
	}
	void clear() {
		arr = new int[capacity];
		size = 0;
	}
	@Override
	public String toString() {
		String data = "";
		for(int i = 0; i < size; i+=1) {
			if(arr[i] != 0) {
				data += i == 0? arr[i] : ", " + arr[i];
			}
		}
		return "["+data+"]";
	}
	
}
public class _03백터클래스구현 {

	public static void main(String[] args) {
		
		MyVector v1 = new MyVector();
		System.out.println(v1);
		System.out.println(v1.size());
		System.out.println(v1.capacity());
		for(int i = 0; i < 10; i+=1) {
			v1.add((i+1)*10);
		}
		System.out.println(v1.size());
		System.out.println(v1.capacity());
		System.out.println(v1.get(1));
		v1.set(1,10000);
		System.out.println(v1);
		v1.add(1, 20);
		System.out.println(v1);
		v1.remove(3);
		System.out.println(v1);
		System.out.println(v1.size());
		System.out.println(v1.capacity());
		
		v1.clear();
		System.out.println(v1);
		System.out.println(v1.size());
		System.out.println(v1.capacity());
	}

}
