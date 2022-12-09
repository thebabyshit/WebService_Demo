package sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {
	//׼��һ���������xml���ݵļ��ϡ�����Girl�ࡢ׼һ�������������濪ʼ�ı�ǩ��tag
	private List<Girl> girls;
	private Girl girl;
	private String tag;

	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		//��Ϊ�������ֻ����һ�Σ������ڿ�ʼ��ʱ��Ϳ���ʵ��������
		girls = new ArrayList<>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		//  ���������ֻ�е���ʼһ��Ԫ�ص�ʱ��Ż���ã�
		// ͨ�����������ⲿ��ʼԪ��Ϊgirl��ʱ����Ҫ��girlʵ����
		//System.out.println("uri:" +uri + "; localName:" + localName + "; qName:" + qName);
		//��tag��ֵ
		tag = qName;
		if ("girl".equals(qName)) {
			girl = new Girl();
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		//��仰������д����Ϊ����sax������һ��Ԫ�ص�ʱ�򣬻��Զ���Ϊ���з���һ���ַ��������ִ��character�����������д���ͻ����û�����ݵ�����
		tag = "";

		//���������������Ԫ�ؽ�β��ʱ�򣬻���ã�Ӧ���������������ӵ���������ȥ��
		if ("girl".equals(qName)) {
			girls.add(girl);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		//���������ݣ����ǣ��޷�ֱ���ж�������һ��Ԫ�ء�
		String string = new String(ch, start, length);
		// �������������ʾ ��ǰ���ִ���� girls ��ǩ�ڡ�
		if ("name".equals(tag)) {
			girl.setName(string);
		} else if ("age".equals(tag)) {
			girl.setAge(string);
		}
	}

	//�ⲿ���úͻ��ֵ��getter setter��
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
