package img;

import java.awt.Image;
import javax.swing.ImageIcon;

public class IconImage {
	private Image logoImg = new ImageIcon(getClass().getResource("/image/dictionary-icon.png")).getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
	private Image memberImg = new ImageIcon(getClass().getResource("/image/member.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image adminImg = new ImageIcon(getClass().getResource("/image/admin.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image vocabImg = new ImageIcon(getClass().getResource("/image/vocab.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image homeImg = new ImageIcon(getClass().getResource("/image/home.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image dashboardImg = new ImageIcon(getClass().getResource("/image/dashboard.png")).getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH);
	private Image topicImg = new ImageIcon(getClass().getResource("/image/topic.png")).getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH);
	private Image starImg = new ImageIcon(getClass().getResource("/image/star.png")).getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
	private Image starAltImg = new ImageIcon(getClass().getResource("/image/star-alt.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	public Image getLogoImg() {
		return logoImg;
	}
	public Image getMemberImg() {
		return memberImg;
	}
	public Image getAdminImg() {
		return adminImg;
	}
	public Image getVocabImg() {
		return vocabImg;
	}
	public Image getHomeImg() {
		return homeImg;
	}
	public Image getDashboardImg() {
		return dashboardImg;
	}
	public Image getTopicImg() {
		return topicImg;
	}
	public Image getStarImg() {
		return starImg;
	}
	public Image getStarAltImg() {
		return starAltImg;
	}
}
