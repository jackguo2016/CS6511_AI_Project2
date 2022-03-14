import java.io.*;
import java.util.*;
public class Main {
    static int numOfClolor;//看有多少个颜色可以选
    static int nodecounter = 0;//记录现在有多少个node已经生成了
    static ArrayList<Node> graph =new ArrayList<>();//一个动态array来记录图上所有的节点

    static int [] listnode =new int [9999]; //用来记录创建了的node的值
    //static int listcount = 0;//上面中国array的index
    public static void main(String[] args)
    {//一开始读的时候需要把所有的节点统一存到一个array里去


        try {
            BufferedReader in = new BufferedReader(new FileReader("src/test.txt"));
            String str;
            str = in.readLine();
            str = str.substring(9);
            numOfClolor =Integer.parseInt(str); //4 在里面
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
        }

        //graph.get(2).printname();
        graph.get(6).printname();
        printnode();

    }

    public void run(){

    }


    public void AC3(){
        Queue<String> q = new LinkedList<>();
        /*add(E e);
        E remove()
        E peek() */
    }

    //min remaining values, least constraining value

    public void MRV(){//在图里找下一个着色点，（没着色的）找下一个有最少备选色的点来着色，就是要向前找适合的变量
        //在一开始选节点最多的那个nood开始，可以少回溯

    }

    public void LCV(){//在备选色中该选那个颜色，这里的策略是选

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


}


//