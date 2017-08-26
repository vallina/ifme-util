package com.huluuu.test;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

/**
 * Created by liuwei on 2017/6/27.
 */
public class CommonUtils {

    /**
     * 上滑 
     *
     * @param driver
     * @param during
     * @param num
     */
    public static void swipeToUp(AppiumDriver<WebElement> driver, int during, int num) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        for (int i = 0; i < num; i++) {
            driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, during);
        }
    }

    /**
     * 下拉
     *
     * @param driver
     * @param during
     * @param num
     */
    public static void swipeToDown(AppiumDriver<WebElement> driver,int during, int num) throws InterruptedException {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        System.out.println(width);
        System.out.println(height);
        for (int i = 0; i < num; i++) {
            driver.swipe(width / 2, height / 4, width / 2, height * 3 / 4, during);
            Thread.sleep(3000);
        }
    }

    /**
     * 向左滑动
     *
     * @param driver
     * @param during
     * @param num
     */
    public static void swipeToLeft(AppiumDriver<WebElement> driver,int during, int num) throws InterruptedException {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        for (int i = 0; i < num; i++) {
            driver.swipe(width * 3 / 4, height / 2, width / 4, height / 2, during);
            Thread.sleep(3000);
        }
    }

    /**
     * 向右滑动
     *
     * @param driver
     * @param during
     * @param num
     */
    public static void swipeToRight(AppiumDriver<WebElement> driver,int during, int num) throws InterruptedException {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        for (int i = 0; i < num; i++) {
            driver.swipe(width / 4, height / 2, width * 3 / 4, height / 2, during);
            Thread.sleep(3000);
        }
    }


    /**
     * 取指定范围的随机数
     * @param min
     * @param max
     */
    public static int getRandom(int min, int max){
        Random rand = new Random();
        int x = rand.nextInt(max)%(max - min + 1)+min;
        return x;
    }


}
