package org.example.Splitwise;

public interface Subject {
    void addObserver(Observer v);
    void removeObserver(Observer v);
    void notifyAll(String message);
}
