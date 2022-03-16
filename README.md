# CS6511_AI_Project2
CSP.AC3 problem:

In this project I have two main java class: Node and Main.

In Node class, I have an array call neb to store all neighbor nodes. and 3 variables representing the information of this node.

In Main class, Most of the work is done here, which mainly includes the main algorithms for solving CSP, AC3, MRV, LCV. The AC3 here is to improve the project by traversing the whole graph and reducing the selectable colors of the subsequent nodes. overall operating speed. MRV is Find the next coloring point in the graph, (uncolored) find the next point with the least alternative color to color, that is, to find the suitable variable forward. LCV is to decide which color should be selected among the alternative colors, the strategy here is to choose the color that is used the most.

I also have all the test case prove by professor in the test#.txt files. to run those test file just need simply change the file name at Main.java line 19(BufferedReader in = new BufferedReader(new FileReader("src/test2.txt"));//  <--------- change here to test different test case)
