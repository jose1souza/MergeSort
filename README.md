#  Sorting Algorithm Performance Comparison

This project implements and compares the performance of four classic sorting algorithms in Java: **Bubble Sort**, **Selection Sort**, **Insertion Sort**, and **Merge Sort**. Each algorithm is applied to the same dataset to evaluate execution time, number of comparisons, and sorting correctness.

---

##  Features

- Full implementations of:
  - Bubble Sort (with verbose and flag optimizations)
  - Selection Sort
  - Insertion Sort
  - Merge Sort
- Precise execution time measurement (in seconds)
- Comparison counters for each algorithm
- Sorted array output for validation

---

##  Performance Results

| Algorithm         | Comparisons       | Time (s)  | Efficiency |
|-------------------|-------------------|-----------|------------|
| **Merge Sort**    | 351,836           | 0.083     | ⭐ Highly efficient |
| **Selection Sort**| 206,261           | 5.363     | ⚠️ Simple but slow |
| **Insertion Sort**| 611,134,160       | 16.826    | ❌ Inefficient with unsorted data |
| **Bubble Sort**   | 1,236,014,340     | 19.589    | 🚫 Extremely inefficient |

>  *Note:* All tests were run on the same dataset to ensure consistent comparisons.

---

##  Algorithm Complexity

| Algorithm        | Time Complexity | Stability | Description |
|------------------|------------------|-----------|-------------|
| **Bubble Sort**  | O(n²)            | ✅ Stable | Repeatedly compares and swaps adjacent elements |
| **Selection Sort** | O(n²)          | ❌ Unstable | Selects the smallest element and places it in order |
| **Insertion Sort** | O(n²)          | ✅ Stable | Inserts each element into its correct position; great for nearly sorted arrays |
| **Merge Sort**   | O(n log n)       | ✅ Stable | Divide-and-conquer: splits and merges sorted subarrays |

---

##  How to Clone and Run

Since `.class` and `.project` files are ignored via `.gitignore`, manual compilation is required.

### Clone the Repository

```bash
git clone https://github.com/jose1souza/MergeSort.git
cd MergeSort
