import java.lang.ref.ReferenceQueue;


public class GarbageMonitor extends Thread{

    ReferenceQueue<ActivityReference> queue;
    
    public GarbageMonitor(ReferenceQueue<ActivityReference> queue){
        this.queue = queue;
    }
    
    public void run(){
        while(true){
            try {
                //移除回收队列的下一个引用对象，线程会一直阻塞到下个引用生效
                ActivityReference ref = (ActivityReference) queue.remove();
                System.out.print("activity " + ref.name + " was collected \n");
            } catch (InterruptedException e) {
                System.out.print("error " + e.toString() + "\n");
                break;
            }
        }
    }
}
