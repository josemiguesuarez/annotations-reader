//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.19 at 10:43:37 AM COT 
//


package generated;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}struct"/>
 *         &lt;element ref="{}constraints"/>
 *         &lt;element name="comments" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{}featureOrder"/>
 *       &lt;/sequence>
 *       &lt;attribute name="chosenLayoutAlgorithm" type="{http://www.w3.org/2001/XMLSchema}integer" default="4" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "struct",
    "constraints",
    "comments",
    "featureOrder"
})
@XmlRootElement(name = "featureModel")
public class FeatureModel {

    @XmlElement(required = true)
    protected Struct struct;
    @XmlElement(required = true)
    protected Constraints constraints;
    @XmlElement(required = true)
    protected String comments;
    @XmlElement(required = true)
    protected FeatureOrder featureOrder;
    @XmlAttribute(name = "chosenLayoutAlgorithm")
    protected BigInteger chosenLayoutAlgorithm;

    /**
     * Gets the value of the struct property.
     * 
     * @return
     *     possible object is
     *     {@link Struct }
     *     
     */
    public Struct getStruct() {
        return struct;
    }

    /**
     * Sets the value of the struct property.
     * 
     * @param value
     *     allowed object is
     *     {@link Struct }
     *     
     */
    public void setStruct(Struct value) {
        this.struct = value;
    }

    /**
     * Gets the value of the constraints property.
     * 
     * @return
     *     possible object is
     *     {@link Constraints }
     *     
     */
    public Constraints getConstraints() {
        return constraints;
    }

    /**
     * Sets the value of the constraints property.
     * 
     * @param value
     *     allowed object is
     *     {@link Constraints }
     *     
     */
    public void setConstraints(Constraints value) {
        this.constraints = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComments(String value) {
        this.comments = value;
    }

    /**
     * Gets the value of the featureOrder property.
     * 
     * @return
     *     possible object is
     *     {@link FeatureOrder }
     *     
     */
    public FeatureOrder getFeatureOrder() {
        return featureOrder;
    }

    /**
     * Sets the value of the featureOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link FeatureOrder }
     *     
     */
    public void setFeatureOrder(FeatureOrder value) {
        this.featureOrder = value;
    }

    /**
     * Gets the value of the chosenLayoutAlgorithm property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getChosenLayoutAlgorithm() {
        if (chosenLayoutAlgorithm == null) {
            return new BigInteger("4");
        } else {
            return chosenLayoutAlgorithm;
        }
    }

    /**
     * Sets the value of the chosenLayoutAlgorithm property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setChosenLayoutAlgorithm(BigInteger value) {
        this.chosenLayoutAlgorithm = value;
    }

}
