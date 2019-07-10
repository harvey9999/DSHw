import java.util.*;

public class Cycle {
    public static class Pair<S, T> {
        public final S first;
        public final T second;
        public Pair(S first, T second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() { return "("+first+", "+second+")"; }
    }
    public static HashMap<String , Set<String>> createG(ArrayList<Pair<String, String>> graph, Set<String> visitall){
        HashMap<String, Set<String>> crgraph = new HashMap<>();
        for (int i = 0; i < graph.size(); i++){
            Pair<String, String> p = graph.get(i);
            visitall.add(p.first);
            visitall.add(p.second);
            if (!crgraph.containsKey(p.first)){
                Set<String> set = new HashSet<>();
                set.add(p.second);
                crgraph.put(p.first, set);
            }else{
                crgraph.get(p.first).add(p.second);
            }
        }
        return crgraph;
    }
    public static List<String> findCycle(ArrayList<Pair<String, String>> graph){
        Set<String> nv = new HashSet<>();
        HashMap<String, Set<String>> map = createG(graph,nv);
        Set<String> v = new HashSet<>();
        List<String> ans =  cHelper(map, new ArrayList<>(), v,graph.get(0).first);
        nv.removeAll(v);
        while(!nv.isEmpty()){
            Iterator<String> iter = nv.iterator();
            ans =  cHelper(map, new ArrayList<>(), v,iter.next());
            if (ans!= null){
                return ans;
            }
            nv.removeAll(v);
        }
        return ans;
    }

    public static List<String> cHelper(HashMap<String, Set<String>> map, List<String> ds, Set<String> v, String c){
        v.add(c);
        if (map.containsKey(c)) {
            if (ds.contains(c)) {
                return ds;
            } else {
                ds.add(c);
                Set<String> nbrs = map.get(c);
                List<String> result;
                for (String nbr : nbrs) {
                    result = cHelper(map, ds, v, nbr);
                    if (result != null) {
                        return result;
                    }
                    ds.remove(nbr);
                }
            }
        }
        return null;
    }


}
