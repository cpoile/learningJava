package chris.HackerRank;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LocalesMap {
    public static void main(String[] varargs) {
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
//        Map<String, String> langs = locales.collect(
//                Collectors.toMap(
//                        Locale::getDisplayLanguage,
//                        loc -> loc.getDisplayLanguage(loc),
//                        (existingVal, newVal) -> existingVal))
        //langs.forEach((k, v) -> System.out.println(k + ": " + v));

        Map<String, List<String>> langs2 = locales.collect(
                Collectors.groupingBy(Locale::getDisplayCountry,
                        Collectors.mapping(l -> l.getDisplayLanguage(l),
                                Collectors.toList())));
        langs2.forEach((k, v) -> System.out.println(k + ": " + v));

        //locales.forEach(l -> System.out.println(l.getDisplayCountry() + ": " + l.getDisplayLanguage()));

    }
}
