package br.com.bilheteriacinema.services;
import br.com.bilheteriacinema.models.FeatureFilm;
import br.com.bilheteriacinema.models.Ticket;
import br.com.bilheteriacinema.models.User;
import br.com.bilheteriacinema.repositories.FeatureFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class FeatureFilmService {

    @Autowired
    FeatureFilmRepository featureFilmRepository;

    public Collection<FeatureFilm> getAllFeaturesFilm() {
        return (Collection<FeatureFilm>) featureFilmRepository.findAll();
    }

    public void addFeatureFilm(FeatureFilm featureFilm) {
        featureFilmRepository.save(featureFilm);
    }

    public void deleteById(Integer id) {
        featureFilmRepository.deleteById(id);
    }

    public List<Ticket> generateFakeSchedule(Integer id) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        FeatureFilm  featureFilm = featureFilmRepository.findById(id).get();

        List<Ticket> scheduleFeatureFilm = new ArrayList<Ticket>();
        List<Date> listDateFeatureFilm = new ArrayList<Date>();  

        Date date1 = format.parse("25/10/2023 19:00");
        Date date2 = format.parse("25/10/2023 20:30");
        Date date3 = format.parse("25/10/2023 21:00");
        Date date4 = format.parse("25/10/2023 21:30");
        Date date5 = format.parse("25/10/2023 22:00");

        listDateFeatureFilm.addAll(Arrays.asList(date1, date2, date3, date4, date5));

        Integer fakeId = 0;

        for (Date d : listDateFeatureFilm) {
            fakeId++;
            Ticket ticket = new Ticket(featureFilm, null, d, 30.0);
            ticket.setId(fakeId);
            scheduleFeatureFilm.add(ticket);

        }

        return scheduleFeatureFilm;

    }

}
