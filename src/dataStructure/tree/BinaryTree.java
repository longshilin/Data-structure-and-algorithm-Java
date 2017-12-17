package dataStructure.tree;

/*
 * 链式二叉树
 * chain binary tree
 */
class CBTType{
	String data;
	CBTType left;
	CBTType right;
}

class ChainBinaryTree{
	static final int MAXLEN = 20;
		
	CBTType CreateNode(String data){											// 创建二叉树结点
		CBTType node;
		if((node = new CBTType())==null){
			System.out.println("申请内存失败!");
			System.exit(0);
		}else{
			node.data = data;
			node.left = null;
			node.right = null;
			return node;
		}
		return null;
	}
	
	int AddTreeNode(CBTType rootNode, String data){								// 插入叶子结点
		CBTType node;
		if(rootNode == null){
			System.out.println("不存在父结点! 插入失败!");
			return 0;
		}else{
			node = CreateNode(data);
			if(rootNode.left == null){
				rootNode.left = node;
			}else if(rootNode.right == null){
				rootNode.right = node;
			}else{
				System.out.println("该父结点左右子数已满! 插入失败!");
			}
		}
		return 1;
	}
	
	CBTType TreeFindNode(CBTType treeNode, String data){						// 查找结点
		CBTType node;
		if(treeNode == null){
			return null;
		}else{
			if(treeNode.data.equals(data)){
				return treeNode;
			}else if((node = TreeFindNode(treeNode.left,data))!=null){			// 分别向左右子数递归查找
				return node;
			}else if((node = TreeFindNode(treeNode.right,data))!=null){
				return node;
			}else{
				return null;
			}
		}
	}
	
	CBTType TreeLeftNode(CBTType treeNode){										// 获取左子树
		if(treeNode==null){
			return null;
		}
		return treeNode.left;
	}
	
	CBTType TreeRightNode(CBTType treeNode){									// 获取右子树
		if(treeNode==null){
			return null;
		}
		return treeNode.right;
	}
	
	int TreeIsEmpty(CBTType treeNode){											// 判断空树
		if(treeNode == null){
			return 1;
		}else{
			return 0;
		}
	}
	
	int TreeDepth(CBTType treeNode){											// 计算二叉树深度
		if(treeNode==null){														// 递归临界条件
			return 0;															// 对于空树 深度为0
		}
		return Math.max(TreeDepth(treeNode.left), TreeDepth(treeNode.right))+1;	// 递归调用左右子树 计算深度，并回溯深度+1
	}
	
	void ClearTree(CBTType treeNode){											// 清空二叉树
		if(treeNode!=null){
			ClearTree(treeNode.left);											//递归调用 清空左右子树，最后清空父结点
			ClearTree(treeNode.right);
			treeNode = null;
		}
	}
	
	void TreeNodeData(CBTType p){												// 显示结点数据
		if(p==null){
			System.out.println("无效结点!");
		}else{
			System.out.printf("%s",p.data);
		}
	}
	
	void LevelTree(CBTType treeNode){											// 按层遍历
		CBTType node;
		CBTType[] stack = new CBTType[MAXLEN];									// 定义一个顺序队列,保存各结点对象
		int head=0,tail=0;
		if(treeNode!=null){
			tail = (tail+1)%MAXLEN;												// 利用取余 实现循环队列
			stack[tail]=treeNode;												// 将二叉树的根结点入队列
		}
		while(head!=tail){														// 当队列不为空时，循环入队和出队遍历 打印结点	
			head=(head+1)%MAXLEN;
			node = stack[head];													// 队首元素出队列
			TreeNodeData(node);
			while(head!=tail){
				if(node.left!=null){											// 遍历下一层时 队首元素的左子树入队列
					tail=(tail+1)%MAXLEN;
					stack[tail]=node.left;
				}
				if(node.right!=null){											// 遍历下一层时 队首元素的右子树入队列
					tail=(tail+1)%MAXLEN;
					stack[tail]=node.right;
				}
			}
		}
	}
		
	void DLRTree(CBTType treeNode){												// 先序遍历
		if(treeNode!=null){
			TreeNodeData(treeNode);												// 先打印结点数据，再遍历左右子树
			DLRTree(treeNode.left);
			DLRTree(treeNode.right);
		}
	}		
	
	void LDRTree(CBTType treeNode){												// 中序遍历
		if(treeNode!=null){
			LDRTree(treeNode.left);												// 先遍历左子树 打印结点数据 再遍历右子树
			TreeNodeData(treeNode);
			LDRTree(treeNode.right);
		}
	}
	
	void LRDTree(CBTType treeNode){												// 后续遍历
		if(treeNode!=null){
			LRDTree(treeNode.left);												// 先遍历左右子树，再打印结点
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

}



