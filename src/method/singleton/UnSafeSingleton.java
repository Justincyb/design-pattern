package method.singleton;

/**
 * @Author Justin
 * @Time 2018/6/26 14:16
 * @Description 简单单例改版 （调用时初始化实例，非线程安全，延迟加载实例）
 * 类加载时不初始化实例，当被调用时再初始化
 * 思路：调用时先判断实例是否为空，不为空就直接使用，为空的话就去初始化
 * 缺陷：当多线程情况下，如果有2个或者多个线程同时通过 == null 判断 则会发生2次初始化，就会出现不同的实例，此时该类就不满足单例要求了
 *
 */
public class UnSafeSingleton {

    // 私有构造，客户端无法自己创建Singleton类实例
    private UnSafeSingleton() {
    }

    static UnSafeSingleton unSafeSingleton;

    // 全局唯一访问入口
    public static UnSafeSingleton getUnSingleton() {
        if (unSafeSingleton == null) {
            unSafeSingleton = new UnSafeSingleton();
        }
        return unSafeSingleton;
    }

    public static void main(String[] args) {
        // 调用端以这种方式去调用，在其他调用类通过new该实例是不允许的
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                UnSafeSingleton singleton = UnSafeSingleton.getUnSingleton();
                System.out.println("t1:" + singleton); // t1:method.singleton.UnSafeSingleton@47a2a66c
            }
        }
        );
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                UnSafeSingleton singleton = UnSafeSingleton.getUnSingleton();
                System.out.println("t2:" + singleton); // t2:method.singleton.UnSafeSingleton@6f9777db
            }
        }
        );
        t1.start();
        t2.start();
    }

}
