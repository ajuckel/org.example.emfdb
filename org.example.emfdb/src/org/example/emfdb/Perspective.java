package org.example.emfdb;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

    public void createInitialLayout(IPageLayout layout) {
        layout.setEditorAreaVisible(false);
        layout.setFixed(false);
        layout.addView(View.ID, IPageLayout.LEFT, 1.0f,
                IPageLayout.ID_EDITOR_AREA);
    }

}
