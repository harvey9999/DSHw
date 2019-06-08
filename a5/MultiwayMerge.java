package hw5;
import java.util.*;

public class MultiwayMerge {
        public static LinkedList<Integer> mergeAll(LinkedList<Integer>[] lists) {
            LinkedList<Integer> finalans= new LinkedList<>();
            int c=0;
            PriorityQueue<LinkedList<Integer>> q=new PriorityQueue<>(Comparator.comparing(LinkedList<Integer>::peek));
            for (int i = 0; i <lists.length ; i++) {
                q.add(lists[i]);
                c+=lists[i].size();
            }
            while(c>0){
                if(q.peek()!=null) {
                    LinkedList<Integer> store = q.poll();
                    finalans.add(store.poll());
                    if (!store.isEmpty()) {
                        q.add(store);

                    }
                }
                c--;
            }
            return finalans;
        }
    }