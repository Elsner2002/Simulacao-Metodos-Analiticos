public class NumberGenerator {

    private static double xi = 123;  // Semente inicial
    private static final double a = 1664525;
    private static final double c = 1013904223;
    private static final double M = Math.pow(2, 32);
    public static int count = 0;

    static double nextRandom() {
        count--;
        xi = (a * xi + c) % M;
        xi = xi / M;
        return xi;
    }

    static double nextRandom(double min, double max) {
        return min + (max - min) * nextRandom();
    }
}