public class Team {
    private String nickname;
    private int wins;
    private int losses;

    /**
     * constructor
     * 
     * @param nickname starting value for nickname
     * @param wins     starting balue for wins
     * @param losses   starting value for losses
     */
    public Team(String nickname, int wins, int losses) {
        setNickname(nickname);
        setWins(wins);
        setLosses(losses);
    }

    /**
     * getNickname
     * 
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * getWins
     * 
     * @return wins
     */
    public int getWins() {
        return wins;
    }

    /**
     * getLosses
     * 
     * @return losses
     */
    public int getLosses() {
        return losses;
    }

    /**
     * setNickname
     * 
     * @param nickname new value for nickname
     * @return a reference to this object
     */
    public Team setNickname(String nickname) {
        this.nickname = nickname;

        return this;
    }

    /**
     * setWins
     * 
     * @param wins new value for wins
     *             wins must be >= 0. otherwise value is unchanged
     * @return a reference to this object
     */
    public Team setWins(int wins) {
        if (wins >= 0)
            this.wins = wins;
        return this;
    }

    /**
     * setLosses
     * 
     * @param losses new value for losses
     *               losses must be >= 0. otherwise value is unchanged
     * @return a reference to this object
     */
    public Team setLosses(int losses) {
        if (losses >= 0)
            this.losses = losses;
        return this;
    }

    /**
     * equals
     * 
     * @param o another Team object
     * @return true if the instance variables in this object are equal to the
     *         instance variables in t; false otherwise
     */
    public boolean equals(Object o) {
        if (!(o instanceof Team))
            return false;
        else {
            Team t = (Team) o;
            return (nickname.equals(t.nickname)
                    && wins == t.wins && losses == t.losses);
        }
    }

    /**
     * toString
     * 
     * @return String representation of nickname, wins, and losses
     */
    public String toString() {
        return ("nickname: " + nickname + "\t# of wins: "
                + wins + "\t# of losses: " + losses);
    }

    /**
     * winningPercentage
     * 
     * @return wins / total games; 0 if no games have been played
     */
    public double winningPercentage() {
        if ((wins + losses) != 0)
            return ((double) wins / (wins + losses));
        else
            return 0.0;
    }
}
