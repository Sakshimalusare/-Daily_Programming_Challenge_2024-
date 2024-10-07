import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return (left.val == right.val)
            && isMirror(left.left, right.right)
            && isMirror(left.right, right.left);
    }

    public TreeNode buildTree(Integer[] nodes) {
        if (nodes.length == 0 || nodes[0] == null) {
            return null;
        }
        
        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode current = queue.poll();
            
            if (nodes[i] != null) {
                current.left = new TreeNode(nodes[i]);
                queue.add(current.left);
            }
            i++;
            
            if (i < nodes.length && nodes[i] != null) {
                current.right = new TreeNode(nodes[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        SymmetricTree treeChecker = new SymmetricTree();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of nodes in the binary tree:");
        int n = scanner.nextInt();
        
        System.out.println("Enter the values of nodes in level order (use 'null' for missing nodes):");
        Integer[] nodes = new Integer[n];
        for (int i = 0; i < n; i++) {
            String value = scanner.next();
            if (value.equals("null")) {
                nodes[i] = null;
            } else {
                nodes[i] = Integer.parseInt(value);
            }
        }

        TreeNode root = treeChecker.buildTree(nodes);
        boolean result = treeChecker.isSymmetric(root);

        System.out.println("Is the tree symmetric? " + result);
        scanner.close();
    }
}
