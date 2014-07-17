package hello.springmvc.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * fuquanemail@gamil.com
 * Date: 14-7-13 下午3:55
 */
public class SomeInterceptor implements HandlerInterceptor{

    private Logger log = LoggerFactory.getLogger(SomeInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("### SomeInterceptor ###  preHandle ### controller之前调用 ");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("### SomeInterceptor ###  postHandle ### controller之后调用 ");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("### SomeInterceptor ###  postHandle ### 请求处理完成之后调用,view 已经返回给client ");
    }
}
