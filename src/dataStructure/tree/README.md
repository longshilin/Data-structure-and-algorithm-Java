# <a id="top"></a>树结构 :strawberry:
## 准备数据
定义二叉树结构的类CBTType。结点的具体数据保持在一个字符串data中，而引用left用来指向左子树结点，引用right用来指向右子树结点。
```java
/*
 * 链式二叉树
 * chain binary tree
 */
class CBTType{					// 树结点的类型结构
	String data;				// 结点保存的数据
	CBTType left;				// 指向的左子树
	CBTType right;				// 指向的右子树
}
```
## 初始化二叉树
在使用顺序表之前，首先要初始化二叉树。在此，在程序中只需将一个结点设置为二叉树的根结点。
```java
CBTType InitTree(){				// 创建二叉树结点
	CBTType node;
	if((node = new CBTType())!=null){		// 分配内存
		System.out.println("请先输入一个根结点数据：");
		node.data=input.next();
		node.left=null;
		node.right=null;
		if(node!=null){
			return node;
		}else{
			return null;
		}
	}
	return null;
}
```
在上述代码中，首先申请内存，然后由用户输入一个根结点数据，并将指向左子树和右子树的引用设置为空，即可完成二叉树的初始化工作。
## 添加结点
添加结点即在二叉树中添加结点数据。添加结点时除了要输入结点数据外，还需要指定其父结点，以及添加的结点是作为左子树还是作为右子树。
```java
void AddTreeNode(CBTType treeNode){			// 添加结点
	CBTType pnode,parent;
	String data;
	int menusel;
	if((pnode=new CBTType())!=null){		// 分配内存
		System.out.printf("输入需新增的二叉树结点数据：");
		pnode.data=input.next();			// 创建一个新输入的结点
		pnode.left=null;
		pnode.right=null;
		
		System.out.printf("输入该结点的父结点数据：");
		data=input.next();
		
		parent=TreeFindNode(treeNode,data);			// 查找指定数据的结点
		if(parent==null){
			System.out.println("未找到该父结点!");
			pnode=null;
			return;
		}
		
		System.out.println("1.添加该结点到左子树\t2.添加该结点到右子树");
		do{
			menusel = input.nextInt();
			if(menusel==1 || menusel==2){
				if(parent==null){
					System.out.println("不存在父结点，请先设置父结点!");
				}else{
					switch (menusel) {
					case 1:
						if(parent.left!=null){
							System.out.println("左子树不为空!");
						}else{
							parent.left=pnode;
						}
						break;
					case 2:
						if(parent.right!=null){
							System.out.println("右子树结点不为空!");
						}else{
							parent.right=pnode;
						}
						break;
					default:
						System.out.println("无效参数!");
						break;
					}
				}
			}
		}while(menusel!=1 && menusel!=2);
	}
}
```
在上述代码中，输入参数treeNode为二叉树的根结点，参数传入根结点是为了方便在代码中进行查找。程序中首先申请内存，然后由用户输入二叉树结点数据，并设置左、右子树为空。接着指定其父结点，最后设置其作为左子树还是作为右子数。
## 查找结点
查找结点即在二叉树中的每一个节点中，逐个比较数据，当找到目标数据时，将返回该数据所在结点的引用。查找结点的代码如下：
```java
CBTType TreeFindNode(CBTType treeNode, String data){	// 查找结点
	CBTType node;
	if(treeNode == null){
		return null;
	}else{
		if(treeNode.data.equals(data)){
			return treeNode;
		}else if((node = TreeFindNode(treeNode.left,data))!=null){		// 分别向左右子数递归查找
			return node;
		}else if((node = TreeFindNode(treeNode.right,data))!=null){
			return node;
		}else{
			return null;
		}
	}
}
```
在上述代码中，输入参数treeNode为待查找的二叉树的根结点，输入参数data为待查找的结点数据。程序中首先判断根结点是否为空，然后分别向左、右子树递归查找。如果当前结点的数据与查找数据相等，则返回当前结点的引用。
## 获取左子树
```java
CBTType TreeLeftNode(CBTType treeNode){		// 获取左子树
	if(treeNode==null){
		return null;
	}
	return treeNode.left;
}
```
## 获取右子树
```java
CBTType TreeRightNode(CBTType treeNode){	// 获取右子树
	if(treeNode==null){
		return null;
	}
	return treeNode.right;
}
```
## 判断空树
```java
int TreeIsEmpty(CBTType treeNode){			// 判断空树
	if(treeNode == null){
		return 1;
	}else{
		return 0;
	}
}
```
## 计算二叉树深度
计算二叉树深度即计算二叉树中结点的最大层数，这里往往需要采用递归算法来实现。
```java
int TreeDepth(CBTType treeNode){			// 计算二叉树深度
	if(treeNode==null){				// 递归临界条件
		return 0;				// 对于空树 深度为0
	}
	return Math.max(TreeDepth(treeNode.left), TreeDepth(treeNode.right))+1;	// 递归调用左右子树 计算深度，并回溯深度+1
}
```
在上述代码中，输入参数treeNode为待计算的二叉树的根节点。程序中首先判断根结点是否为空，然后分别按照递归调用来计算左子树深度和右子树深度，取左右子树深度中较大的值再加上根结点的深度1，作为整个二叉树深度。
## 清空二叉树
清空二叉树即将二叉树变为一个空树，这里也需要实用递归算法来实现。程序中按照递归调用来清空左子树和右子树，并且使用赋值null操作来释放当前结点所占内存，从而完成清空操作。
```java
void ClearTree(CBTType treeNode){			// 清空二叉树
	if(treeNode!=null){
		ClearTree(treeNode.left);			//递归调用 清空左右子树，最后清空父结点
		ClearTree(treeNode.right);
		treeNode = null;
	}
}
```
## 显示结点数据
```java
void TreeNodeData(CBTType p){				// 显示结点数据
	if(p==null){
		System.out.println("无效结点!");
	}else{
		System.out.printf("%s",p.data);
	}
}
```
## 遍历二叉树
可以通过按层遍历方式遍历树结构，也可以通过使用递归来简化遍历算法。
### 按层遍历算法
由于二叉树代表的是一种层次结构，因此，首先按层来遍历整个二叉树。对于二叉树的按层遍历，一般不能使用递归算法来编写代码，而是使用一个循环队列来进行处理。首先将第1层（根结点）进入队列，再将第1层的左右子树（第2层）进入队列....,循环处理，可以逐层遍历。
![](https://i.imgur.com/WZ9m4eD.png)
```java
void LevelTree(CBTType treeNode){			// 按层遍历
	CBTType node;
	CBTType[] stack = new CBTType[MAXLEN];	// 定义一个顺序队列,保存各结点对象
	int head=0,tail=0;
	if(treeNode!=null){
		tail = (tail+1)%MAXLEN;				// 利用取余 实现循环队列
		stack[tail]=treeNode;				// 将二叉树的根结点入队列
	}
	while(head!=tail){						// 当队列不为空时，循环入队和出队遍历 打印结点	
		// 出队列
		head=(head+1)%MAXLEN;
		node = stack[head];					// 队首元素出队列
		// 打印结点
		TreeNodeData(node);
		// 入队列
		if(node.left!=null){				// 遍历下一层时 队首元素的左子树入队列
			tail=(tail+1)%MAXLEN;
			stack[tail]=node.left;
		}
		if(node.right!=null){				// 遍历下一层时 队首元素的右子树入队列
			tail=(tail+1)%MAXLEN;
			stack[tail]=node.right;
		}
	}
}
```
### 先序遍历算法
先序遍历算法即先访问根结点，再按先序遍历左子树，最后按先序遍历右子树。程序中可以按照递归的思路来遍历整个二叉树。在程序中，输入参数为需要遍历的二叉树根结点。
```java
void DLRTree(CBTType treeNode){				// 先序遍历
	if(treeNode!=null){
		TreeNodeData(treeNode);				// 先打印结点数据，再遍历左右子树
		DLRTree(treeNode.left);
		DLRTree(treeNode.right);
	}
}
```
### 中序遍历算法
中序遍历算法即先按中序遍历左子树，再访问根结点，最后按中序遍历右子树。程序中可以按照递归的思路来遍历整个二叉树。在程序中，输入参数为需要遍历的二叉树根结点。
```java
void LDRTree(CBTType treeNode){				// 中序遍历
	if(treeNode!=null){
		LDRTree(treeNode.left);				// 先遍历左子树 打印结点数据 再遍历右子树
		TreeNodeData(treeNode);
		LDRTree(treeNode.right);
	}
}
```
### 后续遍历算法
后序遍历算法即先按后序遍历左子树，再按后序遍历右子树，最后访问根结点。程序中可以按照递归的思路来遍历整个二叉树。在程序中，输入参数为需要遍历的二叉树根结点。
```java
void LRDTree(CBTType treeNode){				// 后续遍历
	if(treeNode!=null){
		LRDTree(treeNode.left);				// 先遍历左右子树，再打印结点
		LRDTree(treeNode.right);
		TreeNodeData(treeNode);
	}
}
```
## 数结构操作实例
[BinaryTree.java](./BinaryTree.java)


[*****回到首页*****](https://github.com/yilong0722/Data-structure-and-algorithm-Java/#top)