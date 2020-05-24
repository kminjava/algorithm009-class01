
#第一周学习笔记：

##ArrayList:
- ArrayList实现了List接口，允许空元素，所以比Vector更好，基本取代了Vector，随机访问是常数的时间复杂度O(1)，迭代基本是线性的时间复杂度O(n)，所以很好用并且很快，比LinkedList更占空间。每一个List都有一个容量，当array达到初始容量之后会自动扩容。你也可以自己调用ensureCapacity和trimToSize来控制array的容量，避免重新分配内存或者浪费内存。
- ArrayList不是线程安全的，所以需要多线程控制，例如：List list = Collections.synchronizedList(new ArrayList(...));
- 这个迭代器是“快速失败”的，意思是一些结构化的改变，除了remove()，在迭代器自己调用，引起迭代器抛出ConcurrentModificationException而不是其他不确定性的错误。
- 一个新的ArrayList的默认容量是10。新建ArrayList时，如果capacity<0,则抛出IllegalArgumentException，否则新建capacity大小的数组。
- TrimToSize():缩减这个List的尺寸，使其等于它本身的尺寸，可以节省内存；
- ensureCapacity(int minCapacity):保证这个List对象有足够的容量去存所有的元素；
- size():返回list的尺寸；
- isEmpty():判断这个List是否为空；
- contains():如果元素在ArrayList里面存在，则返回true；
- indexOf():返回这个元素在ArrayList里面第一次出现的下标，如果不存在则返回-1；
- lastIndexOf():返回这个元素在ArrayList里面最后一次出现的下标，如果不存在则返回-1；
- clone():创建这个ArrayList浅拷贝的对象，元素没有被拷贝；
- toArray():返回一个包含ArrayList所有元素的array对象;
- get(int index):根据用户提供的index检索元素；
- set(int index,E e):根据给定的index，设置新的元素，新元素可以是任何类型对象，也可以是null；
- add():添加提供的元素到给定的位置，这个位置之后的所有现有的元素向右移动一位，可以添加null元素；
- remove():移除用户给定下标对应的元素；
- clear()：移除所有元素；
- removeRange():移除所有给定半径范围内的所有元素，如果结束下标等于开始下标，则什么都不做；

##LinkedList:
- LinkedList实现List接口，除了实现List接口的方法之外，这个类提供O(1)的时间复杂度在每个stack,queue,或者是双端队列（deque）中创建第一和最后一个元素的通道。这个List是双链表，通过给定的index从前往后遍历寻找指定的元素。
- LinkedList不是线程安全的，所以你需要多线程操作，可以考虑使用List list = Collections.synchronizedList(newLinkedList());

##SkipList:
- 链表加多级索引的结构，就是跳表。是一种各方面性能都比较优秀的动态数据结构，可以支持快速的插入、删除、查找操作，写起来也不复杂，甚至可以替代红黑树（Red-black tree）。
- 是用空间换时间的思想来实现的，添加一层索引之后，查找一个结点需要遍历的结点个数减少了，也就是说查找效率提高了。
- 在跳表中查询任意数据的时间复杂度就是 O(logn)，跳表的空间复杂度是 O(n)，支持动态的插入、删除操作，而且插入、删除操作的时间复杂度也是 O(logn)

