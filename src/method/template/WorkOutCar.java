package method.template;

/**
 * @Author Justin
 * @Time 2018/6/25 14:23
 * @Description
 */
public class WorkOutCar extends PeopleWorkOut{
    @Override
    protected void traffic(String name) {
        System.out.println(name + "正在：乘坐私家车回家...");
    }
}
