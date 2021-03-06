package leetcode;

/*
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.
 */
public class JudgeRouteCircle_657 {
	
	public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char ch : moves.toCharArray()) {
            if (ch == 'U')
                y++;
            if (ch == 'D')
                y--;
            if (ch == 'L')
                x--;
            if (ch == 'R')
                x++;
        }
        return x==0 && y==0;
    }

}
