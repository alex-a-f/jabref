package org.jabref.gui.collabs;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;

import org.jabref.gui.ClipBoardManager;
import org.jabref.gui.DialogService;
import org.jabref.gui.StateManager;
import org.jabref.gui.util.BaseDialog;
import org.jabref.gui.util.ControlHelper;
import org.jabref.logic.l10n.Localization;

import com.airhacks.afterburner.views.ViewLoader;

public class CollaborationsView extends BaseDialog<Void> {

    @FXML private ButtonType copyCollabs;

    @Inject private DialogService dialogService;
    @Inject private ClipBoardManager clipBoardManager;
    private StateManager stateManager;

    private CollaborationsViewModel viewModel;

    public CollaborationsView(StateManager stateManager) {
        this.stateManager = stateManager;
        this.setTitle(Localization.lang("Collaborations:"));

        ViewLoader.view(this)
                .load()
                .setAsDialogPane(this);

        ControlHelper.setAction(copyCollabs, getDialogPane(), event -> copyCollabs());
    }

    public CollaborationsViewModel getViewModel() {
        return viewModel;
    }

    @FXML
    private void copyCollabs() {
        viewModel.copyCollabs();
    }

    @FXML
    private void initialize() {
        viewModel = new CollaborationsViewModel(stateManager, clipBoardManager, dialogService);

        this.setResizable(true);

    }

}

