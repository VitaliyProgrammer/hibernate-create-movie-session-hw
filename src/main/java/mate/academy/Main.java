package mate.academy;

import mate.academy.model.Movie;
import mate.academy.service.MovieService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import mate.academy.util.HibernateUtil;


public class Main {
    public static void main(String[] args) {
        MovieService movieService = null;

        Movie fastAndFurious = new Movie("Fast and Furious");
        fastAndFurious.setDescription("An action film about street racing, heists, and spies.");
        movieService.add(fastAndFurious);
        System.out.println(movieService.get(fastAndFurious.getId()));
        movieService.getAll().forEach(System.out::println);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            System.out.println("Hibernate connected successfully!");
        } catch (Exception e) {
            System.out.println("Hibernate connection Failed!" + e);
        }
    }
}
