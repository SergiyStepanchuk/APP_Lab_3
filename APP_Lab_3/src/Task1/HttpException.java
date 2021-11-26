package Task1;

public class HttpException extends RuntimeException
{
    HttpCode httpCode;

    public HttpException(final HttpCode httpCode) {
        this(httpCode, "");
    }

    public HttpException(final HttpCode httpCode, final String message) {
        this(httpCode, message, "");
    }

    public HttpException(final HttpCode httpCode, final String message, final String addiotionalInfo) {
        super("HTTP ERROR: " + httpCode.toString() +
                (message.length() > 0 ? "\n\tMessage: " + message : "" ) +
                (addiotionalInfo.length() > 0 ? "\n\tAddiotional info: " + addiotionalInfo : ""));
        this.httpCode = httpCode;
    }

    public HttpCode getHttpCode() {
        return httpCode;
    }
}
