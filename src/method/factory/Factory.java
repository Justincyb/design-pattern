package method.factory;

/**
 * @Author Justin
 * @Time 2018/7/6 10:31
 * @Description 工厂接口
 */
public interface Factory {

    // 接口提供一个生产接口的方法
    Product createProduct();
    // 提供一个采购方法
    Purchase createPurchase();


}
