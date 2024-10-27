package configFile.configNodes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="configuration")
public class Configuration {
    //dupa ce am deserializat in clasa "GeneralXml" - aici am structura sub care vreau sa fie deserializat

    @XmlElement(name = "BackendConfig")
    public BackendConfig backendConfig;

    @XmlElement(name = "FrontendConfig")
    public FrontendConfig frontendConfig;

}
