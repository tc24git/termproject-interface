import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class SearchInterface {
    private JFrame frame;
    private JTextField searchField;
    private JTextArea resultsArea;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SearchInterface().createGUI());
    }

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

    private void handleSearch(String query) {
        if (query.startsWith("-text")) {
            frame.dispose(); // Close the Graphic Interface
            runCommandLineMode(); // switch to text inteface
        } else {
            // simulate search results in GUI
            resultsArea.setText("Searching for: " + query + "\nResults:\n1. Result A\n2. Result B");
        }
    }

    private void runCommandLineMode() {
        System.out.println("Now in text Mode");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(">> ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit")) {
                System.out.println("Exiting text mode.");
                break;
            }
            // Simulate a search result
            System.out.println("Results for: " + input);
            System.out.println("1. Console Result A");
            System.out.println("2. Console Result B");
        }
        scanner.close();
    }
}
