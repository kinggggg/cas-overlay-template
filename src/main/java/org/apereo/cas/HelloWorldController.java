package org.apereo.cas;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: weibo_li
 * @since: 2018-02-01 下午5:42
 */
@Controller
public class HelloWorldController {

    @RequestMapping(value = "/world1")
    public String helloWorld() {

        return "helloworld/helloworld";
    }

}
