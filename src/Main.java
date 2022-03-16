import com.sun.tools.javac.util.ArrayUtils;

import java.io.*;
import java.util.*;
public class Main {
    static int numOfClolor;//See how many colors are available
    static int nodecounter = 0;//Record how many nodes have been generated now
    static int cololed = 0;//dyed a few
    static ArrayList<Node> graph =new ArrayList<>();//A dynamic array to record all nodes on the graph
    static int[] cstatus;//Count how many colors are used now

    static int [] listnode =new int [9999]; //Used to record the value of the created node
    //static int listcount = 0;//The index of the above array
    public static void main(String[] args)
    {//When reading at the beginning, all nodes need to be stored in an array


        try {
            BufferedReader in = new BufferedReader(new FileReader("src/test2.txt"));//  <--------- change here to test different test case
            String str;
            in.readLine();
            in.readLine();
            str = in.readLine();
            in.readLine();
            str = str.substring(9);
            numOfClolor =Integer.parseInt(str);
            cstatus = new int[numOfClolor];
            System.out.println(numOfClolor);//for checking input
            while((str = in.readLine()) != null){
                String[] input = str.split(",");
                System.out.println(input[0]+" , "+input[1]);//for checking input
              /*  if(graph.isEmpty()) {
                    Node x = new Node(Integer.parseInt(input[0]), numOfClolor);
                    graph.add(x);
                    listnode[nodecounter] = Integer.parseInt(input[0]);
                    nodecounter++;
                    Node y = new Node(Integer.parseInt(input[1]), numOfClolor);//Create two nodes per line of input
                    graph.add(x);
                    listnode[nodecounter] = Integer.parseInt(input[0]);
                    nodecounter++;
                    x.addne(y);//record their link status in their two arrays
                    y.addne(x);
                }
                else{*/
                    if(isContainKey(listnode,Integer.parseInt(input[0]))){
                        if(isContainKey(listnode,Integer.parseInt(input[1]))){
                            for (int i = 0; i< graph.size();i++) {
                                for (int j = 0; j < graph.size(); j++) {
                                    if(graph.get(i).name == Integer.parseInt(input[0]) && graph.get(j).name == Integer.parseInt(input[1])){
                                        graph.get(i).addne(graph.get(j));
                                        graph.get(j).addne(graph.get(i));
                                    }
                                }
                            }
                        }
                        if(!isContainKey(listnode,Integer.parseInt(input[1]))){
                            Node x = new Node(Integer.parseInt(input[1]), numOfClolor);
                            graph.add(x);
                            listnode[nodecounter] = Integer.parseInt(input[1]);
                            nodecounter++;
                            for (int i = 0; i< graph.size();i++) {
                                if(graph.get(i).name == Integer.parseInt(input[0]) ){ //make the graph in different situation
                                    graph.get(i).addne(x);
                                    x.addne(graph.get(i));
                                }

                            }
                        }

                    }
                    else{
                        Node x = new Node(Integer.parseInt(input[0]), numOfClolor);
                        graph.add(x);
                        listnode[nodecounter] = Integer.parseInt(input[0]);
                        nodecounter++;
                        if(isContainKey(listnode,Integer.parseInt(input[1]))){
                            for (int i = 0; i< graph.size();i++) {
                                if(graph.get(i).name == Integer.parseInt(input[1])){
                                    graph.get(i).addne(x);
                                    x.addne(graph.get(i));
                                }

                            }
                        }
                        else{
                            Node y = new Node(Integer.parseInt(input[1]), numOfClolor);
                            graph.add(y);
                            listnode[nodecounter] = Integer.parseInt(input[1]);
                            nodecounter++;
                            x.addne(y);//record their link status in their two arrays
                            y.addne(x);
                        }
                    }

                }
            //}

        }
        catch (IOException e) {
            System.out.println("There is a problem with the input");
        }

        //graph.get(2).printname();
        //graph.get(6).printname();  //check input
        printnode();
        int [] test = {0,1,1,1};
        //test  = LCV(test);
//        System.out.println("LCVtest："); //check the function of LCV function
//        for(int i:test){
//            System.out.println(i);
//        }
        if (runBackTrack()){
            System.out.println("=============================");
            System.out.println("=============================");
            System.out.println("=============================");
            printans();}
        else{
            System.out.println("=============================");
            System.out.println("=============================");
            System.out.println("=============================");

            System.out.println("there is no solution for this graph in put.");
        }
    }

