package Home;

import Stream.Curso;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Java8Ejer {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Cursos profesional de Java", 6.5f, 50, 200 ));
        cursos.add(new Curso("Cursos profesional de Python", 8.5f, 60, 800 ));
        cursos.add(new Curso("Cursos profesional de DB", 4.5f, 70, 700 ));
        cursos.add(new Curso("Cursos profesional de Android", 7.5f, 10, 400 ));
        cursos.add(new Curso("Cursos profesional de Escritura", 1.5f, 10, 300 ));

        //Obtener la cantidad de cursos con una duración mayor a 5 horas.
        Long cant =  cursos.stream().filter(c -> c.getDuracion() > 5).count();
        System.out.println("cant = " + cant);
        //Obtener la cantidad de cursos con una duración menor a 2 horas.
        Long cant2 =  cursos.stream().filter(c -> c.getDuracion() < 2).count();
        System.out.println("cant = " + cant2);
        //Listar el título de todos aquellos cursos con una cantidad de vídeos mayor a 50.
        cursos.stream().filter(c -> c.getVideos() > 50).forEach(curso -> System.out.println(curso.getTitulo()));
        System.out.println("");
        cursos.stream().filter(c -> c.getVideos() > 50).map(Curso::getTitulo).forEach(System.out::println);
        //Mostrar en consola el título de los 3 cursos con mayor duración.
        System.out.println("-");
        cursos.stream()
                .sorted(Comparator.comparing(Curso::getDuracion).reversed())
                .limit(3)
                .map(Curso::getTitulo)
                .forEach(System.out::println);
        //Mostrar en consola la duración total de todos los cursos.
        System.out.println("-");
        Double totalHoras = cursos.stream()
                .mapToDouble(Curso::getDuracion)
                        .sum();
        System.out.println("totalHoras = " + totalHoras);
        //Mostrar en consola todos aquellos libros que superen el promedio en cuanto a duración se refiere.
        Double promedio = cursos.stream()
                .mapToDouble(Curso::getDuracion)
                .average().getAsDouble();
         cursos.stream().filter(c -> c.getDuracion() > promedio)
                 .map(Curso::getTitulo)
                 .forEach(System.out::println);
        //Mostrar en consola la duración de todos aquellos cursos que tengan una cantidad de alumnos inscritos menor a 500.
        System.out.println("xxxxxxx");
        cursos.stream()
                .filter(curso -> curso.getAlumnos() < 500)
                .map(Curso::getDuracion)
                .forEach(System.out::println);
        //Obtener el curso con mayor duración.
        System.out.println("xxxxxxx");
        cursos.stream()
                .sorted(Comparator.comparing(Curso::getDuracion).reversed())
                .limit(1)
                .map(Curso::getTitulo)
                .forEach(System.out::println);

        cursos.stream()
                .max(Comparator.comparing(Curso::getDuracion))
                .ifPresent(x -> System.out.println(x.getTitulo()));

        //Crear una lista de Strings con todos los titulos de los cursos.
        System.out.println("--");
        List<String> titulos = cursos.stream()
                .map(Curso::getTitulo).toList();
        titulos.forEach(System.out::println);
    }


}
