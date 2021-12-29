package org.jabref.gui.collabs;

import java.util.ArrayList;
import java.util.List;

import org.jabref.gui.StateManager;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImplementationTwo {

    private BibEntry entryOne;
    private BibEntry entryTwo;
    private BibEntry entryThree;
    private BibEntry entryFour;
    private CollaborationsViewModel collabsViewModel;
    private StateManager stateManager;

    @BeforeEach
    void setup() {
        this.stateManager = new StateManager();

        this.entryOne = new BibEntry();
        this.entryTwo = new BibEntry();
        this.entryThree = new BibEntry();
        this.entryFour = new BibEntry();

        entryOne.setField(StandardField.AUTHOR, "Diogo and Alex");
        entryTwo.setField(StandardField.AUTHOR, "Airton and Tiago");
        entryThree.setField(StandardField.AUTHOR, "Joao and Alex");
        entryFour.setField(StandardField.AUTHOR, "Diogo and Joao and Airton");

        List<BibEntry> entries = new ArrayList<BibEntry>();
        entries.add(entryOne);
        entries.add(entryTwo);
        entries.add(entryThree);
        entries.add(entryFour);
        stateManager.setSelectedEntries(entries);

        this.collabsViewModel = new CollaborationsViewModel(stateManager);
    }

    @Test
    public void checkCollabs() {
        assertEquals(collabsViewModel.getCollabs(), "Autores:\n" +
                "Airton = {Diogo, Tiago}\n" +
                "Alex = {Diogo, Joao}\n" +
                "Diogo = {Airton, Alex, Joao}\n" +
                "Joao = {Alex, Diogo}\n" +
                "Tiago = {Airton}\n");
    }



}
