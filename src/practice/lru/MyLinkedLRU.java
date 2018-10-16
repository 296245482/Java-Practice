package practice.lru;

import java.util.HashMap;

/**
 * 链表的实现思路，Node形成的链表外部再加一层，用于弥补链表的随机查找，链表头部为最近使用的节点
 */
public class MyLinkedLRU {
    /**
     * 缓存容量
     */
    private int maxSize;
    /**
     * 记录头尾
     */
    private Node head, tail;
    /**
     * 外层套一层HashMap，内部使用以Node为节点的链表
     */
    private HashMap<Integer, Node> keyNodeMap;

    public MyLinkedLRU(int maxSize) {
        this.maxSize = maxSize;
        head = new Node(-1, -1);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        this.keyNodeMap = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        Node node = keyNodeMap.get(key);
        if (node != null) {
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        Node node = null;
        if (keyNodeMap.containsKey(key)) {
            node = keyNodeMap.get(key);
            node.value = value;
        } else {
            node = new Node(key, value);
            if (keyNodeMap.size() == maxSize) {
                keyNodeMap.remove(removeTail());
            }
            keyNodeMap.put(key, node);
        }
        moveToHead(node);
    }

    /**
     * 将该节点移动到头部
     * @param node
     */
    private void moveToHead(Node node) {
        if (node.pre != null || node.next != null) {
            node.next.pre = node.pre;
            node.pre.next = node.next;
        }
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    /**
     * 找到尾部节点（最没被使用）的key值
     * @return
     */
    private int removeTail() {
        int lastKey = -1;
        if (tail.pre != head) {
            Node lastNode = tail.pre;
            lastKey = lastNode.key;
            lastNode.pre.next = tail;
            tail.pre = lastNode.pre;
            lastNode = null;
        }
        return lastKey;
    }

    /**
     * 重写toString()，按链表顺序打印
     * @return
     */
    @Override
    public String toString() {
        String res = "";
        Node item = head;
        while (item != tail.pre) {
            res += "[" + item.next.key + ", " + item.next.value + "] ";
            item = item.next;
        }
        return res;
    }

    public static void main(String[] args) {
        MyLinkedLRU lru = new MyLinkedLRU(5);
        lru.set(1, 1);
        lru.set(2, 2);
        lru.set(3, 3);
        lru.set(4, 4);
        lru.set(5, 5);
        lru.set(6, 6);
        lru.set(7, 7);
        lru.set(1, 1);
        lru.set(2, 2);
        lru.set(5, 5);
        lru.set(8, 8);
        lru.get(5);
        System.out.println(lru.toString());
    }
}

/**
 * 链表的节点
 */
class Node {
    int key;
    int value;
    Node pre;
    Node next;

    public Node(int k, int v) {
        key = k;
        value = v;
    }
}