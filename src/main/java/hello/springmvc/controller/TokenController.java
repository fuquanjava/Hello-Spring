package hello.springmvc.controller;

import hello.springmvc.token.TokenHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * fuquanemail@gamil.com
 * Date: 14-7-31 上午10:55
 */

@Controller
@RequestMapping("/token")
public class TokenController extends  BaseExceptionController{
    private static Logger logger = LoggerFactory.getLogger(TokenController.class);

    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response ,@RequestParam("name") String name) throws Exception{
        logger.info("name-----入参-----------=[{}]", name);
        TokenHandler.vaildToken(request); //token 验证
        Thread.sleep(5000);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        logger.info("name----------------=[{}]", name);
        return modelAndView;
    }

    @RequestMapping("/tosave")
    public String  beforeSave(HttpServletRequest request) throws  Exception{
        String guid = TokenHandler.generateGUID(request);
        request.setAttribute("tokenValue",guid);
        request.setAttribute("tokenName",TokenHandler.DEFAULT_TOKEN_NAME);
        logger.info("### beforeSave ... guid = [{}] ", guid);
        return "save";
    }

}
