package ejercicio5;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new File("videojuegos.xml"));
			Element root = doc.getDocumentElement();
			Element juegos = doc.createElement("Juegos");
			Element play = doc.createElement("PlayStation4");

			NodeList nList = doc.getElementsByTagName("Juegos");
			root.removeChild(play);
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					if (nNode.getParentNode().getNodeName().equals("PlayStation4")) {
						Element juego = doc.createElement("Juego");
						juego.appendChild(doc.createTextNode(nNode.getNodeValue()));
						juegos.appendChild(juego);// Creacion de la etiqueta edat con la edat dentro de la etiqueta
													// persona
					}
					Element juego = doc.createElement("Juego");
					juego.appendChild(doc.createTextNode("The last of us 2"));
					juegos.appendChild(juego);// Creacion de la etiqueta edat con la edat dentro de la etiqueta persona
				}
			}
			play.appendChild(juegos);
			root.appendChild(play);

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer t = tf.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult sResult = new StreamResult(new File("videojuegos.xml"));

			t.transform(source, sResult);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Echo");
	}

}
