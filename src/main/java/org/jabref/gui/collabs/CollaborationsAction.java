package org.jabref.gui.collabs;

import com.airhacks.afterburner.injection.Injector;
import org.jabref.gui.DialogService;
import org.jabref.gui.StateManager;
import org.jabref.gui.actions.ActionHelper;
import org.jabref.gui.actions.SimpleCommand;

public class CollaborationsAction extends SimpleCommand {

    private StateManager stateManager;

    private final CollaborationsView collaborationsView;

    public CollaborationsAction(StateManager stateManager) {
        this.stateManager = stateManager;
        this.executable.bind(ActionHelper.needsEntriesSelected(stateManager));
        this.collaborationsView = new CollaborationsView(stateManager);
    }

    @Override
    public void execute() {
        DialogService dialogService = Injector.instantiateModelOrService(DialogService.class);
        dialogService.showCustomDialogAndWait(new CollaborationsView(stateManager));
    }

    public CollaborationsView getAboutDialogView() {
        return collaborationsView;
    }
}
