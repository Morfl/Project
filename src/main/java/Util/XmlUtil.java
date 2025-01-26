package Util;

import Entity.CombinedInfo;;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlUtil {

    private static final Logger XmlUtilLogger = Logger.getLogger(JsonUtil.class.getName());

    private XmlUtil() {
    }

    public static void createXmlFile(CombinedInfo combinedInfo, String path) {
        try {
            File file = new File(path + "/Info.xml");
            file.getParentFile().mkdirs();


            JAXBContext contextStat = JAXBContext.newInstance(CombinedInfo.class);
            Marshaller mar1 = contextStat.createMarshaller();
            mar1.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar1.marshal(combinedInfo, file);

            XmlUtilLogger.log(Level.INFO, "Информация записана в XML");
        } catch (JAXBException e) {
            e.printStackTrace();
            XmlUtilLogger.log(Level.SEVERE, "Скорее всего путь к файлу не найден во время создания XML файла");
        }
    }
}