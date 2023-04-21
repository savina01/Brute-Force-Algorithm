import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BruteForceAlg {
    // задаване на азбуката
    private static final char[] ALPHABET = {'a', 'b', 'c', 'd'};

    // задаване на дължината на комбинациите
    private static final int LENGTH = 4;

    public BruteForceAlg(String abc) {
    }

    public static void main(String[] args) throws InterruptedException {
        // определяне на броя процесори
        int numThreads = Runtime.getRuntime().availableProcessors();

        // създаване на ExecutorService
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        // изпълнение на функцията на всеки процесор
        for (int i = 0; i < numThreads; i++) {
            executorService.submit(new Task(i));
        }

        // изчакване на завършването на всички задачи
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }

    private static class Task implements Runnable {
        private final int start;

        public Task(int start) {
            this.start = start;
        }

        @Override
        public void run() {
            // намиране на всички комбинации
            for (int i = start; i < Math.pow(ALPHABET.length, LENGTH); i += Runtime.getRuntime().availableProcessors()) {
                StringBuilder sb = new StringBuilder();
                int j = i;
                for (int k = 0; k < LENGTH; k++) {
                    sb.append(ALPHABET[j % ALPHABET.length]);
                    j /= ALPHABET.length;
                }
                System.out.println(sb.toString());
            }
        }
    }
}
