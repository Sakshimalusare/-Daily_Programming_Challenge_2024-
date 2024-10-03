import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
 
        Map<String, List<String>> anagramMap = new HashMap<>();
        
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            
            if (!anagramMap.containsKey(sortedString)) {
                anagramMap.put(sortedString, new ArrayList<>());
            }
            anagramMap.get(sortedString).add(s);
        }
        
        return new ArrayList<>(anagramMap.values());
    }

    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of strings:");
        int n = sc.nextInt(); 
        sc.nextLine();  
        
        String[] strs = new String[n];
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }
        
       
        List<List<String>> result = groupAnagrams(strs);
        
        
        System.out.println("Grouped Anagrams:");
        for (List<String> group : result) {
            System.out.println(group);
        }
        
        sc.close();
    }
}
