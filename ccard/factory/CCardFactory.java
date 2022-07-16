package project.ccard.factory;
import domain.impl.CCAccount;
import project.ccard.domain.Bronze;
import project.ccard.domain.Gold;
import project.ccard.domain.Silver;

public class CCardFactory
{
    public static CCAccount CreateCard(String cc_number, String exp_date, String cardType){
        if(cardType == "Gold")
        {
            return new Gold(cc_number,exp_date,cardType);
        }
        else if(cardType == "Bronze")
        {
            return new Bronze(cc_number,exp_date,cardType);
        }
        else
        {
            return new Silver(cc_number,exp_date,cardType);
        }
    }
}
