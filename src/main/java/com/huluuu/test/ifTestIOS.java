package com.huluuu.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

/**
 * Created by yumi on 2017/5/27.
 */
@Listeners({ScreenshotListener.class})
public class ifTestIOS {
    //public AppiumDriver driver;
    static IOSDriver driver;
    private boolean isInstall = false;

    public void startRecord() throws IOException {
        Runtime rt = Runtime.getRuntime();
        // this code for record the screen of your device
        rt.exec("cmd.exe /C adb shell screenrecord /sdcard/runCase.mp4");
    }

    public void ScreenShot(IOSDriver driver){
        File screenShot = driver.getScreenshotAs(OutputType.FILE); //获取screenshot文件
        try {
            FileUtils.copyFile(screenShot, new File("./dir" + getDatetime() + ".jpg")); //文件copy到指定的文件夹
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getDatetime(){
        SimpleDateFormat date = new SimpleDateFormat("yyyymmdd hhmmss");
        return date.format(new Date());
    }

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        //启动appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("deviceName","iphone 6s plus");
        capabilities.setCapability("deviceName","iphone 6s plus");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("platformName","IOS");
        //capabilities.setCapability("platformVersion","10.0.1");
        capabilities.setCapability("platformVersion","10.0.1");

        //配置测试apk
        //capabilities.setCapability("udid", "98882a0a4c10070e96345aa753d9bd39a93f9330");
        capabilities.setCapability("udid", "98882a0a4c10070e96345aa753d9bd39a93f9330");
        capabilities.setCapability("bundleId", "com.ifme.videochatapp");
        capabilities.setCapability("newCommandTimeout",600);
        capabilities.setCapability("sessionOverride", true);    //每次启动时覆盖session，否则第二次后运行会报错不能新建session
        capabilities.setCapability("unicodeKeyboard", true);    //设置键盘
        capabilities.setCapability("resetKeyboard", false);     //设置默认键盘为appium的键盘
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //如果真机设备已经安装，则不需要重新安装
//        if (isInstall) {
//            File classpathRoot = new File(System.getProperty("user.dir")); // 获取当前程序所在目录
//            File appDir = new File(classpathRoot, "apps");
//            File app = new File(appDir, "iF-debug-201705201657.ipa");
//            capabilities.setCapability("app", app.getAbsolutePath());
//        }
        //  startRecord();
    }

    @Test
    public void login() throws InterruptedException {
      //  Connection con =  driver.getConnection();
     //   System.out.println(con);
//
          driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"iFme\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeImage/XCUIElementTypeOther[1]/XCUIElementTypeTextField").clear();
          driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"iFme\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeImage/XCUIElementTypeOther[1]/XCUIElementTypeTextField").sendKeys("16000000100");
          driver.findElementByAccessibilityId("免验证").click();
          driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"iFme\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeImage/XCUIElementTypeOther[2]/XCUIElementTypeTextField").sendKeys("0802");
          Thread.sleep(3000);
          driver.findElementByAccessibilityId("登录").click();
          Thread.sleep(3000);
