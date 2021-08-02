import java.util.ArrayList;
import java.util.Arrays;

public class HomeWorkMultithreading {
    /*
    2) Заполняют этот массив единицами;
    3) Засекают время выполнения: long a = System.currentTimeMillis();
    4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
    arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    5) Проверяется время окончания метода System.currentTimeMillis();
    6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
     */

    static final int size = 10000000;
    static final int h = size / 2;


    public static void main(String[] args) {
        method1();
        method2();

    }

    public static void method1 () {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        long start = System.currentTimeMillis();

        for (int i = 0; i < arr.length;i++ ) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long end = System.currentTimeMillis();

        System.out.println("method1 finish, total time: " + (end - start));
    }


    public static void method2() {

        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        long start = System.currentTimeMillis();

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t1 = new Thread(() -> {
           for (int i = 0; i < a1.length; i++) {
               a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
           }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < a2.length; i++) {
                a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("arrays equal: "  + Arrays.equals(a1,a2));

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        long end = System.currentTimeMillis();

        System.out.println("method1 finish, total time: " + (end - start));
    }

}
