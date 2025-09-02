package algo;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class EdgeNodesByLevel {

    // 각 레벨의 양 끝 노드를 출력하는 메서드
    public static void printEdgeNodesByLevel(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // add 함수 대신 사용

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode first = null, last = null;

            /*
            알고리즘 사용해서 풀이해보기 함축적으로, 코드 길이가 줄어들 수 있음.
             */
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (i == 0) first = current;       // 왼쪽 끝 노드
                if (i == size - 1) last = current; // 오른쪽 끝 노드

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }

            // 동일 노드가 양 끝인 경우 한 번만 출력
            if (first == last) {
                System.out.print(first.val + " ");
            } else {
                System.out.print(first.val + " " + last.val + " ");
            }
        }
    }

    // 트리 구성 및 실행
    public static void main(String[] args) {
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(47);
        root.right = new TreeNode(45);

        root.left.left = new TreeNode(11);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(44);
        root.right.right = new TreeNode(23);

        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(1);

        System.out.println("양 끝 노드 출력:");
        printEdgeNodesByLevel(root);
    }
}
