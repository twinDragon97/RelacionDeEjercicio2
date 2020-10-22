import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Oyente extends DefaultHandler {

	private String nombreDelMasViejo, nombreActual;
	private int edadDelMasViejo = 0;
	private String elementoActual;

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String contenido = new String(ch, start, length);
		int edad;

		// System.out.println(contenido);
		contenido.replaceAll("\t\n", "");

		if (contenido.length() > 0) {
			switch (elementoActual) {
			case "edad":
				
				edad = Integer.parseInt(contenido);
				if (edadDelMasViejo < edad) {
					edadDelMasViejo = edad;
					this.nombreDelMasViejo = nombreActual;
				}
				break;
			case "nombre": {
				
				nombreActual = contenido;
				break;
			}
			}
		}

	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("El mas viejo es " + nombreDelMasViejo + " con " + edadDelMasViejo + " Annos.");
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		elementoActual = "";
	}

	@Override
	public void startDocument() throws SAXException {

	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// System.out.println(qName);
		elementoActual = qName;
	}

}
