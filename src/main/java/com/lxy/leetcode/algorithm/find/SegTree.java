package com.lxy.leetcode.algorithm.find;

/**
 * @作者: liuxinyun
 * @日期: 2017/5/26 15:48
 * @描述:
 */
public class SegTree {

    /**
     * 线段树
     */
    transient SegTreeNode[] segTree;

    /**
     * 构造函数
     * @param array：用于构造线段树的数组
     */
    public SegTree(int[] array){
        int length = 2*array.length+1;
        segTree = new SegTreeNode[length];
        build(0, array, 0, array.length-1);
    }

    /**
     * 构建线段树
     * @param root：当前线段树根节点下标
     * @param array：用来构造线段树的数组
     * @param start：数组的起始位置
     * @param end：数组的结束位置
     */
    void build(int root, int[] array, int start, int end){
        if (start == end){
            //叶子节点
            segTree[root] = new SegTreeNode(array[start],0);
        }else {
            int mid = (start+end)>>1;
            //递归构造左子树
            build(2*root+1, array, start, mid);
            //递归构造右子树
            build(2*root+2, array, mid+1, end);
            //根据左右子树节点的值，更新当前根节点的值
            segTree[root] = new SegTreeNode(segTree[2*root+1].getMin()<=segTree[2*root+2].getMin()
                    ?segTree[2*root+1].getMin():segTree[2*root+2].getMin(), 0);
        }
    }

    /**
     * 当前节点标志向下传递
     * @param root
     */
    void pushDown(int root){
        if (segTree[root].getAddMark() != 0){
            //设置左右孩子节点的标志，因为孩子节点可能被多次标记没有向下传递，所以需要把自身的加上
            segTree[2*root+1].addMark = (segTree[2*root+1].getAddMark()+segTree[root].getAddMark());
            segTree[2*root+2].addMark = (segTree[2*root+2].getAddMark()+segTree[root].getAddMark());
            //根据标志设置孩子节点的值
            segTree[2*root+1].min = (segTree[2*root+1].getMin()+segTree[root].getAddMark());
            segTree[2*root+2].min = (segTree[2*root+2].getMin()+segTree[root].getAddMark());
            //传递后，当前节点的标记清零
            segTree[root].addMark = 0;
        }
    }

    /**
     * 查询区间最小值
     * @param root：当前根节点
     * @param nstart：当前节点所表示区间起始位置
     * @param nend：当前节点所表示区间结束位置
     * @param qstart：查询区间起始位置
     * @param qend：查询区间结束位置
     * @return
     */
    public int queryMin(int root, int nstart, int nend, int qstart, int qend){
        //查询区间与当前区间没有交集
        if (qstart>nend || qend<nstart) {
            return -0;
        }
        //当前区间在查询区间内
        if (qstart<=nstart && qend>=nend) {
            return segTree[root].getMin();
        }
        //分别查询左右子树，返回两者中种的较小值
        //延迟标志向下传递
        pushDown(root);
        int mid = (nstart+nend)>>1;
        if (queryMin(2*root+1, nstart, mid, qstart, qend) <=
                queryMin(2*root+2, mid+1, nend, qstart, qend)) {
            return queryMin(2*root+1, nstart, mid, qstart, qend);
        } else {
            return queryMin(2*root+2, mid+1, nend, qstart, qend);
        }
    }

    /**
     * 更新线段树某个区间内节点的值
     * @param root：当前根节点
     * @param nstart：当前节点所表示区间起始位置
     * @param nend：当前节点所表示区间结束位置
     * @param ustart：待更新区间起始位置
     * @param uend：待更新区间结束位置
     * @param addVal：在原值基础上增加的值
     * @return
     */
    public void update(int root, int nstart, int nend, int ustart, int uend, int addVal){
        //待更新区间和当前节点表示区间没有交集
        if (ustart>nend || uend<nstart) {
            return;
        }
        //当前节点表示区间在待更新区间内
        if (ustart<=nstart && uend>= nend){
            segTree[root].addMark = segTree[root].getAddMark()+addVal;
            segTree[root].min = segTree[root].getMin()+addVal;
            return;
        }
        //延迟标记向下传递
        pushDown(root);
        //更新左右孩子节点
        int mid = (nstart+nend)>>1;
        update(2*root+1, nstart, mid, ustart, uend, addVal);
        update(2*root+2, mid, nend, ustart, uend, addVal);
        //根据左右节点的值回溯更新当前节点的值
        segTree[root].min = segTree[2*root+1].getMin()<=segTree[2*root+2].getMin()
                ?segTree[2*root+1].getMin():segTree[2*root+2].getMin();
    }

    static class SegTreeNode{
        int min;//区间最小值
        int addMark;//延时标记，区间各数统一增加值

        public SegTreeNode(int min, int addMark) {
            this.min = min;
            this.addMark = addMark;
        }

        public int getMin() {
            return min;
        }

        public int getAddMark() {
            return addMark;
        }

    }
}
