package edu.sjsu.starbucks.api.service;

import edu.sjsu.starbucks.api.request.AddCardRequest;
import edu.sjsu.starbucks.api.request.ReloadCardRequest;
import edu.sjsu.starbucks.api.response.CardDetailsResponse;

public interface IAddCardService {

    public CardDetailsResponse getCards(String userName);

    public CardDetailsResponse addCard(AddCardRequest addcardrequest) throws IllegalAccessException;

    public CardDetailsResponse reloadCard(ReloadCardRequest reloadcardrequest);

}
