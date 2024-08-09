package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static app.Main.graph;

public class LandMark extends JFrame {

    private final JButton backButton;
    private final JComboBox<String> source;
    private final JComboBox<String> landmark;
    private final JComboBox<String> destination;
    private final JLabel firstHalfPath;
    private final JLabel secondHalfPath;
    private final JLabel distanceDisplay;

    LandMark(){
        backButton = new JButton();
        backButton.setText("Back");
        backButton.setBounds(0,0,100,30);
        backButton.setFocusable(false);
        backButton.setBorder(new DefinedBorder(10));
        backButton.addActionListener(this::landingPage);
        this.add(backButton);

        JLabel currentLocation = new JLabel();
        currentLocation.setText("Select your location...");
        currentLocation.setBounds(100, 50, 200, 40);
        currentLocation.setFont(new Font("Serif", Font.BOLD, 20));
        this.add(currentLocation);

        JLabel landMarkLocation = new JLabel();
        landMarkLocation.setText("Choose landmark...");
        landMarkLocation.setBounds(100, 150, 250, 40);
        landMarkLocation.setFont(new Font("Serif", Font.BOLD, 20));
        this.add(landMarkLocation);

        JLabel destinationLocation = new JLabel();
        destinationLocation.setText("Choose destination...");
        destinationLocation.setBounds(100, 250, 200, 40);
        destinationLocation.setFont(new Font("Serif", Font.BOLD, 20));
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
        destination.setBounds(550, 250, 200, 30);
        this.add(destination);

        landmark = new JComboBox<>(locations);
        landmark.setBounds(550,150,200,30);
        this.add(landmark);

        JLabel initialPath = new JLabel();
        initialPath.setText("Initial path: ");
        initialPath.setBounds(100, 400, 250, 40);
        initialPath.setFont(new Font("Serif",Font.BOLD, 20));
        this.add(initialPath);

        JLabel secondPath = new JLabel();
        secondPath.setText("Final path: ");
        secondPath.setBounds(100, 500, 250, 40);
        secondPath.setFont(new Font("Serif",Font.BOLD, 20));
        this.add(secondPath);

        firstHalfPath = new JLabel();
        firstHalfPath.setBounds(300, 400, 800, 40);
        firstHalfPath.setBorder(new DefinedBorder(10));
        firstHalfPath.setFont(new Font("Serif",Font.BOLD, 20));
        this.add(firstHalfPath);

        secondHalfPath = new JLabel();
        secondHalfPath.setBounds(300, 500, 800, 40);
        secondHalfPath.setBorder(new DefinedBorder(10));
        secondHalfPath.setFont(new Font("Serif",Font.BOLD, 20));
        this.add(secondHalfPath);

        distanceDisplay = new JLabel();
        distanceDisplay.setBounds(250, 600, 400, 40);
        distanceDisplay.setFont(new Font("Serif", Font.BOLD, 20));
        this.add(distanceDisplay);

        JButton getPossiblePaths = new JButton("Get possible paths");
        getPossiblePaths.setBounds(580, 350, 130, 25);
        getPossiblePaths.setBorder(new DefinedBorder(10));
        getPossiblePaths.setFocusable(false);
        this.add(getPossiblePaths);

        getPossiblePaths.addActionListener(this::getPaths);

        this.setLayout(null);
        this.setSize(1300,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.GRAY);
        this.setTitle("Possible Routes Based On Landmark");
        this.setVisible(true);

    }

    private void getPaths(ActionEvent actionEvent) {
        try{
            String origin = source.getSelectedItem().toString();
            String theLandMark = landmark.getSelectedItem().toString();
            String end = destination.getSelectedItem().toString();

            Locations sourceDijkstra = graph.getNodeByName(origin);
            Locations landMarkDijkstra = graph.getNodeByName(theLandMark);
            Locations destinationDijkstra = graph.getNodeByName(end);

            Dijkstra.findShortestPath(graph, sourceDijkstra, landMarkDijkstra);
            String firstPath = Dijkstra.getShortestPath(sourceDijkstra, landMarkDijkstra);
            float firstPathDistance = Dijkstra.getTotalDistance(landMarkDijkstra);

            Dijkstra.findShortestPath(graph, landMarkDijkstra, destinationDijkstra);
            String secondPath = Dijkstra.getShortestPath(landMarkDijkstra, destinationDijkstra);
            float secondPathDistance = Dijkstra.getTotalDistance(destinationDijkstra);

            float totalPathDistance = firstPathDistance + secondPathDistance;


            firstHalfPath.setText(firstPath);
            secondHalfPath.setText(secondPath);

            distanceDisplay.setText("Approximate distance: " + totalDistance(totalPathDistance) + "km");

        }
        catch(NullPointerException exception){
            System.out.println(exception.getMessage());
        }
    }

    private String totalDistance(float totalPathDistance) {
        return String.format("%.3f", totalPathDistance);
    }

    private void landingPage(ActionEvent actionEvent) {
        if(actionEvent.getSource() == backButton){
            this.dispose();
            new UI();
        }
    }


}
