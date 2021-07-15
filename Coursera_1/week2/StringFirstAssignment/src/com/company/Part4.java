package com.Assignment1;

import edu.duke.*;
import java.io.*;


public class Part4 {
    public void findLinks(String url) {
        URLResource urlResource = new URLResource(url);

        for (String line : urlResource.lines()) {
            int youtubeIndex = line.toLowerCase().indexOf("youtube.com");

            if (youtubeIndex != -1) {
                int startIndex = line.lastIndexOf("\"", youtubeIndex);
                int lastIndex = line.indexOf("\"", youtubeIndex);

                System.out.println("Youtube link: " + line.substring(startIndex + 1, lastIndex));
            }
        }
    }

    public void test() {
        String url = "http://www.dukelearntoprogram.com/course2/data/manylinks.html";
        findLinks(url);
    }

}