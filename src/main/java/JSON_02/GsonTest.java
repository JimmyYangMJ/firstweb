package JSON_02;

import java.util.Arrays;

import JSON_02.Person;
import JSON_Gson.CreateFileUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * 采用Google GSON来处理JSON
 * @author Tom
 *
 */
public class GsonTest {
    public static void main(String[] args) {
        testJsonObject();
        System.out.println("=======================");

       // testJsonFile();
    }
    public static void testJsonObject() {
        //构造对象
        Person p = new Person();
        p.setName("Tom");
        p.setAge(20);
        p.setScores(Arrays.asList(60,70,80));

        //从Java对象到JSON字符串
        Gson gson = new Gson();
        String s = gson.toJson(p);
        System.out.println(s); //{"name":"Tom","age":20,"scores":[60,70,80]}


        //从JSON字符串到Java对象
        Person p2 = gson.fromJson(s, Person.class);
        System.out.println(p2.getName());  //Tom
        System.out.println(p2.getAge());   //20
        System.out.println(p2.getScores());//[60, 70, 80]

        //调用GSON的JsonObject
        JsonObject json = gson.toJsonTree(p).getAsJsonObject(); //将整个json解析为一颗树
        System.out.println(json.get("name"));  //"Tom"
        System.out.println(json.get("age"));   //20
        System.out.println(json.get("scores"));//[60,70,80]
        CreateFileUtil.createJsonFile(gson.toString(),"JSON_Gson","json66");
    }

}
