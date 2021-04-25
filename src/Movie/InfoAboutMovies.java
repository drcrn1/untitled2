package Movie;
import java.util.Scanner;

class Movie{
    String name;
    String country;
    String genre;
    int year;
    double price;
    public void printMovie() { System.out.println(this.name + " " + this.country + " " + this.genre + " " + this.year + " " + this.price);}

}
public class InfoAboutMovies{
    static Scanner sc;
    static double avgP;
    public static Movie[] fillArray(int count) {
        Movie[] movies = new Movie[count];
        for (int i = 0; i < count; i++) {
            movies[i] = new Movie();
            System.out.println("Введите название");
            movies[i].name = sc.nextLine();
            System.out.println("Введите страну");
            movies[i].country = sc.nextLine();
            System.out.println("Введите жанр");
            movies[i].genre = sc.nextLine();
            System.out.println("Введите год");
            movies[i].year = sc.nextInt();
            System.out.println("Введите цену");
            movies[i].price = sc.nextDouble();
            sc.nextLine();
        }
        return movies;
    }
    public static void printMovies(Movie[]movies){
        for (int i=0; i< movies.length; i++){
            movies[i].printMovie();
        }
    }
    public static Movie findFirstMovie(Movie[]movies){
        int minYear = movies[0].year;
        int indexMinYear = 0;
        for (int i = 0; i < movies.length; i++){
            if(movies[i].year < minYear){
                minYear = movies[i].year;
                indexMinYear = i;
            }
        }
        return movies[indexMinYear];
    }
    public static double avgPrice(Movie[]movies){
        double avgPrice = 0;
        for (int i=0; i < movies.length; i++){
            avgPrice+= movies[i].price;
        }
        return (avgPrice/ movies.length);
    }
    public static void printMovieAvgPrice(Movie[]movies, double avgP){
        for (int i=0; i < movies.length; i++){
            if(movies[i].price > avgP){
                movies[i].printMovie();
            }
        }
    }
    public static void sortName (Movie[]movies){
        for (int i=0; i < movies.length-1; i++){
            for (int j=0; j < movies.length-i-1; j++){
                if (movies[j].name.compareTo(movies[i+1].name)>0){
                    Movie rab=movies[j];
                    movies[j]=movies[j+1];
                    movies[j+1]=rab;
                }
            }
        }
    }
    public static int findMovie (Movie[]movies, String name){
        int index= -1;
        for (int i=0; i < movies.length; i++){
            if(name.equals(movies[i].name)){
                index = i;
            }
        }
        return index;
    }
    public static Movie redMovie(Movie movie){
        System.out.println("Какое поле хотите изменить");
        System.out.println("name, country, genre, year, price");
        String namePole = sc.nextLine();
        switch (namePole){
            case "name":{
                System.out.println("Введите новое имя");
                String newName = sc.nextLine();
                movie.name = newName;
                break;
            }
            case "country":{
                System.out.println("Введите новую страну");
                String newCountry = sc.nextLine();
                movie.country = newCountry;
                break;
            }
            case "genre":{
                System.out.println("Введите новый жанр");
                String newGenre = sc.nextLine();
                movie.genre = newGenre;
                break;
            }
            case "year":{
                System.out.println("Введите новый год выпуска");
                int newYear = sc.nextInt();
                movie.year = newYear;
                break;
            }
            case "price":{
                System.out.println("Введите новую цену");
                int newPrice = sc.nextInt();
                movie.price = newPrice;
                break;
            }
            default:{
                System.out.println("Такого поля нет");
            }
        }
        return movie;
    }
    public static void main(String[] args){
        Movie movie = new Movie();
        movie.printMovie();
        movie.name = "it";

        sc = new Scanner(System.in);
        System.out.println("Count=>");
        int count = sc.nextInt();
        sc.nextLine();
        Movie[] movies = fillArray (count);
        printMovies(movies);
        Movie FirstMovie = findFirstMovie(movies);
        System.out.println("Самая первая книга");
        FirstMovie.printMovie();
        avgP = avgPrice(movies);
        System.out.println("Avg price = " + avgP);
        printMovieAvgPrice (movies, avgP);
        sortName(movies);
        System.out.println("Отсортированный список по названиям");
        printMovies(movies);

        System.out.println("Введите искомое имя");
        String nameS = sc.nextLine();
        int indexS = findMovie(movies, nameS);
        if (indexS!= -1){
            System.out.println("Найдена запись");
            System.out.println(movies[indexS]);
            movies[indexS] = redMovie(movies[indexS]);
            System.out.println(movies[indexS]);
        }
        else {
            System.out.println("Ничего не найдено");
        }
    }
}