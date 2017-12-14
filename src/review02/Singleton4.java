package review02;

/**
 * 静态内部类实现单例模式
 */
public class Singleton4 {
    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        return SingletonHolder.instance;
    }

    /**
     * 静态内部类
     */
    private static class SingletonHolder {
        private static Singleton4 instance = new Singleton4();
    }
}
