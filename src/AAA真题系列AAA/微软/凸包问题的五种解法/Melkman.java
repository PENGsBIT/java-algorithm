package AAA真题系列AAA.微软.凸包问题的五种解法;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-16 16:16
 **/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zpc
 * @Description:
 * @Create: 2019-09-16 16:16
 **/


public class Melkman {


    private Point[] pointArray;//坐标数组
    private final int N;//数据个数
    private int D[]; // 数组索引

    public Melkman(List<Point> pList) {
        this.pointArray = new Point[pList.size()];
        N = pList.size();
        int k = 0;
        for (Point p : pList) {
            pointArray[k++] = p;
        }
        D = new int[2 * N];
    }

    /**
     * 求凸包点
     *
     * @return 所求凸包点
     */
    public Point[] getTubaoPoint() {
        // 获得最小的Y，作为P0点
        float minY = pointArray[0].getY();
        int j = 0;
        for (int i = 1; i < N; i++) {
            if (pointArray[i].getY() < minY) {
                minY = pointArray[i].getY();
                j = i;
            }
        }
        swap(0, j);

        // 计算除第一顶点外的其余顶点到第一点的线段与x轴的夹角
        for (int i = 1; i < N; i++) {
            pointArray[i].setArCos(angle(i));
        }

        quickSort(1, N - 1); // 根据所得到的角度进行快速排序

        int bot = N - 1;
        int top = N;
        D[top++] = 0;
        D[top++] = 1;
        int i;

        for (i = 2; i < N; i++) {// 寻找第三个点 要保证3个点不共线！！
            if (isLeft(pointArray[D[top - 2]], pointArray[D[top - 1]],
                    pointArray[i]) != 0)
                break;
            D[top - 1] = i; // 共线就更换顶点
        }

        D[bot--] = i;
        D[top++] = i; // i是第三个点 不共线！！

        int t;
        if (isLeft(pointArray[D[N]], pointArray[D[N + 1]], pointArray[D[N + 2]]) < 0) {
            // 此时队列中有3个点，要保证3个点a,b,c是成逆时针的，不是就调换ab
            t = D[N];
            D[N] = D[N + 1];
            D[N + 1] = t;
        }

        for (i++; i < N; i++) {
            // 如果成立就是i在凸包内，跳过 //top=n+3 bot=n-2
            if (isLeft(pointArray[D[top - 2]], pointArray[D[top - 1]],
                    pointArray[i]) > 0
                    && isLeft(pointArray[D[bot + 1]], pointArray[D[bot + 2]],
                    pointArray[i]) > 0) {
                continue;
            }

            //非左转 则退栈
            while (isLeft(pointArray[D[top - 2]], pointArray[D[top - 1]],
                    pointArray[i]) <= 0) {
                top--;
            }
            D[top++] = i;

            //反向表非左转 则退栈
            while (isLeft(pointArray[D[bot + 1]], pointArray[D[bot + 2]],
                    pointArray[i]) <= 0) {
                bot++;
            }
            D[bot--] = i;
        }

        // 凸包构造完成，D数组里bot+1至top-1内就是凸包的序列(头尾是同一点)
        Point[] resultPoints = new Point[top - bot - 1];
        int index = 0;
        for (i = bot + 1; i < top - 1; i++) {
            System.out.println(pointArray[D[i]].getX() + ","
                    + pointArray[D[i]].getY());
            resultPoints[index++] = pointArray[D[i]];
        }
        return resultPoints;
    }

    /**
     * 判断ba相对ao是不是左转
     *
     * @return 大于0则左转
     */
    private float isLeft(Point o, Point a, Point b) {
        float aoX = a.getX() - o.getX();
        float aoY = a.getY() - o.getY();
        float baX = b.getX() - a.getX();
        float baY = b.getY() - a.getY();

        return aoX * baY - aoY * baX;
    }

    /**
     * 实现数组交换
     *
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        Point tempPoint = new Point();
        tempPoint.x=pointArray[j].getX();
        tempPoint.y=pointArray[j].getY();
        tempPoint.setArCos(pointArray[j].getArCos());

        pointArray[j].x=pointArray[i].getX();
        pointArray[j].y=pointArray[i].getY();
        pointArray[j].setArCos(pointArray[i].getArCos());

        pointArray[i].x=tempPoint.getX();
        pointArray[i].y=tempPoint.getY();
        pointArray[i].setArCos(tempPoint.getArCos());
    }

    /**
     * 快速排序
     *
     * @param top
     * @param bot
     */
    private void quickSort(int top, int bot) {
        int pos;
        if (top < bot) {
            pos = loc(top, bot);
            quickSort(top, pos - 1);
            quickSort(pos + 1, bot);
        }
    }

    /**
     * 移动起点，左侧为小，右侧为大
     *
     * @param top
     * @param bot
     * @return 移动后的位置
     */
    private int loc(int top, int bot) {
        double x = pointArray[top].getArCos();
        int j, k;
        j = top + 1;
        k = bot;
        while (true) {
            while (j < bot && pointArray[j].getArCos() < x)
                j++;
            while (k > top && pointArray[k].getArCos() > x)
                k--;
            if (j >= k)
                break;
            swap(j, k);
        }
        swap(top, k);
        return k;
    }

    /**
     * 角度计算
     *
     * @param i 指针
     * @return
     */
    private double angle(int i) {
        double j, k, m, h;
        j = pointArray[i].getX() - pointArray[0].getX();
        k = pointArray[i].getY() - pointArray[0].getY();
        m = Math.sqrt(j * j + k * k); // 得到顶点i 到第一顶点的线段长度
        if (k < 0)
            j = (-1) * Math.abs(j);
        h = Math.acos(j / m); // 得到该线段与x轴的角度
        return h;
    }

    public static void main(String args[]) {
        // File file = new File("G:/yl.txt");
        File file = new File("G:/data.txt");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Point> pointList = new ArrayList<Point>();
        String str = null;
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (str != null) {
            String[] s = str.split("\\t", 2);
            float x = Float.parseFloat(s[0].trim());
            float y = Float.parseFloat(s[1].trim());
            Point p = new Point();
            p.x= (int) x;
            p.y=(int)y;
            // System.out.println("文件数据：" + x + ", " + y);
            pointList.add(p);
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("数据个数：" + pointList.size());

        Melkman m = new Melkman(pointList);
        m.getTubaoPoint();
    }

}
