import java.util.ArrayList;

public class Node {
    Node neb [] = new Node [9999];
    int necounter = 0;//Used to record how many neighbors there are now
    int name;
    int color = -1;
    //int colorReadyToChoice [] ;
    ArrayList<Integer> colorReadyToChoice =new ArrayList<>();


    public Node (int n, int cl){ //cl is the number of colors
        this.name = n;
       // colorReadyToChoice = new int[cl];
        for(int i = 0; i< cl;i++){
            this.colorReadyToChoice.add(i);
        }
    }

public void addne(Node node){//for adding neighbors
        neb[necounter] = node;
        necounter ++; //Increment the counter by one
  //  System.out.println(necounter);
}

public void printname(){//print all the node that have been created
    System.out.println("This node is: "+this.name);
        for (int i = 0; i < necounter;i++){
            if(neb[i] != null){
                System.out.println(neb[i].name);
            }
        }
}

}
