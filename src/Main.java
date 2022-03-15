import com.sun.tools.javac.util.ArrayUtils;

import java.io.*;
import java.util.*;
public class Main {
    static int numOfClolor;//看有多少个颜色可以选
    static int nodecounter = 0;//记录现在有多少个node已经生成了
    static int cololed = 0;//染了几个了
    static ArrayList<Node> graph =new ArrayList<>();//一个动态array来记录图上所有的节点
    static int[] cstatus;//统计现在的颜色用了多少了

    static int [] listnode =new int [9999]; //用来记录创建了的node的值
    //static int listcount = 0;//上面中国array的index
    public static void main(String[] args)
    {//一开始读的时候需要把所有的节点统一存到一个array里去


        try {
            BufferedReader in = new BufferedReader(new FileReader("src/test4.txt"));//4有问题
            String str;
            str = in.readLine();
            str = str.substring(9);
            numOfClolor =Integer.parseInt(str); //4 在里面
            cstatus = new int[numOfClolor];
            System.out.println(numOfClolor);//用来检查输入的
            while((str = in.readLine()) != null){
                String[] input = str.split(",");
                System.out.println(input[0]+" , "+input[1]);//用来检查输入的
              /*  if(graph.isEmpty()) {
                    Node x = new Node(Integer.parseInt(input[0]), numOfClolor);
                    graph.add(x);
                    listnode[nodecounter] = Integer.parseInt(input[0]);
                    nodecounter++;
                    Node y = new Node(Integer.parseInt(input[1]), numOfClolor);//每一行输入创建两个node
                    graph.add(x);
                    listnode[nodecounter] = Integer.parseInt(input[0]);
                    nodecounter++;
                    x.addne(y);//把他们链接状态记录给他们两个的array里
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
                                if(graph.get(i).name == Integer.parseInt(input[0]) ){
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
                            x.addne(y);//把他们链接状态记录给他们两个的array里
                            y.addne(x);
                        }
                    }

                }
            //}

        }
        catch (IOException e) {
            System.out.println("输入有问题");
        }

        //graph.get(2).printname();
        //graph.get(6).printname();
        printnode();
        int [] test = {0,1,1,1};
        //test  = LCV(test);
//        System.out.println("LCV测试：");
//        for(int i:test){
//            System.out.println(i);
//        }
        runBackTrack();
        printans();
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
        ArrayList<Node> backtemp = (ArrayList<Node>)graph.clone();//用来记录修改前的状态用于回溯
        for(int i = 0; i< order.length;i++){
            if(nextNode.colorReadyToChoice.contains(order[i])){
               if(compcolo(nextNode,order[i])){
                  // nextNode.color = order[i]; //这里注意这个颜色会不会改
                   graph.get(graph.indexOf(nextNode)).color = order[i];
                   cstatus[order[i]]++;//颜色的使用情况记录到array里也就是+1
                   cololed++;//标注涂色了一个
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
            graph = (ArrayList<Node>)backtemp.clone(); //回溯到修改之前
            cololed--;//标注删除了涂色一个
        }
        return false;
    }


    public static boolean compcolo(Node node, int color){//用要着色的点的颜色来和这个点的邻居颜色对比
        for (int i = 0; i < node.necounter;i++){
            if(node.neb[i].color == color){
                return false;
            }
        }
        return true;
    }


    public static boolean AC3(){
        Queue<String> q = new LinkedList<>();
        /*add(E e);
        E remove()
        E peek() */

        return true;
    }

    //min remaining values, least constraining value

    public static Node MRV(){//在图里找下一个着色点，（没着色的）找下一个有最少备选色的点来着色，就是要向前找适合的变量
        //在一开始选节点最多的那个nood开始，可以少回溯
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

    public static int[] LCV(){//在备选色中该选那个颜色，这里的策略是选使用的最多的颜色
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
        System.out.println("这是所有的node的表：");
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
        System.out.println("这是所有的node的着色结果展示：");
        for (int i = 0; i < graph.size();i++){
            System.out.println(graph.get(i).name +" and this node clolr is: "+ graph.get(i).color);
        }
    }



}


//