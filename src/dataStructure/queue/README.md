# 队列结构
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
		DATA[] data = new DATA[QUEUELEN];							// 队列顺序结构数组
		int head;													// 队头
		int tail;													// 队尾
	}
```
在上述代码中，定义了队列结构的最大长度QUEUELEN，队列结构数据元素的类DATA及队列结构的类SQType。在类SQType中，data为数据元素，head为队头的序号，tail为队尾的序号。当head=0时表示队列为空，当tail=QUEUELEN时表示队列已满。
## 初始化队列结构
顺序初始化操作步骤如下：
1. 按符号常量QUEUELEN指定

## 判断空队列

## 判断满队列

## 清空队列

## 释放空间

## 入队列

## 出队列

## 读结点数据

## 计算队列长度

## 队列结构操作实例
队列实例操作源码
[Queue.java](./Queue.java)