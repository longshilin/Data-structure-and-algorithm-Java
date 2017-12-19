package dataStructure.linkedList;

import java.util.Scanner;

class DATA{
	String key;										// 结点的关键字
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

	CLType CLAddEnd(CLType head, DATA nodeData){
		CLType node,htemp;
		if((node=new CLType())==null){
			System.out.println("申请内存失败!\n");
			return null;
		}else{
			node.nodeData = nodeData;				// 在新申请的结点中保存数据
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

	CLType CLAddFirst(CLType head, DATA nodeData){
		CLType node;
		if((node = new CLType())==null){
			System.out.println("申请内存失败!\n");
			return null;
		}else{
			node.nodeData = nodeData;				// 保存数据
			node.nextNode = head;					// 新加入的头结点的nextNode指向头引用所指的结点
			head = node;							// 头引用指向新节点
			return head;
		}
	}
	
	CLType CLFindNode(CLType head, String key){
		CLType htemp;
		htemp = head;
		while(htemp!=null){							// 循环遍历，寻找关键字匹配的结点
			if(htemp.nodeData.key.compareTo(key)==0){	
				return htemp;
			}
			htemp = htemp.nextNode;
		}
		return null;
	}
	
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
	
	int CLDeleteNode(CLType head, String key){		// 删除关键字结点
		CLType htemp,node;		//循环遍历时，htemp保存当前结点指针，node保存当前结点的前一结点
		htemp = head;
		node = head;
		while(htemp != null){
			if(htemp.nodeData.key.compareTo(key)==0){ // 遍历查找
				node.nextNode = htemp.nextNode; // 上一结点的引用指向当前结点的下一结点，删除当前结点
				return 1;
			}
			node = htemp;						// 保存当前结点
			htemp = htemp.nextNode;					// 当前结点更新指向下一个结点
		}
		return 0;
	}
	
	int CLLength(CLType head){						//返回结点总数
		CLType htemp;
		int len = 0;
		htemp = head;
		while(htemp!=null){							// 循环遍历累计总结点数
			len++;
			htemp=htemp.nextNode;
		}
		return len;
	}
	
	void CLAllNode(CLType head){					// 遍历链表输出所有数据
		CLType htemp;
		htemp = head;
		System.out.printf("\n当前链表共有%d个结点。链表所有数据如下：\n",CLLength(head));
		while(htemp != null){
			System.out.printf("结点(%s,%s,%d)\n",htemp.nodeData.key, htemp.nodeData.name, htemp.nodeData.age);
			htemp = htemp.nextNode;
		}
	}
}

/**
 * 测试用例
 * @author elon@elon33.com
 *
 */
public class LinkedList {
	public static void main(String[] args) {
		CLType node,head=null;
		CLType CL = new CLType();
		String key,findkey;
		Scanner input = new Scanner(System.in);
		System.out.println("链表测试:\n先输入链表中的数据，格式为：关键字 姓名 年龄 (键入0则结束)");
		do{
			DATA nodeData = new DATA();			// 构造新结点
			nodeData.key = input.next();
			if(nodeData.key.equals("0")){
				break;
			}else{
				nodeData.name = input.next();
				nodeData.age = input.nextInt();
				head = CL.CLAddEnd(head, nodeData);
			}
		}while(true);
		CL.CLAllNode(head);			// 遍历所有结点
		
		System.out.printf("\n演示插入结点，输入插入位置的关键字：");
		findkey = input.next();
		System.out.printf("\n输入插入结点的数据(关键字 姓名 年龄)");
	    DATA nodeData = new DATA();			// 构造新结点
	    nodeData.key = input.next();
	    nodeData.name = input.next();
	    nodeData.age = input.nextInt();		
	    head = CL.CLInsertNode(head, findkey, nodeData);
	    CL.CLAllNode(head);
	    
	    System.out.printf("\n演示删除结点，输入要删除的关键字：");
	    
	    key=input.next();
	    int result = CL.CLDeleteNode(head, key);
	    System.out.println(result==1?"删除结点成功":"删除结点失败");
	    CL.CLAllNode(head);
	    
	    System.out.printf("\n演示在链表中查找，输入查找关键字：");
	    
	    key = input.next();
	    node = CL.CLFindNode(head, key);
	    if(node!=null){
	    	nodeData = node.nodeData;
	    	System.out.printf("关键字%s 对应的结点为(%s,%s,%d)\n",key,nodeData.key,nodeData.name,nodeData.age);
	    }else{
	    	System.out.printf("在链表中未查找到关键字为%s的结点!\n",key);
	    }
	}
}
