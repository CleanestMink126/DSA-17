import java.util.*;

public class GraphProblems {

    public static boolean connected(Graph g, int v, int u) {
        HashSet<Integer> t = new HashSet<Integer>();
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.addLast(v);
        t.add(v);
        while(q.size()>0){
            int place = q.remove(0);
            for(int i : g.getNeighbors(place)){
                if(!t.contains(i)){
                    t.add(i);
                    q.addLast(i);
                }
                if(i == u){
                    return true;
                }
            }
        }
        return false;

    }

    public static List<Integer> topologicalOrder(Digraph g) {
        HashSet<Integer> t = new HashSet<Integer>();
        LinkedList<Integer> l = new LinkedList<Integer>();
        List<Integer> verts = g.vertices();
        while(t.size()< g.numVertices()) {
            int i = 0;
            while(t.contains(verts.get(i))) {
                i++;
            }
            t.add(verts.get(i));
            recurseL(l,t,verts.get(i),g);
        }
        return l;
    }

    public static void recurseL(LinkedList<Integer> l, HashSet<Integer> t, int c, Digraph g){
        for (int i : g.getNeighbors(c)) {
            if (!t.contains(i)) {
                t.add(i);
                recurseL(l,t,i,g);
            }
        }
        l.add(0,c);
    }

    public static boolean hasCycle(UndirectedGraph g) {
        HashSet<Integer> t = new HashSet<Integer>();
        LinkedList<Integer> l = new LinkedList<Integer>();
        List<Integer> verts = g.vertices();
        boolean res = true;

        while(t.size()< g.numVertices()) {
            int i = 0;
            while(t.contains(verts.get(i))) {
                i++;
            }
            t.add(verts.get(i));
            res = res && recurseC(l, verts.get(i),verts.get(i),g,t);
        }
        return !res;
    }

    public static boolean recurseC(LinkedList<Integer> l, int p, int c, Digraph g, HashSet<Integer> t){
        boolean res = true;
        for (int i : g.getNeighbors(c)) {
            if (!l.contains(i)) {
                l.add(i);
                res = res && recurseC(l,c,i,g,t);
                l.remove((Integer)i);
            }else if(i == p){
                //we good
            }else{
                return false;
            }
            if (!t.contains(i)) {
                t.add(i);
            }
        }
        return res;

    }
}