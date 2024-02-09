public class TeamNode {
    private Team team;
    private TeamNode next;

    /**
     * default constructor
     * sets team and next to null
     */
    public TeamNode() {
        team = null;
        next = null;
    }

    /**
     * constructor
     * 
     * @param team a Team object reference
     *             sets team to team, and next to null
     */
    public TeamNode(Team team) {
        this.team = team;
        next = null;
    }

    /**
     * getTeam
     * 
     * @return team
     */
    public Team getTeam() {
        return team;
    }

    /**
     * getNext
     * 
     * @return next
     */
    public TeamNode getNext() {
        return next;
    }

    /**
     * setTeam
     * 
     * @param team new value foe team
     * @return a reference to this object
     */
    public TeamNode setTeam(Team team) {
        this.team = team;
        return this;
    }

    /**
     * setNext
     * 
     * @param next TeamNode reference for next
     * @return a reference to this object
     */
    public TeamNode setNext(TeamNode next) {
        this.next = next;
        return this;
    }
}