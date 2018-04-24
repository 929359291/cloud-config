package com.demo.demologin.contants;

import com.demo.demologin.entity.DimensionType;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @desc: 多线程测试
 * @author: zengxc
 * @date: 2018/4/19
 */
public class MultiThreadTest {

    private static int count;
    ExecutorService pool = Executors.newFixedThreadPool(20);
    ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        final List<Integer> l = new LinkedList<Integer>();
        ThreadPoolExecutor tp = new ThreadPoolExecutor(100, 100, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(20000));
        final Random random = new Random();
        for (int i = 0; i < 20000; i++) {
            tp.execute(new Runnable() {
                public void run() {
                    l.add(random.nextInt());
                }
            });
        }
        tp.shutdown();
        try {
            tp.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(l.size());
    }

    @Test
    public void executors() throws ExecutionException, InterruptedException {
        pool.submit(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                List<String> fieldsValue = DimensionType.FIELDS_VALUE;
                Iterator<String> iterator = fieldsValue.iterator();
                for (int i = 0; i < 1000000; i++) {
                    while (iterator.hasNext()) {
                        String type = iterator.next();
                    }
                    count++;
                }
                System.out.println("耗时 = " + (System.currentTimeMillis() - start));
                System.out.println("统计 = " + count);
            }
        }).get();
    }

    @Test
    public void test03() {
        long startTime = System.currentTimeMillis();
        final List<Integer> l = new LinkedList<Integer>();
        final Random random = new Random();
        for (int i = 0; i < 20000; i++) {
            Thread thread = new Thread() {
                public void run() {
                    l.add(random.nextInt());
                }
            };
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(l.size());
    }
}
