package exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 06/03/17.
 */
public class ErrorListException extends Exception {
        private List<String> errors;

        public ErrorListException() {
            super();
            errors = new ArrayList<>();
        }

        public ErrorListException(String message) {
            this();
            errors.add(message);
        }

        public void add(ErrorListException other) {
            errors.addAll(other.getErrors());
        }

        public void add(String otherMessage) {
            errors.add(otherMessage);
        }

        public boolean isEmpty() {
            return errors.size() == 0 ;
        }

        public List<String> getErrors() {
            return new ArrayList<>(errors);
        }
}
