import java.util.*;
import java.io.*;

class Main {

    public static String GraphChallenge(String[] strArr) {
        int n = Integer.parseInt(strArr[0]);
        Map<String, List<String>> graph = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graph.put(strArr[i], new ArrayList<>());
        }

        for (int i = n + 1; i < strArr.length; i++) {
            String[] edge = strArr[i].split("-");
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return bfs(graph, strArr[1], strArr[n]);
    }

    private static String bfs(Map<String, List<String>> graph, String start, String end) {
        Queue<List<String>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(Arrays.asList(start));
        visited.add(start);

        while (!queue.isEmpty()) {
            List<String> path = queue.poll();
            String node = path.get(path.size() - 1);

            if (node.equals(end)) {
                return String.join("-", path);
            }

            for (String neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(neighbor);
                    queue.offer(newPath);
                }
            }
        }
        return "-1";
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print(GraphChallenge(s.nextLine()));
    }

}
