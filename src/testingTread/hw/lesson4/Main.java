package testingTread.hw.lesson4;

public class Main extends Thread{
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];
    static int numberThread = 0;

    public static void main(String[] args) {
        pullArray();
        divisionArray();
    }

    public static void pullArray() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время подсчета в 1 поток: " + (System.currentTimeMillis() - a));
    }


    Main(String name, float[] array){
        Thread t = new Thread(this, name);
        System.out.println("Thread is create: " + name);
        t.run();
    }

    private static void divisionArray() {
        long ab = System.currentTimeMillis();
        float[] newArr1 = new float[h];
        System.arraycopy(arr, 0, newArr1, 0, h);
        float[] newArr2 = new float[h];
        System.arraycopy(arr, h, newArr2, 0, h);
        System.out.println("Время разбивки массива на 2 части: " + (System.currentTimeMillis() - ab));

        Main thread1 = new Main("New Thread 1", newArr1){
            @Override
            public void run() {
                Main.countArray(newArr1, 0);
                Thread.interrupted();
            }
        };

        Main thread2 = new Main("New Thread 2", newArr1){
            @Override
            public void run() {
                Main.countArray(newArr2, h);
                Thread.interrupted();
            }
        };

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e){
            System.out.println("Аварийное завершение");
        }

        System.out.println("Время подсчета в 2 потока: " + (System.currentTimeMillis() - ab));
    }

    private static void countArray(float[] array, int startingPoint){
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.arraycopy(array, 0, arr, startingPoint, h);
    }

}
