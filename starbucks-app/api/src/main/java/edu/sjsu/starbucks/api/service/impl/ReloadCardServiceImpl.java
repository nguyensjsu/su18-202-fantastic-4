package edu.sjsu.starbucks.api.service.impl;

import edu.sjsu.starbucks.api.dao.ReloadCardDao;
import edu.sjsu.starbucks.api.request.AddCardRequest;
import edu.sjsu.starbucks.api.request.ReloadCardRequest;
import edu.sjsu.starbucks.api.response.CardDetailsResponse;
import edu.sjsu.starbucks.api.service.IReloadCardService;
import edu.sjsu.starbucks.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReloadCardServiceImpl implements IReloadCardService {

    @Autowired
    private ReloadCardDao reloadcardDao;

    @Override
    public CardDetailsResponse reloadCard(ReloadCardRequest reloadcardrequest){
        Card card = new Card();
        card.setUserName(reloadcardrequest.getUserName());
        card.setCardNumber(reloadcardrequest.getCardNumber());
        card.setBalance(reloadcardrequest.getBalance());

        reloadcardDao.ReloadCard(card);

        CardDetailsResponse getcardsResponse = new CardDetailsResponse();
        getcardsResponse.setCardNumber(card.getCardNumber());
        getcardsResponse.setBalance(card.getBalance());
        getcardsResponse.setUserName(card.getUserName());
        return getcardsResponse;
    }
}
