public class MyArrayList<T>{
    private Object[] elems;
	private int size;

	public MyArrayList() {
		elems = new Object[10];
		size =0;
	}

	public MyArrayList(int capacity) {
		elems = new Object[4 * capacity];
		size = 0;
	}

	public void add(int index,T c) {
		if(size >= elems.length){
			resize(2);
		}else{
			for(int i = size;i > index-1; i--){
				elems[i]= elems[i-1];
			}
			elems[index]= c;
		}
		size++;
	}

	public int size() {


		return size;
	}

	public T get(int index) {

		if (index >= size){
			throw new IndexOutOfBoundsException();

		}else{
			return (T)elems[index];
		}



	}

	public T remove(int index) {
		if (size <= 0 || index >= size || index < 0){
			throw new IndexOutOfBoundsException();
		}else{
			T r = (T)elems[index];
			for(int i = index; i < size;i++){
				elems[i] = elems[i+1];
			}
			size--;
			if(size< elems.length/4){
				resize(.5);
			}
			return r;
		}

	}
	public void resize(double c){


		Object[] elems2 = new Object[(int)(elems.length * c)];
		for(int i = 0; i < size;i++){
			elems2[i]=elems[i];
		}
		elems = elems2;
	}

	public void add(T c) {
		if(size >= elems.length){
			resize(2);
		}else{
			elems[size] = c;
		}
		size++;
	}
}
