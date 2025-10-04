import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if(!wordList.contains(endWord)) return 0;
            Queue<String> queue = new LinkedList<>();
            HashMap<String, Boolean> map = new HashMap<>();
            for(int i=0;i<wordList.size();i++) {
                map.put(wordList.get(i), false);
            }
            queue.add(beginWord);
            int level = 1;
            while(!queue.isEmpty()) {
                int levelSize = queue.size();
                for (int i=0;i<levelSize;i++) {
                    String word = queue.poll();
                    if(word.equals(endWord)) return level;
                    wordMatch(word, queue, map);
                }
                level++;
            }
            return 0;
        }
        private void wordMatch(String word, Queue<String> queue, HashMap<String, Boolean> map) {
            for (int i=0;i<word.length();i++) {
                char[] w = word.toCharArray();
                for(int j=0;j<26;j++) {
                    char c = (char) ('a' + j);
                    w[i] = c;
                    String s = String.valueOf(w);
                    if(map.containsKey(s) && !map.get(s)) { 
                        queue.add(s);
                        map.put(s, true);
                    } 
                }
            }
        }
    
    }