    public static Boolean runBackTrack( ){
        if (cololed == nodecounter){
            return true;
        }
        Node nextNode = MRV();
        if(nextNode == null){
            return true;
        }
        int[] order = LCV();
        Boolean ans = false;
        ArrayList<Node> backtemp = (ArrayList<Node>)graph.clone();//Used to record the state before modification for backtracking
        for(int i = 0; i< order.length;i++){
            if(nextNode.colorReadyToChoice.contains(order[i])){
               if(compcolo(nextNode,order[i])){
                  // nextNode.color = order[i]; //Note here whether this color will change
                   graph.get(graph.indexOf(nextNode)).color = order[i];
                   cstatus[order[i]]++;//The usage of the color is recorded in the array, that is,+1
                   cololed++;//The callout is colored one
                   if(AC3()){
                       ans = runBackTrack();
                       if(ans){
                           return true;
                       }
                   }
               }
            }
            else{
                continue;
            }
            graph.clear();
            graph = (ArrayList<Node>)backtemp.clone(); //Backtracking before modification
            cololed--;//标注删除了涂色一个
        }
        return false;
    }


    public static boolean compcolo(Node node, int color){//Use the color of the point to be colored against the color of this point's neighbors
        for (int i = 0; i < node.necounter;i++){
            if(node.neb[i].color == color){
                return false;
            }
        }
        return true;
    }


    public static boolean AC3() {
        Queue<Node> q = new LinkedList<>();
        for (int i =0; i< graph.size();i++){
            for (int j = 0;j<graph.get(i).necounter;j++){//add all the arcs to the queue
                q.add(graph.get(i));
                q.add(graph.get(i).neb[j]);
            }
        }
        while (!q.isEmpty()){
            Node neb = q.poll();
            Node root = q.poll();
            if(revise(neb,root)){
                if(neb.colorReadyToChoice.isEmpty()){
                    return false;
                }
                for (int i =0; i< neb.necounter;i++){
                    q.add(neb.neb[i]);
                    q.add(neb);
                }
            }
        }
        return true;
    }

    public static boolean revise(Node neb, Node root){
        boolean revise = false;
        for (int i = 0; i< neb.colorReadyToChoice.size();i++){
            if(root.colorReadyToChoice.contains(neb.colorReadyToChoice.get(i))){
                if(root.colorReadyToChoice.size()==1){
                    revise =true;
                    neb.colorReadyToChoice.remove(neb.colorReadyToChoice.get(i));
                }
            }
        }


        return revise;
    }

    //min remaining values, least constraining value

    /**
     * min remaining values
     * @return a node to move next
     */
    public static Node MRV(){//Find the next coloring point in the graph, (uncolored) find the next point with the least alternative color to color, that is, to find the suitable variable forward
        //Start with the nood with the most nodes selected at the beginning, you can reduce backtracking
        int tempclolrcounter = 99990;
        Node tempnopde = null;
        for(int i = 0; i< graph.size();i++){
            if (graph.get(i).color == -1){
                if(graph.get(i).colorReadyToChoice.size()<tempclolrcounter){
                    tempnopde = graph.get(i);
                }

            }
        }
        return tempnopde;
    }

    /**
     * least constraining value
     * @return an array that help reduse tge time to try
     */
    public static int[] LCV(){//Which color should be selected among the alternative colors, the strategy here is to choose the color that is used the most
        int [] temp = new int[cstatus.length];
        for (int i = 0; i < cstatus.length; ++i) {
            temp[i] = cstatus[i];
        }
        int counter = 0;
        int ans[] = new int[temp.length];
        while(counter<temp.length) {
            int max = maxValue(temp);
            ans[counter] = findIndex(temp, max);
            counter++;
            temp[findIndex(temp, max)] = -1;
        }
        return ans;
    }

    public static boolean isContainKey(int[] keys, int targetValue)
    {
        if (keys == null || keys.length == 0)
        {
            return false;
        }

        for (int str : keys)
        {
            if (str == targetValue)
            {
                return true;
            }
        }

        return false;
    }

    public static void printnode(){
        System.out.println("Here is a table of all nodes created successfully:：");
        for (int i = 0; i < graph.size();i++){
            System.out.println(graph.get(i).name);
        }
    }


    public static int findIndex(int arr[], int t)
    {

        // if array is Null
        if (arr == null) {
            return -1;
        }

        // find length of array
        int len = arr.length;
        int i = 0;

        // traverse in the array
        while (i < len) {

            // if the i-th element is t
            // then return the index
            if (arr[i] == t) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }

    private static int maxValue(int[] chars) {
        int max = chars[0];
        for (int ktr = 0; ktr < chars.length; ktr++) {
            if (chars[ktr] > max) {
                max = chars[ktr];
            }
        }
        return max;
    }


    public static void printans(){
        System.out.println("Here is the coloring result for all nodes：");
        for (int i = 0; i < graph.size();i++){
            System.out.println(graph.get(i).name +" and this node color is: "+ graph.get(i).color);
        }
    }



}


//