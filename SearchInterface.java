import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class SearchInterface {
    private JFrame frame;
    private JTextField searchField;
    private JTextArea resultsArea;

    public static void main(String[] args) {
        // Decide mode BEFORE launching GUI
        if (args.length > 0 && args[0].equalsIgnoreCase("-text")) {
            //run at the command line
            new SearchInterface().runCommandLineMode();
        } else {
            // Run in graphics mode
            SwingUtilities.invokeLater(() -> new SearchInterface().createGUI());
        }
    }

    //dumb swing shit to make the graphic interface
    private void createGUI() {
        frame = new JFrame("Search Interface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        searchField = new JTextField();
        resultsArea = new JTextArea();
        resultsArea.setEditable(false);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> handleSearch(searchField.getText()));

        frame.setLayout(new BorderLayout());
        frame.add(searchField, BorderLayout.NORTH);
        frame.add(new JScrollPane(resultsArea), BorderLayout.CENTER);
        frame.add(searchButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    //fancy mumbo jumbo to mimic searching 
    private void handleSearch(String query) {
        resultsArea.setText("Searching for: " + query + "\nResults:\n1. Result A\n2. Result B");
    }



    //code for the command line to work. took me 3 hours
    private void runCommandLineMode() {
        System.out.println("Now at Command Line");
        Scanner scnr = new Scanner(System.in);
        while (true) {
            System.out.print("Search: ");
            String input = scnr.nextLine().trim();
            if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit")) {
                System.out.println("Exiting command line mode");
                break;
            }
            //more fake search stuff
            System.out.println("Results for: " + input);
            System.out.println("1. Console Result A");
            System.out.println("2. Console Result B");
        }
        //omg i closed the scanner just shut upppp
        scnr.close();
    }
}
