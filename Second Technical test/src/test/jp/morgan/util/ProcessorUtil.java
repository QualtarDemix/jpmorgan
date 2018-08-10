package test.jp.morgan.util;

import test.jp.morgan.enums.MessageType;
import test.jp.morgan.enums.Operator;

import static test.jp.morgan.constant.MessageConstants.ANY_DIGIT_REGEX;
import static test.jp.morgan.constant.MessageConstants.SPACE_REGEX;

public class ProcessorUtil {


    public static MessageType getMessageType(String message) {
        if (message.matches(ANY_DIGIT_REGEX)) {
            return MessageType.type2;
        } else if (isOperator(message.split(SPACE_REGEX)[0])) {
            return MessageType.type3;
        }
        return MessageType.type1;
    }

    public static boolean isOperator(String firstString) {
        Operator[] values = Operator.values();
        for (Operator value : values) {
            if (value.toString().equalsIgnoreCase(firstString)) {
                return true;
            }
        }
        return false;
    }
}
