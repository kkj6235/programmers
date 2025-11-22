import java.io.*;
import java.util.*;

public class Main {

    public static StringTokenizer st;
    public static BufferedReader br;
    public static int N,M,K;

    public static int[] parent;
    public static long[][] dp;

    public static int find(int k){
        if(parent[k]==k){
            return k;
        }
        return parent[k] = find(parent[k]);
    }

    public static void union(int a,int b){

        int pa = find(a);
        int pb = find(b);

        if(pa==pb){
            return ;
        }
        else if(pa<pb){
            parent[pb] = pa;
        }
        else{
            parent[pa] = pb;
        }
        
    }
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i=1;i<=N;i++){
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());

        Node[] array = new Node[N+1];
        for(int i=1;i<=N;i++){
            array[i] = new Node(Integer.parseInt(st.nextToken()));
        }

    
        for(int i=0;i<M;i++){   
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }

        // SET에 각자 추가해서 그룹 완성
        Set<Integer> set = new HashSet();
    
        for(int i=1;i<parent.length;i++){
            if(set.contains(find(i))){
                array[find(i)].update(array[i].value);
            }  
            else{
                set.add(find(i));
            }
        }

        dp = new long[set.size()+1][K];

        for(int i=0;i<set.size()+1;i++){
            dp[i][0] = 0;
        }

        for(int i=0;i<K;i++){
            dp[0][i] = 0;
        }


        // 내가 원하는 답은 dp[][k-1]
        int i=1;

        for(int s : set){
            // System.out.println(s);
            for(int j=1;j<K;j++){
                if(array[s].count<=j){
                    dp[i][j] = Math.max(dp[i-1][j], array[s].getSum()+ dp[i-1][j-array[s].count]);                    
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
                // System.out.print(dp[i][j]+" ");
            }
            i++;
            // System.out.println();
        }


        System.out.println(dp[set.size()][K-1]);
    
    }


    public static class Node{
        int count;
        long value;
        long sum;
        
        Node(long value){
            this.count = 1;
            this.value= value;
            this.sum=value;
        }

        public void update(long sum){
            this.count++;
            this.sum+=sum;
        }

        public long getSum(){
            return this.sum;
        }

    }



}
