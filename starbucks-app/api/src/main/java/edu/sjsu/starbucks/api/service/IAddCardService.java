package edu.sjsu.starbucks.api.service;

import edu.sjsu.starbucks.api.request.AddCardRequest;
import edu.sjsu.starbucks.api.response.CardDetailsResponse;

public interface IAddCardService {

    public CardDetailsResponse getCards(String userName);

    public CardDetailsResponse addCard(AddCardRequest addcardrequest);

    //public CardDetailsResponse getcardbyusername(String userName);

}
