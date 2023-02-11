package com.service.edu.controller.admin;

import com.service.base.result.R;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author hyj98
 * @Date 2023-02-04 17:16
 * @Version 1.0
 */
@RestController
@RequestMapping("/admin/edu/user")
@CrossOrigin
public class LoginController {

    /**
     * 登录，获取token
     * @return
     */
    @PostMapping("/login")
    public R login(){

        return R.ok().data("token","admin");
    }

    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("/info")
    public R getInfo(){
        Map<String,Object> map = new HashMap();
        map.put("roles","[admin]");
        map.put("name","admin");
        map.put("avatar","https://hyjedu-file.oss-cn-shanghai.aliyuncs.com/avatar/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20230106154634.jpg");
        return R.ok().data(map);
    }

}
