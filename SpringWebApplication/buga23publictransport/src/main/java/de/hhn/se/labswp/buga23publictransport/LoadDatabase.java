package de.hhn.se.labswp.buga23publictransport;

import de.hhn.se.labswp.buga23publictransport.persistence.*;
import de.hhn.se.labswp.buga23publictransport.rnv.RNVQuery;

import java.io.File;
import java.sql.Array;
import java.time.LocalTime;

import de.hhn.se.labswp.buga23publictransport.util.LineLoader;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(PublicTransportLineRepo lineRepo, LineScheduleEntryRepo entryRepo, StationRepo stationRepo) {
        return args -> {
            log.info("Preloading Database Entries");
            log.info("Preloading stops for public transport lines and shuttles");

            Station hansThomaStrStation = new Station(49.47496, 8.52439, "Hans-Thoma-Str.", 2518);
            Station neuOstHeimStation = new Station(49.4774967, 8.5228445, "Neuostheim", 2522);
            Station luisenParkStation = new Station(49.47887, 8.49640, "Luisenpark", 2429);
            Station spinelliParkStation = new Station(49.49646, 8.52208, "Buga 23 Haupteingang Spinelli-Park", 4046);
            Station sapArenaSBFStation = new Station(49.4598771, 8.5171520, "SAP Arena S-Bf (MA-Arena/Maimarkt)", 3894);
            Station maimarktGrossParkPlatzStation = new Station(49.4685232, 8.5220630, "Maimarkt (P+R Großparkplatz)", 2520);
            Station sapArenaStation = new Station(49.4648353, 8.5204035, "SAP-Arena", 2847);
            Station berlinerPlatzStation = new Station(49.4799380, 8.4507645, "Berliner Platz", 2066);
            Station konradAdenauerBrückeStation = new Station(49.4824621, 8.4586681, "Konrad-Adenauer-Brücke", 2426);
            Station universitätStation = new Station(49.48166, 8.46537, "Universität", 2471);
            Station schlossStation = new Station(49.48489, 8.46354, "Schloss", 2462);
            Station paradePlatzStation = new Station(49.48749, 8.46688, "Paradeplatz", 2451);
            Station marktPlatzStation = new Station(49.48943, 8.46782, "Marktplatz", 2438);
            Station akademieStation = new Station(49.48943, 8.46782, "Abendakademie", 6005); // Todo - check if akademiestraße is the same
            Station gewerkschaftHausStation = new Station(49.4904423, 8.4753833, "Gewerkschafthaus", 2412);
            Station nationalTheaterStation = new Station(49.48765, 8.47819, "Nationaltheater", 2444);
            Station theresenKrankenhausStation = new Station(49.48991, 8.48091, "Theresen-Krankenhaus", 5543);
            Station universitaetsKlinikumStation = new Station(49.49363, 8.48423, "Universitätsklinikum", 5544);
            Station bibienStraßeStation = new Station(49.49464, 8.48861, "Bibienastraße", 2398);
            Station hauptFriedHofStation = new Station(49.49078, 8.49127, "Hauptfriedhof", 2418);
            Station pfeiffersWoerthStation = new Station(49.48948, 8.50141, "Pfeifferswörth", 2464);
            Station neckarPlattStation = new Station(49.48892, 8.51182, "Neckarplatt", 2320);
            Station ziethenStraßeStation = new Station(49.49043, 8.51926, "Ziethenstraße", 2325);
            Station adolfDamaschkeRingStation = new Station(49.49359, 8.52103, "Adolf-Damaschke-Ring", 2311);
            Station talStrasseStation = new Station(49.4953505, 8.5249774, "Talstraße", 2324);
            Station abendAkademieStation = new Station(49.49171, 8.46993, "Abendakademie", 2447);
            Station kunstHalleStation = new Station(49.48309, 8.47335, "Kunsthalle", 5542);
            Station rosenGartenStation = new Station(49.48555, 8.47556, "Rosengarten", 2459);
            Station mannheimHauptBahnHofStation = new Station(49.48011, 8.46997, "MA Hauptbahnhof", 2417);
            Station tattersallStation = new Station(49.48174, 8.47320, "Tattersall", 2466);
            Station werderStrasseStation = new Station(9.48073, 8.47791, "Werderstr.", 2477);
            Station pestalozziSchuleStation = new Station(49.47893, 8.48185, "Pestalozzischule", 2452);
            Station weberStrasseStation = new Station(49.47662, 8.48524, "Weberstraße", 2476);
            Station planetariumStation = new Station(49.47659, 8.48985, "Planetarium", 2453);
            Station carlBenzStadionStation = new Station(49.47782, 8.50181, "Carl-Benz-Stadion", 2523);
            Station harrLachStation = new Station(49.47809, 8.50640, "Harrlach", 2515);
            Station lucasCranachStrasseStation = new Station(49.47842, 8.51274, "Lucas-Cranach-Str.", 2519);
            Station schwindStrasseStation = new Station(49.47834, 8.51856, "Schwindstraße", 2524);
            Station ludwigStrasseStation = new Station(49.4832, 8.4482, "Ludwigstraße", 2089);
            Station ratHausLUStation = new Station(49.48517, 8.44339, "LU Rathaus", 2096);
            Station handelsHafenStation = new Station(49.49179, 8.45373, "Handelshafen", 2416);
            Station rheinStrasseStation = new Station(49.49087, 8.45800, "Rheinstraße", 2458);
            Station ratHausMAStation = new Station(49.48914, 8.46246, "MA Rathaus/rem", 6041);
            Station strohMarktStation = new Station(49.48621, 8.46999, "Strohmarkt", 2465);
            Station wasserTurmStation = new Station(49.48487, 8.47339, "Wasserturm", 2475);


            stationRepo.saveAllAndFlush(List.of(
                            hansThomaStrStation,
                            neuOstHeimStation,
                            luisenParkStation,
                            spinelliParkStation,
                            sapArenaSBFStation,
                            maimarktGrossParkPlatzStation,
                            sapArenaStation,
                            berlinerPlatzStation,
                            konradAdenauerBrückeStation,
                            universitätStation,
                            schlossStation,
                            paradePlatzStation,
                            marktPlatzStation,
                            akademieStation,
                            gewerkschaftHausStation,
                            nationalTheaterStation,
                            theresenKrankenhausStation,
                            universitaetsKlinikumStation,
                            bibienStraßeStation,
                            hauptFriedHofStation,
                            pfeiffersWoerthStation,
                            neckarPlattStation,
                            ziethenStraßeStation,
                            adolfDamaschkeRingStation,
                            talStrasseStation,
                            abendAkademieStation,
                            kunstHalleStation,
                            rosenGartenStation,
                            mannheimHauptBahnHofStation,
                            tattersallStation,
                            werderStrasseStation,
                            pestalozziSchuleStation,
                            weberStrasseStation,
                            planetariumStation,
                            carlBenzStadionStation,
                            harrLachStation,
                            lucasCranachStrasseStation,
                            schwindStrasseStation,
                            ludwigStrasseStation,
                            ratHausLUStation,
                            handelsHafenStation,
                            rheinStrasseStation,
                            ratHausMAStation,
                            strohMarktStation,
                            wasserTurmStation
                    )
            );

            var hansThomaStr = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, hansThomaStrStation);
            entryRepo.save(hansThomaStr);

            var neuOstHeim = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, neuOstHeimStation);
            entryRepo.save(neuOstHeim);

            var luisenPark = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    luisenParkStation);
            entryRepo.save(luisenPark);

            var spinelliPark = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    spinelliParkStation);
            entryRepo.save(spinelliPark);

            var sapArenaSBF = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    sapArenaSBFStation);
            entryRepo.save(sapArenaSBF);

            var maimarktGrossParkPlatz = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    maimarktGrossParkPlatzStation);
            entryRepo.save(maimarktGrossParkPlatz);

            var sapArena = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    sapArenaStation);
            entryRepo.save(sapArena);

            var berlinerPlatz = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    berlinerPlatzStation);
            entryRepo.save(berlinerPlatz);

            var konradAdenauerBrücke = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    konradAdenauerBrückeStation);
            entryRepo.save(konradAdenauerBrücke);

            var universität = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    universitätStation);
            entryRepo.save(universität);

            var schloss = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    schlossStation);
            entryRepo.save(schloss);

            var paradePlatz = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    paradePlatzStation);
            entryRepo.save(paradePlatz);

            var marktPlatz = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    marktPlatzStation);
            entryRepo.save(marktPlatz);

            var akademie = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    akademieStation);
            entryRepo.save(akademie);

            var gewerkschaftHaus = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    gewerkschaftHausStation);
            entryRepo.save(gewerkschaftHaus);

            var nationalTheater = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    nationalTheaterStation);
            entryRepo.save(nationalTheater);

            var theresenKrankenhaus = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    theresenKrankenhausStation);
            entryRepo.save(theresenKrankenhaus);

            var universitaetsKlinikum = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    universitaetsKlinikumStation);
            entryRepo.save(universitaetsKlinikum);

            var bibienStraße = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    bibienStraßeStation);
            entryRepo.save(bibienStraße);

            var hauptFriedHof = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    hauptFriedHofStation);
            entryRepo.save(hauptFriedHof);

            var pfeiffersWoerth = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    pfeiffersWoerthStation);
            entryRepo.save(pfeiffersWoerth);

            var neckarPlatt = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    neckarPlattStation);
            entryRepo.save(neckarPlatt);

            var ziethenStraße = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    ziethenStraßeStation);
            entryRepo.save(ziethenStraße);

            var adolfDamaschkeRing = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    adolfDamaschkeRingStation);
            entryRepo.save(adolfDamaschkeRing);

            var talStrasse = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    talStrasseStation);
            entryRepo.save(talStrasse);

            var abendAkademie = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    abendAkademieStation);
            entryRepo.save(abendAkademie);

            var kunstHalle = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    kunstHalleStation);
            entryRepo.save(kunstHalle);

            var rosenGarten = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    rosenGartenStation);
            entryRepo.save(rosenGarten);

            var mannheimHauptBahnHof = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    mannheimHauptBahnHofStation);
            entryRepo.save(mannheimHauptBahnHof);

            var tattersall = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    tattersallStation);
            entryRepo.save(tattersall);

            var werderStrasse = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    werderStrasseStation);
            entryRepo.save(werderStrasse);

            var pestalozziSchule = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    pestalozziSchuleStation);
            entryRepo.save(pestalozziSchule);

            var weberStrasse = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    weberStrasseStation);
            entryRepo.save(weberStrasse);

            var planetarium = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    planetariumStation);
            entryRepo.save(planetarium);

            var carlBenzStadion = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    carlBenzStadionStation);
            entryRepo.save(carlBenzStadion);

            var harrLach = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    harrLachStation);
            entryRepo.save(harrLach);

            var lucasCranachStrasse = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    lucasCranachStrasseStation);
            entryRepo.save(lucasCranachStrasse);

            var schwindStrasse = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    schwindStrasseStation);
            entryRepo.save(schwindStrasse);

            var ludwigStrasse = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    ludwigStrasseStation);
            entryRepo.save(ludwigStrasse);

            var ratHausLU = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    ratHausLUStation);
            entryRepo.save(ratHausLU);

            var handelsHafen = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    handelsHafenStation);
            entryRepo.save(handelsHafen);

            var rheinStrasse = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    rheinStrasseStation);
            entryRepo.save(rheinStrasse);

            var ratHausMA = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    ratHausMAStation);
            entryRepo.save(ratHausMA);

            var strohMarkt = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    strohMarktStation);
            entryRepo.save(strohMarkt);

            var wasserTurm = new LineScheduleEntry(
                    LocalTime.now(), 0, 0,
                    wasserTurmStation);
            entryRepo.save(wasserTurm);

            // Real data for the shuttle line from the BUGA entrance pdf file and openstreetmap
            var bugaShuttlelinie = new PublicTransportLine("P+R", false, "#4e2583", TransportType.Shuttle);
            var bugaShuttleLineDataFile = ResourceUtils.getFile("classpath:database/Buga Line P+R (purple_dashed).txt");
            bugaShuttlelinie.setGeoLinePoints(LineLoader.loadLineFile(bugaShuttleLineDataFile));
            bugaShuttlelinie.addLineScheduleEntryList(sapArena);
            bugaShuttlelinie.addLineScheduleEntryList(luisenPark);
            bugaShuttlelinie.addLineScheduleEntryList(neuOstHeim);
            bugaShuttlelinie.addLineScheduleEntryList(spinelliPark);
            bugaShuttlelinie.addLineScheduleEntryList(hansThomaStr);
            bugaShuttlelinie.addLineScheduleEntryList(maimarktGrossParkPlatz);
            log.info("Saving Buga Shuttle Line " + lineRepo.save(bugaShuttlelinie));

            // Real data for the train station of line 7 (yellow line)
            var line7 = new PublicTransportLine("7", false, "#FFCC00", TransportType.Train);
            File line7DataFile = ResourceUtils.getFile("classpath:database/Buga Line 7 (yellow).txt");
            line7.setGeoLinePoints(LineLoader.loadLineFile(line7DataFile));
            line7.addLineScheduleEntryList(berlinerPlatz);
            line7.addLineScheduleEntryList(konradAdenauerBrücke);
            line7.addLineScheduleEntryList(universität);
            line7.addLineScheduleEntryList(schloss);
            line7.addLineScheduleEntryList(paradePlatz);
            line7.addLineScheduleEntryList(marktPlatz);
            line7.addLineScheduleEntryList(abendAkademie);
            line7.addLineScheduleEntryList(gewerkschaftHaus);
            line7.addLineScheduleEntryList(nationalTheater);
            line7.addLineScheduleEntryList(theresenKrankenhaus);
            line7.addLineScheduleEntryList(universitaetsKlinikum);
            line7.addLineScheduleEntryList(bibienStraße);
            line7.addLineScheduleEntryList(hauptFriedHof);
            line7.addLineScheduleEntryList(pfeiffersWoerth);
            line7.addLineScheduleEntryList(neckarPlatt);
            line7.addLineScheduleEntryList(ziethenStraße);
            line7.addLineScheduleEntryList(adolfDamaschkeRing);
            line7.addLineScheduleEntryList(talStrasse);
            log.info("Saving Line 7 " + lineRepo.save(line7));

            // Real data for buga 23 express blue line
            var lineBuga23 = new PublicTransportLine("BS", false, "#0BBBEF", TransportType.Train);
            var lineBuga23DataFile = ResourceUtils.getFile("classpath:database/Buga Line 23 (light_blue).txt");
            lineBuga23.setGeoLinePoints(LineLoader.loadLineFile(lineBuga23DataFile));
            lineBuga23.addLineScheduleEntryList(mannheimHauptBahnHof);
            lineBuga23.addLineScheduleEntryList(kunstHalle);
            lineBuga23.addLineScheduleEntryList(rosenGarten);
            lineBuga23.addLineScheduleEntryList(nationalTheater);
            lineBuga23.addLineScheduleEntryList(theresenKrankenhaus);
            lineBuga23.addLineScheduleEntryList(universitaetsKlinikum);
            //lineBuga23.addLineScheduleEntryList(bibienStraße);
            //lineBuga23.addLineScheduleEntryList(hauptFriedHof);
            //lineBuga23.addLineScheduleEntryList(pfeiffersWoerth);
            //lineBuga23.addLineScheduleEntryList(neckarPlatt);
            //lineBuga23.addLineScheduleEntryList(ziethenStraße);
            //lineBuga23.addLineScheduleEntryList(adolfDamaschkeRing);
            lineBuga23.addLineScheduleEntryList(talStrasse);
            log.info("Saving Line Buga 23 Express" + lineRepo.save(lineBuga23));

            // real data for ex9 green line
            var ex9 = new PublicTransportLine("9", false, "#95c23d", TransportType.Train);
            var ex9DataFile = ResourceUtils.getFile("classpath:database/Buga Line 9 (green).txt");
            ex9.setGeoLinePoints(LineLoader.loadLineFile(ex9DataFile));
            ex9.addLineScheduleEntryList(mannheimHauptBahnHof);
            ex9.addLineScheduleEntryList(tattersall);
            ex9.addLineScheduleEntryList(werderStrasse);
            ex9.addLineScheduleEntryList(pestalozziSchule);
            ex9.addLineScheduleEntryList(weberStrasse);
            ex9.addLineScheduleEntryList(planetarium);
            ex9.addLineScheduleEntryList(luisenPark);
            ex9.addLineScheduleEntryList(carlBenzStadion);
            ex9.addLineScheduleEntryList(harrLach);
            ex9.addLineScheduleEntryList(lucasCranachStrasse);
            ex9.addLineScheduleEntryList(schwindStrasse);
            ex9.addLineScheduleEntryList(neuOstHeim);
            log.info("Saving Line EX9 " + lineRepo.save(ex9));

            // real data for buga bl line pink line
            var bugaBL = new PublicTransportLine("BL", false, "#e6007e", TransportType.Train);
            var bugaBLDataFile = ResourceUtils.getFile("classpath:database/Buga Line BL (pink).txt");
            bugaBL.setGeoLinePoints(LineLoader.loadLineFile(bugaBLDataFile));
            bugaBL.addLineScheduleEntryList(mannheimHauptBahnHof);
            bugaBL.addLineScheduleEntryList(tattersall);
            bugaBL.addLineScheduleEntryList(werderStrasse);
            bugaBL.addLineScheduleEntryList(pestalozziSchule);
            bugaBL.addLineScheduleEntryList(weberStrasse);
            bugaBL.addLineScheduleEntryList(planetarium);
            bugaBL.addLineScheduleEntryList(luisenPark);
            bugaBL.addLineScheduleEntryList(carlBenzStadion);
            bugaBL.addLineScheduleEntryList(harrLach);
            bugaBL.addLineScheduleEntryList(lucasCranachStrasse);
            bugaBL.addLineScheduleEntryList(schwindStrasse);
            bugaBL.addLineScheduleEntryList(neuOstHeim);
            bugaBL.addLineScheduleEntryList(hansThomaStr);
            bugaBL.addLineScheduleEntryList(maimarktGrossParkPlatz);
            bugaBL.addLineScheduleEntryList(sapArena);
            bugaBL.addLineScheduleEntryList(sapArenaSBF);
            log.info("Saving Buga 23 BL line " + lineRepo.save(bugaBL));

            // real data for rnv bahnlinie brown line
            var bugaLine6 = new PublicTransportLine("6", false, "#966c29", TransportType.Train);
            var bugaLine6DataFile = ResourceUtils.getFile("classpath:database/Buga Line 6 (brown).txt");
            bugaLine6.setGeoLinePoints(LineLoader.loadLineFile(bugaLine6DataFile));
            bugaLine6.addLineScheduleEntryList(berlinerPlatz);
            bugaLine6.addLineScheduleEntryList(ludwigStrasse);
            bugaLine6.addLineScheduleEntryList(ratHausLU);
            bugaLine6.addLineScheduleEntryList(handelsHafen);
            bugaLine6.addLineScheduleEntryList(rheinStrasse);
            bugaLine6.addLineScheduleEntryList(ratHausMA);
            bugaLine6.addLineScheduleEntryList(paradePlatz);
            bugaLine6.addLineScheduleEntryList(schloss);
            bugaLine6.addLineScheduleEntryList(universität);
            bugaLine6.addLineScheduleEntryList(mannheimHauptBahnHof);
            bugaLine6.addLineScheduleEntryList(tattersall);
            bugaLine6.addLineScheduleEntryList(werderStrasse);
            bugaLine6.addLineScheduleEntryList(pestalozziSchule);
            bugaLine6.addLineScheduleEntryList(weberStrasse);
            bugaLine6.addLineScheduleEntryList(planetarium);
            bugaLine6.addLineScheduleEntryList(luisenPark);
            bugaLine6.addLineScheduleEntryList(carlBenzStadion);
            bugaLine6.addLineScheduleEntryList(harrLach);
            bugaLine6.addLineScheduleEntryList(lucasCranachStrasse);
            bugaLine6.addLineScheduleEntryList(schwindStrasse);
            bugaLine6.addLineScheduleEntryList(neuOstHeim);
            bugaLine6.addLineScheduleEntryList(hansThomaStr);
            bugaLine6.addLineScheduleEntryList(maimarktGrossParkPlatz);
            bugaLine6.addLineScheduleEntryList(sapArena);
            bugaLine6.addLineScheduleEntryList(sapArenaSBF);
            log.info("Saving Buga Line 6" + lineRepo.save(bugaLine6));
        };
    }
}


