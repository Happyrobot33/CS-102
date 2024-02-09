import java.util.ArrayList;

public class TeamLinkedListClient {
    public static void main(String[] args) {
        Team t1 = new Team("Lions", 10, 6);
        Team t2 = new Team("Ravens", 11, 5);
        Team t3 = new Team("Saints", 8, 8);
        Team t4 = new Team("Giants", 7, 9);
        Team t5 = new Team("Chiefs", 12, 4);
        Team t6 = new Team("Falcons", 5, 11);
        Team t7 = new Team("Raiders", 6, 10);
        Team t8 = new Team("Patriots", 7, 9);
        Team t9 = new Team("Cowboys", 4, 12);
        Team t10 = new Team("Browns", 3, 13);

        // construct TeamLinkedList
        TeamLinkedList teams = new TeamLinkedList();
        teams.insert(t1); // insert first team
        teams.insert(t2); // insert second team 
        teams.insert(t3); // insert third team 
        teams.insert(t4); // insert fourth team 
        teams.insert(t5); // insert fifth team
        teams.insert(t6); // insert sixth team 
        teams.insert(t7); // insert seventh team 
        teams.insert(t8); // insert eighth team 
        teams.insert(t9); //insert ninth team 
        teams.insert(t10); // insert tenth team

        System.out.println("Number of items in the list: "
                + teams.getNumberOfItems() + "\n" + teams.toString());

        ArrayList<String> winningest = teams.mostWins();
        ArrayList<Team> fiveBest = teams.fiveBestTeams();

        if (winningest.size() >= 2)
            System.out.print("The winningest teams are: ");
        else if (winningest.size() == 1)
            System.out.print("The winningest team is: ");
        else
            System.out.println("There are no teams");
        for (String s : winningest)
            System.out.print(s + "\t");

        if (fiveBest.size() == 5)
            System.out.println("\n\nThe five best teams are:");
        else if (fiveBest.size() > 0)
            System.out.println("\n\nThe " + fiveBest.size() + " best teams are:");

        for (Team t : fiveBest)
            System.out.print(t + "\n");
    }
}
