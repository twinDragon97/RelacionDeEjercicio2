import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;


public class Ejercicio1 {

	public static void main(String[] args) {
		try {
			leerXMLConSax("personas.xml");
		} catch (SAXException | IOException | ParserConfigurationException e) {
			System.out.println("Error " + e.getMessage());
		}
	}

	private static void leerXMLConSax(String nombreFichero)
			throws FileNotFoundException, SAXException, IOException, ParserConfigurationException {

		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		SAXParser parser = parserFactory.newSAXParser();

		XMLReader reader = parser.getXMLReader();
		
		Oyente oyente=new Oyente();
		reader.setContentHandler(oyente);
		
		reader.parse(new InputSource(nombreFichero));

	}

}
