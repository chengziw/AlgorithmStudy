package com.leecode.pratice;

import com.leecode.code.Code4_ReverseList;
import com.leecode.dto.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.pratice
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/8/4 20:11
 * @version: 1.0.0
 */
public class QZPratice {


    /**
     * @author wangzicheng
     * @description: 有一个数组ROOTLn]，
     * 数组的元素为Node,
     * ，每个Node包含-
     * 一个字段index：
     * 用来表示自己所在ROOT位置标号；
     * 一个字段Next：用来表示他引用的下一级Node。
     * Next可能指向自身，也可能指向
     * 一个新的孤立的Node (并非ROOT中的Node），也可能指向其他ROOT里的Node,
     * 这样每个ROOT下 面都可能形成一个单项的Node链表，并且可能形成循环链表。
     * 请实现代码删除所有下面的Node没有被其他ROOT下的Node引用的ROOT节点
     * (可以用 ROOT[n] = nul1 设置为删除）
     * @date 2022/8/4 20:41
     */
    public void test1() {
        Node[] root = new Node[]{};
        HashMap<Node, Integer> nodeMap = new HashMap<>();
        Set<Integer> indexSet = new HashSet<>();
        for (int i = 0; i < root.length; i++) {
            Node dummy = root[i];
            while (null != dummy && !nodeMap.containsKey(dummy)) {
                nodeMap.put(dummy, dummy.index);
                indexSet.add(dummy.index);
                dummy = dummy.next;
            }
        }

        for (int i = 0; i < root.length; i++) {
            Node dummy = root[i];
            if (null != dummy && !indexSet.contains(i)){
                root[i] = null;
            }
        }

    }

    public static class Node {
        public int index;
        public Node next;

        public Node(int index) {
            index = index;
        }
    }


    /**
     * @author wangzicheng
     * @description: 假设有一个函数
     * bool testAndset (int &value, int target, int before)
     * (不需要自己实现）
     * 可以线程安全的比较value值是否为before，如果是的话就设置为target,
     * 同时返回true，否则不设置值并且返回false
     * 请其于此函数实现-
     * 一个长度不超过100的线程安全的Queue
     * （包含pop和push，不能使用synchonized/lock/mutex/atomic等关键宇/类，可以使用volatile）
     * @date 2022/8/4 21:23
     */
    public void test2(){

    }

}


