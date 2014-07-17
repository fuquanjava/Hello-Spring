package hello.springmvc.controller;

import hello.springmvc.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * fuquanemail@gamil.com
 * Date: 14-7-13 下午2:38
 */

@Controller
@RequestMapping("/user")
public class HelloControllerAnnotation  {

    private Logger log = LoggerFactory.getLogger(HelloControllerAnnotation.class);

    @RequestMapping("/toLogin")
    public String toLogin(){
        log.info("###HelloControllerAnnotation #### user ### toLotin ");
        return "login";
    }

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam("name") String userName ,
                              @RequestParam("pwd") String password ) throws  Exception{
        log.info("userName:"+userName);
        log.info("password:"+password);
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("user", userName);
        return new ModelAndView("main" , data);
    }

    @RequestMapping("/login2")
    public ModelAndView login2(@ModelAttribute ("user")User user,BindingResult bindingResult) throws  Exception{

        int errorCount = bindingResult.getErrorCount();
        log.info("#### errorCount:  [{}] ###  " , errorCount);


        if (bindingResult.hasErrors()){ //存在没有通过验证的字段
            List<ObjectError> erros =  bindingResult.getAllErrors ();
            for(ObjectError error : erros){
                log.info("#### error.getObjectName() :  [{}] ###  " , error.getObjectName());
                log.info("#### error.getDefaultMessage() :  [{}] ###  " , error.getDefaultMessage());
            }
            return new ModelAndView("login");
        }

        log.info("userName:"+user.getName());
        log.info("password:"+user.getPassword());
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("user", user.getName());
        return new ModelAndView("main");
    }


    @RequestMapping("/a")
    public RedirectView  a() throws Exception{
        //重定向View
        RedirectView view = new RedirectView("toLogin");
        return view;
    }

    @RequestMapping("/b")
    public String  b() throws Exception{
        //重定向View
        return "redirect:toLogin";
    }

}
