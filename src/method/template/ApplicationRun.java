package method.template;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Justin
 * @Time 2018/6/25 10:52
 * @Description
 */
public class ApplicationRun {

    public static void main(String[] args) {

        // 现在小明和小红下班了，准备坐地铁回家 so easy
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        /*Runnable xiaoming = () -> {
            PeopleCar.goHomeBySubWay("小明");
        };
        Runnable xiaohong = () -> {
            PeopleCar.goHomeBySubWay("小红");
        };
        executorService.execute(xiaoming);
        executorService.execute(xiaohong);*/

        // 现在问题来了，有一天小明和小红不是做地铁回家的，小明还做地铁，但是小红恋爱了，所以男朋友开车来接她的，
        // 这个时候我们的PeopleCar貌似不适用了,但是这个时候又得满足场景，为了尽快满足业务，我们第一时间想到的方法无非是另起一个方法来出来私家车的问题
        /*WorkOut workOut = new WorkOut();
        Runnable xiaoming = () -> {
            workOut.goHomeBySubWay("小明");
        };
        Runnable xiaohong = () -> {
            workOut.goHomeByCar("小红");
        };*/


        // 这种方案虽然问题不大，但是我们会发现goHomeBySubWay和goHomeByCar两个方法中存在了重复的业务逻辑，例如现在，下班之后增加了打卡流程，
        // 小明和小红下班之后关完电脑，还得加一步逻辑，打卡动作，此时我们需要在这2个方法都需要增加一段打卡逻辑，是不是有点废，而且代码不利于管理
        // 解决方案1：将共同的业务逻辑抽离出来作为公共业务逻辑方法 （此处不讲解）；
        // 解决方案2：使用模板模式改造

        WorkOutCar workOutCar = new WorkOutCar();
        WorkOutSubWay workOutSubWay = new WorkOutSubWay();
        Runnable xiaoming = () -> {
            workOutCar.workOut("小明");
        };
        Runnable xiaohong = () -> {
            workOutSubWay.workOut("小红");
        };
        executorService.execute(xiaoming);
        executorService.execute(xiaohong);




    }

}
