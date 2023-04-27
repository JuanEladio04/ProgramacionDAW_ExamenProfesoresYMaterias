package examen.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import examen.controller.AsignaturaController;
import examen.controller.AsignaturasPorDocenteController;
import examen.controller.DocenteController;
import examen.model.Asignatura;
import examen.model.Asignaturaspordocente;
import examen.model.Docente;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {
	
	private DefaultListModel<Asignatura> jlm_UnselectedAsignatura = new DefaultListModel<Asignatura>();
	private DefaultListModel<Asignatura> jlm_SelectedAsignaturas = new DefaultListModel<Asignatura>(); 
	private List<Asignatura> selectedAsignaturas = new ArrayList<>();
	private JPanel contentPane;
	private JTextField jtf_ProfessorChooser;
	private JComboBox jcb_ProfessorChooser;
	private JList jl_UnselectedMat;
	private JList jl_SelectedMat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Docentes y asignaturas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		jtf_ProfessorChooser = new JTextField();
		GridBagConstraints gbc_jtf_ProfessorChooser = new GridBagConstraints();
		gbc_jtf_ProfessorChooser.anchor = GridBagConstraints.NORTH;
		gbc_jtf_ProfessorChooser.insets = new Insets(0, 0, 5, 5);
		gbc_jtf_ProfessorChooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf_ProfessorChooser.gridx = 0;
		gbc_jtf_ProfessorChooser.gridy = 0;
		panel_1.add(jtf_ProfessorChooser, gbc_jtf_ProfessorChooser);
		jtf_ProfessorChooser.setColumns(10);
		
		JButton btn_filter = new JButton("Filtrar");
		btn_filter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Docente> docentesToAdd = DocenteController.findByLikeDescription(jtf_ProfessorChooser.getText());
				
				for (Docente docente : docentesToAdd) {
					jcb_ProfessorChooser.addItem(docente);
				}
			}
		});
		GridBagConstraints gbc_btn_filter = new GridBagConstraints();
		gbc_btn_filter.insets = new Insets(0, 0, 5, 0);
		gbc_btn_filter.gridx = 1;
		gbc_btn_filter.gridy = 0;
		panel_1.add(btn_filter, gbc_btn_filter);
		
		jcb_ProfessorChooser = new JComboBox();
		GridBagConstraints gbc_jcm_ProfessorChooser = new GridBagConstraints();
		gbc_jcm_ProfessorChooser.insets = new Insets(0, 0, 0, 5);
		gbc_jcm_ProfessorChooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcm_ProfessorChooser.gridx = 0;
		gbc_jcm_ProfessorChooser.gridy = 1;
		panel_1.add(jcb_ProfessorChooser, gbc_jcm_ProfessorChooser);
		
		JButton btn_ChargeMat = new JButton("Cargar materias");
		btn_ChargeMat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jlm_SelectedAsignaturas.removeAllElements();
				jlm_UnselectedAsignatura.removeAllElements();
				
				setValuesToLists();
			}
		});
		GridBagConstraints gbc_btn_ChargeMat = new GridBagConstraints();
		gbc_btn_ChargeMat.gridx = 1;
		gbc_btn_ChargeMat.gridy = 1;
		panel_1.add(btn_ChargeMat, gbc_btn_ChargeMat);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		contentPane.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Asignaturas no selecionadas");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Asignaturas seleccionadas");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 0;
		panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jl_UnselectedMat = new JList(getDefaultListModel(true));
		GridBagConstraints gbc_jl_allStudents = new GridBagConstraints();
		gbc_jl_allStudents.insets = new Insets(0, 0, 0, 5);
		gbc_jl_allStudents.fill = GridBagConstraints.BOTH;
		gbc_jl_allStudents.gridx = 0;
		gbc_jl_allStudents.gridy = 1;
		panel_2.add(jl_UnselectedMat, gbc_jl_allStudents);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridheight = 2;
		gbc_panel_4.insets = new Insets(0, 0, 0, 5);
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 0;
		panel_2.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JButton btn_allToRight = new JButton(">>");
		btn_allToRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < jlm_UnselectedAsignatura.getSize(); i++) {
					jlm_SelectedAsignaturas.addElement(jlm_UnselectedAsignatura.getElementAt(i));
				}
				jlm_UnselectedAsignatura.removeAllElements();
			}
		});
		GridBagConstraints gbc_btn_allToRight = new GridBagConstraints();
		gbc_btn_allToRight.insets = new Insets(0, 0, 5, 0);
		gbc_btn_allToRight.gridx = 0;
		gbc_btn_allToRight.gridy = 0;
		panel_4.add(btn_allToRight, gbc_btn_allToRight);
		
		JButton btn_right = new JButton(">");
		btn_right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jlm_SelectedAsignaturas.addElement((Asignatura) jl_UnselectedMat.getSelectedValue());
				jlm_UnselectedAsignatura.removeElement(jl_UnselectedMat.getSelectedValue());
			}
		});
		GridBagConstraints gbc_btn_right = new GridBagConstraints();
		gbc_btn_right.insets = new Insets(0, 0, 5, 0);
		gbc_btn_right.gridx = 0;
		gbc_btn_right.gridy = 1;
		panel_4.add(btn_right, gbc_btn_right);
		
		JButton btn_left = new JButton("<");
		btn_left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jlm_UnselectedAsignatura.addElement((Asignatura) jl_SelectedMat.getSelectedValue());
				jlm_SelectedAsignaturas.removeElement(jl_SelectedMat.getSelectedValue());
			}
		});
		GridBagConstraints gbc_btn_left = new GridBagConstraints();
		gbc_btn_left.insets = new Insets(0, 0, 5, 0);
		gbc_btn_left.gridx = 0;
		gbc_btn_left.gridy = 2;
		panel_4.add(btn_left, gbc_btn_left);
		
		JButton btn_allToLeft = new JButton("<<");
		btn_allToLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < jlm_SelectedAsignaturas.getSize(); i++) {
					jlm_UnselectedAsignatura.addElement(jlm_SelectedAsignaturas.getElementAt(i));
				}
				jlm_SelectedAsignaturas.removeAllElements();
			}
		});
		GridBagConstraints gbc_btn_allToLeft = new GridBagConstraints();
		gbc_btn_allToLeft.gridx = 0;
		gbc_btn_allToLeft.gridy = 3;
		panel_4.add(btn_allToLeft, gbc_btn_allToLeft);
		
		jl_SelectedMat = new JList(getDefaultListModel(false));
		GridBagConstraints gbc_jl_SelectedStudents = new GridBagConstraints();
		gbc_jl_SelectedStudents.fill = GridBagConstraints.BOTH;
		gbc_jl_SelectedStudents.gridx = 2;
		gbc_jl_SelectedStudents.gridy = 1;
		panel_2.add(jl_SelectedMat, gbc_jl_SelectedStudents);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 3;
		contentPane.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton btn_save = new JButton("Guardar");
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realizeSaveButtonActions();
			}
		});
		GridBagConstraints gbc_btn_save = new GridBagConstraints();
		gbc_btn_save.gridx = 0;
		gbc_btn_save.gridy = 0;
		panel_3.add(btn_save, gbc_btn_save);
	}
	
	/**
	 * 
	 * @return
	 */
	private DefaultListModel getDefaultListModel(boolean isIzquierda) {
		if(isIzquierda) {
			this.jlm_UnselectedAsignatura = new DefaultListModel<Asignatura>();
			return this.jlm_UnselectedAsignatura;
		}
		else {
			this.jlm_SelectedAsignaturas = new DefaultListModel<Asignatura>();
			return this.jlm_SelectedAsignaturas;
		}
	}
	
	
	/**
	 * 
	 */
	private void setValuesToLists() {
		this.selectedAsignaturas.clear();
		Docente d = (Docente) jcb_ProfessorChooser.getSelectedItem();
		List<Asignaturaspordocente> apd = AsignaturasPorDocenteController.findbyId(d.getId());
		List<Asignatura> allAsignaturas = AsignaturaController.findAll();
		
		for (Asignaturaspordocente asignaturaspordocente : apd) {
			this.selectedAsignaturas.add(asignaturaspordocente.getAsignatura());
		}
		
		for (Asignatura asignatura : allAsignaturas) {
			boolean exists = false;
			for (Asignatura sAsignatura : this.selectedAsignaturas) {
				if(asignatura.getId() == sAsignatura.getId()) {
					exists = true;
				}
			}
			if (!exists) this.jlm_UnselectedAsignatura.addElement(asignatura); 
		}
		
		for (Asignatura a : this.selectedAsignaturas) {
			jlm_SelectedAsignaturas.addElement(a);
		}
		
	}
	
	
	/**
	 * 
	 */
	private void realizeSaveButtonActions() {
		List<Asignatura> asignaturasToUpdate = new ArrayList<Asignatura>();
		Docente prof = (Docente) jcb_ProfessorChooser.getSelectedItem();
		
		for (int i = 0; i < this.jlm_SelectedAsignaturas.size(); i++) {
			asignaturasToUpdate.add(this.jlm_SelectedAsignaturas.getElementAt(i));
		
		for (Asignatura a : asignaturasToUpdate) {
			Asignaturaspordocente apd = AsignaturasPorDocenteController.findByAllId(prof.getId(), a.getId());
			
			if(apd == null) insertapd(apd, prof, a);
			}

		}
		
	}
	
	
	/**
	 * @param vm
	 */
	private void insertapd(Asignaturaspordocente apd, Docente d,Asignatura a) {
		apd = new Asignaturaspordocente();
		apd.setAsignatura(a);
		apd.setDocente(d);
		AsignaturasPorDocenteController.realizeInsert(apd);
	}
	
	
	
}
