package com.example.loginregisterexample.Register;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class NicknameValidate extends StringRequest {

    final static private String URL="";

    // GET 방식
    public NicknameValidate(String NickName, Response.Listener<String> listener){
        super(Method.GET, URL, listener, null);

    }


}
