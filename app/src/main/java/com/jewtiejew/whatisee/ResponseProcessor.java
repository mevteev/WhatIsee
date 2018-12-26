package com.jewtiejew.whatisee;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

import static java.net.HttpURLConnection.HTTP_OK;

public class ResponseProcessor {

    private final HttpURLConnection httpURLConnection;

    public ResponseProcessor(HttpURLConnection httpURLConnection) {
        this.httpURLConnection = httpURLConnection;
    }

    public int getStatus() throws IOException {
        return httpURLConnection.getResponseCode();
    }

    public boolean isOk() throws IOException {
        return getStatus() == HTTP_OK;
    }

    public InputStream getBody() throws IOException {
        return httpURLConnection.getInputStream();
    }

    public InputStream getErrorStream() {
        return httpURLConnection.getErrorStream();
    }

    public Map<String, List<String>> getHeaders() {
        return httpURLConnection.getHeaderFields();
    }

    public String getHeader(String header) {
        return httpURLConnection.getHeaderField(header);
    }
}
