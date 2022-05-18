package com.mercubuana.Tb1PboMangaCafeView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class Tb1PboMangaCafeView {

	private JFrame frmMangaCafe;
	private JTable table;
	private JList list;
	private JTextField textField;
	private JTextField textField_1;

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
	
	private void initialize() {
		frmMangaCafe = new JFrame();
		frmMangaCafe.setFont(new Font("Arial", Font.PLAIN, 12));
		frmMangaCafe.setTitle("Manga cafe");
		frmMangaCafe.setBounds(100, 100, 657, 598);
		frmMangaCafe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//headers for the table
        String[] columns = new String[] {
            "No", "Ruang", "Jenis", "Sisa Ruang"
        };
         
        //actual data for the table in a 2d array
        Object[][] data = new Object[][] {
            {1, "R-01", "Reguler", 0 },
            {2, "R-01", "VIP", 0 },
            {3, "R-01", "Extended", 0},
            {4, "V-01", "Reguler", 0 },
            {5, "V-01", "VIP", 0 },
            {6, "V-01", "Extended", 0},
            {4, "X-01", "Reguler", 0 },
            {5, "X-01", "VIP", 0 },
            {6, "X-01", "Extended", 0},
        };
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Dialog", Font.PLAIN, 14));
		tabbedPane.setFocusable(false);
		tabbedPane.setFocusTraversalKeysEnabled(false);
		tabbedPane.setBackground(SystemColor.inactiveCaption);
		tabbedPane.setForeground(Color.BLACK);
		
		JButton btnNewButton = new JButton("Tambah");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnHapus = new JButton("Hapus");
		btnHapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		
		JPanel panel_3 = new JPanel();
		
		JPanel panel_4 = new JPanel();
		
		JButton btnPesan = new JButton("Pesan");
		GroupLayout groupLayout = new GroupLayout(frmMangaCafe.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnPesan, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 604, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnHapus, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnHapus, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnPesan, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel_4.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("127px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("263px"),},
			new RowSpec[] {
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("28px"),}));
		
		JLabel lblJumlahSlot = new JLabel("Jumlah Ruangan");
		lblJumlahSlot.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_4.add(lblJumlahSlot, "2, 2, left, center");
		
		textField_1 = new JTextField();
		panel_4.add(textField_1, "4, 2");
		textField_1.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(new CardLayout(0, 0));
		
		JButton btnVip = new JButton("VIP");
		btnVip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_3.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("124px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("269px"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("28px"),}));
		
		JLabel lblJenisRuangan = new JLabel("Jenis Ruangan");
		lblJenisRuangan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_3.add(lblJenisRuangan, "2, 2, left, fill");
		panel_5.add(btnVip, "name_237298207859400");
		
		JMenuItem menuItem = new JMenuItem("New menu item");
		panel_5.add(menuItem, "name_237298221694500");
		panel_3.add(panel_5, "4, 2, fill, fill");
		
		JLabel lblRuangan = new JLabel("Ruangan");
		lblRuangan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		JPanel panel = new JPanel();
		panel.setLayout(new CardLayout(0, 0));
		
		JButton btnNewButton_1 = new JButton("R-01");
		panel.add(btnNewButton_1, "name_237313129570600");
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		panel.add(mntmNewMenuItem, "name_237313140836100");
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("58px"),
				ColumnSpec.decode("74px"),
				ColumnSpec.decode("268px"),},
			new RowSpec[] {
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("28px"),}));
		panel_2.add(lblRuangan, "2, 2, left, top");
		panel_2.add(panel, "4, 2, fill, top");
		
		JLabel lblNewLabel = new JLabel("Nama Pembooking");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setColumns(10);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("118px"),
				FormSpecs.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("265px"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("28px"),}));
		panel_1.add(lblNewLabel, "2, 2, left, center");
		panel_1.add(textField, "4, 2, default, center");
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Ketersedian Ruangan", null, scrollPane, null);
		
		table = new JTable(data, columns);
		scrollPane.setViewportView(table);
		
		list = new JList();
		tabbedPane.addTab("Ruangan Tersewa", null, list, null);
		frmMangaCafe.getContentPane().setLayout(groupLayout);
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
}
