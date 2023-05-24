import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ProductObservable {
    private PropertyChangeSupport support;

    public ProductObservable() {
        this.support = new PropertyChangeSupport(this);
    }

    public void addObserver(PropertyChangeListener observer) {
        this.support.addPropertyChangeListener(observer);
    }

    public void removeObserver(PropertyChangeListener observer) {
        this.support.removePropertyChangeListener(observer);
    }

    public void notifyObservers(Product oldProduct, Product newProduct) {
        this.support.firePropertyChange("price", oldProduct, newProduct);
    }
}
