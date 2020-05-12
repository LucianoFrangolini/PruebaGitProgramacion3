package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import clases.EstacionDeServicio;
import clases.Surtidor;
import excepciones.CargaInvalidaException;
import excepciones.FaltaCombustibleException;
import excepciones.TipoCombustibleInvalidoException;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Ventana extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panelSuperior;
	private JScrollPane scrollHistorial;
	private JScrollPane scrollPaneSurtidores;
	private JList<Surtidor> listaSurtidores;
	private JPanel panelCarga;
	private JTextArea historial;
	private DefaultListModel<Surtidor> modeloListaSurtidores;
	private EstacionDeServicio estacion = EstacionDeServicio.getInstance();
	private JPanel panelCargaSuperior;
	private JButton btnNuevoSurtidor;
	private JButton btnLlenarSurtidor;
	private JPanel panelEnvNuevoSurt;
	private JPanel panelEnvLlenarSurt;
	private JPanel panelCargaCentral;
	private JLabel lblCarga;
	private JTextField textCarga;
	private JPanel panelEnvCarga;
	private JPanel panelCargaInferior;
	private JLabel lblTipoCombustible;
	private JTextField textCombustible;
	private JPanel panelEnvCombust;
	private JLabel lblNada;
	private JButton btnCargar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1065, 601);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.panelSuperior = new JPanel();
		this.panelSuperior.setBorder(new TitledBorder(null, "Surtidores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.contentPane.add(this.panelSuperior, BorderLayout.CENTER);
		this.panelSuperior.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.scrollPaneSurtidores = new JScrollPane();
		this.panelSuperior.add(this.scrollPaneSurtidores);
		
		this.listaSurtidores = new JList<Surtidor>();
		this.scrollPaneSurtidores.setViewportView(this.listaSurtidores);
		
		this.panelCarga = new JPanel();
		this.panelSuperior.add(this.panelCarga);
		this.panelCarga.setLayout(new GridLayout(3, 0, 0, 0));
		
		this.panelCargaSuperior = new JPanel();
		this.panelCarga.add(this.panelCargaSuperior);
		this.panelCargaSuperior.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panelEnvNuevoSurt = new JPanel();
		FlowLayout flowLayout = (FlowLayout) this.panelEnvNuevoSurt.getLayout();
		flowLayout.setVgap(50);
		this.panelCargaSuperior.add(this.panelEnvNuevoSurt);
		
		this.btnNuevoSurtidor = new JButton("Nuevo Surtidor");
		this.btnNuevoSurtidor.addActionListener(this);
		this.panelEnvNuevoSurt.add(this.btnNuevoSurtidor);
		
		this.panelEnvLlenarSurt = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) this.panelEnvLlenarSurt.getLayout();
		flowLayout_1.setVgap(50);
		this.panelCargaSuperior.add(this.panelEnvLlenarSurt);
		
		this.btnLlenarSurtidor = new JButton("Llenar Surtidor");
		this.btnLlenarSurtidor.addActionListener(this);
		this.panelEnvLlenarSurt.add(this.btnLlenarSurtidor);
		
		this.panelCargaCentral = new JPanel();
		this.panelCarga.add(this.panelCargaCentral);
		this.panelCargaCentral.setLayout(new GridLayout(2, 0, 0, 0));
		
		this.lblCarga = new JLabel("Cantidad a cargar :");
		this.lblCarga.setFont(new Font("Tahoma", Font.PLAIN, 13));
		this.lblCarga.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelCargaCentral.add(this.lblCarga);
		
		this.panelEnvCarga = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) this.panelEnvCarga.getLayout();
		flowLayout_2.setVgap(25);
		this.panelCargaCentral.add(this.panelEnvCarga);
		
		this.textCarga = new JTextField();
		this.textCarga.setHorizontalAlignment(SwingConstants.CENTER);
		this.textCarga.setFont(new Font("Tahoma", Font.PLAIN, 13));
		this.panelEnvCarga.add(this.textCarga);
		this.textCarga.setColumns(20);
		
		this.panelCargaInferior = new JPanel();
		this.panelCarga.add(this.panelCargaInferior);
		this.panelCargaInferior.setLayout(new GridLayout(2, 2, 0, 0));
		
		this.lblTipoCombustible = new JLabel("Tipo de combustible :   ");
		this.lblTipoCombustible.setFont(new Font("Tahoma", Font.PLAIN, 13));
		this.lblTipoCombustible.setHorizontalAlignment(SwingConstants.RIGHT);
		this.panelCargaInferior.add(this.lblTipoCombustible);
		
		this.panelEnvCombust = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) this.panelEnvCombust.getLayout();
		flowLayout_3.setVgap(20);
		this.panelCargaInferior.add(this.panelEnvCombust);
		
		this.textCombustible = new JTextField();
		this.textCombustible.setHorizontalAlignment(SwingConstants.CENTER);
		this.textCombustible.setFont(new Font("Tahoma", Font.PLAIN, 13));
		this.panelEnvCombust.add(this.textCombustible);
		this.textCombustible.setColumns(20);
		
		this.lblNada = new JLabel("");
		this.panelCargaInferior.add(this.lblNada);
		
		this.btnCargar = new JButton("Cargar");
		this.btnCargar.addActionListener(this);
		this.btnCargar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		this.panelCargaInferior.add(this.btnCargar);
		
		this.scrollHistorial = new JScrollPane();
		this.contentPane.add(this.scrollHistorial, BorderLayout.SOUTH);
		this.scrollHistorial.setPreferredSize(new Dimension(40,150));
		
		this.historial = new JTextArea();
		this.scrollHistorial.setViewportView(this.historial);
		
		this.modeloListaSurtidores = new DefaultListModel<Surtidor>();
		this.listaSurtidores.setModel(modeloListaSurtidores);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Nuevo Surtidor")) 
			this.nuevoSurtidor();
		else
			if (e.getActionCommand().equals("Llenar Surtidor")) 
				this.llenaSurtidor(e);
			else
				if (e.getActionCommand().equals("Cargar"))
					this.cargaCombustible(e);
				
		this.actualizarLista();
	}

	private void actualizarLista() {
		
		this.modeloListaSurtidores.clear();
		Iterator<Surtidor> it = this.estacion.getSurtidores().iterator();
		while (it.hasNext())
			this.modeloListaSurtidores.addElement(it.next());
		this.repaint();
		
	}

	private void cargaCombustible(ActionEvent e) {
		
		Surtidor surt = this.listaSurtidores.getSelectedValue();
		
		try {
			surt.cargarCombustible(this.textCombustible.getText(), Double.parseDouble(this.textCarga.getText()));
			this.historial.append("Se cargaron satisfactoriamente "+this.textCarga.getText()+" litros de "+this.textCombustible.getText()+"\n");
		} 
		catch (TipoCombustibleInvalidoException e1) {
			this.historial.append(e1.getMessage()+"\n");
		}
		catch (FaltaCombustibleException e2) {
			this.historial.append(e2.getMessage()+"\n");
			try {
				surt.cargarCombustible(e2.getDato().getCombustible(), e2.getDato().getCantidadDisponible());
			} 
			catch (CargaInvalidaException e1) {}
		}
		catch (CargaInvalidaException e3) {
			this.historial.append(e3.getMessage()+"\n");
		}
	}	

	private void llenaSurtidor(ActionEvent e) {
		Surtidor surt = this.listaSurtidores.getSelectedValue();
		surt.llenarDiesel();
		surt.llenarPremium();
		surt.llenarSuper();
		this.historial.append("Se lleno el surtidor seleccionado\n");
	}

	private void nuevoSurtidor() {
		this.estacion.agregarSurtidor(new Surtidor());
		this.historial.append("Se agrego un nuevo surtidor a la estacion\n");
	}
}
