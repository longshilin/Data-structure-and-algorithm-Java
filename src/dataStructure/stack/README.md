# 顺序栈结构 :cherries:

## 准备数据
```java
class DATA{
	String name;
	int age;
}

/*
 * 顺序栈结构
 */
class StackType{				
	static final int MAXLEN = 50;
	DATA[] data = new DATA[MAXLEN+1];	// 构建栈结构
	int top;		// 栈顶
}
```
在上述代码中，定义了栈结构的最大长度MAXLEN，栈结构数据元素的类DATA及栈结构的类StackType。在类StackType中，data为数据元素，top为栈顶的序号。当top=0时表示栈为空，当top=SIZE时表示栈满。

Java语言中数组都是从下标0开始的。在这里，为了讲述和理解的方便，从下标1开始记录数据结点，下标0的位置不使用。
## 初始化栈结构
顺序栈的初始化操作步骤：
1. 按符号常量SIZE指定的大小申请一片内存空间，用来保存栈中的数据。
- 设置栈顶引用的值为0，表示一个空栈。
```java
StackType STInit(){		// 栈的初始化
	StackType p;
	if((p=new StackType())!=null){		// 申请栈内存
		p.top = 0;		// 设置栈顶为0
		return p;		// 返回指向栈的引用
	}
	return null;
}
```
## 判断空栈
判断空栈即判断一个栈结构是否为空。如果是空栈，则表示该结构中没有数据。此时可以进行入栈操作，但不可以进行出栈操作。
```java
boolean STIsEmpty(StackType s){		// 判断栈是否为空
	return s.top==0;
}
```
## 判断满栈
如果是满栈，则表示该结构中没有多余的空间来保存额外数据。此时不可以进行入栈操作，但是可以进行出栈操作。
```java
boolean STIsFull(StackType s){		// 判断栈是否已满
	return s.top==MAXLEN;
}
```
## 清空栈
清空栈即清除栈中的所有数据，在程序中简单地将栈顶引用top设置为0，表示执行清空栈操作。
```java
void STClear(StackType s){		// 清空栈
	s.top = 0;
}
```
## 释放空间
释放空间即释放栈结构所占用的内存单元，程序中，直接赋值null操作释放所分配的内存。一般在不需要使用栈结构的时候使用，特别是程序结束时。
```java
void STFree(StackType s){		// 释放栈所占用的空间
	if(s != null){
		s = null;
	}
}
```
## 入栈
入栈（Push）是栈结构的基本操作，主要操作是将数据元素保存到栈结构。
1. 首先判断栈顶top，如果top大于等于SIZE，则表示溢出，进行出错处理；否则执行以下操作。
2. 设置top=top+1（栈顶引用加1，指向入栈地址）。
- 将入栈元素保存到top指向的位置。
```java
int PushST(StackType s, DATA data){		// 入栈
	if(s.top+1 > MAXLEN){
		System.out.println("栈溢出!\n");
		return 0;
	}
	s.data[++s.top] = data;		// 元素入栈，top指针+1
	return 1;
}
```
## 出栈
出栈（Pop）是栈结构的基本操作，主要操作与入栈相反，其操作是栈顶弹出一个数据元素。出栈操作的基本步骤如下：
1. 判断栈顶top，如果top等于0，则表示为空栈，进行出错处理；否则，执行下面的步骤。
2. 将栈顶引用top所指位置的元素返回。
3. 设置top=top-1，也就是使栈顶引用减1，指向栈的下一个元素，原来栈顶元素被弹出。
```java
DATA PopST(StackType s){		// 出栈
	if(s.top==0){
		System.out.println("栈为空!\n");
		return null;
	}
	return s.data[s.top--];		// 元素出栈，top指针-1
}
```
## 读结点数据
读结点数据即读取栈结构中结点的数据。由于栈结构只能在一段进行操作，因此这里的读操作其实就是读取栈顶的数据。

需要注意的是，读结点数据的操作和出栈的操作不同。读结点数据的操作仅显示栈顶结点数据的内容，而出栈操作则是将栈顶数据弹出，该数据不再存在了。
```java
DATA PeekST(StackType s){		// 读栈顶数据
	if(s.top==0){
		System.out.println("栈为空! 出栈失败!\n");
		System.exit(0);
	}
	return s.data[top];
}
```
## 栈结构操作实例
操作实例源码
[Stack.java](./Stack.java)