import java.io.*;
import java.util.*;

public class Main {

    public static StringTokenizer st;
    public static BufferedReader br;
    public static int N,M;
    public static boolean flag;
    
    public static boolean check(char[][] subArray, int x, int y){

        // 인덱스 불가 접근 경우
        // System.out.println(x+" "+y);
        if(x<0 || x>=N || y<0 || y>=M){
            // System.out.println("1번");
            return false;
        }
        // 막혀 있을 때
        if(subArray[x][y]=='#' || subArray[x][y]=='R' || subArray[x][y]=='B'){
            // System.out.println(x+" "+y);
            // System.out.println("2번");
            return false;
        }
        return true;
    }
    public static void nodeMove(char[][] subArray, Node node, int direction, boolean R, boolean B){
        
        if(node.status){
            return ;
        }

        int newx = node.x, newy = node.y;
        
        // 상
        if(direction==1){
            newx--;
        }
        // 하
        else if(direction==2){
            newx++;
        }
        // 좌
        else if(direction==3){
            newy--;
        }
        // 우
        else{
            newy++;
        }

        if(!check(subArray, newx, newy)){
            return ;
        }
        if(subArray[newx][newy]=='O'){
            node.goal();
        }
        else{
            if(R){
                subArray[newx][newy] = 'R';
            }
            else if(B){
                subArray[newx][newy] = 'B';
            }
        }
        subArray[node.x][node.y] = '.';
        node.x = newx;
        node.y = newy;
    }
    public static void move(char[][] subArray, Node red, Node blue, int direction){
        // System.out.println(direction);
        // 상
        // System.out.println(red.x+" "+red.y);
        // System.out.println(blue.x+" "+blue.y);
        if(direction==1){
            if(red.y < blue.y){
                for(int i=0;i<N;i++){
                    nodeMove(subArray, red, direction, true, false);
                    nodeMove(subArray, blue, direction, false, true);
                }
            }
            else{
                for(int i=0;i<N;i++){
                    nodeMove(subArray, blue, direction, false, true);
                    nodeMove(subArray, red, direction, true, false);
                }                
            }
        }
        // 하
        else if(direction==2){
            if(red.y < blue.y){
                for(int i=0;i<N;i++){
                    nodeMove(subArray, blue, direction, false, true);
                    nodeMove(subArray, red, direction, true, false);
                }
            }
            else{
                for(int i=0;i<N;i++){
                    nodeMove(subArray, red, direction, true, false);
                    nodeMove(subArray, blue, direction, false, true);
                }
            }
        }
        // 좌
        else if(direction==3){
            if(red.x< blue.x){
                for(int i=0;i<M;i++){
                    nodeMove(subArray, red, direction, true, false);
                    nodeMove(subArray, blue, direction, false, true);
                }
            }
            else{
                for(int i=0;i<M;i++){
                    nodeMove(subArray, blue, direction, false, true);
                    nodeMove(subArray, red, direction, true, false);    
                }
            }
        }
        // 우
        else{
            if(red.x < blue.x){
                for(int i=0;i<M;i++){
                    nodeMove(subArray, blue, direction, false, true);
                    nodeMove(subArray, red, direction, true, false);    
                }
            }
            else{
                for(int i=0;i<M;i++){
                    nodeMove(subArray, red, direction, true, false);
                    nodeMove(subArray, blue, direction, false, true);    
                }
            }
        }


    }

    public static void dfs(char[][] subArray, Node red, Node blue, int cnt){

        if(red.status && !blue.status){
            flag= true;
        }

        if(flag || cnt==11 || blue.status){
            return ;
        }

        // 상하좌우 다 이동
        for(int i=1;i<=4;i++){
            char[][] newArray = copy2D(subArray);
            Node newRed = new Node(red);
            Node newBlue = new Node(blue);

            move(newArray, newRed, newBlue, i);
            // print(newArray);
            dfs(newArray, newRed, newBlue, cnt+1);
        }

    }
    public static void print(char[][] array){

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        char[][] array= new char[N][M];

        Node red=null, blue=null;

        for(int i=0;i<N;i++){
            String tmp = br.readLine();
            for(int j=0;j<M;j++){
                array[i][j] = tmp.charAt(j);
                if(array[i][j]=='R'){
                    red = new Node(i,j);
                }
                else if(array[i][j]=='B'){
                    blue = new Node(i,j);
                }
            }
        }
        
        dfs(copy2D(array), new Node(red), new Node(blue), 1);

        if(flag){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }

    public static char[][] copy2D(char[][] subArray){
        char[][] copy = new char[subArray.length][];

        for(int i=0;i<subArray.length;i++){
            copy[i] = Arrays.copyOf(subArray[i], subArray[i].length);
        }

        return copy;

    }

    public static class Node{
        public int x;
        public int y;
        boolean status;

        Node(int x,int y){
            this.x =x;
            this.y =y;
            this.status=false;
        }

        Node(Node node){
            this.x =node.x;
            this.y = node.y;
            this.status= false;
        }

        public void goal(){
            this.status=true;
        }
    }



}
