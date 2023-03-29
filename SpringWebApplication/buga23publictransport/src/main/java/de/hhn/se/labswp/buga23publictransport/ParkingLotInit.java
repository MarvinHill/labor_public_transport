package de.hhn.se.labswp.buga23publictransport;

import com.vividsolutions.jts.geom.*;
import de.hhn.se.labswp.buga23publictransport.business.AccessRight;
import de.hhn.se.labswp.buga23publictransport.business.ParkingStatus;
import de.hhn.se.labswp.buga23publictransport.business.ParkingType;
import de.hhn.se.labswp.buga23publictransport.persistence.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.parameters.P;

@Configuration
public class ParkingLotInit {

    @Bean
    CommandLineRunner initializeParkingLots(ParkingLotRepository allRepo, BikeParkingLotRepository bikeRepo, CarParkingLotRepository carRepo) {
        // Parkplatz Info Quelle: https://parken-mannheim.de/

        GeometryFactory c1Geo = new GeometryFactory();
        Polygon c1Poly = c1Geo.createPolygon(c1Geo.createLinearRing(new Coordinate[]{
                new Coordinate(49.48712758655783, 8.4645198008609340),
                new Coordinate(49.487069215669, 8.464672016216854),
                new Coordinate(49.48704874228106, 8.464655252411136),
                new Coordinate(49.48704264382341, 8.464667322351252),
                new Coordinate(49.48703480294819, 8.464661287381194),
                new Coordinate(49.48699124250743, 8.464775281260076),
                new Coordinate(49.48700990297902, 8.46479608670014),
                new Coordinate(49.486984637915235, 8.464858448057411),
                new Coordinate(49.48680996013356, 8.464698856624874),
                new Coordinate(49.48681692983308, 8.464684104477294),
                new Coordinate(49.48674244112207, 8.464617719804798),
                new Coordinate(49.48680778210073, 8.464456116717676),
                new Coordinate(49.486534339331605, 8.464202107077117),
                new Coordinate(49.486549585632574, 8.464151145107735),
                new Coordinate(49.486549585632574, 8.464151145107735),
                new Coordinate(49.486564263733555, 8.464008036698248),
                new Coordinate(49.48712758655783, 8.4645198008609340)
        }));

        GeometryFactory colliniCenterMuldeGeo = new GeometryFactory();
        Polygon colliniCenterMuldePoly = colliniCenterMuldeGeo.createPolygon(colliniCenterMuldeGeo.createLinearRing(new Coordinate[]{
                new Coordinate(49.490978502027914, 8.478789934190527),
                new Coordinate(49.49020589678202, 8.47825530573382),
                new Coordinate(49.490183682401046, 8.478154052347282),
                new Coordinate(49.49027428216679, 8.47783755169),
                new Coordinate(49.49029479062149, 8.477812850882353),
                new Coordinate(49.49038378820515, 8.477908144952284),
                new Coordinate(49.490402813155306, 8.477951655194374),
                new Coordinate(49.49040294480902, 8.477951469298707),
                new Coordinate(49.490394233323386, 8.477984326363773),
                new Coordinate(49.490401638086304, 8.477989690781603),
                new Coordinate(49.49091735529876, 8.477908553957853),
                new Coordinate(49.49096875249447, 8.47794275212622),
                new Coordinate(49.49102537646051, 8.478062110425084),
                new Coordinate(49.49104846159723, 8.47809899079989),
                new Coordinate(49.491074160132044, 8.478117095710065),
                new Coordinate(49.49111684580413, 8.478113742948922),
                new Coordinate(49.491155611331216, 8.478185492037396),
                new Coordinate(49.490978502027914, 8.478789934190527)
        }));

        GeometryFactory d3Geo = new GeometryFactory();
        Polygon d3Poly = d3Geo.createPolygon(d3Geo.createLinearRing(new Coordinate[]{
                new Coordinate(49.4878709813945, 8.463519939128693),
                new Coordinate(49.48784876595397, 8.463584982694876),
                new Coordinate(49.48790277994865, 8.463643320738775),
                new Coordinate(49.487930658116134, 8.463566877784702),
                new Coordinate(49.4878709813945, 8.463519939128693)
        }));

        GeometryFactory d5Geo = new GeometryFactory();
        Polygon d5Poly = d5Geo.createPolygon(d5Geo.createLinearRing(new Coordinate[]{}));

        GeometryFactory g1Geo = new GeometryFactory();
        Polygon g1Poly = g1Geo.createPolygon(g1Geo.createLinearRing(new Coordinate[]{}));

        GeometryFactory h6Geo = new GeometryFactory();
        Polygon h6Poly = h6Geo.createPolygon(h6Geo.createLinearRing(new Coordinate[]{
            new Coordinate(49.4924047093088, 8.463926845350759),
            new Coordinate(49.49239730484887, 8.463949644126535),
            new Coordinate(49.49244782937666, 8.46399993554369),
            new Coordinate(49.49242126045044, 8.464071684632163),
            new Coordinate(49.4924047093088, 8.464060955796503),
            new Coordinate(49.49239382039675, 8.464075037393306),
            new Coordinate(49.49237857591585, 8.46408844843788),
            new Coordinate(49.49235984697565, 8.464101188930227),
            new Coordinate(49.492348522496684, 8.464105212243599),
            new Coordinate(49.492311935700265, 8.46410655334708),
            new Coordinate(49.492283624470275, 8.464086436780219),
            new Coordinate(49.4922500865305, 8.464054250273241),
            new Coordinate(49.49215687706892, 8.463969090137843),
            new Coordinate(49.49221959747264, 8.463804804841805),
            new Coordinate(49.49227099329913, 8.463853084602272),
            new Coordinate(49.49227839777813, 8.463843696871072),
            new Coordinate(49.49231062902672, 8.463866495646847),
            new Coordinate(49.492319340171356, 8.463843026318841),
            new Coordinate(49.4924047093088, 8.463926845350759)
        }));

        GeometryFactory p1Geo = new GeometryFactory();
        Polygon p1Poly = p1Geo.createPolygon(p1Geo.createLinearRing(new Coordinate[]{}));

        GeometryFactory p2Geo = new GeometryFactory();
        Polygon p2Poly = p2Geo.createPolygon(p2Geo.createLinearRing(new Coordinate[]{
            new Coordinate(49.4784317046207, 8.472412711301406),
            new Coordinate(49.4784086135352, 8.47237918368997),
            new Coordinate(49.47845392433422, 8.47236912540654),
            new Coordinate(49.47849967077145, 8.472318163437157),
            new Coordinate(49.47851753365437, 8.472239708826397),
            new Coordinate(49.47850359189264, 8.472160583663406),
            new Coordinate(49.478460895222625, 8.472108951141795),
            new Coordinate(49.47840382104413, 8.47210425727382),
            new Coordinate(49.47835546042884, 8.472155219243204),
            new Coordinate(49.47834064725781, 8.47223635606288),
            new Coordinate(49.47835458906596, 8.472311457912495),
            new Coordinate(49.47831842749293, 8.47228329471889),
            new Coordinate(49.47775232550676, 8.473416075858829),
            new Coordinate(49.47778623088074, 8.473462402957518),
            new Coordinate(49.477732255206504, 8.473457237323917),
            new Coordinate(49.4776852009887, 8.473509540401409),
            new Coordinate(49.47766733780217, 8.473590006668857),
            new Coordinate(49.47768302255166, 8.473674496249677),
            new Coordinate(49.47772789833497, 8.473722776010144),
            new Coordinate(49.47778497330094, 8.473726128771288),
            new Coordinate(49.477830720363066, 8.473676507906362),
            new Coordinate(49.477849019175935, 8.473594700534457),
            new Coordinate(49.47783420585177, 8.473518257580384),
            new Coordinate(49.47786775366776, 8.473554467400733),
            new Coordinate(49.4784317046207, 8.472412711301406)
        }));

        GeometryFactory p3Geo = new GeometryFactory();
        Polygon p3Poly = p3Geo.createPolygon(p3Geo.createLinearRing(new Coordinate[]{
                new Coordinate(49.47943695108108, 8.474396064303393),
                new Coordinate(49.47944566451654, 8.474420204183627),
                new Coordinate(49.47942867331592, 8.474438309093802),
                new Coordinate(49.47956634544108, 8.474704518333784),
                new Coordinate(49.47966873986805, 8.474887115650516),
                new Coordinate(49.48014211509741, 8.474337826130855),
                new Coordinate(49.48003333734188, 8.474137290814696),
                new Coordinate(49.4798952308645, 8.473874434341036),
                new Coordinate(49.47988390350204, 8.473881139863325),
                new Coordinate(49.47987344747288, 8.473861023296461),
                new Coordinate(49.47943695108108, 8.474396064303393),
        }));

        GeometryFactory p5Geo = new GeometryFactory();
        Polygon p5Poly = p5Geo.createPolygon(p5Geo.createLinearRing(new Coordinate[]{
                new Coordinate(49.47736326531506, 8.46927124660294),
                new Coordinate(49.477751858242065, 8.469749701891766),
                new Coordinate(49.47756844276471, 8.470097379401645),
                new Coordinate(49.477182957149644, 8.469617329261856),
                new Coordinate(49.47736326531506, 8.46927124660294)
        }));

        GeometryFactory klinikumGeo = new GeometryFactory();
        Polygon klinikumPoly = klinikumGeo.createPolygon(klinikumGeo.createLinearRing(new Coordinate[]{}));

        GeometryFactory kunsthalleGeo = new GeometryFactory();
        Polygon kunsthallePoly = kunsthalleGeo.createPolygon(kunsthalleGeo.createLinearRing(new Coordinate[]{}));

        GeometryFactory klinikumP3Geo = new GeometryFactory();
        Polygon klinikumP3Poly = klinikumP3Geo.createPolygon(klinikumP3Geo.createLinearRing(new Coordinate[]{
                new Coordinate(49.48916437944193, 8.493028091649018),
                new Coordinate(49.48920793794911, 8.493050219872565),
                new Coordinate(49.48921447172183, 8.493097158528576),
                new Coordinate(49.48924365589608, 8.493145438289043),
                new Coordinate(49.48927893823274, 8.493169578169278),
                new Coordinate(49.48932511014106, 8.493185000870536),
                new Coordinate(49.48936431267056, 8.493174942587107),
                new Coordinate(49.48940351516865, 8.493133368348925),
                new Coordinate(49.48942047342592, 8.493057868458768),
                new Coordinate(49.48946620961817, 8.493072620607801),
                new Coordinate(49.48957644662049, 8.49232867542628),
                new Coordinate(49.4896841690617, 8.491947764436901),
                new Coordinate(49.48978217461035, 8.491609135553423),
                new Coordinate(49.48986932763664, 8.491296055602971),
                new Coordinate(49.489839272676896, 8.491267892409365),
                new Coordinate(49.48981183117579, 8.491213577678838),
                new Coordinate(49.48980486190322, 8.4911753562018),
                new Coordinate(49.48979570698599, 8.491082305806607),
                new Coordinate(49.489818357122466, 8.490964288614352),
                new Coordinate(49.489860172731454, 8.490882481242448),
                new Coordinate(49.489892405572355, 8.490869070197874),
                new Coordinate(49.48988151610147, 8.490756417423448),
                new Coordinate(49.48985755925695, 8.490766475706877),
                new Coordinate(49.4898362158765, 8.490767816811339),
                new Coordinate(49.489810952271284, 8.490756417423448),
                new Coordinate(49.48977014335425, 8.490726693405572),
                new Coordinate(49.489676119430655, 8.491044389864632),
                new Coordinate(49.489710965875226, 8.491070541401552),
                new Coordinate(49.489681346398925, 8.491179841414834),
                new Coordinate(49.48965695387557, 8.491158383743514),
                new Coordinate(49.489507702898706, 8.491672802668948),
                new Coordinate(49.48954124271743, 8.491692919235808),
                new Coordinate(49.48950596056983, 8.491811606980292),
                new Coordinate(49.489472484411834, 8.491788696603333),
                new Coordinate(49.48937309039219, 8.492130871693389),
                new Coordinate(49.48933998604163, 8.492162387651192),
                new Coordinate(49.48929207181084, 8.492285098709047),
                new Coordinate(49.489336501371874, 8.492317955768254),
                new Coordinate(49.48930775283699, 8.492441337378338),
                new Coordinate(49.489252869223506, 8.492418538602562),
                new Coordinate(49.48916437944193, 8.493028091649018)
        }));

        GeometryFactory m4aGeo = new GeometryFactory();
        Polygon m4aPoly = m4aGeo.createPolygon(m4aGeo.createLinearRing(new Coordinate[]{
                new Coordinate(49.48427342931946, 8.466529827905426),
                new Coordinate(49.48456050784949, 8.466812130400719),
                new Coordinate(49.48430999739492, 8.467473112005381),
                new Coordinate(49.48402158532832, 8.467190148693177),
                new Coordinate(49.48427342931946, 8.466529827905426),
        }));

        GeometryFactory n1Geo = new GeometryFactory();
        Polygon n1Poly = n1Geo.createPolygon(n1Geo.createLinearRing(new Coordinate[]{}));

        GeometryFactory n2Geo = new GeometryFactory();
        Polygon n2Poly = n2Geo.createPolygon(n2Geo.createLinearRing(new Coordinate[]{
                new Coordinate(49.48550119008582, 8.466346228260758),
                new Coordinate(49.48574570428805, 8.466573494522951),
                new Coordinate(49.48602852902097, 8.465848824436932),
                new Coordinate(49.48578087627485, 8.465624076375626),
                new Coordinate(49.48550119008582, 8.466346228260758)
        }));

        GeometryFactory n6KomfortGeo = new GeometryFactory();
        Polygon n6KomfortPoly = n6KomfortGeo.createPolygon(n6KomfortGeo.createLinearRing(new Coordinate[]{}));

        GeometryFactory n6StandardGeo = new GeometryFactory();
        Polygon n6StandardPoly = n6StandardGeo.createPolygon(n6StandardGeo.createLinearRing(new Coordinate[]{}));

        GeometryFactory u2Geo = new GeometryFactory();
        Polygon u2Poly = u2Geo.createPolygon(u2Geo.createLinearRing(new Coordinate[]{}));

        GeometryFactory sap1Geo = new GeometryFactory();
        Polygon sap1Poly = sap1Geo.createPolygon(sap1Geo.createLinearRing(new Coordinate[]{
                new Coordinate(49.46157804956302, 8.517320072127875),
                new Coordinate(49.460236838432955, 8.516127093161739),
                new Coordinate(49.46021809719742, 8.51610496493819),
                new Coordinate(49.46020415022681, 8.516078142849041),
                new Coordinate(49.46019586921113, 8.516045956342063),
                new Coordinate(49.46019586921113, 8.516001029342739),
                new Coordinate(49.460202406855196, 8.515951408477813),
                new Coordinate(49.46038080234513, 8.51549496356781),
                new Coordinate(49.46040936291787, 8.515473702671379),
                new Coordinate(49.460475845929224, 8.515477101819505),
                new Coordinate(49.460573534432164, 8.515533656700713),
                new Coordinate(49.461114292858845, 8.516000545719127),
                new Coordinate(49.46122237977362, 8.516113198501246),
                new Coordinate(49.461265066834336, 8.516157312660008),
                new Coordinate(49.461369230921825, 8.516230402855536),
                new Coordinate(49.46155358773871, 8.516315562993887),
                new Coordinate(49.46156840598971, 8.516320256861768),
                new Coordinate(49.46170362583955, 8.51632432851125),
                new Coordinate(49.46181846739275, 8.516550024210119),
                new Coordinate(49.46182923377439, 8.516592816666172),
                new Coordinate(49.461828785175214, 8.51663836992584),
                new Coordinate(49.46170093423906, 8.51700003520901),
                new Coordinate(49.46164037315201, 8.51725402915133),
                new Coordinate(49.46157804956302, 8.517320072127875),
        }));

        GeometryFactory sap2Geo = new GeometryFactory();
        Polygon sap2Poly = sap2Geo.createPolygon(sap2Geo.createLinearRing(new Coordinate[]{
                new Coordinate(49.46167100798148, 8.51720710745664),
                new Coordinate(49.46232111773934, 8.517479939078296),
                new Coordinate(49.462397822714784, 8.517473233556009),
                new Coordinate(49.462466682760905, 8.517412883855425),
                new Coordinate(49.462496318702115, 8.517365945194364),
                new Coordinate(49.46302214164951, 8.51596380842492),
                new Coordinate(49.46212137269248, 8.516400351531459),
                new Coordinate(49.46191503193266, 8.516951537170305),
                new Coordinate(49.46167100798148, 8.51720710745664)
        }));

        GeometryFactory sap3Geo = new GeometryFactory();
        Polygon sap3Poly = sap3Geo.createPolygon(sap3Geo.createLinearRing(new Coordinate[]{
                new Coordinate(49.46556659161986, 8.523846083277725),
                new Coordinate(49.46401881809177, 8.52247478789771),
                new Coordinate(49.46464748964174, 8.52080021444663),
                new Coordinate(49.46471125459628, 8.52077089346843),
                new Coordinate(49.46530336491263, 8.521107912839708),
                new Coordinate(49.46540890544854, 8.521169937985901),
                new Coordinate(49.466115928928744, 8.521593758637644),
                new Coordinate(49.466115928928744, 8.521593758637644),
                new Coordinate(49.46556659161986, 8.523846083277725)
        }));

        GeometryFactory sap6_8Geo = new GeometryFactory();
        Polygon sap6_8Poly = sap6_8Geo.createPolygon(sap6_8Geo.createLinearRing(new Coordinate[]{
                new Coordinate(49.4670353716169, 8.521453699893994),
                new Coordinate(49.46737114613426, 8.521620931470746),
                new Coordinate(49.46761387452, 8.521699386083007),
                new Coordinate(49.467850958861185, 8.52173996688108),
                new Coordinate(49.467971733551245, 8.521748588900234),
                new Coordinate(49.46797177144488, 8.521864238106287),
                new Coordinate(49.46806919770611, 8.52186104840436),
                new Coordinate(49.4692333317201, 8.52207486950899),
                new Coordinate(49.46953806049912, 8.522167310746859),
                new Coordinate(49.46980903192609, 8.522250078348701),
                new Coordinate(49.46998702932054, 8.52231800714184),
                new Coordinate(49.470183537691966, 8.522393605314573),
                new Coordinate(49.47034444613642, 8.522470299116806),
                new Coordinate(49.47059933541707, 8.522618208582449),
                new Coordinate(49.470993058429805, 8.522834046841716),
                new Coordinate(49.47110175380304, 8.522919468726789),
                new Coordinate(49.471205461232344, 8.52301736935218),
                new Coordinate(49.47130097844681, 8.523142346003443),
                new Coordinate(49.47162804258328, 8.523514857909085),
                new Coordinate(49.47169793614156, 8.5235342883046),
                new Coordinate(49.47175806831562, 8.523486679096361),
                new Coordinate(49.47178944159453, 8.523435717126976),
                new Coordinate(49.47180469248674, 8.52338810791874),
                new Coordinate(49.471902761969595, 8.522452477768812),
                new Coordinate(49.47185570215259, 8.522245947682366),
                new Coordinate(49.47184698736668, 8.522156093683718),
                new Coordinate(49.47181561412465, 8.52209172066976),
                new Coordinate(49.471752867580264, 8.522003207775569),
                new Coordinate(49.46970603571891, 8.520579809345847),
                new Coordinate(49.46927712089944, 8.520240060552776),
                new Coordinate(49.4691768954883, 8.520177028645225),
                new Coordinate(49.469055753200955, 8.52011265563127),
                new Coordinate(49.46895116969033, 8.52008046912429),
                new Coordinate(49.4688631450546, 8.52006974029393),
                new Coordinate(49.46874897426213, 8.520089856860793),
                new Coordinate(49.46857815333928, 8.52017300534761),
                new Coordinate(49.46837421329857, 8.520360759971652),
                new Coordinate(49.468258298275636, 8.520494870430497),
                new Coordinate(49.46813105290366, 8.520575336697943),
                new Coordinate(49.46796994061059, 8.520668648649174),
                new Coordinate(49.467790328896974, 8.520711670867918),
                new Coordinate(49.467622084302675, 8.520751499638276),
                new Coordinate(49.467457536825776, 8.520823570755386),
                new Coordinate(49.46732503565252, 8.520910814728552),
                new Coordinate(49.46717096407025, 8.521108061972228),
                new Coordinate(49.467122532277955, 8.521222911595034),
                new Coordinate(49.4670353716169, 8.521453699893994),
        }));

        GeometryFactory luisenparkHaupteingangGeo = new GeometryFactory();
        Polygon luisenparkHaupteingangPoly = luisenparkHaupteingangGeo.createPolygon(luisenparkHaupteingangGeo.createLinearRing(new Coordinate[]{}));

        GeometryFactory luisenparkEingangFernmeldeturmGeo = new GeometryFactory();
        Polygon luisenparkEingangFernmeldeturmPoly = luisenparkEingangFernmeldeturmGeo.createPolygon(luisenparkEingangFernmeldeturmGeo.createLinearRing(new Coordinate[]{}));

        GeometryFactory spinelliParkHaupteingangGeo = new GeometryFactory();
        Polygon spinelliParkHaupteingangPoly = spinelliParkHaupteingangGeo.createPolygon(spinelliParkHaupteingangGeo.createLinearRing(new Coordinate[]{}));

        GeometryFactory spinelliParkEingangParkschaleGeo = new GeometryFactory();
        Polygon spinelliParkEingangParkschalePoly = spinelliParkEingangParkschaleGeo.createPolygon(spinelliParkEingangParkschaleGeo.createLinearRing(new Coordinate[]{}));

        return args -> {
            carRepo.save(new CarParkingLot(c1Poly, 49.48670372470029, 8.464163607570061, "C1 Hauptverwaltung MPB, Parkhaus", true, AccessRight.VISITOR, true, ParkingStatus.AVAILABLE, ParkingType.CAR));
            // TODO "Collini-Center, Tiefgarage" nochmal anschauen -> Webseite war in Wartungsarbeiten
            // allRepo.save(new CarParkingLot(polygon, null, null, "Collini-Center, Tiefgarage", true, AccessRight.VISITOR, true, ParkingStatus.AVAILABLE, ParkingType.CAR));
            carRepo.save(new CarParkingLot(colliniCenterMuldePoly, 49.49075408061332, 8.478267019395627, "Collini-Center Mulde, Parkplatz", false, AccessRight.VISITOR, false, ParkingStatus.AVAILABLE, ParkingType.CAR));
            carRepo.save(new CarParkingLot(d3Poly, 49.4879110562813, 8.463559501710186, "D3, Tiefgarage", true, AccessRight.VISITOR, false, ParkingStatus.AVAILABLE, ParkingType.CAR));
            carRepo.save(new CarParkingLot(d5Poly, 49.48840258589768, 8.462012476971653, "D5 Reiß-Museum, Tiefgarage", true, AccessRight.VISITOR, true, ParkingStatus.AVAILABLE, ParkingType.CAR));
            carRepo.save(new CarParkingLot(g1Poly, 49.49017774981759, 8.467326004459226, "G1 Marktplatz, Tiefgarage", false, AccessRight.VISITOR, true, ParkingStatus.AVAILABLE, ParkingType.CAR));
            carRepo.save(new CarParkingLot(h6Poly, 49.492302393034954, 8.463884183978568, "H6, Tiefgarage", false, AccessRight.VISITOR, false, ParkingStatus.AVAILABLE, ParkingType.CAR));
            carRepo.save(new CarParkingLot(p1Poly, 49.48091242621506, 8.471008262790422, "Hauptbahnhof P1 , Tiefgarage", true, AccessRight.VISITOR, false, ParkingStatus.AVAILABLE, ParkingType.CAR));
            carRepo.save(new CarParkingLot(p2Poly, 49.47810296964162, 8.472913116529053, "Hauptbahnhof P2, Parkhaus", true, AccessRight.VISITOR, false, ParkingStatus.AVAILABLE, ParkingType.CAR));
            carRepo.save(new CarParkingLot(p3Poly, 49.47943310412634, 8.474430709912857, "Hauptbahnhof P3, Parkhaus", true, AccessRight.VISITOR, true, ParkingStatus.AVAILABLE, ParkingType.CAR));
            carRepo.save(new CarParkingLot(p5Poly, 49.477339431515155, 8.469362153107816, "Hauptbahnhof P5, Parkhaus", true, AccessRight.VISITOR, true, ParkingStatus.AVAILABLE, ParkingType.CAR));
            carRepo.save(new CarParkingLot(klinikumPoly, 49.49013345858847, 8.490011035470456, "Klinikum, Tiefgarage", true, AccessRight.VISITOR, false, ParkingStatus.AVAILABLE, ParkingType.CAR));
            carRepo.save(new CarParkingLot(kunsthallePoly, 49.48443764466305, 8.475898516530139, "Kunsthalle, Tiefgarage", true, AccessRight.VISITOR, true, ParkingStatus.AVAILABLE, ParkingType.CAR));
            carRepo.save(new CarParkingLot(klinikumP3Poly, 49.48950663949485, 8.492225870581493, "Klinikum P3, Parkplatz", false, AccessRight.VISITOR, false, ParkingStatus.AVAILABLE, ParkingType.CAR));
            carRepo.save(new CarParkingLot(m4aPoly, 49.484289619483214, 8.467058337801216, "M4a, Parkplatz", false, AccessRight.VISITOR, false, ParkingStatus.AVAILABLE, ParkingType.CAR));
            carRepo.save(new CarParkingLot(n1Poly, 49.485791241035606, 8.4646044171931, "N1, Parkhaus", true, AccessRight.VISITOR, true, ParkingStatus.AVAILABLE, ParkingType.CAR));
            carRepo.save(new CarParkingLot(n2Poly, 49.48562986289634, 8.466035848816876, "N2 Stadthaus, Parkhaus", true, AccessRight.VISITOR, true, ParkingStatus.AVAILABLE, ParkingType.CAR));
            carRepo.save(new CarParkingLot(n6KomfortPoly, 49.48484219488636, 8.470228049013805, "N6 Komforthaus, Parkhaus", false, AccessRight.VISITOR, false, ParkingStatus.AVAILABLE, ParkingType.CAR));
            carRepo.save(new CarParkingLot(n6StandardPoly, 49.484824917464934, 8.469293288064907, "N6 Standardhaus, Parkhaus", true, AccessRight.VISITOR, true, ParkingStatus.AVAILABLE, ParkingType.CAR));
            carRepo.save(new CarParkingLot(u2Poly, 49.49157386839632, 8.471817003175763, "U2, Tiefgarage", true, AccessRight.VISITOR, true, ParkingStatus.AVAILABLE, ParkingType.CAR));
            carRepo.save(new CarParkingLot(sap1Poly, 49.46099304022919, 8.516293830056059, "SAP Arena P1, Parkhaus", true, AccessRight.VISITOR, true, ParkingStatus.AVAILABLE, ParkingType.CAR));
            carRepo.save(new CarParkingLot(sap2Poly, 49.46237835883444, 8.51694056641826, "SAP Arena P2, Parkhaus", true, AccessRight.VISITOR, true, ParkingStatus.AVAILABLE, ParkingType.CAR));
            carRepo.save(new CarParkingLot(sap3Poly, 49.46519123847139, 8.522292420707142, "SAP Arena P3, Parkhaus", true, AccessRight.VISITOR, true, ParkingStatus.AVAILABLE, ParkingType.CAR));
            carRepo.save(new CarParkingLot(sap6_8Poly, 49.470033156114305, 8.521692923027938, "SAP Arena P6-P8, Parkplatz", true, AccessRight.VISITOR, true, ParkingStatus.AVAILABLE, ParkingType.CAR));

            bikeRepo.save(new BikeParkingLot(luisenparkHaupteingangPoly, 49.47889164849036, 8.496487538126075, "Luisenpark Haupteingang, Fahradstellplatz", false, AccessRight.VISITOR, false, ParkingStatus.AVAILABLE, ParkingType.BIKE));
            bikeRepo.save(new BikeParkingLot(luisenparkEingangFernmeldeturmPoly, 49.48656250272681, 8.491967148636943, "Luisenpark Eingang Fernmeldeturm, Fahradstellplatz", false, AccessRight.VISITOR, false, ParkingStatus.AVAILABLE, ParkingType.BIKE));
            bikeRepo.save(new BikeParkingLot(spinelliParkHaupteingangPoly, 49.49680515429167, 8.523504189420152, "Spinelli Park, Fahrradabstellung Haupteingang", false, AccessRight.VISITOR, false, ParkingStatus.AVAILABLE, ParkingType.BIKE));
            bikeRepo.save(new BikeParkingLot(spinelliParkEingangParkschalePoly, 49.50456629500593, 8.516429628068975, "Spinelli Park, Fahrradabstellung Eingang Parkschale", false, AccessRight.VISITOR, false, ParkingStatus.AVAILABLE, ParkingType.BIKE));
        };
    }

}
