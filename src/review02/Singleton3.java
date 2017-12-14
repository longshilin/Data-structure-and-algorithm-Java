package review02;

/**
 * DCL实现单例模式
 */
public class Singleton3 {
    private static Singleton3 instance = null;

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        // 两层判空，第一层是为了避免不必要的同步
        // 第二层是为了在null的情况下创建实例
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }

        }
        return instance;
    }
}
