package your_code;

import java.util.LinkedList;

/**
 * An implementation of a priority Queue
 */
public class MyPriorityQueue {

    LinkedList<Integer> core;
    public MyPriorityQueue(){
        core = new LinkedList<Integer>();
    }

    public void enqueue(int item) {

        if(core.size() != 0){
            int i = 0;
            while(item>core.get(i)){
                i++;
                if(i == core.size()){

                    break;
                }
            }
            if(i == core.size()){

                core.addLast(item);
            }else{
                core.add(i,item);
            }

        }else{
            core.addLast(item);
        }
    }

    /**
     * Return and remove the largest item on the queue.
     */
    public int dequeueMax() {
        if(core.size() != 0){
            return core.removeLast();
        }else{
            throw new IllegalStateException();
        }
    }

}