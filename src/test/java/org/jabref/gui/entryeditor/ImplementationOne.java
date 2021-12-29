package org.jabref.gui.entryeditor;

import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ImplementationOne {

    private BibEntry entry;

    @BeforeEach
    void setup() {
        this.entry = new BibEntry();
        entry.setField(StandardField.NATIONALITY, "Portuguese");
        entry.setField(StandardField.AFILLIATION, "Nova FCT");
    }

    @Test
    public void hasNationality() {
        assertTrue(entry.hasField(StandardField.NATIONALITY));
    }

    @Test
    public void hasAfilliation() {
        assertTrue(entry.hasField(StandardField.AFILLIATION));
    }

    @Test
    public void noNationality() {
        entry.clearField(StandardField.NATIONALITY);
        assertFalse(entry.hasField(StandardField.NATIONALITY));
    }

    @Test
    public void noAfilliation() {
        entry.clearField(StandardField.AFILLIATION);
        assertFalse(entry.hasField(StandardField.AFILLIATION));
    }

    @Test
    public void changeNationality() {
        String var = "English";
        entry.setField(StandardField.NATIONALITY, var);
        assertEquals(entry.getField(StandardField.NATIONALITY).get(), var);
    }

    @Test
    public void changeAfilliation() {
        String var = "IST";
        entry.setField(StandardField.AFILLIATION, var);
        assertEquals(entry.getField(StandardField.AFILLIATION).get(), var);
    }

}
