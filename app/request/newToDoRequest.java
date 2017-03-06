package request;

import play.mvc.Http;
import play.mvc.Http.Request;
import scala.Int;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Created by kevin on 03/03/17.
 */
public class newToDoRequest extends BaseBodyRequest{

        private String title;
        private String description;
        private Date date;

        private static final SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");

        public newToDoRequest(Request request) {
            super(request);
            this.title = getString("title");
            this.description = getString("description");
        }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

}
