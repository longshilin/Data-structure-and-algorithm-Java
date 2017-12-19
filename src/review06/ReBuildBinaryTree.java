package review06;

// 二叉树结点定义
class BinaryTreeNode{
	int m_nValue;
	BinaryTreeNode m_pLeft;
	BinaryTreeNode m_pRight;
}

public class ReBuildBinaryTree {

	public static void main(String[] args) {
		int[] preOrder={1,2,4,7,3,5,6,8};
		int[] inOrder={4,7,2,1,5,3,8,6};
		ReBuildBinaryTree rb = new ReBuildBinaryTree();
		BinaryTreeNode node=rb.Construct(preOrder,inOrder);
		rb.PrintTree(node);
	}
	
	BinaryTreeNode Construct(int[] preorder, int[] inorder){
		if(preorder == null || inorder == null || preorder.length<=0 || inorder.length<=0){
			return null;
		}
		return ConstructCore(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
	}

	private BinaryTreeNode ConstructCore(int[] preorder, int startPreorder, int endPreorder, int[] inorder, int startInorder, int endInorder) {

		// 前序遍历序列的第一个数字是根结点
		int rootValue = preorder[startPreorder];
		// 创建该根结点
		BinaryTreeNode root = new BinaryTreeNode();
		root.m_nValue = rootValue;
		root.m_pLeft = null;
		root.m_pRight = null;
		
		if(startPreorder == endPreorder){
			if(startInorder == endInorder && preorder[startPreorder] == inorder[startInorder]){
				return root;
			}else{
				System.out.println("Invalid input.");
				return null;
			}
		}
		
		// 在中序遍历中找到根结点的值
		int rootInorder = startInorder;
		while(rootInorder <= endInorder && inorder[rootInorder] != rootValue){
			rootInorder++;
		}
		if(rootInorder == endInorder && inorder[rootInorder] != rootValue){
			System.out.println("Invalid input.");
			return null;
		}
		int leftLength = rootInorder - startInorder;
		int leftPreorderEnd = startPreorder + leftLength;
		
		// 递归构建子树
		if(leftLength > 0){
			// 构建左子树
			root.m_pLeft = ConstructCore(preorder, startPreorder+1, leftPreorderEnd, inorder, rootInorder+1, endInorder);
		}
		if(leftLength < endPreorder - startPreorder){
			// 构建右子树
			root.m_pRight = ConstructCore(preorder, leftPreorderEnd+1, endPreorder, inorder, rootInorder+1, endInorder);
		}
		return root;
	}
	
	//中序遍历
	private void PrintTree(BinaryTreeNode treeNode){
		if(treeNode!=null){
			PrintTree(treeNode.m_pLeft);
			System.out.print(treeNode.m_nValue + " ");
			PrintTree(treeNode.m_pRight);
		}
	}
}
