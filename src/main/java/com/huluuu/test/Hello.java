package com.huluuu.test;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Collection;

/**
 * Created by liuwei on 2017/7/10.
 */
public class Hello {

    public static void main(String[] args) {
        //System.out.printf("hello.............");

        System.out.println(getApkPath());
    }

    public static String getApkPath() {
        String path = "/Users/liuwei/.jenkins/workspace/Android_Test/app/build/outputs/apk";
        Collection<File> files = FileUtils.listFiles(new File(path), new String[]{"apk"}, false);
        for (File f : files) {
            return f.getAbsolutePath();
        }
        return null;
    }



    ///Users/liuwei/Documents/if-test/target/classes
    //java -classpath "%CLASSPATH%;/Users/liuwei/Documents/if-test/target/classes;/Users/liuwei/Documents/if-test/target/lib/*”
    //
    // org.testng.TestNG /Users/liuwei/Documents/if-test/target/testng.xml

    //java -classpath '/Users/liuwei/Documents/if-test/target/classes:/Users/liuwei/Documents/if-test/target/lib/*' com.huluuu.test.Hello


    //java -classpath '/Users/liuwei/Documents/if-test/target/classes:/Users/liuwei/Documents/if-test/target/lib/*' org.testng.TestNG /Users/liuwei/Documents/if-test/testng.xm




}
