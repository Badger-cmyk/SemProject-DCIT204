package app;

public class Main {
    public static Map graph = new Map();

    public static void main(String[] args) {

        Locations mainGate = new Locations("Main Gate");
        Locations UGFireService = new Locations("UG Fire Service");
        Locations JonesQuarteyBuilding = new Locations("Jones Quartey Building(JQB)");
        Locations newBlock = new Locations("N Block");
        Locations ugcs = new Locations("UGCS");
        Locations balmeLibrary = new Locations("Balme Library");
        Locations newNBlock = new Locations("NNB");
        Locations CSDepartment = new Locations("Department of Computer Science");
        Locations lawSchool = new Locations("School of Law");
        Locations businessSchool = new Locations("UGBS");
        Locations greatHall = new Locations("Great Hall");
        Locations pentHall = new Locations("Pent Hall");
        Locations voltaHall = new Locations("Volta Hall");
        Locations akuafoHall = new Locations("Akuafo Hall");
        Locations legonHall = new Locations("Legon Hall");
        Locations commonWealthHall = new Locations("Commonwealth Hall");
        Locations athleticOval = new Locations("Athletic Oval");
        Locations diaspora = new Locations("Diaspora Halls(Limann, Kwapong, etc.)");
        Locations nightMarket = new Locations("Night Market");


        System.out.println("Is this working?");

        graph.addVertex(mainGate);
        graph.addVertex(UGFireService);
        graph.addVertex(JonesQuarteyBuilding);
        graph.addVertex(newBlock);
        graph.addVertex(ugcs);
        graph.addVertex(balmeLibrary);
        graph.addVertex(newNBlock);
        graph.addVertex(CSDepartment);
        graph.addVertex(lawSchool);
        graph.addVertex(businessSchool);
        graph.addVertex(greatHall);
        graph.addVertex(pentHall);
        graph.addVertex(voltaHall);
        graph.addVertex(akuafoHall);
        graph.addVertex(legonHall);
        graph.addVertex(commonWealthHall);
        graph.addVertex(athleticOval);
        graph.addVertex(diaspora);
        graph.addVertex(nightMarket);
    }
}