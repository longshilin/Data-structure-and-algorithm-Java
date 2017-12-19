# 顺序表结构 :green_apple:
顺序表（Sequential List）就是按照顺序存储方式存储的线性表，该线性表的结点按照逻辑次序依次存放在计算机的一组连续的存储单元中。

由于顺序表是一次存放的，只要知道了该顺序表的首地址及每个数据元素所占用的存储长度，那么就很容易计算出任何一个数据元素(即数据结点)的位置。

## 准备数据
准备在顺序表操作中需要用到的变量及数据结构等。
```java
class DATA{							// 定义数据元素结构
	String key;						// 结点的关键字
	String name;
	int age;
}

/*
 * 定义顺序表结构	
 * Sequential storage structure
 */
class SLType{
	static final int MAXLEN=100;
	DATA[] ListData = new DATA[MAXLEN+1];	// 保存顺序表的结构数组
	int ListLen;							// 顺序表已存结点的数量
}
```
## 初始化顺序表
在使用顺序表之前，首先要创建一个空的顺序表，即初始化顺序表。这里，只需设置顺序表的结点数量ListLen为0即可，并没有清空一个顺序表。这样，后面添加的数据元素将从顺序表的第一个位置存储，如果原来已有数据，也会后来的数据被覆盖。
```java
void SLInit(SLType SL){			// 初始化为空表
	SL.ListLen = 0;
}
```
## 计算顺序表长度
计算顺序表长度即计算线性表L中结点的个数。
```java
int SLLength(SLType SL){			// 返回顺序表的元素数量 
	return(SL.ListLen);
}
```
## 插入结点
插入结点就是在线性表L的第i个位置插入一个新的结点，使得其后的结点编号依次加1。
```java
int SLInsert(SLType SL, int n, DATA data){			// 插入结点到顺序表中间的位置

	if(SL.ListLen>=MAXLEN){			// 顺序表已满
		System.out.println("顺序表已满，不能插入结点!\n");
		return 0;
	}
	
	if(n<1 || n>SL.ListLen-1){			// 校验插入位置的合法性
		System.out.println("插入元素序号错误，不能插入元素!\n");
		return 0;
	}
	
	for(int i=SL.ListLen;i>=n;i--){			// 将插入位置n后续的结点都向后移动一位
		SL.ListData[i+1]=SL.ListData[i];
	}
	SL.ListData[n]=data;			// 插入结点
	SL.ListLen++;			// 顺序表节点数量加1
	return 1;			//成功插入，返回1
}		
```
## 追加结点
追加结点并不是一个基本的数据结构运算，其可以看作插入结点的一种特殊形式，相当于在顺序表的末尾新增一个数据结点。由于追加结点的特殊性，其代码实现比插入结点要简单，因为不必进行大量数据的移动。
```java
int SLAdd(SLType SL, DATA data){		// 增加元素到顺序表尾部
	if(SL.ListLen>=MAXLEN){			// 顺序表已满
		System.out.println("顺序表已满，不能再添加结点!\n");
		return 0;
	}
	SL.ListData[++SL.ListLen]=data;
	return 1;
}
```
## 删除结点
删除结点即删除线性表L中的第i个结点，使得其后的所有结点编号依次减1。删除一个结点之后，线性表L的长度将变为n-1。删除结点和插入结点类似，都需要进行大量数据的移动。
```java
int SLDelete(SLType SL, int n){		// 按位删除顺序表的结点
	
	if(n<1 || n>SL.ListLen+1){		// 删除结点序号不正确
		System.out.println("删除结点序号错误，不能删除结点!\n");
		return 0;
	}
	
	for(int i=n;i<SL.ListLen;i++){		// 将插入位置n后续的结点都向前移动一位
		SL.ListData[i]=SL.ListData[i+1];
	}
	SL.ListLen--;
	return 1;
}
```
## 查找结点
查找结点即在线性表L中查找值为x的结点，并返回该结点在线性表L中的位置。如果在线性表中没有找到值为x的结点，则返回一个错误标志。根据值x的类型的不同，查找结点分为按照序号查找结点和按照关键字查找结点两种方法。

1）按照序号查找结点
按照序号查找结点是顺序表查找结点最常用的方法，这是因为顺序表的存储本身就是一个数组。
```java
DATA SLFindByNum(SLType SL, int n){			// 根据序号返回数据元素
	
	if(n<1 || n>SL.ListLen+1){
		System.out.println("结点序号错误，不能返回结点!\n");
		return null;
	}
	return SL.ListData[n];
}
```
2）按照关键字查找结点
关键字可以是数据元素结构中的任意一项
```java
int SLFindByKey(SLType SL, String key){			// 按关键字查询结点
	for (int i = 1; i <= SL.ListLen; i++) {			// 搜寻整个顺序表，返回和key匹配的结点
		if(SL.ListData[i].key.compareTo(key)==0){
			return i;
		}
	}
	return 0;
}
```
## 显示所有结点
打印线性表中的所有数据元素
```java
int SLALL(SLType SL){			// 显示顺序表中的所有结点
	
	for(int i=1; i<=SL.ListLen; i++){
		System.out.printf("(%s,%s,%d)\n", SL.ListData[i].key, SL.ListData[i].name, SL.ListData[i].age);
	}
	return 0;
}
```
## 顺序操作表实例
完成实例源码
[OrderList.java](./OrderList.java)

[*****回到首页*****](/offer-java)