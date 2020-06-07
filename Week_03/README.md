第三周学习笔记
##递归
- 递归模板

 public void recur(int level,int param){
	
	if(level > MAX_LEVEL){
		// process result
		return;
	}
	// process current logic
	process(level,param);
	//drill down
	recur(level : level + 1,newParam);
	// restore current status
}

1. 抵制人肉递归
2. 找最近重复性
3. 数学归纳法思维

##分治算法
分而治之，也就是将原问题划分成n个规模较小，并且结构与原问题相似的子问题，并且结构与原问题相似的子问题，递归解决这些子问题，然后再合并其结果。

##回溯算法
回溯的思想有点类似枚举搜索，在一组可能的解中，搜索满足期望的解
