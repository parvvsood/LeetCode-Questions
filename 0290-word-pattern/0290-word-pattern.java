class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        if (pattern.length() != words.length)
            return false;

        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> used = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {

            char c = pattern.charAt(i);
            String word = words[i];

            if (map.containsKey(c) && !map.get(c).equals(word))
                return false;

            if (used.containsKey(word) && used.get(word) != c)
                return false;

            map.put(c, word);
            used.put(word, c);
        }

        return true;
    }
}