package com.webclient.utils;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.junit.Test;

import java.io.IOException;


/**
 * HttpClient 主动提交表单
 */
public class MyHttpClient {
    /**
     * commons.httpclient 包
     * 数组提交参数 requestBody提交参数成功
     * @throws IOException
     */
    @Test
   public  void post1() throws IOException {

       HttpClient client = new HttpClient();
       PostMethod method = new PostMethod("http://localhost:9030/httpClient/login.do");
       NameValuePair[] pairs = {
               new NameValuePair("uname","lula"),
               new NameValuePair("pwd", "123456")
       };
        method.setRequestBody(pairs);
       client.executeMethod(method);
       String result = method.getResponseBodyAsString();

       System.out.println("测试:"+result);
   }

    /**
     * setParameter 设置参数  RequestEntity不靠谱
     * @throws IOException
     */
   @Test
   public void post2() throws IOException {
       HttpClient httpClient = new HttpClient();
       PostMethod method = new PostMethod("http://localhost:9030/httpClient/login.do");

       method.setParameter("uname","nancy"); // 设置表单参数
       method.setParameter("pwd","i love a firewood");// 设置表单参数

       httpClient.executeMethod(method);//执行方法
       String result = method.getResponseBodyAsString();// 获取响应值

       System.out.println("输出结果："+result);
   }

    /**
     * json 传递数据 fail
     */
   @Test
   public void post3() throws IOException {
       String url = "http://localhost:9030/httpClient/login.do";
       HttpClient httpClient = new HttpClient();// 实例化
       PostMethod method = new PostMethod(url);// 加载url
       String params = "{\"uname\":\"jack\",\"pwd\":\"i love a firewood\"}";

       RequestEntity re = new StringRequestEntity(params,"application/json","UTF-8");
       method.setRequestEntity(re);// 设置参数

       int code = httpClient.executeMethod(method);// 执行方法 200表示ok
       String result = method.getResponseBodyAsString();// 获取响应

       System.out.println("测试响应值:"+result+",代号:"+code+"\t"+ re.getContentType());

   }


}
