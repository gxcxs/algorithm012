<h1>HashMap学习小总结</h1>
<h1>关于hash</h1>
<h2>hash算法</h2>
 static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
 <h2>hash冲突方案</h2>
解决哈希冲突的几种方案：
1、开放定址法：发生冲突，继续寻找下一块未被占用的存储地址；
2、再散列函数法；
3、链地址法（HashMap就是采用了链地址法，也就是数组+链表的方式）；
  <h2>底层结构jdk8</h2>
  hashMap底层结构：数组+链表，Node中保存着HashMap的key和value；next对象是当出现hash碰撞时，用于存储原该Node链表中对象值；

  数组：
  transient Node<K,V>[] table = (Node<K,V>[])new Node[newCap];
  
  链表：
   static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
