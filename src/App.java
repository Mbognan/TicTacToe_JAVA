import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JFrame frame;
    private int counter = 0;

    public App() {
        frame = new JFrame("Condition Popup Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JButton incrementButton = new JButton("Increment Counter");
        incrementButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counter++;
                if (counter >= 5) {
                    showPopup("Counter reached 5!");
                }
            }
        });

        frame.setLayout(new FlowLayout());
        frame.add(incrementButton);

        frame.setVisible(true);
    }

    private void showPopup(String message) {
        JOptionPane.showMessageDialog(frame, message, "Popup", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new App();
            }
        });
    }
}
