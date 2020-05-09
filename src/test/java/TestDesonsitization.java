import org.bson.BSONObject;
import org.bson.BasicBSONObject;
import top.elizabath.tankwar.conn.desensitization.DesensitizationManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDesonsitization {
    public static void main(String[] args) {
        //db.Demo.find({$or:[{$and:[{state1:11},{state2:22}]},{value:{$gte:300}}]})
        //db.books.find({info:{$elemMatch:{data:{$elemMatch:{house_id:"2185216"}}}}})
        // db.Demos.find({info:{$elemMatch:{data:{$elemMatch:{house_id:"2185216"}}}}})
        //db.Demos.find({info:{$elemMatch:{data:{$elemMatch:{house_id:"2185216"}}}}})
        Map<String, Object> metadata = new HashMap<>();
        Map<String, Object> filterMap = new HashMap<>();
        List<Map<String, Object>> filterList = new ArrayList<>();
        List<Map<String, Object>> filterList2 = new ArrayList<>();
        Map<String, Object> filterMapListMap = new HashMap<>();
        Map<String, Object> filterMapListMap2 = new HashMap<>();
        Map<String, Object> filterMapListMap3 = new HashMap<>();
        Map<String, Object> projection = new HashMap<>();
        projection.put("age", 0);
        projection.put("name", 0);
        metadata.put("findOne", "Demo");
        metadata.put("filter", filterMap);
        //metadata.put("filter", null);
        //filterMap.put("$or", filterList);

        filterList.add(filterMapListMap);
        filterMapListMap2.put("state1", 11);
        filterMapListMap2.put("state2", "22");
        filterList2.add(filterMapListMap2);
        filterMapListMap.put("$and", filterList2);

        filterMapListMap3.put("$gte", 300);
        filterMapListMap.put("value", filterMapListMap3);
        metadata.put("projection", projection);
        Map<String, Object> a = new HashMap<>();

        a.put("$rt", 39);
//        filterMap.put("age", a);
//        filterMap.put("in.name", "张三");
//        filterMap.put("card", "1501231997456454546");
//        filterMap.put("address", "中国");


        Map<String, Object> objectObjectHashMap = new HashMap<>();
        Map<String, Object> objectObjectHashMap3 = new HashMap<>();
        Map<String, Object> objectObjectHashMap2 = new HashMap<>();
        Map<String, Object> objectObjectHashMap1 = new HashMap<>();
        objectObjectHashMap.put("$elemMatch", objectObjectHashMap1);
        objectObjectHashMap1.put("data", objectObjectHashMap2);
        objectObjectHashMap3.put("house_id", "2185216");
        objectObjectHashMap2.put("$elemMatch", objectObjectHashMap3);
        filterMap.put("info", objectObjectHashMap);
        BSONObject bsonObject = new BasicBSONObject();
        bsonObject.put("metadata", metadata);
        // StringBuilder stringBuilder = ProcessUtil.processCommand(metadata);
        //System.out.println(stringBuilder);
        Map<String, String> script = new HashMap<>();
        script.put("aa", "if('id'in item){item.id=item.id.replace(item.id.substring(6,19),'**********')};");
        BSONObject bsonObject1 = DesensitizationManager.processMongodb(bsonObject, script);
        System.out.println(bsonObject1);

    }
}
