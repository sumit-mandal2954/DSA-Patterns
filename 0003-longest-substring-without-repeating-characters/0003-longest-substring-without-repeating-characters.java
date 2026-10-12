// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         HashMap<Character, Integer> map = new HashMap<>();
//         int l = 0;
//         int r = 0;
//         int maxlen = 0;
//         while (r < s.length()) {
//             char ch = s.charAt(r);
//             if (map.containsKey(ch)) {
//                 if (map.get(ch) >= l) {
//                     l = map.get(ch) + 1;
//                     maxlen = Math.max(maxlen, r - l + 1);
//                     map.put(ch, r);
//                     r++;
//                 } else {
//                     maxlen = Math.max(maxlen, r - l + 1);
//                     map.put(ch, r);
//                     r++;
//                 }
//             } else {
//                 map.put(ch, r);
//                 maxlen = Math.max(maxlen, r - l + 1);
//                 r++;
//             }
//         }
//         return maxlen;
//     }
// }

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int maxlen = 0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            if (map.containsKey(ch)) {
                if (map.get(ch) >= l) {
                    l = map.get(ch) + 1;
                }
                maxlen = Math.max(maxlen, r - l + 1);
                map.put(ch, r);
                r++;
            } else {
                map.put(ch, r);
                maxlen = Math.max(maxlen, r - l + 1);
                r++;
            }
        }
        return maxlen;
    }
}