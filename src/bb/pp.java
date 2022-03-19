package bb;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//import cc.Price;
//import cc.PriceDAO;

import javax.swing.JList;

public class pp {

	private JFrame frame;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		run();
		
	}
	public static void run() {
		
		pp window = new pp();
		window.frame.setVisible(true);
	
}

	/**
	 * Create the application.
	 */
	public pp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		PriceDAO bbsDAO = new PriceDAO();
		ArrayList<Price> list = bbsDAO.getList();
		ArrayList<Price> list1 = bbsDAO.getavgList();
		ArrayList<Price> list2 = bbsDAO.getListmax_min();

		


		frame = new JFrame();
		frame.setBounds(100, 100, 621, 458);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblCost = new JLabel("Average of Broker fee");
		lblCost.setBounds(230, 16, 139, 27);
		frame.getContentPane().add(lblCost);

		String[] headings = new String[] { "year", "price" };
	


		Object[][] data = new Object[list1.size()][2];
		for (int i = 0; i < list1.size(); i++) {
			data[i][0] = list1.get(i).getAvgYear();
			data[i][1] = list1.get(i).getAvgPrice();
		};
		

		JTable table = new JTable(data, headings);
		table.setColumnSelectionAllowed(true);
		table.setBounds(50, 67, 519, 255);
		frame.getContentPane().add(table);

		JLabel lblMax = new JLabel("MIN");
		lblMax.setBounds(50, 356, 61, 16);
		frame.getContentPane().add(lblMax);

		JLabel label = new JLabel("MAX");
		label.setBounds(50, 328, 61, 16);
		frame.getContentPane().add(label);
		JLabel lblNewLabel = new JLabel();
		// JLabel lblNewLabel = new JLabel("%s",);
		lblNewLabel.setText(Integer.toString(list2.get(1).getMax_year()));

		// lblNewLabel.setText(tostring.list2.get(1).getMax_price());

		lblNewLabel.setBounds(93, 328, 61, 16);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setText(Integer.toString(list2.get(0).getMax_year()));
		lblNewLabel_1.setBounds(93, 356, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setText(Integer.toString(list2.get(1).getMax_price()));
		lblNewLabel_2.setBounds(166, 328, 93, 16);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setText(Integer.toString(list2.get(0).getMax_price()));
		lblNewLabel_3.setBounds(166, 356, 93, 16);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("year");
		lblNewLabel_4.setBounds(50, 39, 61, 16);
		frame.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("price");
		lblNewLabel_5.setBounds(308, 39, 61, 16);
		frame.getContentPane().add(lblNewLabel_5);
	}

	private void printf(String string, int idprice) {
		// TODO Auto-generated method stub

	}
}
