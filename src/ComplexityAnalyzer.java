import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Empirical time-complexity analyzer.
 *
 * Drop this class into any Java project and call analyze() on your methods.
 * It runs your code with doubling input sizes, measures wall-clock time,
 * and infers the Big-O class from the growth ratio.
 *
 * Usage:
 *   ComplexityAnalyzer.analyze("mySort", n -> generateArray(n), arr -> mySort(arr));
 */
public class ComplexityAnalyzer {

    // Input sizes used for measurement (each doubles the previous)
    private static final int[] SIZES = {100, 200, 400, 800, 1600, 3200, 6400, 12800};

    private static final int WARMUP_RUNS   = 5;   // JIT warm-up iterations
    private static final int MEASURE_RUNS  = 7;   // Timed iterations (median taken)

    // -------------------------------------------------------------------------
    // Public API
    // -------------------------------------------------------------------------

    /**
     * Analyzes the time complexity of a method that consumes a single input.
     *
     * @param label     Display name shown in the report
     * @param inputGen  Produces an input of size n  (e.g. n -> new int[n])
     * @param method    The method under test         (e.g. arr -> Arrays.sort(arr))
     */
    public static <T> void analyze(String label,
                                   Function<Integer, T> inputGen,
                                   Consumer<T> method) {
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.printf ("║  Analyzing: %-32s║%n", label);
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.printf ("║  %-8s  %-14s  %-18s║%n", "n", "avg time (ns)", "doubling ratio");
        System.out.println("╠══════════════════════════════════════════════╣");

        long[] times = new long[SIZES.length];

        for (int i = 0; i < SIZES.length; i++) {
            int n = SIZES[i];
            T input = inputGen.apply(n);

            // JIT warm-up (not measured)
            for (int w = 0; w < WARMUP_RUNS; w++) {
                method.accept(input);
            }

            // Collect timed runs
            long[] runs = new long[MEASURE_RUNS];
            for (int r = 0; r < MEASURE_RUNS; r++) {
                T freshInput = inputGen.apply(n);   // fresh input each run
                long start = System.nanoTime();
                method.accept(freshInput);
                runs[r] = System.nanoTime() - start;
            }

            times[i] = median(runs);

            String ratio = (i == 0)
                    ? "  —  (baseline)"
                    : String.format("%.2fx", (double) times[i] / times[i - 1]);

            System.out.printf("║  %-8d  %-14s  %-18s║%n",
                    n,
                    String.format("%,d", times[i]),
                    ratio);
        }

        String bigo   = inferComplexity(times);
        String reason = explainRatio(times);

        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.printf ("║  Inferred: %-34s║%n", bigo);
        System.out.printf ("║  Reason  : %-34s║%n", reason);
        System.out.println("╚══════════════════════════════════════════════╝");
    }

    // -------------------------------------------------------------------------
    // Inference logic
    // -------------------------------------------------------------------------

    /**
     * When n doubles:
     *   O(1)       → ratio ≈ 1.0
     *   O(log n)   → ratio ≈ 1.0 + small constant (approaches 1)
     *   O(n)       → ratio ≈ 2.0
     *   O(n log n) → ratio ≈ 2.1 – 2.3
     *   O(n²)      → ratio ≈ 4.0
     *   O(n³)      → ratio ≈ 8.0
     *   O(2^n)     → ratio grows without bound
     */
    private static String inferComplexity(long[] times) {
        double ratio = stableRatio(times);
        if (ratio < 1.15) return "O(1)       — Constant";
        if (ratio < 1.65) return "O(log n)   — Logarithmic";
        if (ratio < 2.65) return "O(n)       — Linear";
        if (ratio < 3.50) return "O(n log n) — Linearithmic";
        if (ratio < 6.50) return "O(n²)      — Quadratic";
        if (ratio < 13.0) return "O(n³)      — Cubic";
        return             "O(2^n)+    — Exponential (or worse)";
    }

    private static String explainRatio(long[] times) {
        double ratio = stableRatio(times);
        return String.format("avg doubling ratio = %.2fx  (ideal O(n)=2x, O(n²)=4x)", ratio);
    }

    /**
     * Uses the median of the last half of doubling ratios (steadier after JIT).
     */
    private static double stableRatio(long[] times) {
        int last = times.length - 1;
        int start = times.length / 2;          // skip early noisy measurements
        double sum = 0;
        int count = 0;
        for (int i = start; i <= last; i++) {
            if (times[i - 1] > 0) {
                sum += (double) times[i] / times[i - 1];
                count++;
            }
        }
        return count == 0 ? 1.0 : sum / count;
    }

    private static long median(long[] values) {
        long[] copy = Arrays.copyOf(values, values.length);
        Arrays.sort(copy);
        return copy[copy.length / 2];
    }

    // -------------------------------------------------------------------------
    // Demo main — delete or keep for quick manual testing
    // -------------------------------------------------------------------------

    public static void main(String[] args) {

        // ── Example 1: O(n²) — bubble sort ──
        analyze(
                "Bubble Sort",
                n -> {
                    int[] arr = new int[n];
                    for (int i = 0; i < n; i++) arr[i] = (int) (Math.random() * n);
                    return arr;
                },
                arr -> {
                    int[] a = arr.clone();
                    for (int i = 0; i < a.length - 1; i++)
                        for (int j = 0; j < a.length - i - 1; j++)
                            if (a[j] > a[j + 1]) { int t = a[j]; a[j] = a[j+1]; a[j+1] = t; }
                }
        );

        // ── Example 2: O(n log n) — Arrays.sort ──
        analyze(
                "Arrays.sort (TimSort)",
                n -> {
                    int[] arr = new int[n];
                    for (int i = 0; i < n; i++) arr[i] = (int) (Math.random() * n);
                    return arr;
                },
                arr -> Arrays.sort(arr.clone())
        );

        // ── Example 3: O(n) — linear scan ──
        analyze(
                "Linear scan (max element)",
                n -> {
                    int[] arr = new int[n];
                    for (int i = 0; i < n; i++) arr[i] = (int) (Math.random() * n);
                    return arr;
                },
                arr -> {
                    int max = Integer.MIN_VALUE;
                    for (int x : arr) if (x > max) max = x;
                }
        );

        // ── Example 4: O(1) — array index access ──
        analyze(
                "O(1) — array index access",
                n -> new int[n],
                arr -> { int x = arr[arr.length / 2]; }
        );
    }
}