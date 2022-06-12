/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isc4u.pkgfinal.project_kaif.david.dieter;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author David
 */
public class VictoryFrame extends JFrame implements ActionListener{
    private SavedData[] saves;
    private int score, level;
    private JButton homeBtn;
    
    public VictoryFrame(Intro intro, SavedData[] saves, int numDeaths, int level){
        this.saves = saves;
        this.score = numDeaths;
        this.level = level;
        initUI();
        //this.intro = intro;
        
    }
    private void initUI() {
        setBackground(Color.WHITE);
        Image homeButton = new ImageIcon(this.getClass().getResource("/isc4u/pkgfinal/project_kaif/david/dieter/Tiles/homeButton.png")).getImage();
        Image newHomeBtn = homeButton.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon iconHomeBtn = new ImageIcon(newHomeBtn);
        homeBtn = new JButton(iconHomeBtn);
        homeBtn.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    
    
}
