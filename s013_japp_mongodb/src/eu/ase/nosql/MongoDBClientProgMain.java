package eu.ase.nosql;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDBClientProgMain {

	public static void main(String[] args) {
		try{
			MongoClient mongoClient = new MongoClient("10.2.65.198", 27017);
			
			//avem deja baza de date de la client
			MongoDatabase db = mongoClient.getDatabase("test");
			// db.createCollection("mycol");
			
			System.out.println("DB connection and collection get...");
			
			MongoCollection<Document> coll = db.getCollection("mycol");
			
			Document doc = new Document("title", "MongoDB 06")
					.append("description", "NoSQL Post")
					.append("likes", 160)
					.append("url", "www.secitc.eu")
					.append("by", "DICE");
			
			coll.insertOne(doc);
			System.out.println("Doc inserted = " + doc.toJson());
			
			FindIterable<Document> iterableFind = coll.find();
			MongoCursor<Document> cursor = iterableFind.iterator();
			
			int i = 1;
			while(cursor.hasNext()) {
				System.out.println("Inserted doc i = " + i + ", doc = " + cursor.next());
				i++;
			}
			
			mongoClient.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
