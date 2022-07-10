package ru.netology;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;

public class Main {
    public static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build();
        String key = "2MxdhCPP9ZlRhMpl2yzooZTG2ldWePt5mVbGlOhu";
        HttpGet request = new HttpGet("https://api.nasa.gov/planetary/apod?api_key=" + key);
        CloseableHttpResponse response = httpClient.execute(request);

        Post post = mapper.readValue(response.getEntity().getContent(), new TypeReference<>() {
        });

        String url = post.getHdurl();

        String[] split = url.split("/");
        String filename = "/home/alexandra/Pictures/" + split[split.length - 1];

        HttpGet request2 = new HttpGet(url);
        CloseableHttpResponse response2 = httpClient.execute(request2);

        InputStream in = response2.getEntity().getContent();
        FileOutputStream fos = new FileOutputStream(filename);
        byte[] buf = new byte[1024];
        int n;
        while (-1 != (n = in.read(buf))) {
            fos.write(buf, 0, n);
        }
        fos.close();
        in.close();
    }
}
