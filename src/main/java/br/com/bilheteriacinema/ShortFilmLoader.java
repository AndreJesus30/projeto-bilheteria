package br.com.bilheteriacinema;

import br.com.bilheteriacinema.controllers.ShortFilmController;
import br.com.bilheteriacinema.models.MediumFilm;
import br.com.bilheteriacinema.models.ShortFilm;
import br.com.bilheteriacinema.services.ShortFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
@Order(3)
@Component
public class ShortFilmLoader implements ApplicationRunner  {

//    private Map<Integer, ShortFilm> mapShortFilm;

//    @Autowired
//    ShortFilmController shortFilmController;

    @Autowired
    ShortFilmService shortFilmService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        mapShortFilm = new HashMap<Integer, ShortFilm>();

        FileReader file = new FileReader("dummyFiles/short_film.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();

        String[] fields = null;

        while (line != null) {
            fields = line.split(";");

            String[] parseGendersList = fields[4].split("-");

            List<String> gendersList = new ArrayList<>(Arrays.asList(parseGendersList));

            ShortFilm shortFilm = new ShortFilm(
                    Integer.parseInt(fields[0]),
                    fields[1],
                    Integer.parseInt(fields[2]),
                    fields[3],
                    gendersList,
                    Integer.parseInt(fields[5])
            );


//            mapShortFilm.put(shortFilm.getCode(), shortFilm);
//            featureFilmService.incluir(featureFilm);

//            shortFilmController.add(shortFilm.getCode(), shortFilm);

            shortFilmService.addShortFilm(shortFilm);
            line = reader.readLine();
        }

        Collection<ShortFilm> films = shortFilmService.getAllShortFilm();

        for (ShortFilm film : films) {
            System.out.println("Short Film Inclusão realizada: " +  film.getTitle() +  film.getDirector());
        }

        reader.close();
    }


}
