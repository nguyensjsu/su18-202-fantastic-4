package edu.sjsu.starbucks.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import edu.sjsu.starbucks.api.dao.AddCardDao;
import edu.sjsu.starbucks.api.request.AddCardRequest;
import edu.sjsu.starbucks.api.request.ReloadCardRequest;
import edu.sjsu.starbucks.api.response.CardDetailsResponse;
import edu.sjsu.starbucks.api.response.CardResponse;
import edu.sjsu.starbucks.api.service.IAddCardService;
import edu.sjsu.starbucks.model.Card;
import edu.sjsu.starbucks.model.common.CardStatus;

@Service
public class AddCardServiceImpl implements IAddCardService {

    @Autowired
    private AddCardDao addcardDao;

    @Override
    public CardDetailsResponse addCard(AddCardRequest addcardrequest) {
        List<Card> updatedList = new ArrayList<>();
        boolean cardExist = false;

        List<Card> cards = addcardDao.getCards(addcardrequest.getUserName());
        if (!CollectionUtils.isEmpty(cards)) {
            for (Card dbCard : cards) {
                if (dbCard.getCardNumber().equals(addcardrequest.getCardNumber())) {
                    cardExist = true;
                    dbCard.setStatus(CardStatus.ACTIVE);
                    dbCard.setBalance(20.0);
                } else {
                    dbCard.setStatus(CardStatus.DEACTIVATED);
                }

                updatedList.add(dbCard);
            }
        }

        if (!cardExist) {
            Card card = new Card();
            card.setUserName(addcardrequest.getUserName());
            card.setCvv(addcardrequest.getCvv());
            card.setCardNumber(addcardrequest.getCardNumber());
            card.setStatus(CardStatus.ACTIVE);
            card.setBalance(20.0);
            updatedList.add(card);
        }

        addcardDao.saveAll(updatedList);

        List<CardResponse> cardResponses = new ArrayList<>();
        cards = addcardDao.getCards(addcardrequest.getUserName());
        if (!CollectionUtils.isEmpty(cards)) {
            for (Card dbCard : cards) {
                CardResponse response = new CardResponse();
                response.setCardNumber(dbCard.getCardNumber());
                response.setBalance(dbCard.getBalance());
                response.setStatus(dbCard.getStatus());

                cardResponses.add(response);
            }
        }
        CardDetailsResponse getcardsResponse = new CardDetailsResponse();
        getcardsResponse.setUserName(addcardrequest.getUserName());
        getcardsResponse.setCards(cardResponses);
        return getcardsResponse;

    }

    @Override
    public CardDetailsResponse getCards(String userName) {
        List<CardResponse> cardResponses = new ArrayList<>();
        List<Card> cards = addcardDao.getCards(userName);
        if (!CollectionUtils.isEmpty(cards)) {
            for (Card dbCard : cards) {
                CardResponse response = new CardResponse();
                response.setCardNumber(dbCard.getCardNumber());
                response.setBalance(dbCard.getBalance());
                response.setStatus(dbCard.getStatus());

                cardResponses.add(response);
            }
        }
        CardDetailsResponse getcardsResponse = new CardDetailsResponse();
        getcardsResponse.setUserName(userName);
        getcardsResponse.setCards(cardResponses);
        return getcardsResponse;
    }

    @Override
    public CardDetailsResponse reloadCard(ReloadCardRequest reloadcardrequest) {
        List<Card> updatedList = new ArrayList<>();
        List<Card> cards = addcardDao.getCards(reloadcardrequest.getUserName());
        if (!CollectionUtils.isEmpty(cards)) {
            for (Card dbCard : cards) {
                if (dbCard.getCardNumber() == reloadcardrequest.getCardNumber()) {
                    dbCard.setStatus(CardStatus.ACTIVE);
                    dbCard.setBalance(dbCard.getBalance() + reloadcardrequest.getBalance());
                } else {
                    dbCard.setStatus(CardStatus.DEACTIVATED);
                }
                updatedList.add(dbCard);
            }
        }

        addcardDao.saveAll(updatedList);

        List<CardResponse> cardResponses = new ArrayList<>();
        for (Card card : updatedList) {
            CardResponse response = new CardResponse();
            response.setCardNumber(card.getCardNumber());
            response.setBalance(card.getBalance());
            response.setStatus(card.getStatus());

            cardResponses.add(response);
        }
        CardDetailsResponse reloadCardsResponse = new CardDetailsResponse();
        reloadCardsResponse.setUserName(reloadcardrequest.getUserName());
        reloadCardsResponse.setCards(cardResponses);
        return reloadCardsResponse;
    }

}
