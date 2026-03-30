package i.see.you;

import javax.swing.*;
import java.awt.*;
import i.see.you.TheRootOfCorruptionMod;

public class AlertWindowInner {
    public static void main(String[] args) {
        if (args.length < 2) {
            TheRootOfCorruptionMod.LOGGER.error("Usage: AlertWindowInner <title> <message>");
            return;
        }
        String title = args[0];
        String message = args[1];
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
        });
    }
}