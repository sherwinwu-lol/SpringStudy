package templateMethod.unuseful;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FtocTemplateMethod extends Application {
    private InputStreamReader isr;
    private BufferedReader br;

    @Override
    protected void init() {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);
    }

    @Override
    protected void idle() {
        String fahrString = readLineAndReturnNullIfError();
        if (fahrString == null || fahrString.length() == 0) {
            setDone();
        } else {
            double fahr = Double.parseDouble(fahrString);
            double celcius = 5.0 / 9.0 * (fahr - 32);
            System.out.println("F=" + fahr + ", C=" + celcius);
        }
    }

    @Override
    protected void cleanup() {
        System.out.println("ftoc exit");
    }

    private String readLineAndReturnNullIfError() {
        String s;
        try {
            s = br.readLine();
        } catch (IOException e) {
            s = null;
        }
        return s;
    }
}
/**
 * 它没有带来任何有价值的东西,使问题复杂化了.
 * 这是滥用模式, 使得程序变得复杂庞大, 把每个应用程序的主循环以通用方式封装起来
 *
 * 本例,虽然可以应用TEMPLATE METHOD模式,但是使用是不明智的,因为使用该模式的代价要高于它带来的好处
 */
