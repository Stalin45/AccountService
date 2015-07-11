package web.com.accountservice.responses;

/**
 * @Author Илья
 * @Created 07.07.2015.
 */
public enum ResponseStatus {

    OK(0),

    TECHNICAL_ERROR(9999);

    private Integer statusCode;

    ResponseStatus(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        return this.statusCode.toString();
    }
}
