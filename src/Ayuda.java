import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class Ayuda extends JLabel{
   
    Ayuda(){
            this.setBackground(Color.BLACK);
            this.setHorizontalAlignment(JLabel.CENTER);
            this.setForeground(Color.BLACK);
            this.setFont(new Font("Arial", Font.BOLD, 36));
            this.setOpaque(true);//para que no se vea el fondo
            this.addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    if(principal.ayudaCounter < 1){
                        e.getComponent().setBackground(Color.GREEN);
                        principal.ayudaCounter = 1;
                    }
                }

                @Override
                public void mousePressed(java.awt.event.MouseEvent e) {
                    // TODO Auto-generated method stub
                    
                }

                @Override
                public void mouseReleased(java.awt.event.MouseEvent e) {
                    // TODO Auto-generated method stub
                    
                }

                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {
                    // TODO Auto-generated method stub
                    
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                    // TODO Auto-generated method stub
                    
                }
            });
    }
}
