
package mypackage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mypackage package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RemoveHuman_QNAME = new QName("http://lab1.wst.com/", "removeHuman");
    private final static QName _GetPersons_QNAME = new QName("http://lab1.wst.com/", "getPersons");
    private final static QName _RemoveHumanResponse_QNAME = new QName("http://lab1.wst.com/", "removeHumanResponse");
    private final static QName _AddHuman_QNAME = new QName("http://lab1.wst.com/", "addHuman");
    private final static QName _GetHumans2_QNAME = new QName("http://lab1.wst.com/", "getHumans2");
    private final static QName _GetHumans2Response_QNAME = new QName("http://lab1.wst.com/", "getHumans2Response");
    private final static QName _AddHumanResponse_QNAME = new QName("http://lab1.wst.com/", "addHumanResponse");
    private final static QName _NullHumanException_QNAME = new QName("http://lab1.wst.com/", "NullHumanException");
    private final static QName _GetPersonsResponse_QNAME = new QName("http://lab1.wst.com/", "getPersonsResponse");
    private final static QName _ChangeHuman_QNAME = new QName("http://lab1.wst.com/", "changeHuman");
    private final static QName _IncorrectIdException_QNAME = new QName("http://lab1.wst.com/", "IncorrectIdException");
    private final static QName _GetHumansResponse_QNAME = new QName("http://lab1.wst.com/", "getHumansResponse");
    private final static QName _GetHumans_QNAME = new QName("http://lab1.wst.com/", "getHumans");
    private final static QName _ChangeHumanResponse_QNAME = new QName("http://lab1.wst.com/", "changeHumanResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetHumans2Response }
     * 
     */
    public GetHumans2Response createGetHumans2Response() {
        return new GetHumans2Response();
    }

    /**
     * Create an instance of {@link ChangeHuman }
     * 
     */
    public ChangeHuman createChangeHuman() {
        return new ChangeHuman();
    }

    /**
     * Create an instance of {@link PersonServiceFault }
     * 
     */
    public PersonServiceFault createPersonServiceFault() {
        return new PersonServiceFault();
    }

    /**
     * Create an instance of {@link GetPersonsResponse }
     * 
     */
    public GetPersonsResponse createGetPersonsResponse() {
        return new GetPersonsResponse();
    }

    /**
     * Create an instance of {@link GetHumans2 }
     * 
     */
    public GetHumans2 createGetHumans2() {
        return new GetHumans2();
    }

    /**
     * Create an instance of {@link ChangeHumanResponse }
     * 
     */
    public ChangeHumanResponse createChangeHumanResponse() {
        return new ChangeHumanResponse();
    }

    /**
     * Create an instance of {@link RemoveHumanResponse }
     * 
     */
    public RemoveHumanResponse createRemoveHumanResponse() {
        return new RemoveHumanResponse();
    }

    /**
     * Create an instance of {@link RemoveHuman }
     * 
     */
    public RemoveHuman createRemoveHuman() {
        return new RemoveHuman();
    }

    /**
     * Create an instance of {@link GetPersons }
     * 
     */
    public GetPersons createGetPersons() {
        return new GetPersons();
    }

    /**
     * Create an instance of {@link AddHumanResponse }
     * 
     */
    public AddHumanResponse createAddHumanResponse() {
        return new AddHumanResponse();
    }

    /**
     * Create an instance of {@link AddHuman }
     * 
     */
    public AddHuman createAddHuman() {
        return new AddHuman();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link Human }
     * 
     */
    public Human createHuman() {
        return new Human();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveHuman }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1.wst.com/", name = "removeHuman")
    public JAXBElement<RemoveHuman> createRemoveHuman(RemoveHuman value) {
        return new JAXBElement<RemoveHuman>(_RemoveHuman_QNAME, RemoveHuman.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersons }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1.wst.com/", name = "getPersons")
    public JAXBElement<GetPersons> createGetPersons(GetPersons value) {
        return new JAXBElement<GetPersons>(_GetPersons_QNAME, GetPersons.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveHumanResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1.wst.com/", name = "removeHumanResponse")
    public JAXBElement<RemoveHumanResponse> createRemoveHumanResponse(RemoveHumanResponse value) {
        return new JAXBElement<RemoveHumanResponse>(_RemoveHumanResponse_QNAME, RemoveHumanResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddHuman }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1.wst.com/", name = "addHuman")
    public JAXBElement<AddHuman> createAddHuman(AddHuman value) {
        return new JAXBElement<AddHuman>(_AddHuman_QNAME, AddHuman.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHumans2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1.wst.com/", name = "getHumans2")
    public JAXBElement<GetHumans2> createGetHumans2(GetHumans2 value) {
        return new JAXBElement<GetHumans2>(_GetHumans2_QNAME, GetHumans2 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHumans2Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1.wst.com/", name = "getHumans2Response")
    public JAXBElement<GetHumans2Response> createGetHumans2Response(GetHumans2Response value) {
        return new JAXBElement<GetHumans2Response>(_GetHumans2Response_QNAME, GetHumans2Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddHumanResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1.wst.com/", name = "addHumanResponse")
    public JAXBElement<AddHumanResponse> createAddHumanResponse(AddHumanResponse value) {
        return new JAXBElement<AddHumanResponse>(_AddHumanResponse_QNAME, AddHumanResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1.wst.com/", name = "NullHumanException")
    public JAXBElement<PersonServiceFault> createNullHumanException(PersonServiceFault value) {
        return new JAXBElement<PersonServiceFault>(_NullHumanException_QNAME, PersonServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1.wst.com/", name = "getPersonsResponse")
    public JAXBElement<GetPersonsResponse> createGetPersonsResponse(GetPersonsResponse value) {
        return new JAXBElement<GetPersonsResponse>(_GetPersonsResponse_QNAME, GetPersonsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeHuman }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1.wst.com/", name = "changeHuman")
    public JAXBElement<ChangeHuman> createChangeHuman(ChangeHuman value) {
        return new JAXBElement<ChangeHuman>(_ChangeHuman_QNAME, ChangeHuman.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1.wst.com/", name = "IncorrectIdException")
    public JAXBElement<PersonServiceFault> createIncorrectIdException(PersonServiceFault value) {
        return new JAXBElement<PersonServiceFault>(_IncorrectIdException_QNAME, PersonServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHumans2Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1.wst.com/", name = "getHumansResponse")
    public JAXBElement<GetHumans2Response> createGetHumansResponse(GetHumans2Response value) {
        return new JAXBElement<GetHumans2Response>(_GetHumansResponse_QNAME, GetHumans2Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHumans2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1.wst.com/", name = "getHumans")
    public JAXBElement<GetHumans2> createGetHumans(GetHumans2 value) {
        return new JAXBElement<GetHumans2>(_GetHumans_QNAME, GetHumans2 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeHumanResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1.wst.com/", name = "changeHumanResponse")
    public JAXBElement<ChangeHumanResponse> createChangeHumanResponse(ChangeHumanResponse value) {
        return new JAXBElement<ChangeHumanResponse>(_ChangeHumanResponse_QNAME, ChangeHumanResponse.class, null, value);
    }

}
