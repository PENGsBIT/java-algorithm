public class 洗牌算法 {


    public static void main(String[] args) {
        int[] data = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        print(data);
        shuffleSort(data);
        System.out.println("排序后的数组：");
        print(data);
    }

    public static void swap(int[] data, int i, int j) {
        if (i == j) {
            return;
        }
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }

    public static void shuffleSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int j = (int) (data.length * Math.random());
            swap(data, i, j);
        }
    }

    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }


}
