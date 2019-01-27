package com.lxy.leetcode.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxinyun
 * @date 2019/1/27 12:13
 */
public class UndirectedGraphNode {

    public int label;

    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int label) {
        this.label = label;
        this.neighbors = new ArrayList<>();
    }
}
