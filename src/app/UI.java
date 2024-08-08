package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import static app.Main.graph;

public class UI extends JFrame {

    private final JComboBox<String> source;
    private final JComboBox<String> destination;
    private final JLabel shortestPathDisplay;
    private final JLabel distanceDisplay;
    private final JButton landMarkButton;

    UI(){
        this.setTitle("Finding Possible Paths To Your Destination");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 1000);  //try this to check and edit later
        this.setLayout(null);
        this.setResizable(true);
        this.getContentPane().setBackground(Color.gray);

        JLabel currentLocation = new JLabel();
        currentLocation.setText("Where are you at right now? Choose your current location...");
        currentLocation.setFont(new Font("Serif", Font.BOLD, 15));
        currentLocation.setBounds(100, 80, 150, 150);
        this.add(currentLocation);

        JLabel landMarkLocation = new JLabel();
        landMarkLocation.setText("Or use a landmark instead?...");
        landMarkLocation.setFont(new Font("Serif", Font.BOLD, 15));
        landMarkLocation.setBounds(100, 200, 250, 150);
        this.add(landMarkLocation);

        JLabel destinationLocation = new JLabel();
        destinationLocation.setText("Where are you going? Select your destination...");
        destinationLocation.setFont(new Font("Serif", Font.BOLD, 15));
        destinationLocation.setBounds(100, 200, 250, 150);
        this.add(destinationLocation);

        String[] locations = {
                "Main Gate", "UG Fire Service", "JQB", "N Block", "UGCS", "Balme Library",
                "New N Block", "Department of Computer Science", "School of Law", "UGBS",
                "Great Hall", "Pent Hall", "Volta Hall", "Akuafo Hall", "Legon Hall",
                "Commonwealth Hall", "Athletic Oval", "Diaspora Halls", "Night Market"
        };

        source = new JComboBox<>(locations);
        source.setBounds(450, 50, 200, 50);
        this.add(source);

        destination = new JComboBox<>(locations);
        destination.setBounds(450, 50, 200, 50);
        this.add(destination);

        JLabel data = new JLabel();
        data.setText(("Shortest Path:"));
        data.setFont(new Font("Serif", Font.BOLD, 15));
        data.setBounds(100, 300, 150, 80);
        this.add(data);

        shortestPathDisplay = new JLabel();
        shortestPathDisplay.setBounds(300, 400, 900, 40);
        shortestPathDisplay.setBorder(new DefinedBorder(10));
        shortestPathDisplay.setFont(new Font("Serif", Font.BOLD, 15));
        this.add(shortestPathDisplay);

        distanceDisplay = new JLabel();
        distanceDisplay.setBounds(300, 400, 400, 40);
        distanceDisplay.setFont(new Font("Serif", Font.BOLD, 15));
        this.add(distanceDisplay);

        JButton getPossiblePaths = new JButton("Get possible paths to your destination");
        getPossiblePaths.setBounds(580, 230, 130, 25);
        getPossiblePaths.setBorder(new DefinedBorder(10));
        getPossiblePaths.setFocusable(false);

        landMarkButton = new JButton("Click to get landmark(s)");
        landMarkButton.setBounds(450, 300, 120, 25);
        landMarkButton.setFocusable(false);
        landMarkButton.setBorder(new DefinedBorder(10));

        this.add(getPossiblePaths);
        this.add(landMarkButton);
        this.setVisible(true);

        getPossiblePaths.addActionListener(this::getPath);
        landMarkButton.addActionListener(this::landMarkPath);

    }

    private void landMarkPath(ActionEvent actionEvent) {
        if(actionEvent.getSource() == landMarkButton){
            this.dispose();
            new LandMark();
        }
    }

    private void getPath(ActionEvent actionEvent) {
        try{
            String origin = source.getSelectedItem().toString();
            String end = destination.getSelectedItem().toString();

            Locations sourceDijkstra = graph.getNodeByName(origin);
            Locations destinationDijkstra = graph.getNodeByName(end);

            Dijkstra.findShortestPath(graph, sourceDijkstra, destinationDijkstra);
            String path = Dijkstra.getShortestPath(sourceDijkstra, destinationDijkstra);
            shortestPathDisplay.setText(path);

            distanceDisplay.setText("Approximate Distance: " + Dijkstra.getTotalDistance(destinationDijkstra) + "km");
        }
        catch(NullPointerException exception){
            System.out.println(exception.getMessage());
        }
    }

}
