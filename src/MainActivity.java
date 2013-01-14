public class MainActivity {
    
    public static void main(String[] args){
        
        //新建一个弱引用的数组，主要还是实例化ReferenceQueue
        ActivityReference[] refs = new ActivityReference[10];
        
       //开始监控线程
        GarbageMonitor monitor = new GarbageMonitor(ActivityReference.collectedQueue);
        monitor.start();
        
        for(int i = 0 ;i< refs.length;i++){
            //这里模拟activity的创建,创建activity的同时，关联activity到ReferenceQueue
            refs[i] = new ActivityReference(new Activity((i + 1) + ""));
            System.out.print("create activity : " + (i + 1) + "\n");
        }
    }
}
