package review04;

public class ReplaceString {
	
	public static void main(String[] args) {
		String str = "we are happy.";
		String rep = replace(str);
		System.out.println(rep);
	}

	/*
	 * 替换函数，将空格替换为%20
	 */
	public static String replace(String s) {
		String str = s;
		str = str.replace(" ", "%20");
		return str;
	}
}
