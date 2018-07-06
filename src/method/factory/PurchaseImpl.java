package method.factory;

/**
 * @Author Justin
 * @Time 2018/7/6 11:00
 * @Description
 */
public class PurchaseImpl implements Purchase{
    @Override
    public void purchaseMotor() {
        System.out.println("采购发动机");
    }

    @Override
    public void purchaseChip() {
        System.out.println("采购芯片");
    }
}
