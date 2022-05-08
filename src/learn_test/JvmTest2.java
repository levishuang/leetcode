package learn_test;

import java.util.Date;

import java.util.Timer;

import java.util.TimerTask;

/**
 * @package: learn_test
 * @Description:
 * @author: jilai_huang
 * @date: 2022/4/22 22:18
 */

public class JvmTest2 {

    public static void main(String[] args) {

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {

            @Override
            public void run() {

                System.out.println(Thread.currentThread() + " is running");

            }

        }, new Date(), 6000);

    }
}
