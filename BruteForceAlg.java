import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BruteForceAlg {

    private String alphabet;

    public BruteForceAlg(String alphabet) {
        this.alphabet = alphabet;
    }

    public String generate(int length) {
        StringBuilder sb = new StringBuilder();
        generateRecursive(sb, length);
        return sb.toString();
    }

    private void generateRecursive(StringBuilder sb, int length) {
        if (length == 0) {
            sb.append("\n");
            return;
        }

        for (int i = 0; i < alphabet.length(); i++) {
            char c = alphabet.charAt(i);
            sb.append(c);
            generateRecursive(sb, length - 1);
            sb.setLength(sb.length() - 1);
        }
    }
}
