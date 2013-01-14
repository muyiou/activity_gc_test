import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;


public class ActivityReference extends SoftReference{

    String name; 
    
    static ReferenceQueue<ActivityReference> collectedQueue = new ReferenceQueue<ActivityReference>();
    
    public ActivityReference(Activity activity) {
        //向回收队列注册activity的引用，如果activity被回收,该引用会被加入到collectedQueue里
        super(activity,collectedQueue);
        this.name = activity.mShelfName;
    }
}
