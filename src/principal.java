import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class principal {
    static gestionFichero gf = new gestionFichero("diccionarioCompleto.txt");
    static ArrayList<String> todasPalabras = new ArrayList<>();
    public static ArrayList<String> misChar = new ArrayList<String>();
    public static String[] keys = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    public static ArrayList<String>letra = new ArrayList<String>();
    public static List<String> keysList = new ArrayList<>(Arrays.asList(keys));
    public static String word = generateRandom();
    public static int posicionCol, posicionRow, ayudaCounter, keyIndex = 0;
    public static boolean win = false;
    public static JLabel[][] wordleCasilla = new JLabel[5][6];
    public static JLabel[] label = new JLabel[5];
    public static JLabel[] keyCasilla = new JLabel[27];
    public static JLabel name = new JLabel();
    public static JFrame frame = new JFrame();
    Ayuda ayuda = new Ayuda();

    public static String generateRandom(){
        todasPalabras = gf.leer();
        String palabra = gf.generar_palabra(todasPalabras).toUpperCase();
        System.out.println(palabra);
        return palabra;
    }

    public static void resetGame(){
        word = generateRandom();
        String[] ary = word.split("");

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                for(int i = 0; i < 5; i++) {
                    for(int j = 0; j < 6; j++) {
                        wordleCasilla[i][j].setText("");
                        wordleCasilla[i][j].setBackground(new Color(0xA5A5A5));
                    }
                }
                for(int k = 0; k < 26; k++) {
                    keyCasilla[k].setBackground(new Color(0xA5A5A5));
                }
               
                for(int l = 0; l < 5; l++) {
                    label[l].setBackground(Color.black);
                    label[l].setText("");
                    label[l].setText(ary[l]);
                }
            }
        }, 500);
        letra.clear();
        posicionRow = 0;
        posicionCol = 0;
        ayudaCounter = 0;
    }

    public static void resetLine(){
        for(int i = 0; i < 5; i++) {
            // wordleCasilla[i][posicionRow].setBackground(new Color(0xA5A5A5));
            wordleCasilla[i][posicionRow].setText("");
        }
        posicionCol = 0;
    }

    public static int countOccurrences(String str, String letter) {
        String[] word = str.split("");
        int occurences = 0;
        for(String lett : word){
            if(lett.equalsIgnoreCase(letter)){
                occurences++;
            }
        }
    return occurences;
    }

    // funciona
    public static boolean nextLine(String str){
        String answerWord = "";
        int accLetrasAcertadas = 0;
        String word1 = word;
        String[] caracteres = word.split("");
        System.out.println(word1);
                for(int i = 0; i < 5; i++){
                    answerWord += str.charAt(i);
                    keyIndex = Collections.binarySearch(keysList, misChar.get(i));
                        if(keyIndex>=0){
                            if(word1.contains(misChar.get(i))){
                                if(misChar.get(i).equals(caracteres[i])){
                                    word1 = word1.replaceFirst(caracteres[i], "");
                                    wordleCasilla[i][posicionRow].setBackground(Color.GREEN);
                                    keyCasilla[keyIndex].setBackground(Color.GREEN);
                                    // letra.add(keyCasilla[keyIndex].getText());
                                    accLetrasAcertadas++;
                                    int index = answerWord.indexOf(misChar.get(i));
                                    if (index != -1) {
                                        answerWord = answerWord.replaceFirst(misChar.get(i), "");
                                    }
                                }
                                else{
                                    if(countOccurrences(answerWord, misChar.get(i)) <= countOccurrences(word1, misChar.get(i))){
                                        wordleCasilla[i][posicionRow].setBackground(new Color(0xE4C000));
                                        keyCasilla[keyIndex].setBackground(new Color(0xE4C000));
                                    }else{
                                        wordleCasilla[i][posicionRow].setBackground(new Color(0x333333));
                                        keyCasilla[keyIndex].setBackground(new Color(0x333333));
                                    }
                                    if(!letra.contains(keyCasilla[keyIndex].getText())){
                                        keyCasilla[keyIndex].setBackground(new Color(0xE4C000));
                                    }
                                }
                               
                            }else{
                                wordleCasilla[i][posicionRow].setBackground(new Color(0x333333));
                                if(!letra.contains(keyCasilla[keyIndex].getText())){
                                    keyCasilla[keyIndex].setBackground(new Color(0x333333));
                                    
                                }
                            }
                        }
                    if(accLetrasAcertadas == 5){
                        win = true;
                        JOptionPane.showMessageDialog(null, "Ganaste");
                        misChar.clear();
                        ayudaCounter = 0;
                        letra.clear();
                        resetGame();
                        return true;
                    }
                }
                posicionCol = 0;
                posicionRow++;
                misChar.clear();
                return false;
    }

}
