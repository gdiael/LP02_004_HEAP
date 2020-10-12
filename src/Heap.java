import java.io.File;

public class Heap extends PriorityQueue {
	
	public Heap(int [] vetor){
	}
	
	public void subir(int i){
	}
	
	public boolean add(int value) {
		elements[size] = value;
		size += 1;
		subir(size-1);
		return false;
	}
	
	public int remove() {
		return 0;
	}
	
	public int get() {
		return 0;
	}
	
	public void update(int value, int newValue) {
	}
}