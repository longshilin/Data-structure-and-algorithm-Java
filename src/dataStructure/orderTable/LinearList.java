package dataStructure.orderTable;

import java.util.Scanner;

/*
 * 定义数据结构模型
 */
class DATA{
	String key;						// 结点的关键字
	String name;
	int age;
}

/*
 * 定义顺序表结构	
 * Sequential storage structure
 */
class SLType{
	static final int MAXLEN=100;
	DATA[] ListData = new DATA[MAXLEN+1];	// 保存顺序表的结构数组
	int ListLen;						// 顺序表已存结点的数量
	
	void SLInit(SLType SL){	 			// 初始化为空表
		SL.ListLen = 0;
	}
	
	int SLLength(SLType SL){			// 返回顺序表的元素数量 
		return(SL.ListLen);
	}
	
	int SLInsert(SLType SL, int n, DATA data){		// 插入结点到顺序表中间的位置

		if(SL.ListLen>=MAXLEN){			// 顺序表已满
			System.out.println("顺序表已满，不能插入结点!\n");
			return 0;
		}
		
		if(n<1 || n>SL.ListLen-1){		// 校验插入位置的合法性
			System.out.println("插入元素序号错误，不能插入元素!\n");
			return 0;
		}
		
		for(int i=SL.ListLen;i>=n;i--){		// 将插入位置n后续的结点都向后移动一位
			SL.ListData[i+1]=SL.ListData[i];
		}
		SL.ListData[n]=data;			// 插入结点
		SL.ListLen++;					// 顺序表节点数量加1
		return 1;						//成功插入，返回1
	}
	
	int SLAdd(SLType SL, DATA data){	// 增加元素到顺序表尾部
		if(SL.ListLen>=MAXLEN){			// 顺序表已满
			System.out.println("顺序表已满，不能再添加结点!\n");
			return 0;
		}
		SL.ListData[++SL.ListLen]=data;
		return 1;
	}
	
	int SLDelete(SLType SL, int n){		// 按位删除顺序表的结点
		
		if(n<1 || n>SL.ListLen+1){		// 删除结点序号不正确
			System.out.println("删除结点序号错误，不能删除结点!\n");
			return 0;
		}
		
		for(int i=n;i<SL.ListLen;i++){	// 将插入位置n后续的结点都向前移动一位
			SL.ListData[i]=SL.ListData[i+1];
		}
		SL.ListLen--;
		return 1;
	}
	
	DATA SLFindByNum(SLType SL, int n){	// 根据序号返回数据元素
		
		if(n<1 || n>SL.ListLen+1){
			System.out.println("结点序号错误，不能返回结点!\n");
			return null;
		}
		return SL.ListData[n];
	}
	
	int SLFindByKey(SLType SL, String key){		// 按关键字查询结点
		for (int i = 1; i <= SL.ListLen; i++) {	// 搜寻整个顺序表，返回和key匹配的结点
			if(SL.ListData[i].key.compareTo(key)==0){
				return i;
			}
		}
		return 0;
	}
	
	int SLALL(SLType SL){				// 显示顺序表中的所有结点
		
		for(int i=1; i<=SL.ListLen; i++){
			System.out.printf("(%s,%s,%d)\n", SL.ListData[i].key, SL.ListData[i].name, SL.ListData[i].age);
		}
		return 0;
	}
	
}

/**
 * 测试用例
 * @author elon@elon33.com
 *
 */
public class LinearList {
	
	public static void main(String[] args) {
		
		int i;
		SLType SL = new SLType();
		DATA pdata;
		String key;
		System.out.println("顺序表操作演示!");
		
		SL.SLInit(SL);												// 初始化顺序表
		System.out.println("初始化顺序表完成!");
	
		Scanner input = new Scanner(System.in);
		
		do{
			System.out.println("输入添加的结点(学号 姓名 年龄)：");
			DATA data = new DATA();
			data.key = input.next();
			data.name = input.next();
			data.age = input.nextInt();
			
			if(data.age!=0){
				if(SL.SLAdd(SL, data)==0){
					break;
				}
			}else{
				break;
			}
		}while(true);
		System.out.println("\n 顺序表中的结点顺序为：");
		SL.SLALL(SL);
		
		System.out.println("\n 要取出结点的序号：");
		i = input.nextInt();
		pdata = SL.SLFindByNum(SL, i);
		if(pdata!=null){
			System.out.printf("第%d个结点为：(%s,%s,%d)\n",i,pdata.key,pdata.name,pdata.age);
		}
		
		System.out.println("\n要查找结点的关键字：");
		key = input.next();
		i=SL.SLFindByKey(SL, key);
		pdata=SL.SLFindByNum(SL, i);
		if(pdata!=null){
			System.out.printf("第%d个结点为:(%s,%s,%d)\n",i,pdata.key,pdata.name,pdata.age);
		}
	}
}












