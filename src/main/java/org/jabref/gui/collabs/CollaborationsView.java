package org.jabref.gui.collabs;

import com.airhacks.afterburner.views.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import org.jabref.gui.ClipBoardManager;
import org.jabref.gui.DialogService;
import org.jabref.gui.StateManager;
import org.jabref.gui.util.BaseDialog;
import org.jabref.gui.util.ControlHelper;
import org.jabref.logic.l10n.Localization;
import org.jabref.logic.util.BuildInfo;

import javax.inject.Inject;

public class CollaborationsView extends BaseDialog<Void> {

    @FXML private ButtonType botaoInutil;
    //@FXML private TextArea textAreaVersions;

    @Inject
    private DialogService dialogService;
    @Inject private ClipBoardManager clipBoardManager;
    @Inject private BuildInfo buildInfo;
    private StateManager stateManager;

    private CollaborationsViewModel viewModel;

    public CollaborationsView(StateManager stateManager) {
        this.stateManager = stateManager;
        this.setTitle(Localization.lang("Collaborations:"));

        ViewLoader.view(this)
                .load()
                .setAsDialogPane(this);

        ControlHelper.setAction(botaoInutil, getDialogPane(), event -> System.out.println("botão"));
    }

    public CollaborationsViewModel getViewModel() {
        return viewModel;
    }

    @FXML
    private void botaoInutil() {
        viewModel.botaoInutil();
    }

    @FXML
    private void initialize() {
        viewModel = new CollaborationsViewModel(stateManager);

        this.setResizable(false);
    }


}

