package peaksoft.exceptions;

    public class DaoOperationException extends Exception {
        public DaoOperationException(String message, Throwable cause) {
            super(message, cause);
        }

        public DaoOperationException(String message) {
            super(message);
        }
    }


