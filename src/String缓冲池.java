/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-06-24 21:37
 **/

public class String缓冲池 {
    public static void main(String[] args) {
        String s = new String("abc");
        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = "abc";
        //String s = new String("abc"); 这句,创建了两个对象..其内容都是"abc".注意,
        //s 不是对象,只是引用.只有 new 生成的才是对象.
        //创建的流程是,首先括号里的"abc"先到 String pool 里看有没"abc"这个对象,没有
        //则在 pool 里创建这个对象..所以这里就在 pool 创建了一个"abc"对象.然后 通过
        //new 语句又创建了一个"abc"对象..而这个对象是放在内存的堆里. .这里的 s 指
        //向堆里的对象.
        System.out.println(s == s1);//false
        System.out.println(s == s2);//false
        System.out.println(s1 == s2);//flase
        System.out.println(s1 == s3);//true
        //上面已经说明了,hello hel lo 这三个都是指向 pool 中的对象..
        //现在我们考虑"hel" + "lo" 按照内容来说,两个相加也就是"hello".这个时候,这个会
        //返回 pool 中的"hello"对象.所以,hello == "hel" + "lo" 返回的是 true .
        //而"hel" + lo 虽然内容也是"hello",但是它将在堆里面生成一个"hello"对象,并返回
        //这个对象...所以这里的结果是 false
        String hello = "hello";
        String hel = "hel";
        String lo = "lo";
        System.out.println(hello == "hel" + "lo");//true
        System.out.println(hello == "hel" + lo);//false

        //Integer中有个静态内部类IntegerCache，里面有个cache[],
        // 也就是Integer常量池，常量池的大小为一个字节（-128~127）。
        //创建  1 个对象，存放在常量池中。引用c1,c2存放在栈内存中。
        Integer c1 = 1;
        Integer c2 = 1;
        System.out.println("c1 = c2 ? " + (c1 == c2)); //true

        //创建 2  个对象，存放在堆内存中。2 个引用存放在栈内存中。
        Integer b1 = 130; //130不在(-128~127)之间
        Integer b2 = 130;
        System.out.println("b1 = b2 ? " + (b1 == b2)); //false

        //创建2个对象，存放在堆内存中。
        Integer b3 = new Integer(2);
        Integer b4 = new Integer(2);
        System.out.println("b3 = b4 ? " + (b3 == b4));  //false
        //下面两行代码证明了使用new Integer(int i) (i 在-128~127之间)创建对象不会保存在常量池

    }
}
