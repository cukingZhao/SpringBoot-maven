package com.cuking;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cuking on 2017/1/4.
 */
@Controller
@EnableTransactionManagement
public class HelloController {

    @RequestMapping("/")
    @ResponseBody
    public String sayhello() {
        return "Hello World";
    }

    @RequestMapping("/index")
    public String index(ModelMap map) {

        //添加属性
        map.put("imgUrl","http://www.gxcards.com/app/common/img/common_logo.png");
        //模板的文件名称
        return "index";
    }
}
