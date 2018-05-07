package com.hbfintech.pay.common.exception;



import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 访问禁止异常
 *
 *
 */
@JsonAutoDetect(fieldVisibility = Visibility.NONE, getterVisibility = Visibility.PUBLIC_ONLY, setterVisibility = Visibility.NONE)
@JsonIgnoreProperties(
{ "cause", "class", "localizedMessage", "stackTrace", "suppressed" })
public class AccessForbiddenException extends RuntimeException
{
    private static final long serialVersionUID = -3256637135660248064L;

    public AccessForbiddenException(String message)
    {
        super(message);
    }

    @Override
    @JsonProperty(value = "message")
    public String getMessage()
    {
        return super.getMessage();
    }
}
