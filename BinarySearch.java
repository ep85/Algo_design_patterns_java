/*
Time complexity #
Since, we are reducing the search range by half at every step, this means that the time complexity of our algorithm will be O(logN) where ‘N’ is the total elements in the given array.

Space complexity #
The algorithm runs in constant space O(1)O(1).
*/


class BinarySearch {

    public static char searchNextLetter(char[] letters, char key) {
      int n = letters.length;
      int start = 0; int end = letters.length - 1;
      while (start <= end) {
        int mid = start + (end-start)/2;
        if (letters[mid] == key) {
          return letters[mid];
        }
        if (key < letters[mid]){
          end = mid -1;
        } 
        else  {
          start = mid + 1;
        }
      }
      return letters[start%n];
    }
  
    public static int searchCeilingOfANumber(int[] arr, int key) {
      if (key > arr[arr.length - 1]) // if the 'key' is bigger than the biggest element
        return -1;
      int start = 0, end = arr.length - 1;
      while (start <= end) {
        // calculate the middle of the current range
        int mid = start + (end - start) / 2;
        if (key < arr[mid]) {
          end = mid -1;
        } else if (key > arr[mid]) {
          start = mid + 1;
        } else { // found the key
          return mid;
        }
      }
      return start;
    }
  
  
    public static int search(int[] arr, int key) {
      int start = 0, end = arr.length - 1;
      boolean isAscending = arr[start] < arr[end];
      while (start <= end) {
        // calculate the middle of the current range
        int mid = start + (end - start) / 2;
  
        if (key == arr[mid]) {
          return mid;
        }
        if (isAscending) { // ascending order
          if (key < arr[mid]) {
            end = mid - 1; // the 'key' can be in the first half
          } else { // key > arr[mid]
            start = mid + 1; // the 'key' can be in the second half
          }
        } else { // descending order        
          if (key > arr[mid]) {
            end = mid - 1; // the 'key' can be in the first half
          } else { // key < arr[mid]
            start = mid + 1; // the 'key' can be in the second half
          }
        }
      }
      return -1; // element not found
    }
    public static int[] findRange(int[] arr, int key) {
      int[] result = new int[] { -1, -1 };
      result[0] = searchRange(arr, key, false);
      if (result[0] != -1){
      // no need to search, if 'key' is not present in the input array
        result[1] = searchRange(arr, key, true);
      }
      System.out.println("{"+result[0]+","+result[1]+"}");
      return result;
    }
  
    private static int searchRange(int[] arr, int key, boolean findMaxIndex) {
      int keyIndex = -1;
      int start = 0, end = arr.length - 1;
      while (start <= end) {
        int mid = start + (end - start) / 2;
        if (key < arr[mid]) {
          end = mid - 1;
        } else if (key > arr[mid]) {
          start = mid + 1;
        } else { // key == arr[mid]
          keyIndex = mid;
          if (findMaxIndex)
            start = mid + 1; // search ahead to find the last index of 'key'
          else
            end = mid - 1; // search behind to find the first index of 'key'
        }
      }
      return keyIndex;
    }
  
    public static int searchMinDiffElement(int[] arr, int key) {
      // TODO: Write your code here
      int start = 0;
      int end = arr.length -1;
      int minDiff = 10000;
      int minDiffResult = 10000;
      while (start <= end) {
        int mid = start + (end-start)/2;
  
        if (arr[mid] == key){
          return arr[mid];
        }
        int diff = Math.abs(arr[mid]-key);
        if (diff < minDiff) {
          minDiff = diff;
          minDiffResult = arr[mid];
        }
  
        if (key < arr[mid]){
          end = mid -1;
        } else {
          start = mid +1;
        } 
      }
      if (minDiffResult != 10000) {
        return minDiffResult;
      }
      return -1;
    }
  
  
    public static void main(String[] args) {
      System.out.println("-------------");
      System.out.println("Binary Search");
      System.out.println(search(new int[] { 1, 2, 3, 4, 5, 6, 7,8,9,10,11,12 }, 9));
      System.out.println("-------------");
      System.out.println("Celing of a number\n Write a function to return the index of the ceiling of the ‘key’. If there isn’t any ceiling return -1.");
      System.out.println(searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
      System.out.println("-------------");
      System.out.println("Next Letter\nGiven an array of lowercase letters sorted in ascending order, find the smallest letter in the given array greater than a given ‘key’.");
      System.out.println(searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
      System.out.println("-------------");
      System.out.println("Number range\nGiven an array of lowercase letters sorted in ascending order, find the smallest letter in the given array greater than a given ‘key’.");
      findRange(new int[] { 4, 6, 6, 6, 9 },6);
       System.out.println("-------------");
      System.out.println("Minimum Difference Element\nGiven an array of numbers sorted in ascending order, find the element in the array that has the minimum difference with the given ‘key’.");
       System.out.println(searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
    }
  }