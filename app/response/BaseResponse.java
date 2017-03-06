package response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Preconditions;

/**
 * Created by kevin on 03/03/17.
 */

@JsonInclude(Include.NON_NULL)
public class BaseResponse {
    public enum ResponseStatus {
        SUCCESS, ERROR
    }

    @JsonProperty("status")
    private ResponseStatus status;

    @JsonProperty("message")
    private String message;

    public BaseResponse(ResponseStatus status, String message) {
        Preconditions.checkNotNull(status);
        Preconditions.checkArgument(message != null && !message.isEmpty());

        this.status = status;
        this.message = message;
    }

    public BaseResponse() {
        this.status = ResponseStatus.SUCCESS;
    }

    public BaseResponse(ResponseStatus status) {
        this.status = status;
    }

    /**
     * @return the status
     */
    public ResponseStatus getStatus() {
        return status;
    }
}
