import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.util.regex.Pattern;

public class Q6 {
    public static void main(String[] args) throws SAXException, 
    IOException, ParserConfigurationException {

        String search = "asus-i5-config" ;

        new Q6("SaveRoot.xml", search);

    }
    public Q6(final String file, String search ) throws SAXException,
     IOException,ParserConfigurationException {
        final DocumentBuilderFactory DBFac = DocumentBuilderFactory.newInstance();
        final DocumentBuilder DocBuild = DBFac.newDocumentBuilder();
        final Document Doc = DocBuild.parse(this.getClass().getResourceAsStream(file));
        final List<String> l = new ArrayList<String>();
        parse(Doc, l, Doc.getDocumentElement(),search, Pattern.compile(search),Pattern.CASE_INSENSITIVE);
    }

    private void parse(final Document Doc, final List<String> list, final Element e,
     String search, Pattern pattern) {
        final NodeList children = e.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            final Node n = children.item(i);
            if(n.getNodeName().equals("Folder")) {
                parse(Doc, list, e, search, pattern);
            }
            else if (n.getNodeName().equals("File")){
                String filename = n.getTextContent();
                if(pattern.matcher(filename).find()){
                    System.out.println(filename);
                }
            }
        }
    }

     public void save(final String file,String search) {
     Document dom;
     Element a = null;
     DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     try {

         DocumentBuilder db = dbf.newDocumentBuilder();

         dom = db.newDocument();
 
         Element rootEle = dom.createElement();

     }
 }
}
