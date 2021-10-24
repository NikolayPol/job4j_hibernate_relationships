package store;

import model.Brand;
import model.Model;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Класс HbmRun.
 *
 * Сохраняем ассоциированные модели - мы получаем список записей, которые ассоциированы
 * с объектом и уже в этот список добавляем записи, которые необходимо сохранить.
 *
 * @author Nikolay Polegaev
 * @version 1.0 24.10.2021
 */
public class HbmRunOneToMany {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            Model one = Model.of("A4");
            Model two = Model.of("S5");
            Model three = Model.of("TT");
            Model four = Model.of("Q7");
            Model five = Model.of("S5");
            session.save(one);
            session.save(two);
            session.save(three);
            session.save(four);
            session.save(five);

            Brand brand = Brand.of("AUDI");
            brand.addModel(session.load(Model.class, 1));
            brand.addModel(session.load(Model.class, 2));
            brand.addModel(session.load(Model.class, 3));
            brand.addModel(session.load(Model.class, 4));
            brand.addModel(session.load(Model.class, 5));

            session.save(brand);

            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
