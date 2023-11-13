package christmas.validator;

import java.util.regex.Pattern;

public final class InputValidator {

    private static final Pattern NON_INTEGER_PATTERN = Pattern.compile("^(?!-?\\d+$).+");
    private static final Pattern ORDER_INPUT_PATTERN = Pattern.compile(
        "^([a-zA-Z가-힣0-9]+-\\d+)(,[a-zA-Z가-힣0-9]+-\\d+)*");

    private InputValidator() {
        // 인스턴스 생성 방지
    }

    public static Boolean isNonInteger(String input) {
        return NON_INTEGER_PATTERN.matcher(input).matches();
    }

    public static Boolean isInvalidOrderInput(String input) {
        return !ORDER_INPUT_PATTERN.matcher(input).matches();
    }
}
