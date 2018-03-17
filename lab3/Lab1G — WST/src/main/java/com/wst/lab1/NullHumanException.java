package com.wst.lab1;

import javax.xml.ws.WebFault;

/** Предок для SOAP-ошибок, инициализирует fault */

@WebFault(faultBean = "com.wst.lab1.PersonServiceFault")
public class NullHumanException extends Exception
{
    private static final long serialVersionUID = -6647544772732631047L;
    private final PersonServiceFault fault;

    public NullHumanException(String message, PersonServiceFault fault)
    {
        super(message);
        this.fault = fault;
    }

    public NullHumanException(String message, PersonServiceFault fault, Throwable cause)
    {
        super(message, cause);
        this.fault = fault;
    }

    public PersonServiceFault getFaultInfo()
    { return fault; }
}
