package configFile;

import lombok.SneakyThrows;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class GeneralXml {

    //cream aici o logica care sa citesca din fisierul "atfConfig.xml" si sa incerce sa il deserealize sub o anumita structura

  @SneakyThrows(JAXBException.class)
    public static <T> T createConfig(Class<T> klass){
        //acesta este un object care te ajuta pe tine sa creeze o instanta de context care sa aiba structura clasei pe care tu o specifici
        // de exemplu poate fi : backend sau frontend in cazul nostru
        JAXBContext jaxbContext = JAXBContext.newInstance(klass);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return klass.cast(unmarshaller.unmarshal(new File("atfConfig.xml")));
    }


}
