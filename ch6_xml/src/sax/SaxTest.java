package sax;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SaxTest {

    public static void main(String[] args) {
//     1.创建连接
        SAXParserFactory newInstance = SAXParserFactory.newInstance();
        try {
//      2.获取解析器
            SAXParser saxParser = newInstance.newSAXParser();
//      3.调用方法，执行xml解析
            File file = new File("D:\\CodeProjects\\JavaIDEAProjects\\WebService_Demo\\ch6_xml\\src\\xml\\girls.xml");
            MyHandler dh = new MyHandler();
            saxParser.parse(file, dh);
            List<Girl> girls = dh.getGirls();
//      4.输出集合
            System.out.println(girls);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
