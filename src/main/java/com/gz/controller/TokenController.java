package com.gz.controller;

import com.gz.annotation.NoneAuth;
import com.gz.entity.JsonData;
import com.gz.enums.HttpStatusEnum;
import com.gz.utils.token.TokenHelper;
import com.gz.utils.token.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private TokenHelper tokenHelper;

    @NoneAuth
    @GetMapping
    public Object login(String username, String password) {
        Map<String,String> user = new HashMap<>();
        user.put("id","1");
        user.put("name","xm");
        user.put("password","123456");
        if(user == null || !user.get("password").equals(password)) {
            return JsonData.buildError(HttpStatusEnum.NOT_FOUND.getCode(), "\"用户不存在或密码错误\"");
        }
        //用户名密码验证通过后，生成token
        TokenModel model = tokenHelper.create(Integer.valueOf(user.get("id")));
        return JsonData.buildSuccess(model);
    }

    @DeleteMapping
    public Object logout(HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("userId");
        if(userId != null) {
            tokenHelper.delete(userId);
        }
        return JsonData.buildSuccess();
    }

}
