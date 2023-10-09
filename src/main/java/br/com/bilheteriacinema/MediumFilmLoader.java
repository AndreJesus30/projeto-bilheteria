package br.com.bilheteriacinema;

import br.com.bilheteriacinema.controllers.MediumFilmController;
import br.com.bilheteriacinema.models.FeatureFilm;
import br.com.bilheteriacinema.models.MediumFilm;
import br.com.bilheteriacinema.services.MediumFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
@Order(2)
@Component
public class MediumFilmLoader implements ApplicationRunner  {

//    @Autowired
//    MediumFilmController mediumFilmController;

    @Autowired
    MediumFilmService mediumFilmService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        mapMediumFilm = new HashMap<Integer, MediumFilm>();

        FileReader file = new FileReader("dummyFiles/medium_film.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();

        String[] fields = null;

        while (line != null) {
            fields = line.split(";");

            String[] parseGendersList = fields[4].split("-");

            List<String> gendersList = new ArrayList<>(Arrays.asList(parseGendersList));

            MediumFilm mediumFilm = new MediumFilm(
                    Integer.parseInt(fields[0]),
                    fields[1],
                    Integer.parseInt(fields[2]),
                    fields[3],
                    gendersList,
                    Integer.parseInt(fields[5])
            );


//            mapMediumFilm.put(mediumFilm.getCode(), mediumFilm);
//            featureFilmService.incluir(featureFilm);
//            mediumFilmController.add(mediumFilm.getCode(), mediumFilm);
            mediumFilmService.addMediumFilm(mediumFilm);
            line = reader.readLine();
        }

        Collection<MediumFilm> films = mediumFilmService.getAllMediumFilm();

        for (MediumFilm film : films) {
            System.out.println("Medium Film Inclusão realizada: " +  film.getTitle() +  film.getDirector());
        }

        reader.close();
    }


}
