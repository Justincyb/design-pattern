package method.prototype;

/**
 * @Author Justin
 * @Time 2018/7/6 17:35
 * @Description 原型模式
 * 使用原型实例指定将要创建的对象类型，通过复制这个实例创建新的对象
 * 这种模式是实现了一个原型接口，该接口用于创建当前对象的克隆。当直接创建对象的代价比较大时，则采用这种模式
 */
public class GoodsInfoTest {

    public static void main(String[] args) {
        GoodsInfo goodsInfo = GoodsInfo.clonePackage("10010");
        System.out.println("原始数据：");
        displayGoods(goodsInfo);

        goodsInfo.setGoosId("10002");
        goodsInfo.setGoodsName("车厘子10R");
        System.out.println("克隆之后的数据：");
        displayGoods(goodsInfo);
    }

    public static void displayGoods(GoodsInfo goodsInfo) {
        System.out.println("编号:" + goodsInfo.getGoosId());
        System.out.println("名称：" + goodsInfo.getGoodsName());
        System.out.println("品级:" + goodsInfo.getLevel());
        System.out.println("数量:" + goodsInfo.getAmount());
        System.out.println("售价:" + goodsInfo.getPrice());
    }


}
