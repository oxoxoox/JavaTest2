import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Theardtest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        ExecutorService es = Executors.newFixedThreadPool(1000);
        List<Future<Long> > futures=new ArrayList<>(1000);
        long ans=0;
        for(int i=0; i<100;i++){
            futures.add(es.submit(new Task(i,x)));
        }

        for(Future<Long>future:futures){
            try {
                ans+=future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(ans);
    }
}
class Task implements Callable<Long>{
    private  final int name,x;
    public Task(int name,int x){
        this.name=name;
        this.x=x;
    }
    private long ans;
    private boolean contain(long num, int x) {
        return String.valueOf(num).contains(String.valueOf(x));
    }
    @Override
    public Long call() throws Exception {
        for(int i=10000000*name;i<10000000*(name+1);i++){
            if (contain(i, x)) ans += i;
        }
        return ans;
    }
}

