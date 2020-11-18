package gof.prototype;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrototypeApp {

    public static void main(String[] args) {

        Letter letter = new Letter();
        letter.setTitle("Title");
        letter.setContent("Content");
        letter.setDate(LocalDate.of(2000, 10, 1));
        letter.setReceiver("Ktoś");

        System.out.println(letter);

        List<Letter> letters = Stream.of("Adresta 1", "Adresat 2", "Adresat 3").map(addr -> {
            Letter l = new Letter();
            letter.setTitle("Title");
            letter.setContent("Content");
            letter.setDate(LocalDate.of(2000, 10, 1));
            letter.setReceiver(addr);
            return l;
        }).collect(Collectors.toList());

        Template template = new Template();
        template.setTitle("Title");
        template.setContent("Content");
        template.setDate(LocalDate.of(2000, 10, 1));
        template.setReceiver("Ktoś");

        Letter someLetter = template.letter();
        someLetter.setReceiver("Adresat 5");

        template.letter("Adresat 6");

        System.out.println(template);

        List<Letter> aLotOfLetters = IntStream
                .iterate(0, i -> i + 1)
                .limit(500)
                .mapToObj(i -> "Adresat " + i)
                .map(template::letter)
                .collect(Collectors.toList());
        
        System.out.println(aLotOfLetters);

    }
}
