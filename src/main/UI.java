package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;

import data.GregorianInfo;
import data.ImladrisInfo;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

public class UI {
	
	/* FRAME */
	private JFrame frame;
	
	/* GREGORIAN to IMLADRIS */
	private JTextField year;
	private JComboBox month;
	private JComboBox day;
	private JCheckBox afterSunset;
	private JButton toImladris;
	private JTextPane resImladris;
	
	/* IMLADRIS to GREGORIAN */
	private JTextField loa;
	private JComboBox yen;
	private JComboBox period;
	private JComboBox dayOfLoa;
	private JButton toGregorian;
	private JTextPane resGregorian;
	
	/* SETTINGS */
	private JTextField city;
	private JTextField country;
	private JLabel saveResult;
	
	/* TODAY */
	private JLabel locationInfo;
	private JTextPane todayGregorian;
	private JTextPane todayImladris;
	
	/* Frame */
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	/* Gregorian to Imladris */
	public JTextField getYear() {
		return year;
	}
	public void setYear(JTextField year) {
		this.year = year;
	}
	public JComboBox getMonth() {
		return month;
	}
	public void setMonth(JComboBox month) {
		this.month = month;
	}
	public JComboBox getDay() {
		return day;
	}
	public void setDay(JComboBox day) {
		this.day = day;
	}
	public JCheckBox getAfterSunset() {
		return afterSunset;
	}
	public void setAfterSunset(JCheckBox afterSunset) {
		this.afterSunset = afterSunset;
	}
	public JButton getToImladris() {
		return toImladris;
	}
	public void setToImladris(JButton toImladris) {
		this.toImladris = toImladris;
	}
	public JTextPane getResImladris() {
		return resImladris;
	}
	public void setResImladris(JTextPane resImladris) {
		this.resImladris = resImladris;
	}
	
	/* Imladris to Gregorian */
	public JTextField getLoa() {
		return loa;
	}
	public void setLoa(JTextField loa) {
		this.loa = loa;
	}
	public JComboBox getYen() {
		return yen;
	}
	public void setYen(JComboBox yen) {
		this.yen = yen;
	}
	public JComboBox getPeriod() {
		return period;
	}
	public void setPeriod(JComboBox period) {
		this.period = period;
	}
	public JComboBox getDayOfLoa() {
		return dayOfLoa;
	}
	public void setDayOfLoa(JComboBox dayOfLoa) {
		this.dayOfLoa = dayOfLoa;
	}
	public JButton getToGregorian() {
		return toGregorian;
	}
	public void setToGregorian(JButton toGregorian) {
		this.toGregorian = toGregorian;
	}
	public JTextPane getResGregorian() {
		return resGregorian;
	}
	public void setResGregorian(JTextPane resGregorian) {
		this.resGregorian = resGregorian;
	}
	
	/* Settings */
	public JTextField getCity() {
		return city;
	}
	public void setCity(JTextField city) {
		this.city = city;
	}
	public JTextField getCountry() {
		return country;
	}
	public void setCountry(JTextField country) {
		this.country = country;
	}
	public JLabel getSaveResult() {
		return saveResult;
	}
	public void setSaveResult(JLabel saveResult) {
		this.saveResult = saveResult;
	}
	
	/* Today */
	public JLabel getLocationInfo() {
		return locationInfo;
	}
	public void setLocationInfo(JLabel locationInfo) {
		this.locationInfo = locationInfo;
	}
	public JTextPane getTodayGregorian() {
		return todayGregorian;
	}
	public void setTodayGregorian(JTextPane todayGregorian) {
		this.todayGregorian = todayGregorian;
	}
	public JTextPane getTodayImladris() {
		return todayImladris;
	}
	public void setTodayImladris(JTextPane todayImladris) {
		this.todayImladris = todayImladris;
	}
	
