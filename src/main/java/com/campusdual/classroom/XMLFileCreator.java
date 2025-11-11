package com.campusdual.classroom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLFileCreator {

    public static void createDocument() {
        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();


            Element rootElement = doc.createElement("shoppinglist");
            doc.appendChild(rootElement);


            Element itemsElement = doc.createElement("items");
            rootElement.appendChild(itemsElement);


            addItem(doc, itemsElement, "Manzana", 2);
            addItem(doc, itemsElement, "Leche", 1);
            addItem(doc, itemsElement, "Pan", 3);
            addItem(doc, itemsElement, "Huevo", 2);
            addItem(doc, itemsElement, "Queso", 1);
            addItem(doc, itemsElement, "Cereal", 1);
            addItem(doc, itemsElement, "Agua", 4);
            addItem(doc, itemsElement, "Yogur", 6);
            addItem(doc, itemsElement, "Arroz", 2);


            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            DOMSource source = new DOMSource(doc);

            File file = new File("src/main/resources/shoppingList.xml");
            file.getParentFile().mkdirs();
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private static void addItem(Document doc, Element parent, String name, int quantity) {
        Element item = doc.createElement("item");
        item.setAttribute("quantity", String.valueOf(quantity));
        item.appendChild(doc.createTextNode(name));
        parent.appendChild(item);
    }
}
