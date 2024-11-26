package ru.vsu.cs.kg24.g82.leguenko_e_yu.demo82;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel paintAreaPanel;
    private DrawPanel dp;

    public MainFrame() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        dp = new DrawPanel(width, height);
        paintAreaPanel.add(dp);
    }

    public static void main(String[] args) {
        MainFrame dialog = new MainFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        dialog.pack();
        dialog.setSize((int) width, (int) height);
        dialog.setVisible(true);

        System.exit(0);
    }
}
