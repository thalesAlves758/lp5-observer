import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class User implements PropertyChangeListener {
    private List<Notification> notifications = new ArrayList<>();
    private String email;

    public User(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public void addProductAsFavorite(Product product) {
        product.addObserver(this);
    }

    public void removeProductFromFavoriteList(Product product) {
        product.removeObserver(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Product oldProduct = (Product) evt.getOldValue();
        Product changedProduct = (Product) evt.getNewValue();

        float readjustment = Utils.calculateReadjustment(oldProduct.getPrice(), changedProduct.getPrice());

        if(readjustment < 0) {
            String title = "Mudança de preço";
            String message = "O produto " + changedProduct.getName() + " obteve um desconto de " + String.format("%.2f", Math.abs(readjustment)) + "%.";
            this.notifications.add(new Notification(title, message));
        }
    }
}
