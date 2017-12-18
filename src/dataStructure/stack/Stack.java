package dataStructure.stack;

import java.util.Scanner;

class DATA{
	String name;
	int age;
}

/*
 * 顺序栈结构
 */
class StackType{				
	static final int MAXLEN = 50;
	DATA[] data = new DATA[MAXLEN+1];		// 构建栈结构
	int top;						// 栈顶
	
	StackType STInit(){				// 栈的初始化
		StackType p;
		if((p=new StackType())!=null){		// 申请栈内存
			p.top = 0;				// 设置栈顶为0
			return p;				// 返回指向栈的引用
		}
		return null;
	}
	
	boolean STIsEmpty(StackType s){	// 判断栈是否为空
		return s.top==0;
	}
	
	boolean STIsFull(StackType s){	// 判断栈是否已满
		return s.top==MAXLEN;
	}
	
	void STClear(StackType s){		// 清空栈
		s.top = 0;
	}
	
	void STFree(StackType s){		// 释放栈所占用的空间
		if(s != null){
			s = null;
		}
	}
	
	int PushST(StackType s, DATA data){		// 入栈
		if(s.top+1 > MAXLEN){
			System.out.println("栈溢出!\n");
			return 0;
		}
		s.data[++s.top] = data;		// 元素入栈，top指针+1
		return 1;
	}
	
	DATA PopST(StackType s){		// 出栈
		if(s.top==0){
			System.out.println("栈为空!\n");
			return null;
		}
		return s.data[s.top--];		// 元素出栈，top指针-1
	}
	
	DATA PeekST(StackType s){		// 读栈顶数据
		if(s.top==0){
			System.out.println("栈为空! 出栈失败!\n");
			System.exit(0);
		}
		return s.data[top];
	}
}


/**
 * 测试用例
 * @author elon@elon33.com
 *
 */
public class Stack {

	public static void main(String[] args) {
		StackType st = new StackType();
		DATA data1 = new DATA();
		
		StackType stack = st.STInit();			// 初始化栈
		Scanner input = new Scanner(System.in);
		System.out.println("入栈操作：");
		System.out.println("输入姓名 年龄进行入栈操作,输入0 结束入栈操作：");
		do{
			DATA data = new DATA();
			data.name = input.next();
			data.age = input.nextInt();
			if(data.name.equals("0")){
				break;
			}else{
				st.PushST(stack, data);
			}
		}while(true);
		String temp = "1";
		System.out.println("出栈操作：按任意非0键进行出栈操作：");
		temp=input.next();
		while(!temp.equals("0")){
			data1=st.PopST(stack);
			if(data1==null){
				break;
			}
			System.out.println("出栈的数据是："+data1.name+","+data1.age);
			temp=input.next();
		}
		System.out.println("测试结束!");
		st.STFree(st);						// 释放栈所用的空间		
	}
	
}














