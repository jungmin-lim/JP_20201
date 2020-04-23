
package stringprocess;

public class StringProcessor {

    public String extract_from_within_brackets(String str){
        int leftBracket = str.indexOf("{");
        int rightBracket = str.indexOf("}");

        if(rightBracket == -1 || leftBracket == -1){
            return "";
        }
        else if(leftBracket - rightBracket > 0){
            return "";
        }
        else{
            return str.substring(leftBracket+1, rightBracket);
        }
    }

    public String[] split_based_on_comma(String str){
        return str.split(",");
    }

    public int count_as(String[] s){
        int count = 0;
        for(int i = 0; i < s.length; ++i){
            if(s[i].startsWith("a")) count++;
        }
        return count;
    }
}