/**.
 * This is used to sort the leaderboard based on wins , losses and draws
 * @author Phaneendhar
 */
class Solution{
	/**
	 * sorts the leaderboard of different teams
	 * @param teams , array of different teams
	 * @return
	 */
	public Team[] sort(Team[] teams){
		// your code goes here
		for (int i = 0; i < (teams.length)-1; i++) {
			int min = i;
			for (int j = i + 1; j < teams.length; j++) {
				if (teams[j].compareTo(teams[min]) == 1) {
					min = j;
				}
			}
				Team temp = teams[min];
				teams[min] = teams[i];
				teams[i] = temp;
			
		}
		return teams;
	}
}
class Team implements Comparable<Team> {
	String teamName;
	int noOfWins;
	int noOfLosses;
	int noOfDraws;
	Team(String name, int wins, int losses, int draws){
		teamName = name;
		noOfDraws = draws;
		noOfWins = wins;
		noOfLosses = losses;
	}
	public String toString(){
		//return all the attributes as a string but appending with ", "
        return "";
	}
	/**.
	 * this is to sort teams by first no of wins, if they are equal then
	 * no of losses , if they are also equal then no of draws
	 */
	public int compareTo(Team team) {
		if (this.noOfWins > team.noOfWins)
		return 1;
		else if (this.noOfWins < team.noOfWins) {
			return -1;
		}
		else {
			if (this.noOfLosses > team.noOfLosses)
				return 1;
			else if (this.noOfLosses < team.noOfLosses) {
				return -1;
			}
			else {
				if (this.noOfDraws > team.noOfDraws)
					return 1;
				else if (this.noOfDraws < team.noOfDraws) {
					return -1;
				}
			}
		} return 0;
	}
}