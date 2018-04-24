package com.demo.demologin.utils;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

public class WebClientUtil {

    private static final MediaType MEDIATYPE = MediaType.APPLICATION_JSON_UTF8;

    /**
     * @param paramter   请求参数
     * @param url        请求路径
     * @param resultType 返回结果类型
     * @return
     */
    public static <V> V post(Object paramter, String url, Class<V> resultType) {

        return post(uri(url, HttpMethod.POST), paramter, resultType);
    }

    /**
     * @param paramter   请求参数
     * @param url        请求路径
     * @param header     请求头
     * @param resultType 返回结果类型
     * @return
     */
    public static <V> V post(Object paramter, String url, Map<String, String> header, Class<V> resultType) {

        WebClient.RequestBodySpec uri = uri(url, HttpMethod.POST);
        addHeader(header, uri);
        return post(uri, paramter, resultType);
    }

    private static <V> V post(WebClient.RequestBodySpec uri, Object paramter, Class<V> resultType) {

        return uri.contentType(MEDIATYPE).body(Mono.just(paramter), Object.class).retrieve().bodyToMono(resultType)
                .block();
    }

    /**
     * @param url        请求路径
     * @param resultType 返回结果类型
     * @return
     */
    public static <V> V get(String url, Class<V> resultType) {

        return uri(url, HttpMethod.GET).retrieve().bodyToMono(resultType).block();
    }

    /**
     * @param url        请求路径
     * @param header     请求头
     * @param resultType 返回结果类型
     * @return
     */
    public static <V> V get(String url, Map<String, String> header, Class<V> resultType) {

        WebClient.RequestBodySpec uri = uri(url, HttpMethod.GET);
        addHeader(header, uri);
        return uri.retrieve().bodyToMono(resultType).block();
    }

    private static WebClient.RequestBodySpec uri(String url, HttpMethod method) {

        return WebClient.create().method(method).uri(url);
    }

    private static void addHeader(Map<String, String> header, WebClient.RequestBodySpec uri) {

        if (!CollectionUtils.isEmpty(header)) {
            header.forEach((name, value) -> uri.cookie(name, value));
        }
    }
}