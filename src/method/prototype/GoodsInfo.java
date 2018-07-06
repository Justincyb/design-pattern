package method.prototype;

/**
 * @Author Justin
 * @Time 2018/7/6 17:21
 * @Description
 */
public class GoodsInfo implements Cloneable{

    // name
    private String goodsName;
    //
    private String goosId;
    //
    private Double price;
    private int amount;
    private String level;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoosId() {
        return goosId;
    }

    public void setGoosId(String goosId) {
        this.goosId = goosId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public GoodsInfo clone(){
        try {
            return (GoodsInfo) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static GoodsInfo clonePackage(String goosId){
        // 从数据库查询数据，此处我就模拟走的db
        GoodsInfo goodsInfo = loadPackageInfo(goosId);
        goodsInfo = goodsInfo.clone();
        goodsInfo.setGoosId(null);
        return goodsInfo;
    }

    private static GoodsInfo loadPackageInfo(String goosId) {
        GoodsInfo goodsInfo = new GoodsInfo();
        goodsInfo.setGoosId(goosId);
        goodsInfo.setGoodsName("车厘子9.5R");
        goodsInfo.setAmount(100);
        goodsInfo.setPrice(100.00);
        goodsInfo.setLevel("新西兰新品");
        return goodsInfo;
    }
}
