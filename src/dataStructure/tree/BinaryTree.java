package dataStructure.tree;

import java.util.Scanner;

/*
 * 链式二叉树
 * chain binary tree
 */
class CBTType{					// 树结点的类型结构
	String data;				// 结点保存的数据
	CBTType left;				// 指向的左子树
	CBTType right;				// 指向的右子树
}

class ChainBinaryTree{
	static final int MAXLEN = 20;
	static Scanner input = new Scanner(System.in);
	CBTType InitTree(){				// 创建二叉树结点
		CBTType node;
		if((node = new CBTType())!=null){		// 分配内存
			System.out.println("请先输入一个根结点数据：");
			node.data=input.next();
			node.left=null;
			node.right=null;
			if(node!=null){
				return node;
			}else{
				return null;
			}
		}
		return null;
	}
	
	void AddTreeNode(CBTType treeNode){			// 添加结点
		CBTType pnode,parent;
		String data;
		int menusel;
		if((pnode=new CBTType())!=null){		// 分配内存
			System.out.printf("输入需新增的二叉树结点数据：");
			pnode.data=input.next();			// 创建一个新输入的结点
			pnode.left=null;
			pnode.right=null;
			
			System.out.printf("输入该结点的父结点数据：");
			data=input.next();
			
			parent=TreeFindNode(treeNode,data);			// 查找指定数据的结点
			if(parent==null){
				System.out.println("未找到该父结点!");
				pnode=null;
				return;
			}
			
			System.out.println("1.添加该结点到左子树\t2.添加该结点到右子树");
			do{
				menusel = input.nextInt();
				if(menusel==1 || menusel==2){
					if(parent==null){
						System.out.println("不存在父结点，请先设置父结点!");
					}else{
						switch (menusel) {
						case 1:
							if(parent.left!=null){
								System.out.println("左子树不为空!");
							}else{
								parent.left=pnode;
							}
							break;
						case 2:
							if(parent.right!=null){
								System.out.println("右子树结点不为空!");
							}else{
								parent.right=pnode;
							}
							break;
						default:
							System.out.println("无效参数!");
							break;
						}
					}
				}
			}while(menusel!=1 && menusel!=2);
		}
	}
	
	CBTType TreeFindNode(CBTType treeNode, String data){	// 查找结点
		CBTType node;
		if(treeNode == null){
			return null;
		}else{
			if(treeNode.data.equals(data)){
				return treeNode;
			}else if((node = TreeFindNode(treeNode.left,data))!=null){		// 分别向左右子数递归查找
				return node;
			}else if((node = TreeFindNode(treeNode.right,data))!=null){
				return node;
			}else{
				return null;
			}
		}
	}
	
	CBTType TreeLeftNode(CBTType treeNode){		// 获取左子树
		if(treeNode==null){
			return null;
		}
		return treeNode.left;
	}
	
	CBTType TreeRightNode(CBTType treeNode){	// 获取右子树
		if(treeNode==null){
			return null;
		}
		return treeNode.right;
	}
	
	int TreeIsEmpty(CBTType treeNode){			// 判断空树
		if(treeNode == null){
			return 1;
		}else{
			return 0;
		}
	}
	
	int TreeDepth(CBTType treeNode){			// 计算二叉树深度
		if(treeNode==null){						// 递归临界条件
			return 0;							// 对于空树 深度为0
		}
		return Math.max(TreeDepth(treeNode.left), TreeDepth(treeNode.right))+1;	// 递归调用左右子树 计算深度，并回溯深度+1
	}
	
	void ClearTree(CBTType treeNode){			// 清空二叉树
		if(treeNode!=null){
			ClearTree(treeNode.left);			//递归调用 清空左右子树，最后清空父结点
			ClearTree(treeNode.right);
			treeNode = null;
		}
	}
	
	void TreeNodeData(CBTType p){				// 显示结点数据
		if(p==null){
			System.out.println("无效结点!");
		}else{
			System.out.printf("%s",p.data);
		}
	}
	
	void LevelTree(CBTType treeNode){			// 按层遍历
		CBTType node;
		CBTType[] stack = new CBTType[MAXLEN];	// 定义一个顺序队列,保存各结点对象
		int head=0,tail=0;
		if(treeNode!=null){
			tail = (tail+1)%MAXLEN;				// 利用取余 实现循环队列
			stack[tail]=treeNode;				// 将二叉树的根结点入队列
		}
		while(head!=tail){						// 当队列不为空时，循环入队和出队遍历 打印结点	
			head=(head+1)%MAXLEN;
			node = stack[head];					// 队首元素出队列
			TreeNodeData(node);
			if(node.left!=null){				// 遍历下一层时 队首元素的左子树入队列
				tail=(tail+1)%MAXLEN;
				stack[tail]=node.left;
			}
			if(node.right!=null){				// 遍历下一层时 队首元素的右子树入队列
				tail=(tail+1)%MAXLEN;
				stack[tail]=node.right;
			}
		}
	}
		
	void DLRTree(CBTType treeNode){				// 先序遍历
		if(treeNode!=null){
			TreeNodeData(treeNode);				// 先打印结点数据，再遍历左右子树
			DLRTree(treeNode.left);
			DLRTree(treeNode.right);
		}
	}		
	
	void LDRTree(CBTType treeNode){				// 中序遍历
		if(treeNode!=null){
			LDRTree(treeNode.left);				// 先遍历左子树 打印结点数据 再遍历右子树
			TreeNodeData(treeNode);
			LDRTree(treeNode.right);
		}
	}
	
	void LRDTree(CBTType treeNode){				// 后续遍历
		if(treeNode!=null){
			LRDTree(treeNode.left);				// 先遍历左右子树，再打印结点
			LRDTree(treeNode.right);
			TreeNodeData(treeNode);
		}
	}
	
}

/**
 * 测试用例
 * @author elon@elon33.com
 *
 */
public class BinaryTree {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args){
		CBTType root = null;					// root 为指向二叉树根节点的引用
		int menusel=0;
		ChainBinaryTree cbt = new ChainBinaryTree();
		root = cbt.InitTree();
		do{
			System.out.println("请选择菜单选择添加二叉树的结点：");
			System.out.printf("0.退出\t");
			System.out.println("1.添加二叉树的子结点");
			menusel = input.nextInt();
			switch (menusel) {
			case 1:
				cbt.AddTreeNode(root);
				break;
			case 0:
				break;
			default:
				break;
			}
		}while(menusel!=0);
		
		// 遍历
		do{
			System.out.println("请选择菜单遍历二叉树，输入0表示退出：");
			System.out.printf("1.先序遍历DLR\t");
			System.out.printf("2.中序遍历LDR\t");
			System.out.printf("3.后序遍历LRD\t");
			System.out.println("4.按层遍历");
			menusel=input.nextInt();
			switch (menusel) {
			case 0:
				break;
			case 1:
				System.out.printf("\n先序遍历DLR的结果：");
				cbt.DLRTree(root);
				System.out.println();
				break;
			case 2:
				System.out.printf("\n中序遍历LDR的结果：");
				cbt.LDRTree(root);
				System.out.println();
				break;
			case 3:
				System.out.printf("\n后序遍历LRD的结果：");
				cbt.LRDTree(root);
				System.out.println();
				break;
			case 4:
				System.out.printf("\n按层遍历的结果：");
				cbt.LevelTree(root);
				System.out.println();
				break;
			default:
				break;
			}
		}while(menusel!=0);
		System.out.println("\n 二叉树深度为：" + cbt.TreeDepth(root));		// 二叉树深度
		cbt.ClearTree(root);
		root = null;
	}
}



