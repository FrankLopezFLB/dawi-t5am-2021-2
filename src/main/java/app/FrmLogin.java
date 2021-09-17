package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import app.Demo08;
import modelo.Producto;
import modelo.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class FrmLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
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
	public FrmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 146);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnNewButton.setBounds(324, 29, 89, 23);
		contentPane.add(btnNewButton);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(122, 30, 161, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario :");
		lblNewLabel.setBounds(10, 33, 102, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblClave = new JLabel("Clave :");
		lblClave.setBounds(10, 64, 102, 14);
		contentPane.add(lblClave);
		
		txtClave = new JTextField();
		txtClave.setColumns(10);
		txtClave.setBounds(122, 61, 161, 20);
		contentPane.add(txtClave);
		
	}

	
	private JTextField txtClave;
	// 1. fabrica el acceso a los datos
				EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
				// 2. crea el manejador de entidades
				EntityManager em = fabrica.createEntityManager();
	
	void registrar() {
			//obtener la conexion -> segund la unidad de persistencia
			
			
			//Validar un Usuario segun su usuario y clave
			
			String usuario=leerUsuario();
			String clave=leerClave();
			String sql2="select u from Usuario u where u.usuario = :xusr and u.clave = :xcla";
			
			TypedQuery<Usuario>query =em.createQuery(sql2,Usuario.class);
			query.setParameter("xusr", usuario);
			query.setParameter("xcla", clave);
			
			Usuario u= null;
			
			try {
				u=query.getSingleResult();
			} catch (Exception e) {
				
			}
			
			if(u==null) {
				aviso("Codigo No existe");
				
			}else {
				aviso("Bienvenido: "+u.getNombre());
			
			}
			
			em.close();
			
		}

	void aviso(String string) {
		JOptionPane.showMessageDialog(this,string);
	}
	private String leerClave() {
		// TODO Auto-generated method stub
		return txtClave.getText();
	}

	private String leerUsuario() {
		// TODO Auto-generated method stub
		return txtUsuario.getText();
	}	
	
}
