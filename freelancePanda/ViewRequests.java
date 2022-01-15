package freelancePanda;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;

public class ViewRequests extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem i1, i2, i3, i4, i5, i6;
	private Seller seller;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JComboBox comboBox;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label8;
	private JLabel ans1;
	private JLabel ans2;
	private JLabel ans3;
	private JLabel ans4;
	private ArrayList<Request> rqsts;
	private JLabel label7;
	private JButton button1;
	private JLabel type;

	public ViewRequests(Seller s) {
		seller = s;
		setTitle("Freelance Panda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][grow][][][][][][][][][][grow][][][][][][][][][][][][pref!,grow,center][][][][][][][][][][][][][][grow]", "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][grow][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]"));
		
		type = new JLabel("Seller Account");
		type.setOpaque(true);
		type.setForeground(Color.WHITE);
		type.setFont(new Font("Tahoma", Font.PLAIN, 18));
		type.setBackground(Color.RED);
		contentPane.add(type, "cell 5 15");
		
		label1 = new JLabel("Active Requests:");
		label1.setBackground(new Color(250, 218, 221));
		label1.setForeground(new Color(255, 0, 0));
		label1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label1.setOpaque(true);
		contentPane.add(label1, "cell 5 24,aligny center");
		
		label2 = new JLabel("0");
		label2.setForeground(new Color(255, 255, 255));
		label2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(label2, "cell 11 24,aligny center");
		
		label3 = new JLabel("Select Request:");
		label3.setBackground(new Color(250, 218, 221));
		label3.setForeground(new Color(255, 0, 0));
		label3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label3.setOpaque(true);
		contentPane.add(label3, "cell 5 36,aligny center");
		
		rqsts = null;
		Request r = new Request();
		rqsts = r.searchActiveRequests();
		String[] temp = null;
		if (rqsts.size() == 0) {
			temp = new String[1];
			temp[0] = "None";
		} else {
			label2.setText(Integer.toString(rqsts.size()));
			temp = new String[rqsts.size()];
			for (int i = 0; i < temp.length; i++) {
				temp[i] = "Request " + (i + 1);
			}
		}
		comboBox = new JComboBox(temp);
		comboBox.addActionListener(this);
		contentPane.add(comboBox, "cell 11 36,aligny center");

		label4 = new JLabel("Request#");
		label4.setBackground(new Color(255, 0, 0));
		label4.setForeground(new Color(255, 255, 255));
		label4.setFont(new Font("Sitka Display", Font.BOLD, 22));
		label4.setOpaque(true);
		contentPane.add(label4, "cell 7 52,aligny center");

		label5 = new JLabel("Sent By");
		label5.setBackground(new Color(255, 0, 0));
		label5.setForeground(new Color(255, 255, 255));
		label5.setFont(new Font("Sitka Display", Font.BOLD, 22));
		label5.setOpaque(true);
		contentPane.add(label5, "cell 11 52,aligny center");
		
		label6 = new JLabel("Price");
		label6.setBackground(new Color(255, 0, 0));
		label6.setForeground(new Color(255, 255, 255));
		label6.setFont(new Font("Sitka Display", Font.BOLD, 22));
		label6.setOpaque(true);
		contentPane.add(label6, "cell 16 52,aligny center");
		
		label7 = new JLabel("Date Sent");
		label7.setBackground(new Color(255, 0, 0));
		label7.setForeground(new Color(255, 255, 255));
		label7.setFont(new Font("Sitka Display", Font.BOLD, 22));
		label7.setOpaque(true);
		contentPane.add(label7, "cell 21 52");
				
		label8 = new JLabel("Action");
		label8.setBackground(new Color(255, 0, 0));
		label8.setForeground(new Color(255, 255, 255));
		label8.setFont(new Font("Sitka Display", Font.BOLD, 22));
		label8.setOpaque(true);
		contentPane.add(label8, "cell 26 52,aligny center");

		ans1 = new JLabel("none");
		ans1.setForeground(new Color(255, 255, 255));
		ans1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(ans1, "cell 7 59,aligny center");

		ans2 = new JLabel("none");
		ans2.setForeground(new Color(255, 255, 255));
		ans2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(ans2, "cell 11 59,aligny center");

		ans3 = new JLabel("none");
		ans3.setForeground(new Color(255, 255, 255));
		ans3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(ans3, "cell 16 59,aligny center");

		ans4 = new JLabel("none");
		ans4.setForeground(new Color(255, 255, 255));
		ans4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(ans4, "cell 21 59,aligny center");
		
		button1 = new JButton("Accept Request");
		button1.setForeground(new Color(255, 255, 255));
		button1.setBackground(new Color(255, 0, 0));
		button1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(button1, "cell 26 59,aligny center");
		button1.addActionListener(this);

		
		 if (rqsts.size() > 0) 
		 {
			ans1.setText(Integer.toString(1));
			ans2.setText(rqsts.get(0).getSender().getUserName());
			ans3.setText(Double.toString(rqsts.get(0).getPrice()));
			ans4.setText(rqsts.get(0).getDate().toString());
		 }
		 
		menuBar = new JMenuBar();
		menu = new JMenu("Main");
		i1 = new JMenuItem("Home");
		i2 = new JMenuItem("Profile");
		i3 = new JMenuItem("Orders");
		i4 = new JMenuItem("Payments");
		i5 = new JMenuItem("Requests");
		i6 = new JMenuItem("Logout");
		menu.add(i1);
		menu.add(i2);
		menu.add(i3);
		menu.add(i4);
		menu.add(i5);
		menu.add(i6);
		menuBar.add(menu);
		setJMenuBar(menuBar);
		i1.addActionListener(this);
		i2.addActionListener(this);
		i3.addActionListener(this);
		i4.addActionListener(this);
		i5.addActionListener(this);
		i6.addActionListener(this);
		if (seller == null)
			i5.setVisible(false);
	}

	public void actionPerformed(ActionEvent e) {
		Person p = seller;
		String title = e.getActionCommand();
		if (title.equals("Home")) {
			setVisible(false);
			Home home = new Home(p);
			home.setVisible(true);
		} 
		else if (title.equals("Profile")) {
			setVisible(false);
			Profile pf = new Profile(p);
			pf.setVisible(true);
		} 
		else if (title.equals("Orders")) {
			setVisible(false);
			Orders o = new Orders(p);
			o.setVisible(true);
		} 
		else if (title.equals("Payments")) 
		{
			setVisible(false);
			Payments pay = new Payments(p);
			pay.setVisible(true);
		}
		else if (title.equals("Requests"))
		{
			setVisible(false);
			ViewRequests view = new ViewRequests(seller);
			view.setVisible(true);
		}
		else if (title.equals("Logout"))
		{
			setVisible(false);
			Main mn = new Main(false);
			mn.setVisible(true);
		}
		else if (title.equals("Accept Request")) 
		{
			if (rqsts.size() <= 0)
			{
				JOptionPane.showMessageDialog(null, "No request to accept!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			Request current = rqsts.get(comboBox.getSelectedIndex());
			Request r = new Request();
			r.acceptRequest(current, seller);
			setVisible(false);
			ViewRequests view = new ViewRequests(seller);
			view.setVisible(true);
			JOptionPane.showMessageDialog(null, "Order created!","Success", JOptionPane.ERROR_MESSAGE);
			return;
		}
		JComboBox temp = null;
		if (e.getSource() instanceof JComboBox) {
			temp = (JComboBox) e.getSource();
			int index = temp.getSelectedIndex();
			ans1.setText(Integer.toString(index + 1));
			ans2.setText(rqsts.get(index).getSender().getUserName());
			ans3.setText(Double.toString(rqsts.get(index).getPrice()));
			ans4.setText(rqsts.get(index).getDate().toString());
		}
	}

}
