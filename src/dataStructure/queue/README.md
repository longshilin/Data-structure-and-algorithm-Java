# 队列结构 :tangerine:
## 准备数据
```java
class DATA{
	String name;
	int age;
}

/*
 * 顺序结构队列
 * sequential queue
 */
class SQType{
	static final int QUEUELEN = 15;
	DATA[] data = new DATA[QUEUELEN];		// 队列顺序结构数组
	int head;		// 队头
	int tail;		// 队尾
}
```
在上述代码中，定义了队列结构的最大长度QUEUELEN，队列结构数据元素的类DATA及队列结构的类SQType。在类SQType中，data为数据元素，head为队头的序号，tail为队尾的序号。当head=0时表示队列为空，当tail=QUEUELEN时表示队列已满。

## 初始化队列结构
顺序初始化操作步骤如下：
1. 按符号常量QUEUELEN指定的大小申请一片内存空间，用来保存队列中的数据。
2. 设置head=0和tail=0，表示一个空栈。
```java
SQType SQTypeInit(){	// 队列初始化
	SQType q;
	if((q=new SQType())!=null){		// 申请内存
		q.head = 0;											
		q.tail = 0;
		return q;
	}else{
		return null;
	}
}
```
在上述代码中，首先使用new关键字申请内存，申请成功后设置队头和队尾，然后返回申请内存的首地址。如果申请失败，将返回null。

## 判断空队列
判断空队列即判断一个队列结构是否为空。如果是空队列，则表示该队列结构中没有数据。此时可以进行入队列，但不可以进行出队列。
```java
int SQTypeIsEmpty(SQType q){	// 判断队列空
	int temp = 0;
	if(q.head == q.tail)
		temp = 1;
	return temp;
}
```
在上述代码中，输入参数q是一个指向操作的队列的引用。在程序中，根据队列head是否等于tail，判断队列是否为空。
## 判断满队列
判断满队列即判断一个队列结构是否为满。如果是满队列，则表示该队列结构中没有多余的空间来保存额外数据。此时不可以进行入队列操作，但是可以进行出队列操作。
```java
int SQTypeIsFull(SQType q){		// 判断队列满
	int temp = 0;
	if(q.tail==QUEUELEN){
		temp=1;
	}
	return temp;
}
```
## 清空队列
```java
void SQTypeClear(SQType q){		// 清空队列
	q.head = 0;
	q.tail = 0;
}
```
## 释放空间
```java
void SQTypeFree(SQType q){		// 释放队列
	if(q != null){
		q = null;
	}
}
```
## 入队列
入队列是队列结构的基本操作，主要操作是将数据元素保存到队列结构。入队列的具体步骤如下：
1. 首先判断队列顶tail，如果tail等于QUEUELEN，则表示溢出，进行出错处理；否则执行以下操作。
2. 设置tail=tail+1（队列顶引用加1，指向入队列地址）
3. 将入队列元素保存到tail指向的位置。
```java
int InSQType(SQType q, DATA data){		// 入队列
	if(q.tail==QUEUELEN){
		System.out.println("队列已满! 操作失败!\n");
		return 0;
	}
	q.data[q.tail++] = data;		// 顺序入队列，并将队尾指针+1
	return 1;
}
```
在上述代码中，输入参数q是一个指向操作的队列引用，输入参数data是需要入队列的数据元素。程序中首先判断队列是否溢出，如果溢出则不进行入队列操作，否则修改队列顶引用的值，再将元素入队列。

## 出队列
出队列是队列结构的基本操作，主要操作与入队列相反，其操作是从队列顶弹出一个数据元素。出队列操作的具体步骤如下：
1. 判断队列head，如果head等于tail，则表示为空队列，进行出错处理；否则，执行下面的步骤。
2. 从队列首部取出队头元素（实际是返回队头元素的引用）。
3. 设修改队头head的序号，使其指向后一个元素。
```java
DATA OutSQType(SQType q){		// 出队列
	if(q.head==q.tail){
		System.out.println("队列已空! 操作失败!\n");
		return null;
	}else{
		return q.data[q.head++];	// 顺序出队列，并将队首指针+1
	}
}
```
在上述代码中，输入参数q是一个指向操作的队列的引用。该方法返回值是一个DATA类型的数据，返回值是指向该数据元素的引用。

## 读结点数据
读操作其实是读取队列头的数据。需要注意的是，读结点数据的操作和出队列操作不同。读结点数据的操作仅显示队列顶结点数据的内容，而出队列操作则将队列顶数据弹出，该数据不再存在。
```java
DATA PeekSQType(SQType q){		//读结点数据
	if(SQTypeIsEmpty(q)==1){
		System.out.println("\n空队列");
		return null;
	}else{
		return q.data[q.head];
	}
}
```
上述代码中，输入参数q是一个指向操作的队列的引用。该方法的返回值同样是一个DATA类型的引用数据，返回值是指向数据元素的引用。
## 计算队列长度
计算队列长度即统计该队列中数据结点的个数。计算队列长度的方法比较简单，用队尾序号减去队头序号即可。
```java
int SQTypeLen(SQType q){		// 计算队列长度
	int temp;
	temp=q.tail - q.head;
	return temp;
}
```
在上述代码中，输入参数q是一个指向操作的队列的引用。该方法的返回值便是队列的长度。
## 队列结构操作实例
队列实例操作源码
[Queue.java](./Queue.java)

[*****回到首页*****](https://github.com/yilong0722/Data-structure-and-algorithm-Java/#top)