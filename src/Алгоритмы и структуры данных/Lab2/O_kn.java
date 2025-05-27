import java.util.*;

public class O_kn {
    public static List<List<Integer>> findAllSubsets(int[] elements) {
        List<List<Integer>> allSubsets = new ArrayList<>(); 
        generateSubsets(elements, 0, new ArrayList<>(), allSubsets); 
        return allSubsets;
    }

    private static void generateSubsets(int[] elements, int index, List<Integer> currentSubset, List<List<Integer>> allSubsets) {
        if (index == elements.length) {
            allSubsets.add(new ArrayList<>(currentSubset));
            return;
        }

        generateSubsets(elements, index + 1, currentSubset, allSubsets);

        currentSubset.add(elements[index]);
        generateSubsets(elements, index + 1, currentSubset, allSubsets); 
        currentSubset.remove(currentSubset.size() - 1);
    }
}
