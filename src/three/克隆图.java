package three;

import java.util.*;

public class 克隆图 {
    public Node cloneGraph(Node node) {
        Map<Node,Node> map = new HashMap<>();
        return dfs(node,map);
    }

    /**
     * 深度遍历
     * @param node
     * @param lookUp
     * @return
     */
    public Node dfs(Node node, Map<Node,Node> lookUp){
        if(node == null) return null;
        if(lookUp.containsKey(node)){
            return lookUp.get(node);
        }
        Node clone = new Node(node.val,new ArrayList<>());
        lookUp.put(node,clone); // 传递的是地址
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor,lookUp));
        }
        return clone;
    }

    /**
     * 广度遍历
     * @param node
     * @return
     */
    public Node bfs(Node node){
        if(node == null) return null;
        Map<Node,Node> lookUp = new HashMap<>();
        Node clone = new Node(node.val, new ArrayList<>());
        lookUp.put(node,clone);
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()){
            Node node1 = queue.poll();
            for (Node neighbor : node1.neighbors) {
                if(!lookUp.containsKey(neighbor)){
                    queue.offer(neighbor);
                    //加入队列到时进行深拷贝
                    lookUp.put(node1,new Node(node1.val,new ArrayList<>()));
                }
                lookUp.get(node1).neighbors.add(lookUp.get(neighbor));
            }
        }
        return clone;
    }

    public Node bfs2(Node node){
        Queue<Node> queue = new ArrayDeque<>();
        Node clone = new Node(node.val,new ArrayList<>());
        queue.offer(node);
        Map<Node,Node> map = new HashMap<>();
        map.put(node,clone);
        while (!queue.isEmpty()){
            Node now = queue.poll();
            for (Node n : now.neighbors) {
                if(!map.containsKey(n)){
                    queue.offer(n);
                    Node clone2 = new Node(n.val,new ArrayList<>());
                    map.put(n,clone2);
                }
                map.get(now).neighbors.add(map.get(n));
            }
        }
        return clone;
    }


}
