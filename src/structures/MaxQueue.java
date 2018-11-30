package structures;

import comparators.IntegerComparator;

import java.util.Comparator;
import java.util.Iterator;

public class MaxQueue<V> implements PriorityQueue<Integer, V> {

	private StudentArrayHeap<Integer, V> queue = 
			new StudentArrayHeap<Integer, V>(new IntegerComparator());
	int size = 0;
	
	public MaxQueue<V>(){
		queue = null;
		int size = 0;
	}
	
	@Override
	public PriorityQueue<Integer, V> enqueue(Integer priority, V value) 
			throws NullPointerException {
		// TODO Auto-generated method stub
		if(priority == null || value == null) {
			throw new NullPointerException();
		}
		
		queue.add(priority, value);
		size++;
		
		return (PriorityQueue<Integer, V>) queue;
	}

	@Override
	public V dequeue() throws IllegalStateException {
		// TODO Auto-generated method stub
		if(queue.isEmpty()) {
			throw new IllegalStateException();
		}
		
		V retVal = queue.peek();
		queue.remove();
		size--;
		return retVal;
	}

	@Override
	public V peek() {
		// TODO Auto-generated method stub
		return queue.peek();
	}

	@Override
	public Iterator<Entry<Integer, V>> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<Integer> getComparator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return queue.isEmpty();
	}
}
