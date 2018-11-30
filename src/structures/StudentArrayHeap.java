package structures;

import java.util.Comparator;
import java.util.Iterator;

public class StudentArrayHeap<P, V> extends AbstractArrayHeap<P, V> {

	protected StudentArrayHeap(Comparator<P> comparator) {
		super(comparator);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected int getLeftChildOf(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if(index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		return (2 * index) + 1;
	}

	@Override
	protected int getRightChildOf(int index) {
		// TODO Auto-generated method stub
		if(index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		return (2 * index) + 2;
	}

	@Override
	protected int getParentOf(int index) {
		// TODO Auto-generated method stub
		if(index < 1) {
			throw new IndexOutOfBoundsException();
		}
		
		return (index - 1) / 2;
	}

	@Override
	protected void bubbleUp(int index) {
		// TODO Auto-generated method stub
		if(this.size() < 2 || index == 0) {
			return;
		}
		
		Entry<P, V> c = heap.get(index);
		Entry<P, V> p = heap.get(getParentOf(index));
		
		if((index > 0) && (super.comparator.compare(c.getPriority(), p.getPriority()) > 0)) {
			swap(index, getParentOf(index));
			bubbleUp(getParentOf(index));
		}
	}

	@Override
	protected void bubbleDown(int index) {
		// TODO Auto-generated method stub
		System.out.println("before swap ----> " + toString());
		if(this.size() < 1 || index > this.size() - 1 ) {
			return;
		}
		
		if(getLeftChildOf(index) > this.size() - 1 || getRightChildOf(index) > this.size() - 1) {
			return;
		}
		
		Entry<P, V> p = heap.get(index);
		Entry<P, V> lC = heap.get(getLeftChildOf(index));
		Entry<P, V> rC = heap.get(getRightChildOf(index));
		
		System.out.println("p: " + index + " lc: " + getLeftChildOf(index)+ " rc: " + getRightChildOf(index)); 
		
		if(super.comparator.compare(p.getPriority(), lC.getPriority()) < 0 ||
				super.comparator.compare(p.getPriority(), rC.getPriority()) < 0) {
			if(super.comparator.compare(rC.getPriority(), lC.getPriority()) < 0) {
				swap(index, getLeftChildOf(index));
				System.out.println("after swap ----> " + toString());
				bubbleDown(getLeftChildOf(index));
			}
			else {
				swap(index, getRightChildOf(index));
				System.out.println("after swap ----> " + toString());
				bubbleDown(getRightChildOf(index));
			}
		}
	}
	
	public String toString() {
		String output = "";
		for(Entry<P, V> e : heap) {
			output += e.getPriority() + " : " + e.getValue() + " ";
		}
		return output;
	}
	
}