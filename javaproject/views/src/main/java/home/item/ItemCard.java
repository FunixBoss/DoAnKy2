package home.item;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import entity.Lesson;

public class ItemCard extends JPanel {
    private JLabel lbTitle;
    private JLabel lbValues;
    
    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    private Color color1;
    private Color color2;
    private JLabel lblPoint;

    public ItemCard() {
        initComponents();
        setOpaque(false);
        color1 = Color.BLACK;
        color2 = Color.WHITE;
    }

    public void setData(String title, String value, String point) {
        lbTitle.setText(title);
        lbValues.setText(value);
        lblPoint.setText(point);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        lbTitle = new JLabel();
        lbValues = new JLabel();

        lbTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        lbTitle.setForeground(new Color(255, 255, 255));
        lbTitle.setText("Title");

        lbValues.setFont(new Font("SansSerif", Font.BOLD, 14)); 
        lbValues.setForeground(new Color(255, 255, 255));
        lbValues.setText("Values");
        
        lblPoint = new JLabel();
        lblPoint.setText("Point");
        lblPoint.setForeground(Color.WHITE);
        lblPoint.setFont(new Font("SansSerif", Font.BOLD, 18));


        GroupLayout layout = new GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(lbTitle))
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(lbValues))
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(lblPoint, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(380, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lbTitle)
        			.addGap(18)
        			.addComponent(lbValues)
        			.addPreferredGap(ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
        			.addComponent(lblPoint, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        			.addGap(22))
        );
        this.setLayout(layout);
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
        g2.setColor(new Color(255, 255, 255, 50));
        g2.fillOval(getWidth() - (getHeight() / 2), 10, getHeight(), getHeight());
        g2.fillOval(getWidth() - (getHeight() / 2) - 20, getHeight() / 2 + 20, getHeight(), getHeight());
        super.paintComponent(grphcs);
    }
}
