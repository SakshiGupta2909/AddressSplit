public class RegexMapper {

        public static  String NUMBER_AFTER_SPACE = "(?=\\s\\d+)";
        public static  String CHARACTER_AFTER_SPACE = "(?<=\\s)(?=[a-zA-Z])";
        public static  String AFTER_WHITESPACE = "\\s";
        public static  String START_WITH_DIGIT =  "^(\\d+.*|-\\d+.*)";

    }