//
//        driver.findElementById("com.douyaim.qsapp.ifme:id/action_sign_in").click();
//        Thread.sleep(3000);
//        //   ScreenShot(driver);
//        String str = driver.findElementById("com.douyaim.qsapp.ifme:id/title_of_fc_list").getText().trim();
//        assertEquals("ME Life", str);
//        Thread.sleep(8000);

          System.out.println("!!!!!!!!!");
    }

    /*
    ** 发单聊私信（不带特效）
     */
    @Test
    public void sendMessages() throws InterruptedException {
          driver.findElementByAccessibilityId("common menu icon").click();
          Thread.sleep(3000);
          driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"iFme\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeButton[4]").click();
          Thread.sleep(2000);
          driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"iFme\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeButton").click();
          Thread.sleep(2000);
          driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"iFme\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeButton[2]").click();

          Date date=new Date();
          DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          String time=format.format(date);

          System.out.println(time);

          for(int i = 0; i < 500; i++) {
              Thread.sleep(1000);
              driver.findElementByAccessibilityId("video msg record ic").click();
              Thread.sleep(60000);
              driver.findElementByAccessibilityId("video msg record ic").click();
              System.out.println(i);

              //获取全部子元素的最后一个子元素
              WebElement elelast = driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"iFme\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[last()]/XCUIElementTypeOther/XCUIElementTypeButton");

              Thread.sleep(8000);

              List<String> list = driver.findElementsByXPath("//XCUIElementTypeApplication[@name=\"iFme\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[last()]/XCUIElementTypeOther/node()") ;
              System.out.println("node size is: "+list.size());

              //发送中状态处理......
              if(list.size() > 2){
                  System.out.println("第" + i + "次发送中.......");

              }else if("send error icon".equals(elelast.getAttribute("name"))){
                  System.out.println("第" + i + "次发送视频失败");
              }

          }
          driver.findElementByAccessibilityId("common back write").click();

    }

    /*
    ** 发单聊私信（带特效）
     */
    @Test
    public void sendMessagesAddEffect() throws InterruptedException {
        driver.findElementByAccessibilityId("common menu icon").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"iFme\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeButton[4]").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"iFme\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeButton").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"iFme\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeButton[2]").click();



//        Thread.sleep(1000);
//        driver.findElementByAccessibilityId("特效").click();
//
//        Thread.sleep(2000);

