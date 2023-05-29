class ThreadPrimo extends Thread{

    private int start, end;

    public ThreadPrimo(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        final int max = 99999;
        final int range = 10000;

        for (int i = 0; i <= max; i += range){
            new ThreadPrimo(i, Math.min(i + range - 1, max)).start();
        }
    }
}

