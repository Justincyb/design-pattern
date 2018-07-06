package method.factory;

/**
 * @Author Justin
 * @Time 2018/7/6 10:34
 * @Description 工厂实现
 * 创建服务端生产实例
 * 问题：如果我们有多个服务端实例这里就需要创建多个实例，
 * 有多少个就得创建多少个，引发的问题就是工厂类泛滥
 */
public class FactoryImpl implements Factory {

    // 创建一个生产实例
    @Override
    public Product createProduct() {
        return new ProductImpl();
    }

    // 创建一个采购实例
    @Override
    public Purchase createPurchase() {
        return new PurchaseImpl();
    }

}
