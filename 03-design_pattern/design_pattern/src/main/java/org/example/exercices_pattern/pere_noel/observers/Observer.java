package org.example.exercices_pattern.pere_noel.observers;

import org.example.exercices_pattern.pere_noel.factories.Toy;

public interface Observer {
    void notify(Toy toy);
}
