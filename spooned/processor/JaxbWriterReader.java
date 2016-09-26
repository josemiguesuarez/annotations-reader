package processor;


/** 
 * Utility class to marshall and unmarshall xml files using JAXB
 * @author carlos
 */
public class JaxbWriterReader {
    /** 
     * Reads the contents of an xml with JAXB
     * 
     * @param classType
     *            the class type of the root of the document
     * @param path
     *            path to the file to load
     * @return an object representing the root of the file loaded
     */
    public static java.lang.Object jaxbReader(java.lang.Class<?>  classType, java.lang.String path) {
        java.lang.Object root = null;
        try {
            javax.xml.bind.JAXBContext context = javax.xml.bind.JAXBContext.newInstance(classType);
            root = context.createUnmarshaller().unmarshal(new java.io.FileReader(path));
        } catch (javax.xml.bind.JAXBException e) {
            java.lang.System.err.println(("Error while reading the JAXB model in: " + path));
            e.printStackTrace();
        } catch (java.io.FileNotFoundException e) {
            java.lang.System.err.println(("Error while trying to load the file: " + path));
            e.printStackTrace();
        }
        return root;
    }
    
    /** 
     * Reads the contents of an xml with JAXB and validates it with an schema
     * 
     * @param classType
     *            the class type of the root of the document
     * @param pathToXML
     *            path to the xml file to load
     * @param pathToXSD
     *            path to the xsd used for the validation
     * @return an object representing the root of the file loaded
     */
    public static java.lang.Object jaxbReaderSchemaValidation(java.lang.Class<?>  classType, java.lang.String pathToXML, java.lang.String pathToXSD) {
        java.lang.Object root = null;
        try {
            javax.xml.bind.JAXBContext context = javax.xml.bind.JAXBContext.newInstance(classType);
            javax.xml.bind.Unmarshaller unmarshaller = context.createUnmarshaller();
            javax.xml.validation.Schema schema = javax.xml.validation.SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(new java.io.File(pathToXSD));
            unmarshaller.setSchema(schema);
            root = unmarshaller.unmarshal(new java.io.FileReader(pathToXML));
        } catch (javax.xml.bind.JAXBException e) {
            java.lang.System.err.println(((("Error while reading the JAXB model in: " + pathToXML) + " with the schema: ") + pathToXSD));
            e.printStackTrace();
            java.lang.System.exit(1);
        } catch (java.io.FileNotFoundException e) {
            java.lang.System.err.println(("Error while trying to load the file: " + pathToXML));
            e.printStackTrace();
        } catch (org.xml.sax.SAXException e) {
            java.lang.System.err.println(((("Error while processing the file " + pathToXML) + " with the schema: ") + pathToXSD));
            e.printStackTrace();
            java.lang.System.exit(1);
        }
        return root;
    }
    
    /** 
     * Writes the contents of a JAXB model in an xml file with identation and
     * blank spaces without schema verification
     * 
     * @param root
     *            the root of the object to write
     * @param path
     *            destination of the file to create
     */
    public static void jaxbWriterNoSchema(java.lang.Object root, java.lang.String path) {
        try {
            javax.xml.bind.JAXBContext context = javax.xml.bind.JAXBContext.newInstance(root.getClass());
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT ,java.lang.Boolean.TRUE);
            marshaller.marshal(root ,new java.io.FileWriter(path));
        } catch (javax.xml.bind.JAXBException e) {
            java.lang.System.err.println(("Error while preparing to write the JAXB model in: " + path));
            e.printStackTrace();
        } catch (java.io.IOException e) {
            java.lang.System.err.println(("Error while writting the JAXB model in: " + path));
            e.printStackTrace();
        }
    }
    
    /** 
     * Writes the contents of a JAXB model in an xml file with identation and
     * blank spaces and schema verification
     * 
     * @param root
     *            the root of the object to write
     * @param path
     *            destination of the file to create
     */
    public static void jaxbWriter(java.lang.Object root, java.lang.String path, java.lang.String schema) {
        try {
            javax.xml.bind.JAXBContext context = javax.xml.bind.JAXBContext.newInstance(root.getClass());
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_SCHEMA_LOCATION ,schema);
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT ,java.lang.Boolean.TRUE);
            marshaller.marshal(root ,new java.io.FileWriter(path));
        } catch (javax.xml.bind.JAXBException e) {
            java.lang.System.err.println(("Error while preparing to write the JAXB model in: " + path));
            e.printStackTrace();
        } catch (java.io.IOException e) {
            java.lang.System.err.println(("Error while writting the JAXB model in: " + path));
            e.printStackTrace();
        }
    }
    
}

