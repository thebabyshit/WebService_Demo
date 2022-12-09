package sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {
	//准备一个用于添加xml数据的集合、调用Girl类、准一个用于用来保存开始的标签的tag
	private List<Girl> girls;
	private Girl girl;
	private String tag;

	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		//因为这个方法只调用一次，所以在开始的时候就可以实例化集合
		girls = new ArrayList<>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		//  这个方法，只有当开始一个元素的时候才会调用，
		// 通过分析，当外部开始元素为girl的时候，需要将girl实例化
		//System.out.println("uri:" +uri + "; localName:" + localName + "; qName:" + qName);
		//将tag赋值
		tag = qName;
		if ("girl".equals(qName)) {
			girl = new Girl();
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		//这句话，必须写，因为，当sax解析完一个元素的时候，会自动认为换行符是一个字符，会继续执行character方法。如果不写，就会造成没有数据的现象。
		tag = "";

		//这个方法，当到了元素结尾的时候，会调用，应该在这里，将对象添加到集合里面去。
		if ("girl".equals(qName)) {
			girls.add(girl);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		//这里是内容，但是，无法直接判断属于哪一个元素。
		String string = new String(ch, start, length);
		// 这两种情况，表示 当前语句执行在 girls 标签内。
		if ("name".equals(tag)) {
			girl.setName(string);
		} else if ("age".equals(tag)) {
			girl.setAge(string);
		}
	}

	//外部设置和获得值（getter setter）
	public List<Girl> getGirls() {
		return girls;
	}

	public void setGirls(List<Girl> girls) {
		this.girls = girls;
	}

	public Girl getGirl() {
		return girl;
	}

	public void setGirl(Girl girl) {
		this.girl = girl;
	}
}
