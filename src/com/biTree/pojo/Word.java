package com.biTree.pojo;

/**
 * Created by user on 2018/4/16.
 */
public class Word {
    private String alphabetic;// 拼音
    private String Chinese;// 中文字

    public Word(String alphabetic,String Chinese){
        this.alphabetic = alphabetic;
        this.Chinese = Chinese;
    }

    public Word(){}

    public String getAlphabetic() {
        return alphabetic;
    }

    public void setAlphabetic(String alphabetic) {
        this.alphabetic = alphabetic;
    }

    public String getChinese() {
        return Chinese;
    }

    public void setChinese(String chinese) {
        Chinese = chinese;
    }

    @Override
    public String toString() {
        return "Word{" +
                "alphabetic='" + alphabetic + '\'' +
                ", Chinese='" + Chinese + '\'' +
                '}';
    }
}
