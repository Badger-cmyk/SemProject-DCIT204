package app;

public class Main {
    public static Map graph = new Map();

    public static void main(String[] args) {

        Locations mainGate = new Locations("Main Gate");
        Locations UGFireService = new Locations("UG Fire Service");
        Locations JQB = new Locations("Jones Quartey Building(JQB)");
        Locations NBlock = new Locations("N Block");
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

        //test entry point.
        System.out.println("Is this working?");

        graph.addVertex(mainGate);
        graph.addVertex(UGFireService);
        graph.addVertex(JQB);
        graph.addVertex(NBlock);
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

        //distances from main gate to...
        graph.addEdge(new Extent(mainGate, JQB, 300));
        graph.addEdge(new Extent(mainGate, UGFireService, 240));
        graph.addEdge(new Extent(mainGate, akuafoHall, 500));

        //distances from Balme Library to...
        graph.addEdge(new Extent(balmeLibrary, akuafoHall, 270));
        graph.addEdge(new Extent(balmeLibrary, legonHall, 500));

        //distances from CSDepartment to...
        graph.addEdge(new Extent(CSDepartment, balmeLibrary, 650));
        graph.addEdge(new Extent(CSDepartment, akuafoHall, 850));
        graph.addEdge(new Extent(CSDepartment, lawSchool, 650));

        //distances from NBlock to...
        graph.addEdge(new Extent(NBlock, CSDepartment, 500));
        graph.addEdge(new Extent(NBlock, balmeLibrary, 600));
        graph.addEdge(new Extent(NBlock, newNBlock, 500));
        graph.addEdge(new Extent(NBlock, businessSchool, 500));
        graph.addEdge(new Extent(NBlock, ugcs, 500));

        //distances from UGFireService to...
        graph.addEdge(new Extent(UGFireService, akuafoHall, 650));

        //distances from UGCS to...
        graph.addEdge(new Extent(ugcs, balmeLibrary, 200));
        graph.addEdge(new Extent(ugcs, voltaHall, 350));

        //distances from great hall to...
        graph.addEdge(new Extent(greatHall, commonWealthHall, 100));

        //distances from volta hall to...
        graph.addEdge(new Extent(voltaHall, businessSchool, 200));
        graph.addEdge(new Extent(voltaHall, commonWealthHall,450));
        graph.addEdge(new Extent(voltaHall, legonHall, 190));

        //distances from business school to...
        graph.addEdge(new Extent(businessSchool, ugcs, 70));

        //distances from legon hall to...
        graph.addEdge(new Extent(legonHall, akuafoHall, 400));
        graph.addEdge(new Extent(legonHall, athleticOval, 450));
        graph.addEdge(new Extent(legonHall, commonWealthHall, 750));

        //distances from JQB to...
        graph.addEdge(new Extent(JQB, akuafoHall, 700));
        graph.addEdge(new Extent(JQB, lawSchool, 350));

        //distances from law school to...
        graph.addEdge(new Extent(lawSchool, pentHall, 900));

        //distances from athletic oval to...
        graph.addEdge(new Extent(athleticOval, akuafoHall, 550));
        graph.addEdge(new Extent(athleticOval, nightMarket, 800));

        //distances from akuafo hall to...
        graph.addEdge(new Extent(akuafoHall, nightMarket, 1000));

        //distances from night market to...
        graph.addEdge(new Extent(nightMarket, diaspora, 850));

    }
}