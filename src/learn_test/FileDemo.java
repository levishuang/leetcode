package learn_test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @package: learn_test
 * @Description:
 * @author: jilai_huang
 * @date: 2022/2/25 16:16
 */

public class FileDemo {
    public static void deleteAllFiles(String filePath) {
        File files = new File(filePath);
        if (files.isDirectory()) {
            for (File f : files.listFiles()) {
                if (f.isFile()) {
                    if (f.delete()) {
                        System.out.println(f.getAbsolutePath() + "已删除");

                    }
                }else {
                    deleteAllFiles(f.getPath());
                    boolean flag = f.delete();
                    System.out.println(f.getAbsolutePath() + "已删除");
                }
            }
            files.delete();
        }
    }

    public static void main(String[] args) {
        String directoryName = "D:" + File.separator + "huang";
        File f = new File(directoryName);
        if (!f.exists()) {
            try {
                f.mkdir();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String fileName = f.getAbsolutePath() + File.separator + "test.txt";
        File f1 = new File(fileName);
        try {
            f1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        deleteAllFiles(directoryName);
        //读写测试的数据都比较小
        String text = "黄继来是大帅b！！！！！！！";
        //字节流的读写
//        FileOutputStream fileOutputStream = null;
//        try {
//            fileOutputStream = new FileOutputStream(fileName);
//            fileOutputStream.write(text.getBytes(StandardCharsets.UTF_8));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        FileInputStream fileInputStream = null;
//        try {
//            byte[] b = new byte[255];
//            fileInputStream = new FileInputStream(fileName);
//            fileInputStream.read(b);
//            System.out.println(new String(b));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //字符流的读写
//        try {
//            FileReader fileReader = new FileReader(fileName);
//            int len = fileReader.read();
//            System.out.println(len);
//            char[] cbuffer = new char[len];
//            fileReader.read(cbuffer);
//            System.out.println(new String(cbuffer));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
