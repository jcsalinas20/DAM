import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Prueba {

	public static void main(String[] args) {
        System.out.println("Prueba conexión MongoDB");
        crearConexion();
 
//        if (mongo != null) {
// 
//        } else {
//            System.out.println("Error: Conexión no establecida");
//        }
    }
 
    private static void crearConexion() {
        MongoClientURI uri = new MongoClientURI("mongodb+srv://admin:admin@clustersalinas-hvex2.mongodb.net/Tienda?retryWrites=true&w=majority");
        
        try(MongoClient mongo = new MongoClient(uri)) {
        	MongoDatabase database = mongo.getDatabase("Tienda");
        	MongoCollection<Document> collection = database.getCollection("Consolas");
        	
        	FindIterable<Document> docs = collection.find();
        	for (Document doc : docs) {
				System.out.println(doc);
			}
        	
//            printDatabases(mongo);
        }
    }
 
    @SuppressWarnings("deprecation")
	private static void printDatabases(MongoClient mongo) {
        List<String> dbs = mongo.getDatabaseNames();
        System.out.println("Lista de bases de datos: ");
        for (String db : dbs) {
            System.out.println(" - " + db);
        }
    }
}