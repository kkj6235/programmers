


import java.io.*;
import java.util.*;

public class Main {
		public static StringTokenizer st;
		public static BufferedReader br;
	    public static int N,K,L,count;
	    
	    public static Coordinate[] appleLo;
	    public static List<Info> snakeDirection;
	    
	    public static boolean[][] board;
	    
	    public static Coordinate head;
	    public static Map<String, Integer> map;
	    
	    
	    public static Deque<Coordinate> queue;
	    
	    // 위 1 오른쪽 2 아래 3 왼쪽 4
	    public static int direction;
	    
	    public static boolean check(Coordinate tmp) {
	    	
	    	// 벽에 닿는지    	
	    	if(tmp.x<0 || tmp.x>=N || tmp.y<0 || tmp.y>=N){
	    		
//	    		System.out.println(tmp.x+","+tmp.y);
//	    		System.out.println("벽에 닿음");
	    		return false;
	    	}
	    	
	    	// 나와 닿는지
	    	if(map.containsKey(tmp.x+","+tmp.y)) {
//	    		System.out.println("나와 닿음");
//	    		System.out.println(tmp.x+","+tmp.y);
	    		return false;
	    	}
	    		
	    	return true;
	    }
	    
	    public static Coordinate caculateNext() {
	    	
	    	
	    	if(direction==1) {
	    		return new Coordinate(head.x-1, head.y);
	    	}
	    	else if(direction==2) {
	    		return new Coordinate(head.x, head.y+1);
	    	}
	    	else if(direction==3) {
	    		return new Coordinate(head.x+1, head.y);
	    	}
	    	else if(direction==4) {
	    		return new Coordinate(head.x, head.y-1);
	    	}
	    	
	    	
	    	return new Coordinate(head);
	    }
	    
	    public static void main(String[] args) throws IOException{

	        br = new BufferedReader(new InputStreamReader(System.in));
	        
	        N = Integer.parseInt(br.readLine());
	        K = Integer.parseInt(br.readLine());
	        board = new boolean[N][N];
	        queue = new ArrayDeque<>();
	        
	        appleLo = new Coordinate[K];
	        
	        map = new HashMap<>();

	        for(int i=0;i<K;i++){
	            st = new StringTokenizer(br.readLine());
	            int x = Integer.parseInt(st.nextToken());
	            int y = Integer.parseInt(st.nextToken());

	            appleLo[i] = new Coordinate(x-1, y-1);
	            board[x-1][y-1] = true;
	        }
	        
	        L = Integer.parseInt(br.readLine());
	        snakeDirection = new ArrayList<>();
	        
	        for(int i=0;i<L;i++){
	            st = new StringTokenizer(br.readLine());
	            int second = Integer.parseInt(st.nextToken());
	            snakeDirection.add(new Info(second, st.nextToken().charAt(0)));
	        }

	        head = new Coordinate(0,0);
	        
	        map.put(0+","+0, 1);
	        queue.addFirst(new Coordinate(0,0));
	        direction = 2;
	        
	        count = 0;
	        
	        while(true) {
	        	
	        	
	        	// 현재 방향으로 전진
	        	count++;
	        	// 새로 추가하기
	        	Coordinate next = caculateNext();
	        	// 그리고 확인하기!!
	        	
	        	if(!check(next)) {
	        		break;
	        	}

	        	
        		head = new Coordinate(next);
        		map.put(head.x+","+head.y, 1);
//        		System.out.println(head.x+","+head.y+ " "+count);
        		queue.addFirst(new Coordinate(head));

        	
	        	if(!board[next.x][next.y]) {
	        		Coordinate tail = queue.pollLast();
	        		map.remove(tail.x+","+tail.y);
	        	}
	        	else {
	        		board[next.x][next.y]= false;
	        	}
	        	
	        	
		    	if(!snakeDirection.isEmpty()) {
			    	Info tmpInfo = snakeDirection.get(0);
			    	
			    	if(tmpInfo.second==count) {
			    		if(tmpInfo.direction=='L') {
			    			direction--;
			    			if(direction<1) {
			    				direction = 4;
			    			}
			    		}
			    		else {
			    			direction++;
			    			if(direction>4) {
			    				direction = 1;
			    			}
			    		}
			    		
			    		snakeDirection.remove(0);
			    	}
		    	}

	        }

//	        System.out.println("끝남");
	        System.out.println(count);

	    }

	    static class Coordinate{
	        int x;
	        int y;

	        Coordinate(int x,int y){
	            this.x = x;
	            this.y = y;
	        }
	        
	        Coordinate(Coordinate coor){
	        	this.x = coor.x;
	        	this.y = coor.y;
	        }
	    }

	    static class Info{
	        int second;
	        char direction;

	        Info(int second, char direction){
	            this.second = second;
	            this.direction = direction;
	        }
	        
	        Info(Info info){
	        	this.second = info.second;
	        	this.direction = info.direction;
	        }
	    }
}
