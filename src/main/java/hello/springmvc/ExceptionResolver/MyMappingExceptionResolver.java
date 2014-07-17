package hello.springmvc.ExceptionResolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * fuquanemail@gamil.com
 * Date: 14-7-13 下午9:15
 */
public class MyMappingExceptionResolver implements HandlerExceptionResolver {
    private Logger log = LoggerFactory.getLogger(MyMappingExceptionResolver.class);
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                         Object handler, Exception ex) {
        log.info("### MyMappingExceptionResolver###resolveException ### 开始解析异常");
        String clazzName = ex.getClass().getSimpleName();
        log.info("### MyMappingExceptionResolver###resolveException ### clazzName:"+clazzName);
        Map<String , Object> model = new HashMap<String, Object>();
        model.put("ex", ex); //存储 excpetion
        ModelAndView modelAndView;
        if (ex instanceof  NullPointerException) {
            modelAndView = new ModelAndView("nullPointer", model);
        }else if (ex instanceof NumberFormatException) {
            modelAndView = new ModelAndView("numberFormat", model);
        }else {
            modelAndView = new ModelAndView("error", model);
        }
        // 根据不同错误转向不同页面
        return  modelAndView;
    }
}
