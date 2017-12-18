package dataStructure.queue;

import java.util.Scanner;

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
	DATA[] data = new DATA[QUEUELEN];	// 队列顺序结构数组
	int head;		// 队头
	int tail;		// 队尾
	
	SQType SQTypeInit(){		// 队列初始化
		SQType q;
		if((q=new SQType())!=null){		// 申请内存
			q.head = 0;											
			q.tail = 0;
			return q;
		}else{
			return null;
		}
	}
	
	int SQTypeIsEmpty(SQType q){	// 判断队列空
		int temp = 0;
		if(q.head == q.tail)
			temp = 1;
		return temp;
	}
	
	int SQTypeIsFull(SQType q){		// 判断队列满
		int temp = 0;
		if(q.tail==QUEUELEN){
			temp=1;
		}
		return temp;
	}
	
	void SQTypeClear(SQType q){		// 清空队列
		q.head = 0;
		q.tail = 0;
	}
	
	void SQTypeFree(SQType q){		// 释放队列
		if(q != null){
			q = null;
		}
	}
	
	int InSQType(SQType q, DATA data){		// 入队列
		if(q.tail==QUEUELEN){	
			System.out.println("队列已满! 操作失败!\n");
			return 0;
		}
		q.data[q.tail++] = data;		// 顺序入队列，并将队尾指针+1
		return 1;
	}
	
	DATA OutSQType(SQType q){		// 出队列
		if(q.head==q.tail){
			System.out.println("队列已空! 操作失败!\n");
			return null;
		}else{
			return q.data[q.head++];	// 顺序出队列，并将队首指针+1
		}
	}
	
	DATA PeekSQType(SQType q){			//读结点数据
		if(SQTypeIsEmpty(q)==1){
			System.out.println("\n空队列");
			return null;
		}else{
			return q.data[q.head];
		}
	}
	
	int SQTypeLen(SQType q){		// 计算队列长度
		int temp;
		temp=q.tail - q.head;
		return temp;
	}
}

/**
 * 测试用例
 * @author elon@elon33.com
 *
 */
public class Queue {

	public static void main(String[] args) {
		SQType st = new SQType();
		DATA data1;
		Scanner input = new Scanner(System.in);
		SQType stack = st.SQTypeInit();
		System.out.println("入队列操作:");
		System.out.println("输入姓名 年龄进行入队列操作,输入0 结束入队操作:");
		do{
			DATA data = new DATA();
			data.name=input.next();
			data.age=input.nextInt();
			if(data.name.equals("0")){
				break;
			}else{
				st.InSQType(stack, data);
			}
		}while(true);
		
		String temp = "1";
		System.out.println("出队列操作：按任意非0键进行出队列操作：");
		temp = input.next();
		while(!temp.equals("0")){
			data1 = st.OutSQType(stack);
			if(data1 == null){
				break;
			}
			System.out.println("出队列的数据是"+data1.name+","+data1.age);
			temp = input.next();
		}
		System.out.println("测试结束!");
		st.SQTypeFree(stack);													// 释放队列占用的空间
	}
}









