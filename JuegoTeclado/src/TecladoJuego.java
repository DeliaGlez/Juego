import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JLabel;
import java.awt.Color;

public class TecladoJuego {

	private JFrame frame;
	ArrayList<String> palabras = new ArrayList<>(Arrays.asList("elefante", "computadora", "restaurante", "mesabanco", "excepcional", "enciclopedia", "desarrollo", "aventura", "universidad", "extraordinario"));
	ArrayList<JLabel> arrLetras;
	JLabel lblPalabra;
	JLabel lblInput;
	JLabel lblSpace;
	JLabel lblBackspace;
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
		arrLetras= new ArrayList<>();

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
		panelPalabras.setPreferredSize(new Dimension(450,70));
		
		lblInput = new JLabel();
		lblInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInput.setBounds(35, 11, 222, 23);
		panelPalabras.add(lblInput);
		
		lblPalabra = new JLabel("New label");
		lblPalabra.setBounds(35, 45, 222, 14);
		panelPalabras.add(lblPalabra);
		
		JLabel lblTiempo = new JLabel("New label");
		lblTiempo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTiempo.setBounds(339, 11, 121, 33);
		panelPalabras.add(lblTiempo);
		
		JPanel panelTeclado = new JPanel();
		panelTeclado.setBackground(new Color(255, 128, 128));
		panelFondo.add(panelTeclado, BorderLayout.CENTER);
		panelTeclado.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTeclas = new JPanel();
		panelTeclas.setBackground(new Color(255, 128, 128));
		panelTeclado.add(panelTeclas, BorderLayout.CENTER);
		panelTeclas.setLayout(new GridLayout(3, 9, 10, 10));
		
		JLabel lblNewLabel = new JLabel("   ");
		panelTeclado.add(lblNewLabel, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("   ");
		panelTeclado.add(lblNewLabel_1, BorderLayout.EAST);
		
		JLabel lblNewLabel_2 = new JLabel("    ");
		panelTeclado.add(lblNewLabel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("   ");
		panelTeclado.add(lblNewLabel_3, BorderLayout.SOUTH);
		
		for (String string : letras) {
			JLabel letra = new JLabel(string);
			letra.setOpaque(true);
			letra.setFont((new Font("Century Gothic", Font.BOLD, 20)));
			letra.setHorizontalAlignment(SwingConstants.CENTER);
			letra.setBackground(Color.white);
			arrLetras.add(letra);
			panelTeclas.add(letra);
		}
		
		JPanel panelAbajo = new JPanel();
		panelAbajo.setBackground(new Color(128, 128, 255));
		panelFondo.add(panelAbajo, BorderLayout.SOUTH);
		
		lblSpace = new JLabel("[____________________]");
		lblSpace.setOpaque(true);
		panelAbajo.add(lblSpace);
		
		 lblBackspace = new JLabel("Backspace");
		lblBackspace.setOpaque(true);
		panelAbajo.add(lblBackspace);
		
		
		palabraAzar();
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e);
				int code= e.getKeyCode();
				char letra =e.getKeyChar();
				String letraPresionada = e.getKeyText(code);
				
				if(code!=8 ) {
					lblInput.setText(lblInput.getText()+letra);
					
				}else if (code == 8 && lblInput.getText().length() > 0) {
					lblBackspace.setBackground(colorAleatorio());
			        String textoActual = lblInput.getText();
			        String nuevoTexto = textoActual.substring(0, textoActual.length() - 1);
			        lblInput.setText(nuevoTexto);
			    }
				if(code==32) {
					lblSpace.setBackground(colorAleatorio());
				}
				
				for (JLabel lblLetra : arrLetras) {
					if(letraPresionada.equals(lblLetra.getText())) {
						lblLetra.setBackground(colorAleatorio());
					}
				}
				
				switch (code){
				case KeyEvent.VK_DELETE:
                   
                    break;
				case 87:
				case 38:
					
					break;
				case 65:
				case 37:
					
					break;
				case 83:
				case 40:
					
					break;
				case 68:
				case 39:
					
					break;
				}
				
				
				
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				int code= e.getKeyCode();
				//char letra =e.getKeyChar();
				String letraPresionada = e.getKeyText(code);
				for (JLabel lblLetra : arrLetras) {
					if(letraPresionada.equals(lblLetra.getText())) {
						lblLetra.setBackground(Color.white);
					}
				}
				if (code == 8 ) {
					lblBackspace.setBackground(Color.white);
					}
				else if(code==32) {
					lblSpace.setBackground(Color.white);
				}
			}
			
		});
		
	}
	
	public void palabraAzar() {
        Random random = new Random();
        int indiceAleatorio = random.nextInt(palabras.size());
        lblPalabra.setText(palabras.get(indiceAleatorio));
    }
	public Color colorAleatorio() {
		Random rand= new Random();
		float r2 = rand.nextFloat();
		float g2 = rand.nextFloat();
		float b2 = rand.nextFloat();
		
		Color randomColor = new Color(r2, g2, b2);
		return randomColor;
		
	}
}