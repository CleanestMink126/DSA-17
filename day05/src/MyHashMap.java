import java.lang.reflect.Array;
import java.util.*;

/**
 * Implementation of a HashMap using a collection of MyLinearMap and
 * resizing when there are too many or too few entries.
 *
 * @author downey
 * @param <K>
 * @param <V>
 *
 */
public class MyHashMap<K, V> implements Map<K, V> {

	// average number of entries per map before we grow the map
	private static final double ALPHA = 1.0;
	// average number of entries per map before we shrink the map
	private static final double BETA = .25;

	// resizing factor: (new size) = (old size) * (resize factor)
	private static final double SHRINK_FACTOR = 0.5, GROWTH_FACTOR = 2.0;

	private static final int MIN_MAPS = 16;

	// list of maps
	protected List<MyLinearMap<K,V>> maps;

	private int numEntries = 0;

	public MyHashMap() {
		makeMaps(MIN_MAPS);
	}

	@Override
	public int size() {
		return numEntries;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Initialize maps
	 */
	protected void makeMaps(int size) {
		maps = new ArrayList<MyLinearMap<K,V>>(size);
		for(int i = 0;i < size; i++){
			maps.add( new MyLinearMap<K, V> ());
		}

		this.numEntries = 0;
	}

	protected MyLinearMap<K, V> chooseMap(Object key) {


		return maps.get(Objects.hashCode(key) % maps.size());
	}

	@Override
	public boolean containsKey(Object key) {
		return chooseMap(key).containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		for(MyLinearMap<K, V> i : maps){
			if(i.containsValue(value)){
				return true;
			}
		}
		return false;
	}

	protected void rehash(double growthFactor) {
		ArrayList<MyLinearMap<K,V>> maps2 = new ArrayList<MyLinearMap<K,V>>((int)(maps.size() * growthFactor));
		for(int i = 0;i < (int)(maps.size()*growthFactor); i++){
			maps2.add( new MyLinearMap<K, V> ());
		}
		for(MyLinearMap<K, V> i : maps){
			for(Entry myEntry : i.getEntries()){
				maps2.get(Objects.hashCode(myEntry.getKey()) % maps2.size()).put((K)myEntry.getKey(), (V)myEntry.getValue());
			}
		}
		maps = maps2;
	}

	@Override
	public V get(Object key) {
		MyLinearMap<K,V> m = chooseMap(key);
		return m.get(key);
	}

	@Override
	public V put(K key, V value) {
		if(numEntries/maps.size() >= ALPHA){
			rehash(GROWTH_FACTOR);
		}
		numEntries -= chooseMap(key).size();
		V back = chooseMap(key).put(key,value);
		numEntries += chooseMap(key).size();

		return back;
	}

	@Override
	public V remove(Object key) {
		if((double)(numEntries)/maps.size() < BETA){
			System.out.println(numEntries/maps.size());
			rehash(SHRINK_FACTOR);
		}
		if(this.containsKey(key)){

			V back = chooseMap(key).remove(key);
			numEntries--;
			return back;
		}else{
			return null;
		}

	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
			put(entry.getKey(), entry.getValue());
		}
	}

	public void clear() {
		for (int i=0; i<maps.size(); i++) {
			maps.get(i).clear();
		}
		numEntries = 0;
	}

	@Override
	public Set<K> keySet() {
		Set<K> set = new HashSet<>();
		for (MyLinearMap<K,V> map : maps) {
			set.addAll(map.keySet());
		}
		return set;
	}

	@Override
	public Collection<V> values() {
		Collection<V> ll = new LinkedList<>();
		for (MyLinearMap<K,V> map : maps) {
			ll.addAll(map.values());
		}
		return ll;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		Set<Entry<K,V>> set = new HashSet<>();
		for (MyLinearMap<K,V> map : maps) {
			set.addAll(map.getEntries());
		}
		return set;
	}
}
