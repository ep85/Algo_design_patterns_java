/*
Description #
BFS is a technique to traverse a tree.
We will use a Queue to keep track of all the nodes of a level before we jump onto the next level.
Used to explore nodes and edges of a graph
Useful for finding shortest path on unweighted graphs
Explores in layers, explores 0 and all its neighbors then does the same to its neighbors.

When to USE
If you need to find the shortest path in an unweighted graph, you should use BFS

Time complexity #
O(V+E)

Space complexity #
The algorithm runs in constant space O(V)

V is the number of vertices and E is the number of edges in the graph
*/
import java.util.*;

class BFS {
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  };
  
  public static List<List<Integer>> zigZag(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (root == null){
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean leftFirst = true;
    while(!queue.isEmpty()){
      int levelSize = queue.size();
      List<Integer> currentLevel = new ArrayList();
      for (int i =0; i <levelSize; i++) {
        TreeNode currentNode = queue.poll();
        if (leftFirst) {
          currentLevel.add(currentNode.val);
        } else {
          currentLevel.add(0, currentNode.val);
        }

        if (currentNode.left != null){
          queue.offer(currentNode.left);
        }
        if (currentNode.right != null){
          queue.offer(currentNode.right);
        }
      }
      leftFirst = !leftFirst;
      result.add(currentLevel);
    }
    return result;
  }

  public static List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (root == null)
      return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      List<Integer> currentLevel = new ArrayList<>(levelSize);
      for (int i = 0; i < levelSize; i++) {
        TreeNode currentNode = queue.poll();
        // add the node to the current level
        currentLevel.add(currentNode.val);
        // insert the children of current node in the queue
        if (currentNode.left != null)
          queue.offer(currentNode.left);
        if (currentNode.right != null)
          queue.offer(currentNode.right);
      }
      result.add(currentLevel);
    }

    return result;
  }

  public static void main(String[] args) {
    // level 1
    TreeNode root = new TreeNode(12);
    // level 2
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    // level 3 
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    // Traverse
    System.out.println("---------------");
    List<List<Integer>> result = traverse(root);
    System.out.println("Level order traversal: " + result);

    // Zig Zag
    System.out.println("---------------");
    List<List<Integer>> result2 = zigZag(root);
    System.out.println("ZigZag Traversal: " + result2);
  }
}