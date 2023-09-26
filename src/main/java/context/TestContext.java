package context;


import java.util.HashMap;

public class TestContext {
    public HashMap<String, Object> getMap() {
        return map;
    }

    private HashMap<String, Object> map;

    public TestContext(){
        this.map= new HashMap<>();
    }

    public <T> T get(String key){
        Object item = map.get(key);
        if(item!=null){
            return (T)item;
        }else{
            throw new IllegalArgumentException("Item not found in context");
        }
    }
    public void put(String key, Object item){
        map.put(key,item);
    }

    public void print(){
        for (String i :map.keySet()){
            System.out.println(i);
        }
    }


}
