import java.io.*;
import java.util.*;

public class Main {

    public static StringTokenizer st;
    public static BufferedReader br;
    public static int max;


    public static void swap(int x, int y, int newx, int newy, int[][] subDirection, Node[] subFish, int[][] subArray){
        // 위치와 방향 스왑
        // System.out.println(x+" "+y+" "+newx+" "+newy);

        if(subArray[newx][newy]==0){

            subDirection[newx][newy] = subDirection[x][y];
            subDirection[x][y] = 0;
    
            subFish[subArray[x][y]].set(newx, newy);
    
            subArray[newx][newy] = subArray[x][y];
            subArray[x][y] = 0;
        }
        else{
            int tmp = subDirection[newx][newy];
            subDirection[newx][newy] = subDirection[x][y];
            subDirection[x][y] = tmp;
    
            subFish[subArray[x][y]].set(newx, newy);
            subFish[subArray[newx][newy]].set(x,y);
    
            tmp = subArray[newx][newy];
            subArray[newx][newy] = subArray[x][y];
            subArray[x][y] = tmp;
        }


    }
    public static void caculate(int x, int y, int cnt, int[][] subDirection, Node[] subFish, int[][] subArray, Node subShark){
        if(cnt==8){
            return ;
        }
        int newx=x, newy=y;
        if(subDirection[x][y]==1){
            newx = x - 1;
        }
        else if(subDirection[x][y]==2){
            newx = x-1;
            newy = y-1;
        }
        else if(subDirection[x][y]==3){
            newy = y-1;
        }
        else if(subDirection[x][y]==4){
            newx = x+1;
            newy = y-1;
        }
        else if(subDirection[x][y]==5){
            newx = x+1;
        }
        else if(subDirection[x][y]==6){
            newx = x+1;
            newy = y+1;
        }
        else if(subDirection[x][y]==7){
            newy = y+1;
        }
        else {
            newx = x-1;
            newy = y+1;
        }


        if(fishCheck(newx, newy, subShark)){
            swap(x,y,newx,newy, subDirection, subFish, subArray);
        }
        else{
            // 방향 바꾸고 다시 호출?
            subDirection[x][y]++;
            if(subDirection[x][y]==9){
                subDirection[x][y] = 1;
            }
            caculate(x,y,cnt+1, subDirection, subFish, subArray, subShark);
        }
    }

    public static boolean fishCheck(int x, int y, Node subShark){
        // 상어가 있거나 공간의 경계가 넘는지?

        if(x>3 || y >3 || y<0 || x<0){
            return false;
        } 

        if(subShark.x ==x && subShark.y == y){
            return false;
        }
        return true;
    }

    public static boolean sharkCheck(int x,int y, int[][] subArray){
        if(x>3 || y >3 || y<0 || x<0){
            return false;
        }
        if(subArray[x][y] == 0){
            return false;
        }
        return true;
    }

    public static void delete(int x, int y, Node[] subFish, int[][] subDirection, int[][] subArray){
        subFish[subArray[x][y]].delete();
        subArray[x][y] = 0;
        subDirection[x][y] = 0;
    }

    public static void print(int[][] subArray){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(subArray[i][j]+ " ");
            }
            System.out.println();
        }

        System.out.println();
    }
    public static List<Node> sharkCaculate(Node subShark, int subSharkDirection){

        List<Node> result = new ArrayList<Node>();

        int newx = subShark.x;
        int newy = subShark.y;
        for(int i=0;i<4;i++){
            if(subSharkDirection==1){
                newx = newx - 1;
            }
            else if(subSharkDirection==2){
                newx = newx-1;
                newy = newy-1;
            }
            else if(subSharkDirection==3){
                newy = newy-1;
            }
            else if(subSharkDirection==4){
                newx = newx+1;
                newy = newy-1;
            }
            else if(subSharkDirection==5){
                newx = newx+1;
            }
            else if(subSharkDirection==6){
                newx = newx+1;
                newy = newy+1;
            }
            else if(subSharkDirection==7){
                newy = newy+1;
            }
            else {
                newx = newx-1;
                newy = newy+1;
            }
            result.add(new Node(newx, newy));
        }

        return result;
    }
    public static int[][] deepCopy2D(int[][] original) {
        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = Arrays.copyOf(original[i], original[i].length);
        }

        // for(int i=0;i<4;i++){
        //     for(int j=0;j<4;j++){
        //         System.out.print(copy[i][j]+ " ");
        //     }
        //     System.out.println();
        // }
        return copy;
    }
    public static Node[] deepCopyFish(Node[] original) {
        Node[] copy = new Node[original.length];
        for (int i = 0; i < original.length; i++) {
            if (original[i] != null)
                copy[i] = new Node(original[i]);
        }
        return copy;
    }
    
    public static void dfs(Node[] subFish, int[][] subDirection, int[][] subArray, Node subShark, int subSharkDirection, int sum){
        
        for(int i=1;i<17;i++){
            // System.out.println(i+"번째");
            if(subFish[i].getStatus()){
                caculate(subFish[i].x, subFish[i].y, 0, subDirection, subFish, subArray, subShark);
            }
        }

        
        // 상어 방향 확인 후 옮길수 있는 리스트 뽑기

        List<Node> list = sharkCaculate(subShark, subSharkDirection);
        
        for(Node shark : list){
            if(sharkCheck(shark.x, shark.y, subArray)){
                
                Node[] newFish = deepCopyFish(subFish);
                int[][] newDirection = deepCopy2D(subDirection);
                int[][] newArray = deepCopy2D(subArray);
                Node newShark = new Node(shark);
                // System.out.println("shark : "+shark.x+" "+shark.y+" "+newDirection[newShark.x][newShark.y] );
                delete(newShark.x,newShark.y, newFish, newDirection, newArray);

                dfs(newFish, newDirection, newArray, newShark, subDirection[newShark.x][newShark.y], sum + subArray[newShark.x][newShark.y]);
            }
            else{
                if(sum>max){
                    max = sum;
                }
            }
        }

    }
    
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        
        int[][] array;
        int[][] direction;
    
        Node[] fish;

        array= new int[4][4];
        direction = new int[4][4];
        fish = new Node[17];
        max = 0;

        for(int i=0;i<4;i++){
            st = new StringTokenizer(br.readLine());      
            for(int j=0;j<4;j++){
                array[i][j] = Integer.parseInt(st.nextToken());
                fish[array[i][j]] = new Node(i,j); 
                direction[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    
        max += array[0][0];
        Node shark = new Node(0,0);
        int sharkDirection = direction[0][0];
        delete(0,0,fish, direction, array);
        shark.set(0,0);
        dfs(fish , direction, array, shark, sharkDirection, max);


        System.out.println(max);
    }


    public static class Node{
        int x;
        int y;
        boolean status;

        Node(int x, int y){
            this.x = x;
            this.y = y;
            this.status = true;
        }

        Node(Node node){
            this.x = node.x;
            this.y = node.y;
            this.status = node.status;
        }

        void set(int x, int y){
            this.x= x;
            this.y =y;
        }

        void delete(){
            this.x = -1;
            this.y = -1;
            this.status = false;
        }

        boolean getStatus(){
            return this.status;
        }
    }

}
