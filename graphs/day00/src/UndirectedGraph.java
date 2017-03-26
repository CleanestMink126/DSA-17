import java.util.*;

public class UndirectedGraph implements Graph {
    public HashMap<Integer, LinkedList<Integer>> graph;
    public int edges;
    public UndirectedGraph(int n) {
        graph = new HashMap<Integer, LinkedList<Integer>>();
        for(int i =0 ; i < n; i++){
            graph.put(i, new LinkedList<Integer>());
        }
    }
    //01
    @Override
    public void addEdge(int v, int w) {
        graph.get(v).addLast(w);
        graph.get(w).addLast(v);
        edges++;
    }
    //O(V)
    @Override
    public List<Integer> vertices() {
        ArrayList<Integer> my = new ArrayList<Integer>();
        for(int i : graph.keySet()){
    	    my.add(i);
        }
        return my;
    }
    //O1
    @Override
    public int numVertices() {
    	return graph.size();
    }
    //O1
    @Override
    public int numEdges() {
    	return edges;
    }
    //O1
    @Override
    public Iterable<Integer> getNeighbors(int v) {
    	return graph.get(v);
    }
    //0E
    @Override
    public boolean hasEdgeBetween(int v, int w) {
    	return graph.get(v).contains(w);
    }

}
