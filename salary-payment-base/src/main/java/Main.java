import org.joda.time.DateTime;

import java.util.Random;

/**
 * 数据库是实现细节!尽可能地推迟考虑数据库,太多应用程序之所以和数据库绑定在一起而无法分离,
 * 就是因为一开始设计时就把数据库考虑在内了.
 * 请记住抽象的定义: 本质部分的放大, 无关紧要部分的去除.
 * 在项目当前阶段数据库就是无关紧要: 它只不过是一项用来存储和访问数据的技术而已.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        String[] qinghuas = new String[6];
        qinghuas[0] = "可以坐上我家洁宝贝的电动车";
        qinghuas[1] = "可以亲吻宝贝";
        qinghuas[2] = "可以看到宝贝美丽的脸蛋";
        qinghuas[3] = "可以搂着宝贝的腰";
        qinghuas[4] = "可以闻着宝贝的发香";
        qinghuas[5] = "可以听到宝贝的声音";
        Random random = new Random(47);

        while (true) {
            DateTime restTime = DateTime.parse("2019-04-30T18:00");
            DateTime now = DateTime.now();
            int restM = restTime.secondOfDay().get();
            int nowM = now.secondOfDay().get();
            System.out.println("剩余" + (restM - nowM) + "秒, " + qinghuas[random.nextInt(6)]);
            Thread.sleep(1000);
        }
    }
}
