import java.util.*;

public class UniquePermutations {

    public static List<String> permuteUnique(String s) {
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[] visited = new boolean[chars.length];
        StringBuilder currentPermutation = new StringBuilder();
        backtrack(result, chars, visited, currentPermutation);
        return result;
    }

    private static void backtrack(List<String> result, char[] chars, boolean[] visited, StringBuilder currentPermutation) {
        if (currentPermutation.length() == chars.length) {
            result.add(currentPermutation.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (visited[i] || (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            currentPermutation.append(chars[i]);
            backtrack(result, chars, visited, currentPermutation);

            visited[i] = false;
            currentPermutation.deleteCharAt(currentPermutation.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = sc.nextLine();

        List<String> permutations = permuteUnique(input);

        System.out.println("Unique Permutations:");
        for (String permutation : permutations) {
            System.out.println(permutation);
        }

        sc.close();
    }
}
