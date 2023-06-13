import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JLabel;
import java.awt.Color;

public class TecladoJuego {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TecladoJuego window = new TecladoJuego();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TecladoJuego() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ArrayList<String> letras = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"));
		ArrayList<String> palabras = new ArrayList<>(Arrays.asList("elefante", "computadora", "restaurante", "paralelepípedo", "excepcional", "enciclopedia", "desarrollo", "aventura", "universidad", "extraordinario"));

		frame = new JFrame();
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelFondo = new JPanel();
		frame.getContentPane().add(panelFondo, BorderLayout.CENTER);
		panelFondo.setLayout(new BorderLayout(0, 0));
		
		JPanel panelPalabras = new JPanel();
		panelPalabras.setBackground(new Color(128, 128, 255));
		panelFondo.add(panelPalabras, BorderLayout.NORTH);
		panelPalabras.setLayout(null);
		panelPalabras.setPreferredSize(new Dimension(450,50));
		
		JLabel lblInput = new JLabel("New label");
		lblInput.setBounds(35, 5, 222, 14);
		panelPalabras.add(lblInput);
		
		JLabel lblPalabra = new JLabel("New label");
		lblPalabra.setBounds(35, 30, 222, 14);
		panelPalabras.add(lblPalabra);
		
		JLabel lblTiempo = new JLabel("New label");
		lblTiempo.setBounds(339, 11, 121, 14);
		panelPalabras.add(lblTiempo);
		
		JPanel panelTeclado = new JPanel();
		panelTeclado.setBackground(new Color(255, 128, 128));
		panelFondo.add(panelTeclado, BorderLayout.CENTER);
		panelTeclado.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTeclas = new JPanel();
		panelTeclas.setBackground(new Color(255, 128, 128));
		panelTeclado.add(panelTeclas, BorderLayout.CENTER);
		panelTeclas.setLayout(new GridLayout(3, 9, 10, 10));
		
		for (String string : letras) {
			JLabel letra = new JLabel(string);
			letra.setOpaque(true);
			letra.setFont((new Font("Century Gothic", Font.BOLD, 20)));
			letra.setHorizontalAlignment(SwingConstants.CENTER);
			
			panelTeclas.add(letra);
		}
		
		JPanel panelAbajo = new JPanel();
		panelAbajo.setBackground(new Color(128, 128, 255));
		panelFondo.add(panelAbajo, BorderLayout.SOUTH);
		
		JLabel lblSpace = new JLabel("[____________________]");
		lblSpace.setOpaque(true);
		panelAbajo.add(lblSpace);
		
		JLabel lblBackspace = new JLabel("Backspace");
		lblBackspace.setOpaque(true);
		panelAbajo.add(lblBackspace);
	}
}
