package br.com.bilheteriacinema;

import br.com.bilheteriacinema.models.FeatureFilm;
import br.com.bilheteriacinema.services.FeatureFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

@Order(1)
@Component
public class FeatureFilmLoader implements ApplicationRunner {

    @Autowired
    FeatureFilmService featureFilmeService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("dummyFiles/feature_film.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();

        String[] fields = null;

        while (line != null) {
            fields = line.split(";");

            String[] parseGendersList = fields[4].split("-");

            List<String> gendersList = new ArrayList<>(Arrays.asList(parseGendersList));

            FeatureFilm featureFilm = new FeatureFilm(
                    Integer.parseInt(fields[0]),
                    fields[1],
                    Integer.parseInt(fields[2]),
                    fields[3],
                    gendersList,
                    Integer.parseInt(fields[5])
            );

            featureFilmeService.addFeatureFilm(featureFilm);
            line = reader.readLine();
        }

        Collection<FeatureFilm> films = featureFilmeService.getAllFeaturesFilm();

        for (FeatureFilm film : films) {
            System.out.println("Feature Film Inclusão realizada: " +  film.getTitle() +  film.getDirector());
        }

        reader.close();
    }


}
