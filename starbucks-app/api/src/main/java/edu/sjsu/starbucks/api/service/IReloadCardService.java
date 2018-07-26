package edu.sjsu.starbucks.api.service;

import edu.sjsu.starbucks.api.request.ReloadCardRequest;
import edu.sjsu.starbucks.api.response.CardDetailsResponse;

public interface IReloadCardService {

    public CardDetailsResponse reloadCard(ReloadCardRequest reloadcardrequest);
}
