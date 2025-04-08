import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;

public class GraphicInterface implements Runnable, ActionListener, ItemListener, ChangeListener{


        

        public static String[] books = {"book1","book2","book3"};
        
        private JTextArea searchStatus;
        private JTextField searchBar;
        

        @Override
        public void run() {

            JFrame.setDefaultLookAndFeelDecorated(true);

            JFrame frame = new JFrame("GraphicInterface");

            frame.setPreferredSize(new Dimension(800,425));

            JPanel framePanel = new JPanel();

            frame.add(framePanel);


            frame.pack();
            frame.setVisible(true);


        }

        @Override
        public void stateChanged(ChangeEvent e) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'stateChanged'");
        }

        public static void main(String args[]){
            javax.swing.SwingUtilities.invokeLater(new GraphicInterface());
        }




}