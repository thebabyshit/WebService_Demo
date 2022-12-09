package dom;

import java.io.File;

public class DomTest {
	
	public static void main(String[] args) {
		File file = new File("D:\\CodeProjects\\JavaIDEAProjects\\WebService_Demo\\ch6_xml\\src\\xml\\girls.xml");
	    new DoXmlWithDOM().readXML(file); 
	}
}
