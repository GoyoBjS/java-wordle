import javax.swing.JLabel;
import java.awt.Font;

public class Title extends JLabel {
    Title(){
        this.setText("Wardle");
        this.setVerticalAlignment(JLabel.TOP);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setFont(new Font("Arial", Font.BOLD, 36));
        this.setBounds(50,50,300,100);
        principal.frame.add(this);
    }
}
