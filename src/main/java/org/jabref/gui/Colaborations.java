package org.jabref.gui;

import java.util.List;

import org.jabref.gui.actions.ActionHelper;
import org.jabref.gui.actions.SimpleCommand;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;

public class Colaborations extends SimpleCommand {

    private List<BibEntry> entries;
    private final StateManager stateManager;

    public Colaborations(StateManager stateManager) {
        this.stateManager = stateManager;
        this.executable.bind(ActionHelper.needsEntriesSelected(stateManager));
    }

    @Override
    public void execute() {
        entries = stateManager.getSelectedEntries();
        System.out.println("Autores: ");
        for (BibEntry entry: entries) {
            System.out.println(entry.getField(StandardField.AUTHOR).get());
        }
    }
}
