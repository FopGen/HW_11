import java.io.BufferedInputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;


public class Main {
    public static void main(String[] args) {

//-------- Завдання 1
        List<String> names = List.of("Ivan", "Peter", "Zuzanna", "Mukola", "Evgen", "Anton");
        System.out.print("Відповідь №1 : ");

                IntStream.range(0, names.size())
                .filter(i -> i%2==1)
                .mapToObj(names::get)
                .map(name->names.indexOf(name)+ " " +name +", ")
                .forEach(System.out::print);


//-------- Завдання 2

        System.out.println();
        List<String> sortedList = names.stream()
                .map(String::toUpperCase)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("Відповідь №2 : " + sortedList);


//-------- Завдання 3

        String[] array = {"1,2,0","4,5"};
        System.out.print("Відповідь №3 : ");

        Stream<String> sumaryArray = Arrays.stream(array);
                sumaryArray.map(s->s.split(","))
                .flatMap(Arrays::stream)
                .sorted()
                .collect(Collectors.toList())
                        .forEach(System.out::print);

//-------- Завдання 4
        System.out.println();
        System.out.print("Відповідь №4 : ");

        BigDecimal a = new BigDecimal(25214903917l);
        int c = 11;
        BigDecimal m = new BigDecimal(Math.pow(2,48));
        BigDecimal seed = new BigDecimal(System.currentTimeMillis());

        Stream.iterate(seed, x-> ((a.multiply(x).add(BigDecimal.valueOf(c))).remainder(m)))
                .limit(10)
                .forEach(x-> System.out.print(x.longValue()+" - "));

//-------- Завдання 5
        Stream <Integer> first = Stream.of(1, 3, 5, 7);
        Stream <Integer> second = Stream.of(2, 4, 6, 8, 10);
        
        Stream<Integer> mixed = zip(first, second);
        System.out.println();
        System.out.print("Відповідь №5 : ");
        System.out.println(mixed.collect(Collectors.toList()));
        
    }
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){

        List<T> listFirst = first.collect(Collectors.toList());
        List<T> listSecond = second.collect(Collectors.toList());

        int count = Math.min(listFirst.size(), listSecond.size());

        List<T> output = new ArrayList<>();

        for (int i=0; i<count; i++){
            output.add(listFirst.get(i));
            output.add(listSecond.get(i));
        }

        return output.stream();
    }
}