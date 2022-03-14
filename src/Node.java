public class Node {
    Node neb [] = new Node [9999];
    int necounter = 0;//用来记录现在有几个邻居用的
    int name;
    int color = -1;
    int colorReadyToChoice [] ;

    public Node (int n, int cl){ //cl是颜色的个数
        this.name = n;
        colorReadyToChoice = new int[cl];
        for(int i = 0; i< cl;i++){
            this.colorReadyToChoice[i] = i;
        }
    }

public void addne(Node node){//添加邻居用的
        neb[necounter] = node;
        necounter ++; //吧计数器加一
  //  System.out.println(necounter);
}


}
