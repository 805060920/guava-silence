package com.silence.ex.bussiness;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @auth yang
 * @Description
 * @Date 2020/9/2
 */
public class HttpUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static final MediaType MEDIA_TYPE_MARKDOWN
            = MediaType.parse("text/x-markdown; charset=utf-8");

    private final static OkHttpClient client = new OkHttpClient();

    public static void postRes() throws Exception {

        OkHttpClient okHttpClient = new OkHttpClient();

        Map<String, String> foo = new HashMap<String, String>();
        foo.put("name", "HTTP");
        foo.put("age", "18");

        Request request = new Request.Builder().url("http://m.ctrip.com/restapi/soa2/20508/updateJob")
                .post(RequestBody.create(MediaType.parse("application/json"), "{\"rankingId\":13420090209467}")).build();
        Response response = okHttpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            System.out.println("su");
        } else {
            System.out.println("fal");
        }
    }

}
