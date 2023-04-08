package de.hhn.se.labswp.buga23publictransport;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Polygon;
import org.springframework.data.geo.Point;
import de.hhn.se.labswp.buga23publictransport.business.ParkingType;
import de.hhn.se.labswp.buga23publictransport.persistence.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class ParkingLotInit {

    @Bean
    CommandLineRunner initializeParkingLots(BikeParkingLotRepository bikeRepo, CarParkingLotRepository carRepo) {
        //Auto
        //Mit Info zur Auslastung: https://parken-mannheim.de/
        GeometryFactory c1Geo = new GeometryFactory();
        Polygon c1Poly = c1Geo.createPolygon(c1Geo.createLinearRing(new Coordinate[]{
                new Coordinate(49.4868387, 8.4643446),
                new Coordinate(49.4868586, 8.46436270),
                new Coordinate(49.4869681, 8.4644628),
                new Coordinate(49.4870857, 8.4645703),
                new Coordinate(49.4870575, 8.4646433),
                new Coordinate(49.4870263, 8.4647244),
                new Coordinate(49.4869707, 8.4648684),
                new Coordinate(49.4868804, 8.4647858),
                new Coordinate(49.4867950, 8.4647078),
                new Coordinate(49.4868030, 8.4646871),
                new Coordinate(49.4867616, 8.4646492),
                new Coordinate(49.4867318, 8.4646220),
                new Coordinate(49.4867786, 8.4645005),
                new Coordinate(49.4866156, 8.4643514),
                new Coordinate(49.4864937, 8.4642401),
                new Coordinate(49.4865312, 8.4641428),
                new Coordinate(49.4865058, 8.4641195),
                new Coordinate(49.4865466, 8.4640137),
                new Coordinate(49.4868570, 8.4642974),
                new Coordinate(49.4868387, 8.4643446)
        }));
        Point c1GeoLocation = new Point(49.486712989660845, 8.464162980407481);
        List<Point> c1Entrances = new ArrayList<>();
        c1Entrances.add(new Point(49.48673226883311, 8.464151615591579));

        GeometryFactory colliniCenterMuldeGeo = new GeometryFactory();
        Polygon colliniCenterMuldePoly = colliniCenterMuldeGeo.createPolygon(colliniCenterMuldeGeo.createLinearRing(new Coordinate[]{
                new Coordinate(49.4911516, 8.4781802),
                new Coordinate(49.4909744, 8.4787881),
                new Coordinate(49.4902015, 8.4782498),
                new Coordinate(49.4901807, 8.4781470),
                new Coordinate(49.4902706, 8.4778341),
                new Coordinate(49.4903806, 8.4779074),
                new Coordinate(49.4904004, 8.4779501),
                new Coordinate(49.4903896, 8.4779831),
                new Coordinate(49.4909142, 8.4779174),
                new Coordinate(49.4909658, 8.4779523),
                new Coordinate(49.4910321, 8.4780853),
                new Coordinate(49.4911516, 8.4781802)
        }));
        Point colliniCenterMuldeGeoLocation = new Point(49.490775510160645, 8.478265606351393);
        List<Point> colliniCenterMuldeEntrances = new ArrayList<>();
        colliniCenterMuldeEntrances.add(new Point(49.491107109344746, 8.478143980506028));
        colliniCenterMuldeEntrances.add(new Point(49.49034444536021, 8.477880125348301));

        GeometryFactory d3Geo = new GeometryFactory();
        Polygon d3Poly = d3Geo.createPolygon(d3Geo.createLinearRing(new Coordinate[]{
                new Coordinate(49.4878709813945, 8.463519939128693),
                new Coordinate(49.48784876595397, 8.463584982694876),
                new Coordinate(49.48790277994865, 8.463643320738775),
                new Coordinate(49.487930658116134, 8.463566877784702),
                new Coordinate(49.4878709813945, 8.463519939128693)
        }));
        Point d3GeoLocation = new Point(49.4878342, 8.4635585);
        List<Point> d3Entrances = new ArrayList<>();
        d3Entrances.add(new Point(49.487821456426374, 8.463594250135488));

        GeometryFactory d5Geo = new GeometryFactory();
        Polygon d5Poly = d5Geo.createPolygon(d5Geo.createLinearRing(new Coordinate[]{}));
        Point d5GeoLocation = new Point(49.4884564, 8.4621187);
        List<Point> d5Entrances = new ArrayList<>();
        d5Entrances.add(new Point(49.4884564, 8.4621187));

        GeometryFactory g1Geo = new GeometryFactory();
        Polygon g1Poly = g1Geo.createPolygon(g1Geo.createLinearRing(new Coordinate[]{
                new Coordinate(49.4901047, 8.4673278),
                new Coordinate(49.4898536, 8.4679967),
                new Coordinate(49.4897542, 8.4679051),
                new Coordinate(49.4897154, 8.4678694),
                new Coordinate(49.4893920, 8.4675718),
                new Coordinate(49.4893513, 8.4675375),
                new Coordinate(49.4892975, 8.4674878),
                new Coordinate(49.4895041, 8.4669152),
                new Coordinate(49.4894980, 8.4668860),
                new Coordinate(49.4895007, 8.4668443),
                new Coordinate(49.4895149, 8.4668047),
                new Coordinate(49.4895339, 8.4667943),
                new Coordinate(49.4895583, 8.4668109),
                new Coordinate(49.4896088, 8.4668766),
                new Coordinate(49.4896464, 8.4669089),
                new Coordinate(49.4897229, 8.4669697),
                new Coordinate(49.4898736, 8.4671067),
                new Coordinate(49.4899153, 8.4671469),
                new Coordinate(49.4899653, 8.4671952),
                new Coordinate(49.4900341, 8.4672617),
                new Coordinate(49.4901047, 8.4673278)
        }));
        Point g1GeoLocation = new Point(49.49017904887094, 8.467323698760266);
        List<Point> g1Entrances = new ArrayList<>();
        g1Entrances.add(new Point(49.49016465068107, 8.46734579223191));
        g1Entrances.add(new Point(49.48974040908255, 8.466944778693932));

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
        Point h6GeoLocation = new Point(49.4922900, 8.4638865);
        List<Point> h6Entrances = new ArrayList<>();
        h6Entrances.add(new Point(49.49253822776612, 8.463997136165622));

        GeometryFactory p1Geo = new GeometryFactory();
        Polygon p1Poly = p1Geo.createPolygon(p1Geo.createLinearRing(new Coordinate[]{}));
        Point p1GeoLocation = new Point(49.480911816691524, 8.47100677221934);
        List<Point> p1Entrances = new ArrayList<>();
        p1Entrances.add(new Point(49.4805267, 8.4705992));

        GeometryFactory p2Geo = new GeometryFactory();
        Polygon p2Poly = p2Geo.createPolygon(p2Geo.createLinearRing(new Coordinate[]{
            new Coordinate(49.4783738, 8.4723772),
            new Coordinate(49.4783787, 8.4723674),
            new Coordinate(49.4783993, 8.4723727),
            new Coordinate(49.4784186, 8.4723707),
            new Coordinate(49.4784372, 8.4723620),
            new Coordinate(49.4784539, 8.4723468),
            new Coordinate(49.4784679, 8.4723262),
            new Coordinate(49.4784784, 8.4723011),
            new Coordinate(49.4784849, 8.4722729),
            new Coordinate(49.4784870, 8.4722432),
            new Coordinate(49.4784845, 8.4722136),
            new Coordinate(49.4784777, 8.4721856),
            new Coordinate(49.4784668, 8.4721609),
            new Coordinate(49.4784526, 8.4721406),
            new Coordinate(49.4784357, 8.4721260),
            new Coordinate(49.4784170, 8.4721178),
            new Coordinate(49.4783976, 8.4721165),
            new Coordinate(49.4783786, 8.4721220),
            new Coordinate(49.4783608, 8.4721342),
            new Coordinate(49.4783455, 8.4721524),
            new Coordinate(49.4783332, 8.4721756),
            new Coordinate(49.4783248, 8.4722024),
            new Coordinate(49.4783206, 8.4722316),
            new Coordinate(49.4783209, 8.4722615),
            new Coordinate(49.4783257, 8.4722904),
            new Coordinate(49.4783348, 8.4723156),
            new Coordinate(49.4783296, 8.4723260),
            new Coordinate(49.4782896, 8.4722788),
            new Coordinate(49.4777216, 8.4734186),
            new Coordinate(49.4777629, 8.4734673),
            new Coordinate(49.4777576, 8.4734780),
            new Coordinate(49.4777349, 8.4734710),
            new Coordinate(49.4777117, 8.4734745),
            new Coordinate(49.4776900, 8.4734877),
            new Coordinate(49.4776715, 8.4735096),
            new Coordinate(49.4776577, 8.4735385),
            new Coordinate(49.4776496, 8.4735721),
            new Coordinate(49.4776479, 8.4736079),
            new Coordinate(49.4776526, 8.4736430),
            new Coordinate(49.4776635, 8.4736747),
            new Coordinate(49.4776797, 8.4737006),
            new Coordinate(49.4776998, 8.4737186),
            new Coordinate(49.4777224, 8.4737273),
            new Coordinate(49.4777457, 8.4737260),
            new Coordinate(49.4777679, 8.4737149),
            new Coordinate(49.4777872, 8.4736948),
            new Coordinate(49.4778021, 8.4736673),
            new Coordinate(49.4778116, 8.4736345),
            new Coordinate(49.4778147, 8.4735990),
            new Coordinate(49.4778114, 8.4735635),
            new Coordinate(49.4778011, 8.4735293),
            new Coordinate(49.4778062, 8.4735191),
            new Coordinate(49.4778480, 8.4735685),
            new Coordinate(49.4784166, 8.4724276),
            new Coordinate(49.4783738, 8.4723772)
        }));
        Point p2GeoLocation = new Point(49.47811394797251, 8.472875549995567);
        List<Point> p2Entrances = new ArrayList<>();
        p2Entrances.add(new Point(49.477850939264385, 8.473612154181021));

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
                new Coordinate(49.47943695108108, 8.474396064303393)
        }));
        Point p3GeoLocation = new Point(49.4795222, 8.4746602);
        List<Point> p3Entrances = new ArrayList<>();
        p3Entrances.add(new Point(49.47952918214344, 8.474669873401869));

        GeometryFactory p5Geo = new GeometryFactory();
        Polygon p5Poly = p5Geo.createPolygon(p5Geo.createLinearRing(new Coordinate[]{
                new Coordinate(49.4773351, 8.4692846),
                new Coordinate(49.4774008, 8.4693649),
                new Coordinate(49.4777014, 8.4697396),
                new Coordinate(49.4776844, 8.4697719),
                new Coordinate(49.4775216, 8.4700811),
                new Coordinate(49.4772163, 8.4697004),
                new Coordinate(49.4771559, 8.4696250),
                new Coordinate(49.4771833, 8.4695729),
                new Coordinate(49.4773157, 8.4693215),
                new Coordinate(49.4773351, 8.4692846)
        }));
        Point p5GeoLocation = new Point(49.47746453300603, 8.469683377097663);
        List<Point> p5Entrances = new ArrayList<>();
        p5Entrances.add(new Point(49.4774008, 8.4693649));

        GeometryFactory klinikumGeo = new GeometryFactory();
        Polygon klinikumPoly = klinikumGeo.createPolygon(klinikumGeo.createLinearRing(new Coordinate[]{}));
        Point klinikumGeoLocation = new Point(49.49013186211727, 8.490012700986755);
        List<Point> klinikumEntrances = new ArrayList<>();
        klinikumEntrances.add(new Point(49.4901331, 8.4899871));

        GeometryFactory kunsthalleGeo = new GeometryFactory();
        Polygon kunsthallePoly = kunsthalleGeo.createPolygon(kunsthalleGeo.createLinearRing(new Coordinate[]{}));
        Point kunsthalleGeoLocation = new Point(49.4844108, 8.4754868);
        List<Point> kunsthalleEntrances = new ArrayList<>();
        kunsthalleEntrances.add(new Point(49.484416798120535, 8.475879034851713));

        GeometryFactory klinikumP3Geo = new GeometryFactory();
        Polygon klinikumP3Poly = klinikumP3Geo.createPolygon(klinikumP3Geo.createLinearRing(new Coordinate[]{
                new Coordinate(49.4898850, 8.4912837),
                new Coordinate(49.4898020, 8.4911638),
                new Coordinate(49.4898212, 8.4907328),
                new Coordinate(49.4897651, 8.4906766),
                new Coordinate(49.4892435, 8.4924354),
                new Coordinate(49.4891578, 8.4930335),
                new Coordinate(49.4892038, 8.4930498),
                new Coordinate(49.4894648, 8.4930698),
                new Coordinate(49.4895771, 8.4923315),
                new Coordinate(49.4898850, 8.4912837)
        }));
        Point klinikumP3GeoLocation = new Point(49.489517541764336, 8.492225810093881);
        List<Point> klinikumP3Entrances = new ArrayList<>();
        klinikumP3Entrances.add(new Point(49.48988122684213, 8.49081330659882));

        GeometryFactory m4aGeo = new GeometryFactory();
        Polygon m4aPoly = m4aGeo.createPolygon(m4aGeo.createLinearRing(new Coordinate[]{
                new Coordinate(49.4842682, 8.4665333),
                new Coordinate(49.4844858, 8.4667326),
                new Coordinate(49.4845534, 8.4667944),
                new Coordinate(49.4843019, 8.4674451),
                new Coordinate(49.4840168, 8.4671840),
                new Coordinate(49.4842682, 8.4665333)
        }));
        Point m4aGeoLocation = new Point(49.48428953810552, 8.467057661834946);
        List<Point> m4aEntrances = new ArrayList<>();
        m4aEntrances.add(new Point(49.48447617901476, 8.466752297282996));

        GeometryFactory n1Geo = new GeometryFactory();
        Polygon n1Poly = n1Geo.createPolygon(n1Geo.createLinearRing(new Coordinate[]{}));
        Point n1GeoLocation = new Point(49.48580044701165, 8.464616929028745);
        List<Point> n1Entrances = new ArrayList<>();
        n1Entrances.add(new Point(49.4858763, 8.4646061));

        GeometryFactory n2Geo = new GeometryFactory();
        Polygon n2Poly = n2Geo.createPolygon(n2Geo.createLinearRing(new Coordinate[]{
                new Coordinate(49.4854709, 8.4663515),
                new Coordinate(49.4856330, 8.4659343),
                new Coordinate(49.4856548, 8.4658783),
                new Coordinate(49.4856717, 8.4658347),
                new Coordinate(49.4857546, 8.4656214),
                new Coordinate(49.4860254, 8.4658707),
                new Coordinate(49.4859379, 8.660959),
                new Coordinate(49.4857940, 8.4664662),
                new Coordinate(49.4857416, 8.4666009),
                new Coordinate(49.4854709, 8.4663515)
        }));
        Point n2GeoLocation = new Point(49.485775944669406, 8.466097373048717);
        List<Point> n2Entrances = new ArrayList<>();
        n2Entrances.add(new Point(49.485635424818284, 8.465854056585018));

        GeometryFactory n6KomfortGeo = new GeometryFactory();
        Polygon n6KomfortPoly = n6KomfortGeo.createPolygon(n6KomfortGeo.createLinearRing(new Coordinate[]{}));
        Point n6KomfortGeoLocation = new Point(49.4848553, 8.4701419);
        List<Point> n6KomfortEntrances = new ArrayList<>();
        n6KomfortEntrances.add(new Point(49.484808667022044, 8.470252024510945));

        GeometryFactory n6StandardGeo = new GeometryFactory();
        Polygon n6StandardPoly = n6StandardGeo.createPolygon(n6StandardGeo.createLinearRing(new Coordinate[]{
                new Coordinate(49.4845636, 8.4699707),
                new Coordinate(49.4847438, 8.4701600),
                new Coordinate(49.4850171, 8.4694828),
                new Coordinate(49.4850351, 8.4694382),
                new Coordinate(49.4848790, 8.4692934),
                new Coordinate(49.4848288, 8.4692468),
                new Coordinate(49.4847966, 8.4692169),
                new Coordinate(49.4845513, 8.4698441),
                new Coordinate(49.4845199, 8.4699244),
                new Coordinate(49.4845636, 8.4699707)
        }));
        Point n6StandardGeoLocation = new Point(49.48481035971088, 8.469710472562634);
        List<Point> n6StandardEntrances = new ArrayList<>();
        n6StandardEntrances.add(new Point( 49.4845636, 8.4699707));

        GeometryFactory u2Geo = new GeometryFactory();
        Polygon u2Poly = u2Geo.createPolygon(u2Geo.createLinearRing(new Coordinate[]{
                new Coordinate(49.4912155, 8.4714973),
                new Coordinate(49.4913544, 8.4710909),
                new Coordinate(49.4913709, 8.4710426),
                new Coordinate(49.4913876, 8.4709938),
                new Coordinate(49.4914351, 8.4710323),
                new Coordinate(49.4916688, 8.4712216),
                new Coordinate(49.4917936, 8.4713227),
                new Coordinate(49.4916215, 8.4718262),
                new Coordinate(49.4914861, 8.4717166),
                new Coordinate(49.4912155, 8.4714973)
        }));
        Point u2GeoLocation = new Point(49.491591608450804, 8.471383015016409);
        List<Point> u2Entrances = new ArrayList<>();
        u2Entrances.add(new Point( 49.4915272, 8.4717766));

        GeometryFactory sap1Geo = new GeometryFactory();
        Polygon sap1Poly = sap1Geo.createPolygon(sap1Geo.createLinearRing(new Coordinate[]{
                new Coordinate(49.4616816, 8.5166013),
                new Coordinate(49.4604116, 8.5154781),
                new Coordinate(49.4604101, 8.5155553),
                new Coordinate(49.4604233, 8.5156308),
                new Coordinate(49.4603812, 8.5156776),
                new Coordinate(49.4603762, 8.5157144),
                new Coordinate(49.4603733, 8.5157950),
                new Coordinate(49.4603421, 8.5158301),
                new Coordinate(49.4602985, 8.5158761),
                new Coordinate(49.4603219, 8.5159357),
                new Coordinate(49.4602777, 8.5159865),
                new Coordinate(49.4602306, 8.5159999),
                new Coordinate(49.4602261, 8.5160822),
                new Coordinate(49.4615788, 8.5172819),
                new Coordinate(49.4615829, 8.5171963),
                new Coordinate(49.4615268, 8.5170397),
                new Coordinate(49.4615445, 8.5170208),
                new Coordinate(49.4615886, 8.5170149),
                new Coordinate(49.4616293, 8.5169754),
                new Coordinate(49.4616408, 8.5169216),
                new Coordinate(49.4616447, 8.5168377),
                new Coordinate(49.4616700, 8.5168165),
                new Coordinate(49.4617145, 8.5167733),
                new Coordinate(49.4616761, 8.5166800),
                new Coordinate(49.4616816, 8.5166013)
        }));
        Point sapP1GeoLocation = new Point(49.460976750297164, 8.516334236860832);
        List<Point> sapP1Entrances = new ArrayList<>();
        sapP1Entrances.add(new Point(49.46169018798026, 8.516733848853205));
        sapP1Entrances.add(new Point(49.461623070164066, 8.51693903783539));
        sapP1Entrances.add(new Point(49.46153067405889, 8.517097288161523));

        GeometryFactory sap2Geo = new GeometryFactory();
        Polygon sap2Poly = sap2Geo.createPolygon(sap2Geo.createLinearRing(new Coordinate[]{
                new Coordinate(49.4630248, 8.5159457),
                new Coordinate(49.4629866, 8.5159630),
                new Coordinate(49.4629486, 8.5159801),
                new Coordinate(49.4629432, 8.5159826),
                new Coordinate(49.4629043, 8.5159996),
                new Coordinate(49.4628675, 8.5160176),
                new Coordinate(49.4621030, 8.5163814),
                new Coordinate(49.4618885, 8.5169473),
                new Coordinate(49.4618733, 8.5169639),
                new Coordinate(49.4618692, 8.5169683),
                new Coordinate(49.4618242, 8.5170174),
                new Coordinate(49.4616566, 8.5172018),
                new Coordinate(49.4620863, 8.5173905),
                new Coordinate(49.4623033, 8.5174872),
                new Coordinate(49.4623546, 8.5174941),
                new Coordinate(49.4623884, 8.5174819),
                new Coordinate(49.4624211, 8.5174569),
                new Coordinate(49.4624597, 8.5174107),
                new Coordinate(49.4624908, 8.5173566),
                new Coordinate(49.4630248, 8.5159457)
        }));
        Point sapP2GeoLocation = new Point(49.46238822591226, 8.516767598240891);
        List<Point> sapP2Entrances = new ArrayList<>();
        sapP2Entrances.add(new Point(49.4629043, 8.5159996));

        GeometryFactory sap3Geo = new GeometryFactory();
        Polygon sap3Poly = sap3Geo.createPolygon(sap3Geo.createLinearRing(new Coordinate[]{
                new Coordinate(49.4648401, 8.5209588),
                new Coordinate(49.4648645, 8.5209118),
                new Coordinate(49.4648739, 8.5208942),
                new Coordinate(49.4648842, 8.5208870),
                new Coordinate(49.4648972, 8.5208878),
                new Coordinate(49.4651502, 8.5210354),
                new Coordinate(49.4651715, 8.5210634),
                new Coordinate(49.4651772, 8.5210729),
                new Coordinate(49.4651782, 8.5210937),
                new Coordinate(49.4651731, 8.5211120),
                new Coordinate(49.4651534, 8.5211659),
                new Coordinate(49.4650618, 8.5214171),
                new Coordinate(49.4651122, 8.5214199),
                new Coordinate(49.4645908, 8.5227963),
                new Coordinate(49.4645368, 8.5227907),
                new Coordinate(49.4645367, 8.5227964),
                new Coordinate(49.4645367, 8.5228071),
                new Coordinate(49.4645404, 8.5228224),
                new Coordinate(49.4646009, 8.5228765),
                new Coordinate(49.4646156, 8.5228805),
                new Coordinate(49.4646255, 8.5228731),
                new Coordinate(49.4646438, 8.5228500),
                new Coordinate(49.4646761, 8.5227676),
                new Coordinate(49.4646933, 8.5227016),
                new Coordinate(49.4647325, 8.5226080),
                new Coordinate(49.4647424, 8.5225877),
                new Coordinate(49.4647435, 8.5224799),
                new Coordinate(49.4647806, 8.5223733),
                new Coordinate(49.4647878, 8.5223570),
                new Coordinate(49.4649304, 8.5224833),

                new Coordinate(49.4649275, 8.5224914),
                new Coordinate(49.4649279, 8.5225365),
                new Coordinate(49.4649029, 8.5226070),
                new Coordinate(49.4648842, 8.5226279),
                new Coordinate(49.4648421, 8.5226860),
                new Coordinate(49.4647838, 8.5228530),
                new Coordinate(49.4647498, 8.5229330),
                new Coordinate(49.4647434, 8.5229619),
                new Coordinate(49.4647464, 8.5229867),
                new Coordinate(49.4647585, 8.5230093),
                new Coordinate(49.4648094, 8.5230623),
                new Coordinate(49.4648263, 8.5230601),
                new Coordinate(49.4648325, 8.5230544),
                new Coordinate(49.4648338, 8.5230475),
                new Coordinate(49.4648075, 8.5229826),
                new Coordinate(49.4654023, 8.5214164),
                new Coordinate(49.4654291, 8.5214806),
                new Coordinate(49.4654848, 8.5213286),
                new Coordinate(49.4655007, 8.5212895),
                new Coordinate(49.4655117, 8.5212816),
                new Coordinate(49.4655271, 8.5212793),
                new Coordinate(49.4655755, 8.5213087),
                new Coordinate(49.4659297, 8.5215231),
                new Coordinate(49.4660847, 8.5216198),
                new Coordinate(49.4660914, 8.5216374),
                new Coordinate(49.4660929, 8.5216597),
                new Coordinate(49.4660888, 8.5216757),
                new Coordinate(49.4659646, 8.5219988),
                new Coordinate(49.4659918, 8.5220687),
                new Coordinate(49.4657519, 8.5227007),

                new Coordinate(49.4657193, 8.5226463),
                new Coordinate(49.4657191, 8.5226802),
                new Coordinate(49.4657258, 8.5227169),
                new Coordinate(49.4657668, 8.5228095),
                new Coordinate(49.4657808, 8.5228478),
                new Coordinate(49.4657865, 8.5228757),
                new Coordinate(49.4657855, 8.5229252),
                new Coordinate(49.4657699, 8.5229706),
                new Coordinate(49.4657248, 8.5230935),
                new Coordinate(49.4657450, 8.5231119),
                new Coordinate(49.4656911, 8.5232563),
                new Coordinate(49.4656709, 8.5232419),
                new Coordinate(49.4656665, 8.5232523),
                new Coordinate(49.4656921, 8.5233195),
                new Coordinate(49.4655529, 8.5236879),
                new Coordinate(49.4655230, 8.5236188),
                new Coordinate(49.4655127, 8.5236576),
                new Coordinate(49.4655101, 8.5236847),
                new Coordinate(49.4655137, 8.5237007),
                new Coordinate(49.4655288, 8.5237175),
                new Coordinate(49.4655589, 8.5237438),
                new Coordinate(49.4655397, 8.5237949),
                new Coordinate(49.4654411, 8.5237055),
                new Coordinate(49.4645499, 8.5229170),
                new Coordinate(49.4641143, 8.5225293),
                new Coordinate(49.4640986, 8.5224995),
                new Coordinate(49.4640965, 8.5224732),
                new Coordinate(49.4641052, 8.5224517),
                new Coordinate(49.4640576, 8.5224468),
                new Coordinate(49.4643509, 8.5216669),
                new Coordinate(49.4644135, 8.5216773),
                new Coordinate(49.4644965, 8.5217443),
                new Coordinate(49.4645037, 8.5217213),
                new Coordinate(49.4647912, 8.5209567),
                new Coordinate(49.4648401, 8.5209588)
        }));
        Point sapP3GeoLocation = new Point(49.46517379460106, 8.522297204280871);
        List<Point> sapP3Entrances = new ArrayList<>();
        sapP3Entrances.add(new Point(49.4648652, 8.5223481));

        GeometryFactory sap6Geo = new GeometryFactory();
        Polygon sap6Poly = sap6Geo.createPolygon(sap6Geo.createLinearRing(new Coordinate[]{
                new Coordinate(49.4692492, 8.5220839),
                new Coordinate(49.4680719, 8.5218610),
                new Coordinate(49.4680856, 8.5217519),
                new Coordinate(49.4681498, 8.5209893),
                new Coordinate(49.4681794, 8.5207443),
                new Coordinate(49.4682188, 8.5207044),
                new Coordinate(49.4682320, 8.5206570),
                new Coordinate(49.4682577, 8.5205950),
                new Coordinate(49.4683090, 8.5205420),
                new Coordinate(49.4684180, 8.5204538),
                new Coordinate(49.4685799, 8.5203072),
                new Coordinate(49.4687918, 8.5202214),
                new Coordinate(49.4689647, 8.5201956),
                new Coordinate(49.4692157, 8.5203158),
                new Coordinate(49.4694165, 8.5205046),
                new Coordinate(49.4692492, 8.5220839)
        }));
        Point sapP6GeoLocation = new Point(49.468819898991505, 8.521137693444624);
        List<Point> sapP6Entrances = new ArrayList<>();
        sapP6Entrances.add(new Point(49.46804233453952, 8.521807889630427));
        sapP6Entrances.add(new Point(49.47183045528626, 8.522287051208613));

        GeometryFactory sap7Geo = new GeometryFactory();
        Polygon sap7Poly = sap7Geo.createPolygon(sap7Geo.createLinearRing(new Coordinate[]{
            new Coordinate(49.4702922, 8.5224101),
            new Coordinate(49.4696006, 8.5222041),
            new Coordinate(49.4697735, 8.5207278),
            new Coordinate(49.4704428, 8.5212428),
            new Coordinate(49.4702922, 8.5224101)
        }));
        Point sapP7GeoLocation = new Point(49.47008494537713, 8.521661543704857);
        List<Point> sapP7Entrances = new ArrayList<>();
        sapP7Entrances.add(new Point(49.47109831355622, 8.522932824444114));
        sapP7Entrances.add(new Point(49.47183045528626, 8.522287051208613));

        GeometryFactory sap8Geo = new GeometryFactory();
        Polygon sap8Poly = sap8Geo.createPolygon(sap8Geo.createLinearRing(new Coordinate[]{
                new Coordinate(49.4705507, 8.5213083),
                new Coordinate(49.4704112, 8.5222686),
                new Coordinate(49.4717574, 8.5232001),
                new Coordinate(49.4718335, 8.5223544),
                new Coordinate(49.4717708, 8.5223490),
                new Coordinate(49.4718198, 8.5221409),
                new Coordinate(49.4716140, 8.5220164),
                new Coordinate(49.4715510, 8.5219826),
                new Coordinate(49.4705507, 8.5213083)
        }));
        Point sapP8GeoLocation = new Point(49.47113716559011, 8.522280643346296);
        List<Point> sapP8Entrances = new ArrayList<>();
        sapP8Entrances.add(new Point(49.47109831355622, 8.522932824444114));
        sapP8Entrances.add(new Point(49.47183045528626, 8.522287051208613));


        // Ohne Daten über Auslastung: https://parken-mannheim.de/parken
        GeometryFactory cityAirportGeo = new GeometryFactory();
        Polygon cityAirportPoly = cityAirportGeo.createPolygon(cityAirportGeo.createLinearRing(new Coordinate[]{
                new Coordinate(49.4763520, 8.5219878),
                new Coordinate(49.4763384, 8.5225448),
                new Coordinate(49.4761338, 8.5225329),
                new Coordinate(49.4761120, 8.5225317),
                new Coordinate(49.4760533, 8.5225283),
                new Coordinate(49.4760669, 8.5219712),
                new Coordinate(49.4763520, 8.5219878)
        }));
        Point cityAirportGeoLocation = new Point(49.47622436027289, 8.522268453159233);
        List<Point> cityAirportEntrances = new ArrayList<>();
        cityAirportEntrances.add(new Point(49.47625332185185, 8.52277822183503));

        GeometryFactory p4Geo = new GeometryFactory();
        Polygon p4Poly = p4Geo.createPolygon(p4Geo.createLinearRing(new Coordinate[]{
            new Coordinate(49.4792890, 8.4749200),
            new Coordinate(49.4793876, 8.4748023),
            new Coordinate(49.4793110, 8.4746504),
            new Coordinate(49.4792543, 8.4747181),
            new Coordinate(49.4789199, 8.4751173),
            new Coordinate(49.4790088, 8.4752938),
            new Coordinate(49.4793013, 8.4749445),
            new Coordinate(49.4792890, 8.4749200)
        }));
        Point p4GeoLocation = new Point(49.479168752802074, 8.474947441953104);
        List<Point> p4Entrances = new ArrayList<>();
        p4Entrances.add(new Point(49.47934783377337, 8.47489682568971));

        GeometryFactory lortzingblockGeo = new GeometryFactory();
        Polygon lortzingblockPoly = lortzingblockGeo.createPolygon(lortzingblockGeo.createLinearRing(new Coordinate[]{}));
        Point lortzingblockGeoLocation = new Point(49.4996465, 8.4711780);
        List<Point> lortzingblockEntrances = new ArrayList<>();
        lortzingblockEntrances.add(new Point(49.499586526290265, 8.471315723764372));

        GeometryFactory marchivumGeo = new GeometryFactory();
        Polygon marchivumPoly = marchivumGeo.createPolygon(marchivumGeo.createLinearRing(new Coordinate[]{
                new Coordinate(49.5004188, 8.4595820),
                new Coordinate(49.5004392, 8.4595302),
                new Coordinate(49.5003335, 8.4594315),
                new Coordinate(49.5001742, 8.4598360),
                new Coordinate(49.5002798, 8.4599347),
                new Coordinate(49.5003665, 8.4601029),
                new Coordinate(49.5007267, 8.4597415),
                new Coordinate(49.5006221, 8.4596459),
                new Coordinate(49.5005539, 8.4596917),
                new Coordinate(49.5004188, 8.4595820)
        }));
        Point marchivumGeoLocation = new Point(49.500287232674154, 8.45981282662794);
        List<Point> marchivumEntrances = new ArrayList<>();
        marchivumEntrances.add(new Point(49.50037112254051, 8.459345942526939));

        GeometryFactory musikparkGeo = new GeometryFactory();
        Polygon musikparkPoly = musikparkGeo.createPolygon(musikparkGeo.createLinearRing(new Coordinate[]{
                new Coordinate(49.4988265, 8.4571039),
                new Coordinate(49.4989449, 8.4572243),
                new Coordinate(49.4984293, 8.4584151),
                new Coordinate(49.4983723, 8.4585615),
                new Coordinate(49.4982976, 8.4587899),
                new Coordinate(49.4981642, 8.4587064),
                new Coordinate(49.4982529, 8.4584407),
                new Coordinate(49.4983066, 8.4583050),
                new Coordinate(49.4988265, 8.4571039)
        }));
        Point musikparkGeoLocation = new Point(49.49857137021193, 8.457915818297169);
        List<Point> musikparkEntrances = new ArrayList<>();
        musikparkEntrances.add(new Point(49.49871408931336, 8.457366758209504));

        GeometryFactory n7CinemaxxGeo = new GeometryFactory();
        Polygon n7CinemaxxPoly = n7CinemaxxGeo.createPolygon(n7CinemaxxGeo.createLinearRing(new Coordinate[]{
                new Coordinate(49.4841049, 8.4725910),
                new Coordinate(49.4842438, 8.4722333),
                new Coordinate(49.4842673, 8.4721739),
                new Coordinate(49.4838751, 8.4718122),
                new Coordinate(49.4838190, 8.4719564),
                new Coordinate(49.4837128, 8.4722292),
                new Coordinate(49.4841049, 8.4725910)
        }));
        Point n7CinemaxxGeoLocation = new Point(49.48420910079384, 8.472221026989292);
        List<Point> n7CinemaxxEntrances = new ArrayList<>();
        n7CinemaxxEntrances.add(new Point(49.48427905679231, 8.472228883880444));

        GeometryFactory roggenplatzGeo = new GeometryFactory();
        Polygon roggenPoly = roggenplatzGeo.createPolygon(roggenplatzGeo.createLinearRing(new Coordinate[]{
                new Coordinate(49.5275639, 8.4799765),
                new Coordinate(49.5273463, 8.4795658),
                new Coordinate(49.5269050, 8.4801230),
                new Coordinate(49.5270621, 8.4805870),
                new Coordinate(49.5275639, 8.4799765)
        }));
        Point roggenplatzGeoLocation = new Point(49.52723019609795, 8.480029254342357);
        List<Point> roggenplatzEntrances = new ArrayList<>();
        roggenplatzEntrances.add(new Point(49.527109810512265, 8.480432053293457));


        //Fahrad
        GeometryFactory luisenparkHaupteingangGeo = new GeometryFactory();
        Polygon luisenparkHaupteingangPoly = luisenparkHaupteingangGeo.createPolygon(luisenparkHaupteingangGeo.createLinearRing(new Coordinate[]{}));

        GeometryFactory luisenparkEingangFernmeldeturmGeo = new GeometryFactory();
        Polygon luisenparkEingangFernmeldeturmPoly = luisenparkEingangFernmeldeturmGeo.createPolygon(luisenparkEingangFernmeldeturmGeo.createLinearRing(new Coordinate[]{}));

        GeometryFactory spinelliParkHaupteingangGeo = new GeometryFactory();
        Polygon spinelliParkHaupteingangPoly = spinelliParkHaupteingangGeo.createPolygon(spinelliParkHaupteingangGeo.createLinearRing(new Coordinate[]{}));

        GeometryFactory spinelliParkEingangParkschaleGeo = new GeometryFactory();
        Polygon spinelliParkEingangParkschalePoly = spinelliParkEingangParkschaleGeo.createPolygon(spinelliParkEingangParkschaleGeo.createLinearRing(new Coordinate[]{}));

        return args -> {
            carRepo.save(new CarParkingLot(c1GeoLocation, c1Poly, c1Entrances, "C1 Hauptverwaltung MPB, Parkhaus", true, true, ParkingType.CAR));
            // TODO "Collini-Center, Tiefgarage" nochmal anschauen -> Webseite war in Wartungsarbeiten
            // allRepo.save(new CarParkingLot(polygon, null, null, "Collini-Center, Tiefgarage", true, true, ParkingType.CAR));
            carRepo.save(new CarParkingLot(colliniCenterMuldeGeoLocation, colliniCenterMuldePoly, colliniCenterMuldeEntrances, "Collini-Center Mulde, Parkplatz", false, false, ParkingType.CAR));
            carRepo.save(new CarParkingLot(d3GeoLocation, d3Poly, d3Entrances, "D3, Tiefgarage", true, false, ParkingType.CAR));
            carRepo.save(new CarParkingLot(d5GeoLocation, d5Poly, d5Entrances, "D5 Reiß-Museum, Tiefgarage", true, true, ParkingType.CAR));
            carRepo.save(new CarParkingLot(g1GeoLocation, g1Poly, g1Entrances, "G1 Marktplatz, Tiefgarage", false, true, ParkingType.CAR));
            carRepo.save(new CarParkingLot(h6GeoLocation, h6Poly, h6Entrances, "H6, Tiefgarage", false, false, ParkingType.CAR));
            carRepo.save(new CarParkingLot(p1GeoLocation, p1Poly, p1Entrances, "Hauptbahnhof P1 , Tiefgarage", true, false, ParkingType.CAR));
            carRepo.save(new CarParkingLot(p2GeoLocation, p2Poly, p2Entrances, "Hauptbahnhof P2, Parkhaus", true, false, ParkingType.CAR));
            carRepo.save(new CarParkingLot(p3GeoLocation, p3Poly, p3Entrances, "Hauptbahnhof P3, Parkhaus", true, true,ParkingType.CAR));
            carRepo.save(new CarParkingLot(p5GeoLocation, p5Poly, p5Entrances, "Hauptbahnhof P5, Parkhaus", true, true, ParkingType.CAR));
            carRepo.save(new CarParkingLot(klinikumGeoLocation, klinikumPoly, klinikumEntrances, "Klinikum, Tiefgarage", true, false, ParkingType.CAR));
            carRepo.save(new CarParkingLot(kunsthalleGeoLocation, kunsthallePoly, kunsthalleEntrances, "Kunsthalle, Tiefgarage", true, true, ParkingType.CAR));
            carRepo.save(new CarParkingLot(klinikumP3GeoLocation, klinikumP3Poly, klinikumP3Entrances, "Klinikum P3, Parkplatz", false, false, ParkingType.CAR));
            carRepo.save(new CarParkingLot(m4aGeoLocation, m4aPoly, m4aEntrances, "M4a, Parkplatz", false, false, ParkingType.CAR));
            carRepo.save(new CarParkingLot(n1GeoLocation, n1Poly, n1Entrances, "N1, Parkhaus", true, true, ParkingType.CAR));
            carRepo.save(new CarParkingLot(n2GeoLocation, n2Poly, n2Entrances, "N2 Stadthaus, Parkhaus", true, true, ParkingType.CAR));
            carRepo.save(new CarParkingLot(n6KomfortGeoLocation, n6KomfortPoly, n6KomfortEntrances, "N6 Komforthaus, Parkhaus", false, false, ParkingType.CAR));
            carRepo.save(new CarParkingLot(n6StandardGeoLocation, n6StandardPoly, n6StandardEntrances, "N6 Standardhaus, Parkhaus", true, true, ParkingType.CAR));
            carRepo.save(new CarParkingLot(u2GeoLocation, u2Poly, u2Entrances, "U2, Tiefgarage", true, true, ParkingType.CAR));
            carRepo.save(new CarParkingLot(sapP1GeoLocation, sap1Poly, sapP1Entrances,"SAP Arena P1, Parkplatz", true, true, ParkingType.CAR));
            carRepo.save(new CarParkingLot(sapP2GeoLocation, sap2Poly, sapP2Entrances, "SAP Arena P2, Parkplatz", true, true, ParkingType.CAR));
            carRepo.save(new CarParkingLot(sapP3GeoLocation, sap3Poly, sapP3Entrances, "SAP Arena P3, Parkplatz", true, true, ParkingType.CAR));
            carRepo.save(new CarParkingLot(sapP6GeoLocation, sap6Poly, sapP6Entrances, "SAP Arena P6, Parkplatz", true, true, ParkingType.CAR));
            carRepo.save(new CarParkingLot(sapP7GeoLocation, sap7Poly, sapP7Entrances, "SAP Arena P7, Parkplatz", true, true, ParkingType.CAR));
            carRepo.save(new CarParkingLot(sapP8GeoLocation, sap8Poly, sapP8Entrances, "SAP Arena P8, Parkplatz", true, true, ParkingType.CAR));
            carRepo.save(new CarParkingLot(cityAirportGeoLocation, cityAirportPoly, cityAirportEntrances, "City Airport, Parkhaus", false, false, ParkingType.CAR));
            carRepo.save(new CarParkingLot(p4GeoLocation, p4Poly, p4Entrances, "Hauptbahnhof P4, Parkplatz", false, true, ParkingType.CAR));
            carRepo.save(new CarParkingLot(lortzingblockGeoLocation, lortzingblockPoly, lortzingblockEntrances, "Lortzingblock, Parkhaus", true, false, ParkingType.CAR));
            carRepo.save(new CarParkingLot(marchivumGeoLocation, marchivumPoly, marchivumEntrances, "Marchivum, Parkplatz", false, true, ParkingType.CAR));
            carRepo.save(new CarParkingLot(musikparkGeoLocation, musikparkPoly, musikparkEntrances, "Musikpark, Parkplatz", false, false, ParkingType.CAR));
            carRepo.save(new CarParkingLot(n7CinemaxxGeoLocation, n7CinemaxxPoly, n7CinemaxxEntrances, "N7 CinemaxX, Parkhaus", true, false, ParkingType.CAR));
            carRepo.save(new CarParkingLot(roggenplatzGeoLocation, roggenPoly, roggenplatzEntrances, "Roggenplatz, Tiefgarage", false, false, ParkingType.CAR));

            // Auskommentiert da Daten fehlen
//            bikeRepo.save(new BikeParkingLot(luisenparkHaupteingangPoly, "Luisenpark Haupteingang, Fahradstellplatz", false, false, ParkingType.BIKE));
//            bikeRepo.save(new BikeParkingLot(luisenparkEingangFernmeldeturmPoly, "Luisenpark Eingang Fernmeldeturm, Fahradstellplatz", false, false, ParkingType.BIKE));
//            bikeRepo.save(new BikeParkingLot(spinelliParkHaupteingangPoly, "Spinelli Park, Fahrradabstellung Haupteingang", false, false, ParkingType.BIKE));
//            bikeRepo.save(new BikeParkingLot(spinelliParkEingangParkschalePoly, "Spinelli Park, Fahrradabstellung Eingang Parkschale", false, false, ParkingType.BIKE));
        };
    }

}
