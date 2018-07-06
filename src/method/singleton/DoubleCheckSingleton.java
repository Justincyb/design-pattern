package method.singleton;

/**
 * @Author Justin
 * @Time 2018/6/26 16:17
 * @Description 双重检查单例（线程安全，效率高 SafeSingelton升级版）
 * 双重检查 在synchronized基础上做的改进,我们没必要对整个方法同步，其实我们需要同步的仅仅是创建实例这个动作
 */
public class DoubleCheckSingleton {

    // 私有构造，客户端无法自己创建Singleton类实例
    private DoubleCheckSingleton() {
    }

    private volatile static DoubleCheckSingleton doubleCheckSingelton;

    // 全局唯一访问入口
    public static DoubleCheckSingleton getDoubleCheckSingelton() {
        if (doubleCheckSingelton == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (doubleCheckSingelton == null) {
                    doubleCheckSingelton = new DoubleCheckSingleton();
                }
            }
        }
        return doubleCheckSingelton;
    }

    public static void main(String[] args) {
        // 调用端以这种方式去调用，在其他调用类通过new该实例是不允许的
        long st = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            DoubleCheckSingleton doubleCheckSingelton = DoubleCheckSingleton.getDoubleCheckSingelton();
            System.out.println("t1:" + doubleCheckSingelton);
        }
        );
        Thread t2 = new Thread(() -> {
            DoubleCheckSingleton doubleCheckSingelton = DoubleCheckSingleton.getDoubleCheckSingelton();
            System.out.println("t2:" + doubleCheckSingelton);
        }
        );
        Thread t3 = new Thread(() -> {
            DoubleCheckSingleton doubleCheckSingelton = DoubleCheckSingleton.getDoubleCheckSingelton();
            System.out.println("t3:" + doubleCheckSingelton);
        }
        );
        t1.start();
        t2.start();
        t3.start();
        System.out.println("耗时：" + (System.currentTimeMillis() - st));

    }


}
