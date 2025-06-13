/**
 * The {@code ShapeStudioGUI} class provides the graphical user interface (GUI)
 * for the Shape Studio application. It manages user interactions, displays shapes,
 * and handles the main window of the application.
 *
 * <p>This class is part of the {@code fr.gema} package and serves as the entry point
 * for launching and managing the application's GUI components.</p>
 *
 *
 */
package fr.gema;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * The {@code ShapeStudioGUI} class represents the main window of the Shape Studio application.
 * It sets up the primary JFrame with a title, default close operation, size, and layout.
 * <p>
 * The application is launched via the {@link #main(String[])} method, which ensures
 * that the GUI is created and updated on the Event Dispatch Thread.
 * </p>
 */
public class ShapeStudioGUI extends JFrame {

    public ShapeStudioGUI() {
        setTitle("Shape Studio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // COMPLETE THE CODE HERE

        setVisible(true);
    }

    /**
     * The entry point of the Shape Studio application.
     * <p>
     * This method initializes the GUI by scheduling the creation of the
     * {@code ShapeStudioGUI} instance on the Event Dispatch Thread (EDT)
     * using {@link javax.swing.SwingUtilities#invokeLater}. This ensures
     * that all Swing components are created and updated in a thread-safe manner.
     *
     * @param args the command-line arguments (not used)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ShapeStudioGUI::new);
    }
}