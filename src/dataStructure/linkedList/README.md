# 链表结构 :apple:

典型的链表结构，包括如下内容：

1. 数据部分，保存的是该结点的实际数据。
- 地址部分，保存的是下一个结点的地址。
链表结构就是由许多这种结点构成的。在进行链表操作时，首先需定义一个“头引用”变量（一般以head表示），该引用变量指向链表结构的第一个结点，第一个结点的地址部分又指向第二个结点......直到最后一个结点。最后一个结点不再指向其他结点，称为“表尾”，一般在表尾的地址部分放一个空地址null，链表到此结束。

链式存储是最常用的存储方式之一，它不仅可用来表示线性表，而且可用来表示各种非线性的数据结构。链表结构还可以细分为如下几类：
1. 单链表：同上面的链式结构一样，每个结点只包含一个引用。
- 双向链表：若每个结点包含两个引用，一个指向下一个结点，另一个指向上一个结点，这就是双向链表。
- 单循环链表：在单链表中，将终端结点的引用域null改为指向表头结点或开始结点即可构成单循环链表。
- 多重链的循环链表：如果表中结点链在多个环上，将构成多重链的循环链表。

## 准备数据
准备在 链表操作中需要用到的变量及类。
```java
class DATA{
	String key;	// 结点的关键字
	String name;
	int age;
}

/*
 * 定义链表结构
 * Chain-type storage structure
 */
class CLType{
	DATA nodeData = new DATA();
	CLType nextNode;
}
```
上述代码定义了链表数据元素的类DATA及链表的类CLType。结点的具体数据保存在一个类DATA中，而引用nextNode用来指向下一个结点。

其实可以认为该链表是一个班级学生的记录，和上面顺序表所完成的工作类似。
## 追加结点
追加结点即在链表末尾增加一个结点。表尾结点的地址部分原来保存的是空地址null，此时需要将其设置为新增加结点的地址（即原表尾结点指向新增结点），然后将新增结点的地址部分设置为空地址null，即新增节点成为表尾

由于一般情况下，链表只有一个头引用head，要在末尾添加结点就需要从头引用head开始逐个检查，直到找到最后一个结点（即表尾）。
```java
CLType CLAddEnd(CLType head, DATA nodeData){
	CLType node,htemp;
	if((node=new CLType())==null){
		System.out.println("申请内存失败!\n");
		return null;
	}else{
		node.nodeData = nodeData;			// 在新申请的结点中保存数据
		node.nextNode = null;					// 设置结点引用为空，即为表尾
		if(head == null){						// 当head为空时，加入的新结点即为头引用
			head = node;
			return head;
		}
		htemp = head;
		while(htemp.nextNode != null){			// 查找链表的末尾
			htemp = htemp.nextNode;
		}
		htemp.nextNode = node;					// 在链表的末尾插入该结点
		return head;							// 返回指代整个链表的头引用
	}
}
```
在上述代码中，输入参数head为链表头引用，输入参数nodeData为结点保存的数据。程序中，使用new关键字申请保存结点数据的内存空间，如果分配内存成功，node中将保存指向该内存区域的引用。然后，将传入的nodeData保存到申请的内存区域，并设置该结点指向下一结点的引用值为null，最后将该结点链接到链表的末尾。
## 插入头结点
插入头结点即在链表的首部添加结点的过程。
步骤如下：
1. 分配内存空间，保存新增的结点。
- 使新增结点指向头引用head所指向的结点。
- 使头引用head指向新增结点。
```java
CLType CLAddFirst(CLType head, DATA nodeData){
	CLType node;
	if((node = new CLType())==null){
		System.out.println("申请内存失败!\n");
		return null;
	}else{
		node.nodeData = nodeData;			// 保存数据
		node.nextNode = head;					// 新加入的头结点的nextNode指向头引用所指的结点
		head = node;							// 头引用指向新节点
		return head;
	}
}
```
## 查找结点
通过关键字进行查询。
```java
CLType CLFindNode(CLType head, String key){
	CLType htemp;
	htemp = head;
	while(htemp!=null){				// 循环遍历，寻找关键字匹配的结点
		if(htemp.nodeData.key.compareTo(key)==0){	
			return htemp;
		}
		htemp = htemp.nextNode;
	}
	return null;
}
```
在上述代码中，输入参数head为链表的头引用，输入参数key是用来在链表中进行查找结点的关键字。程序中，首先从链表头引用开始，对结点进行逐个比较，直到查找到。找到关键字相同的结点后，返回该结点的引用，方便调用程序处理。
## 插入结点
插入结点就是在链表中间部分的指定位置增加一个结点。插入结点的操作步骤如下：
1. 分配内存空间，保存新增的结点。
- 找到要插入的逻辑位置，也就是那两个结点之间。
- 使新增节点指向原插入位置所指向的结点，并修改插入位置结点的引用，使其指向新增结点。
```java
CLType CLInsertNode(CLType head, String findKey, DATA nodeData){	// 插入关键字结点
	CLType node, nodetemp;
	if((node = new CLType())==null){
		System.out.println("申请内存失败!\n");
		return null;
	}
	node.nodeData = nodeData;
	nodetemp = CLFindNode(head, findKey);		// 获取插入位置关键字所指代的结点
	if(nodetemp == null){
		System.out.println("未找到正确的插入位置!\n");
	}else{							
		node.nextNode = nodetemp.nextNode;		// 新插入的节点的nextNode指向关键字结点的下一结点
		nodetemp.nextNode = node;				// 设置关键结点指向新插入结点
	}
	return head;
}
```
## 删除结点
删除结点就是将链表中的某个结点数据删除。删除结点的操作步骤如下：
1. 查找需要删除的结点。
- 使前一结点指向当前结点的下一结点。
- 删除结点。
```java
int CLDeleteNode(CLType head, String key){		// 删除关键字结点
	CLType htemp,tempnode;
	if(head == null){
		return 0;
	}
	htemp = head;
	tempnode = head;
	while(htemp != null){
		if(htemp.nodeData.key.compareTo(key)==0){ // 遍历查找
			tempnode.nextNode = htemp.nextNode;	// 当前结点的引用指向下一个结点的引用，以此删除htemp结点
			return 1;
		}
		tempnode = htemp;							// 保存当前结点
		htemp = htemp.nextNode;					// 指向下一个结点
	}
	return 0;
}
```
注意，此时被删除结点仍然保存在内存中，接着执行赋值null操作，用来释放被删除节点所占用的内存空间。
## 计算链表长度
统计链表结构中结点的数量，由于链表结构在物理上不是连续存储的，因此，需要遍历整个链表来对结点数量进行累加。
```java
int CLLength(CLType head){			//返回结点总数
	CLType htemp;
	int len = 0;
	htemp = head;
	while(htemp!=null){				// 循环遍历累计总结点数
		len++;
		htemp=htemp.nextNode;
	}
	return len;
}
```
程序中通过while循环来遍历整个链表，从而累加数量并返回。

## 显示所有结点
```java
void CLAllNode(CLType head){			// 遍历链表输出所有数据
	CLType htemp;
	htemp = head;
	System.out.printf("\n当前链表共有%d个结点。链表所有数据如下：\n",CLLength(head));
	while(htemp != null){
		System.out.printf("结点(%s,%s,%d)\n",htemp.nodeData.key, htemp.nodeData.name, htemp.nodeData.age);
		htemp = htemp.nextNode;
	}
}
```
## 链表操作实例
完整实例源码：
[LinkedList.java](./LinkedList.java)