package review02;
/**
 * 懒汉式实现单例模式
 */
public class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {
    }

    // synchronized方法,多线程情况下保证单例对象唯一
    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}