import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreacionFicheroXML {

	public static void main(String[] args) throws Exception {
		File archivoDAT = new File("myPeople.dat");// Ruta fichero .dat
		File archivoXML = new File("personas.xml");// Ruta fichero .xml

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();

		Element raiz = doc.createElement("Persones");
		doc.appendChild(raiz);// Creacion del elemento raiz

		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(archivoDAT));// Lectura del
																										// archivo
		for (int i = 0; i < 5; i++) {
			Persona p = (Persona) objectInputStream.readObject();// Lectura del objeto
			Element persona = doc.createElement("persona");
				Attr nom = doc.createAttribute("nom");
				nom.setValue(p.getNombreApellido());
				persona.setAttributeNode(nom);// Creacion del atributo nom dentro de persona
			raiz.appendChild(persona);// Creacion de la etiqueta persona

			Element edat = doc.createElement("edat");
			edat.appendChild(doc.createTextNode("" + p.getEdad()));
			persona.appendChild(edat);// Creacion de la etiqueta edat con la edat dentro de la etiqueta persona
		}
		objectInputStream.close();

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult sResult = new StreamResult(archivoXML);

		t.transform(source, sResult);
	}

}
