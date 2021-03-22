package hu.nive.ujratervezes.zarovizsga.words;

public class Words {

    public boolean hasMoreDigits(String s) {
        int charSum = 0;
        int numberSum = 0;
        for (char oi : s.toCharArray()) {
            if (Character.isDigit(oi)) {
                numberSum++;
            } else {
                charSum++;
            }
        }
        if (charSum < numberSum) {
            return true;
        }
        return false;
    }
}
