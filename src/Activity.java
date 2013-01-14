public class Activity{
    public String mShelfName;
    
    View[] views = new View[50];
    
    public Activity(String selfName){
        this.mShelfName = selfName;
        
        for(int i = 0; i < views.length ;i++){
            views[i] = new View();
        }
    }
}