package de.hhn.se.labswp.buga23publictransport;

import de.hhn.se.labswp.buga23publictransport.persistence.LineScheduleEntry;
import de.hhn.se.labswp.buga23publictransport.persistence.LineScheduleEntryRepo;
import de.hhn.se.labswp.buga23publictransport.persistence.PublicTransportLine;
import de.hhn.se.labswp.buga23publictransport.persistence.PublicTransportLineRepo;

import java.sql.Array;
import java.time.LocalTime;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(PublicTransportLineRepo lineRepo, LineScheduleEntryRepo entryRepo) {
        return args -> {
            log.info("Preloading Database Entries");
            log.info("Preloading stops for public transport lines and shuttles");
            var hansThomaStr = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Hans-Thoma-Str.",
                    49.47496, 8.52439);

            var neuOstHeim = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Neuostheim",
                    49.4774967, 8.5228445);

            var luisenPark = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Luisenpark",
                    49.47887, 8.49640);

            var spinelliPark = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Buga 23 Haupteingang Spinelli-Park",
                    49.49618, 8.52258);

            var sapArenaSBF = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "SAP Arena S-Bf (MA-Arena/Maimarkt)",
                    49.4598771, 8.5171520);

            var maimarktGrossParkPlatz = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Maimarkt (P+R Großparkplatz)",
                    49.4685232, 8.5220630);

            var sapArena = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "SAP-Arena",
                    49.4648353, 8.5204035);

            var berlinerPlatz = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Berliner Platz",
                    49.4799380, 8.4507645);

            var konradAdenauerBrücke = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Konrad-Adenauer-Brücke",
                    49.4824621, 8.4586681);

            var universität = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Universität",
                    49.48166, 8.46537);

            var schloss = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Schloss",
                    49.48489, 8.46354);

            var paradePlatz = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Paradeplatz",
                    49.48749, 8.46688);

            var marktPlatz = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Marktplatz",
                    49.48943, 8.46782);

            var akademie = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Abendakademie",
                    49.48943, 8.46782);

            var gewerkschaftHaus = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Gewerkschafthaus",
                    49.4904423, 8.4753833);

            var nationalTheater = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Nationaltheater",
                    49.48765, 8.47819);

            var theresenKrankenhaus = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Theresen-Krankenhaus",
                    49.48991, 8.48091);

            var universitaetsKlinikum = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Universitätsklinikum",
                    49.49363, 8.48423);

            var bibienStraße = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Bibienastraße",
                    49.49464, 8.48861);

            var hauptFriedHof = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Hauptfriedhof",
                    49.49078, 8.49127);

            var pfeiffersWoerth = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Pfeifferswörth",
                    49.48948, 8.50141);

            var neckarPlatt = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Neckarplatt",
                    49.48892, 8.51182);

            var ziethenStraße = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Ziethenstraße",
                    49.49043, 8.51926);

            var adolfDamaschkeRing = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Adolf-Damaschke-Ring",
                    49.49359, 8.52103);

            var talStrasse = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Tal-Straße",
                    49.49528, 8.52479);

            var abendAkademie = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Abendakademie",
                    49.49171, 8.46993);

            var kunstHalle = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Kunsthalle",
                    49.48309, 8.47335);

            var rosenGarten = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Rosengarten",
                    49.48555, 8.47556);

            var mannheimHauptBahnHof = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "MA Hauptbahnhof",
                    49.47908, 8.47013);

            var tattersall = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Tattersall",
                    49.48174, 8.47320);

            var werderStrasse = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Werderstr.",
                    49.48073, 8.47791);

            var pestalozziSchule = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Pestalozzischule",
                    49.47893, 8.48185);

            var weberStrasse = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Weberstraße",
                    49.47662, 8.48524);

            var planetarium = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Planetarium",
                    49.47659, 8.48985);

            var carlBenzStadion = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Carl-Benz-Stadion",
                    49.47782, 8.50181);

            var harrLach = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Harrlach",
                    49.47809, 8.50640);

            var lucasCranachStrasse = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Lucas-Cranach-Str.",
                    49.47842, 8.51274);

            var schwindStrasse = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Schwindstraße",
                    49.47834 ,8.51856);

            var berlinerPlatz = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Berliner Platz",
                    49.48007,8.45088);












            // Real data for the shuttle line from the BUGA entrance pdf file and openstreetmap
            var bugaShuttlelinie = new PublicTransportLine("BUGA Shuttlelinie", false);
            bugaShuttlelinie.addLineScheduleEntryList(sapArena);
            bugaShuttlelinie.addLineScheduleEntryList(luisenPark);
            bugaShuttlelinie.addLineScheduleEntryList(neuOstHeim);
            bugaShuttlelinie.addLineScheduleEntryList(spinelliPark);
            bugaShuttlelinie.addLineScheduleEntryList(hansThomaStr);
            bugaShuttlelinie.addLineScheduleEntryList(maimarktGrossParkPlatz);
            log.info("Saving Buga Shuttle Line " + lineRepo.save(bugaShuttlelinie));

            // Real data for the train station of line 7 (yellow line)
            var line7 = new PublicTransportLine("7", false);
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
            var lineBuga23Express = new PublicTransportLine("Buga 23 Express", false);
            lineBuga23Express.addLineScheduleEntryList(mannheimHauptBahnHof);
            lineBuga23Express.addLineScheduleEntryList(kunstHalle);
            lineBuga23Express.addLineScheduleEntryList( rosenGarten);
            lineBuga23Express.addLineScheduleEntryList(nationalTheater);
            lineBuga23Express.addLineScheduleEntryList(theresenKrankenhaus);
            lineBuga23Express.addLineScheduleEntryList(universitaetsKlinikum);
            lineBuga23Express.addLineScheduleEntryList(bibienStraße);
            lineBuga23Express.addLineScheduleEntryList(hauptFriedHof);
            lineBuga23Express.addLineScheduleEntryList(pfeiffersWoerth);
            lineBuga23Express.addLineScheduleEntryList(neckarPlatt);
            lineBuga23Express.addLineScheduleEntryList(ziethenStraße);
            lineBuga23Express.addLineScheduleEntryList(adolfDamaschkeRing);
            lineBuga23Express.addLineScheduleEntryList(talStrasse);
            log.info("Saving Line Buga 23 Express" + lineRepo.save(lineBuga23Express));

            // real data for ex9 green line
            var ex9 = new PublicTransportLine("EX9", false);
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

            // real data for buga 23 bl line pink line
            var bugaBL = new PublicTransportLine("BUGA 23 Sonderlinie BL", false);
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
            var rnvBahnline = new PublicTransportLine("RNV-Bahnlinie", false);
            rnvBahnline.addLineScheduleEntryList();
            // TODO: has next list entry !
            // TODO: branches needed to be implemented !
            rnvBahnline.addLineScheduleEntryList();
            rnvBahnline.addLineScheduleEntryList();
            rnvBahnline.addLineScheduleEntryList();
            rnvBahnline.addLineScheduleEntryList();
            rnvBahnline.addLineScheduleEntryList();
            rnvBahnline.addLineScheduleEntryList();
            rnvBahnline.addLineScheduleEntryList();
            rnvBahnline.addLineScheduleEntryList();
            rnvBahnline.addLineScheduleEntryList();
            rnvBahnline.addLineScheduleEntryList();
            rnvBahnline.addLineScheduleEntryList();
            rnvBahnline.addLineScheduleEntryList();
            rnvBahnline.addLineScheduleEntryList();
            rnvBahnline.addLineScheduleEntryList();
            rnvBahnline.addLineScheduleEntryList();
            rnvBahnline.addLineScheduleEntryList();
            rnvBahnline.addLineScheduleEntryList();
            rnvBahnline.addLineScheduleEntryList();
            rnvBahnline.addLineScheduleEntryList();





        };
    }
}


