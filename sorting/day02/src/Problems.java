import java.util.LinkedList;

public class Problems {

    static void sortNumsBetween100s(int[] A) {
        // TODO
        for(int i = 0; i < A.length;i++){
            A[i] += 100;
        }
        RadixSort.radixSort(A,200);
        for(int i = 0; i < A.length;i++){
            A[i] -= 100;
        }
    }

    /**
     * @param n the character number, 0 is the rightmost character
     * @return
     */
    private static int getNthCharacter(String s, int n) {
        return s.charAt(s.length() - 1 - n) - 'a';
    }


    /**
     * Use counting sort to sort the String array according to a character
     *
     * @param n The digit number (where 0 is the least significant digit)
     */
    static void countingSortByCharacter(String[] A, int n) {
        int[] Anum = new int[A.length];
        for(int i = 0; i < A.length;i++){
            Anum[i] = getNthCharacter(A[i],n);
        }

        int max = getNthCharacter(A[0],n);
        int min = getNthCharacter(A[0],n);
        for(int i = 0; i < A.length; i++){
            if(getNthCharacter(A[i],n) > max){
                max = getNthCharacter(A[i],n);
            }
            if(getNthCharacter(A[i],n) < min){
                min = getNthCharacter(A[i],n);
            }
        }
        LinkedList<String>[] counts = new LinkedList[max-min + 1];
        for (int i = 0; i < max-min + 1; i++)
            counts[i] = new LinkedList<>();
        for(int i = 0; i < A.length; i++){
            counts[getNthCharacter(A[i],n) - min].addLast(A[i]);
        }
        int j = 0;
        for (LinkedList<String> list : counts) {
            for(int i = 0; i < list.size();i++){
                A[j] = list.get(i);
                j++;
            }
        }

    }



    /**
     * @param stringLength The length of each of the strings in S
     */
    static void sortStrings(String[] S, int stringLength) {
        for(int i = stringLength-1; i >= 0; i--) {
            countingSortByCharacter(S,i);
        }
    }



}
