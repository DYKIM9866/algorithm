package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 트리 순회
 * 실버 1
 */
class TreeNode{
    char value;
    TreeNode left;
    TreeNode right;

    public TreeNode(char value) {
        this.value = value;
        left = null;
        right = null;
    }
}

public class No1991 {
    static Map<Character, TreeNode> nodes = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] node = br.readLine().split(" ");

            char root = node[0].charAt(0);
            char left = node[1].charAt(0);
            char right = node[2].charAt(0);

            if(!nodes.containsKey(root)){
                nodes.put(root, new TreeNode(root));
            }
            TreeNode rootNode = nodes.get(root);
            if(left != '.'){
                if(!nodes.containsKey(left)){
                    nodes.put(left, new TreeNode(left));
                }
                rootNode.left = nodes.get(left);
            }
            if(right != '.'){
                if(!nodes.containsKey(right)){
                    nodes.put(right, new TreeNode(right));
                }
                rootNode.right = nodes.get(right);
            }
        }

        TreeNode root = nodes.get('A');
        preorderTraverse(root);
        System.out.println();
        inorderTraverse(root);
        System.out.println();
        postorderTraverse(root);
    }

    private static void preorderTraverse(TreeNode root) {
        if(root == null){
            return;
        }
        System.out.print(root.value);
        preorderTraverse(root.left);
        preorderTraverse(root.right);
    }

    private static void inorderTraverse(TreeNode root) {
        if(root == null){
            return;
        }
        inorderTraverse(root.left);
        System.out.print(root.value);
        inorderTraverse(root.right);
    }


    private static void postorderTraverse(TreeNode root) {
        if(root == null){
            return;
        }
        postorderTraverse(root.left);
        postorderTraverse(root.right);
        System.out.print(root.value);
    }
}
