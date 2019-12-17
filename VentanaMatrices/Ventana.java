package EjercicioEntornos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private MiBoton[][] matrizBT = new MiBoton[10][10];
	private Matrices matrices = new Matrices();
	int x = 10;
	int y = 10;
	int col = 0;
	int filas = 0;

	/**
	 * Create the frame.
	 */
	public Ventana() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		for( col = 0; col < matrizBT.length; col++) {
			
			x = 10;
			
			for( filas = 0; filas < matrizBT.length; filas++) {
				
				final MiBoton bt = new MiBoton(filas,col);
				bt.setBounds(x, y, 50, 50);
				matrizBT[filas][col] = bt;
				panel.add(bt);
				x = x + 50;
				
			}
			
			y = y + 50;
		}
		
		for( col = 0; col < matrizBT.length; col++) {
			for( filas = 0; filas < matrizBT.length; filas++) {
				
				MiBoton bt = matrizBT[filas][col];
				
				bt.setText(String.valueOf(matrices.mostrarNumModificar(filas, col)));
				bt.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						matrices.generarMedia(bt.x, bt.y);
						bt.setText(String.valueOf(matrices.mostrarNumModificar(bt.x, bt.y)));
					}
			});
		
			}
		} 
		
	}
}
