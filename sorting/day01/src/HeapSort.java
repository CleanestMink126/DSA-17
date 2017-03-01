public class HeapSort extends SortAlgorithm {
    int size;
    int[] heap;

    private int parent(int i) {
        return (i-1) / 2;
    }

    private int leftChild(int i) {
        return 2*i + 1;
    }

    private int rightChild(int i) {
        return 2 * (i + 1);
    }

    // Recursively corrects the position of element indexed i: check children, and swap with larger child if necessary.
    public void heapify(int i) {
        if(rightChild(i) < size){
            if(heap[leftChild(i)] > heap[i] && heap[rightChild(i)] > heap[i]){
                if(heap[leftChild(i)] > heap[rightChild(i)]){
                    this.switchSpot(leftChild(i) , i);
                    heapify(leftChild(i));
                }else{
                    this.switchSpot(rightChild(i) , i);
                    heapify(rightChild(i));
                }
            }else if(heap[leftChild(i)] > heap[i]){
                this.switchSpot(leftChild(i) , i);
                heapify(leftChild(i));
            }else if(heap[rightChild(i)] > heap[i]){
                this.switchSpot(rightChild(i) , i);
                heapify(rightChild(i));
            }
        }else if(leftChild(i)< size && heap[leftChild(i)] > heap[i]){
            this.switchSpot(leftChild(i) , i);
        }
    }

    // Given the array, build a heap by correcting every non-leaf's position.
    public void buildHeapFrom(int[] array) {
        this.heap = array;
        this.size = array.length;
        for(int i = size - 1; i >= 0; i--){
            heapify(i);
        }
    }

    /**
     * Best-case runtime:NlogN
     * Worst-case runtime:NlogN
     * Average-case runtime:NlogN
     *
     * Space-complexity:O1
     */
    @Override
    public int[] sort(int[] array) {
        buildHeapFrom(array);
        int[] ans = new int[array.length];
        for (int i=0; i< array.length; i++) {
            ans[i]= pop();
        }
        return heap;
    }

    public int pop(){
        int highest = heap[0];
        switchSpot(0,size-1);
        size--;
        heapify(0);
        return highest;
    }

    public void switchSpot(int i,int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

}
