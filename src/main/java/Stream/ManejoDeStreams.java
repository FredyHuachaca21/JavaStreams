package Stream;

import javax.xml.parsers.SAXParser;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Esta clase sirve para el manejo de flujos Stream
 * @author Fredy Huachaca
 * @version 1.0.0
 * @since 2022-12-14
 */
public class ManejoDeStreams {
    public void streamVacio(){
        Stream<String> streamEmpty = Stream.empty();
        System.out.println("Esto es un Stream Vacio = " + streamEmpty);
    }
    public Stream<String> streamOf(List<String> list) {
        System.out.println("list = " + list);
        return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }
    public void streamDeColleccion(){
        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamOfCollection = collection.stream();
        streamOfCollection.forEach(System.out::println);
    }
    public void streamArray(){
        Stream<String> streamOfArray = Stream.of("a", "b", "c");
                streamOfArray.forEach(System.out::println);
    }

    public void streamArray2(){
        String[] arr = new String[]{"a", "b", "c", "d", "1"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        streamOfArrayFull.forEach(System.out::println);
        System.out.println("=====================");
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
        streamOfArrayPart.forEach(System.out::println);
    }

    public void steamBuilder(){
        Stream<String> streamBuilder =
                Stream.<String>builder().add("a").add("b").add("c").build();

        streamBuilder.forEach(System.out::println);
    }

    public void streamGenerate(){
        Stream<String> streamGenerated = Stream.generate(()-> "elemento").limit(10);
        Stream<Integer> streamGeneratedNumbers = Stream.generate(()-> (int) (Math.random() * 100)).limit(10);
        streamGeneratedNumbers.forEach(System.out::println);
        streamGenerated.forEach(System.out::println);
    }

    public void streamIterate(){
        Stream<Integer> streamIterate = Stream.iterate(40, n -> n + 2 ).limit(5);
        streamIterate.forEach(System.out::println);
        System.out.println("-------");
        Stream<Integer> unoAlDiez = Stream.iterate(1, n -> n+1).limit(10);
        unoAlDiez.forEach(System.out::println);
    }

    public void streamPrimitives(){
        IntStream intStream = IntStream.range(1, 5);
        LongStream longStream = LongStream.rangeClosed(1, 5);
        intStream.forEach(System.out::println);
        System.out.println("=====");
        longStream.forEach(System.out::println);
    }
    public void streamPrimitiveDouble(){
        Random random = new Random();
        DoubleStream doubleStream = random.doubles(5);
        doubleStream.forEach(System.out::println);
    }

    public void streamString(){
        IntStream streamOfChars = "Fredy".chars();
        streamOfChars.forEach(System.out::println);
    }





}
