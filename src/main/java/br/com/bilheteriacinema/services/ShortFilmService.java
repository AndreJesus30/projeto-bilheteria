package br.com.bilheteriacinema.services;

import br.com.bilheteriacinema.models.ShortFilm;
import br.com.bilheteriacinema.models.Ticket;
import br.com.bilheteriacinema.repositories.ShortFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class ShortFilmService {

    @Autowired
    ShortFilmRepository shortFilmRepository;

    public Collection<ShortFilm> getAllShortFilm() {
        return (Collection<ShortFilm>) shortFilmRepository.findAll();
    }

    public void addShortFilm(ShortFilm shortFilm) {
        shortFilmRepository.save(shortFilm);
    }

    public void deleteById(Integer id) {
        shortFilmRepository.deleteById(id);
    }

     public List<Ticket> generateFakeSchedule(Integer id) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        ShortFilm  shortFilm = shortFilmRepository.findById(id).get();

        List<Ticket> scheduleShortFilm = new ArrayList<Ticket>();
        List<Date> listDateShortFilm = new ArrayList<Date>();  

        Date date1 = format.parse("25/10/2023 19:00");
        Date date2 = format.parse("25/10/2023 20:30");
        Date date3 = format.parse("25/10/2023 21:00");
        Date date4 = format.parse("25/10/2023 21:30");
        Date date5 = format.parse("25/10/2023 22:00");

        listDateShortFilm.addAll(Arrays.asList(date1, date2, date3, date4, date5));

        Integer fakeId = 0;

        for (Date d : listDateShortFilm) {
            fakeId++;
            Ticket ticket = new Ticket(shortFilm, null, d, 30.0);
            ticket.setId(fakeId);
            scheduleShortFilm.add(ticket);

        }

        return scheduleShortFilm;

    }

}
