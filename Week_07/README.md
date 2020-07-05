第七周学习总结
##并查集模板
```// Java
class UnionFind { 
	private int count = 0; 
	private int[] parent; 
	public UnionFind(int n) { 
		count = n; 
		parent = new int[n]; 
		for (int i = 0; i < n; i++) { 
			parent[i] = i;
		}
	} 
	public int find(int p) { 
		while (p != parent[p]) { 
			parent[p] = parent[parent[p]]; 
			p = parent[p]; 
		}
		return p; 
	}
	public void union(int p, int q) { 
		int rootP = find(p); 
		int rootQ = find(q); 
		if (rootP == rootQ) return; 
		parent[rootP] = rootQ; 
		count--;
	}
}
```
##Trie树
- 是一种树形结构，典型应用是统计和排序大量的字符串，所以经常被搜索引擎用于文本词频统计
- 最大优点：最大限度减少无谓的字符串比较，查询效率比哈希表高
- 基本性质：
1. 节点本身不存完整单词
2. 从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串
3. 每个节点的所有子节点路径代表的字符都不相同
- 核心思想是空间换时间
- 利用字符串的公共前缀来减低查询时间的开销以达到提高效率的目的

##并查集
- 适用场景
- 组团、配对问题
- Group or not
- 基本操作：
1. makeSet(s):建立一个新的并查集，其中包含S个单元素集合
2. unionSet(x,y):把元素x和元素y所在的集合合并，要求x和y所在的集合不相交，如果相交则不合并
3. find（x）:找到元素x所在的集合的代表

##二叉搜索树
- 二叉搜索树，是指一棵空树或者具有以下性质的二叉树
1. 左子树上的所有节点的值均小于它的根节点的值；
2. 右子树上的所有节点的值均大于它的根节点的值；
3. 依次类推：左右子树也分别为二叉查找树；
- 保证性能的关键
1. 保证二维维度->左右子树节点平衡
2. Balanced

##AVL树
- Balance Factor：它的左子树的高度减去它的右子树的高度（有时相反）。balance factor={-1,0,1}
- 通过旋转操作来进行平衡
- 四种旋转操作
- 不足：节点需要存储额外信息，调整次数频繁

##红黑树
- 是一种近似平衡的二叉搜索树，确保任何一个节点的左右子树的高度差小于两倍
- 每个节点要么是红色，要么是黑色
- 根节点是黑色
- 每个叶节点是黑色的
- 不能有相邻接的两个红色节点
- 从任一节点到每个叶子的所有路径都包含相同数目的黑色节点
