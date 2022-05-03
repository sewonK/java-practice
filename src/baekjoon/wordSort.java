package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Word implements Comparable<Word>{
    private int length;
    private String content;
    Word(String content){
        this.content = content;
        this.length = content.length();
    }
    void print(){
        System.out.println(this.content);
    }
    @Override
    public int compareTo(Word word) {
        if(this.length > word.length){
            return 1;
        } else if(this.length == word.length){
            return this.content.compareTo(word.content);
        }
        return -1;
    }
}
public class wordSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> words = new HashSet<>();
        for(int i=0; i<N; i++){
            String word = br.readLine();
            words.add(word);
        }
        List<String> wordList = new ArrayList<>(words);
        List<Word> wordListForSort = new ArrayList<>();
        for (String s : wordList) {
            wordListForSort.add(new Word(s));
        }
        Collections.sort(wordListForSort);
        for (Word word : wordListForSort) {
            word.print();
        }
    }
}
