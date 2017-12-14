package review02;
/*
 * 饿汉式实现单例模式
 */
public class Singleton1 {
	private static Singleton1 instance = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return instance;
    }
}
