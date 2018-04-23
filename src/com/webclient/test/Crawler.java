package com.webclient.test;

import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * 爬虫
 */
public class Crawler {
    /**
     * GET请求(默认)
     * @throws IOException
     * StringWriter-Reader
     */

    public static void main (String[] args)throws IOException {
        URL url = new URL("http://blog.csdn.net/woxueliuyun/article/details/43267365");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();//建立HttpURLConnection对象
        InputStream in = conn.getInputStream();//建立连接
        Reader reader = new InputStreamReader(in);//输入流 读取
        StringWriter writer = new StringWriter();//输出流 写入

        char[] buffer = new char[1024];//每次读取1024
        for (int length = 0; (length = reader.read(buffer)) > 0;) {
            writer.write(buffer, 0, length);
        }
        writer.close();//关闭输出流
        reader.close();//关闭输入流

        System.out.println(writer.toString());//将网页内容输出

    }

    /**
     * StringBuffer-BufferedReader
     */
    @Test
    public void test() throws IOException {
        URL url = new URL("http://blog.csdn.net/antony9118/article/details/71023009");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();//创建url对象
        BufferedReader in = null;
        StringBuffer out = new StringBuffer();
        in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        //读取数据
        String line;
        while (( line = in.readLine())!= null){
            out.append(line);
        }

        System.out.println(out.toString());
    }




}
