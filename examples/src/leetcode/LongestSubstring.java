import java.util.*;
class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int ptr = 0; int max = 0;
        Map<Character, Integer> saved = new HashMap<>();
        if (s.length() == 0) return 0;
        for (int i = 0; i < s.length(); i++){
            Integer index = saved.get(s.charAt(i));
            if (index == null)
                index = i;
            saved.put(s.charAt(i), i);
            if (!index.equals(i) && index >= ptr ){
                if (i-1 - index > max) max = i-1 - index;
                ptr = index + 1;
            }else{
                if (i - ptr > max) max = i - ptr;
            }
        }
        return max+1;
    }
    //""  : 0
    //"a" : 1
    //"ab": 2
    //"aa": 1
    //"aba":2
}
