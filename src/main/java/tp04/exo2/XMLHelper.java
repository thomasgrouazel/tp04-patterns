package tp04.exo2;

/**
 * Classe pour vous aider à produire du XML plus ou moins correct.
 */
public class XMLHelper {
    
    /**
     * Protège le minimum de caractères spéciaux dans le XML.
     */
    public static String protectText(String text) {
        return text.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");        
    }

    public static String protectAttributeValue(String value) {
        return protectText(value).replace("\"", "&quot;");        
    }
}
