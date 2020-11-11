package com.example.loginregisterexample.Playwithme;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class FriendCheckRequest extends StringRequest {
    private final static String URL = "http://k3a304.p.ssafy.io:8399/api/account/info";
    private Map<String,String> map;

    public FriendCheckRequest(String friend_id, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(Method.GET, URL, listener, errorListener);
    }



}
