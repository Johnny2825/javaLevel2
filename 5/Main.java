public class Main {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) throws InterruptedException {
        float[] arr = new float[SIZE];

        double a = System.currentTimeMillis();
        calculation(oneInArr(arr));
        System.out.println("Time: " + (System.currentTimeMillis() - a));
        System.out.println(arr[0] + " " + arr[HALF - 1] + " " + arr[SIZE - 1]);

        a = System.currentTimeMillis();
        withThread(oneInArr(arr));
        System.out.println("Time: " + (System.currentTimeMillis() - a));
        System.out.println(arr[0] + " " + arr[HALF - 1] + " " + arr[SIZE - 1]);

    }

    public static float[] oneInArr(float[] tmpArr){
        for(int i = 0; i < SIZE; i++){
            tmpArr[i] = 1;
        }
        return tmpArr;
    }

    public static void calculation(float[] tmpArr){
        for(int i = 0; i < tmpArr.length; i++){
            tmpArr[i] = (float)(tmpArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public static void withThread(float[] tmpArr) throws InterruptedException {
        float[] a = new float[HALF];
        float[] b = new float[HALF];
        System.arraycopy(tmpArr, 0, a, 0, HALF);
        System.arraycopy(tmpArr, HALF, b, 0, HALF);

        Thread thread1 = new Thread(() -> calculation(a));

        Thread thread2 = new Thread(() -> calculation(b));

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.arraycopy(a, 0, tmpArr, 0, HALF);
        System.arraycopy(b, 0, tmpArr, HALF, HALF);
    }
}
