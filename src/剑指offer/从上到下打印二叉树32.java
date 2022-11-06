package 剑指offer;

import java.util.*;

public class 从上到下打印二叉树32 {
    private Map<Integer, List<Integer>> map = new HashMap<>();
    private int maxLevel = 0;
    public int[] levelOrder(TreeNode root) {
        dfs(root, 1);
        System.out.println(map);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= maxLevel; i++) {
            List<Integer> list1 = map.get(i);
            list.addAll(list1);
        }
        Integer[] integers = list.toArray(new Integer[0]);
        int[] array = Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
        return array;
    }

    public void dfs(TreeNode root, int level){
        if(root == null ) return;
        if(level > maxLevel) maxLevel = level;
        if(map.containsKey(level)){
            List<Integer> list = map.get(level);
            list.add(root.val);
            map.put(level, list);
        }else {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            map.put(level, list);
        }
        level += 1;
        dfs(root.left, level);
        dfs(root.right, level);
    }

    public int[] levelOrder2(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            root = queue.poll();
            list.add(root.val);
            if(root.left != null)queue.offer(root.left);
            if(root.right != null)queue.offer(root.right);
        }
        Integer[] integers = list.toArray(new Integer[0]);
        int[] array = Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
        return array;
    }
}
