package your_code;

import ADTs.StackADT;

import java.util.LinkedList;

public class PsetProblems {

    public static int longestValidSubstring(String s) {
        LinkedList<String> core = new LinkedList<String>();
        int temp = 0;
        int perm = 0;
        for(int i = 0; i < s.length();i++){
            if(s.substring(i,i+1).equals("(")){
                core.addLast(s.substring(i,i+1));
            }else if(s.substring(i,i+1).equals(")") && !core.isEmpty()){
                core.removeLast();
                temp++;

            }else if(s.substring(i,i+1).equals(")") && core.isEmpty()){
                if(temp > perm){
                    perm = temp;
                }
                temp = 0;
            }
        }
        if(temp > perm){
            perm = temp;
        }
        return 2 * perm;
    }

    public static StackADT<Integer> sortStackLimitedMemory(StackADT<Integer> s) {
        StackADT<Integer> s2 = new MyStack();
        int temp = 0;
        s2.push(s.pop());
        while(true) {

            if(s.peek()<s2.peek()){
                temp = s.pop();
                while(temp<s2.peek()){
                    s.push(s2.pop());
                    if(s2.isEmpty()){
                        break;
                    }
                }
                s2.push(temp);
            }else{
                s2.push(s.pop());
            }
            if(s.isEmpty()){
                break;
            }
        }
        return s2;
    }

}
