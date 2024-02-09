import java.util.ArrayList;

public class TeamLinkedList extends ShellLinkedList {
    // head and numberOfItems are inherited instance variables

    public TeamLinkedList() {
        super();
    }

    /**
     * insert method
     * 
     * @param t Team object to insert
     */
    public void insert(Team t) {
        // insert as head
        TeamNode tn = new TeamNode(t);
        tn.setNext(head);
        head = tn;
        numberOfItems++;
    }

    /**
     * delete method
     * 
     * @param searchNickname nickname of Team to delete
     * @return the Team deleted
     */
    public Team delete(String searchNickname)
            throws DataStructureException {
        TeamNode current = head;
        TeamNode previous = null;
        while (current != null
                && !(current.getTeam().getNickname().equals(searchNickname))) {
            previous = current;
            current = current.getNext();
        }

        if (current == null) // not found
            throw new DataStructureException(searchNickname
                    + " not found: cannot be deleted");
        else {
            if (current == head)
                head = head.getNext(); // delete head else
            previous.setNext(current.getNext());

            numberOfItems--;
            return current.getTeam();
        }
    }

    /**
     * orderTeams method
     * 
     * @return an ArrayList of the teams ordered in descending order by winning
     *         percentages
     */
    public ArrayList<Team> orderTeams() {
        ArrayList<Team> list = new ArrayList<Team>();
        // Fill list with the linked list of teams
        TeamNode current = head;

        while (current != null) {
            list.add(current.getTeam());
            current = current.getNext();
        }

        ArrayList<Team> orderedList = new ArrayList<Team>();
        // fill orderedList from list using a modified version of selection sort
        // sorting in descending order by winning percentages
        // double currentMaxWinPercentage = 0; //Not used for some reason
        Team temp, tempMaxWP;

        for (int i = 0; i < numberOfItems; i++) {
            // find best team
            tempMaxWP = (Team) list.get(0);
            for (int j = 1; j < list.size(); j++) {
                temp = (Team) list.get(j);
                if (temp.winningPercentage() > tempMaxWP.winningPercentage())
                    tempMaxWP = temp;
            }

            // add tempMaxWP to orderedList
            orderedList.add(tempMaxWP);
            // remove it from list
            list.remove(tempMaxWP);
        }

        return orderedList;
    }

    /**
     * fiveBestTeams method
     * 
     * @return an ArrayList representing the five best teams based on winning
     *         percentage
     */
    public ArrayList<Team> fiveBestTeams() {
        ArrayList<Team> result = new ArrayList<Team>();
        ArrayList<Team> ordered = orderTeams();
        Team temp;

        if (ordered.size() < 5) {
            for (int i = 0; i < ordered.size(); i++) {
                temp = (Team) ordered.get(i);
                result.add(new Team(temp.getNickname(), temp.getWins(), temp.getLosses()));
            }
        } else {
            for (int i = 0; i < 5; i++) {
                temp = (Team) ordered.get(i);
                result.add(new Team(temp.getNickname(), temp.getWins(), temp.getLosses()));
            }
        }
        return result;
    }

    /**
     * maxWins method
     * 
     * @return an int, the maximum number of wins by any team
     */
    public int maxWins() {
        int max = 0; // number of wins cannot be negative
        TeamNode current = head;
        while (current != null) {
            if (current.getTeam().getWins() > max)
                max = current.getTeam().getWins();
            current = current.getNext();
        }
        return max;
    }

    /**
     * mostWins method
     * 
     * @return an ArrayList of Strings storing all the nicknames of the teams with
     *         the most wins
     */
    public ArrayList<String> mostWins() {
        int maxWins = maxWins();
        ArrayList<String> temp = new ArrayList<String>();
        TeamNode current = head;

        while (current != null) {
            if (current.getTeam().getWins() == maxWins)
                temp.add(current.getTeam().getNickname());
            current = current.getNext();
        }

        return temp;

    }

    /**
     * peek method
     * 
     * @param searchNickname nickname of Team to search for
     * @return a copy of the Team found
     */
    public Team teek(String searchNickname) throws DataStructureException {
        TeamNode current = head;
        while (current != null
                && !(current.getTeam().getNickname().equals(searchNickname))) {
            current = current.getNext();
        }

        if (current == null) // not found
            throw new DataStructureException(searchNickname
                    + " not found: cannot be deleted");
        else {
            return new Team(searchNickname, current.getTeam().getWins(), current.getTeam().getLosses());
        }
    }
}
