package lesson6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OkHttpExemples {

    public static void main(String[] args) throws IOException {
        OkHttpExemples okHttpExemples = new OkHttpExemples()
                .newBuilder()
                .readTimeout(10, TimeUnit. SECONDS)
                .build;

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("https")
                .host("gb.ru")
                .addPathSegments("/courses")
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .build();

        Response response = OkHttpClient.newCall(request).execute();

        System.out.println(response.code());
        System.out.println(response.headers());
        System.out.println(response.body().string());

    }
}








