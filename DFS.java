/*
Description #
This pattern is based on the Depth First Search (DFS) technique to traverse a tree.
We will be using recursion (or we can also use a stack for the iterative approach) to keep track of all the previous (parent) nodes while traversing. This also means that the space complexity of the algorithm will be O(H), where ‘H’ is the maximum height of the tree.

If you need a specific traversal order(like in topological sort), you should use DFS.

Time complexity #
O(V + E) where V is the number of vertices and E is the number of edges in the graph.

Space complexity #
O(H) H where ‘H’ is the maximum height of the tree.
*/

import java.util.*;

class DFS {
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  };
  public static boolean hasPath(TreeNode root, int sum) {
    if (root == null)
      return false;

    // if the current node is a leaf and its value is equal to the sum, we've found a path
    if (root.val == sum && root.left == null && root.right == null)
      return true;

    // recursively call to traverse the left and right sub-tree
    // return true if any of the two recursive call return true
    return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
  }

   public static List<List<Integer>> findPaths(TreeNode root, int sum) {
    List<List<Integer>> allPaths = new ArrayList<>();
    List<Integer> currentPath = new ArrayList<Integer>();
    findPathsRecursive(root, sum, currentPath, allPaths);
    return allPaths;
  }

  public static void findPathsRecursive(
    TreeNode currentNode, 
    int sum, 
    List<Integer> currentPath, 
    List<List<Integer>> allPaths) {
      if (currentNode == null) {
        return;
      }

      currentPath.add(currentNode.val);

      if (currentNode.val == sum && currentNode.left == null && currentNode.right == null){
        allPaths.add(new ArrayList<Integer>(currentPath));
      } else {
        findPathsRecursive(currentNode.left, sum-currentNode.val,currentPath, allPaths);
        findPathsRecursive(currentNode.right, sum-currentNode.val,currentPath, allPaths);
      }
      // remove the current node from the path to backtrack, 
      // we need to remove the current node while we are going up the recursive call stack.
      currentPath.remove(currentPath.size() - 1);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);

    System.out.println("---------------");
    System.out.println("DFS");
    System.out.println("---------------");
    System.out.println("Binary Tree Path Sum\nGiven a binary tree and a number ‘S’, find if the tree has a path from root-to-leaf such that the sum of all the node values of that path equals ‘S’.");
    System.out.println("Tree has path: " + hasPath(root, 23));
    System.out.println("Tree has path: " + hasPath(root, 16));
    System.out.println("Runs at O(N) and space at O(N)");

    System.out.println("---------------");
     TreeNode root2 = new TreeNode(12);
    root2.left = new TreeNode(7);
    root2.right = new TreeNode(1);
    root2.left.left = new TreeNode(4);
    root2.right.left = new TreeNode(10);
    root2.right.right = new TreeNode(5);
    System.out.println("All Paths for a sum\nGiven a binary tree and a number ‘S’, find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.");
    int sum = 23;
    List<List<Integer>> result = findPaths(root2, sum);
    System.out.println("Tree paths with sum " + sum + ": " + result);
    System.out.println("Runs at O(N^2) and space at O(N)");


  }
  
}