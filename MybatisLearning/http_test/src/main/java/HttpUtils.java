
import okhttp3.*;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HttpUtils {

    private static final String MEDIA_TYPE_JSON = "application/json;charset=utf-8";

    private static String COMPANY_PREFIX = "ECLOUDTECHCOMCN";



    //MEDIA_TYPE_TEXT post请求不是application/x-www-form-urlencoded的，
    // 全部直接返回，不作处理，即不会解析表单数据来放到request parameter map中。
    // 所以通过request.getParameter(name)是获取不到的。只能使用最原始的方式，读取输入流来获取。
    private static final MediaType MEDIA_TYPE_TEXT = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");



    /**
     * @param url , json
     * @return java.lang.String
     * @descprition
     * @version 1.0 post+json方式,token只有在校验用户token换取组户名时必填，其他场景不需要填写
     */
    public static String sendByPostJson(String url, String json,String token) {
        String result;
        if("".equals(token) || null == token){
            token = COMPANY_PREFIX+ DateUtils.format("yyyyMMddHHmmssSSS");
        }else {
            token = "Bearer "+token;
        }
        System.out.println("send post request,url->"+url+"   params->"+json+"   token->"+token);
        //log.info("send post request,url->{},params->{},token->{}",url,json,token);
        //RequestBody body = RequestBody.create(null, new byte[]{});
        RequestBody body = RequestBody.create(MediaType.parse(MEDIA_TYPE_JSON),json);
        Request request = new Request.Builder()
                .addHeader("Authorization",token)
                .addHeader("Content-Type",MEDIA_TYPE_JSON)
                .url(url)
                .post(body)
                .build();
        Response response ;
        try {

            /**
             * 忽略https证书的OkHttpClient
             * 新建一个OkHttpClient的单例模式
             */
            response = new OkHttpClient().newBuilder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    //.sslSocketFactory(SSLSocketClient.getSSLSocketFactory())
                    .hostnameVerifier(SSLSocketClient.getHostnameVerifier())
                    .build().newCall(request).execute();
            //response = client.newCall(request).execute();
            result = response.body().string();
            System.out.println("send post request,receive data->"+result);
            response.close();
            //log.info("send post request,receive data->{}",result);
            return result;
        } catch (IOException e) {
            //log.error("sendByPostJson error",e);
            System.out.println("sendByPostJson error"+e);
            return "kong";
        }
    }


//    public static String sendByPostTest(String url, String json,String token) {
//        String result;
//        //OkHttpClient client = new OkHttpClient();
//
//        if("".equals(token) || null == token){
//            token = COMPANY_PREFIX+ DateUtils.format("yyyyMMddHHmmssSSS");
//        }else {
//            token = "Bearer "+token;
//        }
//        System.out.println("send post request,url->"+url+"   params->"+json+"   token->"+token);
//        //log.info("send post request,url->{},params->{},token->{}",url,json,token);
//        RequestBody body = RequestBody.create(MediaType.parse(MEDIA_TYPE_JSON), json);
//        Request request = new Request.Builder()
//                .addHeader("Authorization",token)
//                .addHeader("Content-Type",MEDIA_TYPE_JSON)
//                .addHeader("User-Agent","Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:0.9.4)")
//                .addHeader("Accept-Language","zh-CN,zh;q=0.9")
//                .url(url)
//                .post(body)
//                .build();
//        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder.connectTimeout(30, TimeUnit.SECONDS);
//        builder.readTimeout(30, TimeUnit.SECONDS);
//        builder.writeTimeout(30, TimeUnit.SECONDS);
//        OkHttpClient client = builder.build();
//        Response response ;
//        try {
//            //response = OKHttpClientBuilder.buildOKHttpClient().connectTimeout(20, TimeUnit.SECONDS).readTimeout(20, TimeUnit.SECONDS).build().newCall(request).execute();
//            response = client.newCall(request).execute();
//            result = response.body().string();
//            System.out.println("send post request,receive data->{}"+result);
//            response.close();
//            //log.info("send post request,receive data->{}",result);
//            return result;
//        } catch (IOException e) {
//            //log.error("sendByPostJson error",e);
//            System.out.println("sendByPostJson error"+e);
//            return "kong";
//        }
//    }


}
