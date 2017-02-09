import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.lang.Math;

public class Problems {

    public static Map<Integer, Integer> getCountMap(int[] arr) {
        MyLinearMap<Integer,Integer> theMap = new MyLinearMap<Integer,Integer>();
        for(int i = 0;i < arr.length;i++){
            if(theMap.containsKey(arr[i])){
                theMap.put(arr[i],theMap.get(arr[i])+1);
            }else{
                theMap.put(arr[i],1);
            }
        }
        return theMap;
    }

    public static List<Integer> removeKDigits(int[] num, int k) {
        Node<Integer> head = new Node<Integer>(num[0]);
        Node<Integer> current = head;
        for(int i =1; i < num.length;i++){
            current.next = new Node(num[i]);
            current.next.prev = current;
            current = current.next;
        }
        current = head;
        while(k > 0){
            System.out.println(current.data);
            if(current.next == null){
                current = current.prev;
                current.next = null;
                k--;
            }else{

                if(current.data <= current.next.data){
                    current = current.next;
                }else if(current.data > current.next.data) {
                    if (current.prev == null) {
                        current = current.next;
                        head = head.next;
                        current.prev = null;
                        k--;
                    } else {
                        current.next.prev = current.prev;
                        current.prev.next = current.next;
                        current = current.prev;
                        k--;
                    }
                }

            }

        }
        LinkedList<Integer> ans = new LinkedList<Integer>();
        while(head.next != null){
            ans.addLast(head.data);
            head = head.next;
        }
        ans.addLast(head.data);
        return ans;
    }

    public static int sumLists(Node<Integer> h1, Node<Integer> h2) {
        Node<Integer> h1t = h1;
        Node<Integer> h2t = h2;
        int first = 1;
        while(h1t.next != null){
            first++;
            h1t = h1t.next;
        }

        int second = 1;
        while(h2t.next != null){
            second++;
            h2t = h2t.next;
        }

        h1t = h1;
        h2t = h2;
        double ans = 0;
        while(first>second){
            ans += h1t.data * (Math.pow(10,first-1));
            h1t = h1t.next;

            first--;
        }
        while(second>first){
            ans += h2t.data * (Math.pow(10,second-1));
            h2t = h2t.next;
            second--;
        }

        while(h1t.next != null){
            ans += h2t.data * (Math.pow(10,second-1));
            h2t = h2t.next;
            ans += h1t.data * (Math.pow(10,first-1));
            h1t = h1t.next;
            second--;
            first--;
        }
        ans += h2t.data;
        ans += h1t.data;
        return (int)ans;



    }

}
