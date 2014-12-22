package ranktracker.utility;

import java.util.HashMap;

/**
 * Utility class to replace html tags from a given string
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class ReplaceAllHtmlTags {

    /**
     * Removes html codes from given sting
     *
     * @param str Input string
     * @return String
     */
    public static String ReplaceHtmlTage(String str) {
        try {
            str = str.replaceAll("&quot;", "\"");
            str = str.replaceAll("<b>", "");
            str = str.replaceAll("</b>", "");
            str = str.replaceAll("&#39;", "'");
            str = str.replace("&#039;", "'");
            str = str.replace("&#064;", "@");
            str = str.replaceAll("&amp;", "&");
            str = str.replaceAll("&;", "&");
            str = str.replaceAll("%2F", "/");
            str = str.replaceAll("%3A", ":");
            str = str.replaceAll("&#183;", "-");
            str = str.replaceAll("<br/>", "");
            if (str.contains("&#")) {
                str = replaceSpecialCodeToFrenchCanCode(str);
            }
        } catch (Exception ex) {
        }
        return str;
    }

    /**
     * Removes html codes from given sting
     *
     * @param str Input string
     * @return String
     */
    public static String GetOnlyData(String str) {
        int counter = str.length();
        int index_of_str1 = 0;
        int index_of_str2 = 0;
        index_of_str1 = str.indexOf("<");
        index_of_str2 = str.indexOf(">");
        if (index_of_str2 < index_of_str1) {
            str = str.substring(index_of_str2 + 1).trim();
        }
        index_of_str1 = 0;
        index_of_str2 = 0;
        index_of_str1 = str.indexOf("<", index_of_str1);
        index_of_str2 = str.indexOf(">", index_of_str1);
        String data = null;//str.substring(index_of_str1,index_of_str2);
        try {
            while (index_of_str1 >= 0 && index_of_str1 <= str.length() && index_of_str2 >= 0) {
                data = str.substring(index_of_str1, index_of_str2 + 1).trim();
                str = str.replace(data, " ").trim();
                index_of_str1 = 0;//index_of_str2+1;
                index_of_str1 = str.indexOf("<", index_of_str1);
                index_of_str2 = str.indexOf(">", index_of_str1);
                str = str.replace("\n", "").trim();
                str = str.replace("\t", "").trim();
            }
        } catch (Exception ex) {
        }
        try {
            str = str.replaceAll(">", "");
            str = str.replaceAll("<", "");
            str = ReplaceAllHtmlTags.ReplaceHtmlTage(str);
        } catch (Exception ex) {
        }
        if (str.contains("&#")) {
            str = replaceSpecialCodeToFrenchCanCode(str);
        }
        return str;
    }

    /**
     * Removes html codes from given sting
     *
     * @param str Input string
     * @return String
     */
    public static String GetOnlyDataInFacebook(String str) {
        int counter = str.length();
        int index_of_str1 = 0;
        int index_of_str2 = 0;
        index_of_str1 = str.indexOf("\\u");
        index_of_str2 = str.indexOf(" ");
        if (index_of_str2 < index_of_str1) {
            str = str.substring(index_of_str2 + 1).trim();
        }
        index_of_str1 = 0;
        index_of_str2 = 0;
        index_of_str1 = str.indexOf("\\u", index_of_str1);
        index_of_str2 = str.indexOf(" ", index_of_str1);
        String data = null;//str.substring(index_of_str1,index_of_str2);
        try {
            while (index_of_str1 >= 0 && index_of_str1 <= str.length() && index_of_str2 >= 0) {
                data = str.substring(index_of_str1, index_of_str2 + 1).trim();
                str = str.replace(data, " ").trim();
                index_of_str1 = 0;//index_of_str2+1;
                index_of_str1 = str.indexOf("\\u", index_of_str1);
                index_of_str2 = str.indexOf(" ", index_of_str1);
                str = str.replace("\n", "").trim();
                str = str.replace("\t", "").trim();
            }
        } catch (Exception ex) {
        }
        try {
            str = str.replaceAll("\\u", "");
            str = str.replaceAll(" ", "");
            str = ReplaceAllHtmlTags.ReplaceHtmlTage(str);
        } catch (Exception ex) {
        }
        return str;
    }

    /**
     * Remove all character and special character from String.
     *
     * @param str
     * @return String of digits only.
     */
    public static String GetOnlyNumberForm(String str) {
        if (str != null) {
            str = str.toUpperCase();
            String remove_data = "=\"~!@#$\\%\\^&\\(\\)_\\+|\\}\\]\\[\\}POIUYTREWQASDFGHJKL:'\\;\\?.>,<MNBVCXZ- /\\\\";
            int len = remove_data.length();
            for (int i = 0; i < len; i++) {
                try {
                    str = str.replace("" + remove_data.charAt(i), "");
                } catch (Exception ex) {
                    //ex.printStackTrace();
                }
            }
        }
        return str;
    }

    /**
     * Remove special character(() \n:-\\&',.*" ) from String
     *
     * @param str
     * @return String
     */
    public static String RelpaceAllSpecilCaracter(String str) {
        if (str != null) {
            str = str.toUpperCase();
            String remove_data = ")( \n:-\\&',.*";
            int len = remove_data.length();
            for (int i = 0; i < len; i++) {
                try {
                    str = str.replace("" + remove_data.charAt(i), " ");
                } catch (Exception ex) {
                }
            }
        }
        return str;
    }

    //this "sanitizeText(String str)" Function created by Atul on 11-04-2011 for sanitize all varchar field in all crawler
    public static String sanitizeText(String str) {
        try {
//            str = str.replaceAll("\n", " ");
//            str = str.replaceAll("\t", " ");
//            str = str.replaceAll("\r", " ");
            str = str.replaceAll("\\s+", " ");
            str = str.trim();
        } catch (Exception e) {
        }
        return str;
    }

    /**
     * Return unique category list and remove all duplicate category strings
     * from that list.
     *
     * @param duplicate_cat List of category as a string comma separated
     * @return
     */
    public static String getUniqeCatgeory(String duplicate_cate) {
        String final_result = "";
        boolean match = true;
        int count = 1;
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        String cat_value[] = duplicate_cate.split(",");
        cat_value = sortArrayWithStringLength(cat_value);
        String cat1 = null;
        String cat_hm = null;
        for (int i = 0; i < cat_value.length; i++) {
            cat1 = cat_value[i];
            cat1 = cat1.trim();
            cat1 = cat1.replaceAll(" ", "");
            cat1 = cat1.toUpperCase();
            if (hm.size() > 0) {
                match = true;
                for (int j = 0; j < hm.size(); j++) {
                    cat_hm = hm.get(j);
                    cat_hm = cat_hm.trim();
                    cat_hm = cat_hm.replaceAll(" ", "");
                    cat_hm = cat_hm.toUpperCase();
                    if (cat_hm.contains(cat1)) {
                        match = false;
                    }
                }
                if (match) {
                    hm.put(count, cat_value[i]);
                    final_result = final_result + "," + cat_value[i];
                    count++;
                }
            } else {
                final_result = cat_value[i];
                hm.put(0, cat_value[i]);
            }
        }

        return final_result;
    }

    /**
     * Replace all french Canadian special symbol
     *
     * @param string
     * @return string
     */
    public static String replaceHtmlToChar(String text) {
        text = text.replace("&#32", " ");
        text = text.replace("&#45", "-");
        text = text.replace("&#46", ".");
        text = text.replace("&#33", "!");
        text = text.replace("&#34", "\"");
        text = text.replace("&#35", "#");
        text = text.replace("&#36", "$");
        text = text.replace("&#37", "%");
        text = text.replace("&#38", "$");
        text = text.replace("&#39", "'");
        text = text.replace("&#40", "(");
        text = text.replace("&#41", ")");
        text = text.replace("&#42", "*");
        text = text.replace("&#43", "+");
        text = text.replace("&#44", ",");
        text = text.replace("&#47", "/");
        text = text.replace("&#48", "0");
        text = text.replace("&#49", "1");
        text = text.replace("&#50", "2");
        text = text.replace("&#51", "3");
        text = text.replace("&#52", "4");
        text = text.replace("&#53", "5");
        text = text.replace("&#54", "6");
        text = text.replace("&#55", "7");
        text = text.replace("&#56", "8");
        text = text.replace("&#57", "9");
        text = text.replace("&#58", ":");
        text = text.replace("&#59", ";");
        text = text.replace("&#60", "<");
        text = text.replace("&#61", "=");
        text = text.replace("&#62", ">");
        text = text.replace("&#63", "?");
        text = text.replace(";", "");
        text = text.replace(":", "");
        text = text.replace("&#64", "@");
        text = text.replace("&#97", "a");
        text = text.replace("&#98", "b");
        text = text.replace("&#99", "c");
        text = text.replace("&#100", "d");
        text = text.replace("&#101", "e");
        text = text.replace("&#102", "f");
        text = text.replace("&#103", "g");
        text = text.replace("&#104", "h");
        text = text.replace("&#105", "i");
        text = text.replace("&#106", "j");
        text = text.replace("&#107", "k");
        text = text.replace("&#108", "l");
        text = text.replace("&#109", "m");
        text = text.replace("&#110", "n");
        text = text.replace("&#111", "o");
        text = text.replace("&#112", "p");
        text = text.replace("&#113", "q");
        text = text.replace("&#114", "r");
        text = text.replace("&#115", "s");
        text = text.replace("&#116", "t");
        text = text.replace("&#117", "u");
        text = text.replace("&#118", "v");
        text = text.replace("&#119", "w");
        text = text.replace("&#120", "x");
        text = text.replace("&#121", "y");
        text = text.replace("&#122", "z");
        return text;
    }

    public static String replaceUrlsFrenchCanCode(String url) {
        url = url.replace("Â", "%C3%82");
        url = url.replace("Ê", "%C3%8A");
        url = url.replace("Î", "%C3%8E");
        url = url.replace("Û", "%C3%9B");
        url = url.replace("Ô", "%C3%94");

        url = url.replace("â", "%C3%A2");
        url = url.replace("ê", "%C3%AA");
        url = url.replace("î", "%C3%AE");
        url = url.replace("ô", "%C3%B4");
        url = url.replace("û", "%C3%BB");

        url = url.replace("À", "%C3%80");
        url = url.replace("È", "%C3%88");
        url = url.replace("Ì", "%c3%8c");
        url = url.replace("Ò", "%C3%92");
        url = url.replace("Ù", "%C3%99");

        url = url.replace("à", "%C3%A0");
        url = url.replace("è", "%C3%A8");
        url = url.replace("ì", "%C3%ac");
        url = url.replace("ò", "%C3%b2");
        url = url.replace("ù", "%C3%B9");

        url = url.replace("�?", "%C3%81");
        url = url.replace("É", "%C3%89");
        url = url.replace("�?", "%C3%8d");
        url = url.replace("Ó", "%C3%93");
        url = url.replace("Ú", "%C3%9a");

        url = url.replace("á", "%C3%a1");
        url = url.replace("é", "%C3%A9");
        url = url.replace("í", "%C3%ad");
        url = url.replace("ó", "%C3%B2");
        url = url.replace("ú", "%C3%ba");

        url = url.replace("Ä", "%C3%8B");
        url = url.replace("Ë", "%C3%8B");
        url = url.replace("�?", "%C3%8F");
        url = url.replace("Ö", "%C3%96");
        url = url.replace("Ü", "%C3%9c");

        url = url.replace("ä", "%C3%a4");
        url = url.replace("ë", "%C3%AB");
        url = url.replace("ï", "%C3%AF");
        url = url.replace("ö", "%C3%b6");
        url = url.replace("ü", "%C3%bc");

        url = url.replace("Ã", "%C3%83");
        url = url.replace("Õ", "%C3%95");

        url = url.replace("Ã", "%C3%a3");
        url = url.replace("Õ", "%C3%b5");

        url = url.replace("ç", "%C3%A7");
        url = url.replace("Ç", "%C3%87");
        return url;
    }

    /**
     * Replace all french Canadian special symbol to its man text
     *
     * @param string
     * @return string
     */
    public static String replaceSpecialCodeToFrenchCanCode(String str) {
        str = str.replace("&#xC2;;", "Â");
        str = str.replace("&#xCA;;", "Ê");
        str = str.replace("&#xCE;;", "Î");
        str = str.replace("&#xDB;;", "Û");
        str = str.replace("&#xF4;;", "Ô");

        str = str.replace("&#xE2;", "â");
        str = str.replace("&#xEA;", "ê");
        str = str.replace("&#xEE;", "î");
        str = str.replace("&#xF4;", "ô");
        str = str.replace("&#xFB;", "û");

        str = str.replace("&#xC0;", "À");
        str = str.replace("&#xC8;", "È");
        str = str.replace("&#xCC;", "Ì");
        str = str.replace("&#xD2;", "Ò");
        str = str.replace("&#xD9;", "Ù");

        str = str.replace("&#xE0;", "à");
        str = str.replace("&#xE8;", "è");
        str = str.replace("&#xEC;", "ì");
        str = str.replace("&#xF2;", "ò");
        str = str.replace("&#xF9;", "ù");

        str = str.replace("&#xC1;", "�?");
        str = str.replace("&#xC9;", "É");
        str = str.replace("&#xCD;", "�?");
        str = str.replace("&#xD3;", "Ó");
        str = str.replace("&#xDA;", "Ú");

        str = str.replace("&#xE1;", "á");
        str = str.replace("&#xE9;", "é");
        str = str.replace("&#xED;", "í");
        str = str.replace("&#xF3;", "ó");
        str = str.replace("&#xFA;", "ú");

        str = str.replace("&#xC4;", "Ä");
        str = str.replace("&#xCB;", "Ë");
        str = str.replace("&#xCF;", "�?");
        str = str.replace("&#xD6;", "Ö");
        str = str.replace("&#xDC;", "Ü");

        str = str.replace("&#xE4;", "ä");
        str = str.replace("&#xEB;", "ë");
        str = str.replace("&#xEF;", "ï");
        str = str.replace("&#xF6;", "ö");
        str = str.replace("&#xFC;", "ü");

        str = str.replace("&#xC3;", "Ã");
        str = str.replace("&#xD5;", "Õ");

        str = str.replace("&#xA3;", "Ã");
        str = str.replace("&#xD5;", "Õ");

        str = str.replace("&#xE7;", "ç");
        str = str.replace("&#xC7;", "Ç");

        str = str.replace("&#40;", "(");
        str = str.replace("&#41;", ")");
        return str;
    }

    /**
     * Sort the array according to length of String
     *
     * @param array Array of string
     * @return Sorted array by length of string
     */
    private static String[] sortArrayWithStringLength(String array[]) {

        String mid_value = null;
        for (int i = 0; i < array.length; i++) {

            for (int j = i; j < array.length; j++) {
                if (array[i].length() < array[j].length()) {
                    mid_value = array[j];
                    array[j] = array[i];
                    array[i] = mid_value;
                }

            }

        }
        return array;
    }

    //Replace all HTML symbols
    public static String ReplaceHtmlSymbols(String str) {
        try {
            int count = 0;
            do {
                count++;
                str = str.replace("%24", "$");
                str = str.replace("%26", "&");
                str = str.replace("%2B", "+");
                str = str.replace("%2C", ",");
                str = str.replace("%2F", "/");
                str = str.replace("%2A", ":");
                str = str.replace("%3B", ";");
                str = str.replace("%3D", "=");
                str = str.replace("%3F", "?");
                str = str.replace("%40", "@");
                str = str.replace("%20", "+");
                str = str.replace("%22", "?");
                str = str.replace("%3C", "<");
                str = str.replace("%3E", ">");
                str = str.replace("%23", "#");
                str = str.replace("%25", "%");
                str = str.replace("%7B", "{");
                str = str.replace("%7D", "}");
                str = str.replace("%7C", "|");
                str = str.replace("%5B", "[");
                str = str.replace("%5D", "]");
                str = str.replace("%60", "'");
                str = str.replace("&quot;", "\"");
                str = str.replace("<b>", "");
                str = str.replace("</b>", "");
                str = str.replace("&#39;", "'");
                str = str.replace("&amp;", "&");
                str = str.replace("'", "");
                str = str.replace("%2F", "/");
                str = str.replace("%3A", ":");
                str = str.replace("%3a", ":");
                str = str.replace("&#183;", "-");
            } while (str.contains("%") && count <= 20);
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
        return str;
    }

    //Replace in to HTML symbols formate
    public static String changeInHtmlSymbols(String str) {
        try {
            str = str.replace("$", "%24");
            str = str.replace("&", "%26");
            str = str.replace("+", "%2B");
            str = str.replace(",", "%2C");
            str = str.replace("/", "%2F");
            str = str.replace(";", "%3B");
            str = str.replace("=", "%3D");
            str = str.replace("?", "%3F");
            str = str.replace("@", "%40");
            str = str.replace("+", "%20");
            str = str.replace("?", "%22");
            str = str.replace("<", "%3C");
            str = str.replace(">", "%3E");
            str = str.replace("#", "%23");
            str = str.replace("{", "%7B");
            str = str.replace("}", "%7D");
            str = str.replace("|", "%7C");
            str = str.replace("%5B", "[");
            str = str.replace("]", "%5D");
            str = str.replace("'", "%60");
            str = str.replace("\"", "&quot;");
            str = str.replace("'", "&#39;");
            str = str.replace("&", "&amp;");
            str = str.replace("/", "%2F");
            str = str.replace("-", "&#183;");
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
        return str;
    }

    /**
     * Getting lots of special symbol like byte code when we are scraping google
     * review thats we are removing here.
     *
     * @param string
     * @return string
     */
    public static String removeAllGoogleReviewByteCode(String str) {
        try {
            if (str.startsWith("*")) {
                str = str.substring(2, str.length());
            }
        } catch (Exception ex) {
        }
        try {
            str = str.replace("", "");  //SOH
            str = str.replace("", "");    //BEL
            str = str.replace("", "");    //FS
            str = str.replace("", "");    //FF
            str = str.replace("", "");    //STX
            str = str.replace("", "");    //SI
            str = str.replace("", "");    //GS
            str = str.replace("", "");    //ENQ
            str = str.replace("", "");    //VT
            str = str.replace("", "");    //ETX
            str = str.replace("", "");    //SOH
            str = str.replace("", "");    //DLE
            str = str.replace("", "");    //SOH
            str = str.replace("", "");    //NAK
            str = str.replace("", "");    //DLE
            str = str.replace("", "");    //RS
            str = str.replace("", "");    //BS
            str = str.replace("", "");    //ENQ
            str = str.replace("", "");    //DC2
            str = str.replace("", "");    //CAN
            str = str.replace("", "");    //US
            str = str.replace("", "");    //EOT
            str = str.replace("", "");     //NUL
            str = str.replace("", "");    //VT
            str = str.replace("", "");    //ETB
            str = str.replace("", "");    //EM
            str = str.replace("", "");    //SUB
            str = str.replace("", "");    //DC4
            str = str.replace("", "");    //SYN
            str = str.replace("", "");    //DC3
            str = str.replace("", "");    //ESC
            str = str.replace("", "");    //ACK
            str = str.replace("\"", "");
            str = str.replace("¹", "");    //¹
            str = str.replace("ˆ", "");    //ˆ
            str = str.replace("", "");    //
            str = str.replace("'", "");    //'
            str = str.replace("Œ", "");    //Œ
            str = str.replace("œ", "œ");   //œ
            str = str.replace("÷", "");    //÷
            str = str.replace("+", "");    //+
            str = str.replace("¿", "");    //¿
            str = str.replace("•", "");
            str = str.replace("¸", "");    //¸
            str = str.replace("ž", "");    //ž
            str = str.replace("³", "");    //³
            str = str.replace("¼", "");    //¼
            str = str.replace("", "");    //
            str = str.replace("¶", "");    //¶
            str = str.replace("°", "");    //°
            str = str.replace("~", "");    //~
            str = str.replace("Ç", "");    //Ç
            str = str.replace("/", "");
            str = str.replace("\n", " ");
            str = str.replace("\r", " ");
            str = str.replace("\t", " ");

            if (str.endsWith("2") || str.endsWith("2 1")) {
                str = str.substring(0, str.lastIndexOf("2"));
            }
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
        return str;
    }

    /**
     * Replace all french Canadian special symbol
     *
     * @param string
     * @return string
     */
    public static String removeAllFrenchCanCode(String url) {
        url = url.replace("Â", "");
        url = url.replace("Ê", "");
        url = url.replace("Î", "");
        url = url.replace("Û", "");
        url = url.replace("Ô", "");

        url = url.replace("â", "");
        url = url.replace("ê", "");
        url = url.replace("î", "");
        url = url.replace("ô", "");
        url = url.replace("û", "");

        url = url.replace("À", "");
        url = url.replace("È", "");
        url = url.replace("Ì", "");
        url = url.replace("Ò", "");
        url = url.replace("Ù", "");

        url = url.replace("à", "");
        url = url.replace("è", "");
        url = url.replace("ì", "");
        url = url.replace("ò", "");
        url = url.replace("ù", "");

        url = url.replace("�?", "");
        url = url.replace("É", "");
        url = url.replace("�?", "");
        url = url.replace("Ó", "");
        url = url.replace("Ú", "");

        url = url.replace("á", "");
        url = url.replace("é", "");
        url = url.replace("í", "");
        url = url.replace("ó", "");
        url = url.replace("ú", "");

        url = url.replace("Ä", "");
        url = url.replace("Ë", "");
        url = url.replace("�?", "");
        url = url.replace("Ö", "");
        url = url.replace("Ü", "");

        url = url.replace("ä", "");
        url = url.replace("ë", "");
        url = url.replace("ï", "");
        url = url.replace("ö", "");
        url = url.replace("ü", "");

        url = url.replace("Ã", "");
        url = url.replace("Õ", "");

        url = url.replace("Ã", "");
        url = url.replace("Õ", "");

        url = url.replace("ç", "");
        url = url.replace("Ç", "");
        return url;
    }
}
