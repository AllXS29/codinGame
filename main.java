import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways
		int[] exits = new  int[E]; // future array of existing exit gateway
		boolean[][] links = new boolean[N][N]; // future list of all node links
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
			//populate the array, if the link exist it is set to true
			links[N1][N2] = true;
			links[N2][N1] = true;
		}
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
            exits[i] = EI; // populate the array of all the gateway exit node
        }

        // game loop
        while (true) {
            int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn
            //test if the Skynet agent is near an exit gateway
			boolean severed = false; // boolean if a link has been severed in the loop
			for(Integer exit : exits){
                if(links[SI][exit]){
					//Sever the link and remove it from the list
					severed = true; // link is being severed
					//the link does not exist anymore
					links[SI][exit] = false;
					links[exit][SI] = false;
					System.out.println(SI + " " + exit);
					//quit the loop
                    break;
                }
            }
			//no link were severed cut one of the links near the Skynet agent 
			if(!severed){
				for(int i = 0; i < links.length; i++){
					if(links[SI][i]){
						//the link does not exist anymore
						links[SI][i] = false;
						links[i][SI] = false;
						System.out.println(i + " " + SI);
						//quit the loop
						break;
					}
				}
			}
        }
    }
}