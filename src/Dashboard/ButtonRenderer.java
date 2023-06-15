package Dashboard;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ButtonRenderer extends DefaultTableCellRenderer {
    private final JButton button;

    public ButtonRenderer() {
        button = new JButton("Apply");
        button.setFocusPainted(false);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return button;
    }
}
