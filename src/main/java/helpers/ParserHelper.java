package helpers;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ParserHelper {
    public static List<Integer> parseTankerArrayString(String input) {
        return Stream.of(input.substring(input.indexOf("(") + 1, input.indexOf(")")).split(","))
                .filter(v -> !v.isEmpty())
                .map(StringUtils::trim)
                .map(Integer::parseInt)
                .collect(toList());
    }
}