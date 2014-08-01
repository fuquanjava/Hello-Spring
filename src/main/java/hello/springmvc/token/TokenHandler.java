package hello.springmvc.token;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * fuquanemail@gamil.com
 * Date: 14-7-31 上午10:00
 */
public class TokenHandler {

    private  static Logger logger = LoggerFactory.getLogger(TokenHandler.class);

    public  static String DEFAULT_TOKEN_NAME="springmvc.token";

    /**
     *
     * @param request 生成token , 并放入session
     * @return
     */
    public synchronized static String generateGUID(HttpServletRequest request){
        HttpSession session = request.getSession();
        try {
            byte id[] = session.getId().getBytes();
            byte now[] = new Long(System.currentTimeMillis()).toString().getBytes();
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(id);
            md.update(now);
            BASE64Encoder encoder = new BASE64Encoder();
            String guid = encoder.encode(md.digest());
            logger.info("### generateGUID:"+guid);

            session.setAttribute(DEFAULT_TOKEN_NAME,guid);

            return  guid;

        } catch (NoSuchAlgorithmException e) {
            logger.info("### generateGUID ",e.getMessage());
        }
        return  null;
    }

    /**
     *
     * @param request 获取表单提交的token值
     * @return
     */
    public static  String getInputToken(HttpServletRequest request){
        Map params = request.getParameterMap();
        if(!params.containsKey(DEFAULT_TOKEN_NAME)){
            logger.warn("请求的request参数中 没有Token ");
            return  null;
        }
        // request: t1=1&t1=2&t2=3
        // request.getParameterMap() : key=t1 ; value[0]=1, value[1]=2 . key 是一个String , value 是一个String[]
        String [] tokenValues = (String[]) params.get(DEFAULT_TOKEN_NAME);

        if(null == tokenValues|| tokenValues.length == 0){
            logger.warn("请求的request 中 token 没有值!");
            return null;
        }

        logger.info("### getInputToken tokenValues:"+tokenValues[0]);
        return  tokenValues[0];
    }

    /**
     *
     * @param request 验证token
     * @return true:通过验证, false :没通过
     */
    public static void vaildToken(HttpServletRequest request) throws Exception{
        String token = getInputToken(request);
        if (null == token){
            logger.warn("vaildToken 验证失败,没有token");
            throw  new RuntimeException("验证失败,稍后重试");
        }
        HttpSession session = request.getSession();
        String sessionToken = (String) session.getAttribute(DEFAULT_TOKEN_NAME);
        if(! token.equals(sessionToken)){
           logger.warn("vaildToken 验证失败,sessionToken =[{}] , reqeustToken= [{}]",sessionToken,token);
            throw new RuntimeException("验证失败,请不要重复提交");
        }
        session.removeAttribute(DEFAULT_TOKEN_NAME);
    }
}
