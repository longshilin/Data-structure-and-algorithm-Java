package dataStructure.stack;

class DATA{
	String name;
	int age;
}

/*
 * 顺序栈结构
 */
class StackType{				
	static final int MAXLEN = 50;
	DATA[] data = new DATA[MAXLEN+1];								// 构建栈结构
	int top;														// 栈顶
	
	StackType STInit(){												// 栈的初始化
		StackType p;
		if((p=new StackType())!=null){								// 申请栈内存
			p.top = 0;												// 设置栈顶为0
			return p;												// 返回指向栈的引用
		}
		return null;
	}
	
	boolean STIsEmpty(StackType s){									// 判断栈是否为空
		return s.top==0;
	}
	
	boolean STIsFull(StackType s){									// 判断栈是否已满
		return s.top==MAXLEN;
	}
	
	void STClear(StackType s){										// 清空栈
		s.top = 0;
	}
	
	void STFree(StackType s){										// 释放栈所占用的空间
		if(s != null){
			s = null;
		}
	}
	
	int PushST(StackType s, DATA data){								// 入栈
		if(s.top+1 > MAXLEN){
			System.out.println("栈溢出!\n");
			return 0;
		}
		s.data[++s.top] = data;										// 元素入栈，top指针+1
		return 1;
	}
	
	DATA PopST(StackType s){										// 出栈
		if(s.top==0){
			System.out.println("栈为空!\n");
			System.exit(0);
		}
		return s.data[s.top--];										// 元素出栈，top指针-1
	}
	
	DATA PeekST(StackType s){										// 读栈顶数据
		if(s.top==0){
			System.out.println("栈为空!\n");
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

}
