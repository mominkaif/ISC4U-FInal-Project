/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isc4u.pkgfinal.project_kaif.david.dieter;
//import class var from drawBoard (instance of Intro class Jframe)
import static isc4u.pkgfinal.project_kaif.david.dieter.DrawBoard.intro;
import java.awt.Color;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author David
 */
public class VictoryFrame extends JFrame implements ActionListener{
    private SavedData [] saves;
    private int score, level;
    private JButton homeBtn, searchBtn;
    private TextArea textA;
    
    private FileOutputStream out;
    
    public VictoryFrame(Intro i, SavedData [] saves, int numDeaths, int level){
        this.saves = saves;
        this.score = numDeaths;
        this.level = level;
        initUI();
        intro = i;
        
    }
    private void initUI() {
        //for the home btn
        Image homeButton = new ImageIcon(this.getClass().getResource("/isc4u/pkgfinal/project_kaif/david/dieter/Tiles/homeButton.png")).getImage();
        Image newHomeBtn = homeButton.getScaledInstance(250, 250, Image.SCALE_FAST); //scale it to same width and height and do it fast
        ImageIcon iconHomeBtn = new ImageIcon(newHomeBtn); //create image icon
        homeBtn = new JButton(iconHomeBtn); //param is icon
        homeBtn.addActionListener(this); //add action listener
        homeBtn.setBounds(800, 320, 250, 250); //set x and w pos, same width and height
        
        //for the search btn, same as above
        Image searchBtn = new ImageIcon(this.getClass().getResource("/isc4u/pkgfinal/project_kaif/david/dieter/Tiles/searchButton.png")).getImage();
        Image newHomeBtn = homeButton.getScaledInstance(250, 250, Image.SCALE_FAST); 
        ImageIcon iconHomeBtn = new ImageIcon(newHomeBtn); 
        homeBtn = new JButton(iconHomeBtn); 
        homeBtn.addActionListener(this); 
        homeBtn.setBounds(60, 320, 250, 250); 
        
        //for the textArea
        textA = new TextArea();
        textA.setEnabled(false);
        textA.setBounds(100, 50, 760, 400);
        
        //must add components to JFrame
        add(textA);
        add(homeBtn);
        add(searchBtn);
        
        //JOption pane to ask for username
        String name = JOptionPane.showInputDialog("Enter your Username: ");
        saves[saves.length - 1] = new SavedData(score, name);
      
        int leftIndex = 0; //left Index is always 0
        int rightIndex = saves.length - 1; //rightmost index
        quickSort(saves, leftIndex, rightIndex);
        
        writeToFile(saves, level); //write sorted array to save file
        
        String highScores = "Highscores: "; //start of string
        //loop through array ten times to get ten best scores
        for (int i = 0; i < 10; i++) {
            if(saves.length > i){ //only add best scores until the tenth one 
                highScores+= "\n#" + (i + 1) + "Name: " + saves[i].getName() + "\tScore: " + saves[i].getScore();
            }
        }
        textA.setText(highScores); //set textArea to the highScores String
        
        //setting up JFrame 
        pack(); //helps to size contents to pref sizes
        setTitle("Leaderboard");
        setBackground(Color.WHITE);
        setSize(960, 640); //same dimensions
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null); //center jframe with other windows
        
    }
    @Override
    public  void actionPerformed(ActionEvent e) {
        if(e.getSource() == homeBtn){
            menu.setVisible(true);
            remove(this);
            this.dispose();
        }
        if(e.getSource() == searchBtn){
            int targetIndex = linearSearchNames(saves);
            if (targetIndex == -1){
                textA.setText("Username not found!");
            } else {
                textA.setText(saves[targetIndex].getName() + "best score yet is: " + saves[targetIndex].getScore());
            }
        }
    }

    private void writeToFile(SavedData [] saves, int level) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private int linearSearchNames(SavedData[] saves) {
        //ask for the userName
        String userName = JOptionPane.showInputDialog("Enter the username you are looking for: ");
        //loop through lenght of array, searching for the name
        for (int i = 0; i < saves.length - 1; i++) {
            //if the userName is found 
            if(saves[i].getName().equalsIgnoreCase(userName)){
                return 1; 
            }
        }
        return -1; //if the userName was not found
        
    }

    private void quickSort(SavedData[] saves, int leftIndex, int rightIndex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
