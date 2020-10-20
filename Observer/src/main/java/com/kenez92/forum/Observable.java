package com.kenez92.forum;

public interface Observable {
    void registerObserver(Observer observer);

    void notifyObservers();

    void removeObserver(Observer observer);
}
