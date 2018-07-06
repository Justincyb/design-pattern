package method.singleton;

/**
 * @Author Justin
 * @Time 2018/6/27 09:19
 * @Description 线程安全的延迟加载（懒加载）
 */
public class SafeLazyLoadSingleton {

    //私有构造
    private SafeLazyLoadSingleton() {
    }

    // 懒加载类
    private static class LazyLoader {
        //
        private static SafeLazyLoadSingleton safeLazyLoadSingleton = new SafeLazyLoadSingleton();
    }

    // 全局唯一入口
    public static SafeLazyLoadSingleton getSafeLazyLoadSingleton() {

        return LazyLoader.safeLazyLoadSingleton;
    }

    public static void main(String[] args) {
        // 客户端调用
        Thread t1 = new Thread(() -> {
            SafeLazyLoadSingleton safeLazyLoadSingleton = SafeLazyLoadSingleton.getSafeLazyLoadSingleton();
            System.out.println("t1:" + safeLazyLoadSingleton);
        }
        );
        Thread t2 = new Thread(() -> {
            SafeLazyLoadSingleton safeLazyLoadSingleton = SafeLazyLoadSingleton.getSafeLazyLoadSingleton();
            System.out.println("t2:" + safeLazyLoadSingleton);
        }
        );

        t1.start();
        t2.start();
    }

}
