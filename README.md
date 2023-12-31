# Shortest Task First Scheduling Algorithm Implementation

## Overview

This document outlines the implementation of the Shortest Task First (STF) scheduling algorithm in the OS scheduling simulator, originally based on a First-Come First-Served (FCFS) scheduling approach. The STF algorithm prioritizes processes based on their remaining CPU time, scheduling the shortest tasks first to potentially reduce the overall waiting time and increase system efficiency.

## Changes Made

### SchedulingAlgorithm.java

The primary changes were made in the `SchedulingAlgorithm.java` file. The original FCFS logic in the `Run` method was replaced with the STF scheduling logic.

#### Key Modifications:

1. **Scheduling Name Update**:
    - The `schedulingName` variable was updated to reflect the new algorithm: `"Shortest Task First"`.

2. **Process Selection Logic**:
    - A new process selection loop was introduced to find the process with the shortest remaining CPU time.
    - This loop iterates over all processes in the `processVector` and selects the one with the minimum `cputime - cpudone`.

3. **Execution and Completion Check**:
    - The selected process is executed for one time unit (incrementing `cpudone`).
    - If a process completes its execution (`cpudone == cputime`), it is marked as completed, and the `completed` counter is incremented.

4. **Termination Condition**:
    - The simulation now terminates when all processes are completed or when the total runtime is reached.

### Testing and Validation

- The implementation was tested with various scenarios to ensure that the STF algorithm correctly prioritizes shorter tasks.
- Additional validation was performed to check the integration with the existing simulation framework.

## Conclusion

The implementation of the STF algorithm in the OS scheduling simulator represents a shift from a simple FCFS approach to a more efficient task scheduling method. This change aims to reduce the average waiting time for processes, thereby improving the overall performance of the simulated operating system environment.
