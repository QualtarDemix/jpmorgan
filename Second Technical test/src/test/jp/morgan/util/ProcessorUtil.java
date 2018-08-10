package test.jp.morgan.util;

import test.jp.morgan.enums.MessageType;
import test.jp.morgan.enums.Operator;

public class ProcessorUtil {

    public static MessageType getMessageType(String message) {
        if (message.matches("\\d.*")) {
            return MessageType.type2;
        } else if (isOperator(message.split("\\s")[0])) {
            return MessageType.type3;
        }
        return MessageType.type1;
    }

    public static boolean isOperator(String firstString) {
        Operator[] values = Operator.values();
        for (Operator value : values) {
            if (value.toString().equals(firstString)) {
                return true;
            }
        }
        return false;
    }
}
