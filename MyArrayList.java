package queue;

public class MyArrayList <T>   {
	private T [] thing;
	private int size;

	public MyArrayList() {
		this.thing = (T[]) new Object[10];
		this.size = 0;
	}

	public int append(T o) {
		this.thing[this.size] = o;
		this.size++;
		return this.size;
	}

	public T get(int idx) {
		if (idx >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		return this.thing[idx];
	}

	public void set(int idx, T o) {
		if (idx >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		this.thing[idx] = o;
	}



	public static void main(String[] args) {
		MyArrayList<String> list = new MyArrayList<String>();
		list.append("rabbit");
		int i = list.append("cat");
		list.set(0, "dog");
		System.out.println(i);
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		String s = list.get(0);
		
		
	}

}