package first;

import java.util.concurrent.TimeUnit;

/**
 * 创建线程可以继承 Thread 类
 *
 * @author zhou
 * @date 2023/3/23
 */
public class FirstThread extends Thread {

    @Override
    public void run() {
        int times = 200;
        for (int i = 0; i < times; i++) {
            System.err.println("一共要执行 " + times + " 次 "
                    + FirstThread.class.getSimpleName()
                    + " 线程的 run 方法。当前是第 " + i + " 次");
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
