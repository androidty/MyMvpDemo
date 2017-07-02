package com.ty.android.mymvpdemo.utils;

import android.net.Uri;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Android on 2017/6/19.
 */

public class ShowApiUtils {
    public static String APP_ID="31834";
    public static String APP_SECRET="448dec58606a42e0a3cca69a97620c53";
    public static String ADDRESS ="http://route.showapi.com/1211-1";

    public static String getApiRequest(String addressUrl){
        String url = Uri.parse(addressUrl).buildUpon().appendQueryParameter("showapi_appid",APP_ID)
                .appendQueryParameter("showapi_sign",APP_SECRET).build().toString();
        return url;
    }

    /**
     * 得到返回的json数据 字符串
     * @param httpUrl
     * @return
     */
    public static String getData(String httpUrl){
        String resultJson;
        BufferedReader bufferedReader;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            URL url = new URL(getApiRequest(httpUrl));
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setRequestMethod("GET");
            urlConn.connect();
            InputStream is = urlConn.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(is,"utf-8"));
            String str = "";
            while ((str=bufferedReader.readLine())!=null){
                stringBuffer.append(str);
                stringBuffer.append("\r\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        resultJson = stringBuffer.toString();
        return resultJson;
    }

    /**
     * json 解析成所需的字符串
     */
    public static String parseJsonResult(String resultJson){
        String englishResult="" ;
        String chineseResult="" ;
        try {
            JSONObject jsonObject = new JSONObject(resultJson);
            JSONObject resJson = jsonObject.getJSONObject("showapi_res_body");
            JSONArray jsonArray = resJson.getJSONArray("data");
            JSONObject result = jsonArray.getJSONObject(0);
            englishResult = result.getString("english");
            chineseResult = result.getString("chinese");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return chineseResult;
    }
}
