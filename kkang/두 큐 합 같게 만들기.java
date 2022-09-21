import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        LinkedList<Integer> q1 = new LinkedList<>();
        LinkedList<Integer> q2 = new LinkedList<>();
        int answer = 0;
        long sum = 0;
        long queue1Sum = 0;
        long queue2Sum = 0;
        for(int i=0;i<queue1.length;i++){
            sum+=queue1[i]+queue2[i];
            queue1Sum+=queue1[i];
            queue2Sum+=queue2[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        
        if(sum%2!=0)
            return -1;
        
        while(answer < queue1.length*3){
            if(queue1Sum>queue2Sum){
                Integer val = q1.poll();
                q2.add(val);
                queue1Sum-=val;
                queue2Sum+=val;
                answer++;
            }else if(queue1Sum<queue2Sum){
                Integer val = q2.poll();
                q1.add(val);
                queue2Sum-=val;
                queue1Sum+=val;
                answer++;
            }else{
                return answer;
            }
            
        }
        
        return -1;
    }
    
}
