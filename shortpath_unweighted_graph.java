import java.util.*;

public class ShortestPath {
    public static int findShortestPath(int V, List<int[]> edges, int start, int end) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < V; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0}); 
        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentNode = current[0];
            int distance = current[1];

            if (currentNode == end) {
                return distance;
            }

            for (int neighbor : graph.get(currentNode)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(new int[]{neighbor, distance + 1});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();

        List<int[]> edges = new ArrayList<>();
        System.out.println("Enter the edges (format: u v): ");
        for (int i = 0; i < E; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edges.add(new int[]{u, v});
        }

        System.out.print("Enter the start node: ");
        int start = scanner.nextInt();
        System.out.print("Enter the end node: ");
        int end = scanner.nextInt();

        int result = findShortestPath(V, edges, start, end);

        if (result == -1) {
            System.out.println("There is no path between node " + start + " and node " + end);
        } else {
            System.out.println("The shortest path length from node " + start + " to node " + end + " is: " + result);
        }

        scanner.close();
    }
}
