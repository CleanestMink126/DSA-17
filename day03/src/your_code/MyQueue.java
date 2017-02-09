package your_code;

import ADTs.QueueADT;

import java.util.LinkedList;

/**
 * An implementation of the Queue interface.
 */
public class MyQueue implements QueueADT<Integer> {

    LinkedList<Integer> core;

    public MyQueue(){
        core = new LinkedList<Integer>();
    }

    @Override
    public void enqueue(Integer item) {
        core.addFirst(item);
    }

    @Override
    public Integer dequeue() {
        if(!this.isEmpty()) {
            return core.removeLast();
        }else{
            throw new IllegalStateException();
        }
    }

    @Override
    public boolean isEmpty() {
        if(core.size() != 0){
            return false;
        }
        return true;
    }

    @Override
    public Integer front() {
        if(!this.isEmpty()) {
            return core.peekLast();
        }else{
            throw new IllegalStateException();
        }
    }
}