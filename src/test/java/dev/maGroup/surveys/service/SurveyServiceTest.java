package dev.maGroup.surveys.service;

import dev.maGroup.surveys.model.Survey;
import dev.maGroup.surveys.repository.SurveyRepository;
import dev.maGroup.surveys.utils.TestDataGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SurveyServiceTest {

    @Mock
    private SurveyRepository surveyRepository;

    @InjectMocks
    private SurveyService surveyService;

    @Test
    public void when_save_survey_it_should_return_survey() {
        Survey survey = TestDataGenerator.generateSurveys(1).get(0);
        when(surveyRepository.save(survey)).thenReturn(survey);

        Survey surveyResult = surveyService.createSurvey(survey);

        verify(surveyRepository, times(1)).save(survey);
        assertThat(surveyResult).isEqualTo(survey);
    }

    @Test
    public void when_find_survey_by_id_it_should_return_survey() {
        Survey survey = TestDataGenerator.generateSurveys(1).get(0);
        when(surveyRepository.findById(survey.getSurveyId())).thenReturn(Optional.of(survey));

        Survey foundSurvey;
        foundSurvey = surveyService.findSurveyById(survey.getSurveyId());

        verify(surveyRepository, times(1)).findById(survey.getSurveyId());
        assertThat(foundSurvey).isEqualTo(survey);
    }

    @Test
    public void when_get_survey_with_wrong_id_it_should_throw_exception() {
        String wrongId = "wrongId";
        when(surveyRepository.findById(wrongId)).thenReturn(Optional.empty());

        // Using assertThrows to expect the exception.
        assertThrows(RuntimeException.class, () -> surveyService.findSurveyById(wrongId));
    }

    @Test
    public void when_delete_survey_it_should_call_repository_delete_method() {
        String id = "someId";

        surveyService.deleteSurveyById(id);

        verify(surveyRepository, times(1)).deleteById(id);
    }

    @Test
    public void when_list_all_surveys_it_should_return_all_surveys() {
        List<Survey> surveys = TestDataGenerator.generateSurveys(2);
        when(surveyRepository.findAll()).thenReturn(surveys);

        List<Survey> retrievedSurveys = surveyService.findAllSurveys();

        verify(surveyRepository, times(1)).findAll();
        assertThat(retrievedSurveys).isEqualTo(surveys);
    }

}
