package freelancePanda;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Registration extends JFrame {
	private Person p;
	private JPanel contentPane;
	private JTextField textField1;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JTextField textField2;
	private JTextField textField3;
	private JPasswordField textField4;
	private JLabel label5;
	private JPasswordField textField5;
	private JTable table;
	private JLabel label6;
	private JButton button;
	private JScrollPane scrollPane;
	private int langcount;
	private String languages[] = new String[3];

	private JPanel contentPane2;
	private JTextField inp;
	private JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7;
	private JTextArea textArea;
	private JButton button2;
	private JComboBox comboBox, comboBox2, comboBox3, comboBox4, comboBox5;
	private boolean b;

	public Registration(boolean buyer) {
		setTitle("Freelance Panda");
		b = buyer;
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));

		setContentPane(contentPane);

		contentPane.setLayout(new MigLayout("",
				"[][][][][][][][][][][][][][][][][][][grow][][][][][][][][][][][pref!,grow,center][][][][][][][][][][][][][grow]",
				"[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][grow][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]"));
		label1 = new JLabel("First Name:");
		label1.setForeground(new Color(255, 255, 255));
		label1.setFont(new Font(label1.getFont().toString(), Font.PLAIN, 20));
		contentPane.add(label1, "cell 15 23,aligny center");

		textField1 = new JTextField();
		textField1.setFont(new Font(textField1.getFont().toString(), Font.PLAIN, 20));
		textField1.setColumns(10);
		contentPane.add(textField1, "cell 18 23,aligny center");

		label2 = new JLabel("Last Name:");
		label2.setForeground(new Color(255, 255, 255));
		contentPane.add(label2, "cell 15 30");
		label2.setFont(new Font(label2.getFont().toString(), Font.PLAIN, 20));

		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setFont(new Font(textField2.getFont().toString(), Font.PLAIN, 20));
		contentPane.add(textField2, "cell 18 30,aligny center");

		label3 = new JLabel("Username:");
		label3.setForeground(new Color(255, 255, 255));
		contentPane.add(label3, "cell 15 37");
		label3.setFont(new Font(label3.getFont().toString(), Font.PLAIN, 20));

		textField3 = new JTextField();
		textField3.setColumns(10);
		textField3.setFont(new Font(textField3.getFont().toString(), Font.PLAIN, 20));
		contentPane.add(textField3, "cell 18 37,aligny center");

		label4 = new JLabel("Password:");
		label4.setForeground(new Color(255, 255, 255));
		contentPane.add(label4, "cell 15 44");
		label4.setFont(new Font(label4.getFont().toString(), Font.PLAIN, 20));

		textField4 = new JPasswordField();
		contentPane.add(textField4, "cell 18 44,growy");
		textField4.setFont(new Font(textField4.getFont().toString(), Font.PLAIN, 20));
		textField4.setColumns(10);

		label5 = new JLabel("Re-type Password:");
		label5.setForeground(new Color(255, 255, 255));
		contentPane.add(label5, "cell 15 51");
		label5.setFont(new Font(label5.getFont().toString(), Font.PLAIN, 20));

		textField5 = new JPasswordField();
		textField5.setColumns(10);
		textField5.setFont(new Font(textField5.getFont().toString(), Font.PLAIN, 20));
		contentPane.add(textField5, "cell 18 51,growy");
		String columns[] = { "Language", "Select any 3" };
		Object[][] data = { { "English" }, { "Urdu" }, { "Spanish" }, { "Chinese" }, { "Arabic" }, { "Portuguese" },
				{ "Russian" }, { "Japanese" }, { "German" }, { "Korean" }, { "French" }, { "Turkish" },
				{ "Vietnamese" }, { "Italian" }, { "Polish" }, { "Romanian" }, { "Greek" }, { "Dutch" } };
		DefaultTableModel model = new DefaultTableModel(data, columns);
		label6 = new JLabel("Languages:");
		label6.setForeground(new Color(255, 255, 255));
		label6.setFont(new Font(label6.getFont().toString(), Font.PLAIN, 20));
		contentPane.add(label6, "cell 15 68,aligny center");
		table = new JTable(model) {

			private static final long serialVersionUID = 1L;

			@Override
			public Class getColumnClass(int column) {
				switch (column) {
				case 0:
					return String.class;
				default:
					return Boolean.class;
				}
			}
		};
		scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, "cell 18 68 1 8");

		button = new JButton("Submit");
		button.setBackground(new Color(255, 0, 0));
		button.setForeground(new Color(255, 255, 255));
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));

		contentPane.add(button, "cell 16 88");
		// button.setPreferredSize(new Dimension(100,100));
		getClickValue();
		if (b) {
			submit();
		} else {
			button.setText("Next");
			next();
				
		}
		// contentPane.setLayout(null);
	}

	public void submit2() {
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Seller seller;
				String first, last, user, pass, pass2;
				String langs[] = new String[3];
				first = textField1.getText().toString();
				last = textField2.getText().toString();
				user = textField3.getText().toString();
				pass = new String(textField4.getPassword());
				pass2 = new String(textField4.getPassword());
				for (int i = 0; i < 3; i++) {
					if (languages[i] == null)
						languages[i] = "none";
				}
				// seller portion
				String[] skills = new String[3];
				String descp, degree, insituteName;
				int insituteType;
				descp = textArea.getText().toString();
				insituteName = inp.getText().toString();
				insituteType = comboBox.getSelectedIndex();
				degree = (String) comboBox2.getSelectedItem();
				skills[0] = (String) comboBox3.getSelectedItem();
				skills[1] = (String) comboBox4.getSelectedItem();
				skills[2] = (String) comboBox5.getSelectedItem();
				seller = new Seller(user, pass, first, last, languages, degree, insituteType, insituteName, skills,
						descp);
				if (descp.length() < 7)
				{
					JOptionPane.showMessageDialog(null, "Description too short!","Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (insituteName.equals("") || insituteName.equals(" "))
					insituteName = "None";
				seller.writeData();
				setVisible(false);
				Main m = new Main(false);
				m.setVisible(true);
				m.setScreen2();
				JOptionPane.showMessageDialog(null, "Account created Successfully!You can login now","Success", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}

	public void next() {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String first, last, user, pass, pass2;
				String langs[] = new String[3];
				first = textField1.getText().toString();
				last = textField2.getText().toString();
				user = textField3.getText().toString();
				pass = new String(textField4.getPassword());
				pass2 = new String(textField5.getPassword());
				for (int i = 0; i < 3; i++) {
					if (languages[i] == null)
						languages[i] = "none";
				}
				Person p = new Buyer(user, pass, first, last, languages);		//temp buyer
				boolean res1 = p.validateFirstName();
				boolean res2 = p.validateLastName();
				boolean res3 = p.validateUserName();
				boolean res4 = p.validatePassword();
				boolean res5 = p.uniqueUserName();
				boolean res6 = false;
				if (pass.equals(pass2))
					res6 = true;
				else
					res6 = false;
				if (res1 && res2 && res3 && res4 && res5 && res6)
				{
					screen2();
					setContentPane(contentPane2);
				}
				else
				{
					if (!(res1))
					{
						JOptionPane.showMessageDialog(null, "Invalid First Name!","Error", JOptionPane.ERROR_MESSAGE);
					}
					if (!(res2))
					{
						JOptionPane.showMessageDialog(null, "Invalid Last Name!","Error", JOptionPane.ERROR_MESSAGE);
					}
					if (!(res3))
					{
						JOptionPane.showMessageDialog(null, "Invalid user name!Not unique enough!","Error", JOptionPane.ERROR_MESSAGE);
					}
					if (!(res4))
					{
						JOptionPane.showMessageDialog(null, "Invalid Password!Password must be atleast 7 digits long and must contain an alpabhet, a number & a special character","Error", JOptionPane.ERROR_MESSAGE);
					}
					if (!(res5))
					{
						JOptionPane.showMessageDialog(null, "User name is already taken!","Error", JOptionPane.ERROR_MESSAGE);
					}
					if (!(res6))
					{
						JOptionPane.showMessageDialog(null, "Passwords don't match!","Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
	}

	public void submit() {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Buyer buyer;
				String first, last, user, pass, pass2;
				String langs[] = new String[3];
				first = textField1.getText().toString();
				last = textField2.getText().toString();
				user = textField3.getText().toString();
				pass = new String(textField4.getPassword());
				pass2 = new String(textField5.getPassword());
				for (int i = 0; i < 3; i++) {
					if (languages[i] == null)
						languages[i] = "none";
				}
				if (b) {
					buyer = new Buyer(user, pass, first, last, languages);
					boolean res1 = buyer.validateFirstName();
					boolean res2 = buyer.validateLastName();
					boolean res3 = buyer.validateUserName();
					boolean res4 = buyer.validatePassword();
					boolean res5 = buyer.uniqueUserName();
					boolean res6 = false;
					if (pass.equals(pass2))
					{
						res6 = true;
					}
					else
					{
						res6 = false;
					}
					if (res1 && res2 && res3 && res4 && res5 && res6)
					{
						buyer.writeData();
						setVisible(false);
						Main m = new Main(true);
						m.setVisible(true);
						m.setScreen2();
						JOptionPane.showMessageDialog(null, "Account created Successfully!You can login now","Success", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						if (!(res1))
						{
							JOptionPane.showMessageDialog(null, "Invalid First Name!","Error", JOptionPane.ERROR_MESSAGE);
						}
						if (!(res2))
						{
							JOptionPane.showMessageDialog(null, "Invalid Last Name!","Error", JOptionPane.ERROR_MESSAGE);
						}
						if (!(res3))
						{
							JOptionPane.showMessageDialog(null, "Invalid user name!Not unqiue enough!","Error", JOptionPane.ERROR_MESSAGE);
						}
						if (!(res4))
						{
							JOptionPane.showMessageDialog(null, "Invalid Password!Password must be atleast 7 digits long and must contain an alpabhet, a number & a special character","Error", JOptionPane.ERROR_MESSAGE);
						}
						if (!(res5))
						{
							JOptionPane.showMessageDialog(null, "User name is already taken!","Error", JOptionPane.ERROR_MESSAGE);
						}
						if (!(res6))
						{
							JOptionPane.showMessageDialog(null, "Passwords don't match!","Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
	}

	public void getClickValue() {
		final String lang;
		if (langcount == 3)
			return;
		table.getModel().addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				for (int i = 0; i < table.getRowCount(); i++) {
					if (table.getValueAt(i, 1) != null) {
						boolean checked = (Boolean) table.getValueAt(i, 1);
						if (checked && langcount != 3) {
							languages[langcount] = (String) table.getValueAt(table.getSelectedRow(), 0);
							langcount++;
							break;
						} else
							break;
					}
					// break;
				}

			}
		});
	}
	public void screen2()
	{
		contentPane2 = new JPanel();
		contentPane2.setBackground(new Color(0, 0, 0));
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane2);
		
		contentPane2.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][grow][][][][][][][grow][][][][][][][][][][][pref!,grow,center][][][][][][][][][][][][][grow]", "[][][][][][][][][][][grow][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][grow][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]"));
		
		lbl1 = new JLabel("Description:");
		lbl1.setForeground(new Color(255, 255, 255));
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane2.add(lbl1, "cell 10 10");
		
		textArea = new JTextArea();
		textArea.setDropMode(DropMode.INSERT);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea.setLineWrap(true);
		textArea.setColumns(50);
		contentPane2.add(textArea, "cell 14 10");
		
		String insitutes[] = {"None", "High School", "College"};
		
		lbl2 = new JLabel("Education:");
		lbl2.setForeground(new Color(255, 255, 255));
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane2.add(lbl2, "cell 10 11");
		//JComboBox<String> comboBox = new JComboBox<String>(insitutes);//pass the chosen index as the insitute type parameter
		comboBox = new JComboBox(insitutes);
		contentPane2.add(comboBox, "cell 14 11,aligny center");
		
		lbl3 = new JLabel("Current/Latest Degree:");
		lbl3.setForeground(new Color(255, 255, 255));
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane2.add(lbl3, "cell 10 22");

		String degrees[] = {"None", "Architecture", "Arts", "Business", "Business Administration", "Computer Science", "Criminal Justice", "Education",  "Wireless Engineering", "Aerospace Engineering", 
				"Agricultural Engineering", "Chemical Engineering", "Civil Engineering", "Computer Engineering", "Electrical Engineering", "Mechanical Engineering", "Software Engineering",
				"Journalism", "Laws", "Literature", "Philosophy", "Chemistry", "Mathematics", "Staistics", "Physics", "English"};
		
		comboBox2 = new JComboBox(degrees);
		comboBox2.setMaximumRowCount(26);
		contentPane2.add(comboBox2, "cell 14 22,aligny center");
		
		lbl4 = new JLabel("Skill #1:");
		lbl4.setForeground(new Color(255, 255, 255));
		lbl4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane2.add(lbl4, "cell 10 33");

		lbl5 = new JLabel("Skill #2:");
		lbl5.setForeground(new Color(255, 255, 255));
		lbl5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane2.add(lbl5, "cell 10 44");
		
		String skills[] = {"None", "Programming", "Databases", "Web Development", "Graphic Desiging", "Operating Systems", "Machine Learning", "Artifical Intelligence", "Data Entry", 
				"Content Writing", "Art and Drawing", "Tutoring", "Virtual Assistant", "Software Development", "Calculus", "Differential Equations", "Private Investigator", "Communication", 
				"Networking", "Article Writing"};
		
		comboBox3 = new JComboBox(skills);
		comboBox3.setMaximumRowCount(20);
		contentPane2.add(comboBox3, "cell 14 33,aligny center");
		
		comboBox4 = new JComboBox(skills);
		comboBox4.setMaximumRowCount(20);
		contentPane2.add(comboBox4, "cell 14 44,aligny center");
		
		lbl6 = new JLabel("Skill #3:");
		lbl6.setForeground(new Color(255, 255, 255));
		lbl6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane2.add(lbl6, "cell 10 55");
		
		comboBox5 = new JComboBox(skills);
		comboBox5.setMaximumRowCount(20);
		contentPane2.add(comboBox5, "cell 14 55,aligny center");
		
		lbl7 = new JLabel("Institute Name:");
		lbl7.setForeground(new Color(255, 255, 255));
		lbl7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane2.add(lbl7, "cell 10 66");
		
		inp = new JTextField();
		inp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		inp.setColumns(15);
		contentPane2.add(inp, "cell 14 66,aligny center");
		
		button2 = new JButton("Submit");
		button2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button2.setBackground(new Color(255, 0, 0));
		button2.setForeground(new Color(255, 255, 255));
		contentPane2.add(button2, "cell 14 74");
		submit2();
	}
}
