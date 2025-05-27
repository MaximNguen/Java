import java.util.*;

class Request {
    int begin;
    int end;

    Request(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    public String toString() {
        return "(" + begin + ", " + end + ")";
    }
}

public class task1 {
    public static List<Request> selectRequest(List<Request> requests) {
        Collections.sort(requests, new Comparator<Request>() {

            public int compare(Request r1, Request r2) {
                return Integer.compare(r1.end, r2.end);
            }
        });

        List<Request> selected = new ArrayList<>();

        if (requests.isEmpty()) {
            return selected;
        }

        Request lastSelected = requests.get(0);
        selected.add(lastSelected);

        System.out.println("Отсортированные заявки до перебора");

        for (int i = 1; i < requests.size(); i++) {
            Request current = requests.get(i);
            
            System.out.println(current);
        
            if (current.begin >= lastSelected.end) {
                selected.add(current);
                lastSelected = current;
            }
        }
        return selected;
    }

    public static void main(String[] args) {
        // Заявки в произвольном порядке (не отсортированы)
        List<Request> requests = Arrays.asList(
            new Request(6, 10),
            new Request(1, 4),
            new Request(8, 12),
            new Request(3, 5),
            new Request(0, 6),
            new Request(5, 7),
            new Request(8, 11),
            new Request(12, 14),
            new Request(3, 8),
            new Request(5, 9),
            new Request(2, 13)
        );

        System.out.println("Исходные заявки:");
        for (Request request : requests) {
            System.out.println(request);
        }

        List<Request> selectedActivities = selectRequest(requests);

        System.out.println("\nВыбранные заявки:");
        for (Request request : selectedActivities) {
            System.out.println(request);
        }
        System.out.println("Общее количество: " + selectedActivities.size());
    }
}