package method.factory;

/**
 * @Author Justin
 * @Time 2018/7/6 10:38
 * @Description 客户端调用工厂
 */
public class Client {

    // 引入工厂
    private Factory factory;

    // 构造接受一个工厂
    public Client (Factory factory){
        this.factory = factory;
    }

    // 生产汽车
    public void productCar(){
        // 1、采购材料 2、生产
        Purchase purchase = factory.createPurchase();
        purchase.purchaseMotor();
        Product product = factory.createProduct();
        product.createCar();
    }

    // 生产手机
    public void productTel(){
        Purchase purchase = factory.createPurchase();
        purchase.purchaseChip();
        Product product = factory.createProduct();
        product.createTel();
    }

    public static void main(String[] args) {
        // 创建客户端，传入工厂实例
        Client client = new Client(new FactoryImpl());
        client.productCar();
        client.productTel();
    }

}
