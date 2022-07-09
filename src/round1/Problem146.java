package round1;

import java.util.HashMap;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/7/9 11:12
 */

public class Problem146 {
    //定义节点
    static class Node{
        public int key, val;
        public Node next, prev;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    //定义双向链表
    static class DoubleList{
        //头尾虚节点
        private Node head, tail;
        private int size;
        //构造
        public DoubleList(){
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
        public void addLastNode(Node x){
            tail.prev.next = x;
            x.next = tail;
            x.prev = tail.prev;
            tail.next = x;
            size++;
        }

        public void removeNode(Node x){
            x.prev.next = x.next;
            x.next.prev  = x.prev;
            size--;
        }
        //删除第一个节点，即删除最近未使用的那个节点
        public Node removeFirst(){
            //说明链表为空
            if(head.next == tail){
                return null;
            }
            Node first = head.next;
            removeNode(first);
            return first;
        }

        public int size(){
            return size;
        }
    }
    class LRUCache {
        private HashMap<Integer, Node> map;
        private DoubleList list;
        private int cap;

        public LRUCache(int capacity) {
            this.cap = capacity;
            map = new HashMap<>();
            list = new DoubleList();
        }
        public void makeRecently(int key){
            Node node = map.get(key);
            list.removeNode(node);
            list.addLastNode(node);
        }

        public void deleteKey(int key){
            Node node = map.get(key);
            list.removeNode(node);
            map.remove(key);
        }

        public void removeLRUNode(){
            Node node = list.removeFirst();
            int key = node.key;
            map.remove(key);
        }

        public void addRecently(int key, int val){
            Node node = new Node(key, val);
            map.put(key, node);
            list.addLastNode(node);
        }


        public int get(int key) {
            //不包含
            if(!map.containsKey(key)){
                return -1;
            }
            //包含的话删除原来的节点，然后重新插入
            makeRecently(key);
            return map.get(key).val;
        }

        public void put(int key, int value) {
            //当链表中存在时
            if(map.containsKey(key)){
                deleteKey(key);
                addRecently(key, value);
                return;
            }
            //当链表中不存在时
            //当容量最大时，删除
            if(cap == list.size){
                removeLRUNode();
            }
            addRecently(key, value);
        }
    }




}
