import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);
        
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        int k = (int) st.nval;
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            st.nextToken();
            arr[i] = (int) st.nval;
        }
        
        System.out.println(maxUniqueInWindow(arr, n, k));
    }
    
    static int maxUniqueInWindow(int[] arr, int n, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int maxUnique = 0;
        
        // Build the first window
        for (int i = 0; i < k; i++) {
            freq.merge(arr[i], 1, Integer::sum);
        }
        maxUnique = freq.size();
        
        // Slide the window
        for (int i = k; i < n; i++) {
            // Remove the element going out of the window
            int outElement = arr[i - k];
            int count = freq.get(outElement);
            if (count == 1) {
                freq.remove(outElement);
            } else {
                freq.put(outElement, count - 1);
            }
            
            // Add the new element coming into the window
            freq.merge(arr[i], 1, Integer::sum);
            
            maxUnique = Math.max(maxUnique, freq.size());
        }
        
        return maxUnique;
    }
}