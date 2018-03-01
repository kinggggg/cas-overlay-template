package org.apereo.cas.controller;

import org.apereo.cas.viewmodel.SsoCookie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class ServerController {

    @RequestMapping(value = "/accessControl", method = RequestMethod.GET)
    @ResponseBody
    public Object accessControl(HttpServletRequest httpServletRequest, HttpServletResponse httpResponse) throws Exception {

        httpResponse.setHeader("Access-Control-Allow-Origin", " http://sso.frontend1.com:3000");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");

        List<SsoCookie> ssoCookies = new ArrayList<>();
        if(httpServletRequest.getCookies() != null && httpServletRequest.getCookies().length > 0) {
            Arrays.stream(httpServletRequest.getCookies()).forEach(cookie -> {
                SsoCookie ssoCookie = new SsoCookie();
                ssoCookie.setName(cookie.getName());
                ssoCookie.setValue(cookie.getValue());

                ssoCookies.add(ssoCookie);
            });
        }

        return ssoCookies;

    }

}
