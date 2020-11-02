package com.example.loginregisterexample.Register;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

// 아이디 중복 확인
public class ValidateRequest extends StringRequest {
    final static private String URL="";
    private Map<String, String> map;


    // POST 방식
    public ValidateRequest(String NickName, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("NickName", NickName);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError{
        return map;
    }


}
