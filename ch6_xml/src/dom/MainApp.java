package dom;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MainApp {
	
	public static void main(String[] args) {
		DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
		try {
		         DocumentBuilder builder= factory.newDocumentBuilder();
		         Document doc=builder.parse("D:\\CodeProjects\\JavaIDEAProjects\\WebService_Demo\\ch6_xml\\src\\xml\\girls.xml");
		         NodeList nodelist=doc.getElementsByTagName("girls");
		         Element element=(Element)nodelist.item(0);
		         NodeList nodelists =element.getElementsByTagName("girl");
		         for(int i=0;i<nodelists.getLength();i++){
		             Element e=(Element)nodelists.item(i);
		             System.out.println("Name: "+e.getElementsByTagName("name").item(0).getFirstChild().getNodeValue());
		             //printNode(e.getElementsByTagName("name").item(0));
		             System.out.println("Age: "+e.getElementsByTagName("age").item(0).getFirstChild().getNodeValue());
		             System.out.println("1===============================================");
		         }
		     } catch (Exception e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		     }
	}
	@Test
	public void testOne() {
		DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
		try {
		         DocumentBuilder builder= factory.newDocumentBuilder();
		         Document doc=builder.parse("src/xml/girls.xml");
		         NodeList nodelist=doc.getElementsByTagName("girls");
		         Element element=(Element)nodelist.item(0);
		         NodeList nodelists =element.getElementsByTagName("girl");
		         
		         List<Girl> list = new ArrayList<Girl>();
		         Girl girl = null;
		         for(int i=0;i<nodelists.getLength();i++){
		             Element e=(Element)nodelists.item(i);
		             girl = new Girl();
		             girl.setId(nodelists.item(i).getAttributes().item(0).getFirstChild().getNodeValue());
		             girl.setName(e.getElementsByTagName("name").item(0).getFirstChild().getNodeValue());
		             girl.setAge(e.getElementsByTagName("age").item(0).getFirstChild().getNodeValue());
		             list.add(girl);
		         }
		         System.out.println("Print Info" + list);
		     } catch (Exception e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		     }
	}
	
	//read property
     public static void printNode(Node node){
      NamedNodeMap nodemap=node.getAttributes();
      for(int i=0;i<nodemap.getLength();i++){
          Node e=nodemap.item(i);
          System.out.println(e.getNodeName()+" : "+e.getFirstChild().getNodeValue());
        }
     }
}
