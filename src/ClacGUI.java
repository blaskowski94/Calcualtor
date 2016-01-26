import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ClacGUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel[] panel = new JPanel[5];
	private JButton[] button = new JButton[16];
	private JTextArea textArea = new JTextArea(2, 20);
	private String[] buttonString = { "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", "=", "C", "/" };
	private boolean[] function = new boolean[4];
	private double[] temp = { 0, 0 };

	public ClacGUI() {

		super("Calculator");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = new JPanel();
		GridLayout grid = new GridLayout(5, 5);

		for (int i = 0; i < panel.length; i++) {
			panel[i] = new JPanel();
			panel[i].setBounds(35, 50, 300, 50);
			contentPane.add(panel[i]);
			panel[i].setBackground(Color.PINK);
		}

		panel[0].add(textArea);
		setContentPane(contentPane);
		contentPane.setLayout(grid);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.PINK);
		setBounds(100, 100, 400, 450);
		Font font = new Font("Times New Roman", Font.BOLD, 18);
		textArea.setFont(font);
		textArea.setEditable(false);
		textArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		for (int i = 0; i < button.length; i++) {
			button[i] = new JButton();
			button[i].setBackground(Color.PINK);
			button[i].setText(buttonString[i]);
			button[i].addActionListener(this);
			button[i].setPreferredSize(new Dimension(50, 50));
			button[i].setFont(font);
		}

		for (int i = 0; i < 4; i++)
			panel[1].add(button[i]);
		for (int i = 4; i < 8; i++)
			panel[2].add(button[i]);
		for (int i = 8; i < 12; i++)
			panel[3].add(button[i]);
		for (int i = 12; i < 16; i++)
			panel[4].add(button[i]);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button[0])
			textArea.append("7");
		else if (e.getSource() == button[1])
			textArea.append("8");
		else if (e.getSource() == button[2])
			textArea.append("9");
		else if (e.getSource() == button[3]) {
			// Addition
			temp[0] = Double.parseDouble(textArea.getText());
			function[0] = true;
			textArea.setText("");
		} else if (e.getSource() == button[4])
			textArea.append("4");
		else if (e.getSource() == button[5])
			textArea.append("5");
		else if (e.getSource() == button[6])
			textArea.append("6");
		else if (e.getSource() == button[7]) {
			// Subtraction
			temp[0] = Double.parseDouble(textArea.getText());
			function[1] = true;
			textArea.setText("");
		} else if (e.getSource() == button[8])
			textArea.append("1");
		else if (e.getSource() == button[9])
			textArea.append("2");
		else if (e.getSource() == button[10])
			textArea.append("3");
		else if (e.getSource() == button[11]) {
			// Multiplication
			temp[0] = Double.parseDouble(textArea.getText());
			function[2] = true;
			textArea.setText("");
		} else if (e.getSource() == button[12])
			textArea.append("0");
		else if (e.getSource() == button[13])
			// Calculate
			getResult();
		else if (e.getSource() == button[14])
			// Clear
			clear();
		else if (e.getSource() == button[15]) {
			// Division
			temp[0] = Double.parseDouble(textArea.getText());
			function[3] = true;
			textArea.setText("");
		}
	}

	public void clear() {
		textArea.setText("");
		for (int i = 0; i < function.length; i++)
			function[i] = false;
		for (int i = 0; i < temp.length; i++)
			temp[i] = 0;
	}

	public void getResult() {
		double result = 0;
		temp[1] = Double.parseDouble(textArea.getText());
		if (function[0])
			result = temp[0] + temp[1];
		else if (function[1])
			result = temp[0] - temp[1];
		else if (function[2])
			result = temp[0] * temp[1];
		else if(function[3])
			result = temp[0] / temp[1];
		textArea.setText(Double.toString(result));
		for (int i = 0; i < function.length; i++)
			function[i] = false;
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ClacGUI calc = new ClacGUI();
	}
}
