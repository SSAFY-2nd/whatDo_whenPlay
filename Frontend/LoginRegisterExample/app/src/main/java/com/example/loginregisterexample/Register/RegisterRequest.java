package com.example.loginregisterexample.Register;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

// 회원가입 값 요청
public class RegisterRequest extends StringRequest {

    final static private String URL = "";
    private Map<String, String> map;
    //private Map<String, String> parameters;

    // 이름, 닉네임, 이메일, 비밀번호, 비밀번호 확인
    public RegisterRequest(String UserName, String NickName, String UserEmail, String UserPwd, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("UserName", UserName);
        map.put("NickName", NickName);
        map.put("UserEmail", UserEmail);
        map.put("UserPwd", UserPwd);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError{
        return map;
    }


}
