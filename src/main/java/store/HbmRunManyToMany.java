package store;

import model.Author;
import model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Класс HbmRunManyToMany.
 *
 * @author Nikolay Polegaev
 * @version 1.0 24.10.2021
 */
public class HbmRunManyToMany {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            Book one = Book.of("Java 8");
            Book two = Book.of("Java 11");

            Author first = Author.of("Horstman");
            first.getBooks().add(one);
            first.getBooks().add(two);

            Author second = Author.of("Sсhildt");
            second.getBooks().add(two);

            Author author = session.get(Author.class, 1);
            session.remove(author);

            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
