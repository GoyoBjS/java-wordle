import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class Wordle extends JFrame{
    gestionFichero gf = new gestionFichero("EJM.txt");
    static ArrayList<String> misChar = principal.misChar;
    static String[] keys = principal.keys;
    static List<String> keysList =principal.keysList;
    public String teclaPulsada;
    static boolean win = false;
    static JLabel[][] wordleCasilla = principal.wordleCasilla;
    static JLabel[] label = principal.label;
    static JLabel[] keyCasilla = principal.keyCasilla;
    static Ayuda ayuda = new Ayuda();
    ArrayList<String> todasPalabras = gf.leer();
    Wordle(){
        
        principal.frame.setTitle("Wardle");
        principal.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.frame.setResizable(false);
        principal.frame.setSize(650,1000);
        principal.frame.setLayout(null);
        principal.frame.addKeyListener(test);
        
        createWordlePanel();
        name();
        totalPoints();
        idioma();
        currentPoints();
        keyboard();
        principal.frame.setVisible(true);
        ayuda();
        
        
    }
    KeyListener test = new KeyListener(){
        public void keyPressed(KeyEvent e){
            
            String teclaPulsada = KeyEvent.getKeyText(e.getKeyCode());
            System.out.println(teclaPulsada);
            if(keysList.contains(teclaPulsada) || teclaPulsada.equals("Desconocido keyCode: 0x0")){
                if(teclaPulsada.equals("Desconocido keyCode: 0x0")) teclaPulsada = "Ñ";
                misChar.add(teclaPulsada);
                wordleCasilla[principal.posicionCol][principal.posicionRow].setText(teclaPulsada);
                principal.posicionCol++;
            }
            if(principal.posicionCol > 4){
                String str = "";
                for (String chart : misChar) {
                    str += chart;
                }
                System.out.println("Palabra: " + str);
                System.out.println(todasPalabras.contains(str.toString().toLowerCase()));
                // if(todasPalabras.contains(str.toString().toLowerCase())){
                    principal.nextLine(str);
                // }else{
                //     // Reset line
                //     misChar.clear();
                //     JOptionPane.showMessageDialog(null, "La palabra no se encuentra en el diccionario");
                //     principal.resetLine();
                // }
            }
            if(principal.posicionRow > 5){
                // principal.word = principal.generateRandom();
                principal.resetGame();
            }
        }
        public void keyReleased(KeyEvent e){
            // teclaPulsada = e.getKeyChar();
        }
        public void keyTyped(KeyEvent e){
            // teclaPulsada = e.getKeyChar();
        }
    };

    public static void createWordlePanel(){
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 6; j++) {
            wordleCasilla[i][j] = new JLabel();
            wordleCasilla[i][j].setBounds(70*i + (130+(i*5)), 70*j +(260+(j*5)), 70, 70);
            wordleCasilla[i][j].setBackground(new Color(0xA5A5A5));
            wordleCasilla[i][j].setHorizontalAlignment(JLabel.CENTER);
            wordleCasilla[i][j].setForeground(Color.BLACK);
            wordleCasilla[i][j].setFont(new Font("Arial", Font.BOLD, 36));
            wordleCasilla[i][j].setOpaque(true);
            if(misChar.size()>0){
                wordleCasilla[i][j].setText(misChar.get(i));
                }
            principal.frame.add(wordleCasilla[i][j]);
            }
        }
    }
    public static void ayuda(){
        String[] caracteres = principal.word.split("");
        
        
        for(int i = 0; i< 5; i++){
            System.out.println("Dentro de Ayuda: " + caracteres[i]);
            label[i] = new Ayuda();
            label[i].setText(caracteres[i]);
            label[i].setBounds(70*i + (130+(i*5)), 157, 70, 70);
            principal.frame.add(label[i]);
        }
    }
    
    public static void keyboard(){
        for(int i = 0; i < 10; i++) {
            keyCasilla[i] = new JLabel();
            keyCasilla[i].setBounds(50*i + (50+(i*3)), 750, 50, 60);
            keyCasilla[i].setBackground(Color.GRAY);
            keyCasilla[i].setText(keys[i]);
            keyCasilla[i].setHorizontalAlignment(JLabel.CENTER);
            keyCasilla[i].setForeground(Color.WHITE);
            keyCasilla[i].setFont(new Font("Arial", Font.BOLD, 36));
            keyCasilla[i].setOpaque(true);
            principal.frame.add(keyCasilla[i]);
        }
        for(int i = 10; i < 20; i++) {
            keyCasilla[i] = new JLabel();
            keyCasilla[i].setBounds(50*(i-10) + (50+((i-10)*3)), 813, 50, 60);
            keyCasilla[i].setBackground(Color.GRAY);
            keyCasilla[i].setText(keys[i]);
            keyCasilla[i].setHorizontalAlignment(JLabel.CENTER);
            keyCasilla[i].setForeground(Color.WHITE);
            keyCasilla[i].setFont(new Font("Arial", Font.BOLD, 36));
            keyCasilla[i].setOpaque(true);
            principal.frame.add(keyCasilla[i]);
        }
        for(int i = 20; i < 26; i++) {
            keyCasilla[i] = new JLabel();
            keyCasilla[i].setBounds(50*(i-20) + (140+((i-20)*3)), 876, 50, 60);
            keyCasilla[i].setBackground(Color.GRAY);
            keyCasilla[i].setText(keys[i]);
            keyCasilla[i].setHorizontalAlignment(JLabel.CENTER);
            keyCasilla[i].setForeground(Color.WHITE);
            keyCasilla[i].setFont(new Font("Arial", Font.BOLD, 36));
            keyCasilla[i].setOpaque(true);
            principal.frame.add(keyCasilla[i]);
        }
        
    }
    public static void name(){
        JLabel name = new JLabel();
        name.setBounds(0, 20, 200, 50);
        name.setBackground(Color.GRAY);
        name.setText("Pablito");
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setForeground(Color.BLACK);
        name.setFont(new Font("Arial", Font.BOLD, 36));
        principal.frame.add(name);
    }
    public static void totalPoints(){
        JLabel totalPoints = new JLabel();
        totalPoints.setBounds(0, 60, 200, 50);
        totalPoints.setBackground(Color.GRAY);
        totalPoints.setText("1429");
        totalPoints.setHorizontalAlignment(JLabel.CENTER);
        totalPoints.setForeground(Color.BLACK);
        totalPoints.setFont(new Font("Arial", Font.BOLD, 36));
        principal.frame.add(totalPoints);
    }
    public static void idioma(){
        JLabel idioma = new JLabel();
        idioma.setBounds(530, 20, 100, 50);
        idioma.setBackground(Color.GRAY);
        idioma.setText("ESP");
        idioma.setHorizontalAlignment(JLabel.CENTER);
        idioma.setForeground(Color.BLACK);
        idioma.setFont(new Font("Arial", Font.BOLD, 36));
        principal.frame.add(idioma);
    }
    public static void currentPoints(){
        JLabel currentPoints = new JLabel();
        currentPoints.setBounds(530, 60, 100, 50);
        currentPoints.setBackground(Color.GRAY);
        currentPoints.setText("437");
        currentPoints.setHorizontalAlignment(JLabel.CENTER);
        currentPoints.setForeground(Color.BLACK);
        currentPoints.setFont(new Font("Arial", Font.BOLD, 36));
        principal.frame.add(currentPoints);
    }
    
}
