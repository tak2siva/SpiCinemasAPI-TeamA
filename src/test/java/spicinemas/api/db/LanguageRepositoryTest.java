package spicinemas.api.db;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;

import java.util.List;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class LanguageRepositoryTest {
    @Autowired
    private LanguageRepository languageRepository;

    @Test
    public void shouldReturnAllTheLanguagesFromLanguageTable(){

        List<spicinemas.api.model.Language> languages = languageRepository.getAllLanguage();
        Assert.assertTrue(languages.size() > 0);
    }
}