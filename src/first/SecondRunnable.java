package first;

import java.util.concurrent.TimeUnit;

/**
 * 实现一个 Runnable 接口，然后将其放入到线程中执行
 *
 * @author zhou
 * @date 2023/3/23
 */
public class SecondRunnable implements Runnable {

    @Override
    public void run() {
        int times = 200;
        for (int i = 0; i < times; i++) {
            System.err.println("一共要执行 " + times + " 次 "
                    + Thread.currentThread()
                    + " 线程的 run 方法。当前是第 " + i + " 次");
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