	/**
	 * Create the application.
	 */
	private static UI instance = null;
	public static UI getInstance() {
		if(instance == null) {
			instance = new UI();
		}
		return instance;
	}
	private UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("Notië Imberissëo 1.0 beta");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(520, 300);
		frame.setLocation(300,200);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{520, 0};
		gridBagLayout.rowHeights = new int[]{227, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		frame.getContentPane().add(tabbedPane, gbc_tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("To Imladris Reckoning", null, panel_1, "Convert from Gregorian to Imladris Reckoning");
		panel_1.setBorder(null);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(2dlu;default)"),
				ColumnSpec.decode("172px"),
				ColumnSpec.decode("32px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("55px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("32px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(20dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(14dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(5dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(12dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_1.add(lblYear, "5, 2, 3, 1, center, default");
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_1.add(lblMonth, "9, 2, 5, 1, center, default");
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_1.add(lblDay, "15, 2, 3, 1, center, default");
		
		JLabel lblChooseGregorianDate = new JLabel("Choose Gregorian date:");
		panel_1.add(lblChooseGregorianDate, "2, 4, 2, 1, fill, fill");
		
		year = new JTextField();
		year.setToolTipText("Valid years: 1 - 2299");
		year.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				UIController.getInstance().updateDayComboGregorian();
			}
		});
		panel_1.add(year, "5, 4, 3, 1, fill, fill");
		
		month = new JComboBox();
		month.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UIController.getInstance().updateDayComboGregorian();
			}
		});
		month.setModel(new DefaultComboBoxModel(GregorianInfo.getInstance().getMonthsArray()));
		panel_1.add(month, "9, 4, 5, 1, fill, fill");
		
		day = new JComboBox();
		day.setEnabled(false);
		panel_1.add(day, "15, 4, 3, 1, fill, fill");
		
		toImladris = new JButton(">>");
		toImladris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UIController.getInstance().convertToImladris();
			}
		});
		
		afterSunset = new JCheckBox("After sunset");
		afterSunset.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_1.add(afterSunset, "5, 6, 5, 1");
		toImladris.setEnabled(false);
		panel_1.add(toImladris, "11, 6, 7, 1, fill, fill");
		
		JLabel lblResultingImladrisDate = new JLabel("Resulting Imladris date:");
		panel_1.add(lblResultingImladrisDate, "2, 10, 2, 1, fill, fill");
		
		resImladris = new JTextPane();
		panel_1.add(resImladris, "5, 10, 13, 1, fill, fill");
		
		JLabel lblFormat = new JLabel("(Format: Weekday, Period [Day#], Yén Loa)");
		lblFormat.setFont(new Font("Dialog", Font.PLAIN, 10));
		panel_1.add(lblFormat, "5, 12, 13, 1, fill, fill");
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("From Imladris Reckoning", null, panel_2, "Convert from Imladris to Gregorian Reckoning");
		panel_2.setBorder(null);
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(87dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:max(13dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(12dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(8dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(9dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(5dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblYn = new JLabel("Yén");
		lblYn.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_2.add(lblYn, "6, 2, 3, 1, center, default");
		
		JLabel lblLoa = new JLabel("Loa");
		lblLoa.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_2.add(lblLoa, "10, 2, 3, 1, center, default");
		
		JLabel lblPeriod = new JLabel("Period");
		lblPeriod.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_2.add(lblPeriod, "14, 2, 5, 1, center, default");
		
		JLabel lblNewLabel = new JLabel("Day");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_2.add(lblNewLabel, "20, 2, 3, 1, center, default");
		
		JLabel lblS = new JLabel("Choose Imladris date:");
		panel_2.add(lblS, "2, 4, 3, 1, fill, fill");
		
		yen = new JComboBox();
		yen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UIController.getInstance().updateDayComboImladris();
			}
		});
		yen.setModel(new DefaultComboBoxModel(ImladrisInfo.getInstance().getYeniArray()));
		panel_2.add(yen, "6, 4, 3, 1, fill, fill");
		
		loa = new JTextField();
		loa.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				UIController.getInstance().updateDayComboImladris();
			}
		});
		loa.setToolTipText("Valid loar: 1 - 144");
		panel_2.add(loa, "10, 4, 3, 1, fill, fill");
		loa.setColumns(10);
		
		period = new JComboBox();
		period.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIController.getInstance().updateDayComboImladris();
			}
		});
		period.setModel(new DefaultComboBoxModel(ImladrisInfo.getInstance().getPeriodsArray()));
		panel_2.add(period, "14, 4, 5, 1, fill, fill");
		
		dayOfLoa = new JComboBox();
		dayOfLoa.setEnabled(false);
		panel_2.add(dayOfLoa, "20, 4, 3, 1, fill, fill");
		
		toGregorian = new JButton(">>");
		toGregorian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIController.getInstance().convertToGregorian();
			}
		});
		toGregorian.setEnabled(false);
		panel_2.add(toGregorian, "16, 6, 7, 1, fill, fill");
		
		JLabel lblNewLabel_1 = new JLabel("Resulting Gregorian date:");
		panel_2.add(lblNewLabel_1, "2, 10, 3, 1, fill, fill");
		
		resGregorian = new JTextPane();
		panel_2.add(resGregorian, "6, 10, 17, 1, fill, fill");
		
		JLabel lblNewLabel_2 = new JLabel("(Format: Weekday, Month Day, Year)");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 10));
		panel_2.add(lblNewLabel_2, "6, 12, 17, 1");
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		tabbedPane.addTab("Settings", null, panel, "Set configuration");
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(61dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblCity = new JLabel("City:");
		panel.add(lblCity, "2, 4, right, fill");
		
		city = new JTextField();
		panel.add(city, "4, 4, fill, fill");
		city.setColumns(10);
		
		JLabel lblCountry = new JLabel("Country:");
		panel.add(lblCountry, "2, 6, right, fill");
		
		country = new JTextField();
		panel.add(country, "4, 6, fill, fill");
		country.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIController.getInstance().saveSettings();
			}
		});
		panel.add(btnSave, "4, 8, right, fill");
		
		saveResult = new JLabel("");
		saveResult.setForeground(Color.GREEN);
		panel.add(saveResult, "2, 10, 3, 1, right, fill");
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		frame.getContentPane().add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 401, 0};
		gbl_panel_3.rowHeights = new int[]{0, 24, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblTodaysDate = new JLabel("Current date:");
		GridBagConstraints gbc_lblTodaysDate = new GridBagConstraints();
		gbc_lblTodaysDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblTodaysDate.gridx = 0;
		gbc_lblTodaysDate.gridy = 0;
		panel_3.add(lblTodaysDate, gbc_lblTodaysDate);
		
		locationInfo = new JLabel("");
		locationInfo.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_locationInfo = new GridBagConstraints();
		gbc_locationInfo.anchor = GridBagConstraints.EAST;
		gbc_locationInfo.insets = new Insets(0, 0, 5, 0);
		gbc_locationInfo.gridx = 1;
		gbc_locationInfo.gridy = 0;
		panel_3.add(locationInfo, gbc_locationInfo);
		
		JLabel lblGregorian = new JLabel("Gregorian:");
		lblGregorian.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblGregorian = new GridBagConstraints();
		gbc_lblGregorian.anchor = GridBagConstraints.EAST;
		gbc_lblGregorian.insets = new Insets(0, 0, 5, 5);
		gbc_lblGregorian.gridx = 0;
		gbc_lblGregorian.gridy = 1;
		panel_3.add(lblGregorian, gbc_lblGregorian);
		
		todayGregorian = new JTextPane();
		GridBagConstraints gbc_todayGregorian = new GridBagConstraints();
		gbc_todayGregorian.insets = new Insets(0, 0, 5, 0);
		gbc_todayGregorian.fill = GridBagConstraints.BOTH;
		gbc_todayGregorian.gridx = 1;
		gbc_todayGregorian.gridy = 1;
		panel_3.add(todayGregorian, gbc_todayGregorian);
		
		JLabel lblImladris = new JLabel("Imladris:");
		lblImladris.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblImladris = new GridBagConstraints();
		gbc_lblImladris.anchor = GridBagConstraints.EAST;
		gbc_lblImladris.insets = new Insets(0, 0, 0, 5);
		gbc_lblImladris.gridx = 0;
		gbc_lblImladris.gridy = 2;
		panel_3.add(lblImladris, gbc_lblImladris);
		
		todayImladris = new JTextPane();
		GridBagConstraints gbc_todayImladris = new GridBagConstraints();
		gbc_todayImladris.fill = GridBagConstraints.BOTH;
		gbc_todayImladris.gridx = 1;
		gbc_todayImladris.gridy = 2;
		panel_3.add(todayImladris, gbc_todayImladris);
	}

}
