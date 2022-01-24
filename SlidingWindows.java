class SlidingWindow{

    public static int findMaxSumSubArray(int k, int[] arr) {
       int windowSum = 0, maxSum = 0;
       int windowStart = 0;
       for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
         windowSum += arr[windowEnd]; // add the next element
         // slide the window, we don't need to slide if we've not hit the required window size of 'k'
         if (windowEnd >= k - 1) {
           maxSum = Math.max(maxSum, windowSum);
           windowSum -= arr[windowStart]; // subtract the element going out
           windowStart++; // slide the window ahead
         }
       }
     }
   
     public static int findLengthDistinct(String str) {
       int windowStart = 0, maxLength = 0;
       Map<Character, Integer> charIndexMap = new HashMap<>();
       // try to extend the range [windowStart, windowEnd]
       for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
         char rightChar = str.charAt(windowEnd);
         // if the map already contains the 'rightChar', shrink the window from the beginning so that
         // we have only one occurrence of 'rightChar'
         if (charIndexMap.containsKey(rightChar)) {
           // this is tricky; in the current window, we will not have any 'rightChar' after its previous index
           // and if 'windowStart' is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
           windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
         }
         charIndexMap.put(rightChar, windowEnd); // insert the 'rightChar' into the map
         maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
       }
       return maxLength;
     }
   
     public static void main(String[] args) {
       System.out.println("------------");
       System.out.println("Sliding Window");
       System.out.println("------------");
       System.out.println("Maximum Sum Subarray of Size K\nGiven an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size k.");
       System.out.println(findMaxSumSubArray(3, new int[] {2, 1, 5, 1, 3, 2}));
     }
   }