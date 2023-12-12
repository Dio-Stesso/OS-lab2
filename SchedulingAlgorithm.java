import java.util.Vector;
import java.io.*;

public class SchedulingAlgorithm {

  public static Results Run(int runtime, Vector processVector, Results result) {
    int comptime = 0;
    int size = processVector.size();
    int completed = 0;
    String resultsFile = "Summary-Processes";

    result.schedulingType = "Batch (Nonpreemptive)";
    result.schedulingName = "Shortest Task First";
    try {
      PrintStream out = new PrintStream(new FileOutputStream(resultsFile));
      while (comptime < runtime) {
        sProcess shortest = null;
        for (int i = 0; i < size; i++) {
          sProcess process = (sProcess) processVector.elementAt(i);
          if (process.cpudone < process.cputime) {
            if (shortest == null || process.cputime - process.cpudone < shortest.cputime - shortest.cpudone) {
              shortest = process;
            }
          }
        }

        if (shortest == null) {
          break; // All processes are complete
        }

        out.println("Process: " + shortest + " selected (CPU Time: " + shortest.cputime + " ms, CPU Done: " + shortest.cpudone + " ms)");
        shortest.cpudone++;
        if (shortest.cpudone == shortest.cputime) {
          completed++;
          out.println("Process: " + shortest + " completed (CPU Time: " + shortest.cputime + " ms, CPU Done: " + shortest.cpudone + " ms)");
        }

        if (completed == size) {
          result.compuTime = comptime;
          break;
        }

        comptime++;
      }
      out.close();
    } catch (IOException e) { /* Handle exceptions */ }
    result.compuTime = comptime;
    return result;
  }
}
