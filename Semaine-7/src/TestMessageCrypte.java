/*
	@author Corentin D'haeyere
 */
public class TestMessageCrypte {

	public static void main(String[] args) {
		System.out.println("Mission 1: implementes la methode decalage");
		
		MessageCrypte mission2Crypte = new MessageCrypte("LPSOHPHQWHV" + (char)(' ' + 3) + "OD" 
				+ (char)(' ' + 3) + "PHWKRGH" 
				+ (char)(' ' + 3) + "SHUPXWDWLRQ");
		mission2Crypte.decalerCaracteres(-3);
		
		System.out.println("Mission 2: " + mission2Crypte);
		
		MessageCrypte c3 = new MessageCrypte("MILPMENEET SALM TEOHEDM RIIOR");
		c3.permutation();
		System.out.println("Mission 3: " + c3.toString());
		
		MessageCrypte c4 = new MessageCrypte("ontitutibssur_pat_enemfrifChi/ik/wrg.oiaedipik.wfr//s:tpht: ONTITUTIBSSUE ODTHMEA  LNTTAENEMPLIMN  EFIDEE  LNTNATEINMAS TEAI!FANAWAD PNEEU JVORAB");
		c4.permutation();
		c4.miroir();
		System.out.println(c4);

	}

}
