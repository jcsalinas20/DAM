import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LecturaFicheroXML {

	public static void main(String[] args) throws Exception {
		File archivo = new File("personas.xml");// Ruta del fichero

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(archivo);

		doc.getDocumentElement().normalize();// Normalizar archivo

		NodeList nList = doc.getElementsByTagName("persona");// Contador de la etiqueta persona
		System.out.println("Elemento Raiz: Personas");
		System.out.println("Numero de personas: " + nList.getLength() + "\n");// Mostrar cuantas vezes esta la etiqueta
																				// persona

		for (int i = 0; i < nList.getLength(); i++) {
			Node node = nList.item(i);

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element ele = (Element) node;

				System.out.println(ele.getAttribute("nom") + ":");// Mostrar el nombre
				System.out.println("\tEdad: " + ele.getElementsByTagName("edat").item(0).getTextContent() + "\n");// Mostrar
																													// edad
			}
		}
	}

}
