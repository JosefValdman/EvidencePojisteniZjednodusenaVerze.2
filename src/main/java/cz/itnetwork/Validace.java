package cz.itnetwork.evidencepojistenizjednodusenaverze;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Josef Valdman
 */
public class Validace {

    final String regex = "^([A-ZĚŠČŘŽÝÁÍÉ][a-zěščřžýáíé]*)$";
    final Pattern pattern = Pattern.compile(regex);
   
    public boolean overeni(String testovaciJmeno) { // jméno a příjmení

        final Matcher matcher = pattern.matcher(testovaciJmeno);
        if (matcher.find()) {
            return true;
        }
        System.out.println("Nesprávně zadáno, zadejte prosím znovu.");
        return false;
    }
    
 }
