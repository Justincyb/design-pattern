package method.template;

/**
 * @Author Justin
 * @Time 2018/6/25 14:16
 * @Description 模板方法（框架方法）
 * 引入：定义在一个操作中的一个算法框架，把一些步骤推迟到子类去实现，
 * 模板方法让子类不需要改变算法结构而重新定义特定的算法步骤
 *
 * 解释：
 * 模板方法定义了一系列算法步骤，子类可以去实现/覆盖其中某些步骤但是不能改变其中的步骤顺序，
 * 这个是在模板中已经确定的
 */
public abstract class PeopleWorkOut {

    // 保证业务逻辑顺序
    public void workOut(String name) {
        closeComputer(name);
        // 新增打卡逻辑
        punchClock(name);
        traffic(name);
        driveHome(name);
    }

    // 关闭电脑
    public void closeComputer(String name) {
        System.out.println(name + "正在：关闭电脑，准备下班");
    }

    // 选择交通工具 抽象类，子类可以自己去实现拓展自己的不同业务
    protected abstract void traffic(String name);

    // 到家
    public void driveHome(String name) {
        System.out.println(name + "：到家，与家人共进晚餐");
    }

    // 打卡
    public void punchClock(String name) {
        System.out.println(name + ":打卡下班");
    }

}
