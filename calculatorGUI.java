import javax.swing.*;//for gui
import java.awt.*;//for styling
import java.awt.event.*;//action listener to detect button clicks

public class calculatorGUI extends JFrame implements ActionListener {
    JTextField display;//makes a textfield variable as 'display'
    String numt = "", operator = "";//numt is number that is typed
    double num1 = 0; //the first number in calculation

    public calculatorGUI() {
        setTitle("Multiunctional Calcultor");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.decode("#1e1e2f"));// a window with dark background

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Times New Roman", Font.BOLD, 28));
        display.setBackground(Color.decode("#2c2c3e"));
        display.setForeground(Color.WHITE);
        add(display, BorderLayout.NORTH);//placed at the top 

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 8, 8));//creating 4x4 calc panel.
        panel.setBackground(Color.decode("#1e1e2f"));

        String[] buttons = {
            "7", "8", "9", "/",
            "6", "5", "4", "*",
            "3", "2", "1", "-",
            "C", "0", "=", "+"
        };

        for (String b : buttons) {
            JButton button = new JButton(b);
            button.setFont(new Font("Times New Roman", Font.BOLD, 20));
            button.setFocusPainted(false);
            button.setBackground(b.matches("[0-9]") ? Color.decode("#3e3e53") :
                                 b.equals("C") ? Color.decode("#cc444b") :
                                 Color.decode("#4b4b7d"));

            button.setForeground(Color.WHITE);
            button.addActionListener(this);
            panel.add(button);//connected the click and added to panel
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);//panel in the centre
    }

    public void actionPerformed(ActionEvent e) {
        String btn = e.getActionCommand();

        if (btn.matches("[0-9]")) {
            numt += btn;
            display.setText(numt);
        } else if (btn.matches("[/*\\-+]")) {
            operator = btn;
            num1 = Double.parseDouble(numt);
            numt = "";// saves the first number along with operator then clears to end the second number
        } else if (btn.equals("=")) {
            double num2 = Double.parseDouble(numt);
            double result = 0;
            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": result = num2 != 0 ? num1 / num2 : 0; break;
            }
            display.setText(String.valueOf(result));
            numt = String.valueOf(result);
        } else if (btn.equals("C")) {
            numt = "";
            num1 = 0;
            operator = "";
            display.setText("");
        }
    }

    public static void main(String[] args) {
        new calculatorGUI();
    }
}
