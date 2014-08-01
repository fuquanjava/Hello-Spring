package hello.spring.mybatis;

/**
 * 定义一个注解，只有注解的mapper 才会被处理
 * Date: 14-7-19 下午4:51
 */
public @interface MyBatisComponentAnnotation {
    String value() default "";
}
