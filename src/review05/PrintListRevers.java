package review05;

import java.util.Stack;

// 链表结构
class ListNode{
	int  m_nkey;
	ListNode m_pNext;
}

public class PrintListRevers {
	
	// 递归遍历: 先递归遍历到链表尾部  再回溯时打印链表结点数据
	void PrintListReversingly_Recursively(ListNode pHead){
		if(pHead != null){
			if(pHead.m_pNext != null){
				PrintListReversingly_Recursively(pHead.m_pNext);
			}
			System.out.println(pHead.m_nkey);
		}
	}
	
	// 栈 遍历链表
	void PrintListReversingly_Iteratively(ListNode pHead){
		Stack nodes = new Stack();

		ListNode pNode = pHead;
		while(pNode != null){	// 链表各结点入栈
			nodes.push(pNode);
			pNode = pNode.m_pNext;
		}
		
		while(!nodes.empty()){	// 各结点出栈
			pNode = (ListNode) nodes.peek();	// 读取栈顶元素
			System.out.println(pNode.m_nkey+"\t");	// 打印读取的元素
			nodes.pop();	// 栈顶元素出栈
		}
	}
	
}
