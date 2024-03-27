package kdn.lab6.task1.encryption;

import org.apache.log4j.Logger;

class VowelsStrategy implements EncryptStrategy {
    private static Logger logger = Logger.getLogger(VowelsStrategy.class);
    String englishVowels = "aeiouAEIOU";
    String russianVowels = "аеёиоуыэюяАЕЁИОУЫЭЮЯ";
    String decryptionArray = "want wanted hidden the and of to in is you that it he was for on are as with his they at be this have from or one had by word but not what all were we when your can said there use an each which she do how their if will up other about out many then them these so some her would make like him into time has look two more way could go see number no not way could go see number no most people my over know water than call first who may down side been now find any new work part take get place made live where after back little only round man year came show every good me give our under name very through just form sentence great think say help low line before turn cause same mean differ move right boy old too does tell sentence set three want air well also play small end put home read hand port large spell add even land here must big high such follow act why ask men change went light kind off need house picture try us again animal point mother world near build self earth father head stand own page should country found answer school grow study still learn plant cover food sun four between state keep eye never last let thought city tree cross farm hard start might story saw far sea draw left late run don't while press close night real life few stop open seem together next white children begin got walk example ease paper group always music those both mark often letter until mile river car feet care second book carry took science eat room friend began idea fish mountain north once base hear horse cut sure watch color face wood main enough plain girl usual young ready above ever red list though feel talk bird soon body dog family direct pose leave song measure state product black short numeral class wind question happen complete ship area half rock order fire south problem piece told knew pass since top whole king space heard best hour better true during hundred am remember step early hold west ground interest reach fast verb sing listen six six table travel less morning ten simple several vowel toward war lay against pattern slow center love person money serve appear road map rain rule govern pull cold notice voice fall power town fine certain fly unit lead cry dark machine note wait plan figure star box noun field rest correct able pound done beauty drive stood contain front teach week final gave green oh quick develop sleep warm free minute strong special mind behind clear tail produce fact street inch lot multiply nothing course stay wheel full force blue object decide surface deep moon island foot system busy test record boat common gold possible plane age dry wonder laugh thousand ago ran check game shape equate miss bring heat snow tire bring yes distant fill east paint language among grand ball yet wave drop heart am present heavy dance engine position arm wide sail material size vary settle speak weight general ice matter circle pair include divide syllable felt perhaps pick sudden count square reason length represent art subject region energy hunt probable bed brother egg ride cell believe fraction forest sit race window store summer train sleep prove lone leg exercise wall catch mount wish sky board joy winter sat written wild instrument kept glass grass cow job edge sign visit past soft fun bright gas weather month million bear finish happy hope flower clothe strange gone jump baby eight village meet root buy raise solve metal whether push seven paragraph third shall held hair describe cook floor either result burn hill safe cat century consider type law bit coast copy phrase silent tall sand soil roll temperature finger industry value fight lie beat excite natural view sense ear else quite broke case middle kill son lake moment scale loud spring observe child straight consonant nation dictionary milk speed method organ pay age section dress cloud surprise quiet stone tiny climb cool design poor lot experiment bottom key iron single stick flat twenty skin smile crease hole trade melody trip office receive row mouth exact symbol die least trouble shout except wrote seed tone join suggest clean break lady yard rise bad blow oil blood touch grew cent mix team wire cost lost brown wear garden equal sent choose fell fit flow fair bank collect save control decimal gentle woman captain practice separate difficult doctor please protect noon whose locate ring character insect caught period indicate radio spoke atom human human history effect electric expect crop modern element hit student corner party supply bone rail imagine provide agree thus capital won't chair danger fruit rich thick soldier process operate guess necessary sharp wing create neighbor wash bat rather crowd corn compare poem string bell depend meat rub tube famous dollar stream fear sight thin triangle planet hurry chief colony clock mine tie enter major fresh search send yellow gun allow print dead spot desert suit current lift rose continue block chart hat sell success company subtract event particular deal swim term opposite wife shoe shoulder spread arrange camp invent cotton born determine quart nine truck noise level chance gather shop stretch throw shine property column molecule select wrong gray repeat require broad prepare salt nose plural anger claim continent oxygen sugar death pretty skill women season solution magnet silver thank gate fresh connect post spend chord fat glad original share station dad bread charge proper bar offer segment slave duck instant market degree populate chick dear enemy reply drink occur support speech nature range steam motion path liquid log meant quotient teeth shell neck oxygen sugar death pretty skill women season solution magnet silver gate chick dear enemy reply drink occur support speech nature range steam motion";
    String toEncrypt, toDecrypt;
    final static private String INITIALIZE = "";
    final static private String SPACE = " ";
    final static private int NOT_FOUND = -1;

    /**
     * Creating new object from string to encrypt
     * @param toEncrypt
     * <br/>
     * Use {@link VowelsStrategy#encrypt()} for encryption.
     * <br/>
     * And {@link VowelsStrategy#decrypt()} for decryption.
     */
    VowelsStrategy(String toEncrypt){
        this.toEncrypt = toEncrypt;
    }

    /**
     * Encrypting kdn.lab6.task1.encryption.VowelsStrategy object
     * @return encryptedString
     */
    @Override
    public String encrypt() {
        StringBuilder sb = new StringBuilder();
        for (char ch : toEncrypt.toCharArray()) {
            if (!isVowel(ch)) {
                sb.append(ch);
            }
        }
        toEncrypt = sb.toString();
        logger.info("File was encrypted with Vowels Deleting method");
        return toEncrypt;
    }

    /**
     * Decrypting kdn.lab6.task1.encryption.VowelsStrategy object
     * @return decryptedString
     */
    @Override
    public String decrypt() {
        boolean adden;
        toDecrypt = INITIALIZE;
        String[] wordsArray = decryptionArray.split(SPACE);
        String[] textToDecrypt = toEncrypt.split(SPACE);
        for(String wordToDecrypt : textToDecrypt){
            adden = false;
            VowelsStrategy encrypted = new VowelsStrategy(wordToDecrypt);
            for(String word : wordsArray){
                VowelsStrategy encryptedWord = new VowelsStrategy(word);
                if(encryptedWord.encrypt().toString().equalsIgnoreCase(encrypted.encrypt().toString())){
                    toDecrypt += word + SPACE;
                    adden = true;
                    break;
                }
            }
            if(!adden){
                toDecrypt += wordToDecrypt + SPACE;
            }
        }
        logger.info("File was decrypted with Vowels Deleting method");
        return toDecrypt;
    }

    /**
     * Searching char 'ch' in array of vowels
     * @param ch
     * @return
     */
    private boolean isVowel(char ch) {
        String vowels = englishVowels + russianVowels;
        return vowels.indexOf(ch) != NOT_FOUND;
    }

}
