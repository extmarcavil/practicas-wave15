package com.company;

public class Main {

    public static void main(String[] args) {
        Inform document3 = new Inform(50, 3,"Name1", "Reviewer1");
        String[] skills = {"Skill1", "Skill2", "Skills3"};
        CV document2 = new CV("Alan", "Gimenez", 28, skills);
        PDF document1 = new PDF(50, "Title 1", "Name 1", "Genre 1");


        Printeable.print(document1);
        Printeable.print(document2);
        Printeable.print(document3);
    }
}
