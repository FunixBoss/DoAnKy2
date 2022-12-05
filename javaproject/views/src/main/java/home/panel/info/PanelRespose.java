package home.panel.info;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.FeedbackDAO;
import dao.VocabularyContributionDAO;
import dao.impl.FeedbackDAOImpl;
import dao.impl.UserDAOImpl;
import dao.impl.VocabularyContributionDAOImpl;
import entity.Feedback;
import entity.VocabularyContribution;
import helper.ErrorMessage;
import helper.StringUtils;
import helper.Validation;
import service.Authorization;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class PanelRespose extends JPanel{

	private JPanel panelContent;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblNewLabel_1;
	private JScrollBar scrollBar;
	private JTextArea txtContent;
	private JLabel lblContent;
	
	private JPanel panelContentFeedback;
	private JPanel panelContentVocabContri;

	private static PanelRespose myInstance;
	private JLabel lblResponse;
	private JButton btnSendFeedback;
	private JPanel panelVocabContri;
	private JLabel lblEmail_1;
	private JTextField txtEmail1;
	private JLabel lblTVng;
	private JLabel lblVocabContri;
	private JButton btnSendVocabContri;
	private JTextField txtWord;
	private JTextField txtMeaning1;
	private JLabel lblMeaning;
	private JTextField txtMeaning2;
	private JTextField txtMeaning3;
	private JPanel panel;

	public static PanelRespose getMyInstance() {
		if (myInstance == null) {
			myInstance = new PanelRespose();
		}
		return myInstance;
	}
	
	public PanelRespose() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 0, 1042, 691);
		panel = new JPanel();
		panel.setLayout(null);
		add(panel);
		
		initComponentFeedback();
		initComponentVocabContri();
		txtEmail.setText(Authorization.email);
		txtEmail.setEditable(false);
		
		txtEmail1.setText(Authorization.email);
		txtEmail1.setEditable(false);
	}

	private void initComponentVocabContri() {
		panelVocabContri = new JPanel();
		panelVocabContri.setLayout(null);
		panelVocabContri.setBorder(BorderFactory.createLineBorder(new Color(37, 57, 111), 2));
		panelVocabContri.setBackground(Color.WHITE);
		panelVocabContri.setBounds(550, 40, 450, 450);
		add(panelVocabContri);
		
		lblEmail_1 = new JLabel("Email");
		lblEmail_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail_1.setBounds(10, 72, 84, 35);
		panelVocabContri.add(lblEmail_1);
		
		txtEmail1 = new JTextField();
		txtEmail1.setText((String) null);
		txtEmail1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail1.setColumns(10);
		txtEmail1.setBounds(93, 72, 347, 35);
		panelVocabContri.add(txtEmail1);
		
		lblTVng = new JLabel("Từ vựng");
		lblTVng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTVng.setBounds(10, 139, 84, 35);
		panelVocabContri.add(lblTVng);
		
		lblVocabContri = new JLabel("Đóng góp từ vựng");
		lblVocabContri.setHorizontalAlignment(SwingConstants.CENTER);
		lblVocabContri.setForeground(new Color(37, 57, 111));
		lblVocabContri.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblVocabContri.setBounds(0, 13, 450, 35);
		panelVocabContri.add(lblVocabContri);
		
		btnSendVocabContri = new JButton("Gửi");
		btnSendVocabContri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doBtnSendFeedback_1ActionPerformed(e);
			}
		});
		btnSendVocabContri.setForeground(Color.WHITE);
		btnSendVocabContri.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSendVocabContri.setBackground(new Color(37, 57, 111));
		btnSendVocabContri.setBounds(175, 400, 100, 35);
		panelVocabContri.add(btnSendVocabContri);
		
		txtWord = new JTextField();
		txtWord.setText((String) null);
		txtWord.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtWord.setColumns(10);
		txtWord.setBounds(93, 137, 347, 35);
		panelVocabContri.add(txtWord);
		
		txtMeaning1 = new JTextField();
		txtMeaning1.setText((String) null);
		txtMeaning1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMeaning1.setColumns(10);
		txtMeaning1.setBounds(93, 205, 347, 35);
		panelVocabContri.add(txtMeaning1);
		
		lblMeaning = new JLabel("Ý Nghĩa");
		lblMeaning.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMeaning.setBounds(10, 205, 84, 35);
		panelVocabContri.add(lblMeaning);
		
		txtMeaning2 = new JTextField();
		txtMeaning2.setText((String) null);
		txtMeaning2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMeaning2.setColumns(10);
		txtMeaning2.setBounds(93, 270, 347, 35);
		panelVocabContri.add(txtMeaning2);
		
		txtMeaning3 = new JTextField();
		txtMeaning3.setText((String) null);
		txtMeaning3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMeaning3.setColumns(10);
		txtMeaning3.setBounds(93, 337, 347, 35);
		panelVocabContri.add(txtMeaning3);
	}

	private void initComponentFeedback() {
		panelContentFeedback = new JPanel();
		panelContentFeedback.setBackground(new Color(255, 255, 255));
		panelContentFeedback.setBounds(41, 41, 450, 450);
		panelContentFeedback.setLayout(null);
		panelContentFeedback.setBorder(BorderFactory.createLineBorder(new Color(37, 57, 111), 2));
		add(panelContentFeedback);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(10, 72, 84, 35);
		panelContentFeedback.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setBounds(93, 72, 347, 35);
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		panelContentFeedback.add(txtEmail);

		panelContent = new JPanel();
		panelContent.setBackground(Color.BLACK);
		panelContent.setBounds(93, 138, 347, 244);
		panelContent.setLayout(new BorderLayout(0, 0));
		panelContentFeedback.add(panelContent);

		txtContent = new JTextArea();
		txtContent.setLineWrap(true);
		txtContent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtContent.setBackground(Color.WHITE);
		txtContent.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		panelContent.add(txtContent);
		
		lblContent = new JLabel("Nội dung");
		lblContent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContent.setBounds(10, 138, 90, 35);
		panelContentFeedback.add(lblContent);
		
		lblResponse = new JLabel("Đóng góp ý kiến");
		lblResponse.setForeground(new Color(37, 57, 111));
		lblResponse.setHorizontalAlignment(SwingConstants.CENTER);
		lblResponse.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblResponse.setBounds(0, 13, 450, 35);
		panelContentFeedback.add(lblResponse);
		
		btnSendFeedback = new JButton("Gửi");
		btnSendFeedback.setForeground(new Color(255, 255, 255));
		btnSendFeedback.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSendFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doBtnSendFeedbackActionPerformed(e);
			}
		});
		btnSendFeedback.setBackground(new Color(37, 57, 111));
		btnSendFeedback.setBounds(175, 400, 100 , 35);
		panelContentFeedback.add(btnSendFeedback);
		
	}
	
	
	
	private boolean validateDataVocabContri() {
		if(txtWord.getText().equals("")) {
			ErrorMessage.ERROR_MESSAGES = "Từ vựng không được để trống!";
			return false;
		} else if(!Validation.checkLength(txtWord.getText(), 1, 200)) {
			ErrorMessage.ERROR_MESSAGES = "Từ vựng tối đa 200 ký tự!";
			return false;
		}
		
		if(!Validation.checkLength(txtMeaning1.getText(), 1, 50) ||
			!Validation.checkLength(txtMeaning2.getText(), 1, 50) ||
			!Validation.checkLength(txtMeaning2.getText(), 1, 50)) {
			ErrorMessage.ERROR_MESSAGES = "Ý nghĩa tối đa 50 ký tự!";
			return false;
		}
		return true;
	}
	
	private boolean validateDataFeedback() {
		if(txtContent.getText().equals("")) {
			ErrorMessage.ERROR_MESSAGES = "Nội dung không được để trống!";
			return false;
		} else if(!Validation.checkLength(txtContent.getText(), 1, 200)) {
			ErrorMessage.ERROR_MESSAGES = "Nội dung tối đa 200 ký tự!";
			return false;
		}
		return true;
	}

	protected void doBtnSendFeedbackActionPerformed(ActionEvent e) {
		if(validateDataFeedback()) {
			FeedbackDAO fbDAO = new FeedbackDAOImpl();
			int id = UserDAOImpl.getIdFromDbByAccount(Authorization.email);
			fbDAO.insert(new Feedback(txtContent.getText(), id));
			JOptionPane.showMessageDialog(this, "Cảm ơn bạn đã đóng góp ý kiến :)!");
			reset();
		} else {
			JOptionPane.showMessageDialog(this, ErrorMessage.ERROR_MESSAGES);
		}
	}
	protected void doBtnSendFeedback_1ActionPerformed(ActionEvent e) {
		if(validateDataVocabContri()) {
			VocabularyContributionDAO vcDAO = new VocabularyContributionDAOImpl();
			int id = UserDAOImpl.getIdFromDbByAccount(Authorization.email);
			StringBuilder meanings = new StringBuilder();
			if(!txtMeaning1.getText().equals("")) {
				meanings.append(StringUtils.formatVocab(txtMeaning1.getText()) + ";");
			}
			if(!txtMeaning2.getText().equals("")) {
				meanings.append(StringUtils.formatVocab(txtMeaning2.getText()) + ";");
			}
			if(!txtMeaning3.getText().equals("")) {
				meanings.append(StringUtils.formatVocab(txtMeaning3.getText()));
			}
			

			vcDAO.insert(new VocabularyContribution(StringUtils.formatVocab(txtWord.getText()), meanings.toString(), id));
			JOptionPane.showMessageDialog(this, "Cảm ơn bạn đã đóng góp từ vựng :)!");
			reset();
		} else {
			JOptionPane.showMessageDialog(this, ErrorMessage.ERROR_MESSAGES);
		}
	}
	
	private void reset() {
		txtContent.setText("");
		txtWord.setText("");
		txtMeaning1.setText("");
		txtMeaning2.setText("");
		txtMeaning3.setText("");
	}
	
}
