package test.jp.morgan.parser;

import test.jp.morgan.dto.SaleDTO;
import test.jp.morgan.enums.MessageType;
import test.jp.morgan.enums.Operator;

import java.util.regex.*;

import static test.jp.morgan.constant.MessageConstants.*;

public class MessageParser {

    public SaleDTO parse(String message, MessageType messageType) {
        SaleDTO sale = null;
        try {
            String[] splitMessage = message.split(SPACE);
            Matcher matcher = Pattern.compile(DIGIT_REGEX).matcher(message);
            matcher.find();
            switch (messageType) {
                case type1:
                    sale = parseType1(splitMessage[0], matcher);
                    break;
                case type2:
                    sale = parseType2(splitMessage[3], matcher);
                    break;
                case type3:
                    sale = parseType3(splitMessage, matcher);
            }
        } catch (IllegalStateException e) {
            System.err.println(MATCH_OPERATION_FAILED_MESSSAGE);
        } catch (PatternSyntaxException e) {
            System.err.println(INCORRECT_FORMAT_MESSAGE);
        }
        return sale;
    }

    private SaleDTO parseType1(String fruitName, Matcher matcher) {
        Integer price = Integer.parseInt(matcher.group());
        return new SaleDTO(fruitName, price, 1, null);
    }

    private SaleDTO parseType2(String fruitName, Matcher matcher) {
        Integer quantity = Integer.parseInt(matcher.group());
        matcher.find();
        Integer price = Integer.parseInt(matcher.group());
        return new SaleDTO(fruitName, price, quantity, null);
    }

    private SaleDTO parseType3(String[] splitMessage, Matcher matcher) {
        SaleDTO sale = parseType1(splitMessage[2], matcher);
        String operator = splitMessage[0];
        sale.setOperator(Operator.valueOf(operator.toLowerCase()));
        return sale;
    }
}
