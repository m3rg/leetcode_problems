package com.m3rg.leetcode_problems.easy;

public class _953_VerifyingAlienDictionary {
    
    public static _953_VerifyingAlienDictionary obj;

    public static void main(String[] args) {
        String[] words = new String[]{"hello", "leetcode"};
        //String[] words = new String[]{"app", "apple"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        _953_VerifyingAlienDictionary obj = new _953_VerifyingAlienDictionary();
        boolean res = obj.isAlienSorted(words, order);
        System.out.println(res);
    }
    
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for(int i = 0; i<order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }
        for(int i = 0; i<words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            int minWordCount = Math.min(word1.length(), word2.length());
            boolean brk = false;
            for(int k = 0; k<minWordCount; k++) {
                char c1 = word1.charAt(k);
                char c2 = word2.charAt(k);
                if(c1 != c2) {
                    if(index[c1 - 'a'] > index[c2 - 'a']) {
                        return false;
                    }
                    brk = true;
                    break;
                }
            }
            if(!brk && word1.length() > word2.length()) {
                return false;
            }
        }
        return true;
    }
    
    /*@BeforeAll
    public static void initAll() throws Exception {
        obj = new _953_VerifyingAlienDictionary();
    }
    
    @Test
    @DisplayName("Test sub strings")
    public void testSubStrings() {
        String[] words = new String[] {"app", "apple"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        boolean res = obj.isAlienSorted(words, order);
        assertEquals(res, true);
    }*/

}
