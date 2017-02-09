package your_code;

import ADTs.StackADT;

import java.util.LinkedList;


/**
 * An implementation of the Stack interface.
 */
public class MyStack implements StackADT<Integer> {

    LinkedList<Integer> core;
    LinkedList<Integer> maxStack;
    public MyStack(){
        core = new LinkedList<Integer>();
        maxStack = new LinkedList<Integer>();
    }
    @Override
    public void push(Integer e) {
        if(maxStack.size() == 0 || maxStack.peekLast()<= e){
            maxStack.addLast(e);
        }
        core.addLast(e);
    }

    @Override
    public Integer pop() {
        if(!this.isEmpty()) {
            if(maxStack.peekLast() == core.peekLast()){
                maxStack.removeLast();
            }
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
    public Integer peek() {
        if(!this.isEmpty()) {
            return core.peekLast();
        }else{
            throw new IllegalStateException();
        }
    }

    public Integer maxElement() {
        if(maxStack.size() != 0){
            return maxStack.peekLast();
        }else{
            throw new IllegalStateException();
        }

    }
}
