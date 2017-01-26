public class MyArrayList {
    private Cow[] elems;
	private int size;

	public MyArrayList() {
		elems = new Cow[10];
		size =0;
	}

	public MyArrayList(int capacity) {
		elems = new Cow[4 * capacity];
		size = 0;
	}

	public void add(int index,Cow c) {
		if(size >= elems.length){
			resize(2);
		}else{
			for(int i = size;i > index; i--){
				elems[size]= elems[size-1];
			}
			elems[index]= c;
		}
		size++;
	}

	public int size() {


		return size;
	}

	public Cow get(int index) {

		if (index >= size){
			throw new IndexOutOfBoundsException();

		}else{
			return elems[index];
		}



	}

	public Cow remove(int index) {
		if (size <= 0 || index > size || index <= 0){
			throw new IndexOutOfBoundsException();
		}else{
			Cow r = elems[index];
			for(int i = index; i <= elems.length - 1;i++){
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


		Cow[] elems2 = new Cow[(int)(size * c)];
		for(int i = 0; i < size;i++){
			elems2[i]=elems[i];
		}
		elems = elems2;
	}

	public void add(Cow c) {
		elems[size] = c;
		size++;
	}
}
