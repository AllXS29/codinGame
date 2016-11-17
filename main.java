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
		List <Integer> egList = new ArrayList(); // future list of existing exit gateway
		List <String> linkList = new ArrayList(); // future list of all node links
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
			 linkList.add(N1 + " " + N2);// populate the link list
        }
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
            egList.add(EI); // populate the list of all the gateway exit node
        }

        // game loop
        while (true) {
            int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn
            //test if the Skynet agent is near an exit gateway
			boolean severed = false; // boolean if a link has been severed in the loop
			for(Integer exit : exitList){
                if(linkList.contains(SI + " " + exit)){
					//Sever the link and remove it from the list
					severed = true; // link being severed
                    System.out.println(SI + " " + exit);
                    linkList.remove(SI + " " + exit);
                    break;
                }else if (linkList.contains(exit + " " + SI)){
					//Sever the link and remove it from the list
                    severed = true; // link being severed
					System.out.println(exit + " " + SI);
                    linkList.remove(exit + " " + SI);
                    break;
                }
            }
			//no link were severed cut the first link from the list
			//TODO : create algorithm choosing which link to sever for better effeciency
			if(!severed){
				System.out.println(linkList.get(0));
				linkList.remove(0);
			}
        }
    }
}