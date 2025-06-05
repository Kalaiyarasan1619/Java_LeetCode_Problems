package medium;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        java.util.List<int[]> result = new java.util.ArrayList<>();
        boolean added = false;

        for (int[] interval : intervals) {
            // If the new interval is before the current interval
            if (newInterval[1] < interval[0]) {
                if (!added) {
                    result.add(newInterval);
                    added = true;
                }
                result.add(interval);
            }
            // If the new interval is after the current interval
            else if (newInterval[0] > interval[1]) {
                result.add(interval);
            }
            // Overlapping intervals, merge them
            else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        // If the new interval was not added, add it at the end
        if (!added) {
            result.add(newInterval);
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        InsertInterval solution = new InsertInterval();
        int[][] intervals = { { 1, 3 }, { 6, 9 } };
        int[] newInterval = { 2, 5 };
        int[][] result = solution.insert(intervals, newInterval);

        for (int[] interval : result) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}
