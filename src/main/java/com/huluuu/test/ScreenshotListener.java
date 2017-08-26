package com.huluuu.test;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yumi on 2017/6/19.
 */
public class ScreenshotListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult tr){
        AppiumDriver driver = ifTest.getDriver();
        File location = new File("screenshots1"); //在默认的工作目录下面创建一个名字叫screenshots1的文件夹，用来存放图片的
        String screenShotName = location.getAbsolutePath()+File.separator+tr.getMethod().getMethodName()+getCurrentTime()+".png"; //
        File screenShot = driver.getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(screenShot, new File(screenShotName));
            System.out.println("stat......");
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    public String getCurrentTime(){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String currentTime=sdf.format(date);
        return currentTime;
    }
}
