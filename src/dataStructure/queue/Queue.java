package dataStructure.queue;

class DATA{
	String name;
	int age;
}

class SQType{
	static final int QUEUELEN = 15;
	DATA[] data = new DATA[QUEUELEN];							// 队列顺序结构数组
	int head;													// 队头
	int tail;													// 队尾
	
	SQType SQTypeInit(){										// 队列初始化
		SQType q;
		if((q=new SQType())!=null){								// 申请内存
			q.head = 0;											
			q.tail = 0;
			return q;
		}else{
			return null;
		}
	}
	
	int SQTypeIsEmpty(SQType q){								// 判断队列空
		int temp = 0;
		if(q.head == q.tail)
			temp = 1;
		return temp;
	}
	
	int SQTypeIsFull(SQType q){									// 判断队列满
		int temp = 0;
		if(q.tail==QUEUELEN){
			temp=1;
		}
		return temp;
	}
	
	void SQTypeClear(SQType q){									// 清空队列
		q.head = 0;
		q.tail = 0;
	}
	
	void SQTypeFree(SQType q){									// 释放队列
		if(q != null){
			q = null;
		}
	}
	
	int InSQType(SQType q, DATA data){							// 入队列
		if(q.tail==QUEUELEN){	
			System.out.println("队列已满! 操作失败!\n");
			return 0;
		}
		q.data[q.tail++] = data;								// 顺序入队列，并将队尾指针+1
		return 1;
	}
	
	DATA OutSQType(SQType q, DATA data){						// 出队列
		if(q.head==0){
			System.out.println("队列已空! 操作失败!\n");
			System.exit(0);
		}else{
			return q.data[q.head++];							// 顺序出队列，并将队首指针+1
		}
		return null;
	}
	
	int SQTypeLen(SQType q){									// 计算队列长度
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

}
