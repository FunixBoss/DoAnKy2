package admin.item;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import admin.panel.PanelAdmin;
import admin.panel.PanelMember;
import admin.update.FrameUpdateAdmin;
import admin.update.FrameUpdateMember;
import entity.User;
import helper.ErrorMessage;
import service.Authorization;
import service.UserService;
import service.VocabularyService;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

public class ItemUser extends JPanel {

	private JLabel lblEmail;

	private User user;
	private UserService userService;
	private JButton btnDelete;
	private JButton btnEdit;
	
	public JPanel panelParent;

	public ItemUser(User user, int y) {
		this.user = user;
		initComponent(y);

	}

	private void initComponent(int y) {
		setLayout(null);
		setBounds(0, y, 995, 53);

		JPanel panel = new JPanel();
		panel.setBounds(0, 52, 995, 1);
		add(panel);
		panel.setBackground(new Color(238, 238, 238));

		JPanel panelHeader = new JPanel();
		panelHeader.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		panelHeader.setBounds(0, 0, 995, 50);
		add(panelHeader);
		panelHeader.setLayout(new GridLayout(0, 5, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panelHeader.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JLabel lblID = new JLabel("ID");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setForeground(new Color(37, 57, 111));
		lblID.setFont(new Font("Arial", Font.PLAIN, 14));
		lblID.setText(user.getId().toString());
		panel_1.add(lblID);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(255, 255, 255));
		panelHeader.add(panel_1_2);
		panel_1_2.setLayout(new BorderLayout(0, 0));

		lblEmail = new JLabel();
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(new Color(37, 57, 111));
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1_2.add(lblEmail);
		lblEmail.setText(user.getEmail());

		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setBackground(Color.WHITE);
		panelHeader.add(panel_1_2_1);
		panel_1_2_1.setLayout(new BorderLayout(0, 0));

		JLabel lblCreatedDate = new JLabel();
		lblCreatedDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreatedDate.setText((String) null);
		lblCreatedDate.setForeground(new Color(37, 57, 111));
		lblCreatedDate.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCreatedDate.setText(user.getCreatedAt().toString());
		panel_1_2_1.add(lblCreatedDate);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(255, 255, 255));
		panelHeader.add(panel_1_1);
		
		btnEdit = new JButton("S???a ");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doBtnEditActionPerformed(e);
			}
		});
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setFont(new Font("Arial", Font.BOLD, 14));
		btnEdit.setBorder(null);
		btnEdit.setBackground(new Color(67, 98, 190));
		btnEdit.setBounds(73, 11, 60, 30);
		panel_1_1.add(btnEdit);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(new Color(255, 255, 255));
		panelHeader.add(panel_1_1_1);
		
		btnDelete = new JButton("X??a");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doBtnDeleteActionPerformed(e);
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Arial", Font.BOLD, 14));
		btnDelete.setBorder(null);
		btnDelete.setBackground(new Color(205, 16, 64));
		btnDelete.setBounds(76, 11, 60, 30);
		panel_1_1_1.add(btnDelete);
	}
	protected void doBtnEditActionPerformed(ActionEvent e) {
		if(Authorization.loggedrole == 1 ) {
			if(user.getRoleId() == 3) {
				FrameUpdateMember a = FrameUpdateMember.getMyInstance(user);
				a.itemUser = this;
				a.setVisible(true);
			} else {
				FrameUpdateAdmin a = FrameUpdateAdmin.getMyInstance(user);
				a.itemAdmin = this;
				a.setVisible(true);
			}
		}else {
			JOptionPane.showMessageDialog(null, "B???n Kh??ng ????? Quy???n H???n ????? Th???c Hi???n!");
		}
	}
	protected void doBtnDeleteActionPerformed(ActionEvent e) {
		if(Authorization.loggedrole == 1) {
			String mess = user.getRoleId() == 3 ? "th??nh vi??n" : "qu???n tr??? vi??n"; 
			int option = JOptionPane.showConfirmDialog(this, "B???n ch???c ch???n mu???n " + mess +" n??y?", "X??a " + mess,
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				userService = new UserService();
				if (userService.delete(user)) {
					JOptionPane.showMessageDialog(this, "Xo?? " + mess + " th??nh c??ng!");
					
					
					if(panelParent instanceof PanelAdmin) {
						JPanel panel = ((PanelAdmin)this.panelParent).getPanel();
						panel.removeAll();
						panel.repaint();
						panel.revalidate();
						((PanelAdmin) this.panelParent).loadData();
					} else if (panelParent instanceof PanelMember){
						JPanel panel = ((PanelMember) this.panelParent).getPanel();
						panel.removeAll();
						panel.repaint();
						panel.revalidate();
						((PanelMember) this.panelParent).loadData();
					}
					
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, "B???n Kh??ng ????? Quy???n H???n ????? Th???c Hi???n!");
		}
	}
}