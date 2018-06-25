package method.template;

/**
 * @Author Justin
 * @Time 2018/6/25 10:41
 * @Description 下班流程 关电脑 ——> 乘地铁 ——>到家和家人共进晚餐
 */
public class WorkOut {

    // 模拟下班乘地铁回家
    public void goHomeBySubWay(String name) {
        System.out.println(name + "正在：关闭电脑，准备下班");
        System.out.println(name + "正在：乘车，坐地铁，买票，上车，换乘，下车...");
        System.out.println(name + "：到家，与家人共进晚餐");
    }

    // 模拟下班乘私家车回家
    public void goHomeByCar(String name){
        System.out.println(name + "正在：关闭电脑，准备下班");
        System.out.println(name + "正在：乘坐私家车回家...");
        System.out.println(name + "：到家，与家人共进晚餐");
    }

}
