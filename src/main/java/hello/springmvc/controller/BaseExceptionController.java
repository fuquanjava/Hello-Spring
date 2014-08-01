package hello.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * fuquanemail@gamil.com
 * Date: 14-7-13 下午9:52
 */
public class BaseExceptionController {
    private Logger log = LoggerFactory.getLogger(BaseExceptionController.class);
    @ExceptionHandler ({NullPointerException.class , NumberFormatException.class ,Exception.class}) //指定异常类型
    public String executeException(HttpServletRequest request ,Exception e){
        request.setAttribute("ex" , e);
        log.info("###BaseExceptionController ### executeException  e:"+e.getMessage());
        //可根据异常类型不同返回不同视图名
        return  "error";
    }
}
