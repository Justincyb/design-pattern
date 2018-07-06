package method.singleton;

/**
 * @Author Justin
 * @Time 2018/6/26 15:26
 * @Description 线程安全的单例模式（UnSafeSingleton改进版）
 * UnSafeSingleton虽然延迟加载了，但是线程不安全，为了解决这个问题，我们引入synchronized进行同步实现安全
 * 缺点：synchronized虽然保证了同步，但是限制了线程访问的效率
 */
public class SafeSingleton {

    // 私有构造，客户端无法自己创建Singleton类实例
    private SafeSingleton() {
    }

    static SafeSingleton safeSingelton;

    // 全局唯一访问入口
    public static synchronized SafeSingleton getSafeSingelton() {
        if (safeSingelton == null) {
            safeSingelton = new SafeSingleton();
        }
        return safeSingelton;
    }

    public static void main(String[] args) {
        // 调用端以这种方式去调用，在其他调用类通过new该实例是不允许的
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                SafeSingleton safeSingelton = SafeSingleton.getSafeSingelton();
                System.out.println("t1:" + safeSingelton);
            }
        }
        );
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                SafeSingleton safeSingelton = SafeSingleton.getSafeSingelton();
                System.out.println("t2:" + safeSingelton);
            }
        }
        );
        t1.start();
        t2.start();
    }

}
