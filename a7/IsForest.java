import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class IsForest {
    public class Pair<S, T> {
        public final S first;
        public final T second;

        public Pair(S first, T second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }

    public static int identifyTrees(int n, Iterable<Pair<Integer, Integer>> edges) {
        Set<Integer>[] graph = new TreeSet[n];
        Arrays.fill(graph, new TreeSet<>());
        int tc = 0;
        Set<Integer> allvisit = new TreeSet<>();
        Iterator<Pair<Integer, Integer>> iterator = edges.iterator();
        cycle cycleCheck = new cycle();


        while (iterator.hasNext()) {
            Pair<Integer, Integer> p = iterator.next();
            graph[p.first].add(p.second);
            graph[p.second].add(p.first);
        }
        for (int i = 0; i < n; i++) {
            if (allvisit.contains(i)) {
                continue;
            }
            Set<Integer> traversal = bfs(graph, i, allvisit, cycleCheck);
            if (!traversal.isEmpty()) {
                tc++;
            }
            if (cycleCheck.e >= 2 * traversal.size()) {
                return 0;
            } else cycleCheck.e = 0;
        }
        return tc;
    }

    static Set<Integer> nbrsExcluding(
            Set<Integer>[] G,
            Set<Integer> vtxes,
            Set<Integer> excl,
            cycle c) {
        Set<Integer> union = new TreeSet<>();
        for (Integer src : vtxes) {
            for (Integer dst : G[src])
                if (!excl.contains(dst)) {
                    union.add(dst);
                    c.e++;
                } else {
                    c.e++;
                }
        }
        return union;
    }

    static Set<Integer> bfs(Set<Integer>[] G,
                            int s,
                            Set<Integer> visited,
                            cycle c) {
        Set<Integer> frontier = new TreeSet<>(Arrays.asList(s));
        visited.add(s);
        while (!frontier.isEmpty()) {
            frontier = nbrsExcluding(G, frontier, visited, c);
            visited.addAll(frontier);
        }
        return visited;
    }

    static class cycle {
        public int e = 0;
    }
}