static int[] climbingLeaderboard(int[] scores, int[] alice) {

        Map<Integer, Integer> rankMap = new HashMap();
        int rank = 1;
        for (int i = 0 ; i < scores.length; i++) {
            rankMap.put(scores[i], rank);
            while (i < scores.length - 1 && scores[i] == scores[i+1]) {
                i++;
            }
            rank++;
        }
        int[] result = new int[alice.length];
        for (int i = 0 ; i < alice.length; i++) {
            int resultRank = getRank(alice[i], rankMap, scores);
            result[i] = resultRank == -1 ? rank : resultRank;
        }
        return result;
    }
    
    static int getRank(int score, Map<Integer, Integer> rankMap, int[] scores) {
        if (scores.length > 0 && score > scores[0]) {
            return 1;
        }
        for (int i = 0 ; i < scores.length; i++) {
            if (score - scores[i] >= 0) {
                return rankMap.get(scores[i]);
            }
        }
        return -1;
    }
