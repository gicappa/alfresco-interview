package alfresco;

@SuppressWarnings("all")
public class ErrorReponse {

    private final ErrorFields error;

    public ErrorReponse(String type, String code, String message) {
        error = new ErrorFields(type, code, message);
    }

    public ErrorFields getError() {
        return error;
    }

    public static class ErrorFields {
        private final String type;
        private final String code;
        private final String message;

        public ErrorFields(String type, String code, String message) {
            this.type = type;
            this.code = code;
            this.message = message;
        }

        public String getType() {
            return type;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }
}

