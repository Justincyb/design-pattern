package method.factory;

/**
 * @Author Justin
 * @Time 2018/7/6 10:35
 * @Description 生产实现
 */
public class ProductImpl implements Product{

    @Override
    public void createCar() {
        System.out.println("生产车。。。");
    }

    @Override
    public void createTel() {
        System.out.println("生产手机。。。");
    }
}
