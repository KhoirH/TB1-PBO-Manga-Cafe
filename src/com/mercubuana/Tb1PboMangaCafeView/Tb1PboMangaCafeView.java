package com.mercubuana.Tb1PboMangaCafeView;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;	
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class Tb1PboMangaCafeView {

	private JFrame frmMangaCafe;
	private JTable table;
	private JTabbedPane tabbedPane;
	private JList list;
	private JPanel panelNamaPembooking;
	private JPanel panelRuangan;
	private JPanel panelJenisRuangan;
	private JPanel panelJumlahSlot;
	private JButton btnTambah;
	private JButton btnHapus;
	private JButton btnEdit;
	private JButton btnPesan;
	
	private JTextField txtNamaPembooking;
	private JTextField txtJumlahSlot;
	private JComboBox cmbRuangan;
	private JComboBox cmbTipeRuangan;
	
	private ArrayList<RuangCafe> ruanganTersewa = new ArrayList<RuangCafe>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tb1PboMangaCafeView window = new Tb1PboMangaCafeView();
					window.frmMangaCafe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tb1PboMangaCafeView() {
		readRuangCafe();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	@SuppressWarnings("unchecked")
	private void initialize() {
		frmMangaCafe = new JFrame();
		frmMangaCafe.setFont(new Font("Arial", Font.PLAIN, 12));
		frmMangaCafe.setTitle("Manga cafe");
		frmMangaCafe.setBounds(100, 100, 657, 598);
		frmMangaCafe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		list = new JList();
		panelNamaPembooking = new JPanel();
		panelRuangan = new JPanel();
		panelJenisRuangan = new JPanel();
		panelJumlahSlot = new JPanel();
		
		
		txtJumlahSlot = new JTextField();
		cmbTipeRuangan = new JComboBox();
		cmbRuangan = new JComboBox();
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		btnTambah = new JButton("Tambah");
		btnHapus = new JButton("Hapus");
		btnEdit = new JButton("Edit");
		btnPesan = new JButton("Pesan");
		txtNamaPembooking = new JTextField();
		
		//headers for the table
        String[] columns = new String[] {
            "No", "Ruang", "Jenis", "Sisa Ruang"
        };
         
        //actual data for the table in a 2d array
        Object[][] data = new Object[][] {
            { 1, "R-01", "Reguler", 20 },
            { 2, "R-01", "VIP", 20 },
            { 3, "R-01", "Extended", 20 },
            { 4, "V-01", "Reguler", 20 },
            { 5, "V-01", "VIP", 20 },
            { 6, "V-01", "Extended", 20 },
            { 7, "X-01", "Reguler", 20 },
            { 8, "X-01", "VIP", 20 },
            { 9, "X-01", "Extended", 20 },
        };
		
		
		tabbedPane.setFont(new Font("Dialog", Font.PLAIN, 14));
		tabbedPane.setFocusable(false);
		tabbedPane.setFocusTraversalKeysEnabled(false);
		tabbedPane.setBackground(SystemColor.inactiveCaption);
		tabbedPane.setForeground(Color.BLACK);
		
		
		GroupLayout groupLayout = new GroupLayout(frmMangaCafe.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnPesan, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 604, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnTambah, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnHapus, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panelJenisRuangan, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panelRuangan, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panelNamaPembooking, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(panelJumlahSlot, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnTambah, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnHapus, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addComponent(panelNamaPembooking, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelRuangan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelJenisRuangan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelJumlahSlot, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnPesan, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		panelJumlahSlot.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("127px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("263px"),},
			new RowSpec[] {
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("28px"),}));
		
		JLabel lblJumlahSlot = new JLabel("Jumlah Ruangan");
		lblJumlahSlot.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panelJumlahSlot.add(lblJumlahSlot, "2, 2, left, center");
		panelJumlahSlot.add(txtJumlahSlot, "4, 2");
		txtJumlahSlot.setColumns(10);
		panelJenisRuangan.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("124px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("269px:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("28px"),}));
		
		JLabel lblJenisRuangan = new JLabel("Jenis Ruangan");
		lblJenisRuangan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panelJenisRuangan.add(lblJenisRuangan, "2, 2, right, fill");
		
		cmbTipeRuangan.setModel(new DefaultComboBoxModel(new String[] {"Reguler", "VIP", "Extended"}));
		panelJenisRuangan.add(cmbTipeRuangan, "4, 2, fill, default");
		
		JLabel lblRuangan = new JLabel("Ruangan");
		lblRuangan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panelRuangan.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("58px"),
				ColumnSpec.decode("74px:grow"),
				ColumnSpec.decode("268px"),},
			new RowSpec[] {
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("28px"),}));
		panelRuangan.add(lblRuangan, "2, 2, right, top");
		
		cmbRuangan.setModel(new DefaultComboBoxModel(new String[] {"R-01", "V-01", "X-01"}));
		panelRuangan.add(cmbRuangan, "4, 2");
		
		JLabel lblNamaPembooking = new JLabel("Nama Pembooking");
		lblNamaPembooking.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		
		txtNamaPembooking.setColumns(10);
		panelNamaPembooking.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("118px"),
				FormSpecs.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("265px"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("28px"),}));
		panelNamaPembooking.add(lblNamaPembooking, "2, 2, left, center");
		panelNamaPembooking.add(txtNamaPembooking, "4, 2, default, center");
		
		tabbedPane.addTab("Ruangan Tersewa", null, list, null);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Ketersedian Ruangan", null, scrollPane, null);
		
		table = new JTable(dataTable, columns);
		scrollPane.setViewportView(table);
		DefaultListModel<String> demoList = new DefaultListModel<String>();
		 demoList.addElement("addElements");
		list = new JList<String>(demoList);
		tabbedPane.addTab("Ruangan Tersewa", null, list, null);
		frmMangaCafe.getContentPane().setLayout(groupLayout);
		
		
		btnTambah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		
		btnHapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnPesan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sewaRuangan();
			}
		});
		
		readRuangCafe();
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	protected void sewaRuangan() {
		String namaPembooking = txtNamaPembooking.getText();
		String namaRuangan;
		switch (cmbRuangan.getSelectedIndex()) {
			case 0:
				namaRuangan = "R-01";
				break;
			case 1:
				namaRuangan = "V-01";
				break;
			case 2:
				namaRuangan = "X-01";
				break;
			default:
				namaRuangan = "R-01";
		}
		
		String jenisRuangan;
		switch (cmbTipeRuangan.getSelectedIndex()) {
			case 0:
				jenisRuangan = "Reguler";
				break;
			case 1:
				jenisRuangan = "VIP";
				break;
			case 2:
				jenisRuangan = "Extended";
				break;
			default:
				jenisRuangan = "Reguler";
		}
		int jumlahSlot = Integer.parseInt(txtJumlahSlot.getText());
		RuangCafe ruangCafe = new RuangCafe(namaPembooking, namaRuangan, jenisRuangan, jumlahSlot, 20);
		ruanganTersewa.add(ruangCafe);
		recordRuangCafe();
	}
	
	private void recordRuangCafe() {
		try {
			String fileName = "data_ruang_tersewa.txt";
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(ruanganTersewa);
			oos.close();
			JOptionPane.showMessageDialog(null, "Ruangan Berhasil Disimpan!");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File tidak bisa ditemukan.\nPesan kesalahan: " + e.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Terjadi error pada saat merekam data ke storage.\n Pesan kesalahan: " + e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	protected void readRuangCafe() {
		try {
			String fileName = "data_ruang_tersewa.txt";
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ruanganTersewa = (ArrayList<RuangCafe>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
//			JOptionPane.showMessageDialog(null, "File tidak bisa ditemukan.\nPesan kesalahan: " + e.getMessage());
		} catch (ClassNotFoundException e) {
//			JOptionPane.showMessageDialog(null, "Class tidak bisa ditemukan.\nPesan kesalahan: " + e.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Terjadi error pada saat merekam data ke storage.\n Pesan kesalahan: " + e.getMessage());
		}
	}
}