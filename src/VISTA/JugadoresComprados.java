package VISTA;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

public class JugadoresComprados extends JFrame {

	public JPanel contentPane;
	public JPanel panel;
	public JButton btnNewButton;
	public JButton btnNewButton_1;
	public JButton btnNewButton_2;
	public JButton btnNewButton_3;
	public JButton btnNewButton_4;
	public JButton btnNewButton_5;
	public JButton btnNewButton_6;
	public JButton btnNewButton_7;
	public JButton btnNewButton_8;
	public JButton btnNewButton_9;
	public JButton btnNewButton_10;
	public JButton btnNewButton_11;
	public JButton btnNewButton_12;
	public JButton btnNewButton_13;
	public JButton btnNewButton_14;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JugadoresComprados frame = new JugadoresComprados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JugadoresComprados() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 507);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), ".", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(18, 20, 562, 451);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(10, 23, 100, 130);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(120, 23, 100, 130);
		panel.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.setBounds(230, 23, 100, 130);
		panel.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("");
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_3.setBounds(340, 23, 100, 130);
		panel.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("");
		btnNewButton_4.setBackground(Color.LIGHT_GRAY);
		btnNewButton_4.setBounds(450, 23, 100, 130);
		panel.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("");
		btnNewButton_5.setBackground(Color.LIGHT_GRAY);
		btnNewButton_5.setBounds(10, 164, 100, 130);
		panel.add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("");
		btnNewButton_6.setBackground(Color.LIGHT_GRAY);
		btnNewButton_6.setBounds(120, 164, 100, 130);
		panel.add(btnNewButton_6);
		
		btnNewButton_7 = new JButton("");
		btnNewButton_7.setBackground(Color.LIGHT_GRAY);
		btnNewButton_7.setBounds(230, 164, 100, 130);
		panel.add(btnNewButton_7);
		
		btnNewButton_8 = new JButton("");
		btnNewButton_8.setBackground(Color.LIGHT_GRAY);
		btnNewButton_8.setBounds(340, 164, 100, 130);
		panel.add(btnNewButton_8);
		
		btnNewButton_9 = new JButton("");
		btnNewButton_9.setBackground(Color.LIGHT_GRAY);
		btnNewButton_9.setBounds(450, 164, 100, 130);
		panel.add(btnNewButton_9);
		
		btnNewButton_10 = new JButton("");
		btnNewButton_10.setBackground(Color.LIGHT_GRAY);
		btnNewButton_10.setBounds(10, 305, 100, 130);
		panel.add(btnNewButton_10);
		
		btnNewButton_11 = new JButton("");
		btnNewButton_11.setBackground(Color.LIGHT_GRAY);
		btnNewButton_11.setBounds(120, 305, 100, 130);
		panel.add(btnNewButton_11);
		
		btnNewButton_12 = new JButton("");
		btnNewButton_12.setBackground(Color.LIGHT_GRAY);
		btnNewButton_12.setBounds(230, 305, 100, 130);
		panel.add(btnNewButton_12);
		
		btnNewButton_13 = new JButton("");
		btnNewButton_13.setBackground(Color.LIGHT_GRAY);
		btnNewButton_13.setBounds(340, 305, 100, 130);
		panel.add(btnNewButton_13);
		
		btnNewButton_14 = new JButton("");
		btnNewButton_14.setBackground(Color.LIGHT_GRAY);
		btnNewButton_14.setBounds(450, 305, 100, 130);
		panel.add(btnNewButton_14);
	}
}
