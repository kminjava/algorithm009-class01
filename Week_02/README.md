##第二周学习总结
#set
- 一个不包含重复元素的集合。更普通的说法是，sets不包含一对e1.equals(e2)的e1和e2的元素，最多只有一个null元素。
- set除了继承自Collection的接口，Set还额外实现了特定的方法，在构造方法里面有add，equals和hashCode的方法。
- 特别注意的是，当可变的元素被当做set元素时，当一个set里面的元素是变化的元素时，会影响equals比较，导致结果不明确。
- 一些set接口实现方法时已经限制了他们可以保存的元素。比如，一些实现禁止null元素，一些限制了元素的类型。添加一个类型不符合的元素会抛出一个unchecked exception,典型的是NullPointException或者ClassCastException。想要查询不符合条件的元素也可能抛出异常，或者
简单的返回false；

- 静态工厂方法Set.of和Set.copyof提供一种方便的途径来创建不可更改的sets。通过这些方法来创建的实体有以下的特点：
1. 他们是不可以更改的，元素不能被添加或者移除。在这个Set里面调用任何更改属性的方法会抛出UnsupportedOperationException。然而，如果保存的元素他们自身是可以变的，只可能会引起Set表现不一致或者它的内容发生改变。
2. 不允许null元素，想要创建null元素会导致NullPointException。
3. 如果所有元素是序列化的，那他们也是序列化的。
4. 在创建的时候就拒绝重复元素。重复元素被传递到静态工厂方法会导致IllegalArgumentException;
5. set元素的迭代是不明确的，会发生改变；
6. 他们是基于value的。调用者不应该假设返回的对象的身份。工厂可以自由地创建新的实例或者重用已存在的对象。所以身份敏感的操作是不可靠的，应该避免（equality(==),hashCode,synchronization）

常见方法：
add(E e) 添加特定的元素到set里面，如果不是可选择的操作；
addAll(Collection<? extends E> c)添加所有的在指定Collection里面的元素添加到set里面，如果不是可选择的操作；
clear() 从set里面移除所有元素；
contains(Object o) 如果set里面包含指定的元素，返回true；
remove() 从set里面移除指定的元素；
removeAll() 从set里面移除所有的元素；

#Map
- 通过键值对的形式存储数据，map不能包含重复的keys；每一个key对应一个值。
- 取代Dictionary类，是一个抽象类而不是一个接口；
- Map接口提供三种集合视图，允许一个map的内容被视作一个set的键，集合的值或者是set的key-value；
- 注意：如果变化的对象被当做map的键，会影响equals()的结果。一个map不允许他自己作为一个可以，但是可以把它自身作为一个value。但是此时equals和hashCode方法在这样的map里面不是被明确定义的。
- 一般用途的map实现提供两种标准的构造器，一种是void的，一种是包含一个参数的Map，在创建的时候伴随着一个相同的key-value作为他的元素；
- 常见方法：
- clear（）清空这个map里面的元素；
- containsKey(Object key) 如果包含指定的key,则返回true；
- containsValue(Object value)如果包含指定的value，则返回true；
- get(Object key)返回可以对应的value，如果不存在对应的value，返回null；
- put(K key,V value)  放入指定的key和对应的value进入map；
 
#HashMap
- Hash表是实现了了Map接口。这个实现提供所有map的方法，允许null值和null键。（HashMap基本上就等于Hashtable,除了它是线程不安全的和允许null。）这个类不保证map的排序；特别，不保证排序一直是常数的时间复杂度。
- 这个实现对基本的操作（get和put）提供常数的时间,假设hash函数在桶里面把元素分散的比较好的话。迭代集合视图需要定时的比例，HashMap实例容量（桶的数量）加上它的size（mappings的数量）。这样，很重要的是不要把初始的capacity设置的太高（或者装载因子太低），这样对迭代性能很重要。
- HashMap的实例有两个重要的参数影响它的性能：初始的capacity和装载因子load factor。capacity是在hash表里面桶的数量，初始capacity就是hash表被创建时的capacity。load factor是在它的capacity自动增长之前衡量一个hash表有多满的标尺。当hash表里面的条目数量超过了产品的load factor和目前的capacity，hash表会刷新（就是内部数据结构被重建），这样hash表大概增大两倍桶的数量。
- 通常的规则，默认的装载因子load factor（0.75），在时间和空间的花费上比较均衡。更高的值会减少空间支出，但是会增加查询的花费（参考大多数的HashMap类，包括get和put）。当设置它的初始capacity时，期望的条目数量和load factor应该被考虑，这样可以最少化rehash的操作数量。如果初始的capacity比被load factor划分之后的最大条目数更大的话，rehash就不会发生。
- 如果一些mappings被保存在HashMap里面，比起通过rehash自动增长表的容量，创建时给一个足够大的capacity将允许mappings存储的更高效。注意使用一些具有同样hashCode的键，会明显的降低任何hash表的性能。为了减轻影响，当keys是可比较的，这个类可以在这些keys之间使用比较排序来帮助打破困局。
- 这个实现是不同步的。如果多个线程同时访问一个hashmap，至少其中的一个线程改变了map的结构，必须通过外部来进行同步。（结构的改变包括任何添加、删除一个或者多个的mappings，仅仅改变一个key对应的值，不是结构改变）这是典型的通过同步一些对象来自然的压缩这个map。如果这样的对象不存在，这个map应该被用Collection.synchronizedMap方法来覆盖。这个最好在创建的时候就实现，可以避免额外的非同步操作：
Map m = Collections.synchronizedMap(new HashMap(...));
- 这个集合所有可见的方法都是快速失败的；

##Heap
- 堆排序是一种原地的、时间复杂度为 O(nlogn) 的排序算法
- 堆是一个完全二叉树；
- 堆中每一个节点的值都必须大于等于（或小于等于）其子树中每个节点的值；
- 每个节点的值都大于等于子树中每个节点值的堆，我们叫作“大顶堆”。对于每个节点的值都小于等于子树中每个节点值的堆，我们叫作“小顶堆”。
- 数组中下标为 i 的节点的左子节点，就是下标为 i∗2 的节点，右子节点就是下标为 i∗2+1 的节点，父节点就是下标为 2i​ 的节点。
