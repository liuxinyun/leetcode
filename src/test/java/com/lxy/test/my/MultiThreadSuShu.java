package com.lxy.test.my;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuxinyun
 * @date 2019/4/24 22:41
 */
public class MultiThreadSuShu {

    private static int threadPoolSize = 10;
    private static int pageNum = 10;
    private static AtomicInteger count = new AtomicInteger();

    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        sumPrimeNums(10000000);
        System.out.println(System.currentTimeMillis() - startTime + "ms");
        startTime = System.currentTimeMillis();
        sumPrimeNums2(10000000);
        System.out.println(System.currentTimeMillis() - startTime + "ms");
    }

    public void sumPrimeNums(int num) {
        int pageSize = num/ pageNum;
        List<Callable<Integer>> callables = new ArrayList<>();
        for (int i = 0; i < pageNum; i++) {
            int start = i*pageSize + 1;
            int end = (pageNum -i == 1) ? num : (start+pageSize-1);
            callables.add(() -> getPrimeNums(start, end));
        }
        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
        try {
            executorService.invokeAll(callables, 10000, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println("count:" + count.get());
    }

    /**
     * 求某范围内的素数数量
     * @param start
     * @param end
     * @return
     */
    public static int getPrimeNums(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (isPrimeFix(i)) {
                count.getAndIncrement();
            }
        }
        return count.get();
    }

    public void sumPrimeNums2(int num) {
        int pageSize = num/ pageNum;
        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);
        for (int i = 0; i < pageNum; i++) {
            int start = i*pageSize + 1;
            int end = (pageNum -i == 1) ? num : (start+pageSize-1);
            completionService.submit(() -> getPrimeNums2(start, end));
        }
        int sum = 0;
        for (int i = 0; i < pageNum; i++) {
            try {
                sum += completionService.take().get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
        System.out.println("sum:" + sum);
    }

    public static int getPrimeNums2(int start, int end) {
        int c = 0;
        for (int i = start; i <= end; i++) {
            if (isPrimeFix(i)) {
                c++;
            }
        }
        return c;
    }

    /**
     * 定义实现
     * 如果数字非常大，效率很低
     *
     * @param n
     * @return
     */
    private static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 优化：开方，如果是亿，直接变一万，缩小很多
     *
     * @param n
     * @return
     */
    private static boolean isPrimeFix(int n) {
        if (n <= 1)
            return false;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
