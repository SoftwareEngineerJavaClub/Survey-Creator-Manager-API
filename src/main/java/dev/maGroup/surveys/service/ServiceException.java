package dev.maGroup.surveys.service;

import dev.maGroup.surveys.model.Survey;
import dev.maGroup.surveys.model.User;

import java.util.List;

public class ServiceException extends Exception {
    //ID Not Valid (verifys if the surevey exist and if false throws this exception)
    //public InvalidId ();
    public ServiceException (String surveyId){
        super("Sorry Survey ID" + surveyId +"could not be found");
    }

    //Input Not Valid (for creating new surveys and checking there values)
    //public InvalidSurveyInput ();
    public ServiceException (Survey attempedSurvey){
        super("Sorry One Of Your Survey Responces Is Invalid");
    }


    //User pull failure()
    //public UnableToPullUsers ();
    public ServiceException (List<User> allUsers){
        super ("No Users Found At the moment");
    }


}
