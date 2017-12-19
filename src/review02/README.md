## <a id="top"></a>为什么使用单例模式
需要确保某个类只要一个对象，或创建一个类需要消耗的资源过多，如访问IO和数据库操作等，这时就需要考虑使用单例模式了。

## 使用单例模式需要注意的关键点
将构造函数访问修饰符设置为private
通过一个静态方法或者枚举返回单例类对象
确保单例类的对象有且只有一个，特别是在多线程环境下
确保单例类对象在反序列化时不会重新构建对象
## 单例模式的几种写法

### 1. 饿汉式
[Singleton1.java](/src/review02/Singleton1.java)
### 2. 懒汉式
getInstance()方法中添加了synchronized关键字，使其变成一个同步方法，目的是为了在多线程环境下保证单例对象唯一。

优点： 只有在使用时才会实例化单例，一定程度上节约了资源。 
缺点： 第一次加载时要立即实例化，反应稍慢。每次调用getInstance()方法都会进行同步，这样会消耗不必要的资源。这种模式一般不建议使用。

[Singleton2.java](/src/review02/Singleton2.java)
### 3. DCL（Double CheckLock）实现单例
优点： 资源利用率高，既能够在需要的时候才初始化实例，又能保证线程安全，同时调用getInstance()方法不进行同步锁，效率高。 
缺点： 第一次加载时稍慢，由于Java内存模型的原因偶尔会失败。在高并发环境下也有一定的缺陷，虽然发生概率很小。 
DCL模式是使用最多的单例模式实现方式，除非代码在并发场景比较复杂或者JDK 6以下版本使用，否则，这种方式基本都能满足需求。

[Singleton3.java](/src/review02/Singleton3.java)
### 4. 静态内部类
第一次加载Singleton类时不会初始化instance，只有在第一次调用getInstance()方法时，虚拟机会加载SingletonHolder类，初始化instance。

这种方式既保证线程安全，单例对象的唯一，也延迟了单例的初始化，推荐使用这种方式来实现单例模式。

[Singleton4.java](/src/review02/Singleton4.java)
### 5. 枚举单例
默认枚举实例的创建是线程安全的，即使反序列化也不会生成新的实例，任何情况下都是一个单例。

优点： 简单！

[Singleton5.java](/src/review02/Singleton5.java)
### 6. 容器实现单例
SingletonManager可以管理多个单例类型，使用时根据key获取对象对应类型的对象。这种方式可以通过统一的接口获取操作，隐藏了具体实现，降低了耦合度。

[Singleton6.java](/src/review02/Singleton6.java)