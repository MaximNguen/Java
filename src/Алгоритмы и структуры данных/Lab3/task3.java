import java.util.*;

class task3 {
    static class Edge {
        String to;
        int weight;

        public Edge(String to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void dijkstra(Map<String, List<Edge>> graph, String start) {
        Map<String, Integer> distance = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        for (String node : graph.keySet()) {
            distance.put(node, Integer.MAX_VALUE);
        }

        distance.put(start, 0);
        queue.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int currentDist = distance.get(current);

            for (Edge edge : graph.get(current)) {
                int newDist = currentDist + edge.weight;

                if (newDist < distance.get(edge.to)) {
                    distance.put(edge.to, newDist);
                    queue.add(edge.to);
                }
            }
        }

        System.out.println("Кратчайшие расстояния от " + start + ":");
        for (String node : distance.keySet()) {
            System.out.println(node + ": " + distance.get(node));
        }
    }

    public static void main(String[] args) {
        Map<String, List<Edge>> graph = new HashMap<>();

        graph.put("A", Arrays.asList(new Edge("B", 5), new Edge("C", 3)));
        graph.put("B", Arrays.asList(new Edge("A", 5), new Edge("D", 2)));
        graph.put("C", Arrays.asList(new Edge("A", 3), new Edge("D", 2)));
        graph.put("D", Arrays.asList(new Edge("B", 2), new Edge("C", 1)));

        dijkstra(graph, "A");
    }
}
