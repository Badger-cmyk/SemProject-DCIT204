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
//    private final JButton landMarkButton;

    UI(){
        this.setTitle("Finding Possible Paths To Your Destination");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1300, 550);
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.lightGray);

        JLabel currentLocation = new JLabel();
        currentLocation.setText("Choose your location...");
        currentLocation.setFont(new Font("Serif", Font.BOLD, 20));
        currentLocation.setBounds(100, 50, 200, 40);
        this.add(currentLocation);

//        JLabel landMarkLocation = new JLabel();
//        landMarkLocation.setText("Or use a landmark instead?...");
//        landMarkLocation.setFont(new Font("Serif", Font.BOLD, 20));
//        landMarkLocation.setBounds(100, 300, 250, 40);
//        this.add(landMarkLocation);

        JLabel destinationLocation = new JLabel();
        destinationLocation.setText("Select destination...");
        destinationLocation.setFont(new Font("Serif", Font.BOLD, 20));
        destinationLocation.setBounds(100, 150, 200, 40);
        this.add(destinationLocation);

        String[] locations = {
                "Main Gate", "UG Fire Service", "JQB", "N Block", "UGCS", "Balme Library",
                "New N Block", "Department of Computer Science", "School of Law", "UGBS",
                "Great Hall", "Pent Hall", "Volta Hall", "Akuafo Hall", "Legon Hall",
                "Commonwealth Hall", "Athletic Oval", "Diaspora Halls", "Night Market"
        };

        source = new JComboBox<>(locations);
        source.setBounds(550, 50, 200, 30);
        this.add(source);

        destination = new JComboBox<>(locations);
        destination.setBounds(550, 150, 200, 30);
        this.add(destination);

        JLabel information = new JLabel();
        information.setText(("Shortest Path:"));
        information.setBounds(100, 400, 250, 40);
        information.setFont(new Font("Serif", Font.BOLD, 20));
        this.add(information);

        shortestPathDisplay = new JLabel();
        shortestPathDisplay.setBounds(300, 400, 900, 40);
        shortestPathDisplay.setBorder(new DefinedBorder(10));
        shortestPathDisplay.setFont(new Font("Serif", Font.BOLD, 15));
        this.add(shortestPathDisplay);

        distanceDisplay = new JLabel();
//        distanceDisplay.setBounds(300, 400, 400, 40);
        distanceDisplay.setBounds(250, 450, 400, 40);
        distanceDisplay.setFont(new Font("Serif", Font.BOLD, 20));
        this.add(distanceDisplay);

        JButton getPossiblePaths = new JButton("Get possible paths to your destination");
        getPossiblePaths.setBounds(580, 230, 130, 25);
        getPossiblePaths.setBorder(new DefinedBorder(10));
        getPossiblePaths.setFocusable(false);

//        landMarkButton = new JButton("Use landmark(s)");
//        landMarkButton.setBounds(580, 300, 130, 25);
//        landMarkButton.setFocusable(false);
//        landMarkButton.setBorder(new DefinedBorder(10));

        this.add(getPossiblePaths);
//        this.add(landMarkButton);
        this.setVisible(true);

        getPossiblePaths.addActionListener(this::getPath);
//        landMarkButton.addActionListener(this::landMarkPath);

    }

//    private void landMarkPath(ActionEvent actionEvent) {
//        if(actionEvent.getSource() == landMarkButton){
//            this.dispose();
//            new LandMark();
//        }
//    }

    private void getPath(ActionEvent actionEvent) {
        try{
            String origin = source.getSelectedItem().toString();
            String end = destination.getSelectedItem().toString();

            Locations sourceDijkstra = graph.getNodeByName(origin);
            Locations destinationDijkstra = graph.getNodeByName(end);

            Dijkstra.findShortestPath(graph, sourceDijkstra, destinationDijkstra);
            String path = Dijkstra.getShortestPath(sourceDijkstra, destinationDijkstra);
            shortestPathDisplay.setText(path);

            distanceDisplay.setText("Approximate Distance is " + Dijkstra.getTotalDistance(destinationDijkstra) + "km");
        }
        catch(NullPointerException exception){
            System.out.println(exception.getMessage());
            distanceDisplay.setText("Try another destination or location");
        }
    }

}
