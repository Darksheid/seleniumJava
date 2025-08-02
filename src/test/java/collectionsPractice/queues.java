package collectionsPractice;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class queues {
	
	
	
	static Queue<Integer> shortenQueue(Queue<Integer> queue) {
		System.out.println("\nRemoving element : "+queue.poll());
        return queue;
    }
	
	static void printQueue(Queue<Integer> q) {
		Iterator<Integer> iter = q.iterator();
		while(iter.hasNext()) {
			Integer ele = iter.next();
			System.out.print(ele+"\t");
		}
	}

	public static void main(String[] args) {
		Queue q = new ArrayDeque<Integer>();
		int size=5;
		for(int i=1;i<=size;i++) {
			q.add(i*10);
		}
		System.out.println("Before removing elements :");
		printQueue(q);
		q=shortenQueue(q);
		q=shortenQueue(q);
		q=shortenQueue(q);
		System.out.println("After removing elements :");
		printQueue(q);
		
		
		

	}

}
