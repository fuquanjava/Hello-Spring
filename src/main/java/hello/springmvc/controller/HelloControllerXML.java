package hello.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller组件约定的handleRequest方法执行后返回一个ModelAndView对象，
 * 该对象可封装模型数据和视图名响应信息
 */
public class HelloControllerXML implements Controller {

    private Logger log = LoggerFactory.getLogger(HelloControllerXML.class);

    public HelloControllerXML(){
        log.info("##################实例化 [{}]" ,this.getClass().getSimpleName());
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info("执行 handleRequest, 处理请求...");
        String uri = request.getRequestURI();
        log.info("请求uri:"+uri);

        // 模仿异常
        String s = null;
        int i = s.length();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");

        return  modelAndView;
    }
}
