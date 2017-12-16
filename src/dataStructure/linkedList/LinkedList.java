package dataStructure.linkedList;


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
		CLType htemp,tempnode;
		if(head == null){
			return 0;
		}
		htemp = head;
		tempnode = head;
		while(htemp.nextNode != null){
			if(htemp.nodeData.key.compareTo(key)==0){ // 遍历查找
				tempnode.nextNode = htemp.nextNode;	// 当前结点的引用指向下一个结点的引用，以此删除htemp结点
				return 1;
			}
			tempnode = htemp;						// 保存当前结点
			htemp = htemp.nextNode;					// 指向下一个结点
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
		System.out.printf("当前链表共有%d个结点。链表所有数据如下：\n",CLLength(head));
		while(htemp.nextNode != null){
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

}
