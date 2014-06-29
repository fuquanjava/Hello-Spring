package hello.junit;

/**
 * fuquanemail@gamil.com
 * Date: 14-6-28 下午2:56
 */
public class Foo {

    public int add (int a, int b){
        return a  + b;
    }

    public int minus(int a, int b){
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return a - b;
    }

    public int divide(int a, int b){
        if (b == 0){
            throw  new IllegalArgumentException(b+"的值不能为0");
        }
        return a / b;

    }
}
