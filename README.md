# Advanced Graph Coloring Solver: A CSP Approach with AC-3, MRV, and LCV Heuristics

## Project Overview
This Java-based project implements an advanced solution to the Graph Coloring Problem, a classic NP-hard optimization challenge in computer science. The solver utilizes sophisticated Constraint Satisfaction Problem (CSP) techniques, including the AC-3 algorithm for constraint propagation and intelligent variable and value ordering heuristics.

## Key Components
1. **Node Class**: 
   - Represents graph vertices with adjacency information.
   - Manages color assignments and available color choices.

2. **Main Class**:
   - Implements core CSP solving algorithms:
     - AC-3 (Arc Consistency Algorithm #3) for constraint propagation
     - MRV (Minimum Remaining Values) for variable ordering
     - LCV (Least Constraining Value) for value selection
   - Handles graph construction from input files
   - Orchestrates the overall solving process

## Advanced Algorithmic Techniques
1. **AC-3 Algorithm**: 
   - Enhances efficiency by pre-processing and dynamically reducing the domain of variables.
   - Traverses the entire graph to minimize the color options for subsequent nodes.

2. **MRV Heuristic**: 
   - Intelligently selects the next node to color by identifying the uncolored node with the least remaining color options.
   - Optimizes the search process by tackling the most constrained variables first.

3. **LCV Heuristic**: 
   - Prioritizes color selection based on usage frequency.
   - Chooses colors that are most used, potentially leaving more options for future assignments.

4. **Backtracking Search**: 
   - Implements a sophisticated backtracking algorithm that leverages AC-3, MRV, and LCV for pruning and guiding the search process.

## Implementation Details
- **Graph Representation**: Utilizes an adjacency list structure for efficient neighbor access and memory usage.
- **Dynamic Color Domain**: Each node maintains a list of available colors, dynamically updated through constraint propagation.
- **Extensible Design**: The modular structure allows for easy integration of additional CSP techniques or problem-specific heuristics.

## Usage Instructions
1. Prepare an input file following the format specified in the provided test files (e.g., `test.txt`).
2. Modify the file path in `Main.java` (line 19) to point to your input file.
3. Run `Main.java` to execute the solver.
4. The program will output the coloring result for all nodes if a solution is found.

## Testing and Validation
- Comprehensive test cases provided in `test#.txt` files.
- JUnit tests implemented in `MainTest.java` and `NodeTest.java` ensure the correctness of core functionalities.

## Performance Analysis
The integration of AC-3, MRV, and LCV heuristics significantly enhances the solver's efficiency:
- AC-3 reduces the search space by eliminating inconsistent values early.
- MRV minimizes branching factor in the search tree.
- LCV maximizes future solving flexibility.

These techniques combine to provide a robust solution capable of handling complex graph coloring instances efficiently.

## Future Enhancements
- Implementation of additional CSP techniques such as forward checking or conflict-directed backjumping.
- Parallelization of the solving process for improved performance on large-scale graphs.
- Development of a graphical user interface for visual representation of the coloring process.

## Author
Ziyan

## Academic References
1. Mackworth, A. K. (1977). Consistency in networks of relations. Artificial Intelligence, 8(1), 99-118.
2. Russell, S. J., & Norvig, P. (2010). Artificial Intelligence: A Modern Approach (3rd ed.). Pearson Education.
3. Kumar, V. (1992). Algorithms for constraint-satisfaction problems: A survey. AI Magazine, 13(1), 32-44.


CSP.AC3 problem:

In this project I have two main java class: Node and Main.

In Node class, I have an array call neb to store all neighbor nodes. and 3 variables representing the information of this node.

In Main class, Most of the work is done here, which mainly includes the main algorithms for solving CSP, AC3, MRV, LCV. The AC3 here is to improve the project by traversing the whole graph and reducing the selectable colors of the subsequent nodes. overall operating speed. MRV is Find the next coloring point in the graph, (uncolored) find the next point with the least alternative color to color, that is, to find the suitable variable forward. LCV is to decide which color should be selected among the alternative colors, the strategy here is to choose the color that is used the most.

I also have all the test case prove by professor in the test#.txt files. to run those test file just need simply change the file name at Main.java line 19(BufferedReader in = new BufferedReader(new FileReader("src/test2.txt"));//  <--------- change here to test different test case)
