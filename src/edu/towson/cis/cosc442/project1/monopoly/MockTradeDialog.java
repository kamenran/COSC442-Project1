package edu.towson.cis.cosc442.project1.monopoly;

/**
 * Represents the MockTradeDialog component of the Monopoly application.
 */
public class MockTradeDialog implements TradeDialog {

    public TradeDeal getTradeDeal() {
        TradeDeal deal = new TradeDeal();
        deal.setAmount(200);
        deal.setSellerIndex(0);
        deal.setPropertyName(GameMaster.instance().getGameBoard().getCell(1).toString());
        return deal;
    }
}
