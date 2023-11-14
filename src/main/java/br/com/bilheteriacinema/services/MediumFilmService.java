package br.com.bilheteriacinema.services;

import br.com.bilheteriacinema.models.FeatureFilm;
import br.com.bilheteriacinema.models.MediumFilm;
import br.com.bilheteriacinema.models.Ticket;
import br.com.bilheteriacinema.repositories.MediumFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MediumFilmService {

    @Autowired
    MediumFilmRepository mediumFilmRepository;

    public Collection<MediumFilm> getAllMediumFilm() {
        return (Collection<MediumFilm>) mediumFilmRepository.findAll();
    }

    public Optional<MediumFilm> getByIdMediumFilm(Integer id) {
        return mediumFilmRepository.findById(id);
    }

    public void addMediumFilm(MediumFilm mediumFilm) {
        mediumFilmRepository.save(mediumFilm);
    }

    public void deleteById(Integer id) {
        mediumFilmRepository.deleteById(id);
    }

     public List<Ticket> generateFakeSchedule(Integer id) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        MediumFilm  mediumFilm = mediumFilmRepository.findById(id).get();

        List<Ticket> scheduleMediumFilm = new ArrayList<Ticket>();
        List<Date> listDateMediumFilm = new ArrayList<Date>();  

        Date date1 = format.parse("25/10/2023 19:00");
        Date date2 = format.parse("25/10/2023 20:30");
        Date date3 = format.parse("25/10/2023 21:00");
        Date date4 = format.parse("25/10/2023 21:30");
        Date date5 = format.parse("25/10/2023 22:00");

        listDateMediumFilm.addAll(Arrays.asList(date1, date2, date3, date4, date5));

        Integer fakeId = 0;

        for (Date d : listDateMediumFilm) {
            fakeId++;
            Ticket ticket = new Ticket(mediumFilm, null, d, 30.0);
            ticket.setId(fakeId);
            scheduleMediumFilm.add(ticket);

        }

        return scheduleMediumFilm;

    }

    public void editMediumFilm(MediumFilm mediumFilmEdited) {
        System.out.println("Chamou o edit medium service");

      MediumFilm mediumFilm =  mediumFilmRepository.findById(mediumFilmEdited.getId()).orElse(null);

      if(mediumFilm != null) {
          mediumFilm.setCode(mediumFilmEdited.getCode());
          mediumFilm.setTitle(mediumFilmEdited.getTitle());
          mediumFilm.setAgeRating(mediumFilmEdited.getAgeRating());
          mediumFilm.setDirector(mediumFilmEdited.getDirector());
          mediumFilm.setDuration(mediumFilmEdited.getDuration());
          mediumFilm.setGendersList(mediumFilmEdited.getGendersList());
          mediumFilmRepository.save(mediumFilm);
      }
  }

}
