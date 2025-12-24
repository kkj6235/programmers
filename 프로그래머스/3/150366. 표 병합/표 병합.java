import java.io.*;
import java.util.*;

class Solution {
    
    // 부모 값
    // 자기 자신 원래 값
    
    // 부모 찾기 함수 union-find 로직 구상..
    
    
    public Point find(Point p){
        
        if(parent[p.x][p.y]==null){
            return p;
        }
        
        return parent[p.x][p.y]=find(parent[p.x][p.y]);
    }
    public boolean union(Point a, Point b){
        
        a = find(a);
        b= find(b);
        
        // 부모 같음
        if(a.x==b.x && a.y==b.y){
            return false;    
        }
        
        // 부모 안 같을 경우
        parent[b.x][b.y]=a;
        
        return true;
    }
    // union 함수도..!
    String[][] grid;
    Point[][] parent;
    int maxX, maxY;
    // value1 -> value2로 바꾸기 위함..
    // value1을 모두 검색할수가 없다!

    public List<String> solution(String[] commands) {
        List<String> answer = new ArrayList<>();
        
        grid = new String[50][50];
        parent = new Point[50][50];
    

        StringTokenizer st;
        
        maxX = Integer.MIN_VALUE;
        maxY = Integer.MIN_VALUE;
        
        for(String cmd : commands){
            st = new StringTokenizer(cmd);
            
            String code = st.nextToken();
            
            if(code.equals("UPDATE")){
                
                String a = st.nextToken();
                String b = st.nextToken();
                
                if(st.hasMoreTokens()){
                    int r = Integer.parseInt(a);
                    int c= Integer.parseInt(b);
                    
                    maxX = Math.max(maxX, r);
                    maxY = Math.max(maxY, c);
                    String value = st.nextToken();

                    Point p = find(new Point(r-1,c-1));
                    
                    grid[p.x][p.y] = value;
                                      
                    
                }
                else{
                    
                    for(int i=0;i<50;i++){
                        for(int j=0;j<50;j++){
                            
                            if(grid[i][j]==null && parent[i][j]==null){
                                continue;
                            }
                            
                            Point p = find(new Point(i,j));
                            
                            if(grid[p.x][p.y]==null){
                                continue;
                            }
                            if(grid[p.x][p.y].equals(a)){                            
                                grid[p.x][p.y] = b;
                            }

                        }
                    }
                    
                }
                
            }
            else if(code.equals("MERGE")){
                           
                int r1 = Integer.parseInt(st.nextToken());
                int c1 = Integer.parseInt(st.nextToken());

                int r2 = Integer.parseInt(st.nextToken());
                int c2 = Integer.parseInt(st.nextToken());
                
                maxX = Math.max(maxX, r1-1);
                maxY = Math.max(maxY, c1-1);
                
                maxX = Math.max(maxX, r2-1);
                maxY = Math.max(maxY, c2-1);
                
                if(r1==r2 && c1==c2){
                    continue;
                }
                Point p1 = find(new Point(r1-1,c1-1));
                Point p2 = find(new Point(r2-1,c2-1));
                
                if(p1.x==p2.x && p1.y==p2.y){
                    continue;
                }
                
                // 2. 이미 같은 그룹이면 아무것도 하지 않음
                if (p1.x == p2.x && p1.y == p2.y) continue;

                // 3. 우선순위에 따른 값 결정 (p1의 값 우선, 없으면 p2의 값)
                String finalValue = (grid[p1.x][p1.y] != null) ? grid[p1.x][p1.y] : grid[p2.x][p2.y];

                // 4. Union 수행 (p2를 p1에 병합한다고 가정)
                union(p1, p2); 

                // 5. 값 업데이트: 기존 두 부모의 값은 비우고, '새로운' 부모 위치에 값을 넣음
                // (union 내부 로직에 따라 새로운 root가 p1이 아닐 수도 있으므로 다시 find 하거나 p1을 root로 강제)
                grid[p1.x][p1.y] = null;
                grid[p2.x][p2.y] = null;

                Point root = find(p1); // 병합 후의 최종 대표자
                grid[root.x][root.y] = finalValue;
                
                // print();
                
            }
            else if(code.equals("UNMERGE")){
             
                // print();
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                
                Point p1 = find(new Point(r-1,c-1));
                
                String value = grid[p1.x][p1.y];
                for(int i=0;i<50;i++){
                    for(int j=0;j<50;j++){
                        if(grid[i][j]==null && parent[i][j]==null){
                            continue;
                        }
                        
                        Point p = find(new Point(i,j));
                        if(p.x == p1.x && p.y==p1.y){
                            grid[i][j]=null;
                            parent[i][j]=null;
                        }
                    }
                }
                grid[r-1][c-1]=value;
            }
            else if(code.equals("PRINT")){
                
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                
                Point p = find(new Point(r-1,c-1));
                // 부모 찾기!
                if(grid[p.x][p.y]==null){
                    answer.add("EMPTY");
                    continue;
                }
                
                // Point p = find(new Point(r,c));
                answer.add(grid[p.x][p.y]);
                // print();
                
            }
            print();
            
        }
        
        return answer;
    }
    
    public void print(){
        
        for(int i=0;i<maxX;i++){
            for(int j=0;j<maxY;j++){
                find(new Point(i,j));
                
                // if(grid[p.x][p.y]==null){
                //     System.out.print(" ");
                // }
                // else{
                //     System.out.print(grid[p.x][p.y]+" ");
                // }
            }
            // System.out.println();
        }   
        
        // System.out.println();
        
    }
    class Point{
        int x;
        int y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}

/*

	["UPDATE 1 1 A", "UPDATE 2 2 B", "UPDATE 3 3 C", "UPDATE 4 4 D", "MERGE 1 1 2 2", "MERGE 3 3 4 4", "MERGE 1 1 4 4", "UNMERGE 3 3", "PRINT 1 1", "PRINT 2 2", "PRINT 3 3", "PRINT 4 4"]

*/