package org.jabref.gui.collabs;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;

import org.jabref.gui.AbstractViewModel;
import org.jabref.gui.StateManager;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;

public class CollaborationsViewModel extends AbstractViewModel {

    private final ReadOnlyStringWrapper collabs = new ReadOnlyStringWrapper();
    private final ReadOnlyStringWrapper heading = new ReadOnlyStringWrapper();

    public CollaborationsViewModel(StateManager stateManager) {
        heading.set("Collaborations:");

        collabs.set(formatCollabs(stateManager));
    }

    private String formatCollabs(StateManager stateManager) {
        List<BibEntry> entries;
        Map<String, TreeSet<String>> collabs = new TreeMap<String, TreeSet<String>>();
        String result = "Autores:\n";

        entries = stateManager.getSelectedEntries();

        for (BibEntry entry: entries) {
            String entryAuthors = entry.getField(StandardField.AUTHOR).get();

            TreeSet<String> names = new TreeSet<>();
            String[] aux = entryAuthors.split(" and ");

            String mainAuthor = aux[0];
            for(int i = 1; i < aux.length; i++)
                names.add(aux[i]);

            if(collabs.containsKey(mainAuthor))
                collabs.get(mainAuthor).addAll(names);
            else
                collabs.put(mainAuthor, names);

            for(String name: names) {
                collabs.putIfAbsent(name, new TreeSet<>());
                collabs.get(name).add(mainAuthor);
            }
        }

        for(String author: collabs.keySet()) {
            result += author + " = {";
            Iterator<String> it = collabs.get(author).iterator();
            while(it.hasNext()) {
                result += it.next();
                if(it.hasNext())
                    result += ", ";
            }

            result += "}\n";
        }

        return result;
    }

    public ReadOnlyStringProperty collabsProperty() {
        return collabs.getReadOnlyProperty();
    }

    public String getCollabs() {
        return collabs.get();
    }

    public ReadOnlyStringProperty headingProperty() {
        return heading.getReadOnlyProperty();
    }

    public String getHeading() {
        return heading.get();
    }

    public void botaoInutil() {
        System.out.println("nada");
    }
}
