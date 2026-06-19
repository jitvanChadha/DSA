import java.util.ArrayDeque;
import java.util.Queue;
public class StackUsingQueue {
    static Queue<Integer> q = new ArrayDeque<>();
    public static void main(String [] args){
        push(10);
        push(20);
        push(30);
        pop();
        pop();
        push(14);
        System.out.print("The top element right now is:"+q.peek());
    }
    static void push(int x){
        int s = q.size();
        q.add(x);
        for (int i= 0 ; i< s ; i++){
            q.add(q.peek());
            q.remove();
        }
    }
    static void pop(){
        q.remove();
    }
}
