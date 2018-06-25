package method.template;

/**
 * @Author Justin
 * @Time 2018/6/25 14:24
 * @Description
 */
public class WorkOutSubWay extends PeopleWorkOut{
    @Override
    protected void traffic(String name) {
        System.out.println(name + "正在：乘车，坐地铁，买票，上车，换乘，下车...");
    }
}
