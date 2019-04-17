package designPattern.templateMethod;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Fttocraw {
    /**
     * 组成部分: 1.初始化InputStreamReader和BufferedReader
     *          2.主循环从BufferedReader中读取华氏温度,并把该温度转换成摄氏温度打印出来
     *          3.打印出一条退出信息
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        boolean done = false;
        while (!done) {
            String fahrString = br.readLine();
            if (fahrString == null || fahrString.length() == 0) {
                done = true;
            }
            else {
                double fahr = Double.parseDouble(fahrString);
                double celcius = 5.0/9.0*(fahr - 32);
                System.out.println("F=" + fahr + ", C=" + celcius);
            }
        }
        System.out.println("ftoc exit");
    }
}
