package br.com.gabriel.api;

import br.com.gabriel.api.model.Car;
import br.com.gabriel.api.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import springfox.documentation.oas.annotations.EnableOpenApi;

import java.util.Arrays;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableOpenApi
public class ApiApplication implements CommandLineRunner {


    final CarRepository carRepository;

    public ApiApplication(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Override
    public void run(String... args) {
        /*Car AcuraLegend1987 = new Car(
                "JH4KA2630HC019837",
                "Legend",
                "Acura",
                "Prata",
                15840D,
                1987
        );

        Car HondaAccord2007 = new Car(
                "1HGCM66537A023172",
                "Accord",
                "Honda",
                "Verde",
                32860D,
                2007
        );

        Car ChryslerBaron1982 = new Car(
                "1C3BC55D0CG133270",
                "Le Baron",
                "Chrysler",
                "Vermelho",
                64820D,
                1982
        );

        Car OldsmobileAlero1999 = new Car(
                "1G3NF52E3XC403652",
                "Alero",
                "Oldsmobile",
                "Amarelo",
                78250D,
                1999
        );

        Car JeepCherokke2004 = new Car(
                "1J4GW48S94C420221",
                "Grand Cherokke",
                "Jeep",
                "Branco",
                66950D,
                2004
        );

        Car JeepWrangler2013 = new Car(
                "1C4BJWFGXDL531773",
                "Wrangler Unlimited",
                "Jeep",
                "Verde",
                54620D,
                2013
        );

        Car ToyotaCorolla1991 = new Car(
                "2T1AE97A4MC092797",
                "Corolla",
                "Toyota",
                "Prata",
                32510D,
                1991
        );

        Car HyundaiSonata2007 = new Car(
                "5NPET46C07H192362",
                "Sonata",
                "Hyundai",
                "Verde",
                44500D,
                2007
        );

        Car AcuraIntegra1988 = new Car(
                "JH4DA3462JS027249",
                "Integra",
                "Acura",
                "Amarelo",
                38200D,
                1988
        );

        Car AcuraLegend1993 = new Car(
                "JH4KA7670PC005516",
                "Legend",
                "Acura",
                "Azul",
                16580D,
                1993
        );

        Car FordEscort2001 = new Car(
                "3FAFP13P41R199033",
                "Escort",
                "Ford",
                "Azul",
                26190D,
                2001
        );

        Car AcuraLegend1994 = new Car(
                "JH4KA8160RC002560",
                "Legend",
                "Acura",
                "Amarelo",
                17850D,
                1994
        );

        Car AcuraLegend1991 = new Car(
                "JH4KA8260MC000458",
                "Legend",
                "Acura",
                "Verde",
                12850D,
                1991
        );

        Car AcuraLegend1988 = new Car(
                "JH4KA4531JC024340",
                "Legend",
                "Acura",
                "Branco",
                9850D,
                1988
        );

        Car HondaPredule1992 = new Car(
                "JHMBB2269NC026648",
                "Predule",
                "Honda",
                "Preto",
                19250D,
                1992
        );

        Car HyundaiElantra2010 = new Car(
                "KMHDU4AD5AU136970",
                "Elantra",
                "Hyundai",
                "Vermelho",
                58210D,
                2010
        );

        Car DodgeDiplomat1985 = new Car(
                "1B3BG26P3FX513068",
                "Diplomate",
                "Dodge",
                "Prata",
                28210D,
                1985
        );

        Car FordExplorer1992 = new Car(
                "1FMCU24X4NUD21099",
                "Explorer",
                "Ford",
                "Amarelo",
                18720D,
                1992
        );

        Car ToyotaEcho2001 = new Car(
                "JTDBT123710161315",
                "Echo",
                "Toyota",
                "Preto",
                31250D,
                2001
        );

        carRepository.saveAll(Arrays.asList(
                AcuraLegend1987,
                HondaAccord2007,
                ChryslerBaron1982,
                OldsmobileAlero1999,
                JeepCherokke2004,
                JeepWrangler2013,
                ToyotaCorolla1991,
                HyundaiSonata2007,
                AcuraIntegra1988,
                AcuraLegend1993,
                FordEscort2001,
                AcuraLegend1994,
                AcuraLegend1991,
                AcuraLegend1988,
                HondaPredule1992,
                HyundaiElantra2010,
                DodgeDiplomat1985,
                FordExplorer1992,
                ToyotaEcho2001)
        );*/
    }
}
