package 转化;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-06-18 10:00
 **/

public class intToInteger {
    int iInt = 10;
    Integer iInteger = new Integer(iInt);

    int[] data = {1,2,3,4,5,6,7,8,9,10};
    // To boxed array
    Integer[] what = Arrays.stream( data ).boxed().toArray( Integer[]::new );
    Integer[] ever = IntStream.of( data ).boxed().toArray( Integer[]::new );

    // To boxed list
    List<Integer> you  = Arrays.stream( data ).boxed().collect( Collectors.toList() );
    List<Integer> like = IntStream.of( data ).boxed().collect( Collectors.toList() );
}
