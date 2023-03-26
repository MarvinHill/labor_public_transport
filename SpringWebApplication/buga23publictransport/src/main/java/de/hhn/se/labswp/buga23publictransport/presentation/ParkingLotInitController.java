package de.hhn.se.labswp.buga23publictransport.presentation;

import de.hhn.se.labswp.buga23publictransport.persistence.ParkingLot;
import de.hhn.se.labswp.buga23publictransport.persistence.ParkingLotRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/parking")
public class ParkingLotInitController {

    ParkingLotRepository p1Repo;

    ParkingLotInitController(ParkingLotRepository repo) {
        this.p1Repo = repo;
    }

    // Über Iterator klappt die Ausgabe nicht. Endet iwi in rekursiver endlosschleife (lt. terminal), außer Polygon is null, dann klappt's, wenn Polygon ein wert hat dann nicht
//    @GetMapping("/all")
//    Iterable<ParkingLot> all() {
//        p1Repo.findAll();
//    }

    public String einzelParkplatz(String name) {
        ArrayList<ParkingLot> parkList = (ArrayList<ParkingLot>) p1Repo.findAll();
        ParkingLot parking;
        for(int i = 0; i < parkList.size(); i++) {
            if(parkList.get(i).getName().equals(name)){
                parking = parkList.get(i);
                return "area: " + parking.getArea() + ", longtitude: " + parking.getLongtitude() + ", latitude: " + parking.getLatitude() + ", name: " + parking.getName() +
                        ", barrierfree: " + parking.getBarrierfree() + ", accessRight: " + parking.getAccessRight() + ", charging: " + parking.getCharging() +
                        ", parkingStatus: " + parking.getParkingStatus() + ", parkingType: " + parking.getParkingType();
            }
        }
        return "nicht vorhanden";
    }

    @GetMapping("/all")
    ArrayList<String> all() {
        ArrayList<ParkingLot> parkList = (ArrayList<ParkingLot>) p1Repo.findAll();
        ArrayList<String> stringList = new ArrayList<>();

        for(int i = 0; i < parkList.size(); i++) {
            ParkingLot parking = parkList.get(i);
            String parkingString = "area: " + parking.getArea() + ", longtitude: " + parking.getLongtitude() + ", latitude: " + parking.getLatitude() + ", name: " + parking.getName() +
                    ", barrierfree: " + parking.getBarrierfree() + ", accessRight: " + parking.getAccessRight() + ", charging: " + parking.getCharging() +
                    ", parkingStatus: " + parking.getParkingStatus() + ", parkingType: " + parking.getParkingType();
            stringList.add(parkingString);
        }
        return stringList;
    }

    @GetMapping("/c1-hauptverwaltung-mpb")
    public String c1() {
        return einzelParkplatz("C1 Hauptverwaltung MPB, Parkhaus");
    }

    @GetMapping("/collini-center-mulde")
    public String collini_center() {
        return einzelParkplatz("Collini-Center Mulde, Parkplatz");
    }

    @GetMapping("/d3")
    public String d3() {
        return einzelParkplatz("D3, Tiefgarage");
    }

    @GetMapping("/d5-reiß-museum")
    public String d5_reiss_museum() {
        return einzelParkplatz("D5 Reiß-Museum, Tiefgarage");
    }

    @GetMapping("/g1-marktplatz")
    public String g1() {
        return einzelParkplatz("G1 Marktplatz, Tiefgarage");
    }

    @GetMapping("/h6")
    public String h6() {
        return einzelParkplatz("H6, Tiefgarage");
    }

    @GetMapping("/hauptbahnhof-p1")
    public String hbf_p1() {
        return einzelParkplatz("Hauptbahnhof P1 , Tiefgarage");
    }

    @GetMapping("/hauptbahnhof-p2")
    public String hbf_p2() {
        return einzelParkplatz("Hauptbahnhof P2, Parkhaus");
    }

    @GetMapping("/hauptbahnhof-p3")
    public String hbf_p3() {
        return einzelParkplatz("Hauptbahnhof P3, Parkhaus");
    }

    @GetMapping("/hauptbahnhof-p5")
    public String hbf_p5() {
        return einzelParkplatz("Hauptbahnhof P5, Parkhaus");
    }

    @GetMapping("/klinikum")
    public String klinikum() {
        return einzelParkplatz("Klinikum, Tiefgarage");
    }

    @GetMapping("/kunsthalle")
    public String kunsthalle() {
        return einzelParkplatz("Kunsthalle, Tiefgarage");
    }

    @GetMapping("/klinikum-p3")
    public String klinikum_p3() {
        return einzelParkplatz("Klinikum P3, Parkplatz");
    }

    @GetMapping("m4a")
    public String m4a() {
        return einzelParkplatz("M4a, Parkplatz");
    }

    @GetMapping("/n1")
    public String n1() {
        return einzelParkplatz("N1, Parkhaus");
    }

    @GetMapping("/n2-stadthaus")
    public String n1_n2() {
        return einzelParkplatz("N2 Stadthaus, Parkhaus");
    }

    @GetMapping("/n6-komforthaus")
    public String n6_komforthaus() {
        return einzelParkplatz("N6 Komforthaus, Parkhaus");
    }

    @GetMapping("/n6-standardhaus")
    public String n6_standardhaus() {
        return einzelParkplatz("N6 Standardhaus, Parkhaus");
    }

    @GetMapping("/u2")
    public String u2() {
        return einzelParkplatz("U2, Tiefgarage");
    }

    @GetMapping("/sap-arena-p1")
    public String sap_arena_p1() {
        return einzelParkplatz("SAP Arena P1, Parkhaus");
    }

    @GetMapping("/sap-arena-p2")
    public String sap_arena_p2() {
        return einzelParkplatz("SAP Arena P2, Parkhaus");
    }

    @GetMapping("/sap-arena-p3")
    public String sap_arena_p3() {
        return einzelParkplatz("SAP Arena P3, Parkhaus");
    }

    @GetMapping("/sap-arena-p6-p8")
    public String sap_arena_p() {
        return einzelParkplatz("SAP Arena P6-P8, Parkplatz");
    }

}
