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
		
	}

	@Override
	protected void bubbleDown(int index) {
		// TODO Auto-generated method stub
		
	}

}