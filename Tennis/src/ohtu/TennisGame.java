package ohtu;

import java.util.HashMap;

public class TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    private HashMap<Integer, String> map;
    private HashMap<Integer, String> resultMap;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.initMap();
    }

    private void initMap() {
        this.map = new HashMap<Integer, String>();
        this.map.put(0, "Love");
        this.map.put(1, "Fifteen");
        this.map.put(2, "Thirty");
        this.map.put(3, "Forty");

        this.resultMap = new HashMap<Integer, String>();
        this.resultMap.put(1, "Advantage player1");
        this.resultMap.put(-1, "Advantage player2");
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            m_score1 += 1;
        } else {
            m_score2 += 1;
        }
    }

    private String equal() {
        String score = "";
        if (m_score1 >= 0 && m_score1 <= 3) {
            score = this.map.get(m_score1) + "-All";
        } else {
            score = "Deuce";
        }
        return score;
    }

    private String overFour() {
        String score = "";
        int minusResult = m_score1 - m_score2;
        score = this.resultMap.get(minusResult);
        if (minusResult >= 2) {
            score = "Win for player1";
        } else if (minusResult < -1) {
            score = "Win for player2";
        }
        return score;
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
        if (m_score1 == m_score2) {
            score = this.equal();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            score = this.overFour();
        } else {
            score += this.map.get(m_score1) + "-" + this.map.get(m_score2);
        }
        return score;
    }
}
