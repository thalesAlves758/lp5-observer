import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    void shouldNotifyOneUser() {
        Product product = new Product("Smartphone", 1000);

        User user = new User("thales@email.com");
        user.addProductAsFavorite(product);

        product.setPrice(900);

        Notification notification = user.getNotifications().get(0);

        assertEquals(1, user.getNotifications().size());
        assertEquals("Mudança de preço", notification.getTitle());
        assertEquals("O produto Smartphone obteve um desconto de 10,00%.", notification.getMessage());
    }

    @Test
    void shouldNotifyAllUsers() {
        Product product = new Product("Smartphone", 1000);

        User user = new User("thales@email.com");
        User secondUser = new User("test@email.com");

        user.addProductAsFavorite(product);
        secondUser.addProductAsFavorite(product);

        product.setPrice(900);

        Notification notificationFromFirstUser = user.getNotifications().get(0);
        Notification notificationFromSecondUser = user.getNotifications().get(0);

        assertEquals(1, user.getNotifications().size());
        assertEquals(1, secondUser.getNotifications().size());
        assertEquals("Mudança de preço", notificationFromFirstUser.getTitle());
        assertEquals("Mudança de preço", notificationFromSecondUser.getTitle());
        assertEquals("O produto Smartphone obteve um desconto de 10,00%.", notificationFromFirstUser.getMessage());
        assertEquals("O produto Smartphone obteve um desconto de 10,00%.", notificationFromSecondUser.getMessage());
    }

    @Test
    void shouldNotNotifyUser() {
        Product product = new Product("Smartphone", 1000);

        User user = new User("thales@email.com");

        product.setPrice(900);

        assertEquals(0, user.getNotifications().size());
    }

    @Test
    void shouldNotifyAnUniqueUser() {
        Product product = new Product("Smartphone", 1000);
        Product secondProduct = new Product("Computer", 3000);

        User user = new User("thales@email.com");
        User secondUser = new User("test@email.com");

        user.addProductAsFavorite(product);
        secondUser.addProductAsFavorite(secondProduct);

        product.setPrice(900);

        Notification notification = user.getNotifications().get(0);

        assertEquals(1, user.getNotifications().size());
        assertEquals(0, secondUser.getNotifications().size());
        assertEquals("Mudança de preço", notification.getTitle());
        assertEquals("O produto Smartphone obteve um desconto de 10,00%.", notification.getMessage());
    }
}
