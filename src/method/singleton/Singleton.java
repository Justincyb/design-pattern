package method.singleton;

/**
 * @Author Justin
 * @Time 2018/6/26 13:52
 * @Description 最简单的单例 （加载类时初始化全局唯一实例，线程安全）
 * 需要保证类构造方法是私有的，外部类无法直接创建该类
 * 为了提供该单例对象的使用，需要提供一个全局唯一访问点
 * <p>
 * 该类是线程安全的，不会因为多个线程调用getSingleton而产生多个实例对象
 * 这是因为在JVM加载此类时，对于static属性修饰的对象初始化时，只能由一个线程去执行有且仅一次初始化，这样就做到了全局唯一
 */
public class Singleton {

    // 对于static属性修饰的对象初始化时，只能由一个线程去执行有且仅一次初始化
    private static Singleton singleton = new Singleton();

    // 私有构造，客户端无法自己创建Singleton类实例
    private Singleton() {
    }

    // 全局唯一访问入口
    public static Singleton getSingleton() {
        return singleton;
    }

    public static void main(String[] args) throws Exception {
        // 调用端以这种方式去调用，在其他调用类通过new该实例是不允许的
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                Singleton singleton = Singleton.getSingleton();
                System.out.println("t1:" + singleton);
            }
        }
        );
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                Singleton singleton = Singleton.getSingleton();
                System.out.println("t2:" + singleton);
            }
        });
        t1.start();
        t2.start();
    }

}
