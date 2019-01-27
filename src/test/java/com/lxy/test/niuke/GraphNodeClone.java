package com.lxy.test.niuke;

import com.lxy.leetcode.common.UndirectedGraphNode;

import java.util.*;

/**
 * @author liuxinyun
 * @date 2019/1/27 12:17
 */
public class GraphNodeClone {


    /**
     * 图的深度复制
     * 采用BFS遍历所有节点
     *
     * @param node 待复制图
     * @return 复制图
     */
    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        // 查找去重用的map
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        map.put(node, copy);
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            // 当前处理对象的复制品
            UndirectedGraphNode curCopy = map.get(cur);
            List<UndirectedGraphNode> neighbors = cur.neighbors;
            UndirectedGraphNode neighborCopy;
            for (UndirectedGraphNode neighbor : neighbors) {
                if (map.containsKey(neighbor)) {
                    neighborCopy = map.get(neighbor);
                }else {
                    neighborCopy = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, neighborCopy);
                    queue.offer(neighbor);
                }
                curCopy.neighbors.add(neighborCopy);
            }
        }
        return copy;
    }

}
