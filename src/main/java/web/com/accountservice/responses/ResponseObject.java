package web.com.accountservice.responses;

/**
 * @Author Илья
 * @Created 07.07.2015.
 */
public abstract class ResponseObject {

    private Integer status;

    private Exception error;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Exception getError() {
        return error;
    }

    public void setError(Exception error) {
        this.error = error;
    }
}
