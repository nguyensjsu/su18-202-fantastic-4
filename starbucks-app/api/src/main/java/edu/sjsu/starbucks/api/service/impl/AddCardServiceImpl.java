package edu.sjsu.starbucks.api.service.impl;

import edu.sjsu.starbucks.api.dao.AddCardDao;
import edu.sjsu.starbucks.api.request.AddCardRequest;
import edu.sjsu.starbucks.api.response.CardDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import edu.sjsu.starbucks.api.service.IAddCardService;
import edu.sjsu.starbucks.model.Card;

@Service
public class AddCardServiceImpl implements IAddCardService{

    @Autowired
    private AddCardDao addcardDao;

    //@Override
   /* public CardDetailsResponse getCards(String userName) {

        CardDetailsResponse addcardresponse = new CardDetailsResponse();
        addcardresponse.setBalance(addcardresponse.getBalance());
        addcardresponse.setCardNumber(addcardresponse.getCardNumber());
        addcardresponse.setUserName(addcardresponse.getUserName());
        return addcardresponse;
    }*/

    @Override
    public CardDetailsResponse addCard(AddCardRequest addcardrequest){
        Card card = new Card();
        card.setUserName(addcardrequest.getUserName());
        card.setCvv(addcardrequest.getCvv());
        card.setCardNumber(addcardrequest.getCardNumber());
        card.setBalance(20.0);
        addcardDao.AddCard(card);

       CardDetailsResponse getcardsResponse = new CardDetailsResponse();
       getcardsResponse.setCardNumber(card.getCardNumber());
       getcardsResponse.setBalance(card.getBalance());
       getcardsResponse.setUserName(card.getUserName());
       return getcardsResponse;

    }
    @Override
    public CardDetailsResponse getCards(String userName)
    {
        Card card = addcardDao.GetCards(userName);
        CardDetailsResponse getcardsResponse = new CardDetailsResponse();
        getcardsResponse.setUserName(card.getUserName());
        getcardsResponse.setCardNumber(card.getCardNumber());
        getcardsResponse.setBalance(card.getBalance());
        return getcardsResponse;
    }

}
