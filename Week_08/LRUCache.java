package bit;

import java.util.HashMap;

public class LRUCache {
    private HashMap<Integer,DLinkedNode> map;
    private DoubleList cache;
    private int cap;
    public LRUCache(int capacity){
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }
    public int get(int key){
        if (!map.containsKey(key)) return -1;
        int val = map.get(key).value;
        put(key,val);
        return val;
    }
    public void put(int key,int value){
        DLinkedNode x = new DLinkedNode(key,value);
        if (map.containsKey(key)){
            cache.remove(map.get(key));
            cache.addFirst(x);
            map.put(key,x);
        }else {
            if (cap == cache.size){
                DLinkedNode last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(x);
            map.put(key,x);
        }
    }
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode next;
        DLinkedNode prev;
        public DLinkedNode(int k,int v){
            this.key = k;
            this.value = v;
        }
    }
    class DoubleList{
        private DLinkedNode head,tail;
        private int size;
        public DoubleList(){
            head = new DLinkedNode(0,0);
            tail = new DLinkedNode(0,0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
        //在链表头部添加元素
        public void addFirst(DLinkedNode x){
            x.next = head.next;
            x.prev = head;
            head.next.prev = x;
            head.next = x;
            size++;
        }
        //删除链表中的x节点
        public void remove(DLinkedNode x){
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }
        //删除链表中最后一个节点，并返回该节点
        public DLinkedNode removeLast(){
           if (tail.prev == head) return null;
           DLinkedNode last = tail.prev;
           remove(last);
           return last;
        }
        //返回链表长度
        public int size(){return size;}
    }



    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        int a = cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        int b = cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        int c = cache.get(1);       // returns -1 (not found)
        int d = cache.get(3);       // returns 3
        int e = cache.get(4);       // returns 4
        System.out.printf("%d,%d,%d,%d,%d",a,b,c,d,e);
    }
}
