package com.wst.lab1;

public class ThrottlingException extends Exception
{
    private static final long serialVersionUID = -6647544772732631047L;

    public ThrottlingException(String message)
    {  super(message); }
}
