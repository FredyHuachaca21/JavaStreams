package Home;

import java.util.Arrays;

public class Sorted {

    public static void main(String[] args) {
        int[] enteros = {4,2,7,1,8};

        for (int i = 0; i < enteros.length; i++) {
            for (int j = i+1; j < enteros.length; j++) {
                int temp = 0;
                if (enteros[i] > enteros[j]){
                    temp = enteros[i];
                    enteros[i] = enteros[j];
                    enteros[j] = temp;
                }
            }
            System.out.println(enteros[i]);
        }

        System.out.println("-");
        Arrays.stream(enteros).asLongStream().sorted().forEach(System.out::println);
    }




}
