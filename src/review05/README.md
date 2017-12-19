# <a id="top"></a>从尾到头打印链表

![](https://i.imgur.com/iIhII5F.png)

从尾到头打印链表，意思就是需要先进后出的数据结构，可以通过栈来实现，也可以通过递归来实现（先递归后打印数据）。
### 通过栈来实现数据反序输出
第一个遍历到的结点最后一个输出，而最后一个遍历到的结点第一个输出。这就是典型的“后进先出”，我们可以用栈实现这种顺序。每经过一个结点的时候，把该结点放到一个栈中。当遍历完整个链表后，再从栈顶开始逐个输出节点的值，此时输出的结点的顺序已经反转过来了。这种思路的实现代码如下：
```java
// 栈 遍历链表
void PrintListReversingly_Iteratively(ListNode pHead){
	Stack nodes = new Stack();

	ListNode pNode = pHead;
	while(pNode != null){	// 链表各结点入栈
		nodes.push(pNode);
		pNode = pNode.m_pNext;
	}
	
	while(!nodes.empty()){	// 各结点出栈
		pNode = (ListNode) nodes.peek();	// 读取栈顶元素
		System.out.println(pNode.m_nkey+"\t");	// 打印读取的元素
		nodes.pop();	// 栈顶元素出栈
	}
}
```
### 递归 反序输出
既然想到了用栈来实现这个函数，而递归的本质就是一个栈结构，于是很自然地又想起来用递归来实现。要实现反过来输出链表，我们每次访问到一个结点的时候，先递归输出它后面的结点，再输出该结点自身，这样链表的输出结果就反过来了。基于这样的思路，实现代码如下：
```java
// 递归遍历: 先递归遍历到链表尾部  再回溯时打印链表结点数据
void PrintListReversingly_Recursively(ListNode pHead){
	if(pHead != null){
		if(pHead.m_pNext != null){
			PrintListReversingly_Recursively(pHead.m_pNext);
		}
		System.out.println(pHead.m_nkey);
	}
}
```

完整源代码：[PrintListRevers.java](./PrintListRevers.java)