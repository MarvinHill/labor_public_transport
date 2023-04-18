package de.hhn.se.labswp.buga23publictransport;

import de.hhn.se.labswp.buga23publictransport.persistence.LineScheduleEntry;
import de.hhn.se.labswp.buga23publictransport.persistence.LineScheduleEntryRepo;
import de.hhn.se.labswp.buga23publictransport.persistence.PublicTransportLine;
import de.hhn.se.labswp.buga23publictransport.persistence.PublicTransportLineRepo;

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
    CommandLineRunner initDatabase(PublicTransportLineRepo lineRepo, LineScheduleEntryRepo entryRepo) {
        return args -> {
            log.info("Preloading Database Entries");
            log.info("Preloading stops for public transport lines and shuttles");
            var hansThomaStr = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Hans-Thoma-Str.",
                    49.47496, 8.52439);
            entryRepo.save(hansThomaStr);

            var neuOstHeim = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Neuostheim",
                    49.4774967, 8.5228445);
            entryRepo.save(neuOstHeim);

            var luisenPark = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Luisenpark",
                    49.47887, 8.49640);
            entryRepo.save(luisenPark);

            var spinelliPark = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Buga 23 Haupteingang Spinelli-Park",
                    49.49618, 8.52258);
            entryRepo.save(spinelliPark);

            var sapArenaSBF = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "SAP Arena S-Bf (MA-Arena/Maimarkt)",
                    49.4598771, 8.5171520);
            entryRepo.save(sapArenaSBF);

            var maimarktGrossParkPlatz = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Maimarkt (P+R Großparkplatz)",
                    49.4685232, 8.5220630);
            entryRepo.save(maimarktGrossParkPlatz);

            var sapArena = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "SAP-Arena",
                    49.4648353, 8.5204035);
            entryRepo.save(sapArena);

            var berlinerPlatz = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Berliner Platz",
                    49.4799380, 8.4507645);
            entryRepo.save(berlinerPlatz);

            var konradAdenauerBrücke = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Konrad-Adenauer-Brücke",
                    49.4824621, 8.4586681);
            entryRepo.save(konradAdenauerBrücke);

            var universität = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Universität",
                    49.48166, 8.46537);
            entryRepo.save(universität);

            var schloss = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Schloss",
                    49.48489, 8.46354);
            entryRepo.save(schloss);

            var paradePlatz = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Paradeplatz",
                    49.48749, 8.46688);
            entryRepo.save(paradePlatz);

            var marktPlatz = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Marktplatz",
                    49.48943, 8.46782);
            entryRepo.save(marktPlatz);

            var akademie = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Abendakademie",
                    49.48943, 8.46782);
            entryRepo.save(akademie);

            var gewerkschaftHaus = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Gewerkschafthaus",
                    49.4904423, 8.4753833);
            entryRepo.save(gewerkschaftHaus);

            var nationalTheater = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Nationaltheater",
                    49.48765, 8.47819);
            entryRepo.save(nationalTheater);

            var theresenKrankenhaus = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Theresen-Krankenhaus",
                    49.48991, 8.48091);
            entryRepo.save(theresenKrankenhaus);

            var universitaetsKlinikum = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Universitätsklinikum",
                    49.49363, 8.48423);
            entryRepo.save(universitaetsKlinikum);

            var bibienStraße = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Bibienastraße",
                    49.49464, 8.48861);
            entryRepo.save(bibienStraße);

            var hauptFriedHof = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Hauptfriedhof",
                    49.49078, 8.49127);
            entryRepo.save(hauptFriedHof);

            var pfeiffersWoerth = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Pfeifferswörth",
                    49.48948, 8.50141);
            entryRepo.save(pfeiffersWoerth);

            var neckarPlatt = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Neckarplatt",
                    49.48892, 8.51182);
            entryRepo.save(neckarPlatt);

            var ziethenStraße = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Ziethenstraße",
                    49.49043, 8.51926);
            entryRepo.save(ziethenStraße);

            var adolfDamaschkeRing = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Adolf-Damaschke-Ring",
                    49.49359, 8.52103);
            entryRepo.save(adolfDamaschkeRing);

            var talStrasse = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Tal-Straße",
                    49.49528, 8.52479);
            entryRepo.save(talStrasse);

            var abendAkademie = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Abendakademie",
                    49.49171, 8.46993);
            entryRepo.save(abendAkademie);

            var kunstHalle = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Kunsthalle",
                    49.48309, 8.47335);
            entryRepo.save(kunstHalle);

            var rosenGarten = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Rosengarten",
                    49.48555, 8.47556);
            entryRepo.save(rosenGarten);

            var mannheimHauptBahnHof = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "MA Hauptbahnhof",
                    49.47908, 8.47013);
            entryRepo.save(mannheimHauptBahnHof);

            var tattersall = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Tattersall",
                    49.48174, 8.47320);
            entryRepo.save(tattersall);

            var werderStrasse = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Werderstr.",
                    49.48073, 8.47791);
            entryRepo.save(werderStrasse);

            var pestalozziSchule = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Pestalozzischule",
                    49.47893, 8.48185);
            entryRepo.save(pestalozziSchule);

            var weberStrasse = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Weberstraße",
                    49.47662, 8.48524);
            entryRepo.save(weberStrasse);

            var planetarium = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Planetarium",
                    49.47659, 8.48985);
            entryRepo.save(planetarium);

            var carlBenzStadion = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Carl-Benz-Stadion",
                    49.47782, 8.50181);
            entryRepo.save(carlBenzStadion);

            var harrLach = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Harrlach",
                    49.47809, 8.50640);
            entryRepo.save(harrLach);

            var lucasCranachStrasse = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Lucas-Cranach-Str.",
                    49.47842, 8.51274);
            entryRepo.save(lucasCranachStrasse);

            var schwindStrasse = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Schwindstraße",
                    49.47834, 8.51856);
            entryRepo.save(schwindStrasse);

            var ludwigStrasse = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Ludwigstraße",
                    49.4832, 8.4482);
            entryRepo.save(ludwigStrasse);

            var ratHausLU = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "LU Rathaus",
                    49.48517, 8.44339);
            entryRepo.save(ratHausLU);

            var handelsHafen = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Handelshafen",
                    49.49179, 8.45373);
            entryRepo.save(handelsHafen);

            var rheinStrasse = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Rheinstraße",
                    49.49087, 8.45800);
            entryRepo.save(rheinStrasse);

            var ratHausMA = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "MA Rathaus/rem",
                    49.48914, 8.46246);
            entryRepo.save(ratHausMA);

            var strohMarkt = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Strohmarkt",
                    49.48621, 8.46999);
            entryRepo.save(strohMarkt);

            var wasserTurm = new LineScheduleEntry(
                    LocalTime.now(), 0, 0, "Wasserturm",
                    49.48487, 8.47339);
            entryRepo.save(wasserTurm);

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
            var path = ResourceUtils.getFile("classpath:database/Buga Line 7.txt");
            line7.setGeoLinePoints(LineLoader.loadLineFile(path.getPath()));
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
            lineBuga23Express.addLineScheduleEntryList(rosenGarten);
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
            var rnvBahnlinie6 = new PublicTransportLine("RNV-Bahnlinie 6", false);
            rnvBahnlinie6.addLineScheduleEntryList(berlinerPlatz);
            rnvBahnlinie6.addLineScheduleEntryList(ludwigStrasse);
            rnvBahnlinie6.addLineScheduleEntryList(ratHausLU);
            rnvBahnlinie6.addLineScheduleEntryList(handelsHafen);
            rnvBahnlinie6.addLineScheduleEntryList(rheinStrasse);
            rnvBahnlinie6.addLineScheduleEntryList(ratHausMA);
            rnvBahnlinie6.addLineScheduleEntryList(paradePlatz);
            rnvBahnlinie6.addLineScheduleEntryList(schloss);
            rnvBahnlinie6.addLineScheduleEntryList(universität);
            rnvBahnlinie6.addLineScheduleEntryList(mannheimHauptBahnHof);
            rnvBahnlinie6.addLineScheduleEntryList(tattersall);
            rnvBahnlinie6.addLineScheduleEntryList(werderStrasse);
            rnvBahnlinie6.addLineScheduleEntryList(pestalozziSchule);
            rnvBahnlinie6.addLineScheduleEntryList(weberStrasse);
            rnvBahnlinie6.addLineScheduleEntryList(planetarium);
            rnvBahnlinie6.addLineScheduleEntryList(luisenPark);
            rnvBahnlinie6.addLineScheduleEntryList(carlBenzStadion);
            rnvBahnlinie6.addLineScheduleEntryList(harrLach);
            rnvBahnlinie6.addLineScheduleEntryList(lucasCranachStrasse);
            rnvBahnlinie6.addLineScheduleEntryList(schwindStrasse);
            rnvBahnlinie6.addLineScheduleEntryList(neuOstHeim);
            rnvBahnlinie6.addLineScheduleEntryList(hansThomaStr);
            rnvBahnlinie6.addLineScheduleEntryList(maimarktGrossParkPlatz);
            rnvBahnlinie6.addLineScheduleEntryList(sapArena);
            rnvBahnlinie6.addLineScheduleEntryList(sapArenaSBF);
        };
    }
}


