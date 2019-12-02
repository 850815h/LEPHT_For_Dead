package com.company;

import java.util.Comparator;

public class ClubComparator implements Comparator<ClubStats> {
        @Override
        public int compare(ClubStats x, ClubStats y) {
            if (x.getPoints() > y.getPoints())
                return -1;
            else if (x.getPoints() < y.getPoints())
                return 1;
            else {
                int goalDifX = x.getScoredGoals() - x.getReceivedGoals();
                int goalDifY = y.getScoredGoals() - y.getReceivedGoals();
                if (goalDifX > goalDifY)
                    return -1;
                else if (goalDifX < goalDifY)
                    return 1;
                else return 0;
            }
        }
}
