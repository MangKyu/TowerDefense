package Controller.Observer;

public interface PlayerObserver {
    void add(Observer observer);
    void delete(Observer observer);
    void notifyObservers();
}