//        List<String> list = driver.findElementsByXPath("//XCUIElementTypeApplication[@name=\"iFme\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeCollectionView[1]/node()");
//        System.out.println("--------------");
//        System.out.println(list.size());
//
//        int width = driver.manage().window().getSize().width;
//        int height = driver.manage().window().getSize().height;
//
//        System.out.println("width is :" + width + ";" + "height is :" + height);
//
//        driver.swipe(360,534,30,534,1000);
//
//        Thread.sleep(3000);

        for(int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            driver.findElementByAccessibilityId("特效").click();

            int category =  CommonUtils.getRandom(1, 6);
            String str = new String();

            switch(category){
                case 1:
                    str = "卖个萌";
                    break;
                case 2:
                    str = "表个白";
                    break;
                case 3:
                    str = "撩一下";
                    break;
                case 4:
                    str = "擦浪嘿呦";
                    break;
                case 5:
                    str = "有趣的";
                    break;
                case 6:
                    str = "3D头像";
                    driver.swipe(331,602,40,602,1000); //左滑出现3D头像
                    break;
                default:
                    System.out.println("random num is out of range!!");

            }

            driver.findElementByAccessibilityId(str).click(); //点击特效分类

            if(0 == i%2){
                driver.swipe(360,534,30,534,1000);
            }else{
                driver.swipe(0,534,330,534,1000);
            }

            List<String> list = driver.findElementsByXPath("//XCUIElementTypeApplication[@name=\"iFme\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeCollectionView[1]/node()");
            int len = list.size();
            int effectOrder =  CommonUtils.getRandom(1, len);
            driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"iFme\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell["+effectOrder+"]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]").click();

            Thread.sleep(3000);
            driver.findElementByAccessibilityId("video msg record ic").click();
            Thread.sleep(60000);
            driver.findElementByAccessibilityId("video msg record ic").click();
            Thread.sleep(3000);
            //driver.findElementByAccessibilityId("发送").click();
            //Thread.sleep(3000);
        }


    }

    /*
    ** 私聊下载播放视频
     */
    @Test
    public void downloadMessages() throws InterruptedException {



    }


    /*
    ** 上传朋友圈视频(不带特效)
    */
    @Test
    public void uploadFriendCycle() throws InterruptedException{
        for(int i = 0; i < 1000; i++) {
            driver.findElementByAccessibilityId("camera title").click();
            Thread.sleep(1000);
            driver.findElementByAccessibilityId("camera3 record").click();
            Thread.sleep(20000);
            driver.findElementByAccessibilityId("camera3 record").click();
            try {
                Thread.sleep(3000);
                driver.findElementByAccessibilityId("发送").click();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }

    }


    /*
    ** 上传朋友圈视频(带特效)
     */
    @Test
    public void uploadFriendCycleAddEffects() throws InterruptedException{
     //   driver.findElementByAccessibilityId("camera title").click();

        for(int i = 0; i < 10; i++) {
            driver.findElementByAccessibilityId("camera title").click();
            Thread.sleep(1000);
            driver.findElementByAccessibilityId("特效").click();

            int category =  CommonUtils.getRandom(1, 6);
            String str = new String();

            switch(category){
                case 1:
                    str = "卖个萌";
                    break;
                case 2:
                    str = "表个白";
                    break;
                case 3:
                    str = "撩一下";
                    break;
                case 4:
                    str = "擦浪嘿呦";
                    break;
                case 5:
                    str = "有趣的";
                    break;
                case 6:
                    str = "3D头像";
                    driver.swipe(331,602,40,602,1000); //左滑出现3D头像
                    break;
                default:
                    System.out.println("random num is out of range!!");

            }

            driver.findElementByAccessibilityId(str).click(); //点击特效分类

            if(0 == i%2){
                driver.swipe(360,534,30,534,1000);
            }else{
                driver.swipe(0,534,330,534,1000);
            }

            List<String> list = driver.findElementsByXPath("//XCUIElementTypeApplication[@name=\"iFme\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeCollectionView[1]/node()");
            int len = list.size();
            int effectOrder =  CommonUtils.getRandom(1, len);
            driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"iFme\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell["+effectOrder+"]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]").click();

            Thread.sleep(3000);
            driver.findElementByAccessibilityId("camera3 record").click();
            Thread.sleep(60000);
            driver.findElementByAccessibilityId("camera3 record").click();

            try {
                Thread.sleep(3000);
                driver.findElementByAccessibilityId("发送").click();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    /*
     **上传朋友圈视频(带音乐)
    */
    @Test
    public void uploadFriendCycleAddMusic() throws InterruptedException{
        for(int i = 1; i <= 10; i++) {
            driver.findElementByAccessibilityId("camera title").click();
            Thread.sleep(1000);
            driver.findElementByAccessibilityId("camera3 record").click();
            Thread.sleep(10000);
            driver.findElementByAccessibilityId("camera3 record").click();
            try {
                Thread.sleep(3000);
                driver.findElementByAccessibilityId("音乐").click();
                Thread.sleep(2000);

                if(0 == i%2){
                    if(0 != i%5) {
                        driver.swipe(450, 554, 0, 550, 1000);
                    }
                }else {
                    if(0 == i%3) {
                        driver.swipe(450, 554, 0, 550, 1000);
                        driver.swipe(450, 554, 0, 550, 1000);
                    }
                }

                Thread.sleep(2000);
                List<String> list = driver.findElementsByXPath("//XCUIElementTypeApplication[@name=\"iFme\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView[2]/node()");
                int len = list.size();
                int effectOrder =  CommonUtils.getRandom(1, len);
                System.out.println("effectOrder is:" + effectOrder);
                driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"iFme\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView[2]/XCUIElementTypeCell["+effectOrder+"]/XCUIElementTypeOther/XCUIElementTypeButton[1]").click();

                Thread.sleep(5000);

                driver.findElementByAccessibilityId("发送").click();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /*
    **  朋友圈上传视频带文字
     */
    @Test
    public void uploadFriendCycleAddFont(){



    }


    /*
    ** 查看播放朋友圈视频
     */
    @Test
    public void playVideoFriendCycle(){
        driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"iFme\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeButton[1]").click();



    }








    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }


    public static AppiumDriver getDriver(){
        return driver;
    }
}
