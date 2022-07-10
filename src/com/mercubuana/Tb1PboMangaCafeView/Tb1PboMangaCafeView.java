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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import com.mysql.cj.xdevapi.Result;

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
	
	private JTextField txtIdPembooking;
	private JTextField txtNamaPembooking;
	private JTextField txtJumlahSlot;
	private JComboBox cmbRuangan;
	private JComboBox cmbTipeRuangan;
	
	private ArrayList<RuangCafe> ruanganTersewa = new ArrayList<RuangCafe>();
	private int activeRuanganIndex = -1;
	private int activeId = -1;

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
		panelJenisRuangan.add(lblJenisRuangan, "2, 2, left, fill");
		
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
		getDataRuangan();
		frmMangaCafe.getContentPane().setLayout(groupLayout);
		
		btnTambah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				toEditFunction();
			}
		});
		
		
		btnHapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteRuanganTersewa();
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editRuanganTersewa();
			}
		});

		btnPesan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submit();
			}
		});
		
	}
	public  void toEditFunction() {
		activeRuanganIndex = -1;
		activeId = -1;
		txtNamaPembooking.setText("");
		txtJumlahSlot.setText("");
		cmbRuangan.setSelectedIndex(0);
		cmbTipeRuangan.setSelectedIndex(0);
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
	protected void getDataRuangan() {
		tabbedPane.removeAll();
		String[] columns = new String[] {
            "No", "ID", "Ruang", "Jenis", "Sisa Ruang"
        };
	      
		DefaultListModel<String> demoList = new DefaultListModel<String>();	
	     
		ResultSet rsOrdering = MySQLConnection.SelectData("SELECT id_pembooking, jenis_ruangan, nama_ruangan.name as nama_ruangan, sisa_slot_sewa_harian, nama_pembooking, jumlah_slot_sewa_harian  from ruang_cafe INNER JOIN nama_ruangan on ruang_cafe.nama_ruangan = nama_ruangan.id ");
		// loop data booking place
		try {
			while (rsOrdering.next()) {
				int idPembooking = rsOrdering.getInt("id_pembooking");
				
				String namaPembooking = rsOrdering.getString("nama_pembooking");
				int stringJumlahSlotSewaHarian = rsOrdering.getInt("jumlah_slot_sewa_harian");

				String namaRuang = rsOrdering.getString("nama_ruangan");

				int jenisRuang = rsOrdering.getInt("jenis_ruangan");
				int sisaSlotSewaHarian = rsOrdering.getInt("sisa_slot_sewa_harian");
				// list booking place
				String listString = idPembooking + " - " + namaPembooking + " - " + namaRuang + "-" + jenisRuang + "(" + stringJumlahSlotSewaHarian + ")" ;
				demoList.addElement(listString);
				
				RuangCafe ruangCafe = new RuangCafe(idPembooking, namaPembooking, namaRuang, "" + jenisRuang + "", stringJumlahSlotSewaHarian, sisaSlotSewaHarian);
				ruanganTersewa.add(ruangCafe);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet rsSum = MySQLConnection.SelectData("SELECT id_pembooking, jenis_ruangan, nama_ruangan.name as nama_ruangan, MIN(sisa_slot_sewa_harian) as sisa_slot_sewa_harian  from ruang_cafe INNER JOIN nama_ruangan on ruang_cafe.nama_ruangan = nama_ruangan.id GROUP by ruang_cafe.id_pembooking, ruang_cafe.nama_ruangan, ruang_cafe.jenis_ruangan");
					
		 //actual data for the table in a 2d array
	      ArrayList<Object[]> dataTempTable = new ArrayList<Object[]>();
	      int i = 0;
	      try {
			while (rsSum.next()) {
				 
				Object[] data = {
						i, rsSum.getInt("id_pembooking"), rsSum.getString("nama_ruangan"), rsSum.getString("jenis_ruangan"), rsSum.getString("sisa_slot_sewa_harian")
				};
				
				i++;
				dataTempTable.add(data);
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		list = new JList<String>(demoList);
		
		Object[][] dataTable = new Object[dataTempTable.toArray().length][4];
		
		for (int itt = 0; itt < dataTempTable.toArray().length; itt++) {
			dataTable[itt] = dataTempTable.get(itt);
		}
		
		tabbedPane.addTab("Ruangan Tersewa", null, list, null);	
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Ketersedian Ruangan", null, scrollPane, null);
			table = new JTable(dataTable, columns);
		scrollPane.setViewportView(table);
	}
	
	protected void submit() {
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
		RuangCafe ruangCafe = new RuangCafe(activeId, namaPembooking, namaRuangan, jenisRuangan, jumlahSlot, 20);
		if (activeRuanganIndex == -1) {
			ruanganTersewa.add(ruangCafe);
		} else {
			ruanganTersewa.get(activeRuanganIndex).setNamaPembooking(namaPembooking);
			ruanganTersewa.get(activeRuanganIndex).setNamaRuangan(namaRuangan);
			ruanganTersewa.get(activeRuanganIndex).setJenisRuangan(jenisRuangan);
		}
		recordRuangCafe(ruangCafe, activeRuanganIndex == -1 ? "Ruangan Berhasil Disimpan" : "Ruangan Berhasil Di Edit");
		getDataRuangan();
		resetForm();
	}
	
	private void deleteRuanganTersewa() {
		int index = list.getSelectedIndex();
		int rsOrdering = MySQLConnection.executeUpdate("DELETE FROM `ruang_cafe` WHERE id_pembooking=" + "'" + ruanganTersewa.get(index).getIdPembooking() + "'" + "");
		ruanganTersewa.remove(index);
		getDataRuangan();
	}
	
	private void editRuanganTersewa() {
		int index = list.getSelectedIndex();
		activeRuanganIndex = index;
		RuangCafe ruangan = ruanganTersewa.get(index);
		activeId = ruangan.getIdPembooking();
		txtNamaPembooking.setText(ruangan.getNamaPembooking());
		txtJumlahSlot.setText(Integer.toString(ruangan.getJumlahSlotSewaHarian()));
		
		switch (ruangan.getNamaRuangan()) {
			case "R-01":
				cmbRuangan.setSelectedIndex(0);
				break;
			case "V-01":
				cmbRuangan.setSelectedIndex(1);
				break;
			case "X-01":
				cmbRuangan.setSelectedIndex(2);
				break;
			default:
				cmbRuangan.setSelectedIndex(0);
		}
		switch (ruangan.getJenisRuangan()) {
			case "Reguler":
				cmbTipeRuangan.setSelectedIndex(0);
				break;
			case "VIP":
				cmbTipeRuangan.setSelectedIndex(1);
				break;
			case "Extended":
				cmbTipeRuangan.setSelectedIndex(2);
				break;
			default:
				cmbTipeRuangan.setSelectedIndex(0);
		}
	}
	
	private void recordRuangCafe(RuangCafe ruangCafe, String message) {
		if (ruangCafe != null) {
			if (activeRuanganIndex == -1) {
				int rsOrdering = MySQLConnection.executeUpdate("INSERT INTO `ruang_cafe`(`nama_pembooking`, `nama_ruangan`, `jenis_ruangan`, `jumlah_slot_sewa_harian`, `sisa_slot_sewa_harian`)"
						+ "VALUES ('"
						+ ruangCafe.getNamaPembooking() + "','"
						+ (cmbRuangan.getSelectedIndex() + 1) + "', '"
						+ (cmbTipeRuangan.getSelectedIndex() + 1) + "', '"
						+ ruangCafe.getJumlahSlotSewaHarian() + "','"
						+ ruangCafe.getSisaSLotSewaHarian() + "'"
						+ ")");
			} else {
				int rsOrdering = MySQLConnection.executeUpdate("UPDATE `ruang_cafe` SET `nama_pembooking`='" + ruangCafe.getNamaPembooking() + "',`nama_ruangan`='" + (cmbRuangan.getSelectedIndex() + 1) + "',`jenis_ruangan`='" + (cmbTipeRuangan.getSelectedIndex() + 1) + "',`jumlah_slot_sewa_harian`='" + ruangCafe.getJumlahSlotSewaHarian() + "',`sisa_slot_sewa_harian`='" + ruangCafe.getSisaSLotSewaHarian() + "' WHERE id_pembooking=" + "'" + activeId + "'" + "");
			}
		}
		activeRuanganIndex = -1;
		activeId = -1;
	}
	
	public void dropdownComponent(String[] args) {
        String[] optionsToChoose = {"Apple", "Orange", "Banana", "Pineapple", "None of the listed"};

        JFrame jFrame = new JFrame();

        JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose);
        jComboBox.setBounds(80, 50, 140, 20);

        JButton jButton = new JButton("Done");
        jButton.setBounds(100, 100, 90, 20);

        JLabel jLabel = new JLabel();
        jLabel.setBounds(90, 100, 400, 100);

        jFrame.getContentPane().add(jButton);
        jFrame.getContentPane().add(jComboBox);
        jFrame.getContentPane().add(jLabel);
        
        jFrame.getContentPane().setLayout(null);
        jFrame.setSize(350, 250);
        jFrame.setVisible(true);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFruit = "You selected " + jComboBox.getItemAt(jComboBox.getSelectedIndex());
                jLabel.setText(selectedFruit);
            }
        });

    }
	
	private void resetForm() {
		txtNamaPembooking.setText("");
		txtJumlahSlot.setText("");;
		cmbRuangan.setSelectedIndex(0);
		cmbTipeRuangan.setSelectedIndex(0);
	}
}