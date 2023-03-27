package ru.mirea.ikbo3021.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mirea.ikbo3021.interfaces.Musician;

@Component
public class Drummer implements Musician {

    @Override
    public void doMusic() {
        System.out.println("Drum sounds");
    }
}