##Queue:
- 一个设计用来存储优先处理元素的集合。除了基本的Collection操作外，queue提供额外的插入、提取、和检查的操作。所有这些方法以两种形式存在：一种是当操作失败时抛出异常，另外一种是根据不同的操作返回一个特殊的值（null或者false）。后来的插入操作是经过容量受限制而特殊设计的Queue实现，在多数情况下，插入操作不会失败。
- Queue典型的，但不是必须的，元素采用先进先出的排序方式。这些中例外的是优先队列(priority queue)，它可以让元素按照给定的comparator，或者元素的自然排序和后进先出（或者是stack）的队列，不管排序是怎么使用的，始终让元素后进先出。当调用remove()或者poll()方法时，Queue的头部元素将会被移除掉。在一个先进先出的队列中，所有先插入的元素都会被添加到queue的尾部。其他类型的队列可以使用不同的放置规则。每一个Queue接口在实现的时候必须制定它的排序属性。
- 尽可能使用offer()方法插入元素，失败返回false。这是跟add()方法不同的，add()方法添加元素失败之后仅仅抛出一个未检查异常。offer()是用来当插入失败是正常的而不是抛出异常的情况。
- remove()和poll()方法移除并返回队列的头部元素。具体的是哪一个元素被删除，要看队列实现的排序策略。remove()和poll()唯一的不同之处在于当queue是空的时候：remove()抛出异常，poll()返回null。
- element()和peek()方法返回但是不会移除队列头部的元素。
- Queue接口没有定义阻塞队列方法，跟并发处理程序是一样的。这些方法等元素出现或则空间变得可用时，被定义在java.util.concurrent.BlockQueue接口，是对Queue接口的扩展。
- Queue实现，通常是不允许插入空元素的，尽管一些实现，比如LinkedList，并不禁止插入null元素，但null元素不应该插入到Queue中。当调用poll()方法而队列中不存在该元素的时候，null可以被用作一个特殊的返回值。
- Queue通常不定义基于元素的equals方法和hashCode方法，但是继承了基于Object的方法。因为当相同的元素采取不同的排序属性时，基于元素的相等性在队列并不是确定的。

##priorityQueue:
- 一个无限制的priority queue是基于priority heap的。priority queue的元素是按照他们的自然属性或者是通过在queue创建时给定的Comparator来排序的，这取决于选用哪一个构造器。
- priority queue不允许null元素。priority queue按照自然排序的时候也不允许插入没有比较过的对象（这样会抛出ClassCastException）。
- 这个队列的头部元素是经过特殊排序的最新的元素。如果有多个元素和最新的值绑定，头部是这些元素中的一个--绑定会被终止。队列检索操作，poll，remove，peek和element，都是取队列的头部元素。
- priority queue是不受控制的，但是有一个内部的容量管理一个数组的长度用来存储队列中的元素。至少是跟queue的长度一样大。当元素被添加到priority queue里面时，它的容量是自动增长的。增长的策略是没有规定的。
- 这个类和它的迭代器实现了所有的Collection和Iterator可操作的方法接口。迭代器在iterator()里面提供迭代方法以及拆分器在spliterator()提供拆分方法，不保证以一些特殊的排序移动priority queue里面的元素。如果你需要排序的移动的话，可以考虑使用Arrays.sort(pq.toArray())。
- 注意这个实现不是线程安全的。当改变队列的时候，不应该在PriorityQueue用多线程。取而代之的是，使用线程安全的PriorityBlockingQueue类。
- 这个实现方法提供的处理入队和出队的方法是O(log(n))的时间复杂度的（offer,poll,remove以及add）；remove和contains是线性的时间。检索是常数时间（peek,element,size）。

##Stack
- 后进者先出，先进者后出，这就是典型的“栈”结构；
- 从栈的操作特性上来看，栈是一种“操作受限”的线性表，只允许在一端插入和删除数据；
- 当某个数据集合只涉及在一端插入和删除数据，并且满足后进先出、先进后出的特性，我们就应该首选“栈”这种数据结构；
- 栈既可以用数组来实现，也可以用链表来实现。用数组实现的栈，我们叫作顺序栈，用链表实现的栈，我们叫作链式栈；
- 不管是顺序栈还是链式栈，入栈、出栈只涉及栈顶个别数据的操作，所以时间复杂度都是 O(1)；
- push() 添加一个元素到stack的顶部，这个跟blockquote的addElement(item)是一样的；
- pop() 返回stack的顶部元素并且移除；
- peek() 查看stack的顶部元素，不删除元素；
- empty() 测试stack是否是空的；


