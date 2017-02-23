package com.wwwyb.until;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;


/**
 * Created by 吴亚斌 on 2017/2/2.
 */
public class Dom4JUtil {
    private static String dbFilePath;//xml文件的路径
    static {
        //获取users.xml的真是路径
        URL url= Dom4JUtil.class.getClassLoader().getResource("com/wwwyb/until/users.xml");
        dbFilePath=url.getPath();
    }
    public  static Document getDocument() throws DocumentException {
        SAXReader sr=new SAXReader();
        return sr.read(dbFilePath);
    }
    public static void write2xml(Document document) throws Exception {
        OutputStream out= new FileOutputStream(dbFilePath);
        OutputFormat format= OutputFormat.createPrettyPrint();

        XMLWriter xmlWriter =new XMLWriter(out,format);
        xmlWriter.write(document);
        xmlWriter.close();
    }
}
