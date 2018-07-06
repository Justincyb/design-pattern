package method.prototype;

/**
 * @Author Justin
 * @Time 2018/7/6 17:35
 * @Description
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
