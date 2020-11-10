package com.example.loginregisterexample.LogIn;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {
    private final static String URL = "http://k3a304.p.ssafy.io:8399/api/account/login";
    private Map<String,String> map;

    public LoginRequest(String user_id, String user_pw, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(Request.Method.POST, URL, listener, errorListener);

        map = new HashMap<>();
        map.put("email",user_id);
        map.put("password",user_pw);

    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String>  params = new HashMap<String, String>();
        params.put("User-Agent", "Nintendo Gameboy");
        params.put("Accept-Language", "fr");

        return params;
    }
}
