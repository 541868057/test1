package com.mongodb;
import java.net.UnknownHostException;  
import java.util.ArrayList;  
import java.util.List;  
  
import com.mongodb.BasicDBObject;  
import com.mongodb.BasicDBObjectBuilder;  
import com.mongodb.DB;  
import com.mongodb.DBCollection;  
import com.mongodb.DBObject;  
import com.mongodb.Mongo;  
public class MongoDBTest1 {
	public static void main(String[] args) throws UnknownHostException {  
        
        /** 
         * Mongo类代表与MongoDB服务器的连接，有多种构造函数。无参构造函数默认连接localhost:27017. 
         */  
        Mongo connection = new Mongo("localhost:20000");  
        /** 
         * DB类代表数据库，如果当前服务器上没有该数据库，会默认创建一个 
         */  
        DB db = connection.getDB("mylearndb");  
        /** 
         * DBCollection代表集合，如果数据库中没有该集合，会默认创建一个 
         */  
        DBCollection fruitShop = db.getCollection("fruitshop");  
        /** 
         *  创建水果店文档对象 
         */  
        DBObject shop1 = new BasicDBObject();  
        shop1.put("name", "The Fruit King");  
        /** 
         *  水果店内水果保存在一个内嵌文档的数组中，格式为： 
         *  [{"name" : "apple", "quality" : "good", "price" : "5.6"},  
         *   {"name" : "orange", "quality" : "normal", "price" : "1.5"}, 
         *   ......] 
         */  
        // 数组通过List表示  
        List<DBObject> fruits = new ArrayList<DBObject>();  
        // 数组中的每一个文档，我们通过BasicDBObjectBuilder来构造  
        fruits.add(BasicDBObjectBuilder.start().add("name", "apple").add("quality", "good").add("price", "5.6").get());  
        fruits.add(BasicDBObjectBuilder.start().add("name", "orange").add("quality", "normal").add("price", "1.5").get());  
        shop1.put("fruits", fruits);  
          
        fruitShop.insert(shop1);  
          
    }
}
