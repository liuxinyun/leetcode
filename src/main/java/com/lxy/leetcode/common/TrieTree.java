package com.lxy.leetcode.common;

/**
 * 字典树
 *
 * @author liuxinyun
 * @date 2019/2/23 10:52
 */
public class TrieTree {

    private TrieNode root;//字典树的根

    public TrieTree() {
        root = new TrieNode();
    }

    private class TrieNode {
        // 有多少单词通过这个节点,即由根至该节点组成的字符串模式出现的次数
        private int num;
        // 所有的儿子节点
        private TrieNode[] son;//所有的儿子节点
        // 是不是最后一个节点
        private boolean isEnd;
        // 节点的值
        private char val;

        TrieNode() {
            num = 1;
            son = new TrieNode[26];
            isEnd = false;
        }
    }

    //建立字典树，在字典树中插入一个单词
    public void insert(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        TrieNode node = root;
        char[] letters = str.toCharArray();
        for (char letter : letters) {
            int pos = letter - 'a';
            if (node.son[pos] == null) {
                node.son[pos] = new TrieNode();
                node.son[pos].val = letter;
            } else {
                node.son[pos].num++;
            }
            node = node.son[pos];
        }
        node.isEnd = true;
    }

    //计算单词前缀的数量
    public int countPrefix(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return -1;
        }
        TrieNode node = root;
        char[] letters = prefix.toCharArray();
        for (char letter : letters) {
            int pos = letter - 'a';
            if (node.son[pos] == null) {
                return 0;
            } else {
                node = node.son[pos];
            }
        }
        return node.num;
    }

    //打印指定前缀的单词
    public String hasPrefix(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return null;
        }
        TrieNode node = root;
        char[] letters = prefix.toCharArray();
        for (char letter : letters) {
            int pos = letter - 'a';
            if (node.son[pos] == null) {
                return null;
            } else {
                node = node.son[pos];
            }
        }
        preTraverse(node, prefix);
        return null;
    }

    // 遍历经过此节点的单词.
    public void preTraverse(TrieNode node, String prefix) {
        if (!node.isEnd) {
            for (TrieNode child : node.son) {
                if (child != null) {
                    preTraverse(child, prefix + child.val);
                }
            }
            return;
        }
        System.out.println(prefix);
    }


    //在字典树中查找一个完全匹配的单词.
    public boolean has(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        TrieNode node = root;
        char[] letters = str.toCharArray();
        for (char letter : letters) {
            int pos = letter - 'a';
            if (node.son[pos] == null) {
                return false;
            }
            node = node.son[pos];
        }
        return node.isEnd;
    }

    //前序遍历字典树.
    public void preTraverse(TrieNode node) {
        if (node != null) {
            System.out.print(node.val + "-");
            for (TrieNode child : node.son) {
                preTraverse(child);
            }
        }
    }

    public TrieNode getRoot() {
        return this.root;
    }

    public static void main(String[] args) {
        TrieTree tree = new TrieTree();
        String[] strs = {"banana", "band", "bee", "absolute", "acm",};
        for (String str : strs) {
            tree.insert(str);
        }
        System.out.println(tree.has("abc"));
        tree.preTraverse(tree.getRoot());
        System.out.println();
        String[] prefix = {"ba", "b", "band", "abc",};
        for (String pre : prefix) {
            int num = tree.countPrefix(pre);
            System.out.println(pre + "" + num);
        }
    }

}